package com.example.SpringExample;

public class User {
    private String ID;
    private String name;
    private int wins;
    private int lose;

    public User(String ID, String name){
        this.ID = ID;
        this.name = name;
        this.wins = 0;
        this.lose = 0;
    }
    public User(String ID, String name, int win, int lose){
        this.ID = ID;
        this.name = name;
        this.wins = win;
        this.lose = lose;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", wins=" + wins +
                ", lose=" + lose +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getLose() {
        return lose;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }
}

