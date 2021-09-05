package org.example;

import org.example.controller.Controller;
import org.example.model.Model;
import org.example.view.GlobalConstants;
import org.example.view.View;

import java.util.Locale;

public class Main
{
    public static void main(String[] args)
    {
        Locale locale = new Locale("uk", "UA");
        View view = new View(locale);
        Model model = new Model();
        Controller controller = new Controller(model, view);


    }
}
