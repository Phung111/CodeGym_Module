use quanlisinhvien;

CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

select * from class;

alter table class
MODIFY column startDate Date;

insert into class
values(1,'A1','2008-12-20',1),
(2,'A2','2008-12-22',1),
(3,'B3',current_date,0);

insert into student(StudentID,StudentName,Address,Phone,`Status`,ClassID)
values(1,'Hung','Ha Noi',0912113113,1,1);

insert into student(StudentID,StudentName,Address,`Status`,ClassID)
values (2,'Hoa','Hai Phong',1,1);

insert into student(StudentID,StudentName,Address,Phone,`Status`,ClassID)
values (3,'Manh','HCM',0123123123,0,2);

delete from student;

select * from student;

insert into subject
values(1,'CF',5,1),
(2,'C',6,1),
(3,'HDJ',5,1),
(4,'RDBMS',10,1);

select * from subject;

alter table Mark
add column ExamTimes tinyint default 1;

insert into Mark(SubID,StudentID,Mark,ExamTimes)
values(1,1,8,1),
(1,2,10,2),
(2,1,12,1);	

select * from Mark;

delete from Mark;


