interface DisplayInformation {
    void DisplayInfo();
}

class BusInfo implements DisplayInformation {
    private int BusNumber;
    private String FromCity;
    private String ToCity;
    private int BusCapacity;
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

    public double getCostOfTicket() {
        return CostOfTicket;
    }

    public void setCostOfTicket(double costOfTicket) {
        CostOfTicket = costOfTicket;
    }

    @Override // Display Method
    public void DisplayInfo() {
        System.out.println("Bus Number:" + BusNumber + " | From: " + FromCity + " | To: " + ToCity + " | Total Seats:" + BusCapacity + " | Ticket Cost:" + CostOfTicket);
    }

    // Constructor to create new Bus
    BusInfo(int busNumber, String fromCity, String toCity, int busCapacity, double costOfTicket) {
        BusNumber = busNumber;
        FromCity = fromCity;
        ToCity = toCity;
        BusCapacity = busCapacity;
        CostOfTicket = costOfTicket;
    }

    BusInfo() {
        BusNumber = getBusNumber();
        FromCity = getFromCity();
        ToCity = getToCity();
        BusCapacity = getBusCapacity();
        CostOfTicket = getCostOfTicket();
    }
}

class SpecialBusInfo extends BusInfo {
    private String BusFacility;

    SpecialBusInfo(int busNumber, String fromCity, String toCity, int busCapacity,String busFacilty, double costOfTicket) {
        super(busNumber, fromCity, toCity, busCapacity, costOfTicket);
        BusFacility = busFacilty;
    }

    public String getBusFacility() {
        return BusFacility;
    }

    public void setBusFacility(String busFacility) {
        BusFacility = busFacility;
    }

    @Override // Display Method
    public void DisplayInfo() {
        System.out.println("Bus Number:" + super.getBusNumber() + " | From: " + super.getFromCity()+ " | To: " + super.getToCity() + " | Total Seats:" + super.getBusCapacity() + " | Facility:" + BusFacility + " | Ticket Cost:" + super.getCostOfTicket());
    }

    SpecialBusInfo(){
        BusFacility = getBusFacility();
    }
}
