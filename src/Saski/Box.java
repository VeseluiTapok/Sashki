package Saski;

public enum Box {
    Closed,
    Closedd,
    Fon,
    Foon,
    FonBlackOne,
    FonWhiteOne,
    FoonBlackOne,
    FoonWhiteOne;
    public Object image;
    Box getNextNumberBox() {
        return Box.values()[this.ordinal() + 1];
    }
    int getNumber() {
        return this.ordinal();
    }
}
