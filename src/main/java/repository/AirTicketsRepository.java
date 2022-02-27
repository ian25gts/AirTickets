package repository;

import domain.AirTickets;

public class AirTicketsRepository {
    private AirTickets[] tickets = new AirTickets[0];

    public void save(AirTickets ticket) {

        int length = tickets.length + 1;
        AirTickets[] tmp = new AirTickets[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public AirTickets[] findAll() {
        return tickets;
    }

    public void removeById(int id) {

        int length = tickets.length - 1;
        AirTickets[] tmp = new AirTickets[length];
        int index = 0;
        for (AirTickets ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}