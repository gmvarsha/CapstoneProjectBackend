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


create table flights (
flight_id int auto_increment primary key,
flight_number int unique,
flight_name varchar(50),
source varchar(150),
destination varchar(150),
departure_time DateTime,
arrival_time DateTime,
scheduled_Date date,
airline varchar(100),
status varchar(20),
stops int ,
seats int,
flight_type varchar(50)
);


create table airports(
airport_id int auto_increment Primary Key,
airport_code varchar(100),
airport_name varchar(150),
city varchar(100),
country varchar(50)
);


create table Bookings (
booking_id int auto_increment Primary Key,
user_id BIGINT ,
flight_id int ,
booking_date date,
status varchar(50),
foreign Key (user_id) references Users(id),
foreign Key (flight_id) references Flights(flight_id)
);


create table Passengers(

passenger_id int auto_increment Primary Key,
booking_id int ,
first_name varchar(50),
last_name varchar(50),
passport_number int,
date_of_birth date,
seat_number int,
foreign Key (booking_id) references Bookings(booking_id)

);


create table seats(
seat_id int auto_increment Primary Key,
flight_id int,
seat_number int,
class varchar(100),
is_available Boolean,
Foreign Key (flight_id) references Flights(flight_id)
);


create table airlines (
airline_id int auto_increment primary Key,
airline_name varchar(100),
airline_code varchar(20),
country varchar(50)

);

CREATE TABLE user_query (
  `user_query_id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `user_queries` varchar(2555) NOT NULL,
  PRIMARY KEY (`user_query_id`)
);


CREATE TABLE reply (
  `reply_id` bigint NOT NULL AUTO_INCREMENT,
  `admin_reply` varchar(2555) NOT NULL,
  `user_id` bigint NOT NULL,
  `user_query_id` bigint NOT NULL,
  PRIMARY KEY (`reply_id`)
);


