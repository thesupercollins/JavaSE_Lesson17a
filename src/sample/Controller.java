package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    TextField paramA;
    @FXML
    TextField paramB;
    @FXML
    ScatterChart<Double, Double> scatter1;

    double a, b;

    public void getData(ActionEvent actionEvent)
    {
        try {
            a = Double.parseDouble(paramA.getText());
            b = Double.parseDouble(paramB.getText());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error while reding double values!");
        }

        System.out.println(a + "   " + b);

        scatter1.getXAxis().setLabel("X");
        scatter1.getYAxis().setLabel("Y");
        scatter1.setTitle("A*X^2 + Y");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("x");

        for (double x = -10; x<=10; x+=0.1)
            series1.getData().add(new XYChart.Data(x, a*x*x+b));

        scatter1.getData().add(series1);
        Stage curStage = new Stage();
        Scene scene = new Scene(scatter1, 800, 600);
        curStage.setScene(scene);
        curStage.show();
    }

}
