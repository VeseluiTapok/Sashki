package Saski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Sashki extends JFrame {
    Damka damka;
    Sachka sachka;
    static Game game;
    private JPanel panel;
    private final int cols = 8;
    private final int rows = 8;
    private final int imageSize = 50;
    public static boolean DamkaChiNe = false;
    private int i = 1;
    private int a = 1;

    public Sashki() {
        game = new Game(cols, rows);
        sachka = new Sachka();
        damka = new Damka();
        sachka.start();
        damka.start();
        game.start();
        setImages();
        Panel();
        Frame();
    }

    public void Frame() {
        setTitle("Шашкі");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pack();
        setLocationRelativeTo(null);
    }

    public void Panel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage((Image) game.getBox(coord).image, coord.x * imageSize, coord.y * imageSize, this);
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            private void ifLeftButtonSelected(MouseEvent mouseEvent) {
                int cols = mouseEvent.getX() / imageSize;
                int rows = mouseEvent.getY() / imageSize;
                Coord clickCoord = new Coord(cols, rows);
                Coord DefaultClickCoord = new Coord(cols, rows);
                if (game.getAny(clickCoord) == Box.BlackDamka) {
                    damka.run(clickCoord, Color.Black, DefaultClickCoord);
                }
                else if (game.getAny(clickCoord) == Box.WhiteDamka) {
                    damka.run(clickCoord, Color.White, DefaultClickCoord);
                }
                sachka.run(clickCoord);
            }

            public void ifMouseRollSelected() {
                game.start();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    ifLeftButtonSelected(mouseEvent);
                }
                if (mouseEvent.getButton() == MouseEvent.BUTTON2) {
                    ifMouseRollSelected();
                }
                i++;
                panel.repaint();
            }
        });
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * imageSize, Ranges.getSize().y * imageSize));
        add(panel);
    }

    public void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name());
        }
    }

    public Image getImage(String name) {
        String fileName = "/img/" + name.toLowerCase() + ".png";
        ImageIcon icon = null;
        URL url = getClass().getResource(fileName);

        if (url != null) {
            icon = new ImageIcon(url);
        } else {
            System.out.println("Error getImage");
        }
        return icon.getImage();
    }

    public static void main(String[] args) {
        new Sashki();
    }
}


