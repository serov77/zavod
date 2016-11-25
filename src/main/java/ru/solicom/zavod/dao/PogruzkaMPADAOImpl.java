package ru.solicom.zavod.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaMPA;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.List;

@Repository
public class PogruzkaMPADAOImpl implements PogruzkaMPADAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaMPA> pogruzkaMPAList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaMPA s where s.sertificatMPA.id <> :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaMPA> l = q.list();
        return l;
    }

    @Override
    public List<PogruzkaMPA> pogruzkaMPANaLiniiList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaMPA s where s.sertificatMPA.id = :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaMPA> l = q.list();
        return l;
    }

    @Override
    public void savePogruzkaMPA(PogruzkaMPA pogruzkaMPA) {
        sessionFactory.getCurrentSession().saveOrUpdate(pogruzkaMPA);
    }

    @Override
    public StatusVaiona searchPogruzkaMPAVagonaZaDen(Vagon vagon, LocalDate date) {
        PogruzkaMPA mpa = (PogruzkaMPA) sessionFactory.getCurrentSession().createCriteria(PogruzkaMPA.class).add(Restrictions.ne("sertificatMPA.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).add(Restrictions.eq("dataPogruzki", date)).uniqueResult();
        PogruzkaMPA mpa_2 = (PogruzkaMPA) sessionFactory.getCurrentSession().createCriteria(PogruzkaMPA.class).add(Restrictions.eq("sertificatMPA.id", 1)).add(Restrictions.eq("vagon.id", vagon.getId())).uniqueResult();
        if (mpa != null) {
            return StatusVaiona.PogSegodnyaMPA;
        } else if (mpa_2 != null) {
            return StatusVaiona.StoitNaLiniiMPA;
        }
        return StatusVaiona.OK;
    }

    @Override
    public Boolean searchPogruzkaMPAMKR(int id) {
        List<PogruzkaMPA> list = sessionFactory.getCurrentSession().createCriteria(PogruzkaMPA.class).add(Restrictions.eq("vagon.id", id)).add(Restrictions.eq("tara.id", 2)).list();
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<PogruzkaMPA> searchPogruzkaMPA(int id) {
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaMPA.class).add(Restrictions.eq("vagon.id", id)).list();
    }

    @Override
    public PogruzkaMPA retrivePogruzkaMPA(int id) {
        return (PogruzkaMPA) sessionFactory.getCurrentSession().createCriteria(PogruzkaMPA.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<PogruzkaMPA> searchPogruzkaMPABySertificat(int id) {
        LocalDate date = LocalDate.now();
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaMPA.class).add(Restrictions.lt("dataOtpravleniya", date)).add(Restrictions.eq("sertificatMPA.id", id)).list();
    }

    @Override
    public List<PogruzkaMPA> searchPogruzkaMPAMesyac(LocalDate x1, LocalDate x2) {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaMPA s where s.dataOtpravleniya >= :x1 and s.dataOtpravleniya<=:x2 and sertificatMPA.id>1 order by s.sertificatMPA.pokupatel.name");
        q.setParameter("x1", x1);
        q.setParameter("x2", x2);
        return q.list();
    }
}
