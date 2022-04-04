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
}