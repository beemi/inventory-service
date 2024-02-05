package com.jaitechltd.inventoryservice.service;

import com.jaitechltd.inventoryservice.entities.InventoryEntity;
import com.jaitechltd.inventoryservice.mapper.InventoryEntityConverter;
import com.jaitechltd.inventoryservice.models.dto.requests.InventoryRequestDTO;
import com.jaitechltd.inventoryservice.models.dto.responses.InventoryResponseDTO;
import com.jaitechltd.inventoryservice.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityConverter inventoryEntityConverter;

    public InventoryService(InventoryRepository inventoryRepository, InventoryEntityConverter inventoryEntityConverter) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryEntityConverter = inventoryEntityConverter;
    }

    public InventoryResponseDTO createInventory(InventoryRequestDTO inventoryRequest) {
        log.info("Create inventory service ...");
        // Convert DTO to entity
        InventoryEntity inventory = inventoryEntityConverter.toEntity(inventoryRequest);

        // Save entity to database
        InventoryEntity savedInventory = inventoryRepository.save(inventory);

        // Convert saved entity back to DTO
        return inventoryEntityConverter.toDto(savedInventory);
    }

    public InventoryResponseDTO getInventoryById(Long id) {
        log.info("Get inventory by id service ...");
        InventoryEntity inventory = inventoryRepository.findById(id).orElse(null);
        return inventoryEntityConverter.toDto(inventory);
    }

    public InventoryResponseDTO updateInventoryById(Long id, InventoryRequestDTO inventoryRequest) {

        log.info("Update inventory by id service ...");
        InventoryEntity inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory == null) {
            return null;
        }

        // Update entity
        inventory.setId(id);
        inventory.setName(inventoryRequest.getName());
        inventory.setDescription(inventoryRequest.getDescription());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setPrice(inventoryRequest.getPrice());

        // Save entity to database
        InventoryEntity updatedInventory = inventoryRepository.save(inventory);

        // Convert saved entity back to DTO
        return inventoryEntityConverter.toDto(updatedInventory);
    }

    public void deleteInventoryById(Long id) {
        log.info("Delete inventory by id service ...");
        inventoryRepository.findById(id).ifPresent(inventoryRepository::delete);
    }
}
