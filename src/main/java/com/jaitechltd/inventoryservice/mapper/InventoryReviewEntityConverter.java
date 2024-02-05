package com.jaitechltd.inventoryservice.mapper;

import com.jaitechltd.inventoryservice.entities.InventoryReviewEntity;
import com.jaitechltd.inventoryservice.models.dto.requests.InventoryReviewRequestDTO;
import com.jaitechltd.inventoryservice.models.dto.responses.InventoryReviewResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class InventoryReviewEntityConverter {

    public InventoryReviewEntity toEntity(final InventoryReviewRequestDTO reviewRequest) {
        return InventoryReviewEntity.builder()
                .review(reviewRequest.getReview())
                .rating(reviewRequest.getRating())
                .reviewer(reviewRequest.getReviewer())
                .build();
    }

    public InventoryReviewResponseDTO toDto(final InventoryReviewEntity reviewEntity) {
        return InventoryReviewResponseDTO.builder()
                .id(reviewEntity.getId())
                .review(reviewEntity.getReview())
                .rating(reviewEntity.getRating())
                .reviewer(reviewEntity.getReviewer())
                .createdAt(reviewEntity.getCreatedAt().toString())
                .updatedAt(reviewEntity.getLastModifiedTime().toString())
                .build();
    }
}
