package com.jaitechltd.inventoryservice.models.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryReviewResponseDTO {

        private Long id;
        private String review;
        private Integer rating;
        private String reviewer;
        private String createdAt;
        private String updatedAt;
}
