package com.codegym.staticoop;

public class PhanSoMain {
    public static void main(String[] args) {
        PhanSo ps1 = new PhanSo(2, 4);
        PhanSo ps2 = new PhanSo(1, 6);
        PhanSo ps3 = new PhanSo(1, 6);
        PhanSo ps4 = new PhanSo(1, 6);
        PhanSo ps5 = new PhanSo(1, 6);



        PhanSo[] phanSos = new PhanSo[5];
        phanSos[0] = ps1;
        phanSos[1] = ps2;
        phanSos[2] = ps3;
        phanSos[3] = ps4;
        phanSos[4] = ps5;

        PhanSo temp = new PhanSo(0,1);
        for (int i = 0; i < phanSos.length; i++) {
            temp.congPhanSo(phanSos[i]);

        }
        System.out.println(temp.toString());

        PhanSo temp1 = new PhanSo(0,1);
        for (int i = 0; i < phanSos.length; i++) {
            temp1 = congHaiPhanSo(temp1, phanSos[i]);

        }
        System.out.println(temp1.toString());



    }

    public static PhanSo congHaiPhanSo(PhanSo ps1, PhanSo ps2) {
        int mauSoChung = PhanSoMain.timBCNN(ps1.getMauSo(), ps2.getMauSo());

        PhanSo tong = new PhanSo();
        tong.setMauSo(mauSoChung);
        tong.setTuSo(mauSoChung / ps1.getMauSo() * ps1.getTuSo() + mauSoChung / ps2.getMauSo() * ps2.getTuSo());
        return tong;
    }

    public static int timBCNN(int num1, int num2) {
        int gcd = 1;
        for(int i = 1; i <= num1 && i <= num2; i++)
        {
            if(num1%i==0 && num2%i==0)
                gcd = i;
        }

        return (num1*num2)/gcd;
    }
}
