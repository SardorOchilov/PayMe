package jk.uz.pdp.domain.repository;

import jk.uz.pdp.domain.exception.DataNotFoundException;
import jk.uz.pdp.domain.exception.EPAMPaymentServerException;
import jk.uz.pdp.domain.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class UserRepository implements BaseCrudRepository<User, UUID>{
    private final List<User> userList = new ArrayList<>();

    @Override
    public void create(User user) {
        if(isExist(user.getPhoneNumber())) {
            throw new EPAMPaymentServerException("phone number already registered");
        }
        user.setId(UUID.randomUUID());
        userList.add(user);
    }

    @Override
    public User getById(UUID id) {
        for (User user: userList) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        throw new DataNotFoundException("User with id: " + id + " not found");
    }

    @Override
    public List<User> getList() {
        return userList;
    }

    @Override
    public User update(User update) {
        int i = 0;
        for (User user: userList) {
            if (user.getId().equals(update.getId())) {
                userList.set(i, update);
                return update;
            }
            i++;
        }
        throw new DataNotFoundException("User with id: " + update.getId() + " not found");
    }

    @Override
    public void delete(UUID id) {
        userList.removeIf(user -> user.getId().equals(id));
        throw new DataNotFoundException("User with id: " + id + " not found");
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        for(User user:userList) {
            if(user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        throw new DataNotFoundException("User with phone number: " + phoneNumber + " not found");
    }

    private boolean isExist(String phoneNumber) {
        for (User user: userList) {
            if(user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
