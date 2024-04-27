package modul3;

import java.util.ArrayList;

import modul3.Hline;
import modul3.Label;
import modul3.Space;
import modul3.models.DataPassword;
import modul3.models.PasswordStore;
import modul3.Basepage;
import modul3.Mainpage;

public class Listpasswordpage extends Basepage {
    public String title;
    public int width;

    public Listpasswordpage(int width) {
        super("List Password", width);
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
        ArrayList<PasswordStore> passData = DataPassword.passData;

        int totalPass = passData.size();

        new Space(this.width).draw();
        new Label(this.width, "Terdapat " + totalPass + " Data Tersimpan").draw();
        new Space(this.width).draw();

        if (totalPass > 0) {
            System.out.println("----- ----- -----");
            for (PasswordStore data : passData) {
                // System.out.printf("%s");
                Label label1 = new Label(data.name.length() + 2, data.name);
                Label label2 = new Label(data.username.length() + 2, data.username);
                Label label3 = new Label(data.getPassword().length(), data.getPassword());

                StringBuilder line = new StringBuilder("| ");
                label1.drawToBuffer(line);
                line.append(" | ");
                label2.drawToBuffer(line);
                line.append(" | ");
                label3.drawToBuffer(line);
                line.append(" |");

                System.out.println(line.toString());
            }
        }
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
        new Mainpage(width).draw();
    }
}