package edu.mum.waa.response;

public class StudentReport implements Comparable< StudentReport > {
    private Integer studentId;
    private  Integer attendedCount;
    private  Integer totalSession;
    private  Double percentage;
    private  Double bonusPoint;



    public StudentReport(Integer studentId, Integer attendedCount, Integer totalSession, Double percentage, Double bonusPoint) {
        this.studentId = studentId;
        this.attendedCount = attendedCount;
        this.totalSession = totalSession;
        this.percentage = percentage;
        this.bonusPoint = bonusPoint;
    }


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAttendedCount() {
        return attendedCount;
    }

    public void setAttendedCount(Integer attendedCount) {
        this.attendedCount = attendedCount;
    }

    public Integer getTotalSession() {
        return totalSession;
    }

    public void setTotalSession(Integer totalSession) {
        this.totalSession = totalSession;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(Double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    @Override
    public String toString() {
        return "StudentReport{" +
                "studentId='" + studentId + '\'' +
                ", attendedCount=" + attendedCount +
                ", totalSession=" + totalSession +
                ", percentage=" + percentage +
                ", bonusPoint=" + bonusPoint +
                '}';
    }

    @Override
    public int compareTo(StudentReport s) {
        return this.getStudentId().compareTo(s.getStudentId());
    }
}
