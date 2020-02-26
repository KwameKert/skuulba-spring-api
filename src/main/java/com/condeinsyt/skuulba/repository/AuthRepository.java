package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository  extends JpaRepository<User, Long> {

    Optional<User> findFirstByUserNameAndPassword(String userName, String password);

    Optional<User> findByUserName(String userName);
}
