CREATE TABLE IF NOT EXISTS tbl_product (
    id bigint NOT NULL AUTO_INCREMENT,
    description varchar(255) DEFAULT NULL,
    name varchar(255) NOT NULL,
    price decimal(38, 2) NOT NULL,
    quantity int NOT NULL,
    type enum(
        'APPLIANCE',
        'ELECTRONIC',
        'FOOD',
        'HOUSEHOLD',
        'MUSIC',
        'SPORTS'
    ) NOT NULL,
    PRIMARY KEY (`id`)
);