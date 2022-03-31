import java.util.*;
import java.text.*;

class PassengerInfo {
    Scanner scanner = new Scanner(System.in);
    private String passengerName;
    private String passengerPhoneNumber;
    private String passengerIdNumber;
    // Using TaxPercentage as Static, as a copy of TaxPercentage is not required in all the objects.
    private static double taxPercentage;
    static {
        taxPercentage = 0.05;
    }

    // GettersSetters for private attributes
    public String getPassengerName() {
        return passengerName;
    }

    // Using this when the attributes are same
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerPhoneNumber() {
        return passengerPhoneNumber;
    }

    public void setPassengerPhoneNumber(String passengerPhoneNumber) {
        this.passengerPhoneNumber = passengerPhoneNumber;
    }

    TicketInfo ticketInfo = new TicketInfo();

    public String getFormattedDateOfJourney() {
        Utilities util = new Utilities();
        DateFormat dateFormatter = util.dateFormatter();
        String formattedDate = dateFormatter.format(ticketInfo.getDateOfJourney());
        return formattedDate;
    }

    public String getPassengerIdNumber() {
        return passengerIdNumber;
    }

    public void setPassengerIdNumber(String passengerIdNumber) {
        this.passengerIdNumber = passengerIdNumber;
    }

    // Constructor
    PassengerInfo() {
        System.out.println("\033[0;1m" + "Enter the Boarding city" + "\033[0;0m");
        ticketInfo.setFromCity(scanner.next());
        System.out.println("\033[0;1m" + "Enter the Destination city" + "\033[0;0m");
        ticketInfo.setToCity(scanner.next());
    }

    public void getAgencyNameFromUser() {
        System.out.println("\033[0;1m" + "Enter the travel agency name" + "\033[0;0m");
        ticketInfo.setAgencyName(scanner.next());
    }

    public void getBusNumberFromUser() {
        boolean isSucessful = false;
        while (!isSucessful) {
            System.out.println("\033[0;1m" + "Enter the Bus Number" + "\033[0;0m");
            try {
                int newBusNumber = Integer.parseInt(scanner.next());
                ticketInfo.setBusNumber(newBusNumber);
                isSucessful = true;
            } catch (Exception e) {
                System.out.println("Invalid bus Number, try again!");
                isSucessful = false;
            }
        }
    }

    public void getDateOfJourneyFromUser() {
        Utilities util = new Utilities();
        boolean isSucessful = false;
        while (!isSucessful) {
        System.out.println("\033[0;1m" + "Enter the date of journey in DD/MM/YYYY" + "\033[0;0m");
        try {
            String dateInput = scanner.next();
            // Converting the string to date
            DateFormat dateFormat = util.dateFormatter();
            ticketInfo.setDateOfJourney(dateFormat.parse(dateInput));
            isSucessful = true;
        } catch (ParseException e) {
            System.out.println("Invalid date, try again!");
            isSucessful = false;
        }    
        }
    }

    public void getOtherPassengerInfo() {
        System.out.println("\033[0;1m" + "Enter the name of the Passenger" + "\033[0;0m");
        passengerName = scanner.next();
        System.out.println("\033[0;1m" + "Enter the phone number" + "\033[0;0m");
        passengerPhoneNumber = scanner.next();
        // Phone Number Validation
        while (passengerPhoneNumber.length() != 10) {
            System.out.println("Please enter a valid 10 digit phone number \n Eg: 9876543210");
            passengerPhoneNumber = scanner.next();
        }
        System.out.println("\033[0;1m" + "Enter the Aadhar Number" + "\033[0;0m");
        passengerIdNumber = scanner.next();
        // ID Number Validation
        while (passengerIdNumber.length() != 12) {
            System.out.println("Enter a Valid 12 Digit Aadhar Number without spaces \nEg: 814273020135");
            passengerIdNumber = scanner.next();
        }
    }

    public void getSeatsRequired() {
        System.out.println("\033[0;1m" + "Enter total no:of seats needed" + "\033[0;0m");
        ticketInfo.setTotalNumberOfSeats(scanner.nextInt());
    }

    // ArrayList for filteredbusList based on from & to from user
    private ArrayList<BusInfo> fromToFilteredBusList = new ArrayList<>();

    public ArrayList<BusInfo> getFromToFilteredBusList() {
        return fromToFilteredBusList;
    }

