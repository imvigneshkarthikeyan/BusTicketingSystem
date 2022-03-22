import java.util.*;
import java.io.*;

interface BusOperations {
    void addNewBus();
    void editBus();
    void deleteBus();
    void displayBusList();
}

class AdminInfo implements DisplayInformation, BusOperations {
    Scanner scanner = new Scanner(System.in);

    // Declaring it as final, as it should not be modified
    private final String ADMIN_KEY = "123";

    public String getAdminKey() {
        return ADMIN_KEY;
    }

    public String forgetAdminKey() {
        String hintForAdminKey = "Its a 3 digit pin.";
        return hintForAdminKey;
    }

    // ArrayList for Buses
    private ArrayList<BusInfo> busList = new ArrayList<BusInfo>() {
        // Adding the default buses into ArrayList
        {
            add(new SpecialBusInfo(1001, "Chennai", "Thanjavur", 20, "AC", 750, 2));
            add(new BusInfo(3313, "Chennai", "Thanjavur", 40, 350, 3));
            add(new SpecialBusInfo(3132, "Chennai", "Thanjavur", 30, "Sleeper", 600, 4));
            add(new SpecialBusInfo(1010, "Thanjavur", "Chennai", 20, "AC", 750, 4));
            add(new SpecialBusInfo(3123, "Thanjavur", "Chennai", 30, "Sleeper", 600, 3));
            add(new BusInfo(3331, "Thanjavur", "Chennai", 40, 350, 6));
            add(new SpecialBusInfo(1052, "Chennai", "Trichy", 40, "Semi-Sleeper", 400, 4));
            add(new SpecialBusInfo(1053, "Chennai", "Trichy", 30, "Sleeper", 550, 3));
            add(new BusInfo(1054, "Chennai", "Trichy", 20, 750, 5));
            add(new BusInfo(1025, "Trichy", "Chennai", 40, 400, 5));
            add(new SpecialBusInfo(1035, "Trichy", "Chennai", 30, "Sleeper", 550, 5));
            add(new SpecialBusInfo(1045, "Trichy", "Chennai", 20, "AC", 750, 3));
            add(new SpecialBusInfo(2134, "Trichy", "Thanjavur", 30, "Sleeper", 550, 1));
            add(new SpecialBusInfo(2135, "Trichy", "Thanjavur", 20, "AC", 600, 2));
            add(new BusInfo(2136, "Trichy", "Thanjavur", 40, 350, 2));
            add(new SpecialBusInfo(2143, "Thanjavur", "Trichy", 30, "Sleeper", 550, 3));
            add(new SpecialBusInfo(2153, "Thanjavur", "Trichy", 20, "AC", 600, 4));
            add(new BusInfo(2163, "Thanjavur", "Trichy", 40, 350, 1));
        }
    };

    public ArrayList<BusInfo> getBusList() {
        return busList;
    }

    public void setBusList(ArrayList<BusInfo> busList) {
        this.busList = busList;
    }

    // ArrayList for filteredbusList
    private ArrayList<BusInfo> filteredBusList = new ArrayList<>();

    public ArrayList<BusInfo> getFilteredBusList() {
        return filteredBusList;
    }

    public void setFilteredBusList(ArrayList<BusInfo> filteredBusList) {
        this.filteredBusList = filteredBusList;
    }

    // ArrayList for Passenger List
    private ArrayList<PassengerInfo> passengerList = new ArrayList<>();

