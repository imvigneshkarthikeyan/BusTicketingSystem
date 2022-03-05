class BusInfo {
    private int BusNumber;
    private String FromCity;
    private String ToCity;
    private int BusCapacity;
    private String BusFacility;
    private double CostOfTicket;

    // GettersSetters for private attributes
    public int getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(int busNumber) {
        BusNumber = busNumber;
    }

    public String getFromCity() {
        return FromCity;
    }

    public void setFromCity(String fromCity) {
        FromCity = fromCity;
    }

    public String getToCity() {
        return ToCity;
    }

    public void setToCity(String toCity) {
        ToCity = toCity;
    }

    public int getBusCapacity() {
        return BusCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        BusCapacity = busCapacity;
    }

    public String getBusFacility() {
        return BusFacility;
    }

    public void setBusFacility(String busFacility) {
        BusFacility = busFacility;
    }

    public double getCostOfTicket() {
        return CostOfTicket;
    }

    public void setCostOfTicket(double costOfTicket) {
        CostOfTicket = costOfTicket;
    }

    // Constructor to create new Bus
    BusInfo(int busNumber, String fromCity, String toCity, int busCapacity, String busFacility, double costOfTicket) {
        BusNumber = busNumber;
        FromCity = fromCity;
        ToCity = toCity;
        BusCapacity = busCapacity;
        BusFacility = busFacility;
        CostOfTicket = costOfTicket;
    }

    // Display Method
    public void DisplayBusInfo() {
        System.out.println("Bus Number:" + BusNumber + " | From: " + FromCity + " | To: " + ToCity + " | Seat Availability:" + BusCapacity + " | Facility:"
                + BusFacility + " | Ticket Cost:" + CostOfTicket);
    }
}