SELECT * FROM quanlidetai.giaovien;
SELECT * FROM GIAOVIEN;
-- Q1. Cho biết họ tên và mức lương của các giáo viên nữ.
select MAGV,HOTEN,LUONG from giaovien where PHAI = 'nữ';

-- Q2. Cho biết họ tên của các giáo viên và lương của họ sau khi tăng 10%.

select HOTEN,LUONG, luong*1.1 as 'Lương sau khi tăng 10%' from giaovien;

-- Q3. Cho biết mã của các giáo viên có họ tên bắt đầu là “Nguyễn” và lương trên $2000 hoặc, 
-- giáo viên là trưởng bộ môn nhận chức sau năm 1995.
SELECT * FROM GIAOVIEN;

select distinct MAGV, HOTEN, luong from GIAOVIEN join bomon
on (HOTEN like 'Nguyễn%' and luong > 2000) or
( magv = TRUONGBM and
year(ngaynhanchuc) > 1995);

-- Q4. Cho biết tên những giáo viên khoa Công nghệ thông tin

select distinct g.hoten, g.maBM from giaovien g inner join bomon b on g.maBM = b.maBM 
where b.makhoa = 'CNTT';

-- Q5. Cho biết thông tin của bộ môn cùng thông tin giảng viên làm trưởng bộ môn đó.
select * from giaovien;

select * from giaovien g inner join bomon b on g.magv = b.TRUONGBM;

-- Q6. Với mỗi giáo viên, hãy cho biết thông tin của bộ môn mà họ đang làm việc.

select g.magv, g.hoten, g.phai, g.ngsinh,g.diachi, b.mabm, b.tenbm from bomon b inner join giaovien g on b.mabm = g.mabm;

-- Q7. Cho biết tên đề tài và giáo viên chủ nhiệm đề tài.

select d.madt,d.tendt,g.hoten as 'GVCNDT' from detai d inner join giaovien g on d.GVCNDT = g.magv; 

-- Q8. Với mỗi khoa cho biết thông tin trưởng khoa.

select k.makhoa,k.tenkhoa,g.hoten as 'trưởng khoa' from khoa k inner join giaovien g on k.truongkhoa = g.magv;

-- Q9. Cho biết các giáo viên của bộ môn “Vi sinh” có tham gia đề tài 006.
select * from detai;
select distinct g.hoten as 'giáo viên bộ môn "Vi Sinh" tham gia'
 from giaovien g 
inner join thamgiadt t on g.magv = t.magv
 where g.MABM = 'VS' and t.MADT = 006;

-- Q10. Với những đề tài thuộc cấp quản lý “Thành phố”, cho biết mã đề tài, đề tài thuộc về chủ đề nào, họ tên
-- người chủ nghiệm đề tài cùng với ngày sinh và địa chỉ của người ấy.

select dt.madt, dt.tendt, dt.macd, chude.tencd, gv.hoten, gv.ngsinh, gv.diachi from detai dt 
 join giaovien gv on dt.GVCNDT = gv.MAgv
 join chude on dt.macd = chude.macd;
 
-- Q11. Tìm họ tên của từng giáo viên và người phụ trách chuyên môn trực tiếp của giáo viên đó.

select gv.hoten,gv.gvqlcm, gv1.hoten as 'người phục trách chuyển môn' from giaovien gv left join giaovien gv1 on gv.GVQLCM = gv1.magv; 

SELECT GV.MAGV, GV.HOTEN, GV.GVQLCM, (SELECT GV1.HOTEN FROM GIAOVIEN GV1 WHERE GV1.MAGV = GV.GVQLCM) AS 'TEN NGUOI QL'
FROM GIAOVIEN GV;

-- Q12. Tìm họ tên của những giáo viên được “Nguyễn An Trung” phụ trách trực tiếp.
SELECT * FROM quanlidetai.giaovien;

select gv.magv,gv.hoten,gv.gvqlcm,(SELECT GV1.HOTEN FROM GIAOVIEN GV1 WHERE GV1.MAGV = GV.GVQLCM) as 'Người phụ trách trực tiếp'
from giaovien gv where gv.GVQLCM = (select gv1.MAGV from giaovien gv1
where gv1.hoten = 'Nguyễn An Trung');

