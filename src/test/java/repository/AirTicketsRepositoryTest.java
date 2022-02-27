package repository;

import domain.AirTickets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirTicketsRepositoryTest {

    private AirTicketsRepository repo = new AirTicketsRepository();
    private AirTickets ticket1 = new AirTickets(1, 1000, "AAA", "BBB", 100);
    private AirTickets ticket2 = new AirTickets(2, 2000, "CCC", "III", 200);

    @Test
    public void saveOneAirTicket() {
        repo.save(ticket1);

        AirTickets[] expected = new AirTickets[]{ticket1};
        AirTickets[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveTwoAirTickets() {
        repo.save(ticket1);
        repo.save(ticket2);

        AirTickets[] expected = new AirTickets[]{ticket1, ticket2};
        AirTickets[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findZeroAirTickets() {
        repo.findAll();

        AirTickets[] expected = new AirTickets[]{};
        AirTickets[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findOneAirTicket() {
        repo.save(ticket1);

        repo.findAll();

        AirTickets[] expected = new AirTickets[]{ticket1};
        AirTickets[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repo.save(ticket1);
        repo.save(ticket2);

        repo.removeById(1);

        AirTickets[] expected = new AirTickets[]{ticket2};
        AirTickets[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}