package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaMPN;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Repository
public class PogruzkaMPNDAOImpl implements PogruzkaMPNDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaMPN> pogruzkaMPNList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.ne("sertificatMPN.id", 1)).addOrder(Order.asc("id")).list();

    }

    @Override
    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.eq("sertificatMPN.id", 1)).addOrder(Order.asc("id")).list();

    }

    @Override
    public StatusVaiona searchPogruzkaMPNVagonaZaDen(Vagon vagon, Date date) {
        return null;
    }
}
