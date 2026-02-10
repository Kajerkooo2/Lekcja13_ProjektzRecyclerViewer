package com.example.skrotymyslowe;

public class Mysl {
    private String mysl;
    private int landscape;

    public Mysl(String mysl, int landscape) {
        this.mysl = mysl;
        this.landscape = landscape;
    }

    public String getMysl() {
        return mysl;
    }

    public void setMysl(String mysl) {
        this.mysl = mysl;
    }

    public int getLandscape() {
        return landscape;
    }

    public void setLandscape(int landscape) {
        this.landscape = landscape;
    }

    @Override
    public String toString() {
        return mysl;
    }
}