package com.MAPS_IT.CpMolGen.trail.atoms;


import com.MAPS_IT.CpMolGen.trail.molecule.Molecule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Atoms {
    @Id
    @GeneratedValue
    private  int id ;
    private  int index;
    private  String symbol;
    private  int multiplicity;
    private  int hybridization;
    private  float nmr_shift;
    //private  Long  batchId; // Identifiant global


     @ManyToOne
     @JoinColumn(name = "Molecule_Id")
     @JsonBackReference
     private Molecule molecule;
}
