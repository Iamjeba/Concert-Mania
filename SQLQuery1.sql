/* Concert Mania Final Edition  */


DROP DATABASE ConcertMania

CREATE DATABASE ConcertMania

DROP TABLE signup

/* sequece -> id, name, gender, pin, nid  */

CREATE TABLE signup
(
UserType varchar(255), 
id int,
name varchar(255),
gender varchar(255),
email varchar(255) unique,
pin varchar(255),
nid varchar(255),
phn varchar(255),
dob date,
health varchar(255),
images varchar(255)
)

SELECT * FROM signup
SELECT * FROM Concert_Registration_User
INSERT INTO signup(UserType,id,name,gender,email,pin,nid,phn,dob,health,images) VALUES
('Admin','1','Jeba','Feale','190104032@aust.edu','Jeba123','236503934','01770620552','1998-12-11','No Sickness','Null'),
('Admin','2','shafi','Male','salekin68@gmail.com','iamsfi','436503904','01969484203','2000-01-17','No Sickness','Null'),
('Admin','3','Ahmad','Male','akc@gmail.com','akc123456','226503904','01969484203','2000-03-01','No Sickness','Null'),
('General User','4','abc','Female','abc@gmail.com','abc12345','738803904','01969484203','2010-03-01','No Sickness','Null'),
('General User','5','efg','Male','efg@gmail.com','efg12345','689503904','01969484203','2010-03-01','Fever','Null'),
('General User','6','afsdds','Male','afsdds@gmail.com','afsdds145','136507704','01969484203','2010-03-01','Fever and Cough','Null')

SELECT * FROM signup WHERE UserType='Admin'
SELECT * FROM signup WHERE UserType='General User'

TRUNCATE TABLE signup

DROP TABLE Concert_Registration

CREATE TABLE Concert_Registration
( 
id int,
name varchar(255),
location varchar(255),
category varchar(255),
ticket_price int,
ticket_quantity int,
C_Date date,
ArtistNames varchar(255),
S_id int,					/* Sponsor ID */
M_id int,					/* Admin/Manager ID */
)

INSERT INTO Concert_Registration(id,name, location, category, ticket_price, ticket_quantity, C_Date, ArtistNames, S_id, M_id) VALUES
('1', 'Artcellism', 'ICCB Expo Zone', 'Rock Music Concert','200','1000','2022-02-21','Arthohin, Artcell' , '2', '1' ),
('2', 'Boishakhi Rong', 'M A Aziz Stadium', 'Pop Music Concert', '400','2000', '2022-04-11','Cryptic Fate' , '1', '2'),
('3', 'Bijoy Dibosh', 'M A Aziz Stadium', 'Pop Music Concert', '150','5000', '2022-04-11','Black' , '1', '3')

/*Insert values -> 3, Joy Bangla, Army Stadium, Rock, 500, 50000,  2022-02-21, Tahsan, Nemesis, 01, 34     */
SELECT * FROM Concert_Registration

SELECT * FROM Concert_Registration where name= 'Artcellism'
SELECT * FROM Concert_Registration where name= 'Artcellism'

/* TRUNCATE TABLE Concert_Registration		  */

DROP TABLE Concert_Registration_User

CREATE TABLE Concert_Registration_User								/* User's info of buying ticket */
(
User_id int,
User_name varchar(255), 
CID int,
Cname varchar(255),
Tquantity int,
Tprice int,
Tamt int,
BuyingTime datetime,
Method varchar(255),
HaveTickets int
)

INSERT INTO Concert_Registration_User(User_id,User_name, CID, Cname, Tquantity, Tprice, Tamt, BuyingTime,Method,HaveTickets) VALUES
('99', 'abc', '1', 'Artcellism', '1', '200', '200', '2022-02-21','Buy','1'),
('98', 'efg', '1', 'Artcellism', '2', '200', '400', '2011-02-21','Buy','2'),
('98', 'efg', '2', 'Boishakhi Rong', '3', '400', '1200', '2011-02-21','Buy','3'),
('99', 'abc', '4', 'Joy Bangla', '4', '250', '1000', '2011-02-21','Buy','4')

SELECT * FROM Concert_Registration_User
Select * From Concert_Registration

SELECT * FROM Concert_Registration_User	where User_id='99'

Select SUM(Tquantity) FROM Concert_Registration_User WHERE User_id='98' AND Cname ='Artcellism'

SELECT User_id FROM Concert_Registration_User where User_id='98' AND Tquantity <= 10

select distinct Cname FROM Concert_Registration_User where User_id='99' AND User_name='abc'

Select MAX(HaveTickets) FROM Concert_Registration_User WHERE User_id='99' AND Cname ='Artcellism'


drop table Sponsor_Registration

CREATE TABLE Sponsor_Registration
( 
/* S_Id int PRIMARY KEY IDENTITY,   */
S_Id int, 
S_CompanyName varchar(255),
S_PhoneNumber varchar(255),  
C_Id int
) SELECT * FROM Sponsor_Registration

Insert into Sponsor_Registration(S_Id,S_CompanyName,S_PhoneNumber,C_Id) values
('1','Bengal Brokerage','01770620552','2'),
('2','Pran RFL','01955209090','1')

TRUNCATE TABLE Sponsor_Registration

 

/*
INSERT INTO Concert_Registration(id,name, location, category, ticket_price, ticket_quantity, C_Date, ArtistNames, S_id, M_id) VALUES
('1', 'Artcellism', 'ICCB Expo Zone', 'Rock Music Concert','200','1000','2022-02-21','Arthohin, Artcell' , '22', '15' ),
('2', 'Boishakhi Rong', 'M A Aziz Stadium', 'Pop Music Concert', '400','2000', '2022-04-11','Cryptic Fate' , '11', '17')
*/

/*
drop table Artist_Registration

CREATE TABLE Artist_Registration								/* User's info of buying ticket */
(
A_Id int,
A_Name varchar(255), 
A_PhoneNumber varchar(255),
A_Email varchar(255),
C_Id int
)

INSERT INTO Artist_Registration values
('01', 'Artcell', '01111111111',  'Artcell@gmail.com', '1'),
('02', 'Arthohin', '01222222222',  'Arthohin@gmail.com', '1'),
('03', 'Cryptic Fate', '02211122222',  'Fate@gmail.com', '2')

select * from Artist_Registration


*/





