package Saski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Sashki extends JFrame{
    Game game;
    private JPanel panel;
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
            private void ifLeftButtonSelected(MouseEvent mouseEvent) {
                int x = mouseEvent.getX() / imageSize;
                int y = mouseEvent.getY() / imageSize;
                Coord coord = new Coord(x, y);
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    if (game.getAny(coord) == Box.BlackDamka) {

                    }
                    else if (game.pressInBlack(coord)) {
                        if (coord.y == 7) {
                            game.setAny(coord, Box.BlackDamka);
                        }
                        else {
                            game.setClosedBlack(coord);
                        }
                    }
                    else if (game.isClosedBlack(coord)) {
                        Coord coord1;
                        if (game.getAny(game.whiteRight(coord)) == Box.FonWhiteOnee) {
                            game.setAny(game.whiteRight(coord), Box.Fon);
                        }
                        else if (game.getAny(game.whiteLeft(coord)) == Box.FonWhiteOnee) {
                            game.setAny(game.whiteLeft(coord), Box.Fon);
                        }
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
                        if (coord.y == 0) {
                            game.setAny(coord, Box.WhiteDamka);
                            int a = coord.y + 1;
                            Coord coord1;
                            if (coord.x != 0) {
                                for (int i = coord.x - 1;i >= 0; i--) {
                                    if (a < 8) {
                                      a++;
                                    }
                                    coord1 = new Coord(i, a);
                                    game.setAny(coord1, Box.Closedd);
                                }
                            }
                            a = coord.y - 1;
                            if (coord.x != 7) {
                                for (int i = coord.x - 1;i >= 0; i--) {
                                    if (a >= 0) {
                                        a--;
                                    }
                                    coord1 = new Coord(i, a);
                                    game.setAny(coord1, Box.Closedd);
                                }
                            }
                        }

                        else {
                            game.setClosedWhite(coord);
                        }
                        }
                    else if (game.isClosedWhite(coord)) {
                        Coord coord1;
                        if (game.getAny(game.blackRight(coord)) == Box.FonBlackOnee) {
                            game.setAny(game.blackRight(coord), Box.Fon);
                        }
                        else if (game.getAny(game.blackLeft(coord)) == Box.FonBlackOnee) {
                            game.setAny(game.blackLeft(coord), Box.Fon);
                        }
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


