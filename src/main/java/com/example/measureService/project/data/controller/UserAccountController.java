package com.example.measureService.project.data.controller;

import com.example.measureService.project.data.domain.UserAccount;
import com.example.measureService.project.data.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserAccountController {
    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public List<UserAccount> getUsers() {
        return userAccountService.getUsers();
    }

    @PostMapping
    public void registerNewAccount(@RequestBody UserAccount userAccount) {
        userAccountService.addNewUserAccount(userAccount);
    }
}
