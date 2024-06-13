package modul3.pages;

import java.util.ArrayList;

import modul3.components.output.Drawable;
import modul3.components.output.Hline;
import modul3.components.output.Label;
import modul3.components.output.Space;

public abstract class Basepage {
    public String title;
    public int width;
    protected final Hline hline;
    protected final Space space;
    protected final Label label;
    protected final ArrayList<Drawable> components = new ArrayList<>();

    public Basepage(String title, int width) {
        this.width = width;
        this.title = title;
        this.hline = new Hline(width);
        this.space = new Space(width);
        this.label = new Label(width, title);
    }

    public void draw() {
        this.drawHeader();
        this.space.draw();
        this.drawContent();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    protected abstract void drawContent();

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}