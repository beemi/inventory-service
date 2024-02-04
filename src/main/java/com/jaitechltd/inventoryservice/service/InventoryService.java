package com.jaitechltd.inventoryservice.service;

import com.jaitechltd.inventoryservice.entities.InventoryEntity;
import com.jaitechltd.inventoryservice.mapper.InventoryEntityConverter;
import com.jaitechltd.inventoryservice.models.dto.requests.InventoryRequestDTO;
import com.jaitechltd.inventoryservice.models.dto.responses.InventoryResponseDTO;
import com.jaitechltd.inventoryservice.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        log.info("Converted inventory entity - {}", inventory);

        // Save entity to database
        InventoryEntity savedInventory = inventoryRepository.save(inventory);

        // Convert saved entity back to DTO
        return inventoryEntityConverter.toDto(savedInventory);
    }
}
