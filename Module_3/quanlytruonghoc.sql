/*Dùng các hàm gộp*/
-- Câu 1: Cho biết số lượng giáo viên của toàn trường
select count(MaGV) as SoLuongGiaoVien from giaovien;
-- Câu 2: Cho biết số lượng giáo viên của bộ môn HTTT
select count(MaGV) as SoLuongGiaoVienHTTT from giaovien where MABM = 'HTTT';
-- Câu 3: Tính số lượng giáo viên có người quản lý về mặt chuyên môn
select count(MaGV) as SoLuongGiaoVienQLCM from giaovien where GVQLCM = MAGV;
-- Câu 4: Tính số lượng giáo viên làm nhiệm vụ quản lý chuyên môn cho giáo viên khác mà thuộc bộ môn HTTT.
select count(MaGV) as SoLuongGiaoVienQLCMHTTT from giaovien where GVQLCM is not null and MABM = 'HTTT';
-- Câu 5:  Tính lương trung bình của giáo viên bộ môn Hệ thống thông tin
select MABM, cast(avg(LUONG) as decimal(9,0)) as avgLuongHTTT from giaovien where MABM = 'HTTT';
/*Dùng group by*/
-- Câu 6: Với mỗn bộ môn cho biết bộ môn (MAMB) và số lượng giáo viên của bộ môn đó.
select MABM, count(MAGV) from giaovien group by MABM;
-- Câu 7: Với mỗi giáo viên, cho biết MAGV và số lượng công việc mà giáo viên đó có tham gia.
select GV.MAGV , HOTEN, count(MADT) as SoLuongCongViec
from giaovien GV 	
	right join thamgiadt TGDT on GV.MAGV = TGDT.MAGV 
group by GV.MAGV
order by GV.MAGV asc;
-- Câu 8: Với mỗi giáo viên, cho biết MAGV và số lượng đề tài mà giáo viên đó có tham gia.
select GV.MAGV , HOTEN, count(distinct MADT) as SoLuongDeTai
from giaovien GV 
	left join thamgiadt TGDT on GV.MAGV = TGDT.MAGV
group by GV.MAGV
order by GV.MAGV asc;
-- Câu 9:  Với mỗi bộ môn, cho biết số đề tài mà giáo viên của bộ môn đó chủ trì
select bm.MABM, bm.TENBM, count(distinct MADT) as SoLuongDeTai
from giaovien gv join thamgiadt tgdt on gv.MAGV = tgdt.MAGV right join bomon bm on gv.MABM = bm.MABM
group by bm.MABM;
-- ???????????
-- Câu 10: Với mỗn bộ môn cho biết tên bộ môn và số lượng giáo viên của bộ môn đó.
select gv.MABM, bm.TENBM, count(MAGV) as SoLuongGiaoVien
from giaovien gv join bomon bm on gv.MABM = bm.MABM
group by gv.MABM;
/*Dùng GROUP BY + HAVING*/
-- Câu 11: Cho biết những bộ môn từ 2 giáo viên trở lên.
select MABM
from  giaovien
group by MABM
having count(MAGV) >= 2;
-- Câu 12: Cho tên những giáo viên và số lượng đề tài của những GV tham gia từ 2 đề tài trở lên.
select *, count(distinct MADT) as SoLuongDeTai
from giaovien gv join thamgiadt tgdt on gv.MAGV = tgdt.MAGV
group by HOTEN
having count(distinct MADT) >= 2;
-- K hiệu quả
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- Hiệu quả
SET sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));
-- Câu 13: Cho biết số lượng đề tài được thực hiện trong từng năm.
-- ???????????????
/************************************************A/
/*Dùng truy vấn con + mệnh đề SELECT*/
-- Câu A1: Với mỗi bộ môn, cho biết tên bộ môn và số lượng giáo viên của bộ môn đó.
select gv.MABM, bm.TENBM, count(MAGV) as SoLuongGiaoVien
from giaovien gv join bomon bm on gv.MABM = bm.MABM
group by gv.MABM;
/*Dùng truy vấn con + mệnh đề FROM*/
-- Câu A2: Cho biết họ tên và lương của các giáo viên bộ môn HTTT
select HOTEN, LUONG, MABM
from giaovien
where MABM = 'HTTT';
/*Dùng truy vấn con + mệnh đề WHERE*/
-- Câu A3: Cho biết những giáo viên có lương lớn hơn lương của giáo viên có MAGV=‘001’
select HOTEN, LUONG, (select LUONG from giaovien where MAGV = '001') as LuongCua001
from giaovien
where LUONG > (select LUONG from giaovien where MAGV = '001');
-- Câu A4: Cho biết họ tên những giáo viên mà không có một người thân nào
-- -- Cách 1
select *
from giaovien gv 
where gv.MAGV not in (select nt.MAGV from nguoithan nt);
-- -- Cách 2
select *
from giaovien gv left join nguoithan nt on gv.MAGV = nt.MAGV
where nt.MAGV is null;
-- -- Cách 3
select *
from giaovien gv
where not exists (select * from nguoithan nt where nt.MAGV = gv.MAGV);
-- Câu A5: Cho những giáo viên có tham gia đề tài
select *
from giaovien gv join thamgiadt tgdt on gv.MAGV = tgdt.MAGV
group by gv.MAGV;
-- Câu A6: Cho những giáo viên có lương nhỏ nhất
select *
from giaovien
where LUONG = (select min(LUONG) from giaovien);
-- Câu A7: Cho những giáo viên có lương cao hơn tất cả các giáo viên của bộ môn HTTT
select *
from giaovien
where LUONG > all (select LUONG from giaovien where MABM = 'VS');
-- Câu A8: Cho biết bộ môn (MABM) có đông giáo viên nhất
select temp.MABM, max(temp.slgv) as SLGV
from (select MABM, count(MAGV) as slgv
from giaovien
group by MABM) temp;
-- Câu A9: Cho biết họ tên những giáo viên mà không có một người thân nào. (Sử dụng ALL thay vì NOT IN)
-- 
-- Câu A10: Cho biết họ tên những giáo viên có tham gia đề tài. (Sử dụng = ANY thay vì IN)
-- 
-- Câu A11: Cho biết các giáo viên có tham gia đề tài.
--
-- Câu A12: Cho biết các giáo viên không có người thân
--
-- Câu A14: Cho biết những giáo viên có lương lớn hơn lương trung bình của bộ môn mà giáo viên đó làm việc.
select *
from giaovien gv, (	select MABM, avg(LUONG) as luongtb
					from giaovien
					group by MABM) temp
