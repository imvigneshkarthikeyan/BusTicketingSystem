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
        while (SelectedOption == 1 || SelectedOption == 2) {
            //Main Booking
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
                //Admin Portal
                int AdminKey = 123;
                System.out.println("Entering into Admin Login...");
                System.out.println("Enter the pin to proceed: ");
                int pinNumber = scanner.nextInt();
                if (AdminKey == pinNumber) {
                    System.out.println("The key is correct...Redirecting to Admin portal");
                    //To display the list of Bus to the admin
                    System.out.println("The following buses are available:");
                    for (BusInfo b : busList) {
                        b.DisplayBusInfo();
                    }
                    //Operations which can be performed by the admin
                    System.out.println("Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \nEnter any other number to logout");
                    int OperationOption = scanner.nextInt();
                    //Adding new Bus
                    if (OperationOption == 1) {
                        System.out.println("Enter the Bus Number");
                        int newBusNumber = scanner.nextInt();
                        System.out.println("Enter the capacity of the bus");
                        int newBusCapacity = scanner.nextInt();
                        System.out.println("Enter the Bus Facility");
                        String newBusFacility = scanner.next();
                        System.out.println("Enter the Cost of the ticket");
                        float newCostOfTicket = scanner.nextFloat();
                        busList.add(new BusInfo(newBusNumber, newBusCapacity, newBusFacility, newCostOfTicket));
                        //Displaying the list of buses after adding
                        System.out.println("The updated bus list is given below:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 2) {
                        System.out.println("Editing the Bus...");
                    } else if (OperationOption == 3) {
                        System.out.println("Deleting the Bus...");
                    } else {
                        System.out.println("Logging out from admin portal...!");
                    }
                } else {
                    System.out.println("The key is incorrect, Retry!");
                }
            } else {
                System.out.println("Quiting the application");
            }
        }
    }
}