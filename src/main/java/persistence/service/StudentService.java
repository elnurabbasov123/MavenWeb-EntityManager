package persistence.service;

import model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> getAllStudents();
    void addStudent(StudentModel model);
    void updateStudent(StudentModel model);
    void deleteStudent(Integer id);
}
