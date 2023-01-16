package officers;

public class NhanVien extends CanBo{
    protected String congViec;

    public NhanVien(String dangThiC, String s, boolean b, String vanPhong) {
    }

    public NhanVien(String congViec) {
        this.congViec = congViec;
    }

    public NhanVien(String hoTen, String ngaySinh, boolean gioiTinh, String diachi, String congViec) {
        super(hoTen, ngaySinh, gioiTinh, diachi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
    public String toString(){
        return String.format("Nhan vien: %s, %s, %s, %s, %s", this.hoTen, this.ngaySinh, this.gioiTinh, this.diachi, this.congViec);
    }
}
