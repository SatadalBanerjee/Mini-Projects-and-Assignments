package com.app.fir.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoliceStation {

    @Id
    private Integer policeStationId;
    private String stationCode;
    private String address;

    @OneToOne
    private Police officerInCharge;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Police> constables;
    
    @OneToMany(mappedBy = "policeStation")
    private List<FIR> firList;

}
