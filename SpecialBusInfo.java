class SpecialBusInfo extends BusInfo {
    private String busFacility;

    SpecialBusInfo(int busNumber, String fromCity, String toCity, int busCapacity, String busFacilty, double costOfTicket, int approxJourneyHrs) {
        super(busNumber, fromCity, toCity, busCapacity, costOfTicket, approxJourneyHrs);
        this.busFacility = busFacilty;
    }

    public String getBusFacility() {
        return busFacility;
    }

    public void setBusFacility(String busFacility) {
        this.busFacility = busFacility;
    }

    @Override // Display Method
    public void displayInfo() {
        System.out.println(
                "Bus Number:" + super.getBusNumber() + " | From: " + super.getFromCity() + " | To: " + super.getToCity() + " | Total Seats:" + super.getBusCapacity() + " | Facility:" + busFacility + " | Ticket Cost:" + super.getCostOfTicket() + " | Approx Journey Time:" + super.getApproxJourneyHrs() + "hrs");
    }

    SpecialBusInfo() {
        busFacility = getBusFacility();
    }
}