    public ArrayList<PassengerInfo> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<PassengerInfo> passengerList) {
        this.passengerList = passengerList;
    }

    //FilterList For Special Bus
    private ArrayList<BusInfo> filteredSpecialBusList = new ArrayList<>();

    public ArrayList<BusInfo> getFilteredSpecialBusList() {
        return filteredSpecialBusList;
    }

    public void setFilteredSpecialBusList(ArrayList<BusInfo> filteredSpecialBusList) {
        this.filteredSpecialBusList = filteredSpecialBusList;
    }

    //Filtering Special Bus
    public void filterSpecialBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : getBusList()) {
            if (bus instanceof SpecialBusInfo){
                getFilteredSpecialBusList().add(bus);
            }
        }
    }

    public void drawDoubleLine() {
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
    }

    public void drawLine() {
        System.out.println("\033[0;1m" + "-----------------------------------------------------------------------------------------------------------------" + "\033[0;0m");
    }

    // Welcome message
    public void displayWelcomeMessage() {
        drawDoubleLine();
        System.out.println("\033[0;1m" + "======================================== Welcome to Bus Ticketing System ========================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "======================================== Total Buses are displayed below ========================================" + "\033[0;0m");
        drawDoubleLine();
    }

    public void displayOptionsMessage() {
        drawDoubleLine();
        System.out.println("\033[0;1m" + "Enter option:" + "\033[0;0m" + "\n1: Start a new Booking \n2: Login as Admin \nAny other number: Quit\n");
    }

    // Displaying BusList in a for each loop
    public void displayBusList() {
        drawDoubleLine();
        System.out.println("\033[0;1m" + "The following buses are available:" + "\033[0;0m");
        for (BusInfo b : getBusList()) {
            b.displayInfo();
        }
    }

    BusInfo busInfo = new BusInfo();
    SpecialBusInfo specialBus = new SpecialBusInfo();

    // Add NewBus for admin panel
    public void addNewBus() {
        System.out.println("Enter 1 to create a normal bus, enter any other number to create Luxury Bus");
        int busType = scanner.nextInt();
        if (busType == 1) { //To Add normal Bus
            System.out.println("Enter the Bus Number");
            busInfo.setBusNumber(scanner.nextInt());
            System.out.println("Enter the Travel Origin");
            busInfo.setFromCity(scanner.next());
            System.out.println("Enter the Destination");
            busInfo.setToCity(scanner.next());
            System.out.println("Enter the capacity of the bus");
            busInfo.setBusCapacity(scanner.nextInt());
            System.out.println("Enter the Cost of the ticket");
            busInfo.setCostOfTicket(scanner.nextDouble());
            System.out.println("Enter the Approximate Time for Journey");
            busInfo.setApproxJourneyHrs(scanner.nextInt());
            int newBusNumber = busInfo.getBusNumber();
            String newFromCity = busInfo.getFromCity();
            String newToCity = busInfo.getToCity();
            int newBusCapacity = busInfo.getBusCapacity();
            double newCostOfTicket = busInfo.getCostOfTicket();
            int newApproxJourneyHrs = busInfo.getApproxJourneyHrs();
            getBusList().add(new BusInfo(newBusNumber, newFromCity, newToCity, newBusCapacity, newCostOfTicket, newApproxJourneyHrs));
            // Displaying the list of buses after adding
            drawLine();
            displayBusList();
        } else{ // To add Special bus
            System.out.println("Enter the Bus Number");
            busInfo.setBusNumber(scanner.nextInt());
            System.out.println("Enter the Travel Origin");
            busInfo.setFromCity(scanner.next());
            System.out.println("Enter the Destination");
            busInfo.setToCity(scanner.next());
            System.out.println("Enter the capacity of the bus");
            busInfo.setBusCapacity(scanner.nextInt());
            System.out.println("Enter the Bus Facility");
            specialBus.setBusFacility(scanner.next());
            System.out.println("Enter the Cost of the ticket");
            busInfo.setCostOfTicket(scanner.nextDouble());
            System.out.println("Enter the Approximate Time for Journey");
            busInfo.setApproxJourneyHrs(scanner.nextInt());
            int newBusNumber = busInfo.getBusNumber();
            String newFromCity = busInfo.getFromCity();
            String newToCity = busInfo.getToCity();
            int newBusCapacity = busInfo.getBusCapacity();
            String newBusFacility = specialBus.getBusFacility();
            double newCostOfTicket = busInfo.getCostOfTicket();
            int newApproxJourneyHrs = busInfo.getApproxJourneyHrs();
            getBusList().add(new SpecialBusInfo(newBusNumber, newFromCity, newToCity, newBusCapacity, newBusFacility, newCostOfTicket, newApproxJourneyHrs));
            // Displaying the list of buses after adding
            drawLine();
            displayBusList();
        }        
    }

    // Displaying the BusInfo along with index number
    public void displayBusWithIndex() {
        drawLine();
        int index = 0;
        for (BusInfo b : getBusList()) {
            System.out.print("Index Number: " + index++ + "| ");
            b.displayInfo();
        }
        drawLine();
    }

    public void displaySpecialBusWithIndex() {
        drawLine();
        int index = 0;
        for (BusInfo b : getFilteredSpecialBusList()) {
            System.out.print("Index Number: " + index++ + "| ");
            b.displayInfo();
        }
        drawLine();
    }

    // EditBus for admin panel
    public void editBus() {
        System.out.println("Editing the Bus...");
        System.out.println("Enter 1: To edit Luxury Bus \nEnter any other number: To edit Normal Bus");
        int editBusOption = scanner.nextInt();
        if (editBusOption == 1) {
            filterSpecialBusList(getPassengerList(), getBusList());
            displaySpecialBusWithIndex();
            // Getting the index number that has to be updated from user
            System.out.println("Enter the Index number of the bus to be updated: ");
            int busToBeUpdated = scanner.nextInt();
            // Asking for the field that has to be updated
            drawLine();
            System.out.println("Select the option of the field which has to be updated: ");
            System.out.println("1.Bus Number \n2.From City \n3.To City \n4.Bus Capacity \n5.Bus Facility \n6.Cost of the ticket \n7.Approx Journey Hours \nEnter any other number to quit");
            int optionToBeUpdated = scanner.nextInt();
            switch (optionToBeUpdated) {
                case 1:
                    System.out.println("Enter the new Bus Number that has to be updated: ");
                    busInfo.setBusNumber(scanner.nextInt());
                    int updatedBusNumber = busInfo.getBusNumber();
                    getBusList().get(busToBeUpdated).setBusNumber(updatedBusNumber);
                    break;
                case 2:
                    System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                    busInfo.setFromCity(scanner.next());
                    String updatedFromCity = busInfo.getFromCity();
                    getBusList().get(busToBeUpdated).setFromCity(updatedFromCity);
                    break;
                case 3:
                    System.out.println("Enter the new Bus Destination that has to be updated: ");
                    busInfo.setToCity(scanner.next());
                    String updatedToCity = busInfo.getToCity();
                    getBusList().get(busToBeUpdated).setToCity(updatedToCity);
                    break;
                case 4:
                    System.out.println("Enter the new Capacity that has to be updated: ");
                    busInfo.setBusCapacity(scanner.nextInt());
                    int updatedBusCapacity = busInfo.getBusCapacity();
                    getBusList().get(busToBeUpdated).setBusCapacity(updatedBusCapacity);
                    break;
                case 5:
                    System.out.println("Enter the new Bus Facility that has to be updated: ");
                    specialBus.setBusFacility(scanner.next());
                    String updatedBusFacility = specialBus.getBusFacility();
                    ((SpecialBusInfo) getBusList().get(busToBeUpdated)).setBusFacility(updatedBusFacility);
                    break;
                case 6:
                    System.out.println("Enter the new Cost that has to be updated: ");
                    busInfo.setCostOfTicket(scanner.nextInt());
                    double updatedBusTicketCost = busInfo.getCostOfTicket();
                    getBusList().get(busToBeUpdated).setCostOfTicket(updatedBusTicketCost);
                    break;
                case 7:
                    System.out.println("Enter the new approximate journey in hrs: ");
                    busInfo.setApproxJourneyHrs(scanner.nextInt());
                    int updatedApproxJourneyHrs = busInfo.getApproxJourneyHrs();
                    getBusList().get(busToBeUpdated).setApproxJourneyHrs(updatedApproxJourneyHrs);
                    break;
                default:
                    System.out.println("Getting out from admin panel");
                    break;
            }
            displayBusList();
        } else {
            displayBusWithIndex();
            // Getting the index number that has to be updated from user
            System.out.println("Enter the Index number of the bus to be updated: ");
            int busToBeUpdated = scanner.nextInt();
            // Asking for the field that has to be updated
            drawLine();
            System.out.println("Select the option of the field which has to be updated: ");
            System.out.println("1.Bus Number \n2.From City \n3.To City \n4.Bus Capacity \n5.Cost of the ticket \n6. Approx Journey Hrs \nEnter any other number to quit");
            int optionToBeUpdated = scanner.nextInt();
            switch (optionToBeUpdated) {
                case 1:
                    System.out.println("Enter the new Bus Number that has to be updated: ");
                    busInfo.setBusNumber(scanner.nextInt());
                    int updatedBusNumber = busInfo.getBusNumber();
                    getBusList().get(busToBeUpdated).setBusNumber(updatedBusNumber);
                    break;
                case 2:
                    System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                    busInfo.setFromCity(scanner.next());
                    String updatedFromCity = busInfo.getFromCity();
                    getBusList().get(busToBeUpdated).setFromCity(updatedFromCity);
                    break;
                case 3:
                    System.out.println("Enter the new Bus Destination that has to be updated: ");
                    busInfo.setToCity(scanner.next());
                    String updatedToCity = busInfo.getToCity();
                    getBusList().get(busToBeUpdated).setToCity(updatedToCity);
                    break;
                case 4:
                    System.out.println("Enter the new Capacity that has to be updated: ");
                    busInfo.setBusCapacity(scanner.nextInt());
                    int updatedBusCapacity = busInfo.getBusCapacity();
                    getBusList().get(busToBeUpdated).setBusCapacity(updatedBusCapacity);
                    break;
                case 5:
                    System.out.println("Enter the new Cost that has to be updated: ");
                    busInfo.setCostOfTicket(scanner.nextInt());
                    double updatedBusTicketCost = busInfo.getCostOfTicket();
                    getBusList().get(busToBeUpdated).setCostOfTicket(updatedBusTicketCost);
                    break;
                case 6:
                    System.out.println("Enter the new approximate journey in hrs: ");
                    busInfo.setApproxJourneyHrs(scanner.nextInt());
                    int updatedApproxJourneyHrs = busInfo.getApproxJourneyHrs();
                    getBusList().get(busToBeUpdated).setApproxJourneyHrs(updatedApproxJourneyHrs);
                    break;
                default:
                    System.out.println("Getting out from admin panel");
                    break;
            }
            displayBusList();
        }
    }

    // Delete bus for admin panel
    public void deleteBus() {
        System.out.println("Deleting the Bus...");
        displayBusWithIndex();
        System.out.println("Enter the index number of the Bus that has to be removed.");
        int busToBeRemoved = scanner.nextInt();
        getBusList().remove(busToBeRemoved);
        // Displaying the BusList after removing
        drawLine();
        displayBusList();
    }

    @Override// Show Bookings
    public void displayInfo() {
        System.out.println("\033[0;1m" + "================================================= BOOKINGS ======================================================" + "\033[0;0m");
        for (PassengerInfo p : getPassengerList()) {
            p.displayBookings(p.ticketInfo.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.ticketInfo.getBusNumber(), p.getFormattedDateOfJourney(), p.ticketInfo.getTotalNumberOfSeats(), p.ticketInfo.getFromCity(), p.ticketInfo.getToCity(), p.getTotalCost(getPassengerList(), getBusList()));
        }
    }

    // Authentication for Admin PIN
    public String ReadPINinConsole() {
        // Using console to read admin pin as invisible
        Console console = System.console();
        System.out.println("Entering into Admin Login...");
        char[] readPin = console.readPassword("Enter the pin to proceed: ");
        String pinNum = new String(readPin);
        return pinNum;
    }

    // ForgotPin
    public void forgotPIN() {
        System.out.println("The key is incorrect. Forgot Pin? Click 1");
        int forgotPinOption = scanner.nextInt();
        if (forgotPinOption == 1) {
            System.out.println("The Hint for PIN is:\n" + forgetAdminKey());
        }
    }

    //Admin's Function
    public void adminFunction() {
        drawLine();
        displayBusList();
        drawLine();
        // Operations which can be performed by the admin
        System.out.println("Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \n4.Display Bookings \n5.Display all the buses\nEnter any other number to logout");
        int operationOption = scanner.nextInt();
        // Adding new Bus
        switch (operationOption) {
            case 1:
                addNewBus();
                break;
            case 2:
                editBus();
                break;
            case 3:
                deleteBus();
                break;
            case 4:
                displayInfo();
                break;
            case 5:
                displayBusList();
                break;
            default:
                System.out.println("Logging out from admin portal...!");
                break;
        }
    }

    //Login as Admin & Admin Operation
    public void adminOperations() {
        String adminKey = getAdminKey();
        // Using console to read admin pin as invisible
        String pinNum = ReadPINinConsole();
        // Checking if the pin is correct
        if (adminKey.equals(pinNum) == true) {
            System.out.println("The key is correct...Redirecting to Admin portal");
            adminFunction();
        } else { // else block for wrong pin
            forgotPIN();
        }
    }

    //Start a new booking
    public void startNewBooking() {
        PassengerInfo ticketForPassenger = new PassengerInfo();
        // Filtering Bus List based on From and To
        ticketForPassenger.filterBusList(getPassengerList(), getBusList());
        ticketForPassenger.displayFilteredBusList(getPassengerList(), getBusList());
        // Checking if the filtered bus list is empty or not based upon from to request from user
        if (ticketForPassenger.isFilteredBusListEmpty(getPassengerList(), getBusList()) == false) {
            ticketForPassenger.showSortingFunctions();
            ticketForPassenger.getBusNumberFromUser();
            ticketForPassenger.getDateOfJourneyFromUser();
            // Displaying remaining seats for the date enetered by user
            int availableSeats = ticketForPassenger.displayRemainingSeats(getPassengerList(), getBusList());
            String formattedDate = ticketForPassenger.getFormattedDateOfJourney();
            boolean isDateFuture = ticketForPassenger.isDateFuture(formattedDate, "dd/MM/yyyy");
            while (isDateFuture == false) {
                System.out.println("The booking is over for the specified date, enter a future date.");
                ticketForPassenger.getDateOfJourneyFromUser();
                formattedDate = ticketForPassenger.getFormattedDateOfJourney();
                isDateFuture = ticketForPassenger.isDateFuture(formattedDate, "dd/MM/yyyy");
            }
            drawLine();
            System.out.println("\033[0;1m" + "The no:of seats available for Bus Number " + ticketForPassenger.ticketInfo.getBusNumber() + " on " + formattedDate + " is: " + "\033[0;0m" + availableSeats);
            drawLine();
            // Checking if seats are available
            if (availableSeats > 0) {
                System.out.println("\033[0;1m" + "Enter number 1:" + "\033[0;0m" + "To continue booking in this bus" + "\033[0;1m" + "\nEnter any other number:" + "\033[0;0m" + "To start a new booking.");
                int continueBooking = scanner.nextInt();
                if (continueBooking == 1) {
                    ticketForPassenger.getOtherPassengerInfo();
                    ticketForPassenger.getSeatsRequired();
                    // Checking whether the user requesting seats less than or equal to the available number of seats
                    while (ticketForPassenger.isAvailable(getPassengerList(), getBusList()) == false) {
                        System.out.println("You have requested for more seats than available seats, Try to enter the available seats properly.");
                        ticketForPassenger.getSeatsRequired();
                    } // Adding passenger to the reserved list
                    getPassengerList().add(ticketForPassenger);
                    // Mapping the ticket details
                    ticketForPassenger.MapAndDisplayTicketDetails();
                    // // Mapping the details for bill
                    ticketForPassenger.MapAndDisplayBillDetails();
                } else { // else block for start a new booking if the available seats is not enough
                    System.out.println("Redirecting...");
                }
            } else { // else block if seats are not available
                System.out.println("As there are no seats available for the date selected, try in different Bus/Date");
            }
        } else { // else block if the user requested other areas than the service areas
            System.out.println("Service is not available in those areas, try \nChennai \nThanjavur \nTrichy");
        }
    }
}