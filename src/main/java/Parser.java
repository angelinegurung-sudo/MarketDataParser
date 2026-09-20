import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Parser {

    public void parser(BufferedReader reader, Connection connection) {

        String sql = "INSERT INTO market_ticks (symbol, price, quantity, side) VALUES (?, ?, ?, ?)";
        String line;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",");
                String symbol = tokens[0];
                Double price = Double.parseDouble(tokens[1]);
                int quantity = Integer.parseInt(tokens[2]);
                String side = tokens[3];

                MarketTick tick = new MarketTick(symbol, price, quantity, side);

                pstmt.setString(1, tick.getSymbol());
                pstmt.setDouble(2, tick.getPrice());
                pstmt.setInt(3, tick.getQuantity());
                pstmt.setString(4, tick.getSide());

                pstmt.executeUpdate();
            }
            System.out.println("All market ticks successfully inserted into the database!");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
