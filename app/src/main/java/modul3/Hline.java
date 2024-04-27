package modul3;

public class Hline implements Drawable {
    private int width;

    public Hline(int width) {
        this.width = width;
    }

    public void draw() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < width; i++) {
            line.append("=");
        }

        System.out.println("+" + line + "+");
    }
}