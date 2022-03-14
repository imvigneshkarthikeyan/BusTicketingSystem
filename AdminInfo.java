import java.util.*;

class AdminInfo {
    Scanner scanner = new Scanner(System.in);

    // Declaring it as final, as it should not be modified
    private final String AdminKey = "123";

    public String getAdminKey() {
        return AdminKey;
    }

    public String getHintForAdminKey() {
        String HintForAdminKey = "Its a 3 digit pin.";
        return HintForAdminKey;
    }

    private int BusNumber;
    private int BusCapacity;
    private String FromCity;
    private String ToCity;
    private String BusFacility;
    private double CostOfTicket;

    public int getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(int BusNumber) {
        BusNumber = this.BusNumber;
    }

    public int getBusCapacity() {
        return BusCapacity;
    }

    public void setBusCapacity(int BusCapacity) {
        BusCapacity = this.BusCapacity;
    }

    public String getFromCity() {
        return FromCity;
    }

    public void setFromCity(String FromCity) {
        FromCity = this.FromCity;
    }

    public String getToCity() {
        return ToCity;
    }

    public void setNewToCity(String ToCity) {
        ToCity = this.ToCity;
    }

    public String getBusFacility() {
        return BusFacility;
    }

    public void setBusFacility(String BusFacility) {
        BusFacility = this.BusFacility;
    }

    public double getCostOfTicket() {
        return CostOfTicket;
    }

    public void setCostOfTicket(double CostOfTicket) {
        CostOfTicket = this.CostOfTicket;
    }

    public void AddNewBus() {
        System.out.println("Enter the Bus Number");
        BusNumber = scanner.nextInt();
        System.out.println("Enter the Travel Origin");
        FromCity = scanner.next();
        System.out.println("Enter the Destination");
        ToCity = scanner.next();
        System.out.println("Enter the capacity of the bus");
        BusCapacity = scanner.nextInt();
        System.out.println("Enter the Bus Facility");
        BusFacility = scanner.next();
        System.out.println("Enter the Cost of the ticket");
        CostOfTicket = scanner.nextDouble();
    }

    public void EditBusNumber() {
        System.out.println("Enter the new Bus Number that has to be updated: ");
        BusNumber = scanner.nextInt();
    }

    public void EditFromCity() {
        System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
        FromCity = scanner.nextLine();
    }

    public void EditToCity() {
        System.out.println("Enter the new Bus Destination that has to be updated: ");
        ToCity = scanner.nextLine();
    }

    public void EditBusCapacity() {
        System.out.println("Enter the new Capacity that has to be updated: ");
        BusCapacity = scanner.nextInt();
    }

    public void EditBusFacility() {
        System.out.println("Enter the new Bus Facility that has to be updated: ");
        BusFacility = scanner.nextLine();
    }

    public void EditBusTicketCost() {
        System.out.println("Enter the new Cost that has to be updated: ");
        CostOfTicket = scanner.nextInt();
    }

    public void DrawLine() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------");
    }
}