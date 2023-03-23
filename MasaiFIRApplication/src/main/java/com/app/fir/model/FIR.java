package com.app.fir.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FIR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer firId;

    private String crimeDetail;
    private LocalDateTime timeStamp;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "fir_criminals",
            joinColumns = @JoinColumn(name = "fir_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    		private Set<User> criminals = new HashSet<>();

    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "police_id")
    private Police officer;

    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "police_station_id")
    private PoliceStation policeStation;

    private boolean isOpen;

}
