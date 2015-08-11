package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Repository
public class PogruzkaIKDAOImpl implements PogruzkaIKDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaIK> pogruzkaIKList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.ne("sertificatIK.id", 1)).addOrder(Order.asc("id")).list();
    }

    @Override
    public List<PogruzkaIK> pogruzkaIKNaLiniiList() {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.eq("sertificatIK.id", 1)).addOrder(Order.asc("id")).list();
    }

    @Override
    public void savePogruzkaIK(PogruzkaIK pogruzkaIK) {
        sessionFactory.getCurrentSession().saveOrUpdate(pogruzkaIK);
    }

    @Override
    public StatusVaiona searchPogruzkaIKVagonaZaDen(Vagon vagon, Date date) {
        PogruzkaIK ik = (PogruzkaIK) sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.ne("sertificatIK.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).add(Restrictions.eq("dataPogruzki", date)).uniqueResult();
        PogruzkaIK ik_2 = (PogruzkaIK) sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.eq("sertificatIK.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).uniqueResult();
        if (ik != null) {
            return StatusVaiona.PogSegodnyaIK;
        } else if (ik_2 != null) {
            return StatusVaiona.StoitNaLiniiIK;
        }
        return StatusVaiona.OK;
    }

    @Override
    public Boolean searchPogruzkaIKMKR(int id) {
        List<PogruzkaIK> list = sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.eq("vagon.id", id)).add(Restrictions.eq("tara.id", 2)).list();
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<PogruzkaIK> searchPogruzkaIK(int id) {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.eq("vagon.id", id)).list();
    }

    @Override
    public PogruzkaIK retrivePogruzkaIK(int id) {
        return (PogruzkaIK)sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

}
