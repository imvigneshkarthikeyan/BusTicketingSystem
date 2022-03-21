import java.util.*;
import java.io.*;

interface Admin {
    void AddNewBus();
    void EditBus();
    void DeleteBus();
    void DisplayBusList();
}

class AdminInfo implements DisplayInformation, Admin {
    Scanner scanner = new Scanner(System.in);

    // Declaring it as final, as it should not be modified
    private final String AdminKey = "123";

    public String getAdminKey() {
        return AdminKey;
    }

    public String ForgetAdminKey() {
        String HintForAdminKey = "Its a 3 digit pin.";
        return HintForAdminKey;
    }

    // ArrayList for Buses
    private ArrayList<BusInfo> busList = new ArrayList<BusInfo>() {
        // Adding the default buses into ArrayList
        {
            add(new SpecialBusInfo(1001, "Chennai", "Thanjavur", 20, "AC", 750));
            add(new BusInfo(3313, "Chennai", "Thanjavur", 40, 350));
            add(new SpecialBusInfo(3132, "Chennai", "Thanjavur", 30, "Sleeper", 600));
            add(new SpecialBusInfo(1010, "Thanjavur", "Chennai", 20, "AC", 750));
            add(new SpecialBusInfo(3123, "Thanjavur", "Chennai", 30, "Sleeper", 600));
            add(new BusInfo(3331, "Thanjavur", "Chennai", 40, 350));
            add(new SpecialBusInfo(1052, "Chennai", "Trichy", 40, "Semi-Sleeper", 400));
            add(new SpecialBusInfo(1053, "Chennai", "Trichy", 30, "Sleeper", 550));
            add(new BusInfo(1054, "Chennai", "Trichy", 20, 750));
            add(new BusInfo(1025, "Trichy", "Chennai", 40, 400));
            add(new SpecialBusInfo(1035, "Trichy", "Chennai", 30, "Sleeper", 550));
            add(new SpecialBusInfo(1045, "Trichy", "Chennai", 20, "AC", 750));
            add(new SpecialBusInfo(2134, "Trichy", "Thanjavur", 30, "Sleeper", 550));
            add(new SpecialBusInfo(2135, "Trichy", "Thanjavur", 20, "AC", 600));
            add(new BusInfo(2136, "Trichy", "Thanjavur", 40, 350));
            add(new SpecialBusInfo(2143, "Thanjavur", "Trichy", 30, "Sleeper", 550));
            add(new SpecialBusInfo(2153, "Thanjavur", "Trichy", 20, "AC", 600));
            add(new BusInfo(2163, "Thanjavur", "Trichy", 40, 350));
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
    public void FilterSpecialBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : getBusList()) {
            if (bus instanceof SpecialBusInfo){
                getFilteredSpecialBusList().add(bus);
            }
        }
    }

    public void DrawDoubleLine() {
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
    }

    public void DrawLine() {
        System.out.println("\033[0;1m" + "-----------------------------------------------------------------------------------------------------------------" + "\033[0;0m");
    }

