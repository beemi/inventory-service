package com.jaitechltd.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "inventory_review")
@Entity
@Data
public class InventoryReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "reviewer")
    private String reviewer;

    @Column(name = "created_at", updatable = false)
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
