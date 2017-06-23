-- Table: public."Weather"

/*
CREATE SEQUENCE Weather_id_seq;
ALTER SEQUENCE Weather_id_seq
OWNED BY Weather.id;
*/


DROP TABLE IF EXISTS Weather;

CREATE TABLE Weather
(
--  id integer NOT NULL DEFAULT nextval('Weather_id_seq') PRIMARY KEY,
  id bigserial PRIMARY KEY,
  city character(50),
  longitude double precision,
  latitude double precision,
  temperature double precision
)
WITH (
  OIDS=FALSE
);
ALTER TABLE Weather
  OWNER TO postgres;


insert into Weather(city,longitude,latitude, temperature) 
values('Sofia', 50.0, 50.0, 50.0);
insert into Weather(city,longitude,latitude, temperature) 
values('Paris', 40.0, 55.0, 50.0);
insert into Weather(city,longitude,latitude, temperature) 
values('Sofia', 50.0, 50.0, 50.0);
insert into Weather(city,longitude,latitude, temperature) 
values('Paris', 40.0, 55.0, 50.0);
select * from Weather;

--select current_database();
--select user;
