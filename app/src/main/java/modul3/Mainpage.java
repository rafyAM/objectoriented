package modul3;

import modul3.Listpasswordpage;
import modul3.Selectinput;
import modul3.Hline;

public class Mainpage {
    public String title;
    public int width;
    private final Hline hline;
    private final Space space;
    private final Label label;

    public Mainpage(String title, int width) {
        this.width = width;
        this.title = title;
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

    private void drawContent() {
        String[] pages = { "Input Password", "Tampil Password", "Keluar Aplikasi" };
        Selectinput pageSelect = new Selectinput("Pilih halaman berikut:",
                this.width, pages);
        int select;
        this.label.text = "Selamat datang di aplikasi Password Vault";
        this.label.draw();
        this.label.text = "Simpan password anda dengan aman di sini";
        this.label.draw();
        this.space.draw();
        pageSelect.draw();
        select = pageSelect.getValue() - 1;

        if (select >= 0 && select < pages.length) {
            switch (select) {
                case 0:
                    drawFooter();
                    new Inputpage("Inputan Password", this.width).draw();
                    break;
                case 1:
                    drawFooter();
                    new Listpasswordpage("List Password Tersimpan", this.width).draw();
                    break;
                case 2:
                    new Label(this.width, "Terima kasih telah menggunakan aplikasi").draw();
                    break;
                default:
                    new Mainpage(this.title, this.width).draw();
            }
        } else {
            new Label(this.width, "Pilihan tidak valid. Silakan pilih nomor yang tersedia.").draw();
        }
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}