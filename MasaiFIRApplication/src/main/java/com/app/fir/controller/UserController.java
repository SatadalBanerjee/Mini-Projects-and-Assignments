package com.app.fir.controller;

import com.app.fir.exceptions.LoginException;
import com.app.fir.exceptions.PoliceException;
import com.app.fir.exceptions.PoliceStationException;
import com.app.fir.exceptions.UserException;
import com.app.fir.model.*;
import com.app.fir.service.LoginService;
import com.app.fir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> loginMapping(@RequestBody UserLogin userLogin) throws LoginException {

        String output = loginService.login(userLogin);

        return new ResponseEntity<String>(output, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutMapping(@RequestParam String key) throws LoginException{

        String output = loginService.logout(key);

        return new ResponseEntity<String>(output,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException {

            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);

    }
    
    @GetMapping("/older")
    public ResponseEntity<FIR> getOldestOpenFirByPoliceStation(@RequestParam Integer policeStationId){

            return new ResponseEntity<>(userService.getOldestOpenFirByPoliceStation(policeStationId), HttpStatus.OK);

    }

    
    @PostMapping("/register/policestation")
    public ResponseEntity<?> registerPoliceStation(@RequestBody PoliceStation police) throws UserException, PoliceStationException {

            return new ResponseEntity<>(userService.registerPoliceStation(police), HttpStatus.CREATED);

    }

    @PostMapping("/register/police")
    public ResponseEntity<Police> registerPolice(@RequestBody Police police) throws UserException, PoliceException {

            return new ResponseEntity<>(userService.registerPolice(police), HttpStatus.CREATED);

    }

}
