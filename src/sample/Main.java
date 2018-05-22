package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Plot builder");

/*        primaryStage.setScene(new Scene(root, 800, 600));
        stage = primaryStage;
        primaryStage.show();
*/

        NumberAxis xAxis = new NumberAxis(-10, 10, 1);
        xAxis.setLabel("X");

        NumberAxis yAxis = new NumberAxis(-5, 10, 1);
        yAxis.setLabel("Y");

        LineChart<String, Number> scatter = new LineChart(xAxis, yAxis);
        scatter.getXAxis().setLabel("X");
        scatter.getYAxis().setLabel("Y");
        scatter.setTitle("Y = A*sinX + B , Y = A*cosX + B");

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName("sinX");
        series2.setName("cosX");

        double a = 5, b = 3;

        for (double x = -10; x <= 10; x += 0.5){
            series1.getData().add(new XYChart.Data(x, a * sin(x) + b));
            series2.getData().add(new XYChart.Data(x, a * cos(x) + b));
        }
        scatter.getData().addAll(series1, series2);

        Scene scene  = new Scene(scatter, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
