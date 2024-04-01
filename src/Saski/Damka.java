package Saski;

public class Damka {
    Game game;
    Sachka sachka;
    private int roundsCounter = 0;
    public boolean Damka = false;
    public void start() {
        sachka = new Sachka();
        game = Sashki.game;
    }
    public void run(Coord coord, Color color, Coord DefaultCoord) {
        if (color == Color.Black) {
            Sashki.DamkaChiNe = true;
            game.setAny(coord, Box.Fon);
            roundsCounter = 0;
            while (coord.x != 0) {
                roundsCounter += 1;
                coord.x -= 1;
                coord.y -= 1;
                if (game.getAny(coord) == Box.FonWhiteOne) {
                    if (game.getAny(sachka.whiteLeft(coord)) == Box.FonWhiteOne) {
                        coord.x = 7;
                    }
                    else {
                        setAllowedFieldsBlackLeft(coord);
                    }
                }
                else if (game.getAny(coord) == Box.FonBlackOne) {
                    coord.x = 7;
                }
                else {
                    game.setAny(coord, Box.Closed);
                }
            }
            roundsCounter = 0;
            while (coord.x != 7) {
                roundsCounter += 1;
                coord = DefaultCoord;
                coord.x += 1;
                coord.y -= 1;
                if (game.getAny(coord) == Box.FonWhiteOne) {
                    if (game.getAny(sachka.whiteRight(coord)) == Box.FonWhiteOne) {
                        coord.x = 7;
                    } else {
                        setAllowedFieldsBlackRight(coord);
                    }
                } else if (game.getAny(coord) == Box.FonBlackOne) {
                    coord.x = 7;
                } else {
                    game.setAny(coord, Box.Closed);
                }
            }
            Damka = false;
        }
        else {
            System.out.println("sfasdasdadaasda");
        }
    }
    public void setAllowedFieldsBlackLeft (Coord coord) {
        if (roundsCounter == 2) {
            game.setAny(sachka.blackLeft(coord), Box.Fon);
        }
        if (roundsCounter == 3) {
            game.setAny(sachka.blackLeft(coord), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(coord)), Box.Fon);
        }
        if (roundsCounter == 4) {
            game.setAny(sachka.blackLeft(coord), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(coord)), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord))), Box.Fon);
        }
        if (roundsCounter == 5) {
            game.setAny(sachka.blackLeft(coord), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(coord)), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord))), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord)))), Box.Fon);
        }
        if (roundsCounter == 6) {
            game.setAny(sachka.blackLeft(coord), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(coord)), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord))), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord)))), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord))))), Box.Fon);
        }
        if (roundsCounter == 7) {
            game.setAny(sachka.blackLeft(coord), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(coord)), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord))), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord)))), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord))))), Box.Fon);
            game.setAny(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(sachka.blackLeft(coord)))))), Box.Fon);
        }
    }
    public void setAllowedFieldsBlackRight (Coord coord) {
        if (roundsCounter == 2) {
            game.setAny(sachka.blackRight(coord), Box.Fon);
        }
        if (roundsCounter == 3) {
            game.setAny(sachka.blackRight(coord), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(coord)), Box.Fon);
        }
        if (roundsCounter == 4) {
            game.setAny(sachka.blackRight(coord), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(coord)), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord))), Box.Fon);
        }
        if (roundsCounter == 5) {
            game.setAny(sachka.blackRight(coord), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(coord)), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord))), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord)))), Box.Fon);
        }
        if (roundsCounter == 6) {
            game.setAny(sachka.blackRight(coord), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(coord)), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord))), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord)))), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord))))), Box.Fon);
        }
        if (roundsCounter == 7) {
            game.setAny(sachka.blackRight(coord), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(coord)), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord))), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord)))), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord))))), Box.Fon);
            game.setAny(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(sachka.blackRight(coord)))))), Box.Fon);
        }
    }
}
