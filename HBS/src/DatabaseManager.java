import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "yourusername";
    private static final String PASS = "yourpassword";

    public void insertUser(String firstname,String lastname, String email, int id) {
        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, firstname);
            pstmt.setString(1, lastname);
            pstmt.setString(2, email);
            pstmt.setInt(1, id);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertBooking(int bookingID, Date checkInDate, Date checkOutDate, Room room, Hotel hotel, Customer customer) {
        String insertSQL = "INSERT INTO bookings (booking_id, check_in_date, check_out_date, room, hotel, customer) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setInt(1, bookingID);
            pstmt.setDate(2, checkInDate);
            pstmt.setDate(3, checkOutDate);
            pstmt.setInt(4, room.roomID);
            pstmt.setInt(5, hotel.hotelID);
            pstmt.setInt(6, customer.customerID);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new booking was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getAllBookings() {
        String querySQL = "SELECT booking_id, check_in_date, check_out_date, room, hotel, customer FROM bookings";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(querySQL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int bookingID = rs.getInt("booking_id");
                Date checkInDate = rs.getDate("check_in_date");
                Date checkOutDate = rs.getDate("check_out_date");
                int roomID = rs.getInt("room");
                int hotelID = rs.getInt("hotel");
                int customerID = rs.getInt("customer");

                System.out.println("Booking ID: " + bookingID);
                System.out.println("Check-In Date: " + checkInDate);
                System.out.println("Check-Out Date: " + checkOutDate);
                System.out.println("Room ID: " + roomID);
                System.out.println("Hotel ID: " + hotelID);
                System.out.println("Customer ID: " + customerID);
                System.out.println("-------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
