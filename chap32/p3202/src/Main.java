import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.sql.*;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main {

    public static Statement stmt;
    private static TextField tfSSN;
    private static TextField tfCourseId;
    private static Label lblStatus;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Stage stage = new Stage();
        start(stage);

    }

    public static void start(Stage primaystage) throws SQLException, ClassNotFoundException {
        initializeDB();

        Button btnshowgrade = new Button("Show Result");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("SSN"), tfSSN, new Label("Course ID"), tfCourseId, btnshowgrade);
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(hBox, lblStatus);

        tfSSN.setPrefColumnCount(6);
        tfCourseId.setPrefColumnCount(6);
        btnshowgrade.setOnAction(event -> {
            try {
                showGrade();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(vbox, 420, 80);
        primaystage.setTitle("FindGrade");
        primaystage.setScene(scene);
        primaystage.show();
    }

    private static void initializeDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook", "kevinhe", "123456");
        System.out.println("Database created");

        stmt = connection.createStatement();
    }

    private static void showGrade() throws SQLException {
        String num = tfSSN.getText();
        String courseId = tfCourseId.getText();
        String queryString = " select courseId as id,courseNumber as num,title as tit\n" +
                "from Course\n" +
                "where numOfCredits =" + num + ";";
        ResultSet resultSet = stmt.executeQuery(queryString);
        if (resultSet.next()) {
            String courseid = resultSet.getString(1);
            String couresenum = resultSet.getString(2);
            String title = resultSet.getString(3);
            lblStatus.setText("courseId:" + courseid + "couresenum:" + couresenum
                    + "title" + title);
        } else {
            lblStatus.setText("Not found");
        }
    }
}
