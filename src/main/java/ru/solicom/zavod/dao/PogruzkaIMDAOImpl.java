package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaIM;

import java.util.List;

@Repository
public class PogruzkaIMDAOImpl implements PogruzkaIMDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaIM> pogruzkaIMList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.ne("sertificatIM.id", 1)).addOrder(Order.asc("id")).list();
    }

    @Override
    public List<PogruzkaIM> pogruzkaIMNaLiniiList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.eq("sertificatIM.id", 1)).addOrder(Order.asc("id")).list();

    }
}
