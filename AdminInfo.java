import java.util.*;
import java.io.*;

class AdminInfo implements DisplayInformation {
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

    private String busOperatingCities = "Chennai, Trichy, Thanjavur";

    public void setOperatingCities(String busOperatingCities) {
        this.busOperatingCities = busOperatingCities;
    }

    public String getOperatingCities() {
        return busOperatingCities;
    }

    private String availableAgencies = "TravelSoon, ReachNow, ABCT";

    public void setAvailableAgencies(String availableAgencies) {
        this.availableAgencies = availableAgencies;
    }

    public String getAvailableAgencies() {
        return availableAgencies;
    }

    // ArrayList for Buses
    private ArrayList<BusInfo> busList = new ArrayList<BusInfo>() {
        // Adding the default buses into ArrayList
        {
            add(new SpecialBusInfo(1001, "TravelSoon", "Chennai", "Thanjavur", 20, "AC", 750, 2));
            add(new SpecialBusInfo(1002, "TravelSoon", "Chennai", "Thanjavur", 30, "Sleeper", 600, 3));
            add(new BusInfo(1003, "TravelSoon", "Chennai", "Thanjavur", 40, 400, 2));
            add(new BusInfo(3313, "ReachNow", "Chennai", "Thanjavur", 30, 200, 4));
            add(new BusInfo(3314, "ReachNow", "Chennai", "Thanjavur", 40, 350, 3));
            add(new SpecialBusInfo(3315, "ReachNow", "Chennai", "Thanjavur", 50, "AC", 1750, 1));
            add(new SpecialBusInfo(4132, "ABCT", "Chennai", "Thanjavur", 25, "AC", 700, 5));
            add(new BusInfo(4314, "ABCT", "Chennai", "Thanjavur", 40, 350, 3));
            add(new SpecialBusInfo(4133, "ABCT", "Chennai", "Thanjavur", 30, "Sleeper", 500, 4));
            add(new SpecialBusInfo(1010, "ReachNow", "Thanjavur", "Chennai", 30, "AC", 750, 4));
            add(new SpecialBusInfo(2010, "ReachNow", "Thanjavur", "Chennai", 10, "Sleeper", 500, 2));
            add(new BusInfo(3010, "ReachNow", "Thanjavur", "Chennai", 20, 350, 3));
            add(new SpecialBusInfo(3123, "TravelSoon", "Thanjavur", "Chennai", 30, "Sleeper", 600, 3));
            add(new SpecialBusInfo(6123, "TravelSoon", "Thanjavur", "Chennai", 35, "AC", 700, 4));
            add(new BusInfo(3712, "TravelSoon", "Thanjavur", "Chennai", 40, 300, 2));
            add(new BusInfo(5630, "ABCT", "Thanjavur", "Chennai", 20, 150, 6));
            add(new BusInfo(5612, "ABCT", "Thanjavur", "Chennai", 40, 350, 3));
            add(new SpecialBusInfo(5553, "ABCT", "Thanjavur", "Chennai", 35, "AC", 700, 4));
            add(new SpecialBusInfo(6312, "ReachNow", "Chennai", "Trichy", 40, "Semi-Sleeper", 400, 4));
            add(new BusInfo(6054, "ReachNow", "Chennai", "Trichy", 20, 750, 3));
            add(new SpecialBusInfo(6053, "TravelSoon", "Chennai", "Trichy", 30, "Sleeper", 550, 3));
            add(new BusInfo(6063, "TravelSoon", "Chennai", "Trichy", 30, 450, 4));
            add(new BusInfo(6073, "ABCT", "Chennai", "Trichy", 20, 750, 5));
            add(new SpecialBusInfo(6083, "ABCT", "Chennai", "Trichy", 30, "Sleeper", 550, 3));
            add(new BusInfo(1025, "ABCT", "Trichy", "Chennai", 40, 400, 5));
            add(new SpecialBusInfo(6093, "ABCT", "Trichy", "Chennai", 30, "Sleeper", 550, 3));
            add(new SpecialBusInfo(1035, "ReachNow", "Trichy", "Chennai", 30, "Sleeper", 550, 4));
            add(new BusInfo(1075, "ReachNow", "Trichy", "Chennai", 40, 400, 5));
            add(new SpecialBusInfo(1045, "TravelSoon", "Trichy", "Chennai", 20, "AC", 750, 5));
            add(new BusInfo(1046, "TravelSoon", "Trichy", "Chennai", 40, 400, 3));
            add(new SpecialBusInfo(2134, "ABCT", "Trichy", "Thanjavur", 30, "Sleeper", 550, 1));
            add(new SpecialBusInfo(2234, "ABCT", "Trichy", "Thanjavur", 30, "AC", 450, 2));
            add(new SpecialBusInfo(2135, "TravelSoon", "Trichy", "Thanjavur", 20, "AC", 600, 2));
            add(new BusInfo(2136, "TravelSoon", "Trichy", "Thanjavur", 40, 350, 3));
            add(new BusInfo(2236, "ReachNow", "Trichy", "Thanjavur", 40, 350, 2));
            add(new SpecialBusInfo(2336, "ReachNow", "Trichy", "Thanjavur", 20, "AC", 600, 1));
            add(new SpecialBusInfo(2143, "TravelSoon", "Thanjavur", "Trichy", 30, "Sleeper", 550, 3));
            add(new SpecialBusInfo(3143, "TravelSoon", "Thanjavur", "Trichy", 50, "AC", 750, 1));
            add(new SpecialBusInfo(2153, "ABCT", "Thanjavur", "Trichy", 20, "AC", 600, 4));
            add(new SpecialBusInfo(3153, "ABCT", "Thanjavur", "Trichy", 30, "Semi-Sleeper", 550, 3));
            add(new BusInfo(2163, "ReachNow", "Thanjavur", "Trichy", 40, 350, 1));
            add(new SpecialBusInfo(5143, "ReachNow", "Thanjavur", "Trichy", 30, "Sleeper", 450, 2));
        }
    };

