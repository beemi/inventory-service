package com.jaitechltd.inventoryservice.services;

import com.jaitechltd.inventoryservice.entities.Inventory;
import com.jaitechltd.inventoryservice.repositorys.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory createInventory(Inventory inventoryRequest) {
        log.info("Create inventory service ...");

        try {
            return inventoryRepository.save(inventoryRequest);
        } catch (Exception e) {
            log.error("Failed to create inventory - ", e);
            throw e;
        }
    }

    public Object getInventory(Long id) {
        log.info("Get inventory service ...");

        try {
            return inventoryRepository.findById(id);
        } catch (Exception e) {
            log.error("Failed to get inventory - ", e);
            throw e;
        }
    }
}
