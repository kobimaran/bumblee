package com.example.bumble.logindomain;

import org.springframework.stereotype.Repository;

import com.example.LindaSchool.Logindomain.login.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
Login findByUsernameAndPassword(String username, String password);
 
}
