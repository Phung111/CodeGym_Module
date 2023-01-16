package officers;
import java.util.Scanner;

public class QLCB {
    public static void main(String[] args) {
        //Tạo ds cán bộ cơ bản
        CanBo [] canbos = new CanBo[3];
        canbos[0] = new CongNhan("Nguyen Van A","1/1/2000",true,"1a","3/4");
        canbos[1] = new KySu("Tran Van B","12/12/1995",true,"2a","Xay Dung");
        canbos[2] = new NhanVien("Dang Thi C","2/2/2000",false,"3a","Van Phong");
//        for (int i = 0; i < canbos.length;i++){
//            System.out.println(canbos[1]);
//        }

        //Thêm cán bộ mới
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String hoTen = String.valueOf(scanner.nextLine());
        System.out.println("Nhập ngày sinh(dd/mm/yyyy): .");
        String ngaySinh = String.valueOf(scanner.nextLine());
        System.out.println("Nhập giới tính(true/false): ");
        boolean gioiTinh = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập địa chỉ(1c):  .");
        String diaChi = String.valueOf(scanner.nextLine());
//      System.out.println("Nhập ngành làm việc(cong nhan, ky su, nhan vien):  .");
//      String hoTen = String.valueOf(Integer.parseInt(scanner.nextLine()));

        CanBo newCanBo = new CanBo();
        newCanBo.setHoTen(hoTen);
        newCanBo.setNgaySinh(ngaySinh);
        newCanBo.setGioiTinh(gioiTinh);
        newCanBo.setDiachi(diaChi);

        for (int i = 0; i < canbos.length;i++){
            System.out.println(canbos[i].toString());
        }
    }

    public void listCanBo(){

    }
}
