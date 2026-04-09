package org.example.cropinventoryservice.repository;

import org.example.cropinventoryservice.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
}

