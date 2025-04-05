package com.MAPS_IT.CpMolGen.trail.atoms;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtomsRepository extends JpaRepository<Atoms,Integer> {
    List<Atoms> findAllByMoleculeId(Long MoleculeId);
}
