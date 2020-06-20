package org.example;

import bluej.extensions.BPackage;
import bluej.extensions.MenuGenerator;
import org.example.gui.controller.IMainController;
import org.example.gui.controller.MainController;
import org.example.model.Counter;
import org.example.model.ICounter;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class shows how you can bind different menus to different parts of BlueJ
 * Remember:
 * * - getToolsMenuItem, getClassMenuItem and getObjectMenuItem may be called by BlueJ at any time.
 * * - They must generate a new JMenuItem each time they are called.
 * * - No reference to the JMenuItem should be stored in the extension.
 * * - You must be quick in generating your menu.
 */
public class MenuBuilder extends MenuGenerator {


    public JMenuItem getToolsMenuItem(BPackage aPackage) {
        return new JMenuItem(new ToolsAction("Open JavaFX Counter"));
    }

    private void showTest() {
        ICounter counter = new Counter();
        IMainController mainController = new MainController(counter);
    }

    class ToolsAction extends AbstractAction {
        ToolsAction(String menuName) {
            putValue(AbstractAction.NAME, menuName);
        }

        public void actionPerformed(ActionEvent anEvent) {
            showTest();
        }
    }
}