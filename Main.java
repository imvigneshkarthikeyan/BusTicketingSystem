import java.util.*;

public class Main {
    public static void main(String[] args) {
        AdminInfo adminInfo = new AdminInfo();
        // Option given by User
        int SelectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        adminInfo.DisplayWelcomeMessage();
        // Fetching the elements from array list
        adminInfo.DisplayBusList();
        // Loop for the Application
        while (SelectedOption == 1 || SelectedOption == 2) {
            // Main Booking
            adminInfo.DisplayOptionsMessage();
            SelectedOption = scanner.nextInt();
            if (SelectedOption == 1) {
                adminInfo.StartNewBooking();
            } else if (SelectedOption == 2) {
                adminInfo.AdminOperations();
            } else { // else block for quit i.e SelectedOption any other number
                System.out.println("Quiting the application");
            }
        }
        scanner.close();
    }
}