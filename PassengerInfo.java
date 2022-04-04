import java.util.*;
import java.util.stream.Collectors;
import java.text.*;

class PassengerInfo {
    Scanner scanner = new Scanner(System.in);
    private String passengerName;
    private String passengerPhoneNumber;
    private String passengerIdNumber;

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

    public String getPassengerIdNumber() {
        return passengerIdNumber;
    }

    public void setPassengerIdNumber(String passengerIdNumber) {
        this.passengerIdNumber = passengerIdNumber;
    }

    TicketInfo ticketInfo = new TicketInfo();

    public String getFormattedDateOfJourney() {
        Utilities util = new Utilities();
        return util.dateFormatter().format(ticketInfo.getDateOfJourney());
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
        boolean validateBusNumber = false;
        while (!validateBusNumber) {
            System.out.println("\033[0;1m" + "Enter the Bus Number" + "\033[0;0m");
            try {
                AdminInfo a = new AdminInfo();
                ticketInfo.setBusNumber(Integer.parseInt(scanner.next()));
                validateBusNumber = a.getBusList().stream().map(BusInfo::getBusNumber).anyMatch(b -> b == ticketInfo.getBusNumber());
                if (!validateBusNumber) {
                    System.out.println("Try Again, enter the available bus number");
                }
            } catch (Exception e) {
                System.out.println("Invalid bus Number, try again!");
                validateBusNumber = false;
            }
        }
    }

    public void getDateOfJourneyFromUser() {
        Utilities util = new Utilities();
        boolean isSucessful = false;
        while (!isSucessful) {
        System.out.println("\033[0;1m" + "Enter the date of journey in DD/MM/YYYY" + "\033[0;0m");
        try {
            // Converting the string to date
            ticketInfo.setDateOfJourney(util.dateFormatter().parse(scanner.next()));
            isSucessful = true;
        } catch (ParseException e) {
            System.out.println("Invalid date, try again!");
            isSucessful = false;
        }    
        }
    }

    public void getOtherPassengerInfo() {
        System.out.println("\033[0;1m" + "Enter the name of the Passenger" + "\033[0;0m");
        setPassengerName(scanner.next());
        System.out.println("\033[0;1m" + "Enter the phone number" + "\033[0;0m");
        setPassengerPhoneNumber(scanner.next());
        // Phone Number Validation
        while (getPassengerPhoneNumber().length() != 10) {
            System.out.println("Please enter a valid 10 digit phone number \n Eg: 9876543210");
            setPassengerPhoneNumber(scanner.next());
        }
        System.out.println("\033[0;1m" + "Enter the Aadhar Number" + "\033[0;0m");
        setPassengerIdNumber(scanner.next());
        // ID Number Validation
        while (getPassengerIdNumber().length() != 12) {
            System.out.println("Enter a Valid 12 Digit Aadhar Number without spaces \nEg: 814273020135");
            setPassengerIdNumber(scanner.next());
        }
    }

    public void getSeatsRequired() {
        boolean isSucessful = false;
        while (!isSucessful) {
        System.out.println("\033[0;1m" + "Enter total no:of seats needed" + "\033[0;0m");
        try {
            ticketInfo.setTotalNumberOfSeats(Integer.parseInt(scanner.next()));
            isSucessful = true;
        } catch (Exception e) {
            System.out.println("Invalid, Please try again!");
            isSucessful = false;
        }
        }
    }

    // Searching bus based on From, To and Agency.
    public ArrayList<BusInfo> fromToSearchList() {
        AdminInfo adminInfo = new AdminInfo();
        ArrayList<BusInfo> fromToSearchBusList = (ArrayList<BusInfo>) adminInfo.getBusList().stream().filter(b -> b.getFromCity().equalsIgnoreCase(ticketInfo.getFromCity()) && b.getToCity().equalsIgnoreCase(ticketInfo.getToCity())).collect(Collectors.toList());
        return fromToSearchBusList;
    }

    public ArrayList<BusInfo> agencySearchList() {
        AdminInfo adminInfo = new AdminInfo();
        ArrayList<BusInfo> agencySearchBusList = (ArrayList<BusInfo>) adminInfo.getBusList().stream().filter(b -> b.getAgencyName().equalsIgnoreCase(ticketInfo.getAgencyName()) && b.getFromCity().equalsIgnoreCase(ticketInfo.getFromCity()) && b.getToCity().equalsIgnoreCase(ticketInfo.getToCity())).collect(Collectors.toList());
        return agencySearchBusList;
    }

    public void displaySearchList(ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        for (BusInfo bus : busList) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public boolean isBusListEmpty(ArrayList<BusInfo> busList) {
        if (busList.isEmpty()) {
            return true;
        }
        return false;
    }

    // Sorting
    public void displayJourneyHrsSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        Collections.sort(agencySearchList(), new JourneyComparator());
        for (BusInfo bus : agencySearchList()) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void displayTicketCostSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        Collections.sort(agencySearchList(), new CostComparator());
        for (BusInfo bus : agencySearchList()) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void displayBusNumberSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        Collections.sort(agencySearchList(), new BusNumberComparator());
        for (BusInfo bus : agencySearchList()) {
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
                        break;
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
                taxPrice = ticketPrice * ticketInfo.getTaxPercentage();
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
                ticketPriceWithTax = ticketPrice + (ticketPrice * ticketInfo.getTaxPercentage());
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
                ticketPriceWithTax = ticketInfo.getTotalNumberOfSeats() * ticketPrice + (ticketInfo.getTotalNumberOfSeats() * ticketPrice * ticketInfo.getTaxPercentage());
            }
        }
        return ticketPriceWithTax;
    }

    // Map Ticket Bookings
    public void mapAndDisplayTicketDetails() {
        Utilities util = new Utilities();
        ticketInfo.setTicketID(ticketInfo.generateTicketID());
        ticketInfo.setAgencyName(ticketInfo.getAgencyName());
        ticketInfo.setBusNumber(ticketInfo.getBusNumber());
        ticketInfo.setFromCity(ticketInfo.getFromCity());
        ticketInfo.setToCity(ticketInfo.getToCity());
        // Displaying Ticket
        ticketInfo.displayTicket(getPassengerName(), getPassengerIdNumber(), util.dateFormatter().format(ticketInfo.getDateOfJourney()));
    }

    // Map Bill Details
    public void mapAndDisplayBillDetails() {
        AdminInfo a = new AdminInfo();
        ticketInfo.setTotalNumberOfSeats(ticketInfo.getTotalNumberOfSeats());
        ticketInfo.setTicketAmount(getCostOfTicket(a.getPassengerList(), a.getBusList()));
        ticketInfo.setTaxPercentage(ticketInfo.getTaxPercentage() * 100);
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
        ticketInfo.setTaxPercentage(ticketInfo.getTaxPercentage() * 100);
        ticketInfo.setTaxAmount(getTaxOfTicket(a.getPassengerList(), a.getBusList()));
        ticketInfo.setTotalAmountPerTicket(getTotalCostOfTicket(a.getPassengerList(), a.getBusList()));
        double discountInPercent = discoutPercentage * 100;
        ticketInfo.setDiscountedAmount(getTotalCost(a.getPassengerList(), a.getBusList()) * discoutPercentage);
        ticketInfo.setTotalAmount(getTotalCost(a.getPassengerList(), a.getBusList()) - ticketInfo.getDiscountedAmount());
        // Displaying the cost of ticket after tax calculation
        ticketInfo.displayBill(discountInPercent);
    }
}