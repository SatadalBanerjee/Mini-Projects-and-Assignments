package com.app.fir.service;

import com.app.fir.exceptions.PoliceStationException;
import com.app.fir.exceptions.UserException;
import com.app.fir.model.FIR;

import java.time.LocalDateTime;

public interface FIRService {

    FIR fileFir(String crimeDetail, LocalDateTime timeStamp, Integer applicantId, Integer criminalIds, Integer officerId, Integer policeStationId) throws UserException, PoliceStationException;

}
