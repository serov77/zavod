package ru.solicom.zavod.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.RodVagona;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.RodVagonaService;

@Repository
public class VagonDAOImpl implements VagonDAO {

    @Autowired
    private RodVagonaService rodVagonaService;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Vagon> vagonList() {
        return sessionFactory.getCurrentSession().createCriteria(Vagon.class).addOrder(Order.desc("id")).list();
    }

    @Override
    public Vagon retriveVagon(int id) {
        return (Vagon) sessionFactory.getCurrentSession().createCriteria(Vagon.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void saveVagon(Vagon vagon) {
        RodVagona rodVagona = rodVagonaService.retriveRodVagona(vagon.getRodVagona().getId());
        vagon.setRodVagona(rodVagona);
        sessionFactory.getCurrentSession().saveOrUpdate(vagon);
    }

    @Override
    public List<Vagon> searchVagonList(String s) {
        String str = "%" + s + "%";
        return sessionFactory.getCurrentSession().createCriteria(Vagon.class).add(Restrictions.like("nomerVagona", str)).addOrder(Order.desc("id")).list();
    }

    @Override
    public Boolean searchVagonByNomerVagona(String nomer, int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Vagon where nomerVagona = :nomer");
        q.setString("nomer", nomer);
        Vagon v = (Vagon) q.uniqueResult();
        if (v == null) {
            return true;
        } else if (v.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public int[] kolichectvoVagonov() {
        int[] kolicestvo = new int[4];
        //kolicestvo[3] = 0;
        for (int i = 1; i < 4; i++) {
            Query q = sessionFactory.getCurrentSession().createQuery("from Vagon where rodVagona.id = :nomer");
            q.setInteger("nomer", i);
            kolicestvo[i-1] = q.list().size();
            kolicestvo[3] = kolicestvo[3] + kolicestvo[i-1];
        }
        return kolicestvo;
    }

}
