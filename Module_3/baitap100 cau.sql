-- Q1. Cho biết họ tên và mức lương của các giáo viên nữ.
select * from giaovien where PHAI = 'nu';
-- Q2. Cho biết họ tên của các giáo viên và lương của họ sau khi tăng 10%.
select HOTEN, LUONG*1.1 as Luong10 from giaovien; 
-- Q3. Cho biết mã của các giáo viên có họ tên bắt đầu là “Nguyễn” và lương trên $2000 hoặc, giáo viên là trưởng bộ môn nhận chức sau năm 1995.
select gv.MAGV, gv.HOTEN, gv.LUONG, gv.GVQLCM, k.NGAYNHANCHUC
from giaovien gv left join khoa k on gv.GVQLCM = k.TRUONGKHOA
where (HOTEN like 'Nguyễn%' and LUONG > 2000) or (GVQLCM != null and year(k.NGAYNHANCHUC) > 1995);
-- Q4. Cho biết tên những giáo viên khoa Công nghệ thông tin.
select * from giaovien where MABM = 'CNTT';
-- Q5. Cho biết thông tin của bộ môn cùng thông tin giảng viên làm trưởng bộ môn đó.
select * from bomon;
-- Q6. Với mỗi giáo viên, hãy cho biết thông tin của bộ môn mà họ đang làm việc.
select gv.HOTEN, bm.TENBM
from giaovien gv join bomon bm on gv.MABM = bm.MABM;
-- Q7. Cho biết tên đề tài và giáo viên chủ nhiệm đề tài.
select dt.TENDT, gv.HOTEN as GVCNDT
from detai dt join giaovien gv on dt.GVCNDT = gv.MAGV;
-- Q8. Với mỗi khoa cho biết thông tin trưởng khoa.
select TENKHOA, gv.HOTEN as TRUONGKHOA
from khoa k join giaovien gv on k.TRUONGKHOA = gv.MAGV;
-- Q9. Cho biết các giáo viên của bộ môn “Vi sinh” có tham gia đề tài 006.
select gv.MAGV, gv.HOTEN, tgdt.MADT
from giaovien gv join thamgiadt tgdt on gv.MAGV = tgdt.MAGV
where tgdt.MADT = '006'
group by gv.MAGV;
-- Q10. Với những đề tài thuộc cấp quản lý “Thành phố”, cho biết mã đề tài, đề tài thuộc về chủ đề nào, họ tên
-- người chủ nghiệm đề tài cùng với ngày sinh và địa chỉ của người ấy.
select dt.MADT, dt.TENDT, dt.CAPQL, cd.TENCD, gv.HOTEN, gv.NGSINH, gv.DIACHI
from detai dt join chude cd on dt.MACD = cd.MACD
				join giaovien gv on dt.GVCNDT = gv.MAGV
