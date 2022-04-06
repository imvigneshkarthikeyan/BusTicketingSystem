import java.util.ArrayList;
import java.util.Scanner;

class BusOperations {
    Scanner scanner = new Scanner(System.in);

    // Displaying BusList in a for each loop
    public void displayBusList(ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        util.drawDoubleLine();
        System.out.println("\033[0;1m" + "The following buses are available:" + "\033[0;0m");
        for (BusInfo b : busList) {
            b.displayInfo();
        }
    }

    // Add NewBus for admin panel
    public void addNewBus(ArrayList<BusInfo> busList) {
        BusInfo busInfo = new BusInfo();
        SpecialBusInfo specialBus = new SpecialBusInfo();
        Utilities util = new Utilities();
        boolean isSucessful = false;
        while (!isSucessful) {
            try {
                System.out.println("Enter 1: To create a normal bus. \nEnter 2: To create Luxury Bus");
                int busType = Integer.parseInt(scanner.next());
                util.throwException(busType, 1, 2);
                if (busType == 1) { // To Add normal Bus
                    System.out.println("Enter the Bus Number");
                    busInfo.setBusNumber(scanner.nextInt());
                    System.out.println("Enter the Agency Name");
                    busInfo.setAgencyName(scanner.next());
                    System.out.println("Enter the Travel Origin");
                    busInfo.setFromCity(scanner.next());
                    System.out.println("Enter the Destination");
                    busInfo.setToCity(scanner.next());
                    System.out.println("Enter the capacity of the bus");
                    busInfo.setBusCapacity(scanner.nextInt());
                    System.out.println("Enter the Cost of the ticket");
                    busInfo.setCostOfTicket(scanner.nextDouble());
                    System.out.println("Enter the Approximate Time for Journey");
                    busInfo.setApproxJourneyHrs(scanner.nextInt());
                    busList.add(new BusInfo(busInfo.getBusNumber(), busInfo.getAgencyName(), busInfo.getFromCity(),
                            busInfo.getToCity(), busInfo.getBusCapacity(), busInfo.getCostOfTicket(),
                            busInfo.getApproxJourneyHrs()));
                    // Displaying the list of buses after adding
                    util.drawLine();
                    displayBusList(busList);
                } else if (busType == 2) { // To add Special bus
                    System.out.println("Enter the Bus Number");
                    busInfo.setBusNumber(scanner.nextInt());
                    System.out.println("Enter the Agency Name");
                    busInfo.setAgencyName(scanner.next());
                    System.out.println("Enter the Travel Origin");
                    busInfo.setFromCity(scanner.next());
                    System.out.println("Enter the Destination");
                    busInfo.setToCity(scanner.next());
                    System.out.println("Enter the capacity of the bus");
                    busInfo.setBusCapacity(scanner.nextInt());
                    System.out.println("Enter the Bus Facility");
                    specialBus.setBusFacility(scanner.next());
                    System.out.println("Enter the Cost of the ticket");
                    busInfo.setCostOfTicket(scanner.nextDouble());
                    System.out.println("Enter the Approximate Time for Journey");
                    busInfo.setApproxJourneyHrs(scanner.nextInt());
                    busList.add(new SpecialBusInfo(busInfo.getBusNumber(), busInfo.getAgencyName(),
                            busInfo.getFromCity(), busInfo.getToCity(), busInfo.getBusCapacity(),
                            specialBus.getBusFacility(), busInfo.getCostOfTicket(), busInfo.getApproxJourneyHrs()));
                    // Displaying the list of buses after adding
                    util.drawLine();
                    displayBusList(busList);
                }
                isSucessful = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please try again!");
            }
        }
    }

    // Displaying the BusInfo along with index number
    public void displayBusWithIndex(ArrayList<BusInfo> buses) {
        Utilities util = new Utilities();
        util.drawLine();
        int index = 0;
        for (BusInfo b : buses) {
            System.out.print("Index Number: " + index++ + "| ");
            b.displayInfo();
        }
        util.drawLine();
    }

    // Filtering Special Bus
    public ArrayList<BusInfo> filterSpecialBusList(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        ArrayList<BusInfo> filteredBusList = new ArrayList<BusInfo>();
        for (BusInfo bus : busList) {
            if (bus instanceof SpecialBusInfo) {
                filteredBusList.add(bus);
            }
        }
        return filteredBusList;
    }

