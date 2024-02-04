package com.jaitechltd.inventoryservice.repository;

import com.jaitechltd.inventoryservice.entities.InventoryReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryReviewRepository extends JpaRepository<InventoryReviewEntity, Long> {
}
