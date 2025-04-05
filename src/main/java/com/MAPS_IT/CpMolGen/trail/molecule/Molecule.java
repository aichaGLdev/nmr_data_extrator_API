package com.MAPS_IT.CpMolGen.trail.molecule;


import com.MAPS_IT.CpMolGen.trail.atoms.Atoms;
import com.MAPS_IT.CpMolGen.trail.corrilation.Corrilation;
import com.MAPS_IT.CpMolGen.trail.forbiddenFragments.ForbiddenFragments;
import com.MAPS_IT.CpMolGen.trail.imposedFragments.ImposedFragments;
import com.MAPS_IT.CpMolGen.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Molecule {

    @Id
    @GeneratedValue
    private Integer id;
    private  String Chimicalformula ;
    private  String Previousformula;
    private int NombreOfcorrelation;
    private int Result;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "molecule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Atoms> atoms;

     @OneToMany(mappedBy = "molecule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JsonManagedReference
    private List<Corrilation> corrilation;

     @OneToOne(mappedBy = "molecule")
     @JsonManagedReference
    private ImposedFragments imposedFragments;



    @OneToOne(mappedBy = "molecule")
    @JsonManagedReference
    private ForbiddenFragments forbiddenFragments;
  }