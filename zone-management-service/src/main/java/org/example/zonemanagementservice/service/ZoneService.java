package org.example.zonemanagementservice.service;

import org.example.zonemanagementservice.dto.ZoneDTO;
import org.example.zonemanagementservice.model.Zone;

import java.util.List;

public interface ZoneService {
    ZoneDTO createZone(ZoneDTO zoneDTO);
    List<Zone> getAllZones();
    Zone getZoneById(Long id);
    Zone updateZone(Long id, ZoneDTO dto);
    void deleteZone(Long id);
}