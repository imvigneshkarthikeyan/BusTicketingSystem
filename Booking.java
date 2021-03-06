import java.util.Scanner;

class Booking {
    Scanner scanner = new Scanner(System.in);
    // Start a new booking
    public void startNewBooking(AdminInfo adminInfo) {
        TicketInfo ticketForPassenger = new TicketInfo();
        Utilities util = new Utilities();
        searchBusByFromAndTo(ticketForPassenger, adminInfo);
        // Checking if the filtered bus list is empty or not based upon from to search request from user
        if (ticketForPassenger.isBusListEmpty(ticketForPassenger.fromToSearchList(adminInfo)) == false) {
            searchBusByAgency(ticketForPassenger, adminInfo);
            if (ticketForPassenger.isBusListEmpty(ticketForPassenger.agencySearchList(adminInfo)) == false) {
                ticketForPassenger.showSortingFunctions(adminInfo);
                getBusNumberAndDateFromUser(ticketForPassenger, adminInfo);
                mainBooking(ticketForPassenger, adminInfo, util);
            } else {
                System.out.println("The requested agency is not available, try: " + adminInfo.getAvailableAgencies());
            }
        } else { // else block if the user requested other areas than the service areas
            System.out.println("Service is not available in those areas, try: " + adminInfo.getOperatingCities());
        }
    }

    public void searchBusByFromAndTo(TicketInfo ticketForPassenger, AdminInfo adminInfo) {
        // Filtering Bus List based on From and To
        ticketForPassenger.fromToSearchList(adminInfo);
        ticketForPassenger.displaySearchList(ticketForPassenger.fromToSearchList(adminInfo));
    }

    public void searchBusByAgency(TicketInfo ticketForPassenger, AdminInfo adminInfo) {
        ticketForPassenger.getAgencyNameFromUser();
        ticketForPassenger.agencySearchList(adminInfo);
        ticketForPassenger.displaySearchList(ticketForPassenger.agencySearchList(adminInfo));
    }

    public void getBusNumberAndDateFromUser(TicketInfo ticketForPassenger, AdminInfo adminInfo) {
        while (true) {
            try {
                ticketForPassenger.getBusNumberFromUser(adminInfo);
            } catch (BusNumberException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        ticketForPassenger.getDateOfJourneyFromUser();
    }

    public void mainBooking(TicketInfo ticketForPassenger, AdminInfo adminInfo, Utilities util) {
        // Displaying remaining seats for the date enetered by user
        int availableSeats = ticketForPassenger.displayRemainingSeats(adminInfo.getTicketList(), adminInfo.getBusList());
        util.validateDate(ticketForPassenger);
        util.drawLine();
        System.out.println("\033[0;1m" + "The no:of seats available for Bus Number " + ticketForPassenger.getBusNumber() + " on " + ticketForPassenger.getFormattedDateOfJourney() + " is: " + "\033[0;0m" + availableSeats);
        util.drawLine();
        // Checking if seats are available
        boolean isSucessful = false;
        while (!isSucessful) {
            if (availableSeats > 0) {
                System.out.println("\033[0;1m" + "Enter number 1:" + "\033[0;0m" + "To continue booking in this bus" + "\033[0;1m" + "\nEnter number 2:" + "\033[0;0m" + "To start a new booking.");
                try {
                    int continueBooking = Integer.parseInt(scanner.next());
                    util.optionValidator(continueBooking, 1, 2);
                    if (continueBooking == 1) {
                        checkAvailabilityAndAddPassenger(ticketForPassenger, adminInfo);
                        // Coupon code and billing
                        getCouponCodeFromUser(adminInfo, ticketForPassenger, util);
                    } else if (continueBooking == 2) { // else block for start a new booking if the available seats is not enough
                        System.out.println("Redirecting...");
                    }
                    isSucessful = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input, please try again!");
                }
            } else { // else block if seats are not available
                System.out.println("As there are no seats available for the date selected, try in different Bus/Date");
                break;
            }
        }
    }

    public void checkAvailabilityAndAddPassenger(TicketInfo ticketForPassenger, AdminInfo adminInfo) {
        ticketForPassenger.passengerInfo.getPassengerDetails();
        ticketForPassenger.getSeatsRequired();
        // Checking whether the user requesting seats less than or equal to the available number of seats
        while (ticketForPassenger.isAvailable(adminInfo.getTicketList(), adminInfo.getBusList()) == false) {
            System.out.println("You have requested for more seats than available seats, Try to enter the available seats properly.");
            ticketForPassenger.getSeatsRequired();
        } // Adding passenger to the reserved list
        adminInfo.getTicketList().add(ticketForPassenger);
    }

    public void getCouponCodeFromUser(AdminInfo adminInfo, TicketInfo ticketForPassenger, Utilities util) {
        boolean checkLoop = false;
        while (!checkLoop) {
            System.out.println("\033[0;1m" + "Enter 1:" + "\033[0;0m" + "If you have any coupon code" + "\033[0;1m" + "\nEnter 2:" + "\033[0;0m" + "To complete the booking without coupon code.");
            try {
                int selectedOption = Integer.parseInt(scanner.next());
                util.optionValidator(selectedOption, 1, 2);
                if (selectedOption == 1) {
                    OffersAndDiscount offers = new OffersAndDiscount();
                    System.out.println("\033[0;1m" + "Enter the coupon code" + "\033[0;0m");
                    offers.setAppliedCouponCode(scanner.next());
                    if (offers.getCouponCode().equals(offers.getAppliedCouponCode())) {
                        System.out.println("The coupon code is valid, discount will be made on the total bill.");
                        ticketForPassenger.mapAndDisplayTicketDetails();
                        ticketForPassenger.mapAndDisplayBillDetails(adminInfo, offers.getDiscountPercentage());
                    } else {
                        System.out.println("The code is invalid so no discount will be made.");
                        displayTicketAndGenerateBill(adminInfo, ticketForPassenger);
                    }
                } else {
                    System.out.println("Redirecting to the bill...");
                    displayTicketAndGenerateBill(adminInfo, ticketForPassenger);
                }
                checkLoop = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please try again!");
            }
        }
    }

    public void displayTicketAndGenerateBill(AdminInfo adminInfo, TicketInfo ticketForPassenger) {
        ticketForPassenger.mapAndDisplayTicketDetails();
        ticketForPassenger.mapAndDisplayBillDetails(adminInfo);
    }
}