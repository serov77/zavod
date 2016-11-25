package ru.solicom.zavod.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaMPN;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;
import org.joda.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class PogruzkaMPNDAOImpl implements PogruzkaMPNDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaMPN> pogruzkaMPNList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaMPN s where s.sertificatMPN.id <> :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaMPN> l = q.list();
        return l;
    }

    @Override
    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaMPN s where s.sertificatMPN.id = :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaMPN> l = q.list();
        return l;
    }

    @Override
    public void savePogruzkaMPN(PogruzkaMPN pogruzkaMPN) {
        sessionFactory.getCurrentSession().saveOrUpdate(pogruzkaMPN);
    }

    @Override
    public StatusVaiona searchPogruzkaMPNVagonaZaDen(Vagon vagon, LocalDate date) {
        PogruzkaMPN ik = (PogruzkaMPN) sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.ne("sertificatMPN.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).add(Restrictions.eq("dataPogruzki", date)).uniqueResult();
        PogruzkaMPN ik_2 = (PogruzkaMPN) sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.eq("sertificatMPN.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).uniqueResult();
        if (ik != null) {
            return StatusVaiona.PogSegodnyaMPN;
        } else if (ik_2 != null) {
            return StatusVaiona.StoitNaLiniiMPN;
        }
        return StatusVaiona.OK;
    }

    @Override
    public Boolean searchPogruzkaMPNMKR(int id) {
        List<PogruzkaMPN> list = sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.eq("vagon.id", id)).add(Restrictions.eq("tara.id", 2)).list();
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<PogruzkaMPN> searchPogruzkaMPN(int id) {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.eq("vagon.id", id)).list();
    }

    @Override
    public PogruzkaMPN retrivePogruzkaMPN(int id) {
        return (PogruzkaMPN)sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.eq("id", id)).uniqueResult();

    }

    @Override
    public List<PogruzkaMPN> searchPogruzkaMPNBySertificat(int id) {
        LocalDate date=LocalDate.now();
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaMPN.class).add(Restrictions.lt("dataOtpravleniya", date)).add(Restrictions.eq("sertificatMPN.id", id)).list();

    }

    @Override
    public List<PogruzkaMPN> searchPogruzkaMPAMesyac(LocalDate x1, LocalDate x2) {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaMPN s where s.dataOtpravleniya >= :x1 and s.dataOtpravleniya<=:x2 and sertificatMPN.id>1 order by s.sertificatMPN.pokupatel.name");
        q.setParameter("x1", x1);
        q.setParameter("x2", x2);
        return q.list();
    }
}
