package com.ambula.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserLocation {

//	Unique Id will assigned to each user
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
//	Name of the user 
    private String name;
    
//    Location latitude of the user
    private double latitude;
    
//  Location longitude of the user
    private double longitude;
}
