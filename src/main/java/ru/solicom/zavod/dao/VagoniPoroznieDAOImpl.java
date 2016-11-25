package ru.solicom.zavod.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;

import java.util.List;

@Repository
public class VagoniPoroznieDAOImpl implements VagoniPoroznieDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<VagoniPoroznie> vagoniPoroznieList() {
        return sessionFactory.getCurrentSession().createCriteria(VagoniPoroznie.class).add(Restrictions.eq("pogruzen", false)).addOrder(Order.desc("nomerSvidetelstva")).list();
    }

    @Override
    public List<VagoniPoroznie> vagoniPoroznieIzvestList() {
        return sessionFactory.getCurrentSession().createCriteria(VagoniPoroznie.class).add(Restrictions.eq("pogruzen", false)).add(Restrictions.lt("gruz.id", 3)).addOrder(Order.desc("nomerSvidetelstva")).list();
    }

    @Override
    public List<VagoniPoroznie> vagoniPoroznieListZayavka(LocalDate date) {
        return sessionFactory.getCurrentSession().createCriteria(VagoniPoroznie.class).add(Restrictions.eq("dataPribitiya", date)).add(Restrictions.lt("gruz.id", 3)).addOrder(Order.desc("nomerSvidetelstva")).list();

    }

    @Override
    public void saveVagonPorozniy(VagoniPoroznie vagoniPoroznie) {
        sessionFactory.getCurrentSession().saveOrUpdate(vagoniPoroznie);
    }

    @Override
    public int maxNomerSvidetelstva() {
        int i = (int) sessionFactory.getCurrentSession().createCriteria(VagoniPoroznie.class).add(Restrictions.lt("gruz.id", 3)).setProjection(Projections.max("id")).uniqueResult();
        int j = ((VagoniPoroznie)sessionFactory.getCurrentSession().createCriteria(VagoniPoroznie.class).add(Restrictions.eq("id",i)).uniqueResult()).getNomerSvidetelstva();
        return j;
    }

    @Override
    public Boolean statusPoroznegoVagona(Vagon vagon) {
        List<VagoniPoroznie> list = sessionFactory.getCurrentSession().createCriteria(VagoniPoroznie.class).add(Restrictions.eq("vagon.id", vagon.getId())).add(Restrictions.eq("pogruzen", false)).list();
        Boolean x = false;
        if (list.isEmpty()) {
            x = true;
        }
        return x;
    }

    @Override
    public VagoniPoroznie retriveVagonPorozniy(int id) {
        return (VagoniPoroznie) sessionFactory.getCurrentSession().createCriteria(VagoniPoroznie.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void otmetkaPogruzen(VagoniPoroznie vagon) {
        vagon.setPogruzen(true);
        sessionFactory.getCurrentSession().saveOrUpdate(vagon);
    }

    @Override
    public void deleteOtmetkaPogruzen(VagoniPoroznie vagon) {
        vagon.setPogruzen(false);
        vagon.setDataPogruzki(null);
        sessionFactory.getCurrentSession().saveOrUpdate(vagon);
    }
}
