package com.example.measureService.project.data.repository;

import com.example.measureService.project.data.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepository
        extends JpaRepository<UserAccount, UUID> {

    Optional<UserAccount> findUserAccountByEmail(String email);

//    @Query("SELECT s From UserAccount s WHERE s.email = ?1")
//    Optional<UserAccount> findUserAccountByEmail(String email);
}
