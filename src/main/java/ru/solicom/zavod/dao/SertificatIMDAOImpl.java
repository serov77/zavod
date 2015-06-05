package ru.solicom.zavod.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.SertificatIM;

import java.util.Date;
import java.util.List;

@Repository
public class SertificatIMDAOImpl implements SertificatIMDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SertificatIM> sertificatIMList() {
        return sessionFactory.getCurrentSession().createCriteria(SertificatIM.class).addOrder(Order.desc("id")).list();

    }

    @Override
    public SertificatIM retriveSertificatIM(int id) {
        return (SertificatIM) sessionFactory.getCurrentSession().createCriteria(SertificatIM.class).add(Restrictions.eq("id", id)).uniqueResult();

    }


    @Override
    public void saveSertificatIM(SertificatIM sertificatIM) {
        sessionFactory.getCurrentSession().saveOrUpdate(sertificatIM);
    }

    @Override
    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, Date data) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIM s where s.nomer = :nomer and year(s.data) = year(:data)");
        q.setString("nomer", nomer);
        q.setDate("data", data);
        SertificatIM s = (SertificatIM) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }
}
