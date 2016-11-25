package ru.solicom.zavod.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.SertificatMPA;

import java.util.List;

@Repository
public class SertificatMPADAOImpl implements SertificatMPADAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SertificatMPA> sertificatMPAList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPA s where s.id != 1 and s.pokupatel.id != 1 order by s.id");
        return q.list();
    }

    @Override
    public List<SertificatMPA> sertificatMPABezPoluchatelyaList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPA s where s.id != 1 and s.pokupatel.id = 1 order by s.id");
        return q.list();
    }

    @Override
    public SertificatMPA retriveSertificatMPA(int id) {
        return (SertificatMPA) sessionFactory.getCurrentSession().createCriteria(SertificatMPA.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void saveSertificatMPA(SertificatMPA sertificatMPA) {
        sessionFactory.getCurrentSession().saveOrUpdate(sertificatMPA);
    }

    @Override
    public Boolean searchSertificatMPAByNomerAndGod(int id, String nomer, LocalDate data) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPA s where s.nomer = :nomer and year(s.data) = :data order by s.id");
        q.setString("nomer", nomer);
        q.setInteger("data", data.getYear());
        SertificatMPA s = (SertificatMPA) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public List<SertificatMPA> searchSertificatMPAByData(LocalDate date) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPA s where s.id != 1 and s.pokupatel.id != 1 and s.data = :date");
        q.setDate("date", date.toDate());
        return q.list();
    }
}
