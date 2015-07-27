package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Repository
public class PogruzkaIMDAOImpl implements PogruzkaIMDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaIM> pogruzkaIMList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.ne("sertificatIM.id", 1)).addOrder(Order.asc("id")).list();
    }

    @Override
    public List<PogruzkaIM> pogruzkaIMNaLiniiList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIM.class).add(Restrictions.eq("sertificatIM.id", 1)).addOrder(Order.asc("id")).list();

    }

    @Override
    public void savePogruzkaIM(PogruzkaIM pogruzkaIM) {
        sessionFactory.getCurrentSession().saveOrUpdate(pogruzkaIM);
    }

    @Override
    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, Date date) {
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
}
