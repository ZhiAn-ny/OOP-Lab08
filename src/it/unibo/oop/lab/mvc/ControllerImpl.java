package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private String currentString;
    private final List<String> history;

    public ControllerImpl() {
        this.currentString = null;
        this.history = new ArrayList<>();
    }

    /**
     * 
     */
    @Override
    public void setNextString(final String str) {
        if (str != null && !str.isEmpty()) {
            this.currentString = str;
        } else {
            throw new IllegalArgumentException("Please insert a valid string.");
        }
    }

    /**
     * 
     */
    @Override
    public String getNextString() {
        return this.currentString;
    }

    /**
     * 
     */
    @Override
    public List<String> getStringHistory() {
        return this.history;
    }

    /**
     * 
     */
    @Override
    public void printString() {
        if (this.currentString != null) {
            System.out.println(this.currentString);
            history.add(0, this.currentString);
            this.currentString = null;
        } else {
            throw new IllegalStateException("The next printable string has not been setted.");
        }
    }

}
