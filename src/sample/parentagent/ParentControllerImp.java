package sample.parentagent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import sample.ParentController;
import sample.entryfiledagent.EntryFieldController;
import sample.paletteagent.PaletteController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ParentControllerImp extends ParentController {
    private ParentAbstraction parentAbstraction = new ParentAbstraction(0);
    @FXML
    private LineChart<Number, Number> tempGraphe;

    private XYChart.Series series = new XYChart.Series();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //load palette section in palette container
        FXMLLoader loaderPalette = new FXMLLoader(getClass().getResource("../paletteagent/palettePresentation.fxml"));
        //load palette section in palette container
        FXMLLoader loaderEntryField = new FXMLLoader(getClass().getResource("../entryfiledagent/entryFieldPresentation.fxml"));



        try {
            //set parent for both controllers
            AnchorPane palettePane = loaderPalette.load();
            ((PaletteController)loaderPalette.getController()).setParentController(this);
            AnchorPane entryFieldPane = loaderEntryField.load();
            ((EntryFieldController)loaderEntryField.getController()).setParentController(this);
            this.parentAbstraction.attach(((EntryFieldController)loaderEntryField.getController()).getEntryFieldAbsraction());
            this.paletteContainer.getChildren().addAll(palettePane);
            this.entryFieldContainer.getChildren().addAll(entryFieldPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //lineChart
        //creating the chart
        tempGraphe.getXAxis().setLabel("Modification");
        tempGraphe.getYAxis().setLabel("Temperature");

        tempGraphe.setTitle("Température");
        //defining a series
        series.setName("Mes tests");
        series.getData().add(new XYChart.Data(1, parentAbstraction.getValue()));
        tempGraphe.getData().add(series);
    }

    @Override
    public void changeTemperatureValue(int value) {
        this.parentAbstraction.setValue(value);
        int index = series.getData().size()+1;
        System.out.println(index + " " + value);
        series.getData().add(new XYChart.Data(index, parentAbstraction.getValue()));
    }

    @Override
    public void addTemperatureValue() {
        this.parentAbstraction.addTen();
        int index = series.getData().size()+1;
        series.getData().add(new XYChart.Data(index, parentAbstraction.getValue()));
    }

    @Override
    public void minusTemperatureValue() {
        this.parentAbstraction.minusTen();
        int index = series.getData().size()+1;
        series.getData().add(new XYChart.Data(index, parentAbstraction.getValue()));
    }
}
