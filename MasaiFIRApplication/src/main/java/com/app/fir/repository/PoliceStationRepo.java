package com.app.fir.repository;

import com.app.fir.model.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceStationRepo extends JpaRepository<PoliceStation, Integer> {

    public PoliceStation findByStationCode( String stationCode);
}
