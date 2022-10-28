package persistence.entity;

import model.StudentModel;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="students")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
@Column(name="Name")
private String name;
@Column(name="BirthPlace")
private String birthPlace;
@Column(name="BirthDate")
private Date birthDate;
public void getStudent(StudentModel model){
    name=model.getName();
    birthPlace=model.getBirthPlace();
    try {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(model.getBirthDate());
        birthDate=date;
    }catch (Exception ex){
        ex.printStackTrace();
    }
}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}
