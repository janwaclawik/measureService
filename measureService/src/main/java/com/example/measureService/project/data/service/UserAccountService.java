package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.UserAccount;

import java.util.List;

public interface UserAccountService {
    List<UserAccount> getUsers();
    void addNewUserAccount(UserAccount userAccount);
}
