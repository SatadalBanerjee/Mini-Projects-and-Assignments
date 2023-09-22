package com.ambula.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;
import com.ambula.repo.UserLocationRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private UserLocationRepo ulRepo;
	
	@Override
	public UserLocation create_data(UserLocation u) throws UserLocationException {
		// TODO Auto-generated method stub
		
		// u  is the details of a user and it directly saved with help of pre built JPA method .save.
		UserLocation ul= ulRepo.save(u);
		
		return ul;
	}

	@Override
	public UserLocation uddate_data(UserLocation u) throws UserLocationException {
		// TODO Auto-generated method stub
		
		//Optional is used as there might be a user or might not be
		Optional<UserLocation> opt = ulRepo.findById(u.getId());
		
		if(opt.isPresent()) {
			return ulRepo.save(u);
		}
		else {
			throw new UserLocationException("There's no data present");
		}
	}

}
