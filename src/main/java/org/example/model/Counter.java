package org.example.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Counter implements ICounter {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private int count;

    public void init() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int newCount) {
        int oldCount = count;
        this.count = newCount;
        pcs.firePropertyChange("counter", oldCount, newCount);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
