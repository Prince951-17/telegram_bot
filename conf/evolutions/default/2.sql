# --- !Ups
CREATE TABLE "Holiday" (
  "id" SERIAL NOT NULL PRIMARY KEY,
  "holidayName" VARCHAR NOT NULL,
  "holidayDate" DATE NOT NULL
);

# --- !Downs
DROP TABLE "Holiday";