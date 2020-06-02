package com.mbegyn.newslettersb.service;

import com.mbegyn.newslettersb.model.User;
import com.mbegyn.newslettersb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository usersRepository;

    public List<User> listAll() {
        return usersRepository.findAll();
    }

    public void save(User user) {
        usersRepository.save(user);
    }

    public User getId(int id) {
        return usersRepository.findById(id).get();
    }

    public void delete(int id) {
        usersRepository.deleteById(id);
    }

}