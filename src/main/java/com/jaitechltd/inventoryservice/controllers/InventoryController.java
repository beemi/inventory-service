package com.jaitechltd.inventoryservice.controllers;

import com.jaitechltd.inventoryservice.entities.Inventory;
import com.jaitechltd.inventoryservice.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Create inventory
     *
     * @param inventoryRequest Inventory request - see {@link Inventory}
     * @return if successful, return the created inventory with HTTP status 200, otherwise return HTTP status 500
     */
    @PostMapping("/create")
    public ResponseEntity<?> createInventory(@RequestBody Inventory inventoryRequest) {
        log.info("Create inventory controller ...");

        Inventory inventory = inventoryService.createInventory(inventoryRequest);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(inventoryService.getInventory(id));
    }
}
