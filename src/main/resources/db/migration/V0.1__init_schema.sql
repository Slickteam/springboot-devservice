CREATE TABLE shelf
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_shelf PRIMARY KEY (id)
);

CREATE TABLE book
(
    id        UUID NOT NULL,
    title     VARCHAR(255),
    author    VARCHAR(255),
    isbn      VARCHAR(255),
    publisher VARCHAR(255),
    shelf_id  UUID,
    CONSTRAINT pk_book PRIMARY KEY (id)
);