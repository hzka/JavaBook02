import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        //2.链接mysql数据库
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook","kevinhe","123456");
        System.out.println("Database created");
        //3.创建一个statement对象
        Statement statement = connection.createStatement();
        //4.执行SQL查询语句并返回一个ResultSet对象
        ResultSet resultSet = statement.executeQuery(" select *\n" +
                " from Course;");
        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        //获取列数和每一列的名称；
        for(int i = 1;i<=rsMetaData.getColumnCount();i++){
            System.out.printf("%-12s\t",rsMetaData.getColumnName(i));
        }
        System.out.println();
        //所有内容。
        while (resultSet.next()){
            for(int i =1;i<=rsMetaData.getColumnCount();i++){
                System.out.printf("%-12s\t",resultSet.getObject(i));
            }
            System.out.println();
        }
        //4.关闭链接，释放资源。
        connection.close();
    }
}
