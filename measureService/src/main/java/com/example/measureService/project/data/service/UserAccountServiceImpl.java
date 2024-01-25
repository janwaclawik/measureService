package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.UserAccount;
import com.example.measureService.project.data.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public List<UserAccount> getUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public void addNewUserAccount(UserAccount userAccount) {
        if(userAccountRepository.findUserAccountByEmail(userAccount.getEmail()).isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userAccountRepository.save(userAccount);
    }
}
