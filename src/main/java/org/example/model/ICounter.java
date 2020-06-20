package org.example.model;

import java.beans.PropertyChangeListener;

public interface ICounter {
    void init();

    int getCount();

    void setCount(int newCount);

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}
