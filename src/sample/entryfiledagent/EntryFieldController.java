package sample.entryfiledagent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.ChildController;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;


public class EntryFieldController extends ChildController implements Observer, Initializable {
    private EntryFieldAbsraction entryFieldAbsraction = new EntryFieldAbsraction();
    @FXML
    private TextField valueTf;

    public EntryFieldAbsraction getEntryFieldAbsraction() {
        return entryFieldAbsraction;
    }

    @Override
    public void setTempratureValueOnParent(int value) {
        this.parentController.changeTemperatureValue(value);
    }

    @FXML
    public void onSetTemperature(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            setTempratureValueOnParent(Integer.parseInt(valueTf.getText().toString()));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.valueTf.setText(arg.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.entryFieldAbsraction.attach(this);
    }
}
