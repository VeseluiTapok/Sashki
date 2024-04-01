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
    public void setAny(Coord coord, Box box) {
        mapa.Map.set(coord, box);
    }
    public Box getAny(Coord coord) {
        return mapa.Map.get(coord);
    }
    public Box getBox(Coord coord) {
        return mapa.get(coord);
    }
}

