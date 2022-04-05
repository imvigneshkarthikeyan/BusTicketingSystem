import java.util.*;

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

    public void getPassengerDetails() {
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
}