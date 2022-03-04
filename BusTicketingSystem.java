import java.util.*;

public class BusTicketingSystem {
    public static void main(String [] args) {
        // ArrayList for BusInfo 
        ArrayList<BusInfo> busList = new ArrayList<>();
        ArrayList<PassengerInfo> passengerList = new ArrayList<>();
        //Adding new buses into ArrayList
        busList.add(new BusInfo(1001, 2, "AC", 750));
        busList.add(new BusInfo(1012, 32, "Sleeper", 600));
        busList.add(new BusInfo(1053, 20, "Semi-Sleeper", 400));
        busList.add(new BusInfo(1055, 20, "Normal", 250));
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
                    //Displaying the cost of ticket after tax calculation 
                    double Price = ticketForPassenger.getCostOfTicket(passengerList, busList);
                    System.out.println("The Cost of the Ticket after including GST is:" + Price);

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
                        double newCostOfTicket = scanner.nextDouble();
                        busList.add(new BusInfo(newBusNumber, newBusCapacity, newBusFacility, newCostOfTicket));
                        //Displaying the list of buses after adding
                        System.out.println("The updated bus list is given below:");
                        for (BusInfo b : busList) {
                            b.DisplayBusInfo();
                        }
                    } else if (OperationOption == 2) {
                        System.out.println("Editing the Bus...");
                        //Displaying the BusInfo along with index as unique number
                        int index = 0;
                        for (BusInfo b : busList) {
                            System.out.print("Unique Number: " + index++ + "| ");
                            b.DisplayBusInfo();
                        }
                        //Getting the index number that has to be updated from user
                        System.out.println("Enter the Unique number of the bus to be updated: ");
                        int BusToBeUpdated = scanner.nextInt();
                        //Asking for the field that has to be updated
                        System.out.println("Select the option of the field which has to be updated: ");
                        System.out.println("1.Bus Number \n2.Bus Capacity \n3.Bus Facility \n4.Cost of the ticket \nEnter any other number to quit");
                        int OptionToBeUpdated = scanner.nextInt();
                        if (OptionToBeUpdated == 1) {
                            System.out.println("Enter the new Bus Number that has to be updated: ");
                            int updatedBusNumber = scanner.nextInt();
                            busList.get(BusToBeUpdated).setBusNumber(updatedBusNumber);
                        } else if (OptionToBeUpdated == 2) {
                            System.out.println("Enter the new Capacity that has to be updated: ");
                            int updatedBusCapacity = scanner.nextInt();
                            busList.get(BusToBeUpdated).setBusCapacity(updatedBusCapacity);
                        } else if (OptionToBeUpdated == 3) {
                            System.out.println("Enter the new Facility that has to be updated: ");
                            String updatedBusFacility = scanner.next();
                            busList.get(BusToBeUpdated).setBusFacility(updatedBusFacility);
                        } else if (OptionToBeUpdated == 4) {
                            System.out.println("Enter the new Cost that has to be updated: ");
                            double updatedBusTicketCost = scanner.nextDouble();
                            busList.get(BusToBeUpdated).setCostOfTicket(updatedBusTicketCost);
                        } else {
                            System.out.println("Getting out from admin panel");
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
                            System.out.print("Unique Number: " + index++ + "| ");
                            b.DisplayBusInfo();
                        }
                        System.out.println("Enter the unique number of the Bus that has to be removed.");
                        int BusToBeRemoved = scanner.nextInt();
                        busList.remove(BusToBeRemoved);
                        //Displaying the BusList after removing
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