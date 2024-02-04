CREATE TABLE IF NOT EXISTS inventory (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    QUANTITY INT NOT NULL,
    PRICE DECIMAL(10, 2) NOT NULL,
    CREATED_AT TIMESTAMP,
    LAST_MODIFIED_TIME TIMESTAMP
);
