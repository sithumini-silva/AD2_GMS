package org.example.zonemanagementservice.repository;

import org.example.zonemanagementservice.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
