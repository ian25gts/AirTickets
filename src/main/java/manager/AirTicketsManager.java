package manager;

import domain.AirTickets;
import repository.AirTicketsRepository;

import java.util.Arrays;

public class AirTicketsManager {
    private AirTicketsRepository repository;

    public AirTicketsManager(AirTicketsRepository repository) {
        this.repository = repository;
    }

    public AirTickets[] searchBy(String departureAirport, String arrivalAirport) {
        AirTickets[] result = new AirTickets[0];
        for (AirTickets ticket : repository.findAll()) {
            if (matches(ticket, departureAirport, arrivalAirport)) {
                int length = result.length + 1;
                AirTickets[] tmp = new AirTickets[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matches(AirTickets ticket, String departureAirport, String arrivalAirport) {
        if (ticket.getDepartureAirport().contains(departureAirport)) {
            return ticket.getArrivalAirport().contains(arrivalAirport);
        }
        return false;
    }
}
