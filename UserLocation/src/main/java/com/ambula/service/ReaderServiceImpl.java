package com.ambula.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;
import com.ambula.repo.UserLocationRepo;

@Service
public class ReaderServiceImpl implements ReaderService{

	@Autowired
	private UserLocationRepo ulRepo;
	
	@Override
	public List<UserLocation> get_users(Integer n) throws UserLocationException {
		// TODO Auto-generated method stub
		List<UserLocation> allUsers = ulRepo.findAll();

        //users are sorted based on their distance from (0,0)
        List<UserLocation> nearByUser = allUsers.stream() 
                .sorted(Comparator.comparingDouble(user -> calculatingDistance(user.getLatitude(), user.getLongitude(), 0, 0)))
                .limit(n)
                .collect(Collectors.toList());

        return nearByUser;
	}

	private double calculatingDistance(double lat1,double lon1,double lat2,double lon2) {
        
        double radius = 6371;

        // Latitude and longitude are converted to radians for the comparison. 
        double la1 = Math.toRadians(lat1);
        double lo1 = Math.toRadians(lon1);
        double la2 = Math.toRadians(lat2);
        double lo2 = Math.toRadians(lon2);

        // The difference between the coordinates are counted
        double latitudeDiff = la2 - la1;
        double longituteDiff = lo2 - lo1;

        // Haversine formula is used to calculate the distance
        double a = Math.sin(latitudeDiff/2) * Math.sin(latitudeDiff/2) +Math.cos(latitudeDiff) * Math.cos(latitudeDiff) * Math.sin(longituteDiff/2) * Math.sin(longituteDiff/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return radius * c;
    }

}
