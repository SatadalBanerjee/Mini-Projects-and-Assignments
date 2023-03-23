package com.app.fir.controller;


import com.app.fir.exceptions.PoliceStationException;
import com.app.fir.exceptions.UserException;
import com.app.fir.model.FIR;
import com.app.fir.service.FIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/FIR")
public class FIRController {

	
    @Autowired
    FIRService firService;

    @PostMapping("file")
    public ResponseEntity<FIR> fileFIR(@RequestParam String crimeDetail, @RequestParam LocalDateTime timeStamp, @RequestParam Integer applicantId, @RequestParam Integer criminalId, @RequestParam Integer officerId, @RequestParam Integer policeStationId) throws PoliceStationException, UserException {

        return new ResponseEntity<>(firService.fileFir(crimeDetail, timeStamp, applicantId, criminalId, officerId, policeStationId), HttpStatus.CREATED);

    }

}

