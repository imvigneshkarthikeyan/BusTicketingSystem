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

    // ArrayList for Passenger List
    private ArrayList<PassengerInfo> passengerList = new ArrayList<>();

    public ArrayList<PassengerInfo> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<PassengerInfo> passengerList) {
        this.passengerList = passengerList;
    }

    // Filtering Special Bus
    public ArrayList<BusInfo> filterSpecialBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        ArrayList<BusInfo> filteredBusList = new ArrayList<BusInfo>();
        for (BusInfo bus : getBusList()) {
            if (bus instanceof SpecialBusInfo) {
                filteredBusList.add(bus);
            }
        }
        return filteredBusList;
    }

    public void displayOptionsMessage() {
        Utilities util = new Utilities();
        util.drawDoubleLine();
        System.out.println("\033[0;1m" + "Enter option:" + "\033[0;0m" + "\n1: Start a new Booking \n2: Login as Admin \n3: Quit\n");
    }

    // Displaying BusList in a for each loop
    public void displayBusList() {
        Utilities util = new Utilities();
        util.drawDoubleLine();
        System.out.println("\033[0;1m" + "The following buses are available:" + "\033[0;0m");
        for (BusInfo b : getBusList()) {
            b.displayInfo();
        }
    }

    // Add NewBus for admin panel
    public void addNewBus() {
        BusInfo busInfo = new BusInfo();
        SpecialBusInfo specialBus = new SpecialBusInfo();
        Utilities util = new Utilities();
        boolean isSucessful = false;
        while (!isSucessful) {
            try {
                System.out.println("Enter 1: To create a normal bus. \nEnter 2: To create Luxury Bus");
                int busType = Integer.parseInt(scanner.next());
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
                    getBusList().add(new BusInfo(busInfo.getBusNumber(), busInfo.getAgencyName(), busInfo.getFromCity(), busInfo.getToCity(), busInfo.getBusCapacity(), busInfo.getCostOfTicket(), busInfo.getApproxJourneyHrs()));
                    // Displaying the list of buses after adding
                    util.drawLine();
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
                    getBusList().add(new SpecialBusInfo(busInfo.getBusNumber(), busInfo.getAgencyName(), busInfo.getFromCity(), busInfo.getToCity(), busInfo.getBusCapacity(), specialBus.getBusFacility(), busInfo.getCostOfTicket(), busInfo.getApproxJourneyHrs()));
                    // Displaying the list of buses after adding
                    util.drawLine();
                    displayBusList();
                }
                isSucessful = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please try again!");
            }
        }
    }

    // Displaying the BusInfo along with index number
    public void displayBusWithIndex(ArrayList<BusInfo> buses) {
        Utilities util = new Utilities();
        util.drawLine();
        int index = 0;
        for (BusInfo b : buses) {
            System.out.print("Index Number: " + index++ + "| ");
            b.displayInfo();
        }
        util.drawLine();
    }


    // EditBus for admin panel
    public void editBus() {
        BusInfo busInfo = new BusInfo();
        SpecialBusInfo specialBus = new SpecialBusInfo();
        Utilities util = new Utilities();
            try {
                System.out.println("Editing the Bus...");
                System.out.println("Enter 1: To edit Luxury Bus \nEnter 2: To edit Normal Bus");
                int editBusOption = Integer.parseInt(scanner.next());
                if (editBusOption < 1 || editBusOption > 2) {
                    throw new IllegalArgumentException();
                }
                if (editBusOption == 1) {
                    ArrayList<BusInfo> filteredBuses = filterSpecialBusList(getPassengerList(), getBusList());
                    displayBusWithIndex(filteredBuses);
                    // Getting the index number that has to be updated from user
                    System.out.println("Enter the Index number of the bus to be updated: ");
                    int busToBeUpdated = scanner.nextInt();
                    while (filteredBuses.size() <= busToBeUpdated) {
                        System.out.println("Enter the index number properly from the given list.");
                        busToBeUpdated = scanner.nextInt();
                    }
                    if (filteredBuses.size() > busToBeUpdated){
                        // Asking for the field that has to be updated
                        util.drawLine();
                        System.out.println("Select the option of the field which has to be updated: ");
                        System.out.println("1: Bus Number \n2: Agency \n3: From City \n4: To City \n5: Bus Capacity \n6: Bus Facility \n7: Cost of the ticket \n8: Approx Journey Hours \nEnter any other number: To Quit");
                        int optionToBeUpdated = scanner.nextInt();
                        switch (optionToBeUpdated) {
                            case 1:
                                System.out.println("Enter the new Bus Number that has to be updated: ");
                                busInfo.setBusNumber(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setBusNumber(busInfo.getBusNumber());
                                break;
                            case 2:
                                System.out.println("Enter the new Agency Name that has to be updated: ");
                                busInfo.setAgencyName(scanner.next());
                                getBusList().get(busToBeUpdated).setAgencyName(busInfo.getAgencyName());
                                break;
                            case 3:
                                System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                                busInfo.setFromCity(scanner.next());
                                getBusList().get(busToBeUpdated).setFromCity(busInfo.getFromCity());
                                break;
                            case 4:
                                System.out.println("Enter the new Bus Destination that has to be updated: ");
                                busInfo.setToCity(scanner.next());
                                getBusList().get(busToBeUpdated).setToCity(busInfo.getToCity());
                                break;
                            case 5:
                                System.out.println("Enter the new Capacity that has to be updated: ");
                                busInfo.setBusCapacity(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setBusCapacity(busInfo.getBusCapacity());
                                break;
                            case 6:
                                System.out.println("Enter the new Bus Facility that has to be updated: ");
                                specialBus.setBusFacility(scanner.next());
                                ((SpecialBusInfo) getBusList().get(busToBeUpdated))
                                        .setBusFacility(specialBus.getBusFacility());
                                break;
                            case 7:
                                System.out.println("Enter the new Cost that has to be updated: ");
                                busInfo.setCostOfTicket(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setCostOfTicket(busInfo.getCostOfTicket());
                                break;
                            case 8:
                                System.out.println("Enter the new approximate journey in hrs: ");
                                busInfo.setApproxJourneyHrs(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setApproxJourneyHrs(busInfo.getApproxJourneyHrs());
                                break;
                            default:
                                System.out.println("Getting out from admin panel");
                                break;
                        }
                    displayBusList();
                    }
                } else if (editBusOption == 2) {
                    displayBusWithIndex(busList);
                    // Getting the index number that has to be updated from user
                    System.out.println("Enter the Index number of the bus to be updated: ");
                    int busToBeUpdated = scanner.nextInt();
                    while (getBusList().size() <= busToBeUpdated) {
                        System.out.println("Enter the index number properly from the given list.");
                        busToBeUpdated = scanner.nextInt();
                    }
                    if (getBusList().size() > busToBeUpdated) {
                        util.drawLine();
                        System.out.println("Select the option of the field which has to be updated: ");
                        System.out.println("1.Bus Number \n2.Agency \n3.From City \n4.To City \n5.Bus Capacity \n6.Cost of the ticket \n7. Approx Journey Hrs \nEnter any other number to quit");
                        int optionToBeUpdated = scanner.nextInt();
                        switch (optionToBeUpdated) {
                            case 1:
                                System.out.println("Enter the new Bus Number that has to be updated: ");
                                busInfo.setBusNumber(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setBusNumber(busInfo.getBusNumber());
                                break;
                            case 2:
                                System.out.println("Enter the new Agency Name that has to be updated: ");
                                busInfo.setAgencyName(scanner.next());
                                getBusList().get(busToBeUpdated).setAgencyName(busInfo.getAgencyName());
                                break;
                            case 3:
                                System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                                busInfo.setFromCity(scanner.next());
                                getBusList().get(busToBeUpdated).setFromCity(busInfo.getFromCity());
                                break;
                            case 4:
                                System.out.println("Enter the new Bus Destination that has to be updated: ");
                                busInfo.setToCity(scanner.next());
                                getBusList().get(busToBeUpdated).setToCity(busInfo.getToCity());
                                break;
                            case 5:
                                System.out.println("Enter the new Capacity that has to be updated: ");
                                busInfo.setBusCapacity(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setBusCapacity(busInfo.getBusCapacity());
                                break;
                            case 6:
                                System.out.println("Enter the new Cost that has to be updated: ");
                                busInfo.setCostOfTicket(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setCostOfTicket(busInfo.getCostOfTicket());
                                break;
                            case 7:
                                System.out.println("Enter the new approximate journey in hrs: ");
                                busInfo.setApproxJourneyHrs(scanner.nextInt());
                                getBusList().get(busToBeUpdated).setApproxJourneyHrs(busInfo.getApproxJourneyHrs());
                                break;
                            default:
                                System.out.println("Getting out from admin panel");
                                break;
                        }
                        displayBusList();
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
            }
        }

    // Delete bus for admin panel
    public void deleteBus() {
        Utilities util = new Utilities();
        System.out.println("Deleting the Bus...");
        displayBusWithIndex(busList);
        System.out.println("Enter the index number of the Bus that has to be removed");
        getBusList().remove(scanner.nextInt());
        // Displaying the BusList after removing
        util.drawLine();
        System.out.println("The selected bus was removed successfully");
        util.drawLine();
        displayBusList();
    }

    // Display Bookings for Admin
    public void displayBookings(String ticketID, String passengerName, String passengerIdNumber, String agencyName, int busNumber, String formattedDate, int totalNumberOfSeats, String fromCity, String toCity, double totalAmount) {
        Utilities util = new Utilities();
        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + ticketID);
        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + passengerName);
        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + passengerIdNumber);
        System.out.println("\033[0;1m" + "Agency Name: " + "\033[0;0m" + agencyName);
        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + busNumber);
        System.out.println("\033[0;1m" + "Date of Journey: " + "\033[0;0m" + formattedDate);
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + totalNumberOfSeats);
        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + fromCity);
        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + toCity);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + totalAmount);
        util.drawDoubleLine();
    }

    @Override // Show Bookings
    public void displayInfo() {
        Utilities util = new Utilities();
        if (getPassengerList().isEmpty()) {
            util.drawBookingLine();
            System.out.println("No bookings till now!");
        } else {
            util.drawBookingLine();
            for (PassengerInfo p : getPassengerList()) {
                displayBookings(p.ticketInfo.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.ticketInfo.getAgencyName(), p.ticketInfo.getBusNumber(), p.getFormattedDateOfJourney(), p.ticketInfo.getTotalNumberOfSeats(), p.ticketInfo.getFromCity(), p.ticketInfo.getToCity(), p.getTotalCost(getPassengerList(), getBusList()));
            }
        }
    }

    public void displayAgencyBookings() {
        Utilities util = new Utilities();
        System.out.println("Enter the agency name to fetch bookings: ");
        String agencyNameToSearch = scanner.next();
        util.drawBookingLine(agencyNameToSearch);
        for (PassengerInfo p : getPassengerList()) {
            if (p.ticketInfo.getAgencyName().equalsIgnoreCase(agencyNameToSearch)) {
                displayBookings(p.ticketInfo.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.ticketInfo.getAgencyName(), p.ticketInfo.getBusNumber(), p.getFormattedDateOfJourney(), p.ticketInfo.getTotalNumberOfSeats(), p.ticketInfo.getFromCity(), p.ticketInfo.getToCity(), p.getTotalCost(getPassengerList(), getBusList()));
                util.drawDoubleLine();
            }
        }
    }

    // Update Operating Cities Message
    public void setOperatingCities() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.println("Enter the list of cities operating separated by comma: ");
        setOperatingCities(br.readLine());
        System.out.println("Updated Operating Cities are: " + getOperatingCities());
    }

    // Update Available Agencies Message
    public void setAvailableAgencies() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.println("Enter the list of agencies separated by comma: ");
        setAvailableAgencies(br.readLine());
        System.out.println("Updated agencies are: " + getAvailableAgencies());
    }

    // Authentication for Admin PIN
    public String readPinInConsole() {
        // Using console to read admin pin as invisible
        Console console = System.console();
        System.out.println("Entering into Admin Login...");
        String pinNum = new String(console.readPassword("Enter the pin to proceed: "));
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
    public void adminOperation() {
        Utilities util = new Utilities();
        util.drawLine();
        displayBusList();
        util.drawLine();
        // Operations which can be performed by the admin
        System.out.println("Enter option: \n1: Add a new bus \n2: Edit a Bus \n3: Delete a Bus \n4: Display All Bookings \n5: Filter Bookings based on Agency \n6: Display all the buses \n7: Update Operating Cities \n8: Update Available Agencies \n9: To logout");
        try {
            int operationOption = Integer.parseInt(scanner.next());
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
    public void adminLogin() {
        String adminKey = getAdminKey();
        // Using console to read admin pin as invisible
        String pinNum = readPinInConsole();
        // Checking if the pin is correct
        if (adminKey.equals(pinNum) == true) {
            System.out.println("The key is correct...Redirecting to Admin portal");
            adminOperation();
        } else { // else block for wrong pin
            forgotPIN();
        }
    }

    // Start a new booking
    public void startNewBooking() {
        PassengerInfo ticketForPassenger = new PassengerInfo();
        Utilities util = new Utilities();
        // Filtering Bus List based on From and To
        ticketForPassenger.fromToSearchList();
        ticketForPassenger.displaySearchList(ticketForPassenger.fromToSearchList());
        // Checking if the filtered bus list is empty or not based upon from to request from user
        if (ticketForPassenger.isBusListEmpty(ticketForPassenger.fromToSearchList()) == false) {
            ticketForPassenger.getAgencyNameFromUser();
            ticketForPassenger.agencySearchList();
            ticketForPassenger.displaySearchList(ticketForPassenger.agencySearchList());
            if (ticketForPassenger.isBusListEmpty(ticketForPassenger.agencySearchList()) == false) {
                // ticketForPassenger.showSortingFunctions();
                ticketForPassenger.getBusNumberFromUser();
                ticketForPassenger.getDateOfJourneyFromUser();
                // Displaying remaining seats for the date enetered by user
                int availableSeats = ticketForPassenger.displayRemainingSeats(getPassengerList(), getBusList());
                boolean isDateFuture = util.isDateFuture(ticketForPassenger.getFormattedDateOfJourney(), "dd/MM/yyyy");
                while (isDateFuture == false) {
                    System.out.println("The booking is over for the specified date, enter a future date.");
                    ticketForPassenger.getDateOfJourneyFromUser();
                    isDateFuture = util.isDateFuture(ticketForPassenger.getFormattedDateOfJourney(), "dd/MM/yyyy");
                }
                util.drawLine();
                System.out.println("\033[0;1m" + "The no:of seats available for Bus Number " + ticketForPassenger.ticketInfo.getBusNumber() + " on " + ticketForPassenger.getFormattedDateOfJourney() + " is: " + "\033[0;0m" + availableSeats);
                util.drawLine();
                // Checking if seats are available
                boolean isSucessful = false;
                while (!isSucessful) {
                    if (availableSeats > 0) {
                    System.out.println("\033[0;1m" + "Enter number 1:" + "\033[0;0m" + "To continue booking in this bus" + "\033[0;1m" + "\nEnter number 2:" + "\033[0;0m" + "To start a new booking.");
                    try {
                        int continueBooking = Integer.parseInt(scanner.next());
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
                            boolean checkLoop = false;
                            while (!checkLoop) {
                            System.out.println("\033[0;1m" + "Enter 1:" + "\033[0;0m" + "If you have any coupon code" + "\033[0;1m" + "\nEnter 2:" + "\033[0;0m" + "To complete the booking without coupon code.");
                            try {
                            int selectedOption = Integer.parseInt(scanner.next());
                            if (selectedOption < 1 || selectedOption > 2) {
                                throw new IllegalArgumentException();
                            }
                            if (selectedOption == 1) {
                                OffersAndDiscount offers = new OffersAndDiscount();
                                System.out.println("\033[0;1m" + "Enter the coupon code" + "\033[0;0m");
                                offers.setAppliedCouponCode(scanner.next());
                                if (offers.getCouponCode().equals(offers.getAppliedCouponCode())) {
                                    System.out.println("The coupon code is valid, discount will be made on the total bill.");
                                    ticketForPassenger.mapAndDisplayTicketDetails();
                                    ticketForPassenger.mapAndDisplayBillDetails(offers.getDiscountPercentage());
                                } else {
                                    System.out.println("The code is invalid so no discount will be made.");
                                    ticketForPassenger.mapAndDisplayTicketDetails();
                                    ticketForPassenger.mapAndDisplayBillDetails();
                                }
                            } else {
                                System.out.println("Redirecting to the bill...");
                                ticketForPassenger.mapAndDisplayTicketDetails();
                                ticketForPassenger.mapAndDisplayBillDetails();
                            }
                            checkLoop = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid input, please try again!");
                            }
                            }
                        } else if (continueBooking == 2) { // else block for start a new booking if the available seats is not enough
                            System.out.println("Redirecting...");
                        }
                        isSucessful = true;
                        } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input, please try again!");
                    }
                } else { // else block if seats are not available
                    System.out.println("As there are no seats available for the date selected, try in different Bus/Date");
                    break;
                }
                }
            } else {
                System.out.println("The requested agency is not available, try: " + getAvailableAgencies());
            }
        } else { // else block if the user requested other areas than the service areas
            System.out.println("Service is not available in those areas, try: " + getOperatingCities());
        }
    }
}