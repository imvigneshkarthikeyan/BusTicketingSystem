# Bus Ticketing System - Console Application

### Details to receive from user during booking process:
1. The boarding point and Destination points.
2. The Agency Name.
3. The Bus number in which the user is going to travel. (With the boarding, destination and agency name, the bus list will be filtered and shown to the user)
4. Date of Journey.
5. Name of the Passenger.
6. Mobile number of the Passenger.
7. Aadhar Number of the Passenger.
8. Total No: of Seats needed to be booked.

### Bus Information which is available by Default:
1. Bus number.
2. Agency Name.
3. Boarding.
4. Destination.
5. Total no of seats in the Bus.
6. Cost of the ticket.
7. Two types of buses:
    - Normal Bus
    - Special Bus.
8. Special Bus has features like:
    - AC
    - Sleeper
    - Semi-Sleeper

The Main purpose of this application is to check the availability of the bus on the particular date which the user has selected and confirm the ticket and display the Booking details if available or else inform the user that the bus is not available on that particular date.  

### Administrator Panel:
1. Add new Bus details
2. Edit existing bus details
3. Delete existing bus details
4. Display Bookings
5. Filter Bookings based on Agency
6. Update Agency Names
7. Update Operating Cities

The administrator can create, edit or delete the bus and specify the features like the bus boarding and destination points as well as can see the successful bookings.

### Flow of the console application:
> Main Flow:
1. User has to enter the boarding, destination and Agency name.
2. Select the bus.(User can sort the buses based on Journey hours, cost of ticket, bus number as well)
3. Enter the details.
3. Book the ticket if available.
4. Ask for Coupon code if available.
5. Calculate the total bill amount including GST.
6. Finally, the ticket will be displayed to the user including the bill amount.(Discount will be made if Coupon code is applied successfully)

> Secondary Flow for Administrator:
1. Display the list of Buses added.
2. Add new bus.
3. Edit existing buses.
    - Edit Bus Number
    - Edit Boarding Point
    - Edit Destination
    - Edit Seat Availability 
    - Edit Bus Facility (If it is a Special Bus)
    - Edit Cost of Ticket
4. Delete a bus.
5. Display Bookings.
6. Display bookings based on agency.
7. Update Agency names.
8. Update Operating Cities.
