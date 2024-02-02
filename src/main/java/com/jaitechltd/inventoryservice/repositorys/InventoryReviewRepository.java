package com.jaitechltd.inventoryservice.repositorys;

import com.jaitechltd.inventoryservice.entities.InventoryReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryReviewRepository extends JpaRepository<InventoryReview, Long> {
}
