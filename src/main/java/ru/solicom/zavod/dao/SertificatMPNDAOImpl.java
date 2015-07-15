package ru.solicom.zavod.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.SertificatMPN;

import java.util.Date;
import java.util.List;

@Repository
public class SertificatMPNDAOImpl implements SertificatMPNDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SertificatMPN> sertificatMPNList() {
        return sessionFactory.getCurrentSession().createCriteria(SertificatMPN.class).add(Restrictions.gt("id", 1)).addOrder(Order.desc("id")).list();
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
    public Boolean searchSertificatMPNByNomerAndGod(int id, String nomer, Date data) {
        Query q = sessionFactory.getCurrentSession().createQuery("from SertificatMPN s where s.nomer = :nomer and year(s.data) = year(:data)");
        q.setString("nomer", nomer);
        q.setDate("data", data);
        SertificatMPN s = (SertificatMPN) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }
}
