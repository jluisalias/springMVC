CREATE DATABASE rateFlats;

GRANT ALL ON rateFlats.* TO rateFlatsuser@'%' IDENTIFIED BY 'prateFlatsuser';
GRANT ALL ON rateFlats.* TO rateFlatsuser@localhost IDENTIFIED BY 'prateFlatsuser';

USE rateFlats;

CREATE TABLE flats (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nameOfStreetandNumber varchar(255),
  distanceToWork integer,
  priceByMonth integer,
  areaSize integer,
  price decimal(15,2),
  url varchar(255),
  myRating decimal (15,2),
  comments varchar(1000),
  isCommunityIncluded boolean,
  isWaterIncluded boolean,
  isPermittedAContractOfSixMonths boolean,
  finalRating decimal(15,2)
);
CREATE INDEX flats_finalRating ON flats(finalRating);