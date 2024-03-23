package Saski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Sashki extends JFrame{
    Game game;
    private JPanel panel;
    private boolean whoStart;
    private final int cols = 8;
    private final int rows = 8;
    private final int imageSize = 50;
    private int i = 1;
    private int a = 1;
    public Sashki() {
        game = new Game(cols, rows);
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
                    g.drawImage((Image) game.getBox(coord).image,
                            coord.x * imageSize, coord.y * imageSize,
                            this);
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / imageSize;
                int y = e.getY() / imageSize;
                Coord coord = new Coord(x, y);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (game.pressInBlack(coord)) {
                            game.setAny(coord, Box.Fon);
                            game.setClosedBlack(coord);
                    }
                    else if (game.isClosedBalck(coord)) {
                        Coord coord1;
                        game.pressLeftButtonBlack(coord);
                        for (int i = 0; i < 8; i++) {
                            for (int a = 0; a < 8; a++) {
                                coord1 = new Coord(i, a);
                                if (game.getAny(coord1) == Box.Closed) {
                                    game.setAny(coord1, Box.Fon);
                                }
                            }
                        }
                    }
                    if (game.pressInWhite(coord)) {
                        if (!game.isAnyWhiteHere(coord, Box.FonWhiteOne)) {
                            coord.x -= 1;
                            coord.y += 1;
                            game.setAny(coord, Box.Fon);
                            if (game.isAnyWhiteHere(coord, Box.FonBlackOne)) {
                                game.setClosedWhite(coord);
                            }
                        }
                        if (game.isAnyWhiteHere(coord, Box.FonBlackOne)) {
                            Coord coord1;
                            coord.x++;
                            coord.y--;
                            if (game.getAny(coord) != Box.FonBlackOne ||
                                    game.getAny(coord) != Box.FonWhiteOne) {
                                game.setAny(coord, Box.Closedd);
                                coord.x -= 2;
                                if (game.getAny(coord) != Box.FonBlackOne ||
                                        game.getAny(coord) != Box.FonWhiteOne) {
                                    game.setAny(coord, Box.Closedd);
                                }
                            }
                        }
                    }
                    else if (game.isClosedWhite(coord)) {
                        Coord coord1;
                        game.pressLeftButtonWhite(coord);
                        for (int i = 0; i < 8; i++) {
                            for (int a = 0; a < 8; a++) {
                                coord1 = new Coord(i, a);
                                if (game.getAny(coord1) == Box.Closedd) {
                                    game.setAny(coord1, Box.Fon);
                                }
                            }
                        }
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    game.start();
                }
                i++;
                panel.repaint();
            }
        });
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * imageSize,
                Ranges.getSize().y * imageSize));
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
        }
        else {
            System.out.println("Error getImage");
        }
        return icon.getImage();
    }
    public static void main(String[] args) {
        new Sashki();
    }
}


