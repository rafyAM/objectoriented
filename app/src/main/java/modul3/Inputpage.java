package modul3;

import modul3.Selectinput;
import modul3.Hline;
import modul3.models.DataPassword;
import modul3.models.PasswordStore;

public class Inputpage {
    public String title;
    public int width;
    private final Hline hline;
    private final Space space;
    private final Label label;

    public Inputpage(String title, int width) {
        this.title = title;
        this.width = width;
        this.hline = new Hline(width);
        this.space = new Space(width);
        this.label = new Label(width, title.toUpperCase());
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
        new Mainpage("Main Page", width).draw();
    }
}