package by.itstep.h2db.dto;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String fullName;
    //private String group;
    @Column(name="avg_mark")
    private Double avgMark;

    public Student(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /* String getGroup() {
        return group;
    }*/

    /*public void setGroup(String group) {
        this.group = group;
    }*/

    public Double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(Double avgMark) {
        this.avgMark = avgMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getFullName() != null ? !getFullName().equals(student.getFullName()) : student.getFullName() != null)
            return false;
        //if (getGroup() != null ? !getGroup().equals(student.getGroup()) : student.getGroup() != null) return false;
        return getAvgMark() != null ? getAvgMark().equals(student.getAvgMark()) : student.getAvgMark() == null;
    }

    @Override
    public int hashCode() {
        int result = getFullName() != null ? getFullName().hashCode() : 0;
        //result = 31 * result + (getGroup() != null ? getGroup().hashCode() : 0);
        result = 31 * result + (getAvgMark() != null ? getAvgMark().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                //", group='" + group + '\'' +
                ", avgMark=" + avgMark +
                '}';
    }
}

