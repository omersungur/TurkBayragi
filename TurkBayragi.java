package GrafikOdevler;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

// author: OMER SUNGUR
// Bayrak Olculeri: https://www.hizliresim.com/8bpvyng

class SurfaceP extends JPanel {

    private double height;
    private double width;

    public void doDrawing(Graphics g) {
        height = getHeight();
        width = getWidth();
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        setBackground(new Color(227, 10, 23));

        g2d.setPaint(new Color(255, 255, 255));
        g2d.fillRect(0, 0, (int) (height / 30), (int) height);
        sekilAy(g2d);
        sekilYildiz(g2d);
    }

    private void sekilYildiz(Graphics2D g2d) {

        double merkezX = height / 2 + 0.05 * width + height * 0.35;
        double merkezY = height / 2;
        double yaricap = height * 0.25 / 2;

        double nokta[][] = {{merkezX - yaricap * 2 / 6, merkezY - yaricap * 5.5 / 6},
                {merkezX - yaricap * 2 / 6, merkezY - yaricap * 1.4 / 6},
                {merkezX - yaricap, merkezY}, {merkezX - yaricap * 2 / 6, merkezY + yaricap * 1.4 / 6},
                {merkezX - yaricap * 2 / 6, merkezY + yaricap * 5.5 / 6},

                {merkezX + yaricap * 0.5 / 6, merkezY + yaricap * 2.2 / 6},
                {merkezX + yaricap * 4.8 / 6, merkezY + yaricap * 3.5 / 6},
                {merkezX + yaricap * 2.1 / 6, merkezY},
                {merkezX + yaricap * 4.8 / 6, merkezY - yaricap * 3.5 / 6},
                {merkezX + yaricap * 0.5 / 6, merkezY - yaricap * 2.2 / 6},
                {merkezX - yaricap * 2 / 6, merkezY - yaricap * 5.5 / 6}};

        GeneralPath yildiz = new GeneralPath();

        yildiz.moveTo(nokta[0][0], nokta[0][1]);
        g2d.setPaint(Color.WHITE);

        for (int k = 1; k < nokta.length; k++) {
            yildiz.lineTo(nokta[k][0], nokta[k][1]);
        }

        yildiz.closePath();
        g2d.fill(yildiz);
        g2d.dispose();
    }

    private void sekilAy(Graphics2D g2d) {

        double ayMerkezX = (height / 2 + width * 0.05);
        double ayMerkezY = height / 2;
        double kucukMerkezX = (int) (ayMerkezX + ((1 / 16) * height) + 0.06 * height);

        g2d.fillOval((int) (ayMerkezX - 0.25 * height), (int) (ayMerkezY - 0.25 * height), (int) (0.5 * height), (int) (0.5 * height));
        g2d.setPaint(new Color(227, 10, 23));
        g2d.fillOval((int) (kucukMerkezX - 0.2 * height), (int) (ayMerkezY - 0.2 * height), (int) (0.4 * height), (int) (height * 0.4));


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

class TurkBayragi extends JFrame {

    TurkBayragi() {
        initUI();
    }

    private void initUI() {

        add(new SurfaceP());

        setTitle("Turk Bayragi");
        int height = 500;
        int width = (int) (height * 1.5);
        setSize(width, height);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                TurkBayragi tb = new TurkBayragi();
                tb.setVisible(true);
            }
        });
    }
}

