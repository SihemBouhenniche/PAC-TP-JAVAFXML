package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public abstract class ParentController implements Initializable {

    @FXML
    protected AnchorPane entryFieldContainer;

    @FXML
    protected AnchorPane paletteContainer;

    public abstract void changeTemperatureValue(int value);
    public abstract void addTemperatureValue();
    public abstract void minusTemperatureValue();
}
