package view;

import controller.ManagerStudent;

import java.util.Scanner;

public class Menu {
    public void MenuStudent() {
        Scanner scanner = new Scanner(System.in);
         ManagerStudent managerStudent= ManagerStudent.getInstance1();
        do {
            System.out.println("----STUDENT MANAGEMENT PROGRAM---");

            System.out.println("select function by number (to continue)");
            System.out.println("""
                    1.View student list
                    2.Add new
                    3.update
                    4.delete
                    5.Sort Students
                    6.Read File
                    7.Write
                    8.Exit
                    Select function:""");
            int menu=scanner.nextInt();
            switch (menu){
                case 1:managerStudent.show();break;
                case 2:managerStudent.creat();break;
                case 3:managerStudent.editById();;break;
                case 4:managerStudent.removeId();break;
                case 5:managerStudent.sortStudentById();break;
                case 6:managerStudent.readFile();break;
                case 7:managerStudent.writeFile();break;
                case 8:System.exit(menu);
            }
        }while (true);
    }
}
