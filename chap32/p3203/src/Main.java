import java.sql.*;

public class Main {
    private static PreparedStatement preparestatement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        //2.链接mysql数据库
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook", "kevinhe", "123456");
        System.out.println("Database created");

        String queryString = " select courseId,courseNumber,title\n" +
                " from Course\n" +
                " where numOfCredits = ?;";

        //3.创建一个statement对象
        preparestatement = connection.prepareStatement(queryString);

        preparestatement.setString(1,"3");
        ResultSet resultSet = preparestatement.executeQuery();

        //5.从Resultset对象处获得查询结果。
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" +
                    resultSet.getString(3));
        }
        //4.关闭链接，释放资源。
        connection.close();
    }
}
