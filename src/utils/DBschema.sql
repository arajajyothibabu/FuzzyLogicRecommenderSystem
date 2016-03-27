/*Ratings table*/
CREATE TABLE ratings
(
  userid NUMBER(36) NOT NULL,
  movieid NUMBER(36) NOT NULL,
  rating NUMBER(1),
  time TIMESTAMP(6),
  CONSTRAINT ratingid PRIMARY KEY (userid, movieid)
);

/*Users table*/
CREATE TABLE users
(
  userid NUMBER(36) NOT NULL PRIMARY KEY,
  gender VARCHAR2(1),
  age NUMBER(2),
  occupation VARCHAR(50),
  zipcode NUMBER(6)
);

/* GenreType definition*/
CREATE TYPE  genreType AS VARRAY(19) OF VARCHAR2(1);

/* custome AUTO Increment*/
CREATE SEQUENCE movie_id
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 20;

/*Movies Table*/
CREATE TABLE movies
(
  movieid number(36) NOT NULL PRIMARY KEY,
  title VARCHAR2(50),
  genres genreType
);