import java.util.*;
import java.text.*;

class BusInfo {
    private int BusNumber;
    private int BusCapacity;
    private String BusFacility;
    private float CostOfTicket;
    //GettersSetters for private attributes
    public int getBusNumber() {
        return BusNumber;
    }
    public void setBusNumber(int busNumber) {
        BusNumber = busNumber;
    }
    public int getBusCapacity() {
        return BusCapacity;
    }
    public void setBusCapacity(int busCapacity) {
        BusCapacity = busCapacity;
    }
    public String getBusFacility(){
        return BusFacility;
    }
    public void setBusFacility(String busFacility) {
        BusFacility = busFacility;
    }
    public float setCostOfTicket() {
        return CostOfTicket;
    }
    public void getCostOfTicket(float costOfTicket) {
        CostOfTicket = costOfTicket;
    }
    //Constructor for Bus
    BusInfo(int busNumber, int busCapacity, String busFacility, float costOfTicket){
        BusNumber = busNumber;
        BusCapacity = busCapacity;
        BusFacility = busFacility;
        CostOfTicket = costOfTicket;
    }
    //Display Method
    public void DisplayBusInfo() {
        System.out.println("Bus Number:" + BusNumber + " | Seats Available:" + BusCapacity + " | Facility:" + BusFacility + " | Ticket Cost:" + CostOfTicket);
    }
}

class PassengerInfo {
    private String PassengerName;
    private String PassengerPhoneNumber;
    private int BusNumber;
    private Date DateOfJourney;
    //GettersSetters for private attributes
    public String getPassengerName() {
        return PassengerName;
    }
    //Using this when the attributes are same
    public void setPassengerName(String PassengerName) {
        this.PassengerName = PassengerName;
    }
    public String getPassengerPhoneNumber() {
        return PassengerPhoneNumber;
    }
    public void setPassengerPhoneNumber(String PassengerPhoneNumber) {
        this.PassengerPhoneNumber = PassengerPhoneNumber;
    }
    public int getBusNumber(){
        return BusNumber;
    }
    public void setBusNumber(int BusNumber){
        this.BusNumber = BusNumber;
    }
    public Date getDateOfJourney() {
        return DateOfJourney;
    }
    public void setDateOfJourney(Date DateOfJourney) {
        this.DateOfJourney = DateOfJourney;
    }
    // Constructor
    PassengerInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the Passenger");
        PassengerName = scanner.next();
        System.out.println("Enter the phone number");
        PassengerPhoneNumber = scanner.next();
        System.out.println("Enter the bus number");
        BusNumber = scanner.nextInt();
        System.out.println("Enter the date of journey in DD-MM-YYYY");
        String DateInput = scanner.next();
        //Converting the string to date
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            DateOfJourney = DateFormat.parse(DateInput);
        } catch (ParseException e) {
            //Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public class BusTicketingSystem {
    public static void main(String [] args) {
        // ArrayList for BusInfo 
        ArrayList<BusInfo> busList = new ArrayList<>();
        ArrayList<PassengerInfo> passengerList = new ArrayList<>();
        //Adding new buses into ArrayList
        busList.add(new BusInfo(1, 20, "AC", 750));
        busList.add(new BusInfo(2, 32, "Sleeper", 600));
        busList.add(new BusInfo(3, 20, "Semi-Sleeper", 400));
        busList.add(new BusInfo(4, 20, "Normal", 250));
        // Option given by User
        int SelectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        // ForEach loop to fetch the elements from array list
        for (BusInfo b : busList) {
            b.DisplayBusInfo();
        }
        // Loop for Booking
        while (SelectedOption == 1) {
            System.out.println("Enter option: \n1: Start a new Booking \n2: Login as Admin \n3: Quit\n");
            SelectedOption = scanner.nextInt();
            if (SelectedOption == 1) {
                System.out.println("Initiated Booking...");
            } else if (SelectedOption == 2) {
                System.out.println("Entering into Admin Login");
            } else {
                System.out.println("Quiting the application");
            }
        }
    }
}