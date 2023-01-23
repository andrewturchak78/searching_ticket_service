package org.example;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
    public Ticket (int id, int price, String from, String to, int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.getPrice() > o.price) {
            return 1;
        } else if (this.getPrice() < o.price) {
            return -1;
        } else {
            return 0;
        }
    }
}
