import java.util.*;
import java.text.*;
//For Date Validation
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class TicketInfo {
    private Date DateOfJourney;
    private int TotalNumberOfSeats;
    private String FromCity;
    private String ToCity;
    private int BusNumber;
    private String TicketID;

    public int getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(int BusNumber) {
        this.BusNumber = BusNumber;
    }

    public Date getDateOfJourney() {
        return DateOfJourney;
    }

    public void setDateOfJourney(Date DateOfJourney) {
        this.DateOfJourney = DateOfJourney;
    }
    
    public int getTotalNumberOfSeats() {
        return TotalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int TotalNumberOfSeats) {
        this.TotalNumberOfSeats = TotalNumberOfSeats;
    }

    public String getFromCity() {
        return FromCity;
    }

    public void setFromCity(String FromCity) {
        this.FromCity = FromCity;
    }

    public String getToCity() {
        return ToCity;
    }

    public void setToCity(String ToCity) {
        this.ToCity = ToCity;
    }

    public String getTicketID() {
        return TicketID;
    }

    public void setTicketID(String TicketID) {
        this.TicketID = TicketID;
    }

}

class PassengerInfo extends TicketInfo {
    Scanner scanner = new Scanner(System.in);
    private String PassengerName;
    private String PassengerPhoneNumber;
    private String PassengerIdNumber;
    
    // Using TaxPercentage as Static, as a copy of TaxPercentage is not required in all the objects.
    protected static double TaxPercentage;
    static {
        TaxPercentage = 0.05;
    }

    // GettersSetters for private attributes
    public String getPassengerName() {
        return PassengerName;
    }

    // Using this when the attributes are same
    public void setPassengerName(String PassengerName) {
        this.PassengerName = PassengerName;
    }

    public String getPassengerPhoneNumber() {
        return PassengerPhoneNumber;
    }

    public void setPassengerPhoneNumber(String PassengerPhoneNumber) {
        this.PassengerPhoneNumber = PassengerPhoneNumber;
    }

    public String getFormattedDateOfJourney() {
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String FormattedDate = dateFormatter.format(getDateOfJourney());
        return FormattedDate;
    }

    public String getPassengerIdNumber() {
        return PassengerIdNumber;
    }

    public void setPassengerIdNumber(String PassengerIdNumber) {
        this.PassengerIdNumber = PassengerIdNumber;
    }

    public String generateTicketID() {
        setTicketID(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        return getTicketID();
    }

    // Constructor
    PassengerInfo() {
        System.out.println("\033[0;1m" + "Enter the Boarding city" + "\033[0;0m");
        setFromCity(scanner.next());
        System.out.println("\033[0;1m" + "Enter the Destination city" + "\033[0;0m");
        setToCity(scanner.next());
    }

    public void GetBusNumberFromUser() {
        System.out.println("\033[0;1m" + "Enter the Bus Number" + "\033[0;0m");
        setBusNumber(scanner.nextInt());
    }

    public void GetDateOfJourneyFromUser() {
        System.out.println("\033[0;1m" + "Enter the date of journey in DD-MM-YYYY" + "\033[0;0m");
        String DateInput = scanner.next();
        // Converting the string to date
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            setDateOfJourney(DateFormat.parse(DateInput));
        } catch (ParseException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Validation: Is entered date a future date
    public boolean IsDateFuture(String Date, String DateFormat) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DateFormat);
        LocalDate inputDate = LocalDate.parse(Date, dtf);
        return inputDate.isAfter(localDate);
    }

