package org.example.model;

import org.example.model.notebook.NoteGroup;
import org.example.model.notebook.Notebook;

import java.util.List;

public class Model {

    private Notebook notebook;
    private List<String> availableGroups;

    public void createNotebook() {
        notebook = new Notebook();
        availableGroups = NoteGroup.getAvailableGroups();
    }

    public void createNoteInNotebook(String surname, String name, String nickname, String comment, NoteGroup group,
                                     String homePhone, String cellPhoneFirst, String cellPhoneSecond, String email,
                                     String skype, String zipCode, String city, String street, String building,
                                     String apartments) {
        notebook.createNote(surname, name, nickname, comment, group, homePhone, cellPhoneFirst, cellPhoneSecond,
                email, skype, zipCode, city, street, building, apartments);
    }

    public List<String> getAvailableGroups() {
        return availableGroups;
    }
}
