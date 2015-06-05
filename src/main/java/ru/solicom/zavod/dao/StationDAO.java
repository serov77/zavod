package ru.solicom.zavod.dao;

import java.util.List;
import ru.solicom.zavod.domain.Station;

public interface StationDAO {

    public List<Station> stationList();

    public Station retriveStation(int id);

    public void saveStation(Station station);

    public Boolean searchStationByName(String name, int id);

    public Boolean searchStationByKod(String kod, int id);

    public List<Station> searchStationList(String s);
}
