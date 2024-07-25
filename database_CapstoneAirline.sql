create database CapstoneAirline ;

use CapstoneAirline;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
    role VARCHAR(50) NOT NULL
);


CREATE TABLE flights (
    flight_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    source VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
flight_number VARCHAR(50) NOT NULL,
departure_date DATE NOT NULL,
departure_time TIME NOT NULL,
arrival_date DATE NOT NULL,
arrival_time TIME NOT NULL,
stops varchar(255),
seats int,
flight_type varchar(50),
price DECIMAL(10, 2) NOT NULL
);


create table seats(
seat_id int auto_increment Primary Key,
flight_id BIGINT,
seat_number int,
class varchar(100),
is_available Boolean,
Foreign Key (flight_id) references Flights(flight_id)
);



create table Bookings (
booking_id INT auto_increment Primary Key,
user_id BIGINT ,
flight_id BIGINT ,
booking_date date,
status varchar(50),
foreign Key (user_id) references Users(id),
foreign Key (flight_id) references Flights(flight_id)
);


CREATE TABLE passengers (
  passenger_id int NOT NULL AUTO_INCREMENT,
  date_of_birth date DEFAULT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  passport_number int NOT NULL,
  seat_number int NOT NULL,
  booking_id int DEFAULT NULL,
  checked_in bit(1) NOT NULL,
  PRIMARY KEY (passenger_id),
  KEY FKgc7vcfrut3vamougerwse2m2u (booking_id),
  CONSTRAINT FKgc7vcfrut3vamougerwse2m2u FOREIGN KEY (booking_id) REFERENCES bookings (booking_id)
);




create table airlines (
airline_id int auto_increment primary Key,
airline_name varchar(100),
airline_code varchar(20),
country varchar(50)

);

create table airports(
airport_id int auto_increment Primary Key,
airport_code varchar(100),
airport_name varchar(150),
city varchar(100),
country varchar(50)
);


CREATE TABLE user_query (
  user_query_id bigint NOT NULL AUTO_INCREMENT,
  created_at datetime(6) DEFAULT NULL,
  user_id bigint NOT NULL,
  user_queries varchar(2555) NOT NULL,
  PRIMARY KEY (user_query_id)
);


CREATE TABLE reply (
  reply_id bigint NOT NULL AUTO_INCREMENT,
  admin_reply varchar(2555) NOT NULL,
  user_id bigint NOT NULL,
  user_query_id bigint NOT NULL,
  PRIMARY KEY (reply_id)
);


