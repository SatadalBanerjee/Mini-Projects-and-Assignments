package com.app.fir.repository;

import com.app.fir.model.FIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FIRRepo extends JpaRepository<FIR, Integer> {
}
