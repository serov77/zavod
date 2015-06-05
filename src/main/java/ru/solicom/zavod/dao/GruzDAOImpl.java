package ru.solicom.zavod.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.Gruz;

@Repository
public class GruzDAOImpl implements GruzDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Gruz> gruzList() {
        return sessionFactory.getCurrentSession().createCriteria(Gruz.class).addOrder(Order.asc("id")).list();
    }

}
