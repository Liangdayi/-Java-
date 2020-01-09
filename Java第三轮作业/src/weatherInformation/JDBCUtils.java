package weatherInformation;

import java.sql.*;

public class JDBCUtils {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/weather?serverTimezone=UTC";
    private static String name = "root";
    private static String mima = "Ldy9290804";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("注册驱动失败");
        }
    }

    public static Connection getConnection() throws Exception {
        // 连接数据库
        Connection con = DriverManager.getConnection(url, name, mima);
        //System.out.println("连接成功！");
        return con;

    }

    public static void closeAll(Connection con, PreparedStatement pst, ResultSet rs) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
