package org.example.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.gui.controller.IMainController;
import org.example.model.ICounter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainView extends Application implements PropertyChangeListener {
    ICounter counter;
    IMainController mainController;

    Button increaseBtn;
    Button decreaseBtn;
    Label counterDisplay;

    public MainView() {

    }

    public MainView(IMainController mainController, ICounter counter) {
        this.mainController = mainController;
        this.counter = counter;
        counter.addPropertyChangeListener(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        createView(primaryStage);
        setupController();
        updateCounterDisplay();
    }

    private void createView(Stage primaryStage) {
        increaseBtn = new Button("+");
        counterDisplay = new Label();
        decreaseBtn = new Button("-");

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(increaseBtn, counterDisplay, decreaseBtn);

        Scene scene = new Scene(vBox, 200, 250);
        primaryStage.setTitle("Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupController() {
        increaseBtn.setOnAction(e -> mainController.increaseCounter());
        decreaseBtn.setOnAction(e -> mainController.decreaseCounter());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("counter")) {
            updateCounterDisplay();
        }
    }

    private void updateCounterDisplay() {
        counterDisplay.setText(Integer.toString(counter.getCount()));
    }
}
