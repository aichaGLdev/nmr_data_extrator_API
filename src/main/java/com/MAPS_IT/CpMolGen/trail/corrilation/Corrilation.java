package com.MAPS_IT.CpMolGen.trail.corrilation;


import com.MAPS_IT.CpMolGen.trail.molecule.Molecule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Corrilation {
    @Id
    @GeneratedValue
    private int id;
    private int atomSet1;
    private int atomSet2;
    private String correlationType;


    @ManyToOne
    @JoinColumn(name = "Molecule_Id")
    @JsonBackReference
    private Molecule molecule ;

}