where LUONG > temp.luongtb and gv.MABM = temp.MaBM;
-- Câu A15: Cho biết những giáo viên có lương lớn nhất
--
-- Câu A16: Cho biết những đề tài mà giáo viên ‘001’ không tham gia.
select *
from detai dt, (select *
				from thamgiadt tgdt
				where tgdt.MAGV = '001') temp
where dt.MADT != temp.MADT
group by dt.MADT;
-- Câu A17: Cho biết họ tên những giáo viên có vai trò quản lý về mặt chuyên môn với các giáo viên khác
--
-- Câu A18: Cho biết những giáo viên có lương lớn nhất.
--
-- Câu A19: Cho biết những bộ môn (MABM) có đông giáo viên nhấ
--
-- Câu A20: Cho biết những tên bộ môn, họ tên của trưởng bộ môn và số lượng giáo viên của bộ môn có đông giáo viên nhất
select temp.MABM, TRUONGBM, max(temp.slgv) as SLGV
from bomon, (	select MABM, count(MAGV) as slgv
				from giaovien
				group by MABM) temp;
-- Câu A21: Cho biết những giáo viên có lương lớn hơn mức lương trung bình của giáo viên bộ môn Hệ thống thông tin mà không trực thuộc bộ môn hệ thống thông tin
select avg(LUONG)
from giaovien gv
where gv.MABM = 'HTTT'; 
select gv.MAGV, gv.LUONG, gv.MABM
from giaovien gv
where LUONG > (select avg(LUONG) from giaovien gv where gv.MABM = 'HTTT') and gv.MABM != 'HTTT';
-- Câu A22: Cho tên biết đề tài có đông giáo viên tham gia nhất viên bộ môn Hệ thống thông tin mà không trực thuộc bộ môn hệ thống thông tin
-- :)
/************************************************/
-- Câu B2: Tìm các giáo viên không tham gia đề tài nào
--
-- Câu B3: Tìm các giáo viên vừa tham gia đề tài vừa là trưởng bộ môn.
--
-- Câu B4: Liệt kê những giáo viên có tham gia đề tài và những giáo viên là trưởng bộ môn.
-- Câu B5: Tìm các giáo viên (MAGV) mà tham gia tất cả các đề tài
--
-- Câu B6: Tìm các giáo viên (MAGV) mà tham gia tất cả các đề tài (Dùng NOT EXISTS)
--
-- Câu B9: Tìm tên các giáo viên ‘HTTT’ mà tham gia tất cả các đề tài thuộc chủ đề ‘QLGD
select gv.MAGV, gv.MABM, dt.MACD
from giaovien gv join thamgiadt tgdt on gv.MAGV = tgdt.MAGV join detai dt on tgdt.MADT = dt.MADT
where MABM = 'HTTT' and MACD = 'QLGD'
group by gv.MAGV;
-- ADVANCED
-- Cho biết tên giáo viên và tên của giáo viên có nhiều người thân nhất
--
-- Cho biết tên của giáo viên lớn tuổi nhất của bộ môn hệ thống thông tin
--
-- Cho biết tên những đề tài mà giáo viên Nguyễn Hoài An chưa tham gia
--
-- Cho biết tên của giáo viên chủ nhiệm nhiều đề tài nhất.
--
-- Cho biết tên giáo viên và tên bộ môn của giáo viên tham gia nhiều đề tài nhất
--
-- Cho biết tên đề tài nào mà được tất cả giáo viên của bộ môn hóa hữu cơ tham gia
--
