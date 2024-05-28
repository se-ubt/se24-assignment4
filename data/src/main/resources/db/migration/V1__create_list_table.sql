CREATE TABLE list (
    id uuid NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    value double precision NOT NULL
);
