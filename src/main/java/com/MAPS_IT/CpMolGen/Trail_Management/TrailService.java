package com.MAPS_IT.CpMolGen.Trail_Management;


import com.MAPS_IT.CpMolGen.trail.atoms.Atoms;
import com.MAPS_IT.CpMolGen.trail.atoms.AtomsRepository;
import com.MAPS_IT.CpMolGen.role.RoleRepository;
import com.MAPS_IT.CpMolGen.trail.corrilation.Corrilation;
import com.MAPS_IT.CpMolGen.trail.corrilation.CorrilationRepository;
import com.MAPS_IT.CpMolGen.trail.forbiddenFragments.ForbiddenFragments;
import com.MAPS_IT.CpMolGen.trail.forbiddenFragments.ForbiddenFragmentsRepository;
import com.MAPS_IT.CpMolGen.trail.imposedFragments.ImposedFragments;
import com.MAPS_IT.CpMolGen.trail.imposedFragments.ImposedFragmentsRepository;
import com.MAPS_IT.CpMolGen.trail.molecule.Molecule;
import com.MAPS_IT.CpMolGen.trail.molecule.MoleculeRepository;
import com.MAPS_IT.CpMolGen.user.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrailService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AtomsRepository atomsRepository;
    private final CorrilationRepository corrilationrepository;
    private final MoleculeRepository moleculerepository;
    private final ImposedFragmentsRepository imposedFragmentsRepository;
    private final ForbiddenFragmentsRepository forbiddenFragmentsRepository;
    public void saveAtoms(resuestBody resuestbody ,int chimiqueId) {
        //var userRole = roleRepository.findByName("USER")
        // todo - better exception handling
        //.orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));

        var Molecule = moleculerepository.findById(chimiqueId)
                // todo - better exception handling
                .orElseThrow(() -> new IllegalStateException("Molecule was not initiated"));

        //Long batchId = resuestbody.getBatchId();
        for (int i = 0; i < resuestbody.getAtoms().length; i++) {
            var Res = Atoms.builder()
                    .index(resuestbody.getAtoms()[i].getIndex())
                    .hybridization(resuestbody.getAtoms()[i].getHybridization())
                    .multiplicity(resuestbody.getAtoms()[i].getMultiplicity())
                    .nmr_shift(resuestbody.getAtoms()[i].getNmr_shift())
                    .symbol(resuestbody.getAtoms()[i].getSymbol())
                    //.batchId(resuestbody.getBatchId())
                    .molecule(Molecule)
                    .build();
            atomsRepository.save(Res);
        }
    }

    public List<Atoms> getAtoms(long MoleculeId) {
        return atomsRepository.findAllByMoleculeId(MoleculeId);
    }




    //corrilation Mangment
    public void saveCorrilation(requestBodyCorrilation requestbodycorrilation,int chimiqueId) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                // todo - better exception handling
                .orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));

        var Molecule = moleculerepository.findById(chimiqueId)
                // todo - better exception handling
                .orElseThrow(() -> new IllegalStateException("Molecule was not initiated"));

        for( int i = 0 ; i< requestbodycorrilation.getCorrilation().length ;i++){
            var Cf = Corrilation.builder()
                    .atomSet1(requestbodycorrilation.getCorrilation()[i].getAtomSet1())
                    .atomSet2(requestbodycorrilation.getCorrilation()[i].getAtomSet2())
                    .correlationType(requestbodycorrilation.getCorrilation()[i].getCorrelationType())
                    .molecule(Molecule)
                    .build();
            corrilationrepository.save(Cf);
        }
        }

    public Corrilation GetCorrilation(long id) {
        return corrilationrepository.findById(id).orElse(null);
    }

    //MoleculMangment

    public saveMoleculeResponce saveMolecule(MoleculeRequestBody moleculeRequestBody ,int id){
        var user = userRepository.findById(id)
                // todo - better exception handling
                .orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));

        var saveMolecule =  Molecule.builder()
                   .Chimicalformula(moleculeRequestBody.getChimicalformula())
                   .Previousformula(moleculeRequestBody.getPreviousformula())
                   .Result(moleculeRequestBody.getResult())
                   .NombreOfcorrelation(moleculeRequestBody.getNombreOfcorrelation())
                   .user(user)
                   .build();
      Molecule  savedEntity = moleculerepository.save(saveMolecule);
            return new saveMoleculeResponce(savedEntity.getId());
    }
    public List<Molecule> GetAllMolecule(){
        return moleculerepository.findAll();
    }
    public Molecule GetMolecule(int chimiqueId) {
        return moleculerepository.findById(chimiqueId).orElse(null);
    }

    public void DeleteMolecule(Integer chimiqueId){
        moleculerepository.deleteById(chimiqueId);
    }

   //ImposedFragments
   public void saveImposedFragments(ImposedFragments imposedFragments ,int id){
       var Molecule = moleculerepository.findById(id)
               // todo - better exception handling
               .orElseThrow(() -> new IllegalStateException("Molecule was not initiated"));

       var saveImposedFragments =  ImposedFragments.builder()
               .threecycle(imposedFragments.isThreecycle())
               .fourcycle(imposedFragments.isFourcycle())
               .fivecycle(imposedFragments.isFivecycle())
               .sixcycle(imposedFragments.isSixcycle())
               .molecule(Molecule)
               .build();
       imposedFragmentsRepository.save(saveImposedFragments);
   }
   //ForbiddenFragments
   public void saveForbiddenFragments(ForbiddenFragments forbiddenFragments , int id){
       var Molecule = moleculerepository.findById(id)
               // todo - better exception handling
               .orElseThrow(() -> new IllegalStateException("Molecule was not initiated"));

       var saveForbiddenFragments =  ForbiddenFragments.builder()
               .threecycle(forbiddenFragments.isThreecycle())
               .fourcycle(forbiddenFragments.isFourcycle())
               .fivecycle(forbiddenFragments.isFivecycle())
               .sixcycle(forbiddenFragments.isSixcycle())
               .molecule(Molecule)
               .build();
       forbiddenFragmentsRepository.save(saveForbiddenFragments);
   }
}
