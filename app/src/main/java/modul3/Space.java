package modul3;

public class Space implements Drawable {
    private int width;

    public Space(int width) {
        this.width = width;
    }

    public void draw() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < width; i++) {
            line.append(" ");
        }

        System.out.println("|" + line + "|");
    }
}