package student;

import java.io.Serializable;

public class Student implements Serializable {
   private String id;
   private String name;
   private String age;
   private String Sex;
   private String address;
   private double mediumScore;

    public Student() {
    }

    public Student (String id, String name, String age, String sex, String address, double mediumScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        Sex = sex;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return "Student:" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", Sex='" + Sex + '\'' +
                ", address='" + address + '\'' +
                ", mediumScore=" + mediumScore +"\n"
                ;
    }
}
