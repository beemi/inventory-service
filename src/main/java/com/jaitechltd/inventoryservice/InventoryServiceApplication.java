package com.jaitechltd.inventoryservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(InventoryServiceApplication.class, args);
            log.info("InventoryServiceApplication started ...");
        } catch (Exception e) {
            log.error("InventoryServiceApplication failed to start:", e);
        }
    }
}
