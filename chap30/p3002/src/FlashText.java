import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class FlashText extends Application {
    private String text = "";
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        Label lalText = new Label("Programming is fun");
        pane.getChildren().add(lalText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //java 中的trim()方法，用于字符串的处理，功能是去除一段字符串前后的空格，
                    // 只保留中间的部分；例如“ hello world ” 将变为“hello world”
                    String s1 = lalText.getText().trim();
                    if (s1.length() == 0) {
                        text = "Welcome";
                    } else {
                        text = "";
                    }
                    //闪烁的控制运行自单独线程，非应用程序线程代码不能更新应用线程中的GUI。
                    //Platform.runLater(new Runnable())告诉系统在应用程序线程中创建一个Runnable对象。
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //持续的修改标签。通过设置和取消文本来模拟闪烁的效果。
                            lalText.setText(text);
                        }
                    });
                    try {
                        //线程休息200ms。
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Scene scene = new Scene(pane,200,50);
        primaryStage.setTitle("FlashText");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
