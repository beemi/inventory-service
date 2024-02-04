package com.jaitechltd.inventoryservice.models.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestDTO {

    private String name;
    private String description;
    private Long quantity;
    private Double price;
    private List<InventoryReviewRequestDTO> reviews;
}

