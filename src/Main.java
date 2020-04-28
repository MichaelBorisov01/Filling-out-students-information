import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;
import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        out.println("Input count of students: ");
        while (!in.hasNextInt()) {
            System.out.println("That not a number!");
            in.next();
        }
        int countOfStudents = in.nextInt();

            if (countOfStudents <= 0) {
                out.println("Enter a positive number please: ");
                while (countOfStudents <= 0) {
                    countOfStudents = in.nextInt();
                }
            }


        Student[] students = new Student[countOfStudents];

        out.println("Enter your average grade: ");
        while (!in.hasNextFloat()) {
            System.out.println("That not a number!");
            in.next();
        }
        float defaultAverageMark=in.nextFloat();
            if (defaultAverageMark <= 0) {
                out.println("Enter a positive number please: ");
                while (defaultAverageMark<=0) {
                    defaultAverageMark = in.nextFloat();
                }
            }

        for (int i=0;i<countOfStudents;i++) {

            Student std = new Student();

            out.println("---------------------");

            out.println();
            std.fio.surname=in.nextLine();

            out.println("Input surname: ");
            while (in.hasNext("-?\\d+(\\.\\d+)?"))
            {
                System.out.println("Please, enter only string:");
                in.next();
            }
            std.fio.surname=in.nextLine();

            out.println("Input name: ");
            while (in.hasNext("-?\\d+(\\.\\d+)?"))
            {
                System.out.println("Please, enter only string:");
                in.next();
            }
            std.fio.name=in.nextLine();

            out.println("Input patronymic: ");
            while (in.hasNext("-?\\d+(\\.\\d+)?"))
            {
                System.out.println("Please, enter only string:");
                in.next();
            }
            std.fio.patronymic=in.nextLine();

            out.println("Input number of group: ");
            while (!in.hasNextInt()) {
                System.out.println("That not a number!");
                in.next();
            }
            std.numberOfGroup=in.nextInt();
            if (std.numberOfGroup <= 0) {
                out.println("Enter a positive number please: ");
                while (std.numberOfGroup<=0) {
                    std.numberOfGroup = in.nextInt();
                }
            }

            out.println("Input progress of student (5 numbers): ");
            for (int j=0; j < 5; j++) {
                while (!in.hasNextInt()) {
                    System.out.println("That not a number!");
                    in.next();
                }
                std.progressOfStudent[j] = in.nextInt();
                if(std.progressOfStudent[j]<=0){
                    out.println("Enter a positive number please: ");
                    while (std.progressOfStudent[j]<=0) {
                        std.progressOfStudent[j] = in.nextInt();
                    }
                }
            }

                float sum = 0;
                for (int value : std.progressOfStudent) sum += value;
                std.personalAverageMark = sum / std.progressOfStudent.length;

            students[i] = std;
        }

       for(int i = 0; i<countOfStudents; i++) {
           sort(students);
           students[i].outputInf();
       }

        out.println();
        out.println("Students with a GPA greater than a given GPA:");
        int count = 0;
       for(int i = 0; i<countOfStudents; i++) {

           if (students[i].personalAverageMark > defaultAverageMark) {
               out.println("---------------------");
               out.print("Surname: ");
               out.println(students[i].fio.surname);
               out.print("Number of group: ");
               out.println(students[i].numberOfGroup);
               count++ ;
           }
       }
        if (count == 0) out.println("There are no such students!");
    }
}