where dt.CAPQL = 'ĐHQG' ;
-- Q11. Tìm họ tên của từng giáo viên và người phụ trách chuyên môn trực tiếp của giáo viên đó.
select gv1.HOTEN, gv2.HOTEN as GVQLCM
from giaovien gv1 join giaovien gv2 on gv1.GVQLCM = gv2.MAGV;
-- Q12. Tìm họ tên của những giáo viên được “Nguyễn Thanh Tùng” phụ trách trực tiếp.
select gv1.HOTEN, gv2.HOTEN as GVQLCM
from giaovien gv1 join giaovien gv2 on gv1.GVQLCM = gv2.MAGV
where gv2.HOTEN = 'Nguyễn An Trung';
-- Q13. Cho biết tên giáo viên là trưởng bộ môn Hệ thống thông tin.
select bm.TENBM, gv.HOTEN as TRUONGBM
from bomon bm join giaovien gv on bm.TRUONGBM = gv.MAGV
where bm.MABM = 'CNTT';
-- Q14. Cho biết tên người chủ nhiệm đề tài của những đề tài thuộc chủ đề Quản lý giáo dục.
select *
from detai dt join giaovien gv on dt.GVCNDT = gv.MAGV
where MACD = 'QLGD';
-- Q15. Cho biết tên các công việc của đề tài HTTT quản lý các trường ĐH có thời gian bắt đầu trong tháng 3/2008.
select TENDT, NGAYBD
from detai
where NGAYBD > 2008-03-01 and NGAYBD < 2002-03-31;
-- Q16. Cho biết tên giáo viên và tên người quản lý chuyên môn của giáo viên đó.
-- Q11
-- Q17. Cho các công việc bắt đầu trong khoảng từ 01/01/2007 đến 01/08/2007.
select *
from congviec
where NGAYBD > '2007-01-01' and NGAYBD < '2007-8-1' ;
-- Q18. Cho biết họ tên các giáo viên cùng bộ môn với giáo viên “Trần Trà Hương”.
select HOTEN, MABM
from giaovien
where MABM = (select MABM from giaovien where HOTEN = 'Trần Trà Hương');
-- Q19. Tìm những giáo viên vừa là trưởng bộ môn vừa chủ nhiệm đề tài.
select HOTEN
from giaovien gv join thamgiadt tgdt on gv.MAGV = tgdt.MAGV join bomon bm on gv.MAGV = bm.TRUONGBM
group by HOTEN;
-- Q20. Cho biết tên những giáo viên vừa là trưởng khoa và vừa là trưởng bộ môn.
select HOTEN
from giaovien gv join bomon bm on gv.MAGV = bm.TRUONGBM join khoa k on gv.MAGV = k.TRUONGKHOA;
-- Q21. Cho biết tên những trưởng bộ môn mà vừa chủ nhiệm đề tài
-- Q19
-- Q22. Cho biết mã số các trưởng khoa có chủ nhiệm đề tài.
select TRUONGKHOA
from khoa k join thamgiadt tgdt on k.TRUONGKHOA = tgdt.MAGV
group by TRUONGKHOA;
-- Q23. Cho biết mã số các giáo viên thuộc bộ môn HTTT hoặc có tham gia đề tài mã 001.
-- Q9
-- Q24. Cho biết giáo viên làm việc cùng bộ môn với giáo viên 002.
select HOTEN
from giaovien
where MABM = (select MABM from giaovien where MAGV = '002');
-- Q25. Tìm những giáo viên là trưởng bộ môn.
--
-- Q26. Cho biết họ tên và mức lương của các giáo viên.
--
-- Q27. Cho biết số lượng giáo viên viên và tổng lương của họ.
-- 
-- Q28. Cho biết số lượng giáo viên và lương trung bình của từng bộ môn.
select MABM, count(MAGV) as SLGV, avg(LUONG) as LUONGTB
from giaovien
group by MABM;
-- Q29. Cho biết tên chủ đề và số lượng đề tài thuộc về chủ đề đó.
select TENCD, count(TENDT) as SLDT
from detai dt join chude cd on dt.MACD = cd.MACD
group by TENCD;
-- Q30. Cho biết tên giáo viên và số lượng đề tài mà giáo viên đó tham gia.
select HOTEN, count(MADT) as SLDT
from giaovien gv join thamgiadt tgdt on gv.MAGV = tgdt.MAGV
group by HOTEN;
Q31. Cho biết tên giáo viên và số lượng đề tài mà giáo viên đó làm chủ nhiệm.

Q32. Với mỗi giáo viên cho tên giáo viên và số người thân của giáo viên đó.

Q33. Cho biết tên những giáo viên đã tham gia từ 3 đề tài trở lên.

Q34. Cho biết số lượng giáo viên đã tham gia vào đề tài Ứng dụng hóa học xanh.Q35. Cho biết mức lương cao nhất của các giảng viên.

Q36. Cho biết những giáo viên có lương lớn nhất.

Q37. Cho biết lương cao nhất trong bộ môn “HTTT”.