    // EditBus for admin panel
    public void editBus(ArrayList<TicketInfo> ticketList, ArrayList<BusInfo> busList) {
        BusInfo busInfo = new BusInfo();
        SpecialBusInfo specialBus = new SpecialBusInfo();
        Utilities util = new Utilities();
        try {
            System.out.println("Editing the Bus...");
            System.out.println("Enter 1: To edit Luxury Bus \nEnter 2: To edit Normal Bus");
            int editBusOption = Integer.parseInt(scanner.next());
            util.throwException(editBusOption, 1, 2);
            if (editBusOption == 1) {
                ArrayList<BusInfo> filteredBuses = filterSpecialBusList(ticketList, busList);
                displayBusWithIndex(filteredBuses);
                // Getting the index number that has to be updated from user
                System.out.println("Enter the Index number of the bus to be updated: ");
                int busToBeUpdated = scanner.nextInt();
                while (filteredBuses.size() <= busToBeUpdated) {
                    System.out.println("Enter the index number properly from the given list.");
                    busToBeUpdated = scanner.nextInt();
                }
                if (filteredBuses.size() > busToBeUpdated) {
                    // Asking for the field that has to be updated
                    util.drawLine();
                    System.out.println("Select the option of the field which has to be updated: ");
                    System.out.println(
                            "1: Bus Number \n2: Agency \n3: From City \n4: To City \n5: Bus Capacity \n6: Bus Facility \n7: Cost of the ticket \n8: Approx Journey Hours \nEnter any other number: To Quit");
                    int optionToBeUpdated = scanner.nextInt();
                    switch (optionToBeUpdated) {
                        case 1:
                            System.out.println("Enter the new Bus Number that has to be updated: ");
                            busInfo.setBusNumber(scanner.nextInt());
                            busList.get(busToBeUpdated).setBusNumber(busInfo.getBusNumber());
                            break;
                        case 2:
                            System.out.println("Enter the new Agency Name that has to be updated: ");
                            busInfo.setAgencyName(scanner.next());
                            busList.get(busToBeUpdated).setAgencyName(busInfo.getAgencyName());
                            break;
                        case 3:
                            System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                            busInfo.setFromCity(scanner.next());
                            busList.get(busToBeUpdated).setFromCity(busInfo.getFromCity());
                            break;
                        case 4:
                            System.out.println("Enter the new Bus Destination that has to be updated: ");
                            busInfo.setToCity(scanner.next());
                            busList.get(busToBeUpdated).setToCity(busInfo.getToCity());
                            break;
                        case 5:
                            System.out.println("Enter the new Capacity that has to be updated: ");
                            busInfo.setBusCapacity(scanner.nextInt());
                            busList.get(busToBeUpdated).setBusCapacity(busInfo.getBusCapacity());
                            break;
                        case 6:
                            System.out.println("Enter the new Bus Facility that has to be updated: ");
                            specialBus.setBusFacility(scanner.next());
                            ((SpecialBusInfo) busList.get(busToBeUpdated))
                                    .setBusFacility(specialBus.getBusFacility());
                            break;
                        case 7:
                            System.out.println("Enter the new Cost that has to be updated: ");
                            busInfo.setCostOfTicket(scanner.nextInt());
                            busList.get(busToBeUpdated).setCostOfTicket(busInfo.getCostOfTicket());
                            break;
                        case 8:
                            System.out.println("Enter the new approximate journey in hrs: ");
                            busInfo.setApproxJourneyHrs(scanner.nextInt());
                            busList.get(busToBeUpdated).setApproxJourneyHrs(busInfo.getApproxJourneyHrs());
                            break;
                        default:
                            System.out.println("Getting out from admin panel");
                            break;
                    }
                    displayBusList(busList);
                }
            } else if (editBusOption == 2) {
                displayBusWithIndex(busList);
                // Getting the index number that has to be updated from user
                System.out.println("Enter the Index number of the bus to be updated: ");
                int busToBeUpdated = scanner.nextInt();
                while (busList.size() <= busToBeUpdated) {
                    System.out.println("Enter the index number properly from the given list.");
                    busToBeUpdated = scanner.nextInt();
                }
                if (busList.size() > busToBeUpdated) {
                    util.drawLine();
                    System.out.println("Select the option of the field which has to be updated: ");
                    System.out.println("1.Bus Number \n2.Agency \n3.From City \n4.To City \n5.Bus Capacity \n6.Cost of the ticket \n7. Approx Journey Hrs \nEnter any other number to quit");
                    int optionToBeUpdated = scanner.nextInt();
                    switch (optionToBeUpdated) {
                        case 1:
                            System.out.println("Enter the new Bus Number that has to be updated: ");
                            busInfo.setBusNumber(scanner.nextInt());
                            busList.get(busToBeUpdated).setBusNumber(busInfo.getBusNumber());
                            break;
                        case 2:
                            System.out.println("Enter the new Agency Name that has to be updated: ");
                            busInfo.setAgencyName(scanner.next());
                            busList.get(busToBeUpdated).setAgencyName(busInfo.getAgencyName());
                            break;
                        case 3:
                            System.out.println("Enter the new Bus Travel Origin that has to be updated: ");
                            busInfo.setFromCity(scanner.next());
                            busList.get(busToBeUpdated).setFromCity(busInfo.getFromCity());
                            break;
                        case 4:
                            System.out.println("Enter the new Bus Destination that has to be updated: ");
                            busInfo.setToCity(scanner.next());
                            busList.get(busToBeUpdated).setToCity(busInfo.getToCity());
                            break;
                        case 5:
                            System.out.println("Enter the new Capacity that has to be updated: ");
                            busInfo.setBusCapacity(scanner.nextInt());
                            busList.get(busToBeUpdated).setBusCapacity(busInfo.getBusCapacity());
                            break;
                        case 6:
                            System.out.println("Enter the new Cost that has to be updated: ");
                            busInfo.setCostOfTicket(scanner.nextInt());
                            busList.get(busToBeUpdated).setCostOfTicket(busInfo.getCostOfTicket());
                            break;
                        case 7:
                            System.out.println("Enter the new approximate journey in hrs: ");
                            busInfo.setApproxJourneyHrs(scanner.nextInt());
                            busList.get(busToBeUpdated).setApproxJourneyHrs(busInfo.getApproxJourneyHrs());
                            break;
                        default:
                            System.out.println("Getting out from admin panel");
                            break;
                    }
                    displayBusList(busList);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please try again!");
        }
    }
    
    // Delete bus for admin panel
    public void deleteBus(ArrayList<BusInfo> busList) {
        Utilities util = new Utilities();
        System.out.println("Deleting the Bus...");
        displayBusWithIndex(busList);
        System.out.println("Enter the index number of the Bus that has to be removed");
        busList.remove(scanner.nextInt());
        // Displaying the BusList after removing
        util.drawLine();
        System.out.println("The selected bus was removed successfully");
        util.drawLine();
        displayBusList(busList);
    }
}
