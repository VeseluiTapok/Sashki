package Saski;

public enum Box {
    Closed,
    Closedd,
    Fon,
    Foon,
    FonBlackOne,
    FonBlackOnee,
    FonWhiteOne,
    FonWhiteOnee,
    FoonBlackOne,
    FoonWhiteOne,
    BlackDamka,
    WhiteDamka;
    public Object image;
    Box getNextNumberBox() {
        return Box.values()[this.ordinal() + 1];
    }
    int getNumber() {
        return this.ordinal();
    }
}
