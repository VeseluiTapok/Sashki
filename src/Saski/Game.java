package Saski;

import java.util.concurrent.Callable;

public class Game {
    private Mapa mapa;
    public Game(int cols, int rows) {
        Ranges.setSize(new Coord(cols, rows));
        mapa = new Mapa();
    }


    public void start() {
        mapa.start();
    }
    public boolean pressInBlack(Coord coord) {
        return mapa.Map.get(coord) == Box.FonBlackOne;
    }
    public boolean pressInWhite(Coord coord) {
       return mapa.Map.get(coord) == Box.FonWhiteOne;
    }
    public Coord blackRight(final Coord oldCoord) {
        return new Coord(oldCoord.x - 1,oldCoord.y + 1);
    }
    public Coord blackLeft(final Coord oldCoord) {
        return new Coord(oldCoord.x + 1, oldCoord.y + 1);
    }
    public Coord whiteRight(final Coord oldCoord) {
        return new Coord(oldCoord.x + 1, oldCoord.y - 1);
    }
    public Coord whiteLeft(final Coord oldCoord) {
        return new Coord(oldCoord.x - 1, oldCoord.y -1);
    }
    public void setClosedBlack(Coord coord) {
            if (coord.x != 0) {
                if (pressInWhite(blackRight(coord))) {
                    if (!pressInBlack(blackRight(blackRight(coord)))) {
                        if (!pressInWhite(blackRight(blackRight(coord)))) {
                            mapa.Map.set(blackRight(coord), Box.FonWhiteOnee);
                            mapa.Map.set(blackRight(blackRight(coord)), Box.Closed);
                            setAny(coord, Box.Fon);
                        }
                    }
                }
            }
            if (coord.x != 7) {
                if (pressInWhite(blackLeft(coord))) {
                    if (!pressInBlack(blackLeft(blackLeft(coord)))) {
                        if (!pressInWhite(blackLeft(blackLeft(coord)))) {
                            mapa.Map.set(blackLeft(coord), Box.FonWhiteOnee);
                            mapa.Map.set(blackLeft(blackLeft(coord)), Box.Closed);
                            setAny(coord, Box.Fon);
                        }
                    }
                }
            }
            if (coord.x != 7) {
                if (!pressInBlack(blackLeft(coord))) {
                    if (!pressInWhite(blackLeft(coord))) {
                        if (getAny(blackLeft(coord)) != Box.FonWhiteOnee) {
                            if (mapa.Map.get(blackRight(blackRight(coord))) != Box.Closed) {
                                setAny(coord, Box.Fon);
                                mapa.Map.set(blackLeft(coord), Box.Closed);
                            }
                        }
                    }
                }
            }
            if (coord.x != 0) {
                if (!pressInBlack(blackRight(coord))) {
                    if (!pressInWhite(blackRight(coord))) {
                        if (getAny(blackRight(coord)) != Box.FonWhiteOnee) {
                            if (mapa.Map.get(blackLeft(blackLeft(coord))) != Box.Closed) {
                                setAny(coord, Box.Fon);
                                mapa.Map.set(blackRight(coord), Box.Closed);
                            }
                        }
                    }
                }
            }
    }
    public void setClosedWhite(Coord coord) {
            if (coord.x != 7) {
                if (pressInBlack(whiteRight(coord))) {
                    if (!pressInBlack(whiteRight(whiteRight(coord)))) {
                        if (!pressInWhite(whiteRight(whiteRight(coord)))) {
                            mapa.Map.set(whiteRight(coord), Box.FonBlackOnee);
                            mapa.Map.set(whiteRight(whiteRight(coord)), Box.Closedd);
                            setAny(coord, Box.Fon);
                        }
                    }
                }
            }
            if (coord.x != 0) {
                if (pressInBlack(whiteLeft(coord))) {
                    if (!pressInBlack(whiteLeft(whiteLeft(coord)))) {
                        if (!pressInWhite(whiteLeft(whiteLeft(coord)))) {
                            mapa.Map.set(whiteLeft(coord), Box.FonBlackOnee);
                            mapa.Map.set(whiteLeft(whiteLeft(coord)), Box.Closedd);
                            setAny(coord, Box.Fon);
                        }
                    }
                }
            }
            if (coord.x != 0) {
                if (!pressInWhite(whiteLeft(coord))) {
                    if (!pressInBlack(whiteLeft(coord))) {
                        if (getAny(whiteLeft(coord)) != Box.FonBlackOnee) {
                            if (getAny(whiteRight(whiteRight(coord))) != Box.Closedd) {
                                mapa.Map.set(whiteLeft(coord), Box.Closedd);
                                setAny(coord, Box.Fon);
                            }
                        }
                    }
                }
            }
            if (coord.x != 7) {
                if (!pressInWhite(whiteRight(coord))) {
                    if (!pressInBlack(whiteRight(coord))) {
                        if (getAny(whiteRight(coord)) != Box.FonBlackOnee) {
                            if (getAny(whiteLeft(whiteLeft(coord))) != Box.Closedd) {
                                mapa.Map.set(whiteRight(coord), Box.Closedd);
                                setAny(coord, Box.Fon);
                            }
                        }
                    }
                }
            }
    }
    public void setAny(Coord coord, Box box) {
        mapa.Map.set(coord, box);
    }
    public Box getAny(Coord coord) {
        return mapa.Map.get(coord);
    }
    public Box getBox(Coord coord) {
        return mapa.get(coord);
    }
    public boolean isClosedBlack(Coord coord) {
        return mapa.Map.get(coord) == Box.Closed;
    }
    public boolean isClosedWhite(Coord coord) {
        return mapa.Map.get(coord) == Box.Closedd;
    }
    public void pressLeftButtonBlack(Coord coord) {
        mapa.Map.set(coord, Box.FonBlackOne);
    }
    public void pressLeftButtonWhite(Coord coord) {
        mapa.Map.set(coord, Box.FonWhiteOne);
    }
    public void blackDamka(final Coord coord) {
        Coord coord1;
        int a = coord.y - 1;
        for (int i = coord.x + 1;i < 8; i++) {
            a--;
            coord1 = new Coord(i, a);
            setAny(coord1, Box.Closed);
        }
        a = coord.y - 1;
        for (int i = coord.x - 1; i >= 0; i--) {
            a--;
            coord1 = new Coord(i, a);
            setAny(coord1, Box.Closed);
        }
    }
    public void whiteDamka(final Coord coord) {
        Coord coord1;
        int a = coord.y + 1;
        for (int i = coord.x - 1;i < 8; i--) {
            a++;
            coord1 = new Coord(i, a);
            setAny(coord1, Box.Closed);
        }
        a = coord.y + 1;
        for (int i = coord.x + 1; i >= 0; i++) {
            a++;
            coord1 = new Coord(i, a);
            setAny(coord1, Box.Closed);
        }
    }
}

