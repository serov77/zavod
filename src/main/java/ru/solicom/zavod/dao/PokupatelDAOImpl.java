package ru.solicom.zavod.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.Pokupatel;

@Repository
public class PokupatelDAOImpl implements PokupatelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Pokupatel> pokupatelList() {
        return sessionFactory.getCurrentSession().createCriteria(Pokupatel.class).add(Restrictions.gt("id", 1)).addOrder(Order.asc("name")).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pokupatel> searchPokupatelList(String s) {
        String str = "%" + s + "%";
        return sessionFactory.getCurrentSession().createCriteria(Pokupatel.class).add(Restrictions.like("name", str)).addOrder(Order.desc("id")).list();
    }

    @Override
    public Boolean searchPokupatelByName(String name, int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Pokupatel where name = :name");
        q.setString("name", name);
        Pokupatel p = (Pokupatel) q.uniqueResult();
        if (p == null) {
            return true;
        } else if (p.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchPokupatelByKod(String kod, int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Pokupatel where kod = :kod");
        q.setString("kod", kod);
        Pokupatel p = (Pokupatel) q.uniqueResult();
        if (p == null) {
            return true;
        } else if (p.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchRokupatelByOKPO(String okpo, int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Pokupatel where okpo = :okpo");
        q.setString("okpo", okpo);
        Pokupatel p = (Pokupatel) q.uniqueResult();
        if (p == null) {
            return true;
        } else if (p.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public void savePokupatel(Pokupatel pokupatel) {
        sessionFactory.getCurrentSession().saveOrUpdate(pokupatel);
    }

    @Override
    public Pokupatel retrivePokupatel(int id) {
        return (Pokupatel) sessionFactory.getCurrentSession().createCriteria(Pokupatel.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

}
