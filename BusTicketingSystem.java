import java.text.*;
import java.util.*;

public class BusTicketingSystem {
    public static void main(String [] args) {
        // ArrayList for BusInfo 
        ArrayList<BusInfo> busList = new ArrayList<>();
        ArrayList<PassengerInfo> passengerList = new ArrayList<>();
        //Adding the default buses into ArrayList
        busList.add(new BusInfo(1001, "Chennai", "Thanjavur", 4, "AC", 750));
        busList.add(new BusInfo(1012, "Thanjavur", "Chennai", 32, "Sleeper", 600));
        busList.add(new BusInfo(1053, "Chennai", "Trichy", 20, "Semi-Sleeper", 400));
        busList.add(new BusInfo(1055, "Trichy", "Chennai", 20, "Normal", 250));
        busList.add(new BusInfo(2122, "Trichy", "Thanjavur", 30, "Sleeper", 275));
        busList.add(new BusInfo(2222, "Thanjavur", "Trichy", 22, "Normal", 150));
        // Option given by User
        int SelectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================================== Welcome to Bus Ticketing System ========================================");
        System.out.println("======================================== Total Buses are displayed below ========================================");

        // ForEach loop to fetch the elements from array list
        for (BusInfo b : busList) {
            b.DisplayBusInfo();
        }
        // Loop for the Application
        while (SelectedOption == 1 || SelectedOption == 2) {
            //Main Booking
            System.out.println("=================================================================================================================");
            System.out.println("Enter option: \n1: Start a new Booking \n2: Login as Admin \n3: Quit\n");
            SelectedOption = scanner.nextInt();
            if (SelectedOption == 1) {
                PassengerInfo ticketForPassenger = new PassengerInfo();
                if (ticketForPassenger.IsAvailable(passengerList, busList)) {
                    passengerList.add(ticketForPassenger);
                    System.out.println("=================================================================================================================");
                    System.out.println("Reservation Status: Success!");
                    String PassengerName = ticketForPassenger.getPassengerName();
                    System.out.println("Passenger Name: " + PassengerName);
                    String PassengerIdNumber = ticketForPassenger.getPassengerIdNumber();
                    System.out.println("Aadhar Number: " + PassengerIdNumber);
                    Date DateOfJourney = ticketForPassenger.getDateOfJourney();
                    DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                    String FormattedDate = dateFormatter.format(DateOfJourney);
                    System.out.println("Date Of Journey: " + FormattedDate);
                    int BusNumber = ticketForPassenger.getBusNumber();
                    System.out.println("Bus Number: " + BusNumber);
                    String FromCity = ticketForPassenger.getFromCity(passengerList, busList);
                    System.out.println("Boarding: " + FromCity);
                    String ToCity = ticketForPassenger.getToCity(passengerList, busList);
                    System.out.println("Destination: " + ToCity);
                    // Displaying the cost of ticket after tax calculation
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                    System.out.println("Bill amount for the ticket is displayed below: ");
                    int TotalNumberOfSeats = ticketForPassenger.getTotalNumberOfSeats();
                    System.out.println("Total No:of Seats: " + TotalNumberOfSeats);
                    double TicketAmount = ticketForPassenger.getCostOfTicket(passengerList, busList);
                    double TaxPercentage = PassengerInfo.TaxPercentage*100;
                    double TaxAmount = ticketForPassenger.getTaxOfTicket(passengerList, busList);
                    double TotalAmountPerTicket = ticketForPassenger.getTotalCostOfTicket(passengerList, busList);
                    double TotalAmount = ticketForPassenger.getTotalCost(passengerList, busList);
                    System.out.println("Ticket Cost: " + TicketAmount);
                    System.out.println("Tax Percentage: " + TaxPercentage + "%");
                    System.out.println("Tax amount: " + TaxAmount);
                    System.out.println("The Total Cost per Ticket: " + TotalAmountPerTicket);
                    System.out.println("The Total Cost: " + TotalAmount);
                    System.out.println("=================================================================================================================");
                } else {
                    System.out.println("Ticket is not available for the date selected. Book in different Bus/Date");
                }
            // Admin Portal
            } else if (SelectedOption == 2) {
                int AdminKey = 123;
                System.out.println("Entering into Admin Login...");
                System.out.println("Enter the pin to proceed: ");
                int pinNumber = scanner.nextInt();
                if (AdminKey == pinNumber) {
                    System.out.println("The key is correct...Redirecting to Admin portal");
                    //To display the list of Bus to the admin
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                    System.out.println("The following buses are available:");
                    for (BusInfo b : busList) {
                        b.DisplayBusInfo();
                    }
                    //Operations which can be performed by the admin
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                    System.out.println("Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \nEnter any other number to logout");
                    int OperationOption = scanner.nextInt();
                    //Adding new Bus
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
                        //Displaying the list of buses after adding
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("The updated bus list is given below:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 2) {
                        System.out.println("Editing the Bus...");
                        //Displaying the BusInfo along with index as unique number
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        int index = 0;
                        for (BusInfo b : busList) {
                            System.out.print("Index Number: " + index++ + "| ");
                            b.DisplayBusInfo();
                        }
                        //Getting the index number that has to be updated from user
                        System.out.println("Enter the Index number of the bus to be updated: ");
                        int BusToBeUpdated = scanner.nextInt();
                        //Asking for the field that has to be updated
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
                        //Displaying the BusInfo along with index as unique number
                        int index = 0;
                        for (BusInfo b : busList) {
                            System.out.print("Index Number: " + index++ + "| ");
                            b.DisplayBusInfo();
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("Enter the index number of the Bus that has to be removed.");
                        int BusToBeRemoved = scanner.nextInt();
                        busList.remove(BusToBeRemoved);
                        //Displaying the BusList after removing
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("The updated bus list after removal is:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
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