    public void setFromToFilteredBusList(ArrayList<BusInfo> fromToFilteredBusList) {
        this.fromToFilteredBusList = fromToFilteredBusList;
    }
    // Filtering
    public void filterFromToBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : busList) {
            if (bus.getFromCity().equalsIgnoreCase(ticketInfo.getFromCity()) && bus.getToCity().equalsIgnoreCase(ticketInfo.getToCity())) {
                getFromToFilteredBusList().add(bus);
            }
        }
    }

    public void displayFromToFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        for (BusInfo bus : getFromToFilteredBusList()) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    // ArrayList for filteredBusList based on agency name
    private ArrayList<BusInfo> agencyFilteredBusList = new ArrayList<>();

    public ArrayList<BusInfo> getAgencyFilteredBusList() {
        return agencyFilteredBusList;
    }

    public void setAgencyFilteredBusList(ArrayList<BusInfo> agencyFilteredBusList) {
        this.agencyFilteredBusList = agencyFilteredBusList;
    }

    public void filterAgencyBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : getFromToFilteredBusList()) {
            if (bus.getAgencyName().equalsIgnoreCase(ticketInfo.getAgencyName())) {
                getAgencyFilteredBusList().add(bus);
            }
        }
    }

    public void displayAgencyFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        for (BusInfo bus : getAgencyFilteredBusList()) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void displayJourneyHrsSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        Collections.sort(getAgencyFilteredBusList(), new JourneyComparator());
        for (BusInfo bus : getAgencyFilteredBusList()) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void displayTicketCostSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        Collections.sort(getAgencyFilteredBusList(), new CostComparator());
        for (BusInfo bus : getAgencyFilteredBusList()) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void displayBusNumberSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        Collections.sort(getAgencyFilteredBusList(), new BusNumberComparator());
        for (BusInfo bus : getAgencyFilteredBusList()) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void showSortingFunctions() {
        AdminInfo a = new AdminInfo();
        int sortOption = 1;
        while (sortOption == 1 || sortOption == 2 || sortOption == 3) {
            System.out.println("Enter: \n1: To Sort based on Journey Hrs \n2: To Sort based on Ticket Cost \n3: To Sort based on Bus Number \n4: To continue booking");
            try {
                sortOption = Integer.parseInt(scanner.next());
                if (sortOption < 1 || sortOption > 4) {
                    throw new IllegalArgumentException();
                }
                switch (sortOption) {
                    case 1:
                        displayJourneyHrsSortedFilteredBusList(a.getPassengerList(), a.getBusList());
                        break;
                    case 2:
                        displayTicketCostSortedFilteredBusList(a.getPassengerList(), a.getBusList());
                        break;
                    case 3:
                        displayBusNumberSortedFilteredBusList(a.getPassengerList(), a.getBusList());
                    case 4:
                        System.out.println("Redirecting...");
                        break;
                    default:
                        System.out.println("Enter 1 - 4");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                sortOption = 1;
            }

        }
    }

    public boolean isFromToFilteredBusListEmpty(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        if (getFromToFilteredBusList().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isAgencyFilteredBusListEmpty(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        if (getAgencyFilteredBusList().isEmpty()) {
            return true;
        }
        return false;
    }

    // Availability Checker
    public int displayRemainingSeats(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        int availableSeats = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                availableSeats = bus.getBusCapacity();
            }
        }
        for (PassengerInfo p : passengerList) {
            if (p.ticketInfo.getBusNumber() == ticketInfo.getBusNumber() && p.ticketInfo.getDateOfJourney().equals(ticketInfo.getDateOfJourney())) {
                availableSeats = availableSeats - p.ticketInfo.getTotalNumberOfSeats();
            }
        }
        return availableSeats;
    }

    boolean isAvailable(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        // Fetching the BusCapacity from the BusNumber entered by the user
        int busCapacity = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                busCapacity = bus.getBusCapacity();
            }
        }
        // Using this as a counter
        int reservedTickets = 0;
        for (PassengerInfo p : passengerList) {
            if (p.ticketInfo.getBusNumber() == ticketInfo.getBusNumber() && p.ticketInfo.getDateOfJourney().equals(ticketInfo.getDateOfJourney())) {
                reservedTickets = reservedTickets + p.ticketInfo.getTotalNumberOfSeats();
            }
        }
        // Checking the capacity and returning accordingly
        if (reservedTickets + ticketInfo.getTotalNumberOfSeats() <= busCapacity) {
            return true;
        } else {
            return false;
        }
    }

    // For Displaying in the ticket section
    public String getFromCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        String fromCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                fromCity = bus.getFromCity();
            }
        }
        return fromCity;
    }

    public String getToCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        String toCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                toCity = bus.getToCity();
            }
        }
        return toCity;
    }

    // Displaying the ticket amount
    public double getCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
            }
        }
        return ticketPrice;
    }

    // Displaying the Tax amount
    public double getTaxOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        double taxPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
                // Calculating GST of 5%
                taxPrice = ticketPrice * taxPercentage;
            }
        }
        return taxPrice;
    }

    // Displaying the total amount for single ticket
    public double getTotalCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        double ticketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
                // Calculating Total cost including GST.
                ticketPriceWithTax = ticketPrice + (ticketPrice * taxPercentage);
            }
        }
        return ticketPriceWithTax;
    }

    // Calculating the total amount with total seats booked
    public double getTotalCost(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        double ticketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == ticketInfo.getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
                // Calculating Total cost including GST.
                ticketPriceWithTax = ticketInfo.getTotalNumberOfSeats() * ticketPrice + (ticketInfo.getTotalNumberOfSeats() * ticketPrice * taxPercentage);
            }
        }
        return ticketPriceWithTax;
    }

    // Map Ticket Bookings
    public void mapAndDisplayTicketDetails() {
        Utilities util = new Utilities();
        ticketInfo.setTicketID(ticketInfo.generateTicketID());
        String passengerName = getPassengerName();
        String passengerIdNumber = getPassengerIdNumber();
        Date dateOfJourney = ticketInfo.getDateOfJourney();
        DateFormat dateFormatter = util.dateFormatter();
        String formattedDate = dateFormatter.format(dateOfJourney);
        ticketInfo.setAgencyName(ticketInfo.getAgencyName());
        ticketInfo.setBusNumber(ticketInfo.getBusNumber());
        ticketInfo.setFromCity(ticketInfo.getFromCity());
        ticketInfo.setToCity(ticketInfo.getToCity());
        // Displaying Ticket
        ticketInfo.displayTicket(passengerName, passengerIdNumber, formattedDate);
    }

    // Map Bill Details
    public void mapAndDisplayBillDetails() {
        AdminInfo a = new AdminInfo();
        ticketInfo.setTotalNumberOfSeats(ticketInfo.getTotalNumberOfSeats());
        ticketInfo.setTicketAmount(getCostOfTicket(a.getPassengerList(), a.getBusList()));
        ticketInfo.setTaxPercentage(PassengerInfo.taxPercentage * 100);
        ticketInfo.setTaxAmount(getTaxOfTicket(a.getPassengerList(), a.getBusList()));
        ticketInfo.setTotalAmountPerTicket(getTotalCostOfTicket(a.getPassengerList(), a.getBusList()));
        ticketInfo.setTotalAmount(getTotalCost(a.getPassengerList(), a.getBusList()));
        // Displaying the cost of ticket after tax calculation
        ticketInfo.displayBill();
    }

    // Map Bill Details
    public void mapAndDisplayBillDetails(double discoutPercentage) {
        AdminInfo a = new AdminInfo();
        ticketInfo.setTotalNumberOfSeats(ticketInfo.getTotalNumberOfSeats());
        ticketInfo.setTicketAmount(getCostOfTicket(a.getPassengerList(), a.getBusList()));
        ticketInfo.setTaxPercentage(PassengerInfo.taxPercentage * 100);
        ticketInfo.setTaxAmount(getTaxOfTicket(a.getPassengerList(), a.getBusList()));
        ticketInfo.setTotalAmountPerTicket(getTotalCostOfTicket(a.getPassengerList(), a.getBusList()));
        double discountInPercent = discoutPercentage * 100;
        double discountedAmount = getTotalCost(a.getPassengerList(), a.getBusList()) * discoutPercentage;
        ticketInfo.setTotalAmount(getTotalCost(a.getPassengerList(), a.getBusList()) - discountedAmount);
        // Displaying the cost of ticket after tax calculation
        ticketInfo.displayBill(discountInPercent, discountedAmount);
    }
}