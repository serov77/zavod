package ru.solicom.zavod.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.solicom.zavod.domain.Station;

@Repository
public class StationDAOImpl implements StationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Station> stationList() {
        return sessionFactory.getCurrentSession().createCriteria(Station.class).add(Restrictions.gt("id", 1)).addOrder(Order.asc("name")).list();
    }

    @Override
    public Station retriveStation(int id) {
        return (Station) sessionFactory.getCurrentSession().createCriteria(Station.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void saveStation(Station station) {
        sessionFactory.getCurrentSession().saveOrUpdate(station);
    }

    @Override
    public Boolean searchStationByName(String name, int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Station where name = :name");
        q.setString("name", name);
        Station s = (Station) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchStationByKod(String kod, int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Station where kod = :kod");
        q.setString("kod", kod);
        Station s = (Station) q.uniqueResult();
        if (s == null) {
            return true;
        } else if (s.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public List<Station> searchStationList(String s) {
        String str = "%" + s + "%";
        return sessionFactory.getCurrentSession().createCriteria(Station.class).add(Restrictions.like("name", str)).addOrder(Order.desc("id")).list();
    }

}
