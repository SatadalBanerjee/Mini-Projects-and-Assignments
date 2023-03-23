package com.app.fir.service;

import com.app.fir.exceptions.PoliceStationException;
import com.app.fir.exceptions.UserException;
import com.app.fir.model.FIR;
import com.app.fir.model.Police;
import com.app.fir.model.PoliceStation;
import com.app.fir.model.User;
import com.app.fir.repository.FIRRepo;
import com.app.fir.repository.PoliceRepo;
import com.app.fir.repository.PoliceStationRepo;
import com.app.fir.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class FIRServiceImpl implements FIRService {

	 @Autowired
	 private PoliceRepo policeRepo;

	@Autowired
	private PoliceStationRepo policeStationRepo;

    @Autowired
    private FIRRepo firRepository;

    @Autowired
    private UserRepo userRepository;

    @Override
    public FIR fileFir(String crimeDetail, LocalDateTime timeStamp, Integer applicantId, Integer criminalIds, Integer officerId, Integer policeStationId) throws UserException, PoliceStationException {

        User applicant = userRepository.findById(applicantId).orElseThrow(() -> new UserException("User with id " + applicantId + "was not found"));

        Optional<User> criminals = userRepository.findById(criminalIds);

        Police officer = policeRepo.findById(officerId).orElseThrow(() -> new UserException("User with id " + officerId + "was not found"));

        PoliceStation policeStation = policeStationRepo.findById(policeStationId)
                .orElseThrow(() -> new PoliceStationException("Police station with id " + policeStationId + "was  not found"));

        FIR fir = new FIR();
        
        fir.setCrimeDetail(crimeDetail);
        fir.setTimeStamp(timeStamp);
        fir.setApplicant(applicant);
        
        fir.setCriminals((Set<User>) criminals.get());
        fir.setOfficer(officer);
        
        fir.setPoliceStation(policeStation);
        fir.setOpen(true);

        return firRepository.save(fir);

    }

}
