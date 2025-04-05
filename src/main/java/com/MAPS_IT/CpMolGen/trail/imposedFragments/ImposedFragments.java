package com.MAPS_IT.CpMolGen.trail.imposedFragments;


import com.MAPS_IT.CpMolGen.trail.molecule.Molecule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImposedFragments {

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
