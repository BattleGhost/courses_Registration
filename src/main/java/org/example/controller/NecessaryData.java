package org.example.controller;

import org.example.view.UnpackedConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public interface NecessaryData {

    List<String> necessaryData = Arrays.asList(
        TechnicalNames.TECHNICAL_SURNAME,
        TechnicalNames.TECHNICAL_MAME,
        TechnicalNames.TECHNICAL_NICKNAME,
        TechnicalNames.TECHNICAL_COMMENT,
        TechnicalNames.TECHNICAL_GROUP,
        TechnicalNames.TECHNICAL_HOME_PHONE,
        TechnicalNames.TECHNICAL_CELLPHONE_FIRST,
        TechnicalNames.TECHNICAL_CELLPHONE_SECOND,
        TechnicalNames.TECHNICAL_EMAIL,
        TechnicalNames.TECHNICAL_SKYPE,
        TechnicalNames.TECHNICAL_ZIP,
        TechnicalNames.TECHNICAL_CITY,
        TechnicalNames.TECHNICAL_STREET,
        TechnicalNames.TECHNICAL_BUILDING,
        TechnicalNames.TECHNICAL_APARTMENT
    );

    List<String> necessaryDataNames = Arrays.asList(UnpackedConstants.MESSAGE_INPUT_SURNAME,
            UnpackedConstants.MESSAGE_INPUT_NAME,
            UnpackedConstants.MESSAGE_INPUT_NICKNAME,
            UnpackedConstants.MESSAGE_INPUT_COMMENT,
            UnpackedConstants.MESSAGE_INPUT_GROUP,
            UnpackedConstants.MESSAGE_INPUT_PHONE_HOME,
            UnpackedConstants.MESSAGE_INPUT_PHONE_CELLULAR_FIRST,
            UnpackedConstants.MESSAGE_INPUT_PHONE_CELLULAR_SECOND,
            UnpackedConstants.MESSAGE_INPUT_EMAIL,
            UnpackedConstants.MESSAGE_INPUT_SKYPE,
            UnpackedConstants.MESSAGE_INPUT_ADDRESS_ZIP,
            UnpackedConstants.MESSAGE_INPUT_ADDRESS_CITY,
            UnpackedConstants.MESSAGE_INPUT_ADDRESS_STREET,
            UnpackedConstants.MESSAGE_INPUT_ADDRESS_BUILDING,
            UnpackedConstants.MESSAGE_INPUT_ADDRESS_APARTMENT
    );

    List<String> necessaryDataRegexps = Arrays.asList(UnpackedConstants.INPUT_SURNAME_REGEXP,
            UnpackedConstants.INPUT_NAME_REGEXP,
            UnpackedConstants.INPUT_NICKNAME_REGEXP,
            UnpackedConstants.INPUT_COMMENT_REGEXP,
            UnpackedConstants.INPUT_GROUP_REGEXP,
            UnpackedConstants.INPUT_PHONE_HOME_REGEXP,
            UnpackedConstants.INPUT_PHONE_CELLULAR_FIRST_REGEXP,
            UnpackedConstants.INPUT_PHONE_CELLULAR_SECOND_REGEXP,
            UnpackedConstants.INPUT_EMAIL_REGEXP,
            UnpackedConstants.INPUT_SKYPE_REGEXP,
            UnpackedConstants.INPUT_ADDRESS_ZIP_REGEXP,
            UnpackedConstants.INPUT_ADDRESS_CITY_REGEXP,
            UnpackedConstants.INPUT_ADDRESS_STREET_REGEXP,
            UnpackedConstants.INPUT_ADDRESS_BUILDING_REGEXP,
            UnpackedConstants.INPUT_ADDRESS_APARTMENT_REGEXP
    );

    Map<String, String> necessaryDataMap = IntStream.range(0, necessaryData.size()).boxed()
            .collect(Collectors.toMap(necessaryData::get, necessaryDataNames::get));

    Map<String, String> necessaryDataRegexpsMap = IntStream.range(0, necessaryData.size()).boxed()
            .collect(Collectors.toMap(necessaryData::get, necessaryDataRegexps::get));
}