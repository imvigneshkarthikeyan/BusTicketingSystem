import java.util.*;

public class Main {
    public static void main(String[] args) {
        AdminInfo adminInfo = new AdminInfo();
        // Option given by User
        int selectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        adminInfo.displayWelcomeMessage();
        // Fetching the elements from array list
        adminInfo.displayBusList();
        // Loop for the Application
        while (selectedOption == 1 || selectedOption == 2) {
            // Main Booking
            adminInfo.displayOptionsMessage();
            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
                if (selectedOption < 1 || selectedOption > 3) {
                    throw new IllegalArgumentException();
                }
                if (selectedOption == 1) {
                    adminInfo.startNewBooking();
                } else if (selectedOption == 2) {
                    adminInfo.adminOperations();
                } else if (selectedOption == 3) {
                    System.out.println("Quiting the application");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please try again!");
                selectedOption = 1;
            } catch (Exception e) {
                System.out.println("Try again!");
            }
        }
        scanner.close();
    }
}