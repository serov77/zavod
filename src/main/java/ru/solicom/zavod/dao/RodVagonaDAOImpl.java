package ru.solicom.zavod.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.RodVagona;

@Repository
public class RodVagonaDAOImpl implements RodVagonaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<RodVagona> rodVagonaList() {
        return sessionFactory.getCurrentSession().createQuery("from RodVagona").list();
    }

    @Override
    public RodVagona retriveRodVagona(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from RodVagona where id = :id");
        q.setInteger("id", id);
        return (RodVagona) q.uniqueResult();
    }
}
