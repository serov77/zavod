package ru.solicom.zavod.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.User;

public interface UserDAO  {
    public UserDetails loadUserByUsername(String login);
}
