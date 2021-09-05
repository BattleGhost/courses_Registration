package org.example.controller;

import org.example.model.Model;
import org.example.view.View;

import java.util.Scanner;

public class Controller implements NecessaryData{
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {

    }

    public String getUserInput(Scanner scanner) {
        return "";
    }
}
