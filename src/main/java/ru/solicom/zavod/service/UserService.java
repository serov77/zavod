package ru.solicom.zavod.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.solicom.zavod.domain.User;

public interface UserService extends UserDetailsService {
    public User getNullUser();
}
