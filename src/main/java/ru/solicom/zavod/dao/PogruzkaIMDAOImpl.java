package ru.solicom.zavod.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import org.joda.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class PogruzkaIMDAOImpl implements PogruzkaIMDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaIM> pogruzkaIMList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIM s where s.sertificatIM.id <> :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaIM> l = q.list();
        return l;    }

    @Override
    public List<PogruzkaIM> pogruzkaIMNaLiniiList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIM s where s.sertificatIM.id = :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaIM> l = q.list();
        return l;
    }

    @Override
    public void savePogruzkaIM(PogruzkaIM pogruzkaIM) {
        sessionFactory.getCurrentSession().saveOrUpdate(pogruzkaIM);
    }

    @Override
    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, LocalDate date) {
        PogruzkaIM ik = (PogruzkaIM) sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.ne("sertificatIM.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).add(Restrictions.eq("dataPogruzki", date)).uniqueResult();
        PogruzkaIM ik_2 = (PogruzkaIM) sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.eq("sertificatIM.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).uniqueResult();
        if (ik != null) {
            return StatusVaiona.PogSegodnyaIM;
        } else if (ik_2 != null) {
            return StatusVaiona.StoitNaLiniiIM;
        }
        return StatusVaiona.OK;
    }

    @Override
    public Boolean searchPogruzkaIMMKR(int id) {
        List<PogruzkaIM> list = sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.eq("vagon.id", id)).add(Restrictions.eq("tara.id", 2)).list();
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<PogruzkaIM> searchPogruzkaIM(int id) {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.eq("vagon.id", id)).list();
    }

    @Override
    public PogruzkaIM retrivePogruzkaIM(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIM s where s.id = :id");
        q.setInteger("id", id);
        return (PogruzkaIM)q.uniqueResult();
        //return (PogruzkaIM)sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<PogruzkaIM> searchPogruzkaIMBySertificat(int id) {
        LocalDate date=LocalDate.now();
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.lt("dataOtpravleniya", date)).add(Restrictions.eq("sertificatIM.id", id)).list();
    }

    @Override
    public List<PogruzkaIM> searchPogruzkaIMMesyac(LocalDate x1, LocalDate x2) {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIM s where s.dataOtpravleniya >= :x1 and s.dataOtpravleniya<=:x2 and sertificatIM.id>1 order by s.sertificatIM.pokupatel.name");
        q.setParameter("x1", x1);
        q.setParameter("x2", x2);
        return q.list();
    }
}
