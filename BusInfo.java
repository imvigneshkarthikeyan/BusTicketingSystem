class BusInfo implements DisplayInformation {
    private int busNumber;
    private String agencyName;
    private String fromCity;
    private String toCity;
    private int busCapacity;
    private double costOfTicket;
    private int approxJourneyHrs;

    // GettersSetters for private attributes
    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
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

    public int getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        this.busCapacity = busCapacity;
    }

    public double getCostOfTicket() {
        return costOfTicket;
    }

    public void setCostOfTicket(double costOfTicket) {
        this.costOfTicket = costOfTicket;
    }

    public int getApproxJourneyHrs() {
        return approxJourneyHrs;
    }

    public void setApproxJourneyHrs(int approxJourneyHrs) {
        this.approxJourneyHrs = approxJourneyHrs;
    }

    @Override // Display Method
    public void displayInfo() {
        System.out.println("Bus Number:" + busNumber + " | Agency:" + agencyName + " | From: " + fromCity + " | To: " + toCity + " | Total Seats:" + busCapacity + " | Ticket Cost:" + costOfTicket + " | Approx Journey Time:" + approxJourneyHrs + "hrs");
    }

    // Constructor to create new Bus
    BusInfo(int busNumber, String agencyName, String fromCity, String toCity, int busCapacity, double costOfTicket, int approxJourneyHrs) {
        this.busNumber = busNumber;
        this.agencyName = agencyName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.busCapacity = busCapacity;
        this.costOfTicket = costOfTicket;
        this.approxJourneyHrs = approxJourneyHrs;
    }

    BusInfo() {
        this.busNumber = getBusNumber();
        this.agencyName = getAgencyName();
        this.fromCity = getFromCity();
        this.toCity = getToCity();
        this.busCapacity = getBusCapacity();
        this.costOfTicket = getCostOfTicket();
        this.approxJourneyHrs = getApproxJourneyHrs();
    }
}