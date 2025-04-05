package com.MAPS_IT.CpMolGen.Trail_Management;


import com.MAPS_IT.CpMolGen.auth.AuthenticationRequest;
import com.MAPS_IT.CpMolGen.auth.AuthenticationResponse;
import com.MAPS_IT.CpMolGen.trail.atoms.Atoms;
import com.MAPS_IT.CpMolGen.trail.corrilation.Corrilation;
import com.MAPS_IT.CpMolGen.trail.forbiddenFragments.ForbiddenFragments;
import com.MAPS_IT.CpMolGen.trail.imposedFragments.ImposedFragments;
import com.MAPS_IT.CpMolGen.trail.molecule.Molecule;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("trail")
@RequiredArgsConstructor
public class TrailController {

    private final TrailService trailService ;
    //FormuleChimicMangment




   //AtomsMangment
    @PostMapping("/saveAtoms/{MoleculeId}")
    public void saveAtoms(
            @RequestBody @Valid  resuestBody resuestbody , @PathVariable int MoleculeId ){
      trailService.saveAtoms(resuestbody, MoleculeId);
    }

    @GetMapping("/GetAtoms/{MoleculeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Atoms> GetAtoms(
            @PathVariable long MoleculeId
    )throws MessagingException{
        return trailService.getAtoms(MoleculeId);
    }



    //corrilation Mangment
    @PostMapping("/saveCorrilation/{MoleculeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> saveCorrilation(
            @RequestBody @Valid  requestBodyCorrilation requestbodycorrilation , @PathVariable int MoleculeId ) throws MessagingException{
        trailService.saveCorrilation(requestbodycorrilation, MoleculeId );
        return ResponseEntity.accepted().build();

    }
    @GetMapping("/GetCorrilation/{MoleculeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Corrilation GetCorrilation(
            @PathVariable long MoleculeId
    )throws MessagingException{
        return trailService.GetCorrilation( MoleculeId);
    }

 //MoleculMangment

    @GetMapping("/FindMoleculeById/{chimiqueId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Molecule GetMolecule(@PathVariable int chimiqueId)throws MessagingException {
        return trailService.GetMolecule(chimiqueId);
    }

    @PostMapping("/saveMolecule/{id}")
    public ResponseEntity<saveMoleculeResponce> saveMolecule(
            @RequestBody @Valid MoleculeRequestBody moleculeRequestBody , @PathVariable int id  ){
        return ResponseEntity.ok(trailService.saveMolecule(moleculeRequestBody ,id));
    }



    @GetMapping("GetAllMolecule")
    public List<Molecule> GetAllMolecule(){
        return trailService.GetAllMolecule();
    }

    @DeleteMapping("deleteById/{id}")
    public void DeleteMolecule(@PathVariable Integer id){

        trailService.DeleteMolecule(id);
    }


    //ImposedFragments
    @PostMapping("/saveImposedFragments/{id}")
    public void saveImposedFragments(
            @RequestBody @Valid ImposedFragments imposedFragments , @PathVariable int id  ){
        trailService.saveImposedFragments(imposedFragments ,id);
    }

    //ForbiddenFragments
    @PostMapping("/saveForbiddenFragments/{id}")
    public void ForbiddenFragments(
            @RequestBody @Valid ForbiddenFragments forbiddenFragments , @PathVariable int id  ){
        trailService.saveForbiddenFragments(forbiddenFragments ,id);
    }


}






