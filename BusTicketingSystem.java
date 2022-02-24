import java.util.*;

class BusInfo {
    int BusNumber;
    int BusCapacity;
    String BusFacility;
    float CostOfTicket;
}

class PassengerInfo {
    String PassengerName;
    String PassengerPhoneNumber;
    Date DateOfJourney;
}

public class BusTicketingSystem {
    public static void main(String [] args) {
        int SelectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        while (SelectedOption == 1) {
            System.out.println("Enter option: \n1: Start a new Booking \n2: Login as Admin \n3: Quit\n");
            SelectedOption = scanner.nextInt();
            if (SelectedOption == 1) {
                System.out.println("Initiating new Booking");
            } else if (SelectedOption == 2) {
                System.out.println("Entering into Admin Login");
            } else {
                System.out.println("Quiting the application");
            }
        }
    }
}