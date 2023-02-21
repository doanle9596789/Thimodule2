package storage;
import student.Student;

import java.util.List;

public interface IReadWriteFile {
    void writeToFileStudent(List<Student> listStudents);
    List<Student> readToFileStudent();
}