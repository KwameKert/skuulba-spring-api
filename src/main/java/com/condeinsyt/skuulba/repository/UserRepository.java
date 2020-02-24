package com.condeinsyt.skuulba.repository;

import com.condeinsyt.skuulba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

     User findByUserName(String userName);
}
