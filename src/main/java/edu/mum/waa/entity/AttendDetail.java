package edu.mum.waa.entity;

public class AttendDetail {
    String date;
    Boolean isAttended;

    public AttendDetail() {
    }

    public AttendDetail(String date, Boolean isAttended) {
        this.date = date;
        this.isAttended = isAttended;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getAttended() {
        return isAttended;
    }

    public void setAttended(Boolean attended) {
        isAttended = attended;
    }
}
