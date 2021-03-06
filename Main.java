import java.util.*;

public class Main {
    public static void main(String[] args) {
        AdminInfo adminInfo = new AdminInfo();
        BusOperations busOperations = new BusOperations();
        Booking booking = new Booking();
        Utilities util = new Utilities();
        // Option given by User
        int selectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        util.displayWelcomeMessage();
        busOperations.displayBusList(adminInfo.getBusList());
        // Loop for the Application
        while (selectedOption == 1 || selectedOption == 2) {
            util.displayOptionsMessage();
            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
                util.optionValidator(selectedOption, 1, 3);
                switch (selectedOption) {
                    case 1:
                        booking.startNewBooking(adminInfo);
                        break;
                    case 2:
                        adminInfo.adminLogin(busOperations);
                        break;
                    case 3:
                        System.out.println("Quiting the application");
                        break;
                    default:
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please try again!");
                selectedOption = 1;
            } 
            catch (Exception e) {
                System.out.println("Try again!");
            }
        }
        scanner.close();
    }
}