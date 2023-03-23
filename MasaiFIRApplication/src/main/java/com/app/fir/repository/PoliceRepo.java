package com.app.fir.repository;

import com.app.fir.model.Police;
import com.app.fir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliceRepo extends JpaRepository<Police, Integer> {

    public Police findByMobileNo(String mobileNo);

}
