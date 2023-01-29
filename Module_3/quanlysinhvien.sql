select *
from student;

select *
from student
where StudentName like 'h%';

select *
from student S join class C on S.ClassId = C.ClassID
where month(StartDate) = 12;

select *
from subject
where Credit>=3 and Credit<=5; 

update student
set classId = 2
where StudentName = 'Hung';

select S.StudentName, Sub.SubName, M.Mark
from student S join mark M on S.StudentId = M.StudentId join subject Sub on M.SubId = Sub.SubId
order by mark desc; 

-- Sử dụng các hàm thông dụng

SELECT Address, COUNT(StudentId) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 15;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);

select *
from student S join mark M on S.StudentId = M.StudentId join subject Sub on M.SubId = Sub.SubId;

-- Luyện tập các hàm thông dụng

select *
from subject
where credit = (select max(credit) from subject)






