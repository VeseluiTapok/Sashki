package Saski;

public class Sachka {
    Game game;
    public void start() {
        game = Sashki.game;
    }
    public void run(Coord coord) {
        if (game.getAny(coord) == Box.FonBlackOne) {
            Sashki.DamkaChiNe = false;
            if (coord.y == 7) {
                game.setAny(coord, Box.BlackDamka);
            }
            else {
                setClosedBlack(coord);
            }
        }
        else if (isClosedBlack(coord)) {
            Coord coord1;
            if (game.getAny(whiteRight(coord)) == Box.FonWhiteOnee) {
                game.setAny(whiteRight(coord), Box.Fon);
            } else if (game.getAny(whiteLeft(coord)) == Box.FonWhiteOnee) {
                game.setAny(whiteLeft(coord), Box.Fon);
            }
            pressLeftButtonBlack(coord);
            for (int i = 0; i < 8; i++) {
                for (int a = 0; a < 8; a++) {
                    coord1 = new Coord(i, a);
                    if (game.getAny(coord1) == Box.Closed) {
                        game.setAny(coord1, Box.Fon);
                    }
                }
            }
        } else if (game.getAny(coord) == Box.FonWhiteOne) {
            if (coord.y == 0) {
                game.setAny(coord, Box.WhiteDamka);
            } else {
                setClosedWhite(coord);
            }
        }
        else if (isClosedWhite(coord)) {
            Coord coord1;
            if (game.getAny(blackRight(coord)) == Box.FonBlackOnee) {
                game.setAny(blackRight(coord), Box.Fon);
            } else if (game.getAny(blackLeft(coord)) == Box.FonBlackOnee) {
                game.setAny(blackLeft(coord), Box.Fon);
            }
            pressLeftButtonWhite(coord);
            for (int i = 0; i < 8; i++) {
                for (int a = 0; a < 8; a++) {
                    coord1 = new Coord(i, a);
                    if (game.getAny(coord1) == Box.Closedd) {
                        game.setAny(coord1, Box.Fon);
                    }
                }
            }
        }
        else {
            System.out.println("sdasfsddfsdfsdffs");
        }
    }


    public boolean pressInBlack(Coord coord) {
       if (game.getAny(coord) == Box.FonBlackOne) {
           return true;
       }
       else {
           return false;
       }
    }

    public boolean pressInWhite(Coord coord) {
        return game.getAny(coord) == Box.FonWhiteOne;
    }

    public Coord blackRight(final Coord oldCoord) {
        return new Coord(oldCoord.x - 1, oldCoord.y + 1);
    }

    public Coord blackLeft(final Coord oldCoord) {
        return new Coord(oldCoord.x + 1, oldCoord.y + 1);
    }

    public Coord whiteRight(final Coord oldCoord) {
        return new Coord(oldCoord.x + 1, oldCoord.y - 1);
    }

    public Coord whiteLeft(final Coord oldCoord) {
        return new Coord(oldCoord.x - 1, oldCoord.y - 1);
    }

