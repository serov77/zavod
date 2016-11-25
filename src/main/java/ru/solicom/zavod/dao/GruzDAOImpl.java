package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.Gruz;

import java.util.List;

@Repository
public class GruzDAOImpl implements GruzDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Gruz> gruzList() {
        return sessionFactory.getCurrentSession().createCriteria(Gruz.class).addOrder(Order.asc("id")).list();
    }

    @Override
    public Gruz retriveGruz(int id) {
        return (Gruz) sessionFactory.getCurrentSession().createCriteria(Gruz.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<Gruz> opasniyGrusList() {
        return sessionFactory.getCurrentSession().createCriteria(Gruz.class).add(Restrictions.le("id", 2)).list();
    }

    @Override
    public List<Gruz> neOpasniyGrusList() {
        return sessionFactory.getCurrentSession().createCriteria(Gruz.class).add(Restrictions.ge("id", 3)).list();

    }

}
