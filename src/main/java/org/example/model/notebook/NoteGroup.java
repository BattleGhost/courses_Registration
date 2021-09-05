package org.example.model.notebook;

import org.example.view.UnpackedConstants;

import java.util.ArrayList;
import java.util.List;

public enum NoteGroup {
    FAMILY(UnpackedConstants.MESSAGE_CONSTANT_GROUPS_FAMILY), FRIENDS(UnpackedConstants.MESSAGE_CONSTANT_GROUPS_FRIENDS),
    COWORKERS(UnpackedConstants.MESSAGE_CONSTANT_GROUPS_COWORKERS), OTHER(UnpackedConstants.MESSAGE_CONSTANT_GROUPS_OTHER);

    private static final NoteGroup DEFAULT_GROUP = NoteGroup.OTHER;
    private String localName;

    NoteGroup(String localName) {
        this.localName = localName;
    }

    public String getLocalName() {
        return localName;
    }

    public static NoteGroup localValueOf(String localName) {
        for (NoteGroup group : NoteGroup.values()) {
            if (group.getLocalName().toUpperCase().equals(localName.toUpperCase()))
                return group;
        }
        return DEFAULT_GROUP;
    }

    public static List<String> getAvailableGroups() {
        List<String> groups = new ArrayList<>();
        for (NoteGroup group : NoteGroup.values()) {
            groups.add(group.localName);
        }
        return groups;
    }
}
