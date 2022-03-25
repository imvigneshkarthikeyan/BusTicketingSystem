import java.util.*;

public class Main {
    public static void main(String[] args) {
        AdminInfo adminInfo = new AdminInfo();
        // Option given by User
        int selectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        adminInfo.displayWelcomeMessage();
        adminInfo.displayBusList();
        // Loop for the Application
        while (selectedOption == 1 || selectedOption == 2) {
            adminInfo.displayOptionsMessage();
            try {
                selectedOption = Integer.parseInt(scanner.nextLine());
                if (selectedOption < 1 || selectedOption > 3) {
                    throw new IllegalArgumentException();
                }
                switch (selectedOption) {
                    case 1:
                        adminInfo.startNewBooking();
                        break;
                    case 2:
                        adminInfo.adminOperations();
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
            } catch (Exception e) {
                System.out.println("Try again!");
            }
        }
        scanner.close();
    }
}