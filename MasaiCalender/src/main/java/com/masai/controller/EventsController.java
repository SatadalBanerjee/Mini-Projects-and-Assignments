package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CurrentUserException;
import com.masai.exception.EventsException;
import com.masai.model.Events;
import com.masai.service.EventsService;

@RestController
public class EventsController {
	
	@Autowired
	private EventsService eventsService;
	
	
	@PostMapping("/addEvents/{uuid}")
	public ResponseEntity<Events> addEvents(@RequestBody Events events, @PathVariable ("uuid") String uuid) throws EventsException, CurrentUserException{
		
		Events se = this.eventsService.addEvents(events, uuid);
		
		return new ResponseEntity<Events>(se,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PutMapping("/updateEvents/{uuid}")
	public ResponseEntity<Events> updateEvents(@RequestBody Events events, @PathVariable ("uuid") String uuid) throws EventsException, CurrentUserException{
		
		Events se = this.eventsService.updateEvents(events, uuid);
		
		return new ResponseEntity<Events>(se,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/deleteEvents/{uuid}")
	public ResponseEntity<Events> deleteEvents(@RequestBody Integer id, @PathVariable ("uuid") String uuid) throws EventsException, CurrentUserException{
		
		Events se = this.eventsService.deleteEvents(id, uuid);
		
		return new ResponseEntity<Events>(se,HttpStatus.ACCEPTED);
		
	}


	
}
