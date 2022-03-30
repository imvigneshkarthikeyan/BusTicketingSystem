import java.util.*;

class TicketInfo {
    private Date dateOfJourney;
    private int totalNumberOfSeats;
    private String agencyName;
    private String fromCity;
    private String toCity;
    private int busNumber;
    private String ticketID;
    private double ticketAmount;
    private double taxPercentage;
    private double taxAmount;
    private double totalAmountPerTicket;
    private double totalAmount;
    
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

    Utilities util = new Utilities();

    // Display Ticket
    public void displayTicket(String passengerName, String passengerIdNumber, String formattedDate) {
        util.ticketLineMsg();
        System.out.println("\033[0;1m" + "Reservation Status:" + "\033[0;0m" + "Success!");
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
        util.billLineMsg();
        System.out.println("\033[0;1m" + "Total No:of Seats: " + "\033[0;0m" + totalNumberOfSeats);
        System.out.println("\033[0;1m" + "Ticket Cost: " + "\033[0;0m" + "₹" + ticketAmount);
        System.out.println("\033[0;1m" + "Tax Percentage: " + "\033[0;0m" + taxPercentage + "%");
        System.out.println("\033[0;1m" + "Tax amount: " + "\033[0;0m" + "₹" + taxAmount);
        System.out.println("\033[0;1m" + "The Total Cost per Ticket: " + "\033[0;0m" + "₹" + totalAmountPerTicket);
        System.out.println("\033[0;1m" + "The Total Cost: " + "\033[0;0m" + "₹" + totalAmount);
        util.drawDoubleLine();
    }

    public void displayBill(double discountInPercent, double discountedAmount) {
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
}
