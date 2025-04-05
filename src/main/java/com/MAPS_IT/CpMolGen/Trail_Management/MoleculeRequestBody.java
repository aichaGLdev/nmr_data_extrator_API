package com.MAPS_IT.CpMolGen.Trail_Management;

import jakarta.validation.Valid;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoleculeRequestBody {

    @Valid
    private  int id;
    private  String Chimicalformula ;
    private  String Previousformula;
    private  int NombreOfcorrelation;
    private  int Result;
}
