package com.codegym.staticoop;

public class PhanSo {
    private int tuSo;
    private int mauSo;
    public PhanSo() {

    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public PhanSo congPhanSo(PhanSo ps) {
        int mauSoChung = PhanSoMain.timBCNN(this.getMauSo(), ps.getMauSo());

        PhanSo tong = new PhanSo();
        tong.setMauSo(mauSoChung);
        tong.setTuSo(mauSoChung / this.getMauSo() * this.getTuSo() + mauSoChung / ps.getMauSo() * ps.getTuSo());

        this.tuSo = tong.getTuSo();
        this.mauSo = tong.getMauSo();
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", this.getTuSo(), this.getMauSo());
    }
}
