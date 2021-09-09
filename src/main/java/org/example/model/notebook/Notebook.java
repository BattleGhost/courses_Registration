package org.example.model.notebook;

import org.example.model.exceptions.LoginIsAlreadyTakenException;
import org.example.view.UnpackedConstants;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    public List<Note> notes = new ArrayList<>();

    public void createNote(String surname, String name, String nickname, String comment, String group,
                           String homePhone, String cellPhoneFirst, String cellPhoneSecond, String email,
                           String skype, String zipCode, String city, String street, String building,
                           String apartments) throws LoginIsAlreadyTakenException {
        boolean isAvailableLogin = true;
        for (Note note : notes) {
            if (note.getNickname().equals(nickname)) {
                isAvailableLogin = false;
                break;
            }
        }
        if (!isAvailableLogin)
            throw new LoginIsAlreadyTakenException(UnpackedConstants.MESSAGE_OUTPUT_WRONG_LOGIN_TAKEN);
        Note note = new Note(surname, name, nickname, comment, NoteGroup.localValueOf(group), homePhone, cellPhoneFirst, cellPhoneSecond,
                email, skype, zipCode, city, street, building, apartments);

        notes.add(note);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Notes:");
        for (Note note : notes) {
            sb.append("\n").append(note.toString());
        }
        return sb.toString();
    }
}