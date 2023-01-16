package officers;

public class KySu extends CanBo{
    protected String nganhDaoTao;

    public KySu(String tranVanB, String s, boolean b, String xayDung) {
    }

    public KySu(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public KySu(String hoTen, String ngaySinh, boolean gioiTinh, String diachi, String nganhDaoTao) {
        super(hoTen, ngaySinh, gioiTinh, diachi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }
    @Override
    public String toString(){
        return String.format("Ky su: %s, %s, %s, %s, %s", this.hoTen, this.ngaySinh, this.gioiTinh, this.diachi, this.nganhDaoTao);
    }
}
