CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE hotel (
    id UUID PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    name VARCHAR(30) NOT NULL UNIQUE,
    localization VARCHAR(100) NOT NULL,
    is_open BOOLEAN NOT NULL ,
    creation_date DATE,
    information VARCHAR(200)
);