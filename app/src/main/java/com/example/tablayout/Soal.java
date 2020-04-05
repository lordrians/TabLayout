package com.example.tablayout;

import android.os.Parcel;
import android.os.Parcelable;

public class Soal implements Parcelable {
    private String soal, pgA, pgB, pgC, pgD, correctAns;

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getPgA() {
        return pgA;
    }

    public void setPgA(String pgA) {
        this.pgA = pgA;
    }

    public String getPgB() {
        return pgB;
    }

    public void setPgB(String pgB) {
        this.pgB = pgB;
    }

    public String getPgC() {
        return pgC;
    }

    public void setPgC(String pgC) {
        this.pgC = pgC;
    }

    public String getPgD() {
        return pgD;
    }

    public void setPgD(String pgD) {
        this.pgD = pgD;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public static Creator<Soal> getCREATOR() {
        return CREATOR;
    }

    public Soal() {

    }

    protected Soal(Parcel in) {
        soal = in.readString();
        pgA = in.readString();
        pgB = in.readString();
        pgC = in.readString();
        pgD = in.readString();
        correctAns = in.readString();
    }

    public static final Creator<Soal> CREATOR = new Creator<Soal>() {
        @Override
        public Soal createFromParcel(Parcel in) {
            return new Soal(in);
        }

        @Override
        public Soal[] newArray(int size) {
            return new Soal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(soal);
        dest.writeString(pgA);
        dest.writeString(pgB);
        dest.writeString(pgC);
        dest.writeString(pgD);
        dest.writeString(correctAns);
    }
}
