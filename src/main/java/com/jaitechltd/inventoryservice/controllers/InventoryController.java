package com.jaitechltd.inventoryservice.controllers;

import com.jaitechltd.inventoryservice.entities.InventoryEntity;
import com.jaitechltd.inventoryservice.models.dto.requests.InventoryRequestDTO;
import com.jaitechltd.inventoryservice.models.dto.responses.InventoryResponseDTO;
import com.jaitechltd.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value={"/api/v1/inventory"},produces = MediaType.APPLICATION_JSON_VALUE)
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Create inventory
     *
     * @param inventoryRequest Inventory request - see {@link InventoryEntity}
     * @return if successful, return the created inventory with HTTP status 200, otherwise return HTTP status 500
     */
    @PostMapping("/create")
    public ResponseEntity<InventoryResponseDTO> createInventory(@RequestBody InventoryRequestDTO inventoryRequest) {
        log.info("Call to create inventory with request - {}", inventoryRequest);

        InventoryResponseDTO inventory = inventoryService.createInventory(inventoryRequest);
        return ResponseEntity.ok(inventory);
    }
}
