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

select * from subject where credit < 10;

select * from Mark;

delete from Mark;

select * from class;

select * from student where status = true;

select student.StudentID, student.StudentName, class.ClassName from student right join Class on student.ClassID = class.classID
where class.className = 'A1';

select student.StudentID, student.StudentName, subject.subname, mark.Mark 
from student inner join Mark on student.studentID = mark.studentID
 join subject on subject.SubID = mark.SubID
where subject.subname = 'CF';

select * from student where StudentName not like "h%";
    
select * from class where month(startDate) = 12;
    
select * from subject where Credit between 3 and 5;

select * from student;

update student 
SET ClassID = 2 where StudentID = 1; 

select student.StudentName, subject.SubName, Mark.mark from mark inner join student on  mark.StudentId = student.studentID
inner join subject on mark.subid = subject.subid
order by mark desc, studentName desc;

select * from student;
select address, count(studentID) as 'số lượng học viên'
from student group by address;

select * from mark;
select student.studentname,student.studentid, avg(mark.mark) as 'diemtrungbinh'
from student inner join mark on student.studentid = mark.studentid group by student.studentid;

select student.studentname,student.studentid, avg(mark.mark) as 'diemtrungbinh'
from student inner join mark on student.studentid = mark.studentid group by student.studentid
having avg(mark.mark) >= all(select avg(mark.mark) from mark group by Mark.studentid);

select * from student;
select * from subject where Credit >= all (select credit from subject);

select student.StudentName, avg(mark.mark) as 'diemtrungbinh'
from student inner join mark on student.studentid = mark.studentid group by student.studentid
order by avg(mark.mark) asc;

create view student_view as
select studentName,address from student;

select * from student_view;
update  student_view
set studentName = 'Hoang' where studentName = 'Hung';

delete from student_view
where address = 'Ha Noi';	

drop view student_view;

select * from student;

select * from student where address = 'Ha Noi';

explain select * from student where address ='Ha Noi';

alter table student add unique index_address(`studentName`);

explain select * from student where studentName ='Hoang';

alter table student drop index studentName;

SHOW INDEX FROM classID_index;

explain select * from student where studentID = 1;

CREATE UNIQUE INDEX student_index ON student(studentID);
alter table student
drop index `primary` ;

CREATE PROCEDURE allrecord(IN value1 int,OUT value2 int)
BEGIN
select * student
END
DELIMITER ;


