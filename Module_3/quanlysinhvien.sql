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
