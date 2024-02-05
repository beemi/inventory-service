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
    public ResponseEntity<?> createInventory(@RequestBody InventoryRequestDTO inventoryRequest) {
        log.info("Call to create inventory with request - {}", inventoryRequest);

        InventoryResponseDTO inventoryResponse = inventoryService.createInventory(inventoryRequest);
        return ResponseEntity.ok().body(inventoryResponse);
    }

    /**
     * Get inventory by id
     *
     * @param id Inventory id
     * @return if successful, return the inventory with HTTP status 200, otherwise return HTTP status 500
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getInventory(@PathVariable Long id) {
        log.info("Call to get inventory by id - {}", id);

        InventoryResponseDTO inventoryResponse = inventoryService.getInventoryById(id);
        return ResponseEntity.ok().body(inventoryResponse);
    }

    /**
     * Update inventory by id
     *
     * @param id Inventory id
     * @param inventoryRequest Inventory request - see {@link InventoryEntity}
     * @return if successful, return the updated inventory with HTTP status 200, otherwise return HTTP status 500
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable Long id, @RequestBody InventoryRequestDTO inventoryRequest) {
        log.info("Call to update inventory by id - {}", id);

        InventoryResponseDTO inventoryResponse = inventoryService.updateInventoryById(id, inventoryRequest);
        return ResponseEntity.ok().body(inventoryResponse);
    }

    /**
     * Delete inventory by id
     *
     * @param id Inventory id
     * @return if successful, return HTTP status 200, otherwise return HTTP status 500
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long id) {
        log.info("Call to delete inventory by id - {}", id);
        inventoryService.deleteInventoryById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Find all inventories
     *
     * @return if successful, return the list of inventories with HTTP status 200, otherwise return HTTP status 500
     */

    /**
     * Health check
     *
     * @return if successful, return HTTP status 200, otherwise return HTTP status 500
     */
    @GetMapping("/health")
    public ResponseEntity<?> healthCheck() {
        log.info("Health check ...");
        return ResponseEntity.ok().build();
    }
}