    // Welcome message
    public void DisplayWelcomeMessage() {
        DrawDoubleLine();
        System.out.println("\033[0;1m" + "======================================== Welcome to Bus Ticketing System ========================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "======================================== Total Buses are displayed below ========================================" + "\033[0;0m");
        DrawDoubleLine();
    }

    public void DisplayOptionsMessage() {
        DrawDoubleLine();
        System.out.println("\033[0;1m" + "Enter option:" + "\033[0;0m" + "\n1: Start a new Booking \n2: Login as Admin \nAny other number: Quit\n");
    }

    // Displaying BusList in a for each loop
    public void DisplayBusList() {
        DrawDoubleLine();
        System.out.println("\033[0;1m" + "The following buses are available:" + "\033[0;0m");
        for (BusInfo b : getBusList()) {
            b.DisplayInfo();
        }
    }

    BusInfo busInfo = new BusInfo();
    SpecialBusInfo specialBus = new SpecialBusInfo();

    // Add NewBus for admin panel
    public void AddNewBus() {
        System.out.println("Enter 1 to create a normal bus, enter any other number to create Luxury Bus");
        int busType = scanner.nextInt();
        if (busType == 1) { //To Add normal Bus
            System.out.println("Enter the Bus Number");
            int BusNumberToBeUpdated = scanner.nextInt();
            busInfo.setBusNumber(BusNumberToBeUpdated);
            System.out.println("Enter the Travel Origin");
            busInfo.setFromCity(scanner.next());
            System.out.println("Enter the Destination");
            busInfo.setToCity(scanner.next());
            System.out.println("Enter the capacity of the bus");
            busInfo.setBusCapacity(scanner.nextInt());
            System.out.println("Enter the Cost of the ticket");
            busInfo.setCostOfTicket(scanner.nextDouble());
            int newBusNumber = busInfo.getBusNumber();
            String newFromCity = busInfo.getFromCity();
            String newToCity = busInfo.getToCity();
            int newBusCapacity = busInfo.getBusCapacity();
            double newCostOfTicket = busInfo.getCostOfTicket();
            getBusList().add(new BusInfo(newBusNumber, newFromCity, newToCity, newBusCapacity, newCostOfTicket));
            // Displaying the list of buses after adding
            DrawLine();
            DisplayBusList();
        } else{ // To add Special bus
            System.out.println("Enter the Bus Number");
            int BusNumberToBeUpdated = scanner.nextInt();
            busInfo.setBusNumber(BusNumberToBeUpdated);
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
            int newBusNumber = busInfo.getBusNumber();
            String newFromCity = busInfo.getFromCity();
            String newToCity = busInfo.getToCity();
            int newBusCapacity = busInfo.getBusCapacity();
            String newBusFacility = specialBus.getBusFacility();
            double newCostOfTicket = busInfo.getCostOfTicket();
            getBusList().add(new SpecialBusInfo(newBusNumber, newFromCity, newToCity, newBusCapacity, newBusFacility,newCostOfTicket));
            // Displaying the list of buses after adding
            DrawLine();
            DisplayBusList();
        }        
    }

    // Displaying the BusInfo along with index number
    public void DisplayBusWithIndex() {
        DrawLine();
        int index = 0;
        for (BusInfo b : getBusList()) {
            System.out.print("Index Number: " + index++ + "| ");
            b.DisplayInfo();
        }
        DrawLine();
    }

    public void DisplaySpecialBusWithIndex() {
        DrawLine();
        int index = 0;
        for (BusInfo b : getFilteredSpecialBusList()) {
            System.out.print("Index Number: " + index++ + "| ");
            b.DisplayInfo();
        }
        DrawLine();
    }

    // EditBus for admin panel
    public void EditBus() {
        System.out.println("Editing the Bus...");
        System.out.println("Enter 1: To edit Luxury Bus \nEnter any other number: To edit Normal Bus");
        int editBusOption = scanner.nextInt();
        if (editBusOption == 1) {
            FilterSpecialBusList(getPassengerList(), getBusList());
            DisplaySpecialBusWithIndex();
            // Getting the index number that has to be updated from user
            System.out.println("Enter the Index number of the bus to be updated: ");
            int BusToBeUpdated = scanner.nextInt();
            // Asking for the field that has to be updated
            DrawLine();
            System.out.println("Select the option of the field which has to be updated: ");
            System.out.println("1.Bus Number \n2.From City \n3.To City \n4.Bus Capacity \n5.Bus Facility \n6.Cost of the ticket \nEnter any other number to quit");
            int OptionToBeUpdated = scanner.nextInt();
            switch (OptionToBeUpdated) {
                case 1:
                    System.out.println("Enter the new Bus Number that has to be updated: ");
                    busInfo.setBusNumber(scanner.nextInt());
                    int updatedBusNumber = busInfo.getBusNumber();
                    getBusList().get(BusToBeUpdated).setBusNumber(updatedBusNumber);
                    break;
                case 2:
                    System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                    busInfo.setFromCity(scanner.next());
                    String updatedFromCity = busInfo.getFromCity();
                    getBusList().get(BusToBeUpdated).setFromCity(updatedFromCity);
                    break;
                case 3:
                    System.out.println("Enter the new Bus Destination that has to be updated: ");
                    busInfo.setToCity(scanner.next());
                    String updatedToCity = busInfo.getToCity();
                    getBusList().get(BusToBeUpdated).setToCity(updatedToCity);
                    break;
                case 4:
                    System.out.println("Enter the new Capacity that has to be updated: ");
                    busInfo.setBusCapacity(scanner.nextInt());
                    int updatedBusCapacity = busInfo.getBusCapacity();
                    getBusList().get(BusToBeUpdated).setBusCapacity(updatedBusCapacity);
                    break;
                case 5:
                    System.out.println("Enter the new Bus Facility that has to be updated: ");
                    specialBus.setBusFacility(scanner.next());
                    String updatedBusFacility = specialBus.getBusFacility();
                    ((SpecialBusInfo) getBusList().get(BusToBeUpdated)).setBusFacility(updatedBusFacility);
                    break;
                case 6:
                    System.out.println("Enter the new Cost that has to be updated: ");
                    busInfo.setCostOfTicket(scanner.nextInt());
                    double updatedBusTicketCost = busInfo.getCostOfTicket();
                    getBusList().get(BusToBeUpdated).setCostOfTicket(updatedBusTicketCost);
                    break;
                default:
                    System.out.println("Getting out from admin panel");
                    break;
            }
            DisplayBusList();
        } else {
            DisplayBusWithIndex();
            // Getting the index number that has to be updated from user
            System.out.println("Enter the Index number of the bus to be updated: ");
            int BusToBeUpdated = scanner.nextInt();
            // Asking for the field that has to be updated
            DrawLine();
            System.out.println("Select the option of the field which has to be updated: ");
            System.out.println("1.Bus Number \n2.From City \n3.To City \n4.Bus Capacity \n5.Cost of the ticket \nEnter any other number to quit");
            int OptionToBeUpdated = scanner.nextInt();
            switch (OptionToBeUpdated) {
                case 1:
                    System.out.println("Enter the new Bus Number that has to be updated: ");
                    busInfo.setBusNumber(scanner.nextInt());
                    int updatedBusNumber = busInfo.getBusNumber();
                    getBusList().get(BusToBeUpdated).setBusNumber(updatedBusNumber);
                    break;
                case 2:
                    System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                    busInfo.setFromCity(scanner.next());
                    String updatedFromCity = busInfo.getFromCity();
                    getBusList().get(BusToBeUpdated).setFromCity(updatedFromCity);
                    break;
                case 3:
                    System.out.println("Enter the new Bus Destination that has to be updated: ");
                    busInfo.setToCity(scanner.next());
                    String updatedToCity = busInfo.getToCity();
                    getBusList().get(BusToBeUpdated).setToCity(updatedToCity);
                    break;
                case 4:
                    System.out.println("Enter the new Capacity that has to be updated: ");
                    busInfo.setBusCapacity(scanner.nextInt());
                    int updatedBusCapacity = busInfo.getBusCapacity();
                    getBusList().get(BusToBeUpdated).setBusCapacity(updatedBusCapacity);
                    break;
                case 5:
                    System.out.println("Enter the new Cost that has to be updated: ");
                    busInfo.setCostOfTicket(scanner.nextInt());
                    double updatedBusTicketCost = busInfo.getCostOfTicket();
                    getBusList().get(BusToBeUpdated).setCostOfTicket(updatedBusTicketCost);
                    break;
                default:
                    System.out.println("Getting out from admin panel");
                    break;
            }
            DisplayBusList();
        }
    }

    // Delete bus for admin panel
    public void DeleteBus() {
        System.out.println("Deleting the Bus...");
        DisplayBusWithIndex();
        System.out.println("Enter the index number of the Bus that has to be removed.");
        int BusToBeRemoved = scanner.nextInt();
        getBusList().remove(BusToBeRemoved);
        // Displaying the BusList after removing
        DrawLine();
        DisplayBusList();
    }

    @Override// Show Bookings
    public void DisplayInfo() {
        System.out.println("\033[0;1m" + "================================================= BOOKINGS ======================================================" + "\033[0;0m");
        for (PassengerInfo p : getPassengerList()) {
            p.DisplayBookings(p.ticketInfo.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.ticketInfo.getBusNumber(), p.getFormattedDateOfJourney(), p.ticketInfo.getTotalNumberOfSeats(), p.ticketInfo.getFromCity(), p.ticketInfo.getToCity(), p.getTotalCost(getPassengerList(), getBusList()));
        }
    }

    // Authentication for Admin PIN
    public String ReadPINinConsole() {
        // Using console to read admin pin as invisible
        Console console = System.console();
        System.out.println("Entering into Admin Login...");
        char[] readPin = console.readPassword("Enter the pin to proceed: ");
        String PinNum = new String(readPin);
        return PinNum;
    }

    // ForgotPin
    public void ForgotPIN() {
        System.out.println("The key is incorrect. Forgot Pin? Click 1");
        int ForgotPinOption = scanner.nextInt();
        if (ForgotPinOption == 1) {
            System.out.println("The Hint for PIN is:\n" + ForgetAdminKey());
        }
    }

    //Admin's Function
    public void AdminFunction() {
        DrawLine();
        DisplayBusList();
        DrawLine();
        // Operations which can be performed by the admin
        System.out.println(
                "Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \n4.Display Bookings \n5.Display all the buses\nEnter any other number to logout");
        int OperationOption = scanner.nextInt();
        // Adding new Bus
        switch (OperationOption) {
            case 1:
                AddNewBus();
                break;
            case 2:
                EditBus();
                break;
            case 3:
                DeleteBus();
                break;
            case 4:
                DisplayInfo();
                break;
            case 5:
                DisplayBusList();
                break;
            default:
                System.out.println("Logging out from admin portal...!");
                break;
        }
    }

    //Login as Admin & Admin Operation
    public void AdminOperations() {
        String AdminKey = getAdminKey();
        // Using console to read admin pin as invisible
        String PinNum = ReadPINinConsole();
        // Checking if the pin is correct
        if (AdminKey.equals(PinNum) == true) {
            System.out.println("The key is correct...Redirecting to Admin portal");
            AdminFunction();
        } else { // else block for wrong pin
            ForgotPIN();
        }
    }

    //Start a new booking
    public void StartNewBooking() {
        PassengerInfo ticketForPassenger = new PassengerInfo();
        // Filtering Bus List based on From and To
        ticketForPassenger.FilterBusList(getPassengerList(), getBusList());
        ticketForPassenger.DisplayFilteredBusList(getPassengerList(), getBusList());
        // Checking if the filtered bus list is empty or not based upon from to request
        // from user
        if (ticketForPassenger.IsFilteredBusListEmpty(getPassengerList(), getBusList()) == false) {
            ticketForPassenger.GetBusNumberFromUser();
            ticketForPassenger.GetDateOfJourneyFromUser();
            // Displaying remaining seats for the date enetered by user
            int AvailableSeats = ticketForPassenger.DisplayRemainingSeats(getPassengerList(), getBusList());
            String FormattedDate = ticketForPassenger.getFormattedDateOfJourney();
            boolean IsDateFuture = ticketForPassenger.IsDateFuture(FormattedDate, "dd/MM/yyyy");
            while (IsDateFuture == false) {
                System.out.println("The booking is over for the specified date, enter a future date.");
                ticketForPassenger.GetDateOfJourneyFromUser();
                FormattedDate = ticketForPassenger.getFormattedDateOfJourney();
                IsDateFuture = ticketForPassenger.IsDateFuture(FormattedDate, "dd/MM/yyyy");
            }
            DrawLine();
            System.out.println("\033[0;1m" + "The no:of seats available for Bus Number " + ticketForPassenger.ticketInfo.getBusNumber() + " on " + FormattedDate + " is: " + "\033[0;0m" + AvailableSeats);
            DrawLine();
            // Checking if seats are available
            if (AvailableSeats > 0) {
                System.out.println("\033[0;1m" + "Enter number 1:" + "\033[0;0m" + "To continue booking in this bus" + "\033[0;1m" + "\nEnter any other number:" + "\033[0;0m" + "To start a new booking.");
                int ContinueBooking = scanner.nextInt();
                if (ContinueBooking == 1) {
                    ticketForPassenger.GetOtherPassengerInfo();
                    ticketForPassenger.GetSeatsRequired();
                    // Checking whether the user requesting seats less than or equal to the available number of seats
                    while (ticketForPassenger.IsAvailable(getPassengerList(), getBusList()) == false) {
                        System.out.println("You have requested for more seats than available seats, Try to enter the available seats properly.");
                        ticketForPassenger.GetSeatsRequired();
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