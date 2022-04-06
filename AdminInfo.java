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

    // ArrayList for Ticket List
    private ArrayList<TicketInfo> ticketList = new ArrayList<>();

    public ArrayList<TicketInfo> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<TicketInfo> ticketList) {
        this.ticketList = ticketList;
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
        if (getTicketList().isEmpty()) {
            util.drawBookingLine();
            System.out.println("No bookings till now!");
        } else {
            util.drawBookingLine();
            for (TicketInfo t : getTicketList()) {
                displayBookings(t.getTicketID(), t.passengerInfo.getPassengerName(), t.passengerInfo.getPassengerIdNumber(), t.getAgencyName(), t.getBusNumber(), t.getFormattedDateOfJourney(), t.getTotalNumberOfSeats(), t.getFromCity(), t.getToCity(), t.getTotalCost(getTicketList(), getBusList()));
            }
        }
    }

    public void displayAgencyBookings() {
        Utilities util = new Utilities();
        System.out.println("Enter the agency name to fetch bookings: ");
        String agencyNameToSearch = scanner.next();
        util.drawBookingLine(agencyNameToSearch);
        for (TicketInfo t : getTicketList()) {
            if (t.getAgencyName().equalsIgnoreCase(agencyNameToSearch)) {
                displayBookings(t.getTicketID(), t.passengerInfo.getPassengerName(), t.passengerInfo.getPassengerIdNumber(), t.getAgencyName(), t.getBusNumber(), t.getFormattedDateOfJourney(), t.getTotalNumberOfSeats(), t.getFromCity(), t.getToCity(), t.getTotalCost(getTicketList(), getBusList()));
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

    // Admin's Function
    public void adminOperation() {
        Utilities util = new Utilities();
        BusOperations busOperations = new BusOperations();
        util.drawLine();
        busOperations.displayBusList(getBusList());
        util.drawLine();
        // Operations which can be performed by the admin
        System.out.println("Enter option: \n1: Add a new bus \n2: Edit a Bus \n3: Delete a Bus \n4: Display All Bookings \n5: Filter Bookings based on Agency \n6: Display all the buses \n7: Update Operating Cities \n8: Update Available Agencies \n9: To logout");
        try {
            int operationOption = Integer.parseInt(scanner.next());
            util.optionValidator(operationOption, 1, 9);
            // Adding new Bus
            switch (operationOption) {
                case 1:
                    busOperations.addNewBus(getBusList());
                    break;
                case 2:
                    busOperations.editBus(getTicketList(), getBusList());
                    break;
                case 3:
                    busOperations.deleteBus(getBusList());
                    break;
                case 4:
                    displayInfo();
                    break;
                case 5:
                    displayAgencyBookings();
                    break;
                case 6:
                    busOperations.displayBusList(getBusList());
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
}