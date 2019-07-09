package sample.paletteagent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.ChildController;

public class PaletteController extends ChildController {
    @Override
    public void setTempratureValueOnParent(int value) {
        this.parentController.changeTemperatureValue(value);
    }

    @FXML
    void onAddTen(ActionEvent event) {
        this.parentController.addTemperatureValue();
    }

    @FXML
    void onMinusTen(ActionEvent event) {
        this.parentController.minusTemperatureValue();
    }

    @FXML
    void onSerZero(ActionEvent event) {
        setTempratureValueOnParent(0);
    }
}
