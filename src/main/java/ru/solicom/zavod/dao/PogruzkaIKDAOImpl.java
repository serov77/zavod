package ru.solicom.zavod.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.text.ParseException;
import java.util.List;

@Repository
public class PogruzkaIKDAOImpl implements PogruzkaIKDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PogruzkaIK> pogruzkaIKList() {

        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIK s where s.sertificatIK.id <> :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaIK> l = q.list();
        return l;
    }

    @Override
    public List<PogruzkaIK> pogruzkaIKNaLiniiList() {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIK s where s.sertificatIK.id = :id order by id asc");
        q.setInteger("id", 1);
        List<PogruzkaIK> l = q.list();
        return l;
    }

    @Override
    public void savePogruzkaIK(PogruzkaIK pogruzkaIK) {
        sessionFactory.getCurrentSession().saveOrUpdate(pogruzkaIK);
    }

    @Override
    public StatusVaiona searchPogruzkaIKVagonaZaDen(Vagon vagon, LocalDate date) throws ParseException {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //Date date = format.parse(date1.toString());
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
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIK s where s.id = :id");
        q.setInteger("id", id);
        return (PogruzkaIK) q.uniqueResult();
        // PogruzkaIK pogruzkaIK = (PogruzkaIK)sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.eq("id", id)).uniqueResult();
        // return pogruzkaIK;
    }

    @Override
    public List<PogruzkaIK> searchPogruzkaIKBySertificat(int id) {
        LocalDate date = LocalDate.now();
        return sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.lt("dataOtpravleniya", date)).add(Restrictions.eq("sertificatIK.id", id)).list();
    }

    @Override
    public List<PogruzkaIK> searchPogruzkaIKMesyac(LocalDate x1, LocalDate x2) {
        Query q = sessionFactory.getCurrentSession().createQuery("from PogruzkaIK s where s.dataOtpravleniya >= :x1 and s.dataOtpravleniya<=:x2 and sertificatIK.id>1 order by s.sertificatIK.pokupatel.name");
        q.setParameter("x1", x1);
        q.setParameter("x2", x2);
        return q.list();


        //return sessionFactory.getCurrentSession().createCriteria(PogruzkaIK.class).add(Restrictions.ge("dataOtpravleniya", x1)).add(Restrictions.le("dataOtpravleniya", x2)).list();
    }

}
