package controller;

import storage.IReadWriteFile;
import storage.ReadWriteFile;
import student.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
    Scanner scanner = new Scanner(System.in);
    private static ManagerStudent instance;

    private final List<Student> listStudent;
     IReadWriteFile iReadWriteFile = ReadWriteFile.getInstance();

    private ManagerStudent() {
        this.listStudent = iReadWriteFile.readToFileStudent();
    }

    public static ManagerStudent getInstance1() {
        if (instance == null) {
            instance = new ManagerStudent();
        }
        return instance;
    }

    public void show() {
        for (Student sv : listStudent) {
            System.out.println(sv);
            System.out.println("------------------");
        }
    }

    public void creat() {
        String id = getID();
        String name = getName();
        String age = getAge();
        String sex=getSex();
        String address=getAddress();
        double mediumScore=getmMediumScore();
        listStudent.add(new Student(id,name,age,sex,address,mediumScore));
    }
    public void editById() {

        System.out.println("Enter the student id to edit");
        String id = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getName().equals(id)) {
                check = i;

            }

        }
        if (check < 0) {
            System.out.println("name is not in the list");

        } else {
            String id1 = getID();
            String name1 = getName();
            String age1 = getAge();
            String sex1=getSex();
            String address1=getAddress();
            double mediumScore1=getmMediumScore();
            listStudent.get(check).setId(id1);
            listStudent.get(check).setName(name1);
            listStudent.get(check).setAge(age1);
            listStudent.get(check).setSex(sex1);
            listStudent.get(check).setAddress(address1);
            listStudent.get(check).setMediumScore(mediumScore1);
        }
    }
    public void removeId() {
        System.out.println("nhập id cần xóa :");
        String id=scanner.nextLine();
        int check=-1;
        for (int i=0;i<listStudent.size();i++){
            if(listStudent.get(i).getId().equals(id)){
                check=i;
            }
        }
        if (check<0){
            System.out.println("id does not exist");
        }else {
            listStudent.remove(check);
        }

    }


    public String getAge() {
        while (true) {
            try {
                System.out.println("Enter the Student age:");
                String age = scanner.nextLine();
                if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 60) {
                    throw new Exception();
                } else return age;
            } catch (Exception e) {
                System.out.println("re-enter employee age from 15 years old to 59 years old");
            }
        }
    }

    public String getSex() {
        while (true) {
            try {
                System.out.println("Please enter your gender ");

                String sex = scanner.nextLine();
                String male;
                String female;
                if (sex.equals("male") || sex.equals("female")) {
                    return sex;
                } else {
                    throw new Exception();
                }
            } catch (Exception e){
                System.out.println("please re-enter");
            }
        }

    }
    public void sortStudentById() {
        sortStudents();
    }
    private void sortStudents() {
        listStudent.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (Integer.parseInt(o1.getId())) - (Integer.parseInt(o2.getId()));
            }

        });
    }
    public double getmMediumScore(){
        System.out.println("enter Medium Score");
        return checkDouble(scanner);


    }



    public String getAddress() {

        System.out.println("enter address :");
        return scanner.nextLine();
    }

    public String getName() {
        while (true) {
            try {
                System.out.println("enter name:");
                String name = scanner.nextLine();
                if (Regex.validateName(name)) {
                    return name;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("name must be in correct format:");
            }
        }

    }

    public String getID() {
        while (true) {
            try {
                System.out.println("enter id :");
                String id = scanner.nextLine();
                if (Regex.validateId(id)) {

                    for (Student sv : listStudent) {
                        if (sv.getId().equals(id)) {
                            throw new Exception();
                        }
                        break;
                    }
                    return id;
                } else System.out.println("id input in the correct format is number (0-9)");
            } catch (Exception e) {
                System.out.println("Enter the same id, re-enter it to see if it still matches!!!!");
            }
        }


    }
    public void readFile(){
iReadWriteFile.readToFileStudent();
    }
    public void writeFile(){
        iReadWriteFile.writeToFileStudent(listStudent);
    }

    public int checkInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Enter incorrectly, please re-enter");
        }
        return checkInt(scanner);
    }

    public double checkDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Enter incorrectly, please re-enter");
        }
        return checkDouble(scanner);
    }

}
