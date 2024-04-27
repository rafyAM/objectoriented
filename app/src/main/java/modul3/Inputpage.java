package modul3;

import java.util.Scanner;

import modul3.Input;
import modul3.Selectinput;
import modul3.Hline;
import modul3.Label;
import modul3.Space;
import modul3.models.PasswordStore;
import modul3.models.DataPassword;

public class Inputpage extends Basepage {
    Input inputName = new Input("Judul Password");
    Input inputUsername = new Input("Username");
    Input inputPass = new Input("Password");
    Selectinput inpCategory;
    PasswordStore pass;

    public Inputpage(int width) {
        super("Inputan Password", width);
        this.inpCategory = new Selectinput("Kategori", this.width, PasswordStore.CATEGORIES);
        this.components.add(this.inputName);
        this.components.add(this.inputUsername);
        this.components.add(this.inputPass);
        this.components.add(this.inpCategory);
        this.components.add(new Label(this.width, "----- -----"));
        this.components.add(new Label(this.width, "Input password berhasil dibuat"));
    }

    public void draw() {
        this.drawHeader();
        this.space.draw();
        this.drawContent();
        this.drawFooter();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    public void drawContent() {
        // Scanner scanner = new Scanner(System.in);

        Input input = new Input("Nama Password");
        Input input2 = new Input("Username");
        Input input3 = new Input("Password");
        input.readInput();
        String name = input.getValue();
        input2.readInput();
        String user = input2.getValue();
        input3.readInput();
        String pass = input3.getValue();

        String[] choices = { "Belum terkategori", "Aplikasi Web", "Aplikasi Mobile", "Akun Lainnya" };
        Selectinput selectInput = new Selectinput("Kategori Password:", 70, choices);
        selectInput.draw();
        int category = selectInput.getValue();

        DataPassword.passData.add(new PasswordStore(name, user, pass, category));
        DataPassword.saveCSVData();
    }

    public void drawFooter() {
        new Hline(50).draw();
        new Space(50).draw();
        new Label(50, "Input Password berhasil dibuat").draw();
        new Space(50).draw();
        new Hline(50).draw();
        new Mainpage(width).draw();
    }
}