import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/kkouea";
        String user = "kkouea";
        String password = "";

        System.out.println("Connecting to PostgreSQL...");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected successfully!");

            String sql = "INSERT INTO market_ticks (symbol, price, quantity, side) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, "AAPL");
                pstmt.setDouble(2, 185.5000);
                pstmt.setInt(3, 100);
                pstmt.setString(4, "BUY");

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new market tick was inserted successfully!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection error or SQL execution failed!");
            e.printStackTrace();
        }
            }
    }
