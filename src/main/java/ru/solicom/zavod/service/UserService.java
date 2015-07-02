package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.User;

public interface UserService {
    public User searchUserByLogin(String login);
}
