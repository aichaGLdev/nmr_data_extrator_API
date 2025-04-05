package com.MAPS_IT.CpMolGen.Trail_Management;

import com.MAPS_IT.CpMolGen.trail.atoms.Atoms;
import com.MAPS_IT.CpMolGen.trail.corrilation.Corrilation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class requestBodyCorrilation {

    @Valid
    //private  int batchId ;
    private Corrilation[] corrilation;

}
