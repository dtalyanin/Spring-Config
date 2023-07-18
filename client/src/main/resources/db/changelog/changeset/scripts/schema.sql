CREATE TABLE IF NOT EXISTS books
(
    id           BIGSERIAL PRIMARY KEY,
    title        VARCHAR(200) NOT NULL CHECK (length(title) > 0),
    author       VARCHAR(200) NOT NULL CHECK (length(author) > 0)
)