    public void setClosedBlack(Coord coord) {
        if (coord.x != 0) {
            if (blackRight(coord).x != 0) {
                if (pressInWhite(blackRight(coord))) {
                    if (!pressInBlack(blackRight(blackRight(coord)))) {
                        if (!pressInWhite(blackRight(blackRight(coord)))) {
                            game.setAny(blackRight(coord), Box.FonWhiteOnee);
                            game.setAny(blackRight(blackRight(coord)), Box.Closed);
                            game.setAny(coord, Box.Fon);
                        }
                    }
                }
            }
        }
        if (coord.x != 7) {
            if (blackLeft(coord).x != 7) {
                if (pressInWhite(blackLeft(coord))) {
                    if (!pressInBlack(blackLeft(blackLeft(coord)))) {
                        if (!pressInWhite(blackLeft(blackLeft(coord)))) {
                            game.setAny(blackLeft(coord), Box.FonWhiteOnee);
                            game.setAny(blackLeft(blackLeft(coord)), Box.Closed);
                            game.setAny(coord, Box.Fon);
                        }
                    }
                }
            }
        }
        if (coord.x != 7) {
            if (!pressInBlack(blackLeft(coord))) {
                if (!pressInWhite(blackLeft(coord))) {
                    if (game.getAny(blackLeft(coord)) != Box.FonWhiteOnee) {
                        if (game.getAny(blackRight(blackRight(coord))) != Box.Closed) {
                            game.setAny(coord, Box.Fon);
                            game.setAny(blackLeft(coord), Box.Closed);
                        }
                    }
                }
            }
        }
        if (coord.x != 0) {
            if (!pressInBlack(blackRight(coord))) {
                if (!pressInWhite(blackRight(coord))) {
                    if (game.getAny(blackRight(coord)) != Box.FonWhiteOnee) {
                        if (game.getAny(blackLeft(blackLeft(coord))) != Box.Closed) {
                            game.setAny(coord, Box.Fon);
                            game.setAny(blackRight(coord), Box.Closed);
                        }
                    }
                }
            }
        }
    }

    public void setClosedWhite(Coord coord) {
        if (coord.x != 7) {
            if (whiteRight(coord).x != 7) {
                if (pressInBlack(whiteRight(coord))) {
                    if (!pressInBlack(whiteRight(whiteRight(coord)))) {
                        if (!pressInWhite(whiteRight(whiteRight(coord)))) {
                            game.setAny(whiteRight(coord), Box.FonBlackOnee);
                            game.setAny(whiteRight(whiteRight(coord)), Box.Closedd);
                            game.setAny(coord, Box.Fon);
                        }
                    }
                }
            }
        }
        if (coord.x != 0) {
            if (whiteLeft(coord).x != 0) {
                if (pressInBlack(whiteLeft(coord))) {
                    if (!pressInBlack(whiteLeft(whiteLeft(coord)))) {
                        if (!pressInWhite(whiteLeft(whiteLeft(coord)))) {
                            game.setAny(whiteLeft(coord), Box.FonBlackOnee);
                            game.setAny(whiteLeft(whiteLeft(coord)), Box.Closedd);
                            game.setAny(coord, Box.Fon);
                        }
                    }
                }
            }
        }
        if (coord.x != 0) {
            if (!pressInWhite(whiteLeft(coord))) {
                if (!pressInBlack(whiteLeft(coord))) {
                    if (game.getAny(whiteLeft(coord)) != Box.FonBlackOnee) {
                        if (game.getAny(whiteRight(whiteRight(coord))) != Box.Closedd) {
                            game.setAny(whiteLeft(coord), Box.Closedd);
                            game.setAny(coord, Box.Fon);
                        }
                    }
                }
            }
        }
        if (coord.x != 7) {
            if (!pressInWhite(whiteRight(coord))) {
                if (!pressInBlack(whiteRight(coord))) {
                    if (game.getAny(whiteRight(coord)) != Box.FonBlackOnee) {
                        if (game.getAny(whiteLeft(whiteLeft(coord))) != Box.Closedd) {
                            game.setAny(whiteRight(coord), Box.Closedd);
                            game.setAny(coord, Box.Fon);
                        }
                    }
                }
            }
        }
    }

    public boolean isClosedBlack(Coord coord) {
        return game.getAny(coord) == Box.Closed;
    }

    public boolean isClosedWhite(Coord coord) {
        return game.getAny(coord) == Box.Closedd;
    }

    public void pressLeftButtonBlack(Coord coord) {
        if (Sashki.DamkaChiNe) {
            game.setAny(coord, Box.BlackDamka);
        } else {
            game.setAny(coord, Box.FonBlackOne);
        }
    }

    public void pressLeftButtonWhite(Coord coord) {
        game.setAny(coord, Box.FonWhiteOne);
    }
}


