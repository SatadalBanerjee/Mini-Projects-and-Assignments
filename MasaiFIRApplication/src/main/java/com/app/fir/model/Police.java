package com.app.fir.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Police {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policeId;
    private String officerName;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$")
    private String mobileNo;

    private String department;

    @OneToMany(mappedBy = "officer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FIR> firsFiled = new ArrayList<>();

    @OneToMany(mappedBy = "officer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FIR> casesClosed = new ArrayList<>();

}
