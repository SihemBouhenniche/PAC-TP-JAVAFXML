package sample.entryfiledagent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EntryFieldAbsraction extends Observable  implements Observer{
    private int value = 0;
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(this,this.value);
        }
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyAllObservers();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.value = (int) arg;
        System.out.println(observers);
        notifyAllObservers();
    }

}
