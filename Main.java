import java.text.*;
import java.util.*;
import java.io.*;

class AdminInfo {
    // Declaring it as final, as it should not be modified
    private final String AdminKey = "123";
    public String getAdminKey() {
        return AdminKey;
    }
    public String getHintForAdminKey() {
        String HintForAdminKey = "Its a 3 digit pin.";
        return HintForAdminKey;
    }
}

public class Main extends AdminInfo {
    public String ForgetAdminKey() {
        return super.getHintForAdminKey();
    }
    public static void main(String[] args) {
        // ArrayList for BusInfo
        ArrayList<BusInfo> busList = new ArrayList<>();
        ArrayList<PassengerInfo> passengerList = new ArrayList<>();
        // Adding the default buses into ArrayList
        busList.add(new BusInfo(1001, "Chennai", "Thanjavur", 20, "AC", 750));
        busList.add(new BusInfo(3132, "Chennai", "Thanjavur", 30, "Sleeper", 600));
        busList.add(new BusInfo(3313, "Chennai", "Thanjavur", 40, "Normal", 350));
        busList.add(new BusInfo(1010, "Thanjavur", "Chennai", 20, "AC", 750));
        busList.add(new BusInfo(3123, "Thanjavur", "Chennai", 30, "Sleeper", 600));
        busList.add(new BusInfo(3331, "Thanjavur", "Chennai", 40, "Normal", 350));
        busList.add(new BusInfo(1052, "Chennai", "Trichy", 40, "Semi-Sleeper", 400));
        busList.add(new BusInfo(1053, "Chennai", "Trichy", 30, "Sleeper", 550));
        busList.add(new BusInfo(1054, "Chennai", "Trichy", 20, "AC", 750));
        busList.add(new BusInfo(1025, "Trichy", "Chennai", 40, "Semi-Sleeper", 400));
        busList.add(new BusInfo(1035, "Trichy", "Chennai", 30, "Sleeper", 550));
        busList.add(new BusInfo(1045, "Trichy", "Chennai", 20, "AC", 750));
        busList.add(new BusInfo(2134, "Trichy", "Thanjavur", 30, "Sleeper", 550));
        busList.add(new BusInfo(2135, "Trichy", "Thanjavur", 20, "AC", 600));
        busList.add(new BusInfo(2136, "Trichy", "Thanjavur", 40, "Normal", 350));
        busList.add(new BusInfo(2143, "Thanjavur", "Trichy", 30, "Sleeper", 550));
        busList.add(new BusInfo(2153, "Thanjavur", "Trichy", 20, "AC", 600));
        busList.add(new BusInfo(2163, "Thanjavur", "Trichy", 40, "Normal", 350));
        // Option given by User
        int SelectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "======================================== Welcome to Bus Ticketing System ========================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "======================================== Total Buses are displayed below ========================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
        // ForEach loop to fetch the elements from array list
        for (BusInfo b : busList) {
            b.DisplayBusInfo();
        }
        // Loop for the Application
        while (SelectedOption == 1 || SelectedOption == 2) {
            // Main Booking
            System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
            System.out.println("\033[0;1m" + "Enter option:" + "\033[0;0m" + "\n1: Start a new Booking \n2: Login as Admin \nAny other number: Quit\n");
            SelectedOption = scanner.nextInt();
            if (SelectedOption == 1) {
                PassengerInfo ticketForPassenger = new PassengerInfo();
                ticketForPassenger.FilteredBusList(passengerList, busList);
                ticketForPassenger.DisplayFilteredBusList(passengerList, busList);
                if (ticketForPassenger.IsFilteredBusListEmpty(passengerList, busList) == false) {
                    ticketForPassenger.GetDateOfJourneyFromUser();
                    int AvailableSeats = ticketForPassenger.DisplayRemainingSeats(passengerList, busList);
                    DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                    String FormattedDate = dateFormatter.format(ticketForPassenger.getDateOfJourney());
                    System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
                    System.out.println("\033[0;1m" + "The no:of seats available for Bus Number " + ticketForPassenger.getBusNumber() + " on " + FormattedDate + " is: " + "\033[0;0m" + AvailableSeats);
                    System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
                    if (AvailableSeats > 0) {
                        ticketForPassenger.GetOtherPassengerInfo();
                        passengerList.add(ticketForPassenger);
                        System.out.println("\033[0;1m" + "=================================================================================================================");
                        System.out.println("================================================== TICKET =======================================================");
                        System.out.println("=================================================================================================================" + "\033[0;0m");
                        System.out.println("\033[0;1m" + "Reservation Status:" + "\033[0;0m" + "Success!");
                        String TicketID = ticketForPassenger.getTicketID();
                        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + TicketID);
                        String PassengerName = ticketForPassenger.getPassengerName();
                        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + PassengerName);
                        String PassengerIdNumber = ticketForPassenger.getPassengerIdNumber();
                        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + PassengerIdNumber);
                        Date DateOfJourney = ticketForPassenger.getDateOfJourney();
                        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                        FormattedDate = dateFormatter.format(DateOfJourney);
                        System.out.println("\033[0;1m" + "Date Of Journey: " + "\033[0;0m" + FormattedDate);
                        int BusNumber = ticketForPassenger.getBusNumber();
                        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + BusNumber);
                        String FromCity = ticketForPassenger.getFromCity(passengerList, busList);
                        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + FromCity);
                        String ToCity = ticketForPassenger.getToCity(passengerList, busList);
                        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + ToCity);
                        // Displaying the cost of ticket after tax calculation
                        System.out.println("\033[0;1m" + "--------------------------------------------------- BILL --------------------------------------------------------" + "\033[0;0m");
                        int TotalNumberOfSeats = ticketForPassenger.getTotalNumberOfSeats();
                        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + TotalNumberOfSeats);
                        double TicketAmount = ticketForPassenger.getCostOfTicket(passengerList, busList);
                        double TaxPercentage = PassengerInfo.TaxPercentage * 100;
                        double TaxAmount = ticketForPassenger.getTaxOfTicket(passengerList, busList);
                        double TotalAmountPerTicket = ticketForPassenger.getTotalCostOfTicket(passengerList, busList);
                        double TotalAmount = ticketForPassenger.getTotalCost(passengerList, busList);
                        System.out.println("\033[0;1m" + "Ticket Cost: " + "\033[0;0m" + "₹" + TicketAmount);
                        System.out.println("\033[0;1m" + "Tax Percentage: " + "\033[0;0m" + TaxPercentage + "%");
                        System.out.println("\033[0;1m" + "Tax amount: " + "\033[0;0m" + "₹" + TaxAmount);
                        System.out.println("\033[0;1m" + "The Total Cost per Ticket: " + "\033[0;0m" + "₹" + TotalAmountPerTicket);
                        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + TotalAmount);
                        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
                    } else {
                        System.out.println("As there are no seats available for the date selected, try in different Bus/Date");
                    }
                } else {
                    System.out.println("Service is not available in those areas, try \nChennai \nThanjavur \nTrichy");
                }
                // Admin Portal
            } else if (SelectedOption == 2) {
                AdminInfo adminKey = new AdminInfo();
                String AdminKey = adminKey.getAdminKey();
                Console console = System.console();
                System.out.println("Entering into Admin Login...");
                char[] readPin = console.readPassword("Enter the pin to proceed: ");
                String PinNum = new String(readPin);
                if (AdminKey.equals(PinNum) == true) {
                    System.out.println("The key is correct...Redirecting to Admin portal");
                    // To display the list of Bus to the admin
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                    System.out.println("The following buses are available:");
                    for (BusInfo b : busList) {
                        b.DisplayBusInfo();
                    }
                    // Operations which can be performed by the admin
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                    System.out.println("Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \n4.Display the list of Buses\nEnter any other number to logout");
                    int OperationOption = scanner.nextInt();
                    // Adding new Bus
                    if (OperationOption == 1) {
                        System.out.println("Enter the Bus Number");
                        int newBusNumber = scanner.nextInt();
                        System.out.println("Enter the Travel Origin");
                        String newFromCity = scanner.next();
                        System.out.println("Enter the Destination");
                        String newToCity = scanner.next();
                        System.out.println("Enter the capacity of the bus");
                        int newBusCapacity = scanner.nextInt();
                        System.out.println("Enter the Bus Facility");
                        String newBusFacility = scanner.next();
                        System.out.println("Enter the Cost of the ticket");
                        double newCostOfTicket = scanner.nextDouble();
                        busList.add(new BusInfo(newBusNumber, newFromCity, newToCity, newBusCapacity, newBusFacility, newCostOfTicket));
                        // Displaying the list of buses after adding
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("The updated bus list is given below:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 2) {
                        System.out.println("Editing the Bus...");
                        // Displaying the BusInfo along with index as unique number
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        int index = 0;
                        for (BusInfo b : busList) {
                            System.out.print("Index Number: " + index++ + "| ");
                            b.DisplayBusInfo();
                        }
                        // Getting the index number that has to be updated from user
                        System.out.println("Enter the Index number of the bus to be updated: ");
                        int BusToBeUpdated = scanner.nextInt();
                        // Asking for the field that has to be updated
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("Select the option of the field which has to be updated: ");
                        System.out.println("1.Bus Number \n2.From City \n3.To City \n4.Bus Capacity \n5.Bus Facility \n6.Cost of the ticket \nEnter any other number to quit");
                        int OptionToBeUpdated = scanner.nextInt();
                        switch (OptionToBeUpdated) {
                            case 1:
                                System.out.println("Enter the new Bus Number that has to be updated: ");
                                int updatedBusNumber = scanner.nextInt();
                                busList.get(BusToBeUpdated).setBusNumber(updatedBusNumber);
                                break;
                            case 2:
                                System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                                String updatedFromCity = scanner.next();
                                busList.get(BusToBeUpdated).setFromCity(updatedFromCity);
                                break;
                            case 3:
                                System.out.println("Enter the new Bus Destination that has to be updated: ");
                                String updatedToCity = scanner.next();
                                busList.get(BusToBeUpdated).setToCity(updatedToCity);
                                break;
                            case 4:
                                System.out.println("Enter the new Capacity that has to be updated: ");
                                int updatedBusCapacity = scanner.nextInt();
                                busList.get(BusToBeUpdated).setBusCapacity(updatedBusCapacity);
                                break;
                            case 5:
                                System.out.println("Enter the new Facility that has to be updated: ");
                                String updatedBusFacility = scanner.next();
                                busList.get(BusToBeUpdated).setBusFacility(updatedBusFacility);
                                break;
                            case 6:
                                System.out.println("Enter the new Cost that has to be updated: ");
                                double updatedBusTicketCost = scanner.nextDouble();
                                busList.get(BusToBeUpdated).setCostOfTicket(updatedBusTicketCost);
                                break;
                            default:
                                System.out.println("Getting out from admin panel");
                                break;
                        }
                        System.out.println("The new bus list after updation is:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 3) {
                        System.out.println("Deleting the Bus...");
                        // Displaying the BusInfo along with index as unique number
                        int index = 0;
                        for (BusInfo b : busList) {
                            System.out.print("Index Number: " + index++ + "| ");
                            b.DisplayBusInfo();
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter the index number of the Bus that has to be removed.");
                        int BusToBeRemoved = scanner.nextInt();
                        busList.remove(BusToBeRemoved);
                        // Displaying the BusList after removing
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("The updated bus list after removal is:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 4) {
                        System.out.println("The following buses are available:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else {
                        System.out.println("Logging out from admin portal...!");
                    }
                } else {
                    System.out.println("The key is incorrect. Forgot Pin? Click 1");
                    int ForgotPinOption = scanner.nextInt();
                    if (ForgotPinOption == 1) {
                        Main b = new Main();
                        System.out.println("The Hint for PIN is:\n" + b.ForgetAdminKey());
                    }
                }
            } else {
                System.out.println("Quiting the application");
            }
        }
    }
}