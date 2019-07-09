package sample.parentagent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ParentAbstraction extends Observable {
    private int value = 0;
    private List<Observer> observers = new ArrayList<Observer>();
    public ParentAbstraction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        System.out.println(observers);
        notifyAllObservers();
    }
    public void addTen(){
        this.value += 10;
        notifyAllObservers();
    }
    public void minusTen(){
        this.value -= 10;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(this,this.value);
        }
    }
}
