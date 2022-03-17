import java.util.*;
import java.io.*;

class AdminInfo {
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
            add(new BusInfo(1001, "Chennai", "Thanjavur", 20, "AC", 750));
            add(new BusInfo(3132, "Chennai", "Thanjavur", 30, "Sleeper", 600));
            add(new BusInfo(3313, "Chennai", "Thanjavur", 40, "Normal", 350));
            add(new BusInfo(1010, "Thanjavur", "Chennai", 20, "AC", 750));
            add(new BusInfo(3123, "Thanjavur", "Chennai", 30, "Sleeper", 600));
            add(new BusInfo(3331, "Thanjavur", "Chennai", 40, "Normal", 350));
            add(new BusInfo(1052, "Chennai", "Trichy", 40, "Semi-Sleeper", 400));
            add(new BusInfo(1053, "Chennai", "Trichy", 30, "Sleeper", 550));
            add(new BusInfo(1054, "Chennai", "Trichy", 20, "AC", 750));
            add(new BusInfo(1025, "Trichy", "Chennai", 40, "Semi-Sleeper", 400));
            add(new BusInfo(1035, "Trichy", "Chennai", 30, "Sleeper", 550));
            add(new BusInfo(1045, "Trichy", "Chennai", 20, "AC", 750));
            add(new BusInfo(2134, "Trichy", "Thanjavur", 30, "Sleeper", 550));
            add(new BusInfo(2135, "Trichy", "Thanjavur", 20, "AC", 600));
            add(new BusInfo(2136, "Trichy", "Thanjavur", 40, "Normal", 350));
            add(new BusInfo(2143, "Thanjavur", "Trichy", 30, "Sleeper", 550));
            add(new BusInfo(2153, "Thanjavur", "Trichy", 20, "AC", 600));
            add(new BusInfo(2163, "Thanjavur", "Trichy", 40, "Normal", 350));
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

    // Welcome message
    public void DisplayWelcomeMessage() {
        DrawDoubleLine();
        System.out.println("\033[0;1m" + "======================================== Welcome to Bus Ticketing System ========================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "======================================== Total Buses are displayed below ========================================" + "\033[0;0m");
        DrawDoubleLine();
    }

    public void DisplayOptionsMessage() {
        DrawDoubleLine();
        System.out.println("\033[0;1m" + "Enter option:" + "\033[0;0m" + "\n1: Start a new Booking \n2: Login as Admin \n3: Display List of Buses \nAny other number: Quit\n");
    }

    // Displaying BusList in a for each loop
    public void ForEachDisplayBusList() {
        DrawDoubleLine();
        System.out.println("\033[0;1m" + "The following buses are available:" + "\033[0;0m");
        for (BusInfo b : getBusList()) {
            b.DisplayBusInfo();
        }
    }

    BusInfo busInfo = new BusInfo();

    // Add NewBus for admin panel
    public void AddNewBus() {
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
        busInfo.setBusFacility(scanner.next());
        System.out.println("Enter the Cost of the ticket");
        busInfo.setCostOfTicket(scanner.nextDouble());
        int newBusNumber = busInfo.getBusNumber();
        String newFromCity = busInfo.getFromCity();
        String newToCity = busInfo.getToCity();
        int newBusCapacity = busInfo.getBusCapacity();
        String newBusFacility = busInfo.getBusFacility();
        double newCostOfTicket = busInfo.getCostOfTicket();
        getBusList().add(new BusInfo(newBusNumber, newFromCity, newToCity, newBusCapacity, newBusFacility, newCostOfTicket));
        // Displaying the list of buses after adding
        DrawLine();
        ForEachDisplayBusList();
    }

    // Displaying the BusInfo along with index number
    public void DisplayBusWithIndex() {
        DrawLine();
        int index = 0;
        for (BusInfo b : getBusList()) {
            System.out.print("Index Number: " + index++ + "| ");
            b.DisplayBusInfo();
        }
        DrawLine();
    }

    // EditBus for admin panel
    public void EditBus() {
        System.out.println("Editing the Bus...");
        DisplayBusWithIndex();
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
                busInfo.setBusFacility(scanner.next());
                String updatedBusFacility = busInfo.getBusFacility();
                getBusList().get(BusToBeUpdated).setBusFacility(updatedBusFacility);
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
        ForEachDisplayBusList();
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
        ForEachDisplayBusList();
    }

    // Show Bookings
    public void ShowBookingList() {
        System.out.println("\033[0;1m" + "================================================= BOOKINGS ======================================================" + "\033[0;0m");
        for (PassengerInfo p : getPassengerList()) {
            p.DisplayBookings(p.getTicketID(), p.getPassengerName(), p.getPassengerIdNumber(), p.getBusNumber(), p.getFormattedDateOfJourney(), p.getTotalNumberOfSeats(), p.getFromCity(), p.getToCity(), p.getTotalCost(getPassengerList(), getBusList()));
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

    public void DrawDoubleLine() {
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");

    }
    public void DrawLine() {
        System.out.println("\033[0;1m" + "-----------------------------------------------------------------------------------------------------------------"  + "\033[0;0m");
    }
}