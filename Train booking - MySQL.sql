create database TrainBooking;
use TrainBooking;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Trip;
DROP TABLE IF EXISTS Registered;
-- User(FirstName , LastName , UserName , email , City , password , Admin? , creditCard)
Create Table User
(
  FirstName varchar(100) NOT NULL,
  LastName varchar(100) NOT NULL,
  UserName varchar(100) primary key,
  Email varchar(255) NOT NULL unique,
  City Varchar(100),
  Password char(8) NOT NULL,
  Admin TINYINT(1) NOT NULL DEFAULT 0,
  CreditCard varchar(255)
);
-- Trip(Source , Destination , StartTime(YYYY-MM-DD HH:MI:SS) , EndTime(YYYY-MM-DD HH:MI:SS) , Capacity , Reserved)
Create Table Trip
(
  Name varchar(100) primary key,
  TrainId INT REFERENCES Train(Id),
  Source varchar(100) NOT NULL,
  Destination Varchar(100) NOT NULL,
  StartTime TIMESTAMP NOT NULL,
  EndTime TIMESTAMP NOT NULL,
  Price INT NOT NULL,
  Reserved INT DEFAULT 0,
  Capacity INT NOT NULL
);
-- Registered(UserName , TripName)
Create Table Registered
(
  UserName varchar(100) REFERENCES User(UserName),
  TripName varchar(100) REFERENCES Trip(Name),
  primary key (UserName, TripName)
);
-- Train(Id, Capacity, Type), Capacity is the number of seats available in the Train.
Create Table Train
(
  Id INT primary key,
  Capacity INT NOT NULL,
  Type varchar(100) NOT NULL
);
