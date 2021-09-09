package org.example.controller;

import org.example.model.Model;
import org.example.model.exceptions.LoginIsAlreadyTakenException;
import org.example.view.UnpackedConstants;
import org.example.view.View;

import java.util.*;

public class Controller implements NecessaryData{
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.createNotebook();
        addNotes(scanner, 2);
        showNotebook();
    }

    public void addNotes(Scanner scanner, int numberOfNotesToAdd) {
        for (int i = 0; i < numberOfNotesToAdd; i++) {
            boolean userDataAdded = false;
            Map<String, String> userData = getNoteData(scanner, necessaryData);

            while (!userDataAdded) {
                userDataAdded = true;
                try {
                    sendDataToModel(userData);
                } catch (LoginIsAlreadyTakenException e) {
                    e.printStackTrace();
                    userDataAdded = false;
                    String key = TechnicalNames.TECHNICAL_NICKNAME;
                    userData.put(key, getNoteData(scanner, Collections.singletonList(key)).get(key));
                }
            }
            view.showMessage(UnpackedConstants.MESSAGE_OUTPUT_SUCCESS);
        }
    }

    public Map<String, String> getNoteData (Scanner scanner, List<String> necessaryData) {
        Map<String, String> userData = new HashMap<>();
        for (String key : necessaryData) {
            String userInput;
            String currentError;
            boolean isCorrect;
            do {
                if (TechnicalNames.TECHNICAL_EXCEPTIONAL_CASE_GROUPS.equals(key)) {
                    userInput = getUserInput(scanner, view.concatStrings(necessaryDataMap.get(key),
                            UnpackedConstants.MESSAGE_CONSTANT_SPACE,
                            UnpackedConstants.MESSAGE_CONSTANT_PARENTHESIS_OPEN,
                            view.stringifyList(model.getAvailableGroups()),
                            UnpackedConstants.MESSAGE_CONSTANT_PARENTHESIS_CLOSE));
                    isCorrect = model.getAvailableGroups().contains(userInput.toLowerCase());
                    currentError = UnpackedConstants.MESSAGE_OUTPUT_WRONG_GROUP;
                } else {
                    userInput = getUserInput(scanner, view.concatStrings(necessaryDataMap.get(key)));
                    isCorrect = userInput.matches(necessaryDataRegexpsMap.get(key));
                    currentError = UnpackedConstants.MESSAGE_OUTPUT_WRONG_DATA;
                }
                if (!isCorrect)
                    view.showMessage(currentError);
            } while(!isCorrect);
            userData.put(key, userInput);
        }
        return userData;
    }

    public String getUserInput(Scanner scanner, String inputDataName) {
        view.showMessage(view.concatStrings(
                UnpackedConstants.MESSAGE_INPUT_REQUEST,
                UnpackedConstants.MESSAGE_CONSTANT_SPACE,
                inputDataName,
                UnpackedConstants.MESSAGE_CONSTANT_COLON
        ));
        return scanner.nextLine();
    }

    public void sendDataToModel(Map<String, String> userData) throws LoginIsAlreadyTakenException {
        model.createNoteInNotebook(
                userData.get(TechnicalNames.TECHNICAL_SURNAME),
                userData.get(TechnicalNames.TECHNICAL_MAME),
                userData.get(TechnicalNames.TECHNICAL_NICKNAME),
                userData.get(TechnicalNames.TECHNICAL_COMMENT),
                userData.get(TechnicalNames.TECHNICAL_GROUP),
                userData.get(TechnicalNames.TECHNICAL_HOME_PHONE),
                userData.get(TechnicalNames.TECHNICAL_CELLPHONE_FIRST),
                userData.get(TechnicalNames.TECHNICAL_CELLPHONE_SECOND),
                userData.get(TechnicalNames.TECHNICAL_EMAIL),
                userData.get(TechnicalNames.TECHNICAL_SKYPE),
                userData.get(TechnicalNames.TECHNICAL_ZIP),
                userData.get(TechnicalNames.TECHNICAL_CITY),
                userData.get(TechnicalNames.TECHNICAL_STREET),
                userData.get(TechnicalNames.TECHNICAL_BUILDING),
                userData.get(TechnicalNames.TECHNICAL_APARTMENT)
        );
    }

    public void showNotebook() {
        view.showMessage(model.notebookAsString());
    }
}
