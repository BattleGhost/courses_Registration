package org.example.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private Locale locale;
    private ResourceBundle resourceBundle;

    public View(Locale locale) {
        this.locale = locale;
        this.resourceBundle = ResourceBundle.getBundle(GlobalConstants.BUNDLE_NAME, this.locale);
        UnpackedConstants.createConstants(this);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getTextFromBundle(String key) {
        return this.resourceBundle.getString(key);
    }

    public String concatStrings(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

}
