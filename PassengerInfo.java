import java.util.*;
import java.text.*;
//For Date Validation
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

interface Showable {
    void FilterBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    void DisplayFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    boolean IsFilteredBusListEmpty(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    int DisplayRemainingSeats(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    String getFromCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    String getToCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getTaxOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getTotalCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getTotalCost(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    void DrawLine();
    void DisplayTicket(String TicketID, String PassengerName, String PassengerIdNumber, String FormattedDate, int BusNumber, String FromCity, String ToCity);
    void DisplayBill(int TotalNumberOfSeats, double TicketAmount, double TaxPercentage, double TaxAmount, double TotalAmountPerTicket, double TotalAmount);
}

class PassengerInfo implements Showable {
    Scanner scanner = new Scanner(System.in);
    private String PassengerName;
    private String PassengerPhoneNumber;
    private int BusNumber;
    private Date DateOfJourney;
    private String PassengerIdNumber;
    private int TotalNumberOfSeats;
    private String FromCity;
    private String ToCity;
    private String TicketID;
    //Using TaxPercentage as Static, as a copy of TaxPercentage is not required in all the objects.
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

    public String generateTicketID() {
        TicketID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return TicketID;
    }
    
    // ArrayList for filteredbusList
    public ArrayList<BusInfo> filteredBusList = new ArrayList<>();

    // Constructor
    PassengerInfo() {
        System.out.println("\033[0;1m" + "Enter the Boarding city" + "\033[0;0m");
        FromCity = scanner.next();
        System.out.println("\033[0;1m" + "Enter the Destination city" + "\033[0;0m");
        ToCity = scanner.next();
    }

    public void GetDateOfJourneyFromUser() {
        System.out.println("\033[0;1m" + "Enter the Bus Number" + "\033[0;0m");
        BusNumber = scanner.nextInt();
        System.out.println("\033[0;1m" + "Enter the date of journey in DD-MM-YYYY" + "\033[0;0m");
        String DateInput = scanner.next();
        // Converting the string to date
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            DateOfJourney = DateFormat.parse(DateInput);
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
        System.out.println("\033[0;1m" + "Enter the Aadhar / PAN Number" + "\033[0;0m");
        PassengerIdNumber = scanner.next();
        System.out.println("\033[0;1m" + "Enter total no:of seats needed" + "\033[0;0m");
        TotalNumberOfSeats = scanner.nextInt();
    }

    // Filtering
    public void FilterBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : busList) {
            if (bus.getFromCity().equalsIgnoreCase(FromCity) && bus.getToCity().equalsIgnoreCase(ToCity)) {
                filteredBusList.add(bus);
            }
        }
    }

    public void DisplayFilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : filteredBusList) {
            System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
            bus.DisplayBusInfo();
        }
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
    }

    public boolean IsFilteredBusListEmpty(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        if (filteredBusList.isEmpty()) {
            return true;
        }
        return false;
    }

    //Availability Checker
    public int DisplayRemainingSeats(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        int AvailableSeats = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                AvailableSeats = bus.getBusCapacity();
            }
        }
        for (PassengerInfo p : passengerList) {
            if (p.BusNumber == BusNumber && p.DateOfJourney.equals(DateOfJourney)) {
                AvailableSeats = AvailableSeats - p.TotalNumberOfSeats;
            }
        }
        return AvailableSeats;
    }
    boolean IsAvailable(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        // Fetching the BusCapacity from the BusNumber entered by the user
        int BusCapacity = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                BusCapacity = bus.getBusCapacity();
            }
        }
        // Using this as a counter
        int ReservedTickets = 0;
        for (PassengerInfo p : passengerList) {
            if (p.BusNumber == BusNumber && p.DateOfJourney.equals(DateOfJourney)) {
                ReservedTickets = ReservedTickets + p.TotalNumberOfSeats;
            }
        }
        // Checking the capacity and returning accordingly
        if (ReservedTickets + TotalNumberOfSeats <= BusCapacity) {
            return true;
        } else {
            return false;
        }
    }

    //For Displaying in the ticket section
    public String getFromCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        String FromCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                FromCity = bus.getFromCity();
            }
        }
        return FromCity;
    }
    
    public String getToCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        String ToCity = "";
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                ToCity = bus.getToCity();
            }
        }
        return ToCity;
    }
    //Displaying the ticket amount
    public double getCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                TicketPrice = bus.getCostOfTicket();
            }
        }
        return TicketPrice;
    }
    //Displaying the Tax amount
    public double getTaxOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        double TaxPrice = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                TicketPrice = bus.getCostOfTicket();
                // Calculating GST of 5%
                TaxPrice = TicketPrice * TaxPercentage;
            }
        }
        return TaxPrice;
    }
    //Displaying the total amount
    public double getTotalCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        double TicketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                TicketPrice = bus.getCostOfTicket();
                //Calculating Total cost including GST. 
                TicketPriceWithTax = TicketPrice + (TicketPrice * TaxPercentage);
            }
        }
        return TicketPriceWithTax;
    }
    // getTotalCost
    public double getTotalCost(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        double TicketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                TicketPrice = bus.getCostOfTicket();
                // Calculating Total cost including GST.
                TicketPriceWithTax = TotalNumberOfSeats*TicketPrice + (TotalNumberOfSeats * TicketPrice * TaxPercentage);
            }
        }
        return TicketPriceWithTax;
    }

    // Draw Line
    public void DrawLine() {
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
    }

    // Display Ticket
    public void DisplayTicket(String TicketID, String PassengerName, String PassengerIdNumber, String FormattedDate, int BusNumber, String FromCity, String ToCity) {
        System.out.println("\033[0;1m" + "=================================================================================================================");
        System.out.println("================================================== TICKET =======================================================");
        System.out.println("=================================================================================================================" + "\033[0;0m");
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
    public void DisplayBookings(String TicketID, String PassengerName, String PassengerIdNumber, int BusNumber,
        String FormattedDate, int TotalNumberOfSeats, String FromCity, String ToCity, double TotalAmount) {
        System.out.println("\033[0;1m" + "Ticket ID: " + "\033[0;0m" + TicketID);
        System.out.println("\033[0;1m" + "Passenger Name: " + "\033[0;0m" + PassengerName);
        System.out.println("\033[0;1m" + "Aadhar Number: " + "\033[0;0m" + PassengerIdNumber);
        System.out.println("\033[0;1m" + "Bus Number: " + "\033[0;0m" + BusNumber);
        System.out.println("\033[0;1m" + "Date of Journey: " + "\033[0;0m" + FormattedDate);
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + TotalNumberOfSeats);
        System.out.println("\033[0;1m" + "Boarding: " + "\033[0;0m" + FromCity);
        System.out.println("\033[0;1m" + "Destination: " + "\033[0;0m" + ToCity);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + TotalAmount);
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
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
        System.out.println("\033[0;1m" + "=================================================================================================================" + "\033[0;0m");
    }
}