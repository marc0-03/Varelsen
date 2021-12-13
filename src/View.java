import java.awt.*;
import java.awt.image.BufferStrategy;

public class View extends Canvas {
    private BufferStrategy bs;
    private int HEIGHT;
    private int WIDTH;
    private int CellWidth;
    private int CellHeight;

    public View(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void setCellSize(Varelsen[][] Cells) {
        CellWidth = (getWidth() / Cells.length);
        CellHeight = (getHeight() / Cells[0].length);
    }

    public void draw(Varelsen[][] Cells) {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();


        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);


        g.setColor(Color.white);
        //g.setColor(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
        for (int w = 0; w<Cells.length; w++) {
            for (int h = 0; h<Cells[0].length; h++) {
                if (Cells[w][h].isAlive()) {
                    g.fillRect(w * CellWidth, h * CellHeight, CellWidth, CellHeight);
                }
            }
        }

        g.dispose();
        bs.show();
    }

    public int getHeight() {
        return HEIGHT;
    }
    public int getWidth() {
        return WIDTH;
    }
}
