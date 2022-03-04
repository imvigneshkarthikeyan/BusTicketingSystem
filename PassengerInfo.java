import java.util.*;
import java.text.*;

class PassengerInfo {
    private String PassengerName;
    private String PassengerPhoneNumber;
    private int BusNumber;
    private Date DateOfJourney;

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
    }

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
                ReservedTickets = ReservedTickets + 1;
            }
        }
        // Checking the capacity and returning accordingly
        if (ReservedTickets < BusCapacity) {
            return true;
        } else {
            return false;
        }
    }
    //Cost of the Ticket including Taxes
    public double getCostOfTicket(ArrayList<PassengerInfo> passengerList, ArrayList<BusInfo> busList) {
        double TicketPrice = 0;
        double TicketPriceWithTax = 0;
        for (BusInfo bus : busList) {
            if (bus.getBusNumber() == BusNumber) {
                TicketPrice = bus.getCostOfTicket();
                TicketPriceWithTax = TicketPrice + (TicketPrice * 0.05);
            }
        }
        return TicketPriceWithTax;
    }
    
}