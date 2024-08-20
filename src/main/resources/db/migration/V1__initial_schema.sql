CREATE TABLE Articles (
      id                  INTEGER NOT NULL PRIMARY KEY,
      name                VARCHAR(255) NOT NULL,
      quantity            INTEGER NOT NULL
);

CREATE TABLE Products (
      id                  SERIAL PRIMARY KEY,
      name                VARCHAR(255) NOT NULL,
      price               INTEGER NOT NULL
);

CREATE TABLE ProductParts (
      id                  SERIAL PRIMARY KEY,
      prod_id             INTEGER NOT NULL REFERENCES Products(id),
      art_id              INTEGER NOT NULL REFERENCES Articles(id),
      quantity            INTEGER NOT NULL
);