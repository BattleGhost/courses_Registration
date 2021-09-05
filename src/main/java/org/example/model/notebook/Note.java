package org.example.model.notebook;

import org.example.view.UnpackedConstants;

import java.util.Date;

public class Note {
    private String surname;
    private String name;
    private String fullName;
    private String nickname;
    private String comment;
    private NoteGroup group;
    private String homePhone;
    private String cellPhoneFirst;
    private String cellPhoneSecond;
    private String email;
    private String skype;
    private String zipCode;
    private String city;
    private String street;
    private String building;
    private String apartments;
    private String address;
    private Date creationDate;
    private Date changeDate;

    public Note(String surname, String name, String nickname, String comment, NoteGroup group, String homePhone,
                String cellPhoneFirst, String cellPhoneSecond, String email, String skype, String zipCode, String city,
                String street, String building, String apartments) {
        this.surname = surname;
        this.name = name;
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.homePhone = homePhone;
        this.cellPhoneFirst = cellPhoneFirst;
        this.cellPhoneSecond = cellPhoneSecond;
        this.email = email;
        this.skype = skype;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartments = apartments;

        this.fullName = createFullName(name, surname);
        this.address = createAddress(zipCode, city, street, building, apartments);
        this.creationDate = new Date();
        this.changeDate = new Date();
    }

    public static String createFullName(String name, String surname) {
        StringBuilder sb = new StringBuilder(surname);
        sb.append(UnpackedConstants.MESSAGE_CONSTANT_SPACE).append(name.charAt(0))
                .append(UnpackedConstants.MESSAGE_CONSTANT_DOT);
        return sb.toString();
    }

    public static String createAddress(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string).append(UnpackedConstants.MESSAGE_CONSTANT_COMMA)
                    .append(UnpackedConstants.MESSAGE_CONSTANT_SPACE);
        }
        return sb.substring(0,sb.length()-2);
    }

    @Override
    public String toString() {
        return "Note{" +
                "\nsurname='" + surname + '\'' +
                ", \nname='" + name + '\'' +
                ", \nfullName='" + fullName + '\'' +
                ", \nnickname='" + nickname + '\'' +
                ", \ncomment='" + comment + '\'' +
                ", \ngroup=" + group +
                ", \nhomePhone='" + homePhone + '\'' +
                ", \ncellPhoneFirst='" + cellPhoneFirst + '\'' +
                ", \ncellPhoneSecond='" + cellPhoneSecond + '\'' +
                ", \nemail='" + email + '\'' +
                ", \nskype='" + skype + '\'' +
                ", \nzipCode='" + zipCode + '\'' +
                ", \ncity='" + city + '\'' +
                ", \nstreet='" + street + '\'' +
                ", \nbuilding='" + building + '\'' +
                ", \napartments='" + apartments + '\'' +
                ", \naddress='" + address + '\'' +
                ", \ncreationDate=" + creationDate +
                ", \nchangeDate=" + changeDate + "\n" +
                '}';
    }
}
