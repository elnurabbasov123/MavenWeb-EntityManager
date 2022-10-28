package persistence.service;

import model.StudentModel;
import persistence.dao.StudentDao;
import persistence.dao.StudentDaoImpl;
import persistence.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao=new StudentDaoImpl();


    @Override
    public List<StudentModel> getAllStudents() {
        return studentDao.getAllStudent();
    }

    @Override
    public void addStudent(StudentModel model) {
            studentDao.addStudent(model);
    }

    @Override
    public void updateStudent(StudentModel model) {
      studentDao.updateStudent(model);
    }

    @Override
    public void deleteStudent(Integer id) {
     studentDao.deleteStudent(id);
    }
}
