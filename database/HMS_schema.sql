create table login(
username varchar2(30), password varchar2(30)
);
insert into login values('admin','admin123');


create table employee(
name varchar2(40),age varchar2(10),gender varchar2(15),jobrole varchar2(30),salary varchar2(20), phone varchar2(20), email varchar2(50),aadhar varchar2(15)
);


create table room(
roomNo varchar2(10),availabilityStatus varchar2(20),cleaningStatus varchar2(15),price varchar2(15),bedType varchar2(20)
);


create table driver(
name varchar2(20),age varchar2(10),gender varchar2(15),carCompany varchar2(20),carModel varchar2(20),availabilityStatus varchar2(20),location varchar2(25)
);


create table customer(
id varchar2(30),idNo varchar2(20),name varchar2(25),gender varchar2(20),country varchar2(20),allocatedRoomNo varchar2(10),time varchar2(30),deposit varchar2(15)
);


