import java.text.*;
//For Date Validation
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

class Utilities {
    public DateFormat dateFormatter() {
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormatter;
    }

    // Validation: Is entered date a future date
    public boolean isDateFuture(String date, String dateFormat) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate inputDate = LocalDate.parse(date, dtf);
        return inputDate.isAfter(localDate);
    }
    
    public void validateDate(TicketInfo ticketForPassenger) {
        boolean isDateFuture = isDateFuture(ticketForPassenger.getFormattedDateOfJourney(), "dd/MM/yyyy");
        while (isDateFuture == false) {
            System.out.println("The booking is over for the specified date, enter a future date.");
            ticketForPassenger.getDateOfJourneyFromUser();
            isDateFuture = isDateFuture(ticketForPassenger.getFormattedDateOfJourney(), "dd/MM/yyyy");
        }
    }

    public void drawDoubleLine() {
        System.out.println("\033[0;1m" + "=========================================================================================================================================================" + "\033[0;0m");
    }

    public void drawLine() {
        System.out.println("\033[0;1m" + "---------------------------------------------------------------------------------------------------------------------------------------------------------" + "\033[0;0m");
    }


    public void displayWelcomeMessage() {
        drawDoubleLine();
        System.out.println("\033[0;1m" + "============================================================ Welcome to Bus Ticketing System ============================================================" + "\033[0;0m");
        System.out.println("\033[0;1m" + "============================================================ Total Buses are displayed below ============================================================" + "\033[0;0m");
        drawDoubleLine();
    }

    public void displayOptionsMessage() {
        drawDoubleLine();
        System.out.println("\033[0;1m" + "Enter option:" + "\033[0;0m" + "\n1: Start a new Booking \n2: Login as Admin \n3: Quit\n");
    }

    public void ticketLineMsg() {
        drawDoubleLine();
        System.out.println("======================================================================== TICKET ========================================================================");
        drawDoubleLine();
    }

    public void billLineMsg() {
        System.out.println("\033[0;1m" + "------------------------------------------------------------------------- BILL -------------------------------------------------------------------------" + "\033[0;0m");
    }

    public void drawBookingLine() {
        System.out.println("\033[0;1m" + "==================================================================== BOOKINGS =====================================================================" + "\033[0;0m");
    }

    public void drawBookingLine(String agencyNameToSearch) {
        System.out.println("\033[0;1m" + "==================================================================== " + agencyNameToSearch + " BOOKINGS =====================================================================" + "\033[0;0m");
    }

    public void optionValidator(int option, int a, int b) {
        if (option < a || option > b) {
            throw new IllegalArgumentException();
        }
    }
}