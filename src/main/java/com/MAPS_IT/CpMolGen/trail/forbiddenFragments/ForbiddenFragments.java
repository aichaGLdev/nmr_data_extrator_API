package com.MAPS_IT.CpMolGen.trail.forbiddenFragments;

import com.MAPS_IT.CpMolGen.trail.molecule.Molecule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForbiddenFragments {
    @Id
    @GeneratedValue
    private  int id;
    private boolean  threecycle;
    private boolean  fourcycle;
    private boolean  fivecycle;
    private boolean  sixcycle;


    @OneToOne
    @JoinColumn(name = "Molecule_Id")
    @JsonBackReference
    private Molecule molecule;

}
