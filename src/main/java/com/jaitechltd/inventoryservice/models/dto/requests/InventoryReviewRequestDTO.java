package com.jaitechltd.inventoryservice.models.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryReviewRequestDTO {
        private String review;
        private Integer rating;
        private String reviewer;
}
