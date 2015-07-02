package ru.solicom.zavod.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDAO.loadUserByUsername(login);
    }
}
