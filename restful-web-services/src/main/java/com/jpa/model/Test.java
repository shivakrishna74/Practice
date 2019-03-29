package com.jpa.model;

public class Test {
    private int id;
    private int anme;

    public Test(int id, int anme) {
        this.id = id;
        this.anme = anme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnme() {
        return anme;
    }

    public void setAnme(int anme) {
        this.anme = anme;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", anme=" + anme +
                '}';
    }
}
