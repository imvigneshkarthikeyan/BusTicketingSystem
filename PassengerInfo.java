import java.util.*;
import java.text.*;
//For Date Validation
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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

    public String getFormattedDateOfJourney() {
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormatter.format(ticketInfo.getDateOfJourney());
        return formattedDate;
    }

    public String getPassengerIdNumber() {
        return passengerIdNumber;
    }

    public void setPassengerIdNumber(String passengerIdNumber) {
        this.passengerIdNumber = passengerIdNumber;
    }
    
    TicketInfo ticketInfo = new TicketInfo();

    public String generateTicketID() {
        ticketInfo.setTicketID(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        return ticketInfo.getTicketID();
    }

    // Constructor
    PassengerInfo() {
        System.out.println("\033[0;1m" + "Enter the Boarding city" + "\033[0;0m");
        ticketInfo.setFromCity(scanner.next());
        System.out.println("\033[0;1m" + "Enter the Destination city" + "\033[0;0m");
        ticketInfo.setToCity(scanner.next());
    }

    public void getBusNumberFromUser() {
        try {
            System.out.println("\033[0;1m" + "Enter the Bus Number" + "\033[0;0m");
            int newBusNumber = Integer.parseInt(scanner.next());
            ticketInfo.setBusNumber(newBusNumber);
        } catch (InputMismatchException e) {
            System.out.println("Invalid, try again!");

        }
    }

    public void getDateOfJourneyFromUser() {
        System.out.println("\033[0;1m" + "Enter the date of journey in DD-MM-YYYY" + "\033[0;0m");
        String dateInput = scanner.next();
        // Converting the string to date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            ticketInfo.setDateOfJourney(dateFormat.parse(dateInput));
        } catch (ParseException e) {
            // Auto-generated catch block
            System.out.println("Invalid date, try again!");
        }
    }

    // Validation: Is entered date a future date
    public boolean isDateFuture(String date, String dateFormat) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate inputDate = LocalDate.parse(date, dtf);
        return inputDate.isAfter(localDate);
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

    AdminInfo a = new AdminInfo();
    // Filtering
    public void filterBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : busList) {
            if (bus.getFromCity().equalsIgnoreCase(ticketInfo.getFromCity()) && bus.getToCity().equalsIgnoreCase(ticketInfo.getToCity())) {
                a.getFilteredBusList().add(bus);
            }
        }
    }

    public void displayFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : a.getFilteredBusList()) {
            a.drawDoubleLine();
            bus.displayInfo();
        }
        a.drawLine();
    }

    public void displayJourneyHrsSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Collections.sort(a.getFilteredBusList(), new JourneyComparator());
        for (BusInfo bus : a.getFilteredBusList()) {
            a.drawDoubleLine();
            bus.displayInfo();
        }
        a.drawLine();
    }

    public void displayTicketCostSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Collections.sort(a.getFilteredBusList(), new CostComparator());
        for (BusInfo bus : a.getFilteredBusList()) {
            a.drawDoubleLine();
            bus.displayInfo();
        }
        a.drawLine();
    }

    public void displayBusNumberSortedFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        Collections.sort(a.getFilteredBusList(), new BusNumberComparator());
        for (BusInfo bus : a.getFilteredBusList()) {
            a.drawDoubleLine();
            bus.displayInfo();
        }
        a.drawLine();
    }

    public void showSortingFunctions() {
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

    public boolean isFilteredBusListEmpty(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        if (a.getFilteredBusList().isEmpty()) {
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
        String generatedTicketID = generateTicketID();
        ticketInfo.setTicketID(generatedTicketID);
        String passengerName = getPassengerName();
        String passengerIdNumber = getPassengerIdNumber();
        Date dateOfJourney = ticketInfo.getDateOfJourney();
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormatter.format(dateOfJourney);
        int busNumber = ticketInfo.getBusNumber();
        String fromCity = getFromCity(a.getPassengerList(), a.getBusList());
        String toCity = getToCity(a.getPassengerList(), a.getBusList());
        // Displaying Ticket
        displayTicket(generatedTicketID, passengerName, passengerIdNumber, formattedDate, busNumber, fromCity, toCity);
    }

    // Map Bill Details
    public void mapAndDisplayBillDetails() {
        int totalNumberOfSeats = ticketInfo.getTotalNumberOfSeats();
        double ticketAmount = getCostOfTicket(a.getPassengerList(), a.getBusList());
        double taxPercentage = PassengerInfo.taxPercentage * 100;
        double taxAmount = getTaxOfTicket(a.getPassengerList(), a.getBusList());
        double totalAmountPerTicket = getTotalCostOfTicket(a.getPassengerList(), a.getBusList());
        double totalAmount = getTotalCost(a.getPassengerList(), a.getBusList());
        // Displaying the cost of ticket after tax calculation
        displayBill(totalNumberOfSeats, ticketAmount, taxPercentage, taxAmount, totalAmountPerTicket, totalAmount);
    }

    // Display Ticket
    public void displayTicket(String ticketID, String passengerName, String passengerIdNumber, String formattedDate, int busNumber, String fromCity, String toCity) {
        a.drawDoubleLine();
        System.out.println( "================================================== TICKET =======================================================");
        a.drawDoubleLine();
        System.out.println("\033[0;1m" + "Reservation Status:" + "\033[0;0m" + "Success!");
        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + ticketID);
        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + passengerName);
        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + passengerIdNumber);
        System.out.println("\033[0;1m" + "Date Of Journey: " + "\033[0;0m" + formattedDate);
        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + busNumber);
        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + fromCity);
        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + toCity);
    }

    // Display Bookings for Admin
    public void displayBookings(String ticketID, String passengerName, String passengerIdNumber, int busNumber, String formattedDate, int totalNumberOfSeats, String fromCity, String toCity, double totalAmount) {
        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + ticketID);
        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + passengerName);
        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + passengerIdNumber);
        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + busNumber);
        System.out.println("\033[0;1m" + "Date of Journey: " + "\033[0;0m" + formattedDate);
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + totalNumberOfSeats);
        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + fromCity);
        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + toCity);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + totalAmount);
        a.drawDoubleLine();
    }

    // Display Bill
    public void displayBill(int totalNumberOfSeats, double ticketAmount, double taxPercentage, double taxAmount, double totalAmountPerTicket, double totalAmount) {
        System.out.println("\033[0;1m" + "--------------------------------------------------- BILL --------------------------------------------------------" + "\033[0;0m");
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + totalNumberOfSeats);
        System.out.println("\033[0;1m" + "Ticket Cost: " + "\033[0;0m" + "₹" + ticketAmount);
        System.out.println("\033[0;1m" + "Tax Percentage: " + "\033[0;0m" + taxPercentage + "%");
        System.out.println("\033[0;1m" + "Tax amount: " + "\033[0;0m" + "₹" + taxAmount);
        System.out.println("\033[0;1m" + "The Total Cost per Ticket: " + "\033[0;0m" + "₹" + totalAmountPerTicket);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + totalAmount);
        a.drawDoubleLine();
    }
}