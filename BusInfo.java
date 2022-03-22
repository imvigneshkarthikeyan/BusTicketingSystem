import java.util.*;

interface DisplayInformation {
    void DisplayInfo();
}

class BusInfo implements DisplayInformation {
    private int BusNumber;
    private String FromCity;
    private String ToCity;
    private int BusCapacity;
    private double CostOfTicket;
    private int ApproxJourneyHrs;

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

    public int getApproxJourneyHrs() {
        return ApproxJourneyHrs;
    }

    public void setApproxJourneyHrs(int approxJourneyHrs) {
        ApproxJourneyHrs = approxJourneyHrs;
    }

    @Override // Display Method
    public void DisplayInfo() {
        System.out.println("Bus Number:" + BusNumber + " | From: " + FromCity + " | To: " + ToCity + " | Total Seats:" + BusCapacity + " | Ticket Cost:" + CostOfTicket + " | Approx Journey Time:" + ApproxJourneyHrs + "hrs");
    }

    // Constructor to create new Bus
    BusInfo(int busNumber, String fromCity, String toCity, int busCapacity, double costOfTicket, int approxJourneyHrs) {
        BusNumber = busNumber;
        FromCity = fromCity;
        ToCity = toCity;
        BusCapacity = busCapacity;
        CostOfTicket = costOfTicket;
        ApproxJourneyHrs = approxJourneyHrs;
    }

    BusInfo() {
        BusNumber = getBusNumber();
        FromCity = getFromCity();
        ToCity = getToCity();
        BusCapacity = getBusCapacity();
        CostOfTicket = getCostOfTicket();
        ApproxJourneyHrs = getApproxJourneyHrs();
    }
}

class SpecialBusInfo extends BusInfo {
    private String BusFacility;

    SpecialBusInfo(int busNumber, String fromCity, String toCity, int busCapacity,String busFacilty, double costOfTicket, int approxJourneyHrs) {
        super(busNumber, fromCity, toCity, busCapacity, costOfTicket, approxJourneyHrs);
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
        System.out.println("Bus Number:" + super.getBusNumber() + " | From: " + super.getFromCity()+ " | To: " + super.getToCity() + " | Total Seats:" + super.getBusCapacity() + " | Facility:" + BusFacility + " | Ticket Cost:" + super.getCostOfTicket() + " | Approx Journey Time:" + super.getApproxJourneyHrs() + "hrs");
    }

    SpecialBusInfo(){
        BusFacility = getBusFacility();
    }
}

class JourneyComparator implements Comparator<BusInfo> {
    @Override
    public int compare(BusInfo b1, BusInfo b2) {
        if (b1.getApproxJourneyHrs() == b2.getApproxJourneyHrs()) {
            return 0;
        } else if (b1.getApproxJourneyHrs() > b2.getApproxJourneyHrs()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class CostComparator implements Comparator<BusInfo> {
    @Override
    public int compare(BusInfo b1, BusInfo b2) {
        if (b1.getCostOfTicket() == b2.getCostOfTicket()) {
            return 0;
        } else if (b1.getCostOfTicket() > b2.getCostOfTicket()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class BusNumberComparator implements Comparator<BusInfo> {
    @Override
    public int compare(BusInfo b1, BusInfo b2) {
        if (b1.getBusNumber() == b2.getBusNumber()) {
            return 0;
        } else if (b1.getBusNumber() > b2.getBusNumber()) {
            return 1;
        } else {
            return -1;
        }
    }
}