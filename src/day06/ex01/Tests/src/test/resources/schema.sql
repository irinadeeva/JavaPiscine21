DROP SCHEMA PUBLIC CASCADE;
CREATE TABLE product(
    id INT PRIMARY KEY,
    name VARCHAR(150),
    price INT
);