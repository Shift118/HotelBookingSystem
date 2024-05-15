import java.util.Date;

public class Booking {
	int BookingID;
	Customer customer;
	Hotel hotel;
	Room room;
	Date checkInDate;
	Date checkOutDate;
	static int id_variable;
	
	Booking(Date checkInDate, Date checkOutDate, Room room, Hotel hotel, Customer customer) {
		id_variable++;
		this.BookingID = id_variable;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
		this.hotel = hotel;
		this.customer = customer;
	}
	void makeBooking(Booking booking,Room room,Customer customer) {
		DatabaseManager dbManager = new DatabaseManager();
		dbManager.insertBooking(booking.BookingID, checkInDate, checkOutDate, room.roomID, hotel.hotelID, customer.customerID);
	}
	void viewBooking() {
		DatabaseManager dbManager = new DatabaseManager();
		dbManager.getAllBookings() ;
	}
}
