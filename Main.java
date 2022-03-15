import java.text.*;
import java.util.*;
import java.io.*;

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
                // Filtering Bus List based on From and To
                ticketForPassenger.FilterBusList(passengerList, busList);
                ticketForPassenger.DisplayFilteredBusList(passengerList, busList);
                // Checking if the filtered bus list is empty or not based upon from to request from user
                if (ticketForPassenger.IsFilteredBusListEmpty(passengerList, busList) == false) {
                    ticketForPassenger.GetDateOfJourneyFromUser();
                    // Displaying remaining seats for the date enetered by user
                    int AvailableSeats = ticketForPassenger.DisplayRemainingSeats(passengerList, busList);
                    DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                    String FormattedDate = dateFormatter.format(ticketForPassenger.getDateOfJourney());
                    boolean IsDateFuture = ticketForPassenger.IsDateFuture(FormattedDate, "dd/MM/yyyy");
                    if (IsDateFuture) {
                        ticketForPassenger.DrawLine();
                        System.out.println("\033[0;1m" + "The no:of seats available for Bus Number " + ticketForPassenger.getBusNumber() + " on " + FormattedDate + " is: " + "\033[0;0m" + AvailableSeats);
                        ticketForPassenger.DrawLine();
                        // Checking if seats are available
                        if (AvailableSeats > 0) {
                            System.out.println("Enter number 1: To continue booking in this bus. \nEnter any other number: To start a new booking. ");
                            int ContinueBooking = scanner.nextInt();
                            if (ContinueBooking == 1) {
                                ticketForPassenger.GetOtherPassengerInfo();
                                // Checking whether the user requesting seats less than or equal to the
                                // available number of seats
                                if (ticketForPassenger.IsAvailable(passengerList, busList) == true) {
                                    // Adding passenger to the reserved list
                                    passengerList.add(ticketForPassenger);
                                    // Mapping the ticket details
                                    String GeneratedTicketID = ticketForPassenger.generateTicketID();
                                    ticketForPassenger.setTicketID(GeneratedTicketID);
                                    String PassengerName = ticketForPassenger.getPassengerName();
                                    String PassengerIdNumber = ticketForPassenger.getPassengerIdNumber();
                                    Date DateOfJourney = ticketForPassenger.getDateOfJourney();
                                    dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                                    FormattedDate = dateFormatter.format(DateOfJourney);
                                    int BusNumber = ticketForPassenger.getBusNumber();
                                    String FromCity = ticketForPassenger.getFromCity(passengerList, busList);
                                    String ToCity = ticketForPassenger.getToCity(passengerList, busList);
                                    // Displaying Ticket
                                    ticketForPassenger.DisplayTicket(GeneratedTicketID, PassengerName, PassengerIdNumber, FormattedDate, BusNumber, FromCity, ToCity);
                                    // Mapping the details for bill
                                    int TotalNumberOfSeats = ticketForPassenger.getTotalNumberOfSeats();
                                    double TicketAmount = ticketForPassenger.getCostOfTicket(passengerList, busList);
                                    double TaxPercentage = PassengerInfo.TaxPercentage * 100;
                                    double TaxAmount = ticketForPassenger.getTaxOfTicket(passengerList, busList);
                                    double TotalAmountPerTicket = ticketForPassenger.getTotalCostOfTicket(passengerList, busList);
                                    double TotalAmount = ticketForPassenger.getTotalCost(passengerList, busList);
                                    // Displaying the cost of ticket after tax calculation
                                    ticketForPassenger.DisplayBill(TotalNumberOfSeats, TicketAmount, TaxPercentage, TaxAmount, TotalAmountPerTicket, TotalAmount);
                                } else { // else block for requesting more seats
                                    System.out.println("You have requested for more seats than available seats, Try to enter the available seats properly.");
                                }
                            } else { // else block for start a new booking if the available seats is not enough
                                System.out.println("Redirecting...");
                            }
                        } else { // else block if seats are not available
                            System.out.println("As there are no seats available for the date selected, try in different Bus/Date");
                        }
                    } else {
                        System.out.println("The booking is over for the specified date, enter a future date.");
                    }
                } else { // else block if the user requested other areas than the service areas
                    System.out.println("Service is not available in those areas, try \nChennai \nThanjavur \nTrichy");
                }
                // Admin Portal
            } else if (SelectedOption == 2) {
                AdminInfo adminInfo = new AdminInfo();
                String AdminKey = adminInfo.getAdminKey();
                // Using console to read admin pin as invisible
                Console console = System.console();
                System.out.println("Entering into Admin Login...");
                char[] readPin = console.readPassword("Enter the pin to proceed: ");
                String PinNum = new String(readPin);
                // Checking if the pin is correct
                if (AdminKey.equals(PinNum) == true) {
                    System.out.println("The key is correct...Redirecting to Admin portal");
                    // To display the list of Bus to the admin
                    adminInfo.DrawLine();
                    System.out.println("The following buses are available:");
                    for (BusInfo b : busList) {
                        b.DisplayBusInfo();
                    }
                    // Operations which can be performed by the admin
                    adminInfo.DrawLine();
                    System.out.println("Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \n4.Display Bookings \n5.Display all the buses\nEnter any other number to logout");
                    int OperationOption = scanner.nextInt();
                    // Adding new Bus
                    if (OperationOption == 1) {
                        adminInfo.AddNewBus();
                        int newBusNumber = adminInfo.getBusNumber();
                        String newFromCity = adminInfo.getFromCity();
                        String newToCity = adminInfo.getToCity();
                        int newBusCapacity = adminInfo.getBusCapacity();
                        String newBusFacility = adminInfo.getBusFacility();
                        double newCostOfTicket = adminInfo.getCostOfTicket();
                        busList.add(new BusInfo(newBusNumber, newFromCity, newToCity, newBusCapacity, newBusFacility, newCostOfTicket));
                        // Displaying the list of buses after adding
                        adminInfo.DrawLine();
                        System.out.println("The updated bus list is given below:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 2) {
                        System.out.println("Editing the Bus...");
                        // Displaying the BusInfo along with index as unique number
                        adminInfo.DrawLine();
                        int index = 0;
                        for (BusInfo b : busList) {
                            System.out.print("Index Number: " + index++ + "| ");
                            b.DisplayBusInfo();
                        }
                        adminInfo.DrawLine();
                        // Getting the index number that has to be updated from user
                        System.out.println("Enter the Index number of the bus to be updated: ");
                        int BusToBeUpdated = scanner.nextInt();
                        // Asking for the field that has to be updated
                        adminInfo.DrawLine();
                        System.out.println("Select the option of the field which has to be updated: ");
                        System.out.println("1.Bus Number \n2.From City \n3.To City \n4.Bus Capacity \n5.Bus Facility \n6.Cost of the ticket \nEnter any other number to quit");
                        int OptionToBeUpdated = scanner.nextInt();
                        switch (OptionToBeUpdated) {
                            case 1:
                                adminInfo.EditBusNumber();
                                int updatedBusNumber = adminInfo.getBusNumber();
                                busList.get(BusToBeUpdated).setBusNumber(updatedBusNumber);
                                break;
                            case 2:
                                adminInfo.EditFromCity();
                                String updatedFromCity = adminInfo.getFromCity();
                                busList.get(BusToBeUpdated).setFromCity(updatedFromCity);
                                break;
                            case 3:
                                adminInfo.EditToCity();
                                String updatedToCity = adminInfo.getToCity();
                                busList.get(BusToBeUpdated).setToCity(updatedToCity);
                                break;
                            case 4:
                                adminInfo.EditBusCapacity();
                                int updatedBusCapacity = adminInfo.getBusCapacity();
                                busList.get(BusToBeUpdated).setBusCapacity(updatedBusCapacity);
                                break;
                            case 5:
                                adminInfo.EditBusFacility();
                                String updatedBusFacility = adminInfo.getBusFacility();
                                busList.get(BusToBeUpdated).setBusFacility(updatedBusFacility);
                                break;
                            case 6:
                                adminInfo.EditBusTicketCost();
                                double updatedBusTicketCost = adminInfo.getCostOfTicket();
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
                        adminInfo.DrawLine();
                        System.out.println("Enter the index number of the Bus that has to be removed.");
                        int BusToBeRemoved = scanner.nextInt();
                        busList.remove(BusToBeRemoved);
                        // Displaying the BusList after removing
                        adminInfo.DrawLine();
                        System.out.println("The updated bus list after removal is:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 4) {
                        System.out.println("\033[0;1m" + "================================================= BOOKINGS ======================================================" + "\033[0;0m");
                        for (PassengerInfo p : passengerList) {
                            p.DisplayBookings(p.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.getBusNumber(), p.getFormattedDateOfJourney(), p.getTotalNumberOfSeats(), p.getFromCity(), p.getToCity(), p.getTotalCost(passengerList, busList));
                        }
                    } else if (OperationOption == 5) {
                        System.out.println("The following buses are available:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else { // if OperationOption is other than 1,2,3,4,5
                        System.out.println("Logging out from admin portal...!");
                    }
                } else { // else block for wrong pin
                    System.out.println("The key is incorrect. Forgot Pin? Click 1");
                    int ForgotPinOption = scanner.nextInt();
                    if (ForgotPinOption == 1) {
                        Main b = new Main();
                        System.out.println("The Hint for PIN is:\n" + b.ForgetAdminKey());
                    }
                }
            } else { // else block for quit i.e SelectedOption any other number
                System.out.println("Quiting the application");
            }
        }
    }
}