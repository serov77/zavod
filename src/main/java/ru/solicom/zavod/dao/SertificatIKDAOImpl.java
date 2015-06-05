package ru.solicom.zavod.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.SertificatIK;

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
        return sessionFactory.getCurrentSession().createCriteria(SertificatIK.class).addOrder(Order.desc("id")).list();
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
    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, Date data) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatIK s where s.nomer = :nomer and year(s.data) = year(:data)");
        q.setString("nomer", nomer);
        q.setDate("data", data);
        SertificatIK s = (SertificatIK) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }
}
