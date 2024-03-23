package Saski;

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
        if (mapa.Map.get(coord) == Box.FonBlackOne) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean pressInWhite(Coord coord) {
        if (mapa.Map.get(coord) == Box.FonWhiteOne) {
            return true;
        }
        else {
            return false;
        }
    }
    public Coord blackRight(Coord coord) {
        coord.x -= 1;
        coord.y += 1;
        return coord;
    }
    public Coord blackLeft(Coord coord) {
        coord.x += 2;
        return coord;
    }
    public Coord whiteRight(Coord coord) {
        if (coord.x != 0) {
            coord.x -= 1;
            coord.y -= 1;
        }
        return coord;
    }
    public Coord whiteLeft(Coord coord) {
        if (coord.x != 7) {
            coord.x += 2;
        }
        return coord;
    }
    public void setClosedBlack(Coord coord) {
        if (coord.x != 0) {
            mapa.Map.set(blackRight(coord), Box.Closed);
        }
        if (coord.x != 7) {
            mapa.Map.set(blackLeft(coord), Box.Closed);
        }
    }
    public void setClosedWhite(Coord coord) {
        if (coord.x != 0) {
            mapa.Map.set(whiteRight(coord), Box.Closedd);
        }
        if (coord.x != 7) {
            mapa.Map.set(whiteLeft(coord), Box.Closedd);
        }
    }
    public int isAnyBlackHere(Coord coord, Box box) {
        if (mapa.Map.get(blackRight(coord)) == box) {
            coord.x--;
            coord.y--;
            return 1;
        }
        else if (mapa.Map.get(blackLeft(coord)) == box) {
            coord.x++;
            coord.y++;
            return 2;
        }
        else if (mapa.Map.get(blackRight(coord)) == box &&
                mapa.Map.get(blackLeft(coord)) == box) {
            coord.x++;
            coord.y++;
            return 3;
        }
        else {
            return 4;
        }
    }
    public boolean isAnyWhiteHere(Coord coord, Box box) {
        if (mapa.Map.get(whiteRight(coord)) == box) {
            return true;
        }
        else if (mapa.Map.get(whiteLeft(coord)) == box) {
            return true;
        }
        else {
            return false;
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
    public boolean isClosedBalck(Coord coord) {
        if (mapa.Map.get(coord) == Box.Closed) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isClosedWhite(Coord coord) {
        if (mapa.Map.get(coord) == Box.Closedd) {
            return true;
        }
        else {
            return false;
        }
    }
    public void pressLeftButtonBlack(Coord coord) {
        mapa.Map.set(coord, Box.FonBlackOne);
    }
    public void pressLeftButtonWhite(Coord coord) {
        mapa.Map.set(coord, Box.FonWhiteOne);
    }
}
