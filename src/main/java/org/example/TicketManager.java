package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }


    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator){
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getFrom().contains(from) & ticket.getTo().contains(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                int i = 0;
                for (Ticket results : result) {
                    tmp[i] = results;
                    i++;
                }
                tmp[result.length] = ticket;
                result = tmp;
                Arrays.sort(result, comparator);
            }
        }
        return result;
    }
}
