import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        //2.链接mysql数据库
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook", "kevinhe", "123456");
        System.out.println("Database created");
        //3.创建一个statement对象
        DatabaseMetaData dbMetaData = connection.getMetaData();
        System.out.println("URL:" + dbMetaData.getURL());
        System.out.println("username:" + dbMetaData.getUserName());
        System.out.println("product name:" + dbMetaData.getDatabaseProductName());
        System.out.println("product version:" + dbMetaData.getDatabaseProductVersion());
        System.out.println("JDBC diver name:" + dbMetaData.getDriverName());
        System.out.println("JDBC diver version:" + dbMetaData.getDriverVersion());
        System.out.println("Max number of connections:" + dbMetaData.getMaxConnections());
        System.out.println("MaxTableNameLength:" + dbMetaData.getMaxTableNameLength());
        System.out.println("MaxColumeNameLength:" + dbMetaData.getMaxColumnsInTable());
        //表名
        ResultSet rstables = dbMetaData.getTables(null,null,null,new String[]{"Table"});
        System.out.println("Table");
        while (rstables.next()){
            System.out.println(rstables.getString("TABLE_NAME")+" ");
        }
    }
}
