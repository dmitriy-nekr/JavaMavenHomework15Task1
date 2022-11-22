import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getArrival().contains(to) && ticket.getDeparture().contains(from)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAll(String from, String to) {
        Arrays.sort(repo.getTickets());
        Ticket[] result = new Ticket[0];
        int counter = 0;
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                if (counter == 0) {
                    Ticket[] tmpresult = new Ticket[counter + 1];
                    tmpresult[counter] = ticket;
                    result = tmpresult;

                }
                if (counter > 0) {
                    Ticket[] tmpresult1 = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmpresult1[i] = result[i];
                    }
                    tmpresult1[tmpresult1.length - 1] = ticket;
                    result = tmpresult1;

                }
                counter++;

            }
        }
        return result;
    }

}
