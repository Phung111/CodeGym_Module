CREATE DATABASE quanlisinhvien;

USE quanlisinhvien;

create table Class (
ClassID int not null auto_increment primary key,
ClassName varchar(60) not null,
startDate Datetime not null,
`status` bit);	

create table Student(
StudentID int not null auto_increment,
StudentName varchar(30) not null,
Address varchar(50),
Phone varchar(20),
`Status` Bit,
ClassID int not null,
primary key(StudentID));

alter table Student
add foreign key(ClassID) references Class(ClassID);

create table Subject(
SubID int not null auto_increment primary key,
SubName varchar(30) not null,
Credit Tinyint not null default 1 check(Credit >=1),
`Status` bit default 1);

create table Mark(
MarkID int not null primary key auto_increment,
SubID int not null unique ,
StudentID int not null unique,
Mark float default 0 check (Mark between 0 and 100),
foreign key(SubID) references subject(SubID),
constraint fk_student foreign key(StudentID) references student(StudentID)); 


