package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.Tara;

import java.util.List;
@Repository
public class TaraDAOImpl implements TaraDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Tara> taraList() {
        return sessionFactory.getCurrentSession().createCriteria(Tara.class).addOrder(Order.asc("id")).list();
    }

    @Override
    public List<Tara> taraBezMKRList() {
        return sessionFactory.getCurrentSession().createCriteria(Tara.class).add(Restrictions.ne("name", "МКР")).addOrder(Order.asc("id")).list();
    }
}