public enum ArtikelTypen { 
    STANDARD(0),
    VIDEO(1),
    BUCH(2),
    CD(3);

    private int index;

    ArtikelTypen(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

};