-- Q13. Cho biết tên giáo viên là trưởng bộ môn Hệ thống thông tin.

select gv.magv, gv.hoten as 'giáo viên trưởng bộ môn Hệ thống thông tin' from giaovien gv join bomon bm on gv.magv = bm.truongbm
where bm.tenbm = 'Hệ thống thông tin';

-- Q14. Cho biết tên người chủ nhiệm đề tài của những đề tài thuộc chủ đề Quản lý giáo dục.

select dt.madt, dt.tendt, dt.macd, gv.hoten as 'Giáo viên chủ nhiệm' from detai dt join giaovien gv on gv.magv = dt.GVCNDT
where dt.macd = 'QLGD';

-- Q15. Cho biết tên các công việc của đề tài HTTT quản lý các trường ĐH có thời gian bắt đầu trong tháng 3/2008.

select cv.tencv,cv.ngaybd from congviec cv join detai dt on cv.madt = dt.madt
where dt.tendt = 'HTTT quản lý các trường ĐH' and MONTH(cv.NGAYBD) = 03;

-- Q16. Cho biết tên giáo viên và tên người quản lý chuyên môn của giáo viên đó.
SELECT * FROM congviec;
select gv.magv,gv.hoten, (select gv1.hoten from giaovien gv1 where gv.GVQLCM = gv1.magv ) as 'người quản lí chuyên môn' from giaovien gv;

-- Q17. Cho biết các công việc bắt đầu trong khoảng từ 01/01/2007 đến 01/08/2007.

select cv.tencv,cv.ngaybd from congviec cv
where cv.ngaybd between '2007-01-01' and '2007-08-01';

select cv.tencv,cv.ngaybd from congviec cv
where datediff('2007-08-01',cv.ngaybd) <213 and datediff('2007-08-01',cv.ngaybd)>=0;

select cv.tencv,cv.ngaybd from congviec cv
where datediff('2007-08-01',cv.ngaybd) between 0 and 212;

-- Q18. Cho biết họ tên các giáo viên cùng bộ môn với giáo viên “Trần Trà Hương”.
SELECT * FROM quanlidetai.giaovien;
select gv1.magv,gv1.hoten,gv1.mabm from giaovien gv1 where gv1.mabm = (select gv.mabm from giaovien gv where gv.hoten = 'Trần Trà Hương')
and not (gv1.hoten  = 'Trần Trà Hương');

-- Q19. Tìm những giáo viên vừa là trưởng bộ môn vừa chủ nhiệm đề tài.

select gv.magv,gv.hoten, bm.truongbm, dt.gvcndt from giaovien gv 
join bomon bm on gv.magv = bm.truongbm
join detai dt on dt.GVCNDT = gv.magv;

select distinct gv.magv,gv.hoten, bm.truongbm, bm.tenbm, dt.gvcndt, dt.tendt from giaovien gv 
join bomon bm 
join detai dt 
where gv.magv = bm.truongbm and gv.magv = dt.GVCNDT;

-- Q20. Cho biết tên những giáo viên vừa là trưởng khoa và vừa là trưởng bộ môn.

select distinct gv.magv,gv.hoten, bm.truongbm, bm.tenbm as 'tên bộ môn' from giaovien gv 
join bomon bm 
join khoa k
where gv.magv = bm.truongbm and gv.magv = k.truongkhoa;

-- Q27. Cho biết số lượng giáo viên viên và tổng lương của họ.
SELECT * FROM quanlidetai.giaovien;
select count(gv.magv) as 'số lượng giáo viên', sum(gv.luong) as 'tổng lương' from giaovien gv;

-- Q28. Cho biết số lượng giáo viên và lương trung bình của từng bộ môn.

select bm.tenbm, count(gv.mabm) as 'số lượng giáo viên', avg(gv.luong) as 'lương trung bình từng bộ môn' from giaovien gv join bomon bm
on gv.mabm = bm.mabm
group by gv.mabm;

-- Q29. Cho biết tên chủ đề và số lượng đề tài thuộc về chủ đề đó.

select cd.macd,cd.tencd, count(dt.macd) from chude cd
 join detai dt on dt.macd = cd.macd
 group by dt.macd;
 
 -- Q30. Cho biết tên giáo viên và số lượng đề tài mà giáo viên đó tham gia.
 
 select gv.magv, gv.hoten, count(tg.magv) as 'số lượng đề tài tham gia' from giaovien gv
 join thamgiadt tg on gv.magv = tg.magv
 group by tg.magv;
 
 -- Q31. Cho biết tên giáo viên và số lượng đề tài mà giáo viên đó làm chủ nhiệm.
 
 select gv.magv, gv.hoten, count(dt.GVCNDT) 'số lượng đề tài mà giáo viên làm chủ nhiệm' from giaovien gv 
 join detai dt on gv.magv = dt.GVCNDT
 group by dt.GVCNDT;
 
 -- Q32. Với mỗi giáo viên cho tên giáo viên và số người thân của giáo viên đó.
 
 select gv.magv, gv.hoten, count(ng.magv) 'số lượng người thân' from giaovien gv
 join nguoithan ng on gv.magv = ng.magv
 group by ng.magv;
 
 -- Q33. Cho biết tên những giáo viên đã tham gia từ 3 đề tài trở lên.
 
 select gv.magv, gv.hoten, count(tg.magv) as 'số lượng đề tài tham gia từ 3 trở lên' from giaovien gv
 join thamgiadt tg on gv.magv = tg.magv
 group by tg.magv
 having count(tg.magv) >=3;
 
 -- Q34. Cho biết số lượng giáo viên đã tham gia vào đề tài Ứng dụng hóa học xanh.
 
 select dt.madt, dt.tendt, count(tg.madt) 'số lượng giáo viên tham gia' from detai dt
  join thamgiadt tg on dt.madt = tg.madt
 where dt.tendt = 'Ứng dụng hóa học xanh'
 group by  tg.madt;
 
  select dt.madt, dt.tendt, count(tg.madt) 'số lượng giáo viên tham gia' from detai dt
join thamgiadt tg on dt.madt = tg.madt
 group by  tg.madt;
 
select dt.madt, dt.tendt,'số lượng giáo viên tham gia' from detai dt;
   
 -- Q35. Cho biết mức lương cao nhất của các giảng viên.
 SELECT * FROM quanlidetai.giaovien;
 
 select distinct gv.luong 'lương cao nhất' from giaovien gv
where gv.luong >= all(select luong from giaovien);

-- Q36. Cho biết những giáo viên có lương lớn nhất.
 
 select gv.magv,gv.hoten,gv.luong from giaovien gv
where gv.luong >= all(select luong from giaovien);

-- Q37. Cho biết lương cao nhất trong bộ môn “HTTT”.

 select gv.magv,gv.hoten,gv.luong from giaovien gv
where gv.mabm = 'HTTT' and 
gv.luong >= all(select luong from giaovien);

-- Q38. Cho biết tên giáo viên lớn tuổi nhất của bộ môn Hệ thống thông tin.

select gv.magv, gv.hoten, gv.ngsinh from giaovien gv 
where gv.mabm = 'HTTT'
and gv.ngsinh = (select MIN(gv1.ngsinh) from giaovien gv1 where gv1.mabm = 'HTTT');

-- Q40. Cho biết tên giáo viên và tên khoa của giáo viên có lương cao nhất.

select  gv.magv,gv.hoten,gv.luong,khoa.tenkhoa,khoa.makhoa from giaovien gv
join bomon bm on gv.mabm = bm.mabm
join khoa on khoa.makhoa = bm.makhoa
where gv.luong >= all (select luong from giaovien);

-- Q41. Cho biết những giáo viên có lương lớn nhất trong bộ môn của họ.

select distinct gv.mabm from giaovien gv;

select * from giaovien gv
join
(select MAX(gv1.LUONG) as luong, gv1.mabm from giaovien gv1
GROUP BY gv1.mabm) as temp
 where temp.mabm = gv.mabm and temp.luong = gv.luong;
 
 -- Q42. Cho biết tên những đề tài mà giáo viên Nguyễn Hoài An chưa tham gia.
 
 select dt.madt, dt.tendt from detai dt
 where dt.madt not in (select tg.madt from thamgiadt tg
				 join giaovien gv on gv.magv = tg.magv 
				 where gv.hoten = 'Nguyễn Hoài An');
                 
