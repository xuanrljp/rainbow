DROP TABLE task IF EXISTS;

CREATE TABLE task (
  id         INTEGER IDENTITY PRIMARY KEY,
  title VARCHAR(255)
);