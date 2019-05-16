package edu.mum.waa.response;

public class StudentReport implements Comparable< StudentReport > {
    private String blockName;
    private String studentName;
    private  Integer attendedCount;
    private  Integer totalSession;
    private  Double percentage;
    private  Double bonusPoint;



    public StudentReport(String blockName, String studentName, Integer attendedCount, Integer totalSession, Double percentage, Double bonusPoint) {
        this.blockName = blockName;
        this.studentName = studentName;
        this.attendedCount = attendedCount;
        this.totalSession = totalSession;
        this.percentage = percentage;
        this.bonusPoint = bonusPoint;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
                "studentName='" + studentName + '\'' +
                ", attendedCount=" + attendedCount +
                ", totalSession=" + totalSession +
                ", percentage=" + percentage +
                ", bonusPoint=" + bonusPoint +
                '}';
    }

    @Override
    public int compareTo(StudentReport s) {
        return this.getStudentName().compareTo(s.getStudentName());
    }
}
