package manager;

import domain.AirTickets;
import org.junit.jupiter.api.Test;
import repository.AirTicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class AirTicketsManagerTest {

    private AirTicketsRepository repo = new AirTicketsRepository();
    private AirTicketsManager manager = new AirTicketsManager(repo);

    private AirTickets ticket1 = new AirTickets(1, 1000, "AAA", "BBB", 100);
    private AirTickets ticket2 = new AirTickets(2, 2000, "CCC", "III", 200);
    private AirTickets ticket3 = new AirTickets(3, 3000, "AAA", "BBB", 300);
    private AirTickets ticket4 = new AirTickets(4, 4000, "DDD", "GGG", 400);
    private AirTickets ticket5 = new AirTickets(5, 5000, "AAA", "BBB", 500);

    @Test
    public void noAirTicketsTest() {
        AirTickets[] expected = new AirTickets[]{};
        AirTickets[] actual = manager.searchBy("AAA", "BBB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneMatchTest() {
        repo.save(ticket1);
        repo.save(ticket2);

        AirTickets[] expected = new AirTickets[]{ticket1};
        AirTickets[] actual = manager.searchBy("AAA", "BBB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void manyAirTicketsNoMatchesTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        AirTickets[] expected = new AirTickets[]{};
        AirTickets[] actual = manager.searchBy("CCC", "BBB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void manyAirTicketsOneMatchTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);

        AirTickets[] expected = new AirTickets[]{ticket2};
        AirTickets[] actual = manager.searchBy("CCC", "III");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void manyAirTicketsMultipleMatchesTest() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        AirTickets[] expected = new AirTickets[]{ticket1, ticket3, ticket5};
        AirTickets[] actual = manager.searchBy("AAA", "BBB");

        assertArrayEquals(expected, actual);
    }
}