package jk.uz.pdp.domain.validator;

import jk.uz.pdp.domain.exception.EPAMPaymentValidationException;
import jk.uz.pdp.domain.exception.ServerError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public void validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length() < 7 || phoneNumber.length() > 20) {
            throw new EPAMPaymentValidationException("Phone number is too short or long");
        }

        String numsRegEx = "[0-9]+";
        Pattern pattern = Pattern.compile(numsRegEx);
        Matcher matcher = pattern.matcher(phoneNumber);
        if(!matcher.matches()) {
            throw new EPAMPaymentValidationException(ServerError.INVALID_PHONE_NUMBER.value);
        }
    }

    public void validatePassword(String password) {

    }
}
