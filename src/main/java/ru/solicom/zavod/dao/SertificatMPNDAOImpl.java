package ru.solicom.zavod.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.SertificatMPN;

import java.util.List;

@Repository
public class SertificatMPNDAOImpl implements SertificatMPNDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SertificatMPN> sertificatMPNList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPN s where s.id != 1 and s.pokupatel.id != 1 order by s.id");
        return q.list();
    }

    @Override
    public List<SertificatMPN> sertificatMPNBezPoluchatelyaList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPN s where s.id != 1 and s.pokupatel.id = 1 order by s.id");
        return q.list();
    }

    @Override
    public SertificatMPN retriveSertificatMPN(int id) {
        return (SertificatMPN) sessionFactory.getCurrentSession().createCriteria(SertificatMPN.class).add(Restrictions.eq("id", id)).uniqueResult();

    }

    @Override
    public void saveSertificatMPN(SertificatMPN sertificatMPN) {
        sessionFactory.getCurrentSession().saveOrUpdate(sertificatMPN);
    }

    @Override
    public Boolean searchSertificatMPNByNomerAndGod(int id, String nomer, LocalDate data) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPN s where s.nomer = :nomer and year(s.data) = :data order by s.id");
        q.setString("nomer", nomer);
        q.setInteger("data", data.getYear());
        SertificatMPN s = (SertificatMPN) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public List<SertificatMPN> searchSertificatMPNByData(LocalDate date) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPN s where s.id != 1 and s.pokupatel.id != 1 and s.data = :date");
        q.setDate("date", date.toDate());
        return q.list();
    }
}