-- Q43. Cho biết những đề tài mà giáo viên Nguyễn Hoài An chưa tham gia. Xuất ra tên đề tài, tên người chủ nhiệm đề tài.
 
  select dt.madt, dt.tendt, dt.gvcndt, gv.hoten 'giáo viên chủ nhiệm đề tài' from detai dt
  join giaovien gv on dt.gvcndt = gv.magv
 where dt.madt not in (select tg.madt from thamgiadt tg
				 join giaovien gv on gv.magv = tg.magv 
				 where gv.hoten = 'Nguyễn Hoài An');

-- Q44. Cho biết tên những giáo viên khoa Công nghệ thông tin mà chưa tham gia đề tài nào.

select distinct gv.magv, gv.hoten from giaovien gv join thamgiadt tg on gv.magv = tg.magv
where tg.magv not in
(select gv.magv from giaovien gv
join bomon bm on gv.mabm = bm.mabm
join khoa on khoa.makhoa = bm.makhoa
where khoa.tenkhoa = 'Công nghệ thông tin');

select giaovien.hoten, khoa.tenkhoa
from giaovien
join khoa on giaovien.magv = khoa.truongkhoa
 where khoa.tenkhoa = 'Sinh học' and giaovien.magv  not in (select thamgiadt.magv
from thamgiadt
join khoa on thamgiadt.magv = khoa.truongkhoa
where khoa.tenkhoa = 'Sinh học');

-- tìm tên giáo viên có trong hệ thống

select gv.hoten from giaovien gv
where gv.hoten = 'Nguyễn Hoài An';



























--  giáo viên vừa tham gia đề tài vừa là trưởng bộ môn


select distinct tg.magv, gv.hoten, bm.tenbm,dt.tendt from thamgiadt tg
join bomon bm on bm.truongbm = tg.magv
join giaovien gv on gv.magv = tg.magv
join detai dt on dt.madt = tg.madt;

select distinct gv.magv,gv.hoten, bm.tenbm,dt.tendt from giaovien gv 
join bomon bm 
join thamgiadt tg
join detai dt
where bm.truongbm = gv.magv and bm.truongbm = tg.magv and tg.madt= dt.madt;

-- Cho biết tên những đề tài mà giáo viên Nguyễn Hoài An  tham gia

select distinct gv.magv,tg.madt,dt.tendt from giaovien gv 
join thamgiadt tg on gv.magv = tg.magv
join detai dt on tg.madt = dt.madt
where gv.hoten = 'Nguyễn Hoài An';

-- -- Cho biết tên những đề tài mà giáo viên Nguyễn Hoài An chưa tham gia

select DISTINCT dt.tendt
from detai dt
where dt.madt not in (
select DISTINCT tg.madt
from giaovien gv join thamgiadt tg on gv.magv = tg.MAGV
where gv.hoten like 'Nguyễn Hoài An'
);

 -- Cho biết tên giáo viên và tên bộ môn của giáo viên tham gia nhiều đề tài nhất
 
SELECT * FROM quanlidetai.thamgiadt;
select  tg.magv, gv.hoten, bm.tenbm, count(distinct tg.madt) ' số lượng mã đề tài' from thamgiadt tg
join giaovien gv on gv.magv = tg.magv
join bomon bm on bm.mabm = gv.mabm
group by tg.magv
having count(distinct tg.madt) >= all(
select count(distinct tg.madt) from thamgiadt tg
group by tg.magv)
;

 select tg.magv, gv.hoten, bm.tenbm, count(distinct tg.madt) as 'số lượng đề tài' from thamgiadt tg
 join giaovien gv on gv.magv = tg.magv
 join bomon bm on bm.mabm = gv.mabm
 group by tg.magv
 having count(distinct tg.madt) >= all
  (select count(distinct tg.madt)  from thamgiadt tg
 group by tg.magv)
 ;
 
 
 
 



 