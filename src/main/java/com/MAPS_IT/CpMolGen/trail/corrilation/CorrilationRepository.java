package com.MAPS_IT.CpMolGen.trail.corrilation;

import com.MAPS_IT.CpMolGen.trail.atoms.Atoms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrilationRepository  extends JpaRepository<Corrilation,Long> {

    //List<Corrilation> findAllByBatchId(Long batchId);
}
