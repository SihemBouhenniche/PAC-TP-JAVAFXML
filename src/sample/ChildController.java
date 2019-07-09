package sample;

import java.util.Observer;

public abstract class ChildController{
    protected ParentController parentController;

    public ParentController getParentController() {
        return parentController;
    }

    public void setParentController(ParentController parentController) {
        this.parentController = parentController;
    }

    public abstract void setTempratureValueOnParent(int value);
}
