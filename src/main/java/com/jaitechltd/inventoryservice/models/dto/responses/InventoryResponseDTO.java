package com.jaitechltd.inventoryservice.models.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Long quantity;
    private Double price;
    private String createdAt;
    private String updatedAt;
    private List<InventoryReviewResponseDTO> reviews;
}

