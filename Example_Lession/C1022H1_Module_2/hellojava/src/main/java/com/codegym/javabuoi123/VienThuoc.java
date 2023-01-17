package com.codegym.javabuoi123;

public class VienThuoc {
    public String tenThuoc;
    public String mauSac;
    private String [] thanhPhans;
    public String dangThuoc;
    private String congthucCheTao;


    public void cachSuDung() {
        System.out.println("Uong 2 lan 1 ngay");
    }
    public VienThuoc() {
        this("Pacacetamol", "Trang", null, "Viên", "...");
        System.out.println("Hello........");

    }

    public VienThuoc(String tenThuoc, String mauSac, String[] thanhPhans,
                     String dangThuoc, String congthucCheTao) {
        this.tenThuoc = tenThuoc;
        this.mauSac = mauSac;
        this.thanhPhans = thanhPhans;
        this.dangThuoc = dangThuoc;
        this.congthucCheTao = congthucCheTao;
    }

}
