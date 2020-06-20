package org.example.gui.controller;

import javafx.stage.Stage;
import org.example.gui.MainView;
import org.example.model.ICounter;

public class MainController implements IMainController {
    ICounter counter;
    MainView mainView;

    public MainController(ICounter counter) {
        this.counter = counter;
        mainView = new MainView(this, counter);
        try {
            // FIXME This is probably not how you're supposed to start a JavaFX app
            mainView.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        counter.init();
    }

    @Override
    public void increaseCounter() {
        counter.setCount(counter.getCount() + 1);
    }

    @Override
    public void decreaseCounter() {
        counter.setCount(counter.getCount() - 1);
    }
}
