package jk.uz.pdp.domain.service;

import jk.uz.pdp.domain.exception.DataNotFoundException;
import jk.uz.pdp.domain.exception.EPAMPaymentSecurityException;
import jk.uz.pdp.domain.exception.ServerError;
import jk.uz.pdp.domain.model.User;
import jk.uz.pdp.domain.repository.UserRepository;
import jk.uz.pdp.domain.validator.UserValidator;

public class UserService extends UserRepository {
    private UserValidator userValidator = new UserValidator();
    public User signIn(String phoneNumber, String password)
            throws DataNotFoundException, EPAMPaymentSecurityException {
        User user = getUserByPhoneNumber(phoneNumber);

        if(user.getPassword().equals(password)) {
            return user;
        }

        throw new EPAMPaymentSecurityException("wrong password", ServerError.WRONG_PASSWORD);
    }

    public void register(User user){
        userValidator.validatePhoneNumber(user.getPhoneNumber());
        userValidator.validatePassword(user.getPassword());
        create(user);
    }
}
