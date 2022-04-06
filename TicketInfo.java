import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

class TicketInfo {
    private Date dateOfJourney;
    private int totalNumberOfSeats;
    private String agencyName;
    private String fromCity;
    private String toCity;
    private int busNumber;
    private String ticketID;
    private double ticketAmount;
    private double taxPercentage = 0.05;
    private double taxAmount;
    private double totalAmountPerTicket;
    private double discountedAmount;
    private double totalAmount;

    Scanner scanner = new Scanner(System.in);
    PassengerInfo passengerInfo = new PassengerInfo();

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(double ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmountPerTicket() {
        return totalAmountPerTicket;
    }

    public void setTotalAmountPerTicket(double totalAmountPerTicket) {
        this.totalAmountPerTicket = totalAmountPerTicket;
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String generateTicketID() {
        setTicketID(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        return getTicketID();
    }

    // Display Ticket
    public void displayTicket(String passengerName, String passengerIdNumber, String formattedDate) {
        Utilities util = new Utilities();
        util.ticketLineMsg();
        System.out.println("\033[0;1m" + "Reservation Status: " + "\033[0;0m" + "Success!");
        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + ticketID);
        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + passengerName);
        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + passengerIdNumber);
        System.out.println("\033[0;1m" + "Date Of Journey: " + "\033[0;0m" + formattedDate);
        System.out.println("\033[0;1m" + "Agency Name: " + "\033[0;0m" + agencyName);
        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + busNumber);
        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + fromCity);
        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + toCity);
    }

    // Display Bill
    public void displayBill() {
        Utilities util = new Utilities();
        util.billLineMsg();
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + totalNumberOfSeats);
        System.out.println("\033[0;1m" + "Ticket Cost: " + "\033[0;0m" + "₹" + ticketAmount);
        System.out.println("\033[0;1m" + "Tax Percentage: " + "\033[0;0m" + taxPercentage + "%");
        System.out.println("\033[0;1m" + "Tax amount: " + "\033[0;0m" + "₹" + taxAmount);
        System.out.println("\033[0;1m" + "The Total Cost per Ticket: " + "\033[0;0m" + "₹" + totalAmountPerTicket);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + totalAmount);
        util.drawDoubleLine();
    }

    public void displayBill(double discountInPercent) {
        Utilities util = new Utilities();
        util.billLineMsg();
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + totalNumberOfSeats);
        System.out.println("\033[0;1m" + "Ticket Cost: " + "\033[0;0m" + "₹" + ticketAmount);
        System.out.println("\033[0;1m" + "Tax Percentage: " + "\033[0;0m" + taxPercentage + "%");
        System.out.println("\033[0;1m" + "Tax amount: " + "\033[0;0m" + "₹" + taxAmount);
        System.out.println("\033[0;1m" + "The Total Cost per Ticket: " + "\033[0;0m" + "₹" + totalAmountPerTicket);
        System.out.println("\033[0;1m" + "The Discount Percentage is: " + "\033[0;0m" + discountInPercent + "%");
        System.out.println("\033[0;1m" + "The Discounted amount is: " + "\033[0;0m" + "₹" + discountedAmount);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + totalAmount);
        util.drawDoubleLine();
    }

    // Constructor
    TicketInfo() {
        System.out.println("\033[0;1m" + "Enter the Boarding city" + "\033[0;0m");
        setFromCity(scanner.next());
        System.out.println("\033[0;1m" + "Enter the Destination city" + "\033[0;0m");
        setToCity(scanner.next());
    }

    public String getFormattedDateOfJourney() {
        Utilities util = new Utilities();
        return util.dateFormatter().format(getDateOfJourney());
    }

    public void getAgencyNameFromUser() {
        System.out.println("\033[0;1m" + "Enter the travel agency name" + "\033[0;0m");
        setAgencyName(scanner.next());
    }

    public void getBusNumberFromUser() throws BusNumberException {
        boolean validateBusNumber = false;
        while (!validateBusNumber) {
            System.out.println("\033[0;1m" + "Enter the Bus Number" + "\033[0;0m");
            AdminInfo a = new AdminInfo();
            setBusNumber(Integer.parseInt(scanner.next()));
            validateBusNumber = a.getBusList().stream().map(BusInfo::getBusNumber).anyMatch(b -> b == getBusNumber());
            if (!validateBusNumber) {
                throw new BusNumberException("Try Again, enter the available bus number");
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
                setDateOfJourney(util.dateFormatter().parse(scanner.next()));
                isSucessful = true;
            } catch (ParseException e) {
                System.out.println("Invalid date, try again!");
                isSucessful = false;
            }
        }
    }

    public void getSeatsRequired() {
        boolean isSucessful = false;
        while (!isSucessful) {
            System.out.println("\033[0;1m" + "Enter total no:of seats needed" + "\033[0;0m");
            try {
                setTotalNumberOfSeats(Integer.parseInt(scanner.next()));
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
        ArrayList<BusInfo> fromToSearchBusList = (ArrayList<BusInfo>) adminInfo.getBusList().stream().filter(b -> b.getFromCity().equalsIgnoreCase(getFromCity())&& b.getToCity().equalsIgnoreCase(getToCity())).collect(Collectors.toList());
        return fromToSearchBusList;
    }

    public ArrayList<BusInfo> agencySearchList() {
        AdminInfo adminInfo = new AdminInfo();
        ArrayList<BusInfo> agencySearchBusList = (ArrayList<BusInfo>) adminInfo.getBusList().stream().filter(b -> b.getAgencyName().equalsIgnoreCase(getAgencyName()) && b.getFromCity().equalsIgnoreCase(getFromCity()) && b.getToCity().equalsIgnoreCase(getToCity())).collect(Collectors.toList());
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
    public void displayJourneyHrsSortedFilteredBusList(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        ArrayList<BusInfo> journeyHrsSortedList = (ArrayList<BusInfo>) agencySearchList().stream().sorted(Comparator.comparingInt(BusInfo::getApproxJourneyHrs)).collect(Collectors.toList());
        Utilities util = new Utilities();
        for (BusInfo bus : journeyHrsSortedList) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void displayTicketCostSortedFilteredBusList(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        ArrayList<BusInfo> ticketCostSortedList = (ArrayList<BusInfo>) agencySearchList().stream().sorted(Comparator.comparingDouble(BusInfo::getCostOfTicket)).collect(Collectors.toList());
        for (BusInfo bus : ticketCostSortedList) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void displayBusNumberSortedFilteredBusList(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        ArrayList<BusInfo> busNumberSortedList = (ArrayList<BusInfo>) agencySearchList().stream().sorted(Comparator.comparingInt(BusInfo::getBusNumber)).collect(Collectors.toList());
        for (BusInfo bus : busNumberSortedList) {
            util.drawDoubleLine();
            bus.displayInfo();
        }
        util.drawLine();
    }

    public void showSortingFunctions() {
        AdminInfo a = new AdminInfo();
        Utilities util = new Utilities();
        int sortOption = 1;
        while (sortOption == 1 || sortOption == 2 || sortOption == 3) {
            System.out.println("Enter: \n1: To Sort based on Journey Hrs \n2: To Sort based on Ticket Cost \n3: To Sort based on Bus Number \n4: To continue booking");
            try {
                sortOption = Integer.parseInt(scanner.next());
                util.optionValidator(sortOption, 1, 4);
                switch (sortOption) {
                    case 1:
                        displayJourneyHrsSortedFilteredBusList(a.getTicketList(), a.getBusList());
                        break;
                    case 2:
                        displayTicketCostSortedFilteredBusList(a.getTicketList(), a.getBusList());
                        break;
                    case 3:
                        displayBusNumberSortedFilteredBusList(a.getTicketList(), a.getBusList());
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
    public int displayRemainingSeats(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        int availableSeats = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                availableSeats = bus.getBusCapacity();
            }
        }
        for (TicketInfo t : ticketList) {
            if (t.getBusNumber() == getBusNumber() && t.getDateOfJourney().equals(getDateOfJourney())) {
                availableSeats = availableSeats - t.getTotalNumberOfSeats();
            }
        }
        return availableSeats;
    }

    boolean isAvailable(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        // Fetching the BusCapacity from the BusNumber entered by the user
        int busCapacity = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                busCapacity = bus.getBusCapacity();
            }
        }
        // Using this as a counter
        int reservedTickets = 0;
        for (TicketInfo t : ticketList) {
            if (t.getBusNumber() == getBusNumber()
                    && t.getDateOfJourney().equals(getDateOfJourney())) {
                reservedTickets = reservedTickets + t.getTotalNumberOfSeats();
            }
        }
        // Checking the capacity and returning accordingly
        if (reservedTickets + getTotalNumberOfSeats() <= busCapacity) {
            return true;
        } else {
            return false;
        }
    }

    // For Displaying in the ticket section
    public String getFromCity(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        String fromCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                fromCity = bus.getFromCity();
            }
        }
        return fromCity;
    }

    public String getToCity(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        String toCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                toCity = bus.getToCity();
            }
        }
        return toCity;
    }

    // Displaying the ticket amount
    public double getCostOfTicket(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
            }
        }
        return ticketPrice;
    }

    // Displaying the Tax amount
    public double getTaxOfTicket(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        double taxPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
                // Calculating GST of 5%
                taxPrice = ticketPrice * (getTaxPercentage()/100);
            }
        }
        return taxPrice;
    }

    // Displaying the total amount for single ticket
    public double getTotalCostOfTicket(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        double ticketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
                // Calculating Total cost including GST.
                ticketPriceWithTax = ticketPrice + (ticketPrice * (getTaxPercentage()/100));
            }
        }
        return ticketPriceWithTax;
    }

    // Calculating the total amount with total seats booked
    public double getTotalCost(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        double ticketPrice = 0;
        double ticketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                ticketPrice = bus.getCostOfTicket();
                // Calculating Total cost including GST.
                ticketPriceWithTax = getTotalNumberOfSeats() * ticketPrice + (getTotalNumberOfSeats() * ticketPrice * (getTaxPercentage()/100));
            }
        }
        return ticketPriceWithTax;
    }

    // Map Ticket Bookings
    public void mapAndDisplayTicketDetails() {
        Utilities util = new Utilities();
        setTicketID(generateTicketID());
        setAgencyName(getAgencyName());
        setBusNumber(getBusNumber());
        setFromCity(getFromCity());
        setToCity(getToCity());
        // Displaying Ticket
        displayTicket(passengerInfo.getPassengerName(), passengerInfo.getPassengerIdNumber(), util.dateFormatter().format(getDateOfJourney()));
    }

    // Map Bill Details
    public void mapAndDisplayBillDetails() {
        AdminInfo a = new AdminInfo();
        setTotalNumberOfSeats(getTotalNumberOfSeats());
        setTicketAmount(getCostOfTicket(a.getTicketList(), a.getBusList()));
        setTaxPercentage(getTaxPercentage() * 100);
        setTaxAmount(getTaxOfTicket(a.getTicketList(), a.getBusList()));
        setTotalAmountPerTicket(getTotalCostOfTicket(a.getTicketList(), a.getBusList()));
        setTotalAmount(getTotalCost(a.getTicketList(), a.getBusList()));
        // Displaying the cost of ticket after tax calculation
        displayBill();
    }

    // Map Bill Details
    public void mapAndDisplayBillDetails(double discoutPercentage) {
        AdminInfo a = new AdminInfo();
        setTotalNumberOfSeats(getTotalNumberOfSeats());
        setTicketAmount(getCostOfTicket(a.getTicketList(), a.getBusList()));
        setTaxPercentage(getTaxPercentage() * 100);
        setTaxAmount(getTaxOfTicket(a.getTicketList(), a.getBusList()));
        setTotalAmountPerTicket(getTotalCostOfTicket(a.getTicketList(), a.getBusList()));
        double discountInPercent = discoutPercentage * 100;
        setDiscountedAmount(getTotalCost(a.getTicketList(), a.getBusList()) * discoutPercentage);
        setTotalAmount(getTotalCost(a.getTicketList(), a.getBusList()) - getDiscountedAmount());
        // Displaying the cost of ticket after tax calculation
        displayBill(discountInPercent);
    }
}
