class BusInfo {
    private int BusNumber;
    private int BusCapacity;
    private String BusFacility;
    private float CostOfTicket;

    // GettersSetters for private attributes
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

    public String getBusFacility() {
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

    // Constructor for Bus
    BusInfo(int busNumber, int busCapacity, String busFacility, float costOfTicket) {
        BusNumber = busNumber;
        BusCapacity = busCapacity;
        BusFacility = busFacility;
        CostOfTicket = costOfTicket;
    }

    // Display Method
    public void DisplayBusInfo() {
        System.out.println("Bus Number:" + BusNumber + " | Seats Available:" + BusCapacity + " | Facility:"
                + BusFacility + " | Ticket Cost:" + CostOfTicket);
    }
}