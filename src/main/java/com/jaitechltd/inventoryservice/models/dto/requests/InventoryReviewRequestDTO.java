package com.jaitechltd.inventoryservice.models.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryReviewRequestDTO {
        private String review;
        private Integer rating;
        private String reviewer;
}
