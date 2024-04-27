package modul3;

import modul3.Listpasswordpage;
import modul3.Selectinput;
import modul3.Drawable;
import modul3.Hline;
import modul3.Label;
import modul3.Space;
import modul3.models.DataPassword;

public class Mainpage extends Basepage {
    Selectinput pageSelect;

    public Mainpage(int width) {
        super("Aplikasi Penyimpanan Password", width);
        this.components.add(new Label(this.width, "Selamat datang di aplikasi Password Vault"));
        this.components.add(new Label(this.width, "Simpan password anda dengan aman di sini"));
        this.components.add(new Space(this.width));
        String[] pages = { "Input Password", "Tampil Password", "Keluar Aplikasi" };
        this.pageSelect = new Selectinput("Pilih halaman berikut:",
                this.width, pages);
        this.components.add(pageSelect);
    }

    @Override
    protected void drawContent() {
        int select;
        for (Drawable widget : this.components) {
            widget.draw();
        }
        select = this.pageSelect.getValue() - 1;
        switch (select) {
            case 0 -> {
                drawFooter();
                new Inputpage(this.width).draw();
            }
            case 1 -> {
                drawFooter();
                new Listpasswordpage(this.width).draw();
            }
            case 2 -> {
                new Label(this.width, "Menyimpan data ... ...").draw();
                DataPassword.saveCSVData();
                new Label(this.width, "Terima kasih telah menggunakan aplikasi").draw();
                drawFooter();
                System.exit(0);
            }
            default -> {
                new Mainpage(this.width).draw();
            }
        }
    }
}