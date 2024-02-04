package com.jaitechltd.inventoryservice.mapper;

import com.jaitechltd.inventoryservice.entities.InventoryEntity;
import com.jaitechltd.inventoryservice.models.dto.requests.InventoryRequestDTO;
import com.jaitechltd.inventoryservice.models.dto.responses.InventoryResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class InventoryEntityConverter {

    public InventoryEntity toEntity(final InventoryRequestDTO inventoryRequest) {
        return InventoryEntity.builder()
                .name(inventoryRequest.getName())
                .description(inventoryRequest.getDescription())
                .quantity(inventoryRequest.getQuantity())
                .price(inventoryRequest.getPrice())
                .build();
    }

    public InventoryResponseDTO toDto(final InventoryEntity inventoryEntity) {
        return InventoryResponseDTO.builder()
                .id(inventoryEntity.getId())
                .name(inventoryEntity.getName())
                .description(inventoryEntity.getDescription())
                .quantity(inventoryEntity.getQuantity())
                .price(inventoryEntity.getPrice())
                .createdAt(inventoryEntity.getCreatedAt().toString())
                .updatedAt(inventoryEntity.getLastModifiedTime().toString())
                .build();
    }
}

