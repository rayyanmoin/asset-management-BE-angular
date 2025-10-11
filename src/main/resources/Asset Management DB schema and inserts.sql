-- Table for User entity
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role VARCHAR(50) NOT NULL
);

-- Table for Suppliers entity
CREATE TABLE suppliers (
    supplier_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255) NOT NULL,
    contact_name VARCHAR(255),
    contact_email VARCHAR(255),
    contact_phone VARCHAR(20),
    address TEXT
);

-- Table for Locations entity
CREATE TABLE locations (
    location_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    location_name VARCHAR(255),
    location_code VARCHAR(255)
);
-- Table for Employees entity
CREATE TABLE employees (
    employee_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    location_id BIGINT,
    contact_email VARCHAR(255),
    contact_phone VARCHAR(20),
    CONSTRAINT fk_employees_location
        FOREIGN KEY (location_id) REFERENCES locations(location_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Table for Categories entity
CREATE TABLE categories (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL,
    category_description VARCHAR(255)
);

-- Table for Assets entity
CREATE TABLE assets (
    asset_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    asset_name VARCHAR(255) NOT NULL,
    category_id BIGINT,
    cost DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_assets_category
        FOREIGN KEY (category_id) REFERENCES categories(category_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Table for AssetDetails entity
CREATE TABLE asset_details (
    asset_details_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    asset_id BIGINT,
    employee_id BIGINT,
    location_id BIGINT,
    supplier_id BIGINT,
    CONSTRAINT fk_assetdetails_asset
        FOREIGN KEY (asset_id) REFERENCES assets(asset_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    CONSTRAINT fk_assetdetails_employee
        FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    CONSTRAINT fk_assetdetails_location
        FOREIGN KEY (location_id) REFERENCES locations(location_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    CONSTRAINT fk_assetdetails_supplier
        FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Table for AssetHistory entity
CREATE TABLE asset_history (
    assetHistory_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    asset_id BIGINT,
    location_id BIGINT,
    year INT,
    asset_history VARCHAR(255),
    CONSTRAINT fk_assethistory_asset
        FOREIGN KEY (asset_id) REFERENCES assets(asset_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    CONSTRAINT fk_assethistory_location
        FOREIGN KEY (location_id) REFERENCES locations(location_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
-- Inserts for users
INSERT INTO users (username, password, email, role) 
VALUES ('admin', 'admin123', 'admin@example.com', 'ADMIN');
INSERT INTO users (username, password, email, role) 
VALUES ('johndoe', 'password123', 'john@example.com', 'USER');

-- Inserts for suppliers
INSERT INTO suppliers (supplier_name, contact_name, contact_email, contact_phone, address) 
VALUES ('Tech Supplies Co.', 'Alice Smith', 'alice@techsupplies.com', '1234567890', '123 Tech Street');
INSERT INTO suppliers (supplier_name, contact_name, contact_email, contact_phone, address) 
VALUES ('Office Depot', 'Bob Johnson', 'bob@officedepot.com', '0987654321', '456 Office Road');

-- Inserts for locations
INSERT INTO locations (location_name, location_code) 
VALUES ('Head Office', 'HO-01');
INSERT INTO locations (location_name, location_code) 
VALUES ('Warehouse', 'WH-01');

-- Inserts for employees
INSERT INTO employees (employee_name, location_id, contact_email, contact_phone) 
VALUES ('Jane Doe', 1, 'jane.doe@example.com', '1112223333');
INSERT INTO employees (employee_name, location_id, contact_email, contact_phone) 
VALUES ('Mark Spencer', 2, 'mark.spencer@example.com', '4445556666');

-- Inserts for categories
INSERT INTO categories (category_name, category_description) 
VALUES ('Electronics', 'Devices like laptops, phones, and tablets');
INSERT INTO categories (category_name, category_description) 
VALUES ('Furniture', 'Office desks, chairs, and cabinets');

-- Inserts for assets
INSERT INTO assets (asset_name, category_id, cost) 
VALUES ('Dell Laptop', 1, 1200.00);
INSERT INTO assets (asset_name, category_id, cost) 
VALUES ('Office Chair', 2, 150.00);

-- Inserts for asset_details
INSERT INTO asset_details (asset_id, employee_id, location_id, supplier_id) 
VALUES (1, 1, 1, 1);
INSERT INTO asset_details (asset_id, employee_id, location_id, supplier_id) 
VALUES (2, 2, 2, 2);

-- Inserts for asset_history
INSERT INTO asset_history (asset_id, location_id, year, asset_history) 
VALUES (1, 1, 2023, 'Assigned Dell Laptop to Jane Doe at Head Office');
INSERT INTO asset_history (asset_id, location_id, year, asset_history) 
VALUES (2, 2, 2024, 'Assigned Office Chair to Mark Spencer at Warehouse');


