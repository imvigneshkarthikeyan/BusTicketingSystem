import java.util.*;

public class Main {
    public static void main(String[] args) {
        AdminInfo adminInfo = new AdminInfo();
        // Option given by User
        int SelectedOption = 1;
        Scanner scanner = new Scanner(System.in);
        adminInfo.DisplayWelcomeMessage();
        // Fetching the elements from array list
        adminInfo.ForEachDisplayBusList();
        // Loop for the Application
        while (SelectedOption == 1 || SelectedOption == 2 || SelectedOption == 3) {
            // Main Booking
            adminInfo.DisplayOptionsMessage();
            SelectedOption = scanner.nextInt();
            if (SelectedOption == 1) {
                PassengerInfo ticketForPassenger = new PassengerInfo();
                // Filtering Bus List based on From and To
                ticketForPassenger.FilterBusList(adminInfo.getPassengerList(), adminInfo.getBusList());
                ticketForPassenger.DisplayFilteredBusList(adminInfo.getPassengerList(), adminInfo.getBusList());
                // Checking if the filtered bus list is empty or not based upon from to request
                // from user
                if (ticketForPassenger.IsFilteredBusListEmpty(adminInfo.getPassengerList(),
                        adminInfo.getBusList()) == false) {
                    ticketForPassenger.GetBusNumberFromUser();
                    ticketForPassenger.GetDateOfJourneyFromUser();
                    // Displaying remaining seats for the date enetered by user
                    int AvailableSeats = ticketForPassenger.DisplayRemainingSeats(adminInfo.getPassengerList(),
                            adminInfo.getBusList());
                    String FormattedDate = ticketForPassenger.getFormattedDateOfJourney();
                    boolean IsDateFuture = ticketForPassenger.IsDateFuture(FormattedDate, "dd/MM/yyyy");
                    while (IsDateFuture == false) {
                        System.out.println("The booking is over for the specified date, enter a future date.");
                        ticketForPassenger.GetDateOfJourneyFromUser();
                        FormattedDate = ticketForPassenger.getFormattedDateOfJourney();
                        IsDateFuture = ticketForPassenger.IsDateFuture(FormattedDate, "dd/MM/yyyy");
                    }
                    ticketForPassenger.DrawLine();
                    System.out.println("\033[0;1m" + "The no:of seats available for Bus Number "
                            + ticketForPassenger.getBusNumber() + " on " + FormattedDate + " is: " + "\033[0;0m"
                            + AvailableSeats);
                    ticketForPassenger.DrawLine();
                    // Checking if seats are available
                    if (AvailableSeats > 0) {
                        System.out.println("\033[0;1m" + "Enter number 1:" + "\033[0;0m"
                                + "To continue booking in this bus" + "\033[0;1m" + "\nEnter any other number:"
                                + "\033[0;0m" + "To start a new booking.");
                        int ContinueBooking = scanner.nextInt();
                        if (ContinueBooking == 1) {
                            ticketForPassenger.GetOtherPassengerInfo();
                            ticketForPassenger.GetSeatsRequired();
                            // Checking whether the user requesting seats less than or equal to the
                            // available number of seats
                            while (ticketForPassenger.IsAvailable(adminInfo.getPassengerList(),
                                    adminInfo.getBusList()) == false) {
                                System.out.println(
                                        "You have requested for more seats than available seats, Try to enter the available seats properly.");
                                ticketForPassenger.GetSeatsRequired();
                            } // Adding passenger to the reserved list
                            adminInfo.getPassengerList().add(ticketForPassenger);
                            // Mapping the ticket details
                            ticketForPassenger.MapAndDisplayTicketDetails();
                            // Mapping the details for bill
                            ticketForPassenger.MapAndDisplayBillDetails();
                        } else { // else block for start a new booking if the available seats is not enough
                            System.out.println("Redirecting...");
                        }
                    } else { // else block if seats are not available
                        System.out.println(
                                "As there are no seats available for the date selected, try in different Bus/Date");
                    }
                } else { // else block if the user requested other areas than the service areas
                    System.out.println("Service is not available in those areas, try \nChennai \nThanjavur \nTrichy");
                }
            } else if (SelectedOption == 2) { // Admin Panel
                String AdminKey = adminInfo.getAdminKey();
                // Using console to read admin pin as invisible
                String PinNum = adminInfo.ReadPINinConsole();
                // Checking if the pin is correct
                if (AdminKey.equals(PinNum) == true) {
                    System.out.println("The key is correct...Redirecting to Admin portal");
                    adminInfo.DrawLine();
                    adminInfo.ForEachDisplayBusList();
                    // Operations which can be performed by the admin
                    adminInfo.DrawLine();
                    System.out.println(
                            "Enter option: \n1:Add a new bus \n2:Edit a Bus \n3:Delete a Bus \n4.Display Bookings \n5.Display all the buses\nEnter any other number to logout");
                    int OperationOption = scanner.nextInt();
                    // Adding new Bus
                    if (OperationOption == 1) {
                        adminInfo.AddNewBus();
                    } else if (OperationOption == 2) {
                        adminInfo.EditBus();
                    } else if (OperationOption == 3) {
                        adminInfo.DeleteBus();
                    } else if (OperationOption == 4) {
                        adminInfo.ShowBookingList();
                    } else if (OperationOption == 5) {
                        adminInfo.ForEachDisplayBusList();
                    } else { // if OperationOption is other than 1,2,3,4,5
                        System.out.println("Logging out from admin portal...!");
                    }
                } else { // else block for wrong pin
                    adminInfo.ForgotPIN();
                }
            } else if (SelectedOption == 3) {
                adminInfo.ForEachDisplayBusList();
            } else { // else block for quit i.e SelectedOption any other number
                System.out.println("Quiting the application");
            }
        }
    }
}