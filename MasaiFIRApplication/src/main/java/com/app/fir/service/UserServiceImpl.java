package com.app.fir.service;

import com.app.fir.exceptions.PoliceException;
import com.app.fir.exceptions.PoliceStationException;
import com.app.fir.exceptions.UserException;
import com.app.fir.model.FIR;
import com.app.fir.model.Police;
import com.app.fir.model.PoliceStation;
import com.app.fir.model.User;
import com.app.fir.repository.PoliceRepo;
import com.app.fir.repository.PoliceStationRepo;
import com.app.fir.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PoliceRepo policeRepository;

    @Autowired
    private PoliceStationRepo policeStationRepository;

    @Override
    public User registerUser(User user) throws UserException {

        List<User> existingUser = userRepository.findUserByMobileNumber(user.getMobileNumber());
        
        if ( existingUser != null ) {
        	
            throw new UserException("User with mobile number " + user.getMobileNumber() + " already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public Police registerPolice(Police police) throws PoliceException {

        Police existingPolice = policeRepository.findByMobileNo(police.getMobileNo());

        if (existingPolice != null) {
        	
            throw new PoliceException("Police with mobile number " + police.getMobileNo() + " already exists");
        }

        return policeRepository.save(police);
    }


    @Override
    public PoliceStation registerPoliceStation(PoliceStation policeStation) throws PoliceStationException {

        PoliceStation existingPoliceStation = policeStationRepository.findByStationCode(policeStation.getStationCode());
        
        if (existingPoliceStation != null) {
        	
            throw new PoliceStationException("Police station with station code " + policeStation.getStationCode() + " already exists");
        }

        return policeStationRepository.save(policeStation);
    }



    @Override
    public FIR getOldestOpenFirByPoliceStation(Integer policeStationId) {

        Optional<PoliceStation> policeStation = policeStationRepository.findById(policeStationId);
// Optional<PoliceStation> policeStation = policeStationRepository.();
        List<FIR> firList = policeStation.get().getFirList();

        FIR oldestOpenFir = null;

        LocalDateTime oldestTime = LocalDateTime.now();

        for (FIR fir : firList) {
        	
            if (fir.isOpen() && fir.getTimeStamp().isBefore(oldestTime)) {
            	// oldestTime = fir.getTimeStamp();
                oldestTime = fir.getTimeStamp();
                oldestOpenFir = fir;
            }
        }

        return oldestOpenFir;
    }


}
