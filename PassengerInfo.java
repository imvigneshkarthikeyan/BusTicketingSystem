import java.util.*;
import java.text.*;

interface Showable {
    String getFromCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    String getToCity(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getTaxOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getTotalCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
    double getTotalCost(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList);
}

class PassengerInfo implements Showable {
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

    // Using this when the attributes are same
    public void setFromCity(String FromCity) {
        this.FromCity = FromCity;
    }

    public String ToFromCity() {
        return ToCity;
    }

    // Using this when the attributes are same
    public void setToCity(String ToCity) {
        this.ToCity = ToCity;
    }

    public String getTicketID() {
        TicketID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return TicketID;
    }
    
    // ArrayList for filteredbusList
    public ArrayList<BusInfo> filteredBusList = new ArrayList<>();

    // Constructor
    PassengerInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[0;1m" + "Enter the Boarding city" + "\033[0;0m");
        FromCity = scanner.next();
        System.out.println("\033[0;1m" + "Enter the Destination city" + "\033[0;0m");
        ToCity = scanner.next();
    }

    public void GetOtherPassengerInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033[0;1m" + "Enter the Bus Number" + "\033[0;0m");
        BusNumber = scanner.nextInt();
        System.out.println("\033[0;1m" + "Enter the date of journey in DD-MM-YYYY" +
                "\033[0;0m");
        String DateInput = scanner.next();
        // Converting the string to date
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            DateOfJourney = DateFormat.parse(DateInput);
        } catch (ParseException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("\033[0;1m" + "Enter the name of the Passenger" +
                "\033[0;0m");
        PassengerName = scanner.next();
        System.out.println("\033[0;1m" + "Enter the phone number" + "\033[0;0m");
        PassengerPhoneNumber = scanner.next();
        System.out.println("\033[0;1m" + "Enter the Aadhar / PAN Number" +
                "\033[0;0m");
        PassengerIdNumber = scanner.next();
        System.out.println("\033[0;1m" + "Enter total no:of seats needed" +
                "\033[0;0m");
        TotalNumberOfSeats = scanner.nextInt();
    }

    // Filtering
    public void FilteredBusList(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        for (BusInfo bus : busList) {
            if (bus.getFromCity().equals(FromCity) && bus.getToCity().equals(ToCity)) {
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

    //Ticket Availability Checker
    //Declaring it as Final as it should not be overrided
    final boolean IsAvailable(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
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
        if (ReservedTickets+TotalNumberOfSeats <= BusCapacity) {
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
}