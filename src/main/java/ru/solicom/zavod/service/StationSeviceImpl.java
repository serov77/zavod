package ru.solicom.zavod.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.StationDAO;
import ru.solicom.zavod.domain.Station;

@Service
@Transactional
public class StationSeviceImpl implements StationService {

    @Autowired
    public StationDAO stationDAO;

    @Override
    public List<Station> stationList() {
        return stationDAO.stationList();
    }

    @Override
    public Station retriveStation(int id) {
        return stationDAO.retriveStation(id);
    }

    @Override
    public void saveStation(Station station) {
        stationDAO.saveStation(station);
    }

    @Override
    public Boolean searchStationByName(String name, int id) {
        return stationDAO.searchStationByName(name, id);
    }

    @Override
    public Boolean searchStationByKod(String kod, int id) {
        return stationDAO.searchStationByKod(kod, id);
    }

    @Override
    public List<Station> searchStationList(String s) {
        return stationDAO.searchStationList(s);
    }

}