Q38. Cho biết tên giáo viên lớn tuổi nhất của bộ môn Hệ thống thông tin.

Q39. Cho biết tên giáo viên nhỏ tuổi nhất khoa Công nghệ thông tin.

Q40. Cho biết tên giáo viên và tên khoa của giáo viên có lương cao nhất.

Q41. Cho biết những giáo viên có lương lớn nhất trong bộ môn của họ.

Q42. Cho biết tên những đề tài mà giáo viên Nguyễn Hoài An chưa tham gia.

Q43. Cho biết những đề tài mà giáo viên Nguyễn Hoài An chưa tham gia. Xuất ra tên đề tài, tên người chủ nhiệm đề tài.

Q44. Cho biết tên những giáo viên khoa Công nghệ thông tin mà chưa tham gia đề tài nào.

Q45. Tìm những giáo viên không tham gia bất kỳ đề tài nàoQ46. Cho biết giáo viên có lương lớn hơn lương của giáo viên “Nguyễn Hoài An”

Q47. Tìm những trưởng bộ môn tham gia tối thiểu 1 đề tài

Q48. Tìm giáo viên trùng tên và cùng giới tính với giáo viên khác trong cùng bộ môn

Q49. Tìm những giáo viên có lương lớn hơn lương của ít nhất một giáo viên bộ môn “Công nghệ phần mềm”

Q50. Tìm những giáo viên có lương lớn hơn lương của tất cả giáo viên thuộc bộ môn “Hệ thống thông tin”

Q51. Cho biết tên khoa có đông giáo viên nhất

Q52. Cho biết họ tên giáo viên chủ nhiệm nhiều đề tài nhất

Q53. Cho biết mã bộ môn có nhiều giáo viên nhất

Q54. Cho biết tên giáo viên và tên bộ môn của giáo viên tham gia nhiều đề tài nhất.

Q55. Cho biết tên giáo viên tham gia nhiều đề tài nhất của bộ môn HTTT.

Q56. Cho biết tên giáo viên và tên bộ môn của giáo viên có nhiều người thân nhất.

Q57. Cho biết tên trưởng bộ môn mà chủ nhiệm nhiều đề tài nhất.

Q58. Cho biết tên giáo viên nào mà tham gia đề tài đủ tất cả các chủ đề.

Q59. Cho biết tên đề tài nào mà được tất cả các giáo viên của bộ môn HTTT tham gia.

Q60. Cho biết tên đề tài có tất cả giảng viên bộ môn “Hệ thống thông tin” tham gia

Q61. Cho biết giáo viên nào đã tham gia tất cả các đề tài có mã chủ đề là QLGD.

Q62. Cho biết tên giáo viên nào tham gia tất cả các đề tài mà giáo viên Trần Trà Hương đã tham gia.

Q63. Cho biết tên đề tài nào mà được tất cả các giáo viên của bộ môn Hóa Hữu Cơ tham gia.

Q64. Cho biết tên giáo viên nào mà tham gia tất cả các công việc của đề tài 006.

Q65. Cho biết giáo viên nào đã tham gia tất cả các đề tài của chủ đề Ứng dụng công nghệ.

Q66. Cho biết tên giáo viên nào đã tham gia tất cả các đề tài của do Trần Trà Hương làm chủ nhiệm.

Q67. Cho biết tên đề tài nào mà được tất cả các giáo viên của khoa CNTT tham gia.

Q68. Cho biết tên giáo viên nào mà tham gia tất cả các công việc của đề tài Nghiên cứu tế bào gốc.

Q69. Tìm tên các giáo viên được phân công làm tất cả các đề tài có kinh phí trên 100 triệu?

Q70. Cho biết tên đề tài nào mà được tất cả các giáo viên của khoa Sinh Học tham gia.

Q71. Cho biết mã số, họ tên, ngày sinh của giáo viên tham gia tất cả các công việc của đề tài “Ứng dụng hóa học xanh”.

