package Saski;

public class Mapa {
    public Matrix Map;

    public Mapa() {
        Map = new Matrix(Box.Fon);
    }

    public void start() {
        Map = new Matrix(Box.Fon);
        setColorToStartPosition();
        setSashkiToStartPosition();
    }

    Box get(Coord coord) {
        return Map.get(coord);
    }

    public void setColorToStartPosition() {
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {
                if (x % 2 != 0) {
                    if (y % 2 == 0) {
                        Map.set(new Coord(x, y), Box.Foon);
                    }
                } else {
                    if (y % 2 != 0) {
                        Map.set(new Coord(x, y), Box.Foon);
                    }
                }
            }
        }
    }

    public Box isFon1(Coord coord) {
        if (Map.get(coord) == Box.Fon) {
            return Box.FonBlackOne;
        } else {
            return Box.FoonBlackOne;
        }
    }

    public Box isFon2(Coord coord) {
        if (Map.get(coord) == Box.Fon) {
            return Box.FonWhiteOne;
        } else {
            return Box.FoonWhiteOne;
        }
    }

    public void setSashkiToStartPosition() {
        for (int x = 0; x <= 7; x++) {
            for (int y = 0; y <= 7; y++) {
                if (y <= 2) {
                    if (y % 2 == 0) {
                        if (x % 2 == 0) {
                            Map.set(new Coord(x, y), Box.FonBlackOne);
                        }
                    } else {
                        if (x % 2 != 0) {
                            Map.set(new Coord(x, y), Box.FonBlackOne);
                        }
                    }
                }
                if (y >= 5) {
                    if (y <= 7) {
                        if (y % 2 == 0) {
                            if (x % 2 == 0) {
                                Map.set(new Coord(x, y), Box.FonWhiteOne);
                            }
                        }
                        else {
                            if (x % 2 != 0) {
                                Map.set(new Coord(x, y), Box.FonWhiteOne);
                            }
                        }
                    }
                }
            }
        }
    }
}
