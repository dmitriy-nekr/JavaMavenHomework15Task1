import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 450, "OVB", "SVO", 500);
    Ticket ticket2 = new Ticket(2, 750, "DME", "AFK", 300);
    Ticket ticket3 = new Ticket(3, 450, "PTE", "SBS", 210);
    Ticket ticket4 = new Ticket(4, 800, "OYP", "STO", 640);
    Ticket ticket5 = new Ticket(5, 120, "USB", "SLD", 115);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

    }

    @Test
    public void shouldFindOneTicket() {
        Ticket[] actual = manager.findAll("PTE", "SBS");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAboveOneTicket() {
        Ticket ticket6 = new Ticket(6, 350, "PTE", "SBS", 210);
        Ticket ticket7 = new Ticket(7, 135, "PTE", "SBS", 210);
        Ticket ticket8 = new Ticket(8, 775, "PTE", "SBS", 210);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.findAll("PTE", "SBS");
        Ticket[] expected = {ticket7, ticket6, ticket3, ticket8};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoOne() {
        Ticket[] actual = manager.findAll("ABC", "GFD");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }


}