    public void GetOtherPassengerInfo() {
        System.out.println("\033[0;1m" + "Enter the name of the Passenger" + "\033[0;0m");
        PassengerName = scanner.next();
        System.out.println("\033[0;1m" + "Enter the phone number" + "\033[0;0m");
        PassengerPhoneNumber = scanner.next();
        // Phone Number Validation
        while (PassengerPhoneNumber.length() != 10) {
            System.out.println("Please enter a valid 10 digit phone number \n Eg: 9876543210");
            PassengerPhoneNumber = scanner.next();
        }
        System.out.println("\033[0;1m" + "Enter the Aadhar Number" + "\033[0;0m");
        PassengerIdNumber = scanner.next();
        // ID Number Validation
        while (PassengerIdNumber.length() != 12) {
            System.out.println("Enter a Valid 12 Digit Aadhar Number without spaces \nEg: 814273020135");
            PassengerIdNumber = scanner.next();
        }
    }

    public void GetSeatsRequired() {
        System.out.println("\033[0;1m" + "Enter total no:of seats needed" + "\033[0;0m");
        setTotalNumberOfSeats(scanner.nextInt());
    }

    AdminInfo a = new AdminInfo();
    // Filtering
    public void FilterBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : busList) {
            if (bus.getFromCity().equalsIgnoreCase(getFromCity()) && bus.getToCity().equalsIgnoreCase(getToCity())) {
                a.getFilteredBusList().add(bus);
            }
        }
    }

    public void DisplayFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : a.getFilteredBusList()) {
            a.DrawDoubleLine();
            bus.DisplayBusInfo();
        }
        a.DrawLine();
    }

    public boolean IsFilteredBusListEmpty(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        if (a.getFilteredBusList().isEmpty()) {
            return true;
        }
        return false;
    }

    // Availability Checker
    public int DisplayRemainingSeats(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        int AvailableSeats = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                AvailableSeats = bus.getBusCapacity();
            }
        }
        for (PassengerInfo p : passengerList) {
            if (p.getBusNumber() == getBusNumber() && p.getDateOfJourney().equals(getDateOfJourney())) {
                AvailableSeats = AvailableSeats - p.getTotalNumberOfSeats();
            }
        }
        return AvailableSeats;
    }

    boolean IsAvailable(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        // Fetching the BusCapacity from the BusNumber entered by the user
        int BusCapacity = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                BusCapacity = bus.getBusCapacity();
            }
        }
        // Using this as a counter
        int ReservedTickets = 0;
        for (PassengerInfo p : passengerList) {
            if (p.getBusNumber() == getBusNumber() && p.getDateOfJourney().equals(getDateOfJourney())) {
                ReservedTickets = ReservedTickets + p.getTotalNumberOfSeats();
            }
        }
        // Checking the capacity and returning accordingly
        if (ReservedTickets + getTotalNumberOfSeats() <= BusCapacity) {
            return true;
        } else {
            return false;
        }
    }

    // For Displaying in the ticket section
    public String getFromCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        String FromCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                FromCity = bus.getFromCity();
            }
        }
        return FromCity;
    }

    public String getToCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        String ToCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                ToCity = bus.getToCity();
            }
        }
        return ToCity;
    }

    // Displaying the ticket amount
    public double getCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                TicketPrice = bus.getCostOfTicket();
            }
        }
        return TicketPrice;
    }

    // Displaying the Tax amount
    public double getTaxOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        double TaxPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                TicketPrice = bus.getCostOfTicket();
                // Calculating GST of 5%
                TaxPrice = TicketPrice * TaxPercentage;
            }
        }
        return TaxPrice;
    }

    // Displaying the total amount for single ticket
    public double getTotalCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        double TicketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                TicketPrice = bus.getCostOfTicket();
                // Calculating Total cost including GST.
                TicketPriceWithTax = TicketPrice + (TicketPrice * TaxPercentage);
            }
        }
        return TicketPriceWithTax;
    }

    // Calculating the total amount with total seats booked
    public double getTotalCost(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        double TicketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == getBusNumber()) {
                TicketPrice = bus.getCostOfTicket();
                // Calculating Total cost including GST.
                TicketPriceWithTax = getTotalNumberOfSeats() * TicketPrice + (getTotalNumberOfSeats() * TicketPrice * TaxPercentage);
            }
        }
        return TicketPriceWithTax;
    }

    // Map Ticket Bookings
    public void MapAndDisplayTicketDetails() {
        String GeneratedTicketID = generateTicketID();
        setTicketID(GeneratedTicketID);
        String PassengerName = getPassengerName();
        String PassengerIdNumber = getPassengerIdNumber();
        Date DateOfJourney = getDateOfJourney();
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String FormattedDate = dateFormatter.format(DateOfJourney);
        int BusNumber = getBusNumber();
        String FromCity = getFromCity(a.getPassengerList(), a.getBusList());
        String ToCity = getToCity(a.getPassengerList(), a.getBusList());
        // Displaying Ticket
        DisplayTicket(GeneratedTicketID, PassengerName, PassengerIdNumber, FormattedDate, BusNumber, FromCity, ToCity);
    }

    // Map Bill Details
    public void MapAndDisplayBillDetails() {
        int TotalNumberOfSeats = getTotalNumberOfSeats();
        double TicketAmount = getCostOfTicket(a.getPassengerList(), a.getBusList());
        double TaxPercentage = PassengerInfo.TaxPercentage * 100;
        double TaxAmount = getTaxOfTicket(a.getPassengerList(), a.getBusList());
        double TotalAmountPerTicket = getTotalCostOfTicket(a.getPassengerList(), a.getBusList());
        double TotalAmount = getTotalCost(a.getPassengerList(), a.getBusList());
        // Displaying the cost of ticket after tax calculation
        DisplayBill(TotalNumberOfSeats, TicketAmount, TaxPercentage, TaxAmount, TotalAmountPerTicket, TotalAmount);
    }

    // Display Ticket
    public void DisplayTicket(String TicketID, String PassengerName, String PassengerIdNumber, String FormattedDate, int BusNumber, String FromCity, String ToCity) {
        a.DrawDoubleLine();
        System.out.println( "================================================== TICKET =======================================================");
        a.DrawDoubleLine();
        System.out.println("\033[0;1m" + "Reservation Status:" + "\033[0;0m" + "Success!");
        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + TicketID);
        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + PassengerName);
        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + PassengerIdNumber);
        System.out.println("\033[0;1m" + "Date Of Journey: " + "\033[0;0m" + FormattedDate);
        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + BusNumber);
        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + FromCity);
        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + ToCity);
    }

    // Display Bookings for Admin
    public void DisplayBookings(String TicketID, String PassengerName, String PassengerIdNumber, int BusNumber, String FormattedDate, int TotalNumberOfSeats, String FromCity, String ToCity, double TotalAmount) {
        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + TicketID);
        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + PassengerName);
        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + PassengerIdNumber);
        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + BusNumber);
        System.out.println("\033[0;1m" + "Date of Journey: " + "\033[0;0m" + FormattedDate);
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + TotalNumberOfSeats);
        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + FromCity);
        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + ToCity);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + TotalAmount);
        a.DrawDoubleLine();
    }

    // Display Bill
    public void DisplayBill(int TotalNumberOfSeats, double TicketAmount, double TaxPercentage, double TaxAmount, double TotalAmountPerTicket, double TotalAmount) {
        System.out.println("\033[0;1m" + "--------------------------------------------------- BILL --------------------------------------------------------" + "\033[0;0m");
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + TotalNumberOfSeats);
        System.out.println("\033[0;1m" + "Ticket Cost: " + "\033[0;0m" + "₹" + TicketAmount);
        System.out.println("\033[0;1m" + "Tax Percentage: " + "\033[0;0m" + TaxPercentage + "%");
        System.out.println("\033[0;1m" + "Tax amount: " + "\033[0;0m" + "₹" + TaxAmount);
        System.out.println("\033[0;1m" + "The Total Cost per Ticket: " + "\033[0;0m" + "₹" + TotalAmountPerTicket);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + TotalAmount);
        a.DrawDoubleLine();
    }
}