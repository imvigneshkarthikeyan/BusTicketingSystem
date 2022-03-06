import java.util.*;
import java.text.*;

class PassengerInfo {
    private String PassengerName;
    private String PassengerPhoneNumber;
    private int BusNumber;
    private Date DateOfJourney;
    private String PassengerIdNumber;
    private int TotalNumberOfSeats;

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

    // Constructor
    PassengerInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the bus number");
        BusNumber = scanner.nextInt();
        System.out.println("Enter the date of journey in DD-MM-YYYY");
        String DateInput = scanner.next();
        // Converting the string to date
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            DateOfJourney = DateFormat.parse(DateInput);
        } catch (ParseException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Enter the name of the Passenger");
        PassengerName = scanner.next();
        System.out.println("Enter the phone number");
        PassengerPhoneNumber = scanner.next();
        System.out.println("Enter the Aadhar / PAN Number");
        PassengerIdNumber = scanner.next();
        System.out.println("Enter total no:of seats needed");
        TotalNumberOfSeats = scanner.nextInt();
    }

    //Ticket Availability Checker
    public boolean IsAvailable(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
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
        if (ReservedTickets < BusCapacity) {
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
                TaxPrice = TicketPrice * 0.05;
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
                TicketPriceWithTax = TicketPrice + (TicketPrice * 0.05);
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
                TicketPriceWithTax = TotalNumberOfSeats*TicketPrice + (TicketPrice * 0.05);
            }
        }
        return TicketPriceWithTax;
    }
}