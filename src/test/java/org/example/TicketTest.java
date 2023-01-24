package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1,350, "MOW","LED", 2);
    Ticket ticket2 = new Ticket(2,200, "GOJ","KUF", 4);
    Ticket ticket3 = new Ticket(3,400, "LED","OGZ", 5);
    Ticket ticket4 = new Ticket(4,600, "FRU","MOW", 8);
    Ticket ticket5 = new Ticket(5,100, "OGZ","GOJ", 1);
    Ticket ticket6 = new Ticket(6,100, "MOW","LED", 2);
    Ticket ticket7 = new Ticket(7,200, "GOJ","KUF", 4);
    Ticket ticket8 = new Ticket(8,600, "LED","OGZ", 5);

    @Test
    public void shouldAdd1() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);

        Ticket[] expected = {ticket1,ticket2,ticket3,ticket4,ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldAdd2() {
        repo.addTicket(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldAdd3() {

        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldRemove1() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.removeById(4);
        Ticket [] expected = {ticket1,ticket2,ticket3,ticket5};
        Ticket [] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldRemove2() {
        repo.addTicket(ticket6);
        repo.removeById(6);
        Ticket [] expected = {};
        Ticket [] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldRemove3() {
        try {
            repo.removeById(5);
        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка");
        }
        Ticket [] expected = {};
        Ticket [] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFind1() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        String from = "MOW";
        String to = "LED";
        Ticket[] expected = {ticket6, ticket1};
        Ticket[] actual = manager.findAll(from,to);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFind2() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        String from = "GOJ";
        String to = "KUF";
        Ticket[] expected = {ticket2, ticket7};
        Ticket[] actual = manager.findAll(from,to);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFind3() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        repo.addTicket(ticket8);
        String from = "LED";
        String to = "OGZ";
        Ticket[] expected = {ticket3, ticket8};
        Ticket[] actual = manager.findAll(from,to);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFind4() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        String from = "OGZ";
        String to = "GOJ";
        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll(from,to);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFind5() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        String from = "PTA";
        String to = "TRE";
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll(from,to);
        Assertions.assertArrayEquals(expected,actual);
    }
}
