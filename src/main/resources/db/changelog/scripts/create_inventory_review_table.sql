CREATE TABLE IF NOT EXISTS inventory_review (
                                                ID INT AUTO_INCREMENT PRIMARY KEY,
                                                REVIEW TEXT NOT NULL,
                                                RATING INT NOT NULL,
                                                REVIEWER VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP,
    LAST_MODIFIED_TIME TIMESTAMP,
    INVENTORY_ID INT NOT NULL,
    CONSTRAINT fk_inventory
    FOREIGN KEY (INVENTORY_ID)
    REFERENCES inventory(ID)
    );