    public ArrayList<BusInfo> getBusList() {
        return busList;
    }

    public void setBusList(ArrayList<BusInfo> busList) {
        this.busList = busList;
    }

    // ArrayList for filteredbusList based on from & to from user
    private ArrayList<BusInfo> fromToFilteredBusList = new ArrayList<>();

    public ArrayList<BusInfo> getFromToFilteredBusList() {
        return fromToFilteredBusList;
    }

    public void setFromToFilteredBusList(ArrayList<BusInfo> fromToFilteredBusList) {
        this.fromToFilteredBusList = fromToFilteredBusList;
    }

    // ArrayList for filteredBusList based on agency name
    private ArrayList<BusInfo> agencyFilteredBusList = new ArrayList<>();

    public ArrayList<BusInfo> getAgencyFilteredBusList() {
        return agencyFilteredBusList;
    }

    public void setAgencyFilteredBusList(ArrayList<BusInfo> agencyFilteredBusList) {
        this.agencyFilteredBusList = agencyFilteredBusList;
    }

    // ArrayList for Passenger List
    private ArrayList<PassengerInfo> passengerList = new ArrayList<>();

    public ArrayList<PassengerInfo> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<PassengerInfo> passengerList) {
        this.passengerList = passengerList;
    }

    // FilterList For Special Bus
    private ArrayList<BusInfo> filteredSpecialBusList = new ArrayList<>();

    public ArrayList<BusInfo> getFilteredSpecialBusList() {
        return filteredSpecialBusList;
    }

    public void setFilteredSpecialBusList(ArrayList<BusInfo> filteredSpecialBusList) {
        this.filteredSpecialBusList = filteredSpecialBusList;
    }

    // Filtering Special Bus
    public void filterSpecialBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : getBusList()) {
            if (bus instanceof SpecialBusInfo) {
                getFilteredSpecialBusList().add(bus);
            }
        }
    }

    public void drawDoubleLine() {
        System.out.println("\033[0;1m" + "=========================================================================================================================================================" + "\033[0;0m");
    }

    public void drawLine() {
        System.out.println("\033[0;1m" + "---------------------------------------------------------------------------------------------------------------------------------------------------------" + "\033[0;0m");
    }

    // Welcome message
    public void displayWelcomeMessage() {
        drawDoubleLine();
        System.out.println("\033[0;1m" + "============================================================ Welcome to Bus Ticketing System ============================================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "============================================================ Total Buses are displayed below ============================================================" + "\033[0;0m");
        drawDoubleLine();
    }

    public void displayOptionsMessage() {
        drawDoubleLine();
        System.out.println("\033[0;1m" + "Enter option:" + "\033[0;0m" + "\n1: Start a new Booking \n2: Login as Admin \n3: Quit\n");
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
        boolean isSucessful = false;
        while (!isSucessful) {
            try {
                System.out.println("Enter 1: To create a normal bus. \nEnter 2: To create Luxury Bus");
                int busType = Integer.parseInt(scanner.nextLine());
                if (busType < 1 || busType > 2) {
                    throw new IllegalArgumentException();
                }
                if (busType == 1) { // To Add normal Bus
                    System.out.println("Enter the Bus Number");
                    busInfo.setBusNumber(scanner.nextInt());
                    System.out.println("Enter the Agency Name");
                    busInfo.setAgencyName(scanner.next());
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
                    String newAgencyName = busInfo.getAgencyName();
                    String newFromCity = busInfo.getFromCity();
                    String newToCity = busInfo.getToCity();
                    int newBusCapacity = busInfo.getBusCapacity();
                    double newCostOfTicket = busInfo.getCostOfTicket();
                    int newApproxJourneyHrs = busInfo.getApproxJourneyHrs();
                    getBusList().add(new BusInfo(newBusNumber, newAgencyName, newFromCity, newToCity, newBusCapacity, newCostOfTicket, newApproxJourneyHrs));
                    // Displaying the list of buses after adding
                    drawLine();
                    displayBusList();
                } else if (busType == 2) { // To add Special bus
                    System.out.println("Enter the Bus Number");
                    busInfo.setBusNumber(scanner.nextInt());
                    System.out.println("Enter the Agency Name");
                    busInfo.setAgencyName(scanner.next());
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
                    String newAgencyName = busInfo.getAgencyName();
                    String newFromCity = busInfo.getFromCity();
                    String newToCity = busInfo.getToCity();
                    int newBusCapacity = busInfo.getBusCapacity();
                    String newBusFacility = specialBus.getBusFacility();
                    double newCostOfTicket = busInfo.getCostOfTicket();
                    int newApproxJourneyHrs = busInfo.getApproxJourneyHrs();
                    getBusList().add(new SpecialBusInfo(newBusNumber, newAgencyName, newFromCity, newToCity, newBusCapacity, newBusFacility, newCostOfTicket, newApproxJourneyHrs));
                    // Displaying the list of buses after adding
                    drawLine();
                    displayBusList();
                }
                isSucessful = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please try again!");
            }
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
        boolean isSucessful = false;
        while (!isSucessful) {
            try {
                System.out.println("Editing the Bus...");
                System.out.println("Enter 1: To edit Luxury Bus \nEnter 2: To edit Normal Bus");
                int editBusOption = Integer.parseInt(scanner.nextLine());
                if (editBusOption < 1 || editBusOption > 2) {
                    throw new IllegalArgumentException();
                }
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
                } else if (editBusOption == 2) {
                    displayBusWithIndex();
                    // Getting the index number that has to be updated from user
                    System.out.println("Enter the Index number of the bus to be updated: ");
                    int busToBeUpdated = scanner.nextInt();
                    // Asking for the field that has to be updated
                    drawLine();
                    System.out.println("Select the option of the field which has to be updated: ");
                    System.out.println(
                            "1.Bus Number \n2.From City \n3.To City \n4.Bus Capacity \n5.Cost of the ticket \n6. Approx Journey Hrs \nEnter any other number to quit");
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
                isSucessful = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
            }
        }
    }

    // Delete bus for admin panel
    public void deleteBus() {
        System.out.println("Deleting the Bus...");
        displayBusWithIndex();
        System.out.println("Enter the index number of the Bus that has to be removed");
        int busToBeRemoved = scanner.nextInt();
        getBusList().remove(busToBeRemoved);
        // Displaying the BusList after removing
        drawLine();
        displayBusList();
    }

    @Override // Show Bookings
    public void displayInfo() {
        System.out.println("\033[0;1m" + "==================================================================== BOOKINGS =====================================================================" + "\033[0;0m");
        for (PassengerInfo p : getPassengerList()) {
            p.displayBookings(p.ticketInfo.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.ticketInfo.getAgencyName(), p.ticketInfo.getBusNumber(), p.getFormattedDateOfJourney(), p.ticketInfo.getTotalNumberOfSeats(), p.ticketInfo.getFromCity(), p.ticketInfo.getToCity(), p.getTotalCost(getPassengerList(), getBusList()));
        }
    }

    public void displayAgencyBookings() {
        System.out.println("Enter the agency name to fetch bookings: ");
        String agencyNameToSearch = scanner.next();
        System.out.println("\033[0;1m" + "==================================================================== " + agencyNameToSearch + " BOOKINGS =====================================================================" + "\033[0;0m");
        for (PassengerInfo p : getPassengerList()) {
            if (p.ticketInfo.getAgencyName().equalsIgnoreCase(agencyNameToSearch)) {
                p.displayBookings(p.ticketInfo.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.ticketInfo.getAgencyName(), p.ticketInfo.getBusNumber(), p.getFormattedDateOfJourney(), p.ticketInfo.getTotalNumberOfSeats(), p.ticketInfo.getFromCity(), p.ticketInfo.getToCity(), p.getTotalCost(getPassengerList(), getBusList()));
                drawDoubleLine();
            }
        }
    }

    // Update Operating Cities Message
    public void setOperatingCities() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.println("Enter the list of cities operating separated by comma: ");
        String newMessage = br.readLine();
        setOperatingCities(newMessage);
        System.out.println("Updated Operating Cities are: " + newMessage);
    }

    // Update Available Agencies Message
    public void setAvailableAgencies() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.println("Enter the list of agencies separated by comma: ");
        String newMessage = br.readLine();
        setAvailableAgencies(newMessage);
        System.out.println("Updated agencies are: " + newMessage);
    }

    // Authentication for Admin PIN
    public String readPinInConsole() {
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

    // Admin's Function
    public void adminFunction() {
        drawLine();
        displayBusList();
        drawLine();
        // Operations which can be performed by the admin
        System.out.println("Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \n4.Display All Bookings \n5.Filter Bookings based on Agency \n6.Display all the buses \n7.Update Operating Cities \n8.Update Available Agencies \n9.To logout");
        try {
            int operationOption = Integer.parseInt(scanner.nextLine());
            if (operationOption < 1 || operationOption > 9) {
                throw new IllegalArgumentException();
            }
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
                    displayAgencyBookings();
                    break;
                case 6:
                    displayBusList();
                    break;
                case 7:
                    try {
                        setOperatingCities();
                    } catch (IOException e) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 8:
                    try {
                        setAvailableAgencies();
                    } catch (IOException e) {
                        System.out.println("Invalid input");
                    }
                    break;
                case 9:
                    System.out.println("Logging out from admin portal...!");
                    break;
                default:
                    System.out.println("Enter 1 to 9");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input, try again");
        }
    }

    // Login as Admin & Admin Operation
    public void adminOperations() {
        String adminKey = getAdminKey();
        // Using console to read admin pin as invisible
        String pinNum = readPinInConsole();
        // Checking if the pin is correct
        if (adminKey.equals(pinNum) == true) {
            System.out.println("The key is correct...Redirecting to Admin portal");
            adminFunction();
        } else { // else block for wrong pin
            forgotPIN();
        }
    }

    // Start a new booking
    public void startNewBooking() {
        PassengerInfo ticketForPassenger = new PassengerInfo();
        // Filtering Bus List based on From and To
        ticketForPassenger.filterFromToBusList(getPassengerList(), getBusList());
        ticketForPassenger.displayFromToFilteredBusList(getPassengerList(), getBusList());
        // Checking if the filtered bus list is empty or not based upon from to request from user
        if (ticketForPassenger.isFromToFilteredBusListEmpty(getPassengerList(), getBusList()) == false) {
            ticketForPassenger.getAgencyNameFromUser();
            ticketForPassenger.filterAgencyBusList(getPassengerList(), getFromToFilteredBusList());
            ticketForPassenger.displayAgencyFilteredBusList(getPassengerList(), getFromToFilteredBusList());
            if (ticketForPassenger.isAgencyFilteredBusListEmpty(getPassengerList(), getFromToFilteredBusList()) == false) {
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
                    System.out.println("\033[0;1m" + "Enter number 1:" + "\033[0;0m" + "To continue booking in this bus" + "\033[0;1m" + "\nEnter number 2:" + "\033[0;0m" + "To start a new booking.");
                    try {
                        int continueBooking = Integer.parseInt(scanner.nextLine());
                        if (continueBooking < 1 || continueBooking > 2) {
                            throw new IllegalArgumentException();
                        }
                        if (continueBooking == 1) {
                            ticketForPassenger.getOtherPassengerInfo();
                            ticketForPassenger.getSeatsRequired();
                            // Checking whether the user requesting seats less than or equal to the available number of seats
                            while (ticketForPassenger.isAvailable(getPassengerList(), getBusList()) == false) {
                                System.out.println("You have requested for more seats than available seats, Try to enter the available seats properly.");
                                ticketForPassenger.getSeatsRequired();
                            } // Adding passenger to the reserved list
                            getPassengerList().add(ticketForPassenger);
                            // Coupon code and billing
                            ticketForPassenger.checkForCouponCode();
                        } else if (continueBooking == 2) { // else block for start a new booking if the available seats is not enough
                            System.out.println("Redirecting...");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input, please try again!");
                    }
                } else { // else block if seats are not available
                    System.out.println("As there are no seats available for the date selected, try in different Bus/Date");
                }
            } else {
                System.out.println("The requested agency is not available, try: " + getAvailableAgencies());
            }
        } else { // else block if the user requested other areas than the service areas
            System.out.println("Service is not available in those areas, try: " + getOperatingCities());
        }
    }
}