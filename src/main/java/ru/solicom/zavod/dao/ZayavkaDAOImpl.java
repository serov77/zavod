package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.Zayavka;

@Repository
public class ZayavkaDAOImpl implements ZayavkaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Zayavka nullZayavka() {
        return (Zayavka) sessionFactory.getCurrentSession().createCriteria(Zayavka.class).add(Restrictions.eq("id",1)).uniqueResult();
    }
}
