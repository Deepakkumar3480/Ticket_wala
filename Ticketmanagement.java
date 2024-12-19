
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ticket {

    int ticketid;
    String description;
    String status;

    //constructor
    public Ticket(int id, String description) {
        this.ticketid = id;
        this.description = description;
        this.status = "open"; //default status is open
    }

    //display ticket details
    public void display() {
        System.out.println("Ticket Id :" + ticketid);
        System.out.println("Description:" + description);
        System.out.println("status :" + status);
    }
}

class Ticketmanagementsystem {

    private List<Ticket> tickets;
    private int ticketCount;

    public Ticketmanagementsystem() {
        tickets = new ArrayList<>();
        ticketCount = 0;
    }

    // create a new ticket
    public void createTicket(String description) {
        ticketCount++;
        Ticket newticket = new Ticket(ticketCount, description);
        tickets.add(newticket);
        System.out.println("Ticket created successfully with ID" + ticketCount);
    }

    //display all tickets
    public void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets available");
            return;
        }
        for (Ticket ticket : tickets) {
            ticket.display();
            System.out.println("...................");
        }
    }

    //update the status of a ticket
    public void updateTicketStatus(int ticketId, String newStatus) {
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.ticketid == ticketId) {
                ticket.status = newStatus;
                found = true;
                System.out.println("Ticket ID" + ticketId + "status updated to" + newStatus);
                break;
            }
        }
        if (!found) {
            System.out.println("Ticket Id not found.");
        }
    }
    //delete a ticket by ID

    public void deleteTicket(int ticketid) {
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.ticketid == ticketid) {
                tickets.remove(ticket);
                found = true;
                System.out.println("Ticket ID" + ticketid + "deleted");
                break;
            }
        }
        if (!found) {
            System.out.println("Ticket ID not found");
        }
    }

    //search tickets by description or status
    public void searchTickets(String query) {
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.description.contains(query)
                    || ticket.status.contains(query)) {
                ticket.display();
                System.out.println("............");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tickets match the search query");
        }
    }
}

public class Ticketmanagement {

    public static void main(String[] args) {
        Ticketmanagementsystem tms = new Ticketmanagementsystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- Ticket management System---");
            System.out.println("1. create a ticket");
            System.out.println("2. Display all tickets");
            System.out.println("3. Update ticket status");
            System.out.println("4. Delete a ticket");
            System.out.println("5. Search tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ticket description: ");
                    String description = scanner.nextLine();
                    tms.createTicket(description);
                    break;

                case 2:
                    tms.displayTickets();
                    break;

                case 3:
                    System.out.print("Enter ticket ID to update: ");
                    int ticketIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new status (Open/Closed): ");
                    String newStatus = scanner.nextLine();
                    tms.updateTicketStatus(ticketIdToUpdate, newStatus);
                    break;

                case 4:
                    System.out.print("Enter ticket ID to delete: ");
                    int ticketIdToDelete = scanner.nextInt();
                    tms.deleteTicket(ticketIdToDelete);
                    break;

                case 5:
                    System.out.print("Enter search query (description or status): ");
                    String query = scanner.nextLine();
                    tms.searchTickets(query);
                    break;

                case 6:
                    System.out.println("Exiting Ticket Management System...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
