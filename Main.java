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
            selectedOption = scanner.nextInt();
            if (selectedOption == 1) {
                adminInfo.startNewBooking();
            } else if (selectedOption == 2) {
                adminInfo.adminOperations();
            } else { // else block for quit i.e SelectedOption any other number
                System.out.println("Quiting the application");
            }
        }
        scanner.close();
    }
}