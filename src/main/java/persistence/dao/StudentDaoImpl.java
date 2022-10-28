package persistence.dao;

import model.StudentModel;
import persistence.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImpl implements StudentDao{


    @Override
    public List<StudentModel> getAllStudent() {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myws2");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        String sql="select u from Student u";
        List<Student> studentList=entityManager.createQuery(sql).getResultList();
        List<StudentModel> studentModels=new ArrayList<>();
        for(Student student:studentList){
            studentModels.add(new StudentModel(student.getId(),student.getName(),student.getBirthPlace(),student.getBirthDate().toString()));
        }
        return studentModels;
    }

    @Override
    public void addStudent(StudentModel model) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myws2");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        Student student=new Student();
        student.getStudent(model);

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateStudent(StudentModel model) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myws2");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Student student=entityManager.find(Student.class,model.getId());
        student.setName(model.getName());
        try{
            Date date=new SimpleDateFormat("yyyy-MM-dd").parse(model.getBirthDate());
            student.setBirthDate(date);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        student.setBirthPlace(model.getBirthPlace());

        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteStudent(Integer id) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myws2");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
}
