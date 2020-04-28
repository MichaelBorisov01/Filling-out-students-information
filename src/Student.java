import java.util.Arrays;

import static java.lang.System.out;

public class Student implements Comparable<Student>{

    Fio fio=new Fio();

    public int numberOfGroup;
    public int[] progressOfStudent=new int[5];
    public float personalAverageMark;

    public void outputInf() {
        out.println("---------------------");
        out.println("Surname: " + fio.surname);
        out.println("Name: " + fio.name);
        out.println("Patronymic: " + fio.patronymic);
        out.println("Number of group: " + numberOfGroup);
        out.println("Progress of student: " + Arrays.toString(progressOfStudent));
        out.println("Average mark: " + personalAverageMark);
    }

    @Override
    public int compareTo(Student std) {
        return (this.numberOfGroup - std.numberOfGroup);
    }
}
