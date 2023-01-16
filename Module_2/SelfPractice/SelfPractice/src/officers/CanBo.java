package officers;


public class CanBo {
    protected String hoTen;
    protected String ngaySinh;
    protected boolean gioiTinh;
    protected String diachi;

    public CanBo() {
    }

    public CanBo(String hoTen, String ngaySinh, boolean gioiTinh, String diachi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diachi = diachi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

}
