import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdvancedAggregationDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:nhanvien.db";

        try {
            // Nạp driver SQLite
            Class.forName("org.sqlite.JDBC");

            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {

                String createTableSQL = "CREATE TABLE IF NOT EXISTS NhanVien (" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "ten TEXT NOT NULL, " +
                                        "chuc_vu TEXT, " +
                                        "luong REAL)";
                stmt.executeUpdate(createTableSQL);

                System.out.println("Kết nối và khởi tạo bảng thành công!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy Driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn: " + e.getMessage());
        }
    }
}