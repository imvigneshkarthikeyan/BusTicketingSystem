import java.util.*;

public class BusTicketingSystem {
    public static void main(String [] args) {
        // ArrayList for BusInfo 
        ArrayList<BusInfo> busList = new ArrayList<>();
        ArrayList<PassengerInfo> passengerList = new ArrayList<>();
        //Adding new buses into ArrayList
        busList.add(new BusInfo(1, 2, "AC", 750));
        busList.add(new BusInfo(2, 32, "Sleeper", 600));
        busList.add(new BusInfo(3, 20, "Semi-Sleeper", 400));
        busList.add(new BusInfo(4, 20, "Normal", 250));
        // Option given by User
        int SelectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        // ForEach loop to fetch the elements from array list
        for (BusInfo b : busList) {
            b.DisplayBusInfo();
        }
        // Loop for Booking
        while (SelectedOption == 1) {
            System.out.println("Enter option: \n1: Start a new Booking \n2: Login as Admin \n3: Quit\n");
            SelectedOption = scanner.nextInt();
            if (SelectedOption == 1) {
                // System.out.println("Initiated Booking...");
                PassengerInfo ticketForPassenger = new PassengerInfo();
                if (ticketForPassenger.IsAvailable(passengerList, busList)) {
                    passengerList.add(ticketForPassenger);
                    System.out.println("The Ticket Reserved Sucessfully...!");
                } else {
                    System.out.println("Ticket is not available for the date selected. Book in different Bus/Date");
                }

            } else if (SelectedOption == 2) {
                System.out.println("Entering into Admin Login");
            } else {
                System.out.println("Quiting the application");
            }
        }
    }
}