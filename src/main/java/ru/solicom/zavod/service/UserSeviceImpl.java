package ru.solicom.zavod.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.UserDAO;
import ru.solicom.zavod.domain.User;

@Service
public class UserSeviceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public User getNullUser() {
        return userDAO.getNullUser();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
