package storage;

import student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteFile{
    private  ReadWriteFile() {};
    private static ReadWriteFile instance1;
    public static ReadWriteFile getInstance() {
        if (instance1 == null) {
            return instance1 = new ReadWriteFile();
        }
        return instance1;
    }
    @Override
    public void writeToFileStudent(List<Student> listStudents) {
        File file = new File("fileStudent.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(listStudents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> readToFileStudent() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("fileStudent.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                List<Student> students;
                try {
                    students = (List<Student>) objectInputStream.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);

                }
                return students;
            } else {
                return new ArrayList<>();
            }
        }
    }
}
