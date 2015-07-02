package ru.solicom.zavod.dao;

import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.User;

public interface UserDAO {
    public User searchUserByLogin(String login);
}
