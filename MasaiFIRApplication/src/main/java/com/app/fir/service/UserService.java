package com.app.fir.service;

import com.app.fir.exceptions.PoliceException;
import com.app.fir.exceptions.PoliceStationException;
import com.app.fir.exceptions.UserException;
import com.app.fir.model.FIR;
import com.app.fir.model.Police;
import com.app.fir.model.PoliceStation;
import com.app.fir.model.User;

public interface UserService {

    User registerUser(User user) throws UserException;
    Police registerPolice(Police police) throws PoliceException;
    PoliceStation registerPoliceStation(PoliceStation policeStation) throws PoliceStationException;
    FIR getOldestOpenFirByPoliceStation(Integer policeStationId);
}
