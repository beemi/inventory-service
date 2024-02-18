package com.jaitechltd.inventoryservice.service;

import com.jaitechltd.inventoryservice.entities.InventoryEntity;
import com.jaitechltd.inventoryservice.mapper.InventoryEntityConverter;
import com.jaitechltd.inventoryservice.mapper.InventoryReviewEntityConverter;
import com.jaitechltd.inventoryservice.models.dto.requests.InventoryRequestDTO;
import com.jaitechltd.inventoryservice.models.dto.responses.InventoryResponseDTO;
import com.jaitechltd.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private InventoryEntityConverter inventoryEntityConverter;

    @Mock
    private InventoryReviewEntityConverter inventoryReviewEntityConverter;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateInventory() {
        // Arrange
        InventoryRequestDTO inventoryRequest = new InventoryRequestDTO(); // Populate with test data
        InventoryEntity inventoryEntity = new InventoryEntity(); // Populate with test data
        InventoryEntity savedInventoryEntity = new InventoryEntity(); // Populate with expected data after save
        InventoryResponseDTO expectedResponse = new InventoryResponseDTO();


        Mockito.when(inventoryEntityConverter.toEntity(inventoryRequest)).thenReturn(inventoryEntity);
        Mockito.when(inventoryRepository.save(inventoryEntity)).thenReturn(savedInventoryEntity);
        Mockito.when(inventoryEntityConverter.toDto(savedInventoryEntity)).thenReturn(expectedResponse);

        // Act
        InventoryResponseDTO actualResponse = inventoryService.createInventory(inventoryRequest);

        // Add assertions here
        assertEquals(expectedResponse, actualResponse);
        verify(inventoryEntityConverter).toEntity(inventoryRequest);
        verify(inventoryRepository).save(inventoryEntity);
        verify(inventoryEntityConverter).toDto(savedInventoryEntity);
    }
}