Q72. Cho biết mã số, họ tên, tên bộ môn và tên người quản lý chuyên môn của giáo viên tham gia tất cả các đề
tài thuộc chủ đề “Nghiên cứu phát triển”.

Q73. Cho biết họ tên, ngày sinh, tên khoa, tên trưởng khoa của giáo viên tham gia tất cả các đề tài có giáo viên “Nguyễn Hoài An” tham gia.

Q74. Cho biết họ tên giáo viên khoa “Công nghệ thông tin” tham gia tất cả các công việc của đề tài có trưởng bộ môn của bộ môn đông nhất khoa “Công nghệ thông tin” làm chủ nhiệm.

Q75. Cho biết họ tên giáo viên và tên bộ môn họ làm trưởng bộ môn nếu có

Q76. Cho danh sách tên bộ môn và họ tên trưởng bộ môn đó nếu có

Q77. Cho danh sách tên giáo viên và các đề tài giáo viên đó chủ nhiệm nếu có

Q78. Xóa các đề tài thuộc chủ đề “NCPT”.

Q79. Xuất ra thông tin của giáo viên (MAGV, HOTEN) và mức lương của giáo viên. Mức lương được xếp theo,quy tắc: Lương của giáo viên < $1800 : “THẤP” ; Từ $1800 đến $2200: TRUNG BÌNH; Lương > $2200:“CAO”

Q80. Xuất ra thông tin giáo viên (MAGV, HOTEN) và xếp hạng dựa vào mức lương. Nếu giáo viên có lương cao
nhất thì hạng là 1.

Q81. Xuất ra thông tin thu nhập của giáo viên. Thu nhập của giáo viên được tính bằng LƯƠNG + PHỤ CẤP. Nếu giáo viên là trưởng bộ môn thì PHỤ CẤP là 300, và giáo viên là trưởng khoa thì PHỤ CẤP là 600.

Q82. Xuất ra năm mà giáo viên dự kiến sẽ nghĩ hưu với quy định: Tuổi nghỉ hưu của Nam là 60, của Nữ là 55.

RÀNG BUỘC TOÀN VẸN
Hãy biểu diễn các ràng buộc toàn vẹn sau:

R1. Tên tài phải duy nhất

R2. Trưởng bộ môn phải sinh sau trước 1975

R3. Một bộ môn có tối thiểu 1 giáo viên nữ

R4. Một giáo viên phải có ít nhất 1 số điện thoại

R5. Một giáo viên có tối đa 3 số điện thoại

R6. Một bộ môn phải có tối thiểu 4 giáo viên

R7. Trưởng bộ môn phải là người lớn tuổi nhất trong bộ môn.

R8. Nếu một giáo viên đã là trưởng bộ môn thì giáo viên đó không làm người quản lý chuyên môn.

R9. Giáo viên và giáo viên quản lý chuyên môn của giáo viên đó phải thuộc về 1 bộ môn.

R10. Mỗi giáo viên chỉ có tối đa 1 vợ chồng

R11. Giáo viên là Nam thì chỉ có vợ chồng là Nữ hoặc ngược lại.

R12. Nếu thân nhân có quan hệ là “con gái” hoặc “con trai” với giáo viên thì năm sinh của giáo viên phải nhỏ hơn năm sinh của thân nhân.

R13. Một giáo viên chỉ làm chủ nhiệm tối đa 3 đề tài.

R14. Một đề tài phải có ít nhất một công việc

R15. Lương của giáo viên phải nhỏ hơn lương người quản lý của giáo viên đó.

R16. Lương của trưởng bộ môn phải lớn hơn lương của các giáo viên trong bộ môn.

R17. Bộ môn ban nào cũng phải có trưởng bộ môn và trưởng bộ môn phải là một giáo viên trong trường.

R18. Một giáo viên chỉ quản lý tối đa 3 giáo viên khác.

R19. Giáo viên chỉ tham gia những đề tài mà giáo viên chủ nhiệm đề tài là người cùng bộ môn với giáo viên đó.