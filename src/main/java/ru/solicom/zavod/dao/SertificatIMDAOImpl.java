package ru.solicom.zavod.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.SertificatIM;

import java.util.List;

@Repository
public class SertificatIMDAOImpl implements SertificatIMDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SertificatIM> sertificatIMList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIM s where s.id != 1 and s.pokupatel.id != 1 order by s.id");
        return q.list();
    }

    @Override
    public List<SertificatIM> sertificatIMBezPoluchatelyaList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIM s where s.id != 1 and s.pokupatel.id = 1 order by s.id");
        return q.list();
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
    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, LocalDate data) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIM s where s.nomer = :nomer and year(s.data) = :data order by s.id");
        q.setString("nomer", nomer);
        q.setInteger("data", data.getYear());
        SertificatIM s = (SertificatIM) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public List<SertificatIM> searchSertificatIMByData(LocalDate date) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIM s where s.id != 1 and s.pokupatel.id != 1 and s.data = :date");
        q.setDate("date", date.toDate());
        return q.list();
    }
}
