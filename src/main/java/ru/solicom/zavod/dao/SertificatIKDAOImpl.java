package ru.solicom.zavod.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.SertificatIK;

import java.util.List;

@Repository
public class SertificatIKDAOImpl implements SertificatIKDAO {

    @Autowired
    private SessionFactory sessionFactory;
//    @Autowired
//    private GruzService gruzService;
//    @Autowired
//    private PokupatelService pokupatelService;

    @Override
    public List<SertificatIK> sertificatIKList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIK s where s.id != 1 and s.pokupatel.id != 1 order by s.id");
        return q.list();
    }

    @Override
    public List<SertificatIK> sertificatIKBezPoluchatelyaList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIK s where s.id != 1 and s.pokupatel.id = 1 order by s.id");
        return q.list();
    }

    @Override
    public SertificatIK retriveSertificatIK(int id) {
        return (SertificatIK) sessionFactory.getCurrentSession().createCriteria(SertificatIK.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void saveSertificatIK(SertificatIK sertificatIK) {
        sessionFactory.getCurrentSession().saveOrUpdate(sertificatIK);
    }

    @Override
    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, LocalDate data) {
        int data1 = data.getYear();
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIK s where s.nomer = :nomer and year(s.data) = :data order by s.id");
        q.setString("nomer", nomer);
        q.setInteger("data", data1);
        SertificatIK s = (SertificatIK) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public List<SertificatIK> searchSertificatIKByData(LocalDate date) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIK s where s.id != 1 and s.pokupatel.id != 1 and s.data = :date order by s.id desc");
        q.setDate("date", date.toDate());
        return q.list();
    }
}
