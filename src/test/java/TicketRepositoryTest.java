import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 450, "OVB", "SVO", 500);
    Ticket ticket2 = new Ticket(2, 750, "DME", "AFK", 300);
    Ticket ticket3 = new Ticket(3, 450, "PTE", "SBS", 400);
    Ticket ticket4 = new Ticket(4, 800, "OYP", "STO", 640);
    Ticket ticket5 = new Ticket(5, 120, "USB", "SLD", 115);

    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

    }


    @Test
    public void shouldGetAllTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(3);
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);

    }

}
