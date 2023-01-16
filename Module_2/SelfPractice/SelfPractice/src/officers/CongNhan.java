package officers;

public class CongNhan extends CanBo{
    protected String bac;

    public CongNhan(String nguyenVanA, String s, boolean b, String s1) {
    }

    public CongNhan(String bac) {
        this.bac = bac;
    }

    public CongNhan(String hoTen, String ngaySinh, boolean gioiTinh, String diachi, String bac) {
        super(hoTen, ngaySinh, gioiTinh, diachi);
        this.bac = bac;
    }

    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }
    public String toString(){
        return String.format("Cong nhan: %s, %s, %s, %s, %s", this.hoTen, this.ngaySinh, this.gioiTinh, this.diachi, this.bac);
    }
}
