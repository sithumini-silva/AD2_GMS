package org.example.zonemanagementservice.service.impl;

import org.example.zonemanagementservice.client.SensorTelemetryClient;
import org.example.zonemanagementservice.dto.ZoneDTO;
import org.example.zonemanagementservice.model.Zone;
import org.example.zonemanagementservice.repository.ZoneRepository;
import org.example.zonemanagementservice.service.ZoneService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;
    private final SensorTelemetryClient sensorTelemetryClient;

    public ZoneServiceImpl(ZoneRepository zoneRepository,
                           SensorTelemetryClient sensorTelemetryClient) {
        this.zoneRepository = zoneRepository;
        this.sensorTelemetryClient = sensorTelemetryClient;
    }



    @Override
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone getZoneById(Long id) {
        return zoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
    }

    @Override
    public Zone updateZone(Long id, ZoneDTO dto) {
        Zone zone = getZoneById(id);
        zone.setName(dto.getName());
        zone.setMinTemp(dto.getMinTemp());
        zone.setMaxTemp(dto.getMaxTemp());
        return zoneRepository.save(zone);
    }

    @Override
    public void deleteZone(Long id) {
        zoneRepository.deleteById(id);
    }
}