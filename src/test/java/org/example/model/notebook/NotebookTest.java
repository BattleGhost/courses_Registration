package org.example.model.notebook;

import org.example.model.exceptions.LoginIsAlreadyTakenException;
import org.example.view.UnpackedConstants;
import org.example.view.View;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotebookTest {
    @BeforeClass
    public static void createView() {
        View view = new View();
        UnpackedConstants.createConstants(view);
    }

    @Test(expected = LoginIsAlreadyTakenException.class)
    public void createNoteShouldThrowLoginIsAlreadyTakenException() throws LoginIsAlreadyTakenException {
        Notebook notebook = new Notebook();
        String someData = "data";
        for (int i = 0; i < 2; i++) {
            notebook.createNote(someData, someData, someData, someData, someData, someData, someData, someData, someData,
                    someData, someData, someData, someData, someData, someData);
        }
    }
}