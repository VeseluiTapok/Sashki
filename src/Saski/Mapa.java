package Saski;

public class Mapa {
    public Matrix Map;
    public Mapa() {
        Map = new Matrix(Box.Closed);
    }
    public void start() {
        Map = new Matrix(Box.Closed);
        setColor();
        setMap();
    }

    Box get(Coord coord) {
        return Map.get(coord);
    }
    public void setColor() {
        for (int i = 0; i < 8; i++) {
            for (int a = 0; a < 8; a++) {
                if (a % 2 == 0) {
                    if (i % 2 == 0) {
                        Map.set(new Coord(i, a), Box.Fon);
                    }
                    else {
                        Map.set(new Coord(i, a), Box.Foon);
                    }
                }
                else {
                    if (i % 2 == 0) {
                        Map.set(new Coord(i, a), Box.Foon);
                    }
                    else {
                        Map.set(new Coord(i, a), Box.Fon);
                    }
                }
            }
        }
    }
    public Box isFon1(Coord coord) {
        if (Map.get(coord) == Box.Fon) {
            return Box.FonBlackOne;
        }
        else {
            return Box.FoonBlackOne;
        }
    }
    public Box isFon2(Coord coord) {
        if (Map.get(coord) == Box.Fon) {
            return Box.FonWhiteOne;
        }
        else {
            return Box.FoonWhiteOne;
        }
    }
    public void setMap() {
        Map.set(new Coord(0, 0), isFon1(new Coord(0, 0)));
        Map.set(new Coord(1, 1), isFon1(new Coord(1, 1)));
        Map.set(new Coord(2, 2), isFon1(new Coord(2, 2)));
        Map.set(new Coord(0, 2), isFon1(new Coord(0, 2)));
        Map.set(new Coord(2, 0), isFon1(new Coord(2, 0)));
        Map.set(new Coord(3, 1), isFon1(new Coord(3, 1)));
        Map.set(new Coord(4, 0), isFon1(new Coord(4, 0)));
        Map.set(new Coord(4, 2), isFon1(new Coord(4, 2)));
        Map.set(new Coord(5, 1), isFon1(new Coord(5, 1)));
        Map.set(new Coord(6, 0), isFon1(new Coord(6, 0)));
        Map.set(new Coord(6, 2), isFon1(new Coord(6, 2)));
        Map.set(new Coord(7, 1), isFon1(new Coord(7, 1)));
        Map.set(new Coord(8, 0), isFon1(new Coord(8, 0)));
        Map.set(new Coord(8, 2), isFon1(new Coord(8, 2)));
        Map.set(new Coord(0, 6), isFon2(new Coord(0, 6)));
        Map.set(new Coord(1, 5), isFon2(new Coord(1, 5)));
        Map.set(new Coord(1, 7), isFon2(new Coord(1, 7)));
        Map.set(new Coord(2, 6), isFon2(new Coord(2, 6)));
        Map.set(new Coord(3, 5), isFon2(new Coord(3, 5)));
        Map.set(new Coord(3, 7), isFon2(new Coord(3, 7)));
        Map.set(new Coord(4, 6), isFon2(new Coord(4, 6)));
        Map.set(new Coord(5, 5), isFon2(new Coord(5, 5)));
        Map.set(new Coord(5, 7), isFon2(new Coord(5, 7)));
        Map.set(new Coord(6, 6), isFon2(new Coord(6, 6)));
        Map.set(new Coord(7, 5), isFon2(new Coord(7, 5)));
        Map.set(new Coord(7, 7), isFon2(new Coord(7, 7)));
    }
}
