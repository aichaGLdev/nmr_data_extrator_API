package com.MAPS_IT.CpMolGen.Trail_Management;


import com.MAPS_IT.CpMolGen.trail.atoms.Atoms;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class resuestBody {
    @Valid
    private Atoms[] atoms;
    //private Long  batchId; // Identifiant unique pour le tableau
}


