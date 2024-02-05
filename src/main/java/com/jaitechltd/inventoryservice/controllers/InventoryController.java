package com.jaitechltd.inventoryservice.controllers;

import com.jaitechltd.inventoryservice.entities.InventoryEntity;
import com.jaitechltd.inventoryservice.models.dto.requests.InventoryRequestDTO;
import com.jaitechltd.inventoryservice.models.dto.responses.InventoryResponseDTO;
import com.jaitechltd.inventoryservice.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = {"/api/v1/inventory"}, produces = MediaType.APPLICATION_JSON_VALUE)
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
    @Operation(summary = "Create a new inventory", description = "Create a new inventory", tags = {"inventory"},
            operationId = "createInventory", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Inventory created"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409",
                    description = "Inventory already exists")})
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
    @Operation(summary = "Get a inventory by id", description = "Get a inventory by id", tags = {"inventory"},
            operationId = "getInventory", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200", description = "Inventory found")})
    public ResponseEntity<?> getInventory(@PathVariable Long id) {
        log.info("Call to get inventory by id - {}", id);

        InventoryResponseDTO inventoryResponse = inventoryService.getInventoryById(id);
        return ResponseEntity.ok().body(inventoryResponse);
    }

    /**
     * Update inventory by id
     *
     * @param id               Inventory id
     * @param inventoryRequest Inventory request - see {@link InventoryEntity}
     * @return if successful, return the updated inventory with HTTP status 200, otherwise return HTTP status 500
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a inventory by id", description = "Update a inventory by id", tags = {"inventory"},
            operationId = "updateInventory", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Inventory updated"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Inventory not found")})
    public ResponseEntity<?> updateInventory(@PathVariable Long id, @RequestBody InventoryRequestDTO inventoryRequest) {
        log.info("Call to update inventory by id {} with request - {}", id, inventoryRequest);

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
    @Operation(summary = "Delete a inventory by id", description = "Delete a inventory by id", tags = {"inventory"},
            operationId = "deleteInventory", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Inventory deleted"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Inventory not found")})
    public ResponseEntity<?> deleteInventory(@PathVariable Long id) {
        log.info("Call to delete inventory by id - {}", id);
        inventoryService.deleteInventoryById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    @Operation(summary = "Get all inventory", description = "Get all inventory", tags = {"inventory"},
            operationId = "getAllInventory")
    public ResponseEntity<?> getAllInventory() {
        log.info("Call to get all inventory");
        return ResponseEntity.ok().body(inventoryService.getAllInventory());
    }
}
