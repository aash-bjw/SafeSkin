CREATE TABLE skincare (
skinId Long NOT NULL PRIMARY KEY,
name VARCHAR(250) NOT NULL,
expireDate Date NOT NULL,
isOpen Boolean NOT NULL,
size Double,
sku Long
)