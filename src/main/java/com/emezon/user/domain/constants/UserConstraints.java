package com.emezon.user.domain.constants;

import com.emezon.user.domain.models.User;

import java.time.LocalDate;
import java.time.Period;

public class UserConstraints {

    public static final int MAX_CELLPHONE_LENGTH = 13;
    private static final int LEGAL_AGE = 18;
    private static final String EMAIL_REGEX = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String CELLPHONE_REGEX = "^\\+?[0-9]+$"; // "^\\+?[0-9]{7,13}$" for 7 to 13 digits

    private UserConstraints() { }

    public static User processAndValidate(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException(UserErrorMessages.USER_EMAIL_REQUIRED);
        }
        user.setEmail(user.getEmail().trim());
        if (!user.getEmail().matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException(UserErrorMessages.USER_EMAIL_INVALID);
        }
        if (user.getCellphone() == null) {
            throw new IllegalArgumentException(UserErrorMessages.USER_CELLPHONE_REQUIRED);
        }
        user.setCellphone(user.getCellphone().trim());
        if (user.getCellphone().length() > MAX_CELLPHONE_LENGTH) {
            throw new IllegalArgumentException(String.format(UserErrorMessages.USER_CELLPHONE_TOO_LONG, MAX_CELLPHONE_LENGTH));
        }
        if (!user.getCellphone().matches(CELLPHONE_REGEX)) {
            throw new IllegalArgumentException(UserErrorMessages.USER_CELLPHONE_INVALID);
        }
        if (user.getDocNumber() == null) {
            throw new IllegalArgumentException(UserErrorMessages.USER_DOC_NUMBER_REQUIRED);
        }
        if (user.getBirthdate() == null) {
            throw new IllegalArgumentException(UserErrorMessages.USER_BIRTHDATE_REQUIRED);
        }
        LocalDate now = LocalDate.now();
        int age = Period.between(user.getBirthdate(), now).getYears();
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException(String.format(UserErrorMessages.USER_UNDERAGE, LEGAL_AGE));
        }
        if (user.getName() == null) {
            throw new IllegalArgumentException(UserErrorMessages.USER_NAME_REQUIRED);
        }
        user.setName(user.getName().trim());
        if (user.getLastName() == null) {
            throw new IllegalArgumentException(UserErrorMessages.USER_LASTNAME_REQUIRED);
        }
        user.setLastName(user.getLastName().trim());
        if (user.getPassword() == null) {
            throw new IllegalArgumentException(UserErrorMessages.USER_PASSWORD_REQUIRED);
        }
        return user;
    }

}
