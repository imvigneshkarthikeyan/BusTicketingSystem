import java.util.*;

interface DisplayInformation {
    void displayInfo();
}

class BusInfo implements DisplayInformation {
    private int busNumber;
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
        System.out.println("Bus Number:" + busNumber + " | From: " + fromCity + " | To: " + toCity + " | Total Seats:" + busCapacity + " | Ticket Cost:" + costOfTicket + " | Approx Journey Time:" + approxJourneyHrs + "hrs");
    }

    // Constructor to create new Bus
    BusInfo(int busNumber, String fromCity, String toCity, int busCapacity, double costOfTicket, int approxJourneyHrs) {
        this.busNumber = busNumber;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.busCapacity = busCapacity;
        this.costOfTicket = costOfTicket;
        this.approxJourneyHrs = approxJourneyHrs;
    }

    BusInfo() {
        this.busNumber = getBusNumber();
        this.fromCity = getFromCity();
        this.toCity = getToCity();
        this.busCapacity = getBusCapacity();
        this.costOfTicket = getCostOfTicket();
        this.approxJourneyHrs = getApproxJourneyHrs();
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