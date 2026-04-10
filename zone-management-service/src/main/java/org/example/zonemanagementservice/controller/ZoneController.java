package org.example.zonemanagementservice.controller;

import org.example.zonemanagementservice.dto.ZoneDTO;
import org.example.zonemanagementservice.model.Zone;
import org.example.zonemanagementservice.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @PostMapping
    public ResponseEntity<ZoneDTO> createZone(@RequestBody ZoneDTO zoneDTO){
        ZoneDTO created = zoneService.createZone(zoneDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public List<Zone> getAllZones(){ return zoneService.getAllZones(); }

    @GetMapping("/{id}")
    public Zone getZoneById(@PathVariable Long id){ return zoneService.getZoneById(id); }

    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable Long id, @RequestBody ZoneDTO dto){
        return zoneService.updateZone(id,dto);
    }

