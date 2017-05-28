package problems;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by pradeep on 28/5/17.
 */

class Student {

    Student(int school, int rollNumber) {
        this.school = school;
        this.rollNumber = rollNumber;
    }

    private int school;
    private int rollNumber;

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
}

public class MonkGobletFire {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        LinkedList<Student> studentQueue = new LinkedList<>();

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        while (numberOfOperations > 0) {

            String[] operation = scanner.nextLine().split(" ");
            Student student;
            switch (operation[0]) {

                case "E":
                    student = new Student(Integer.parseInt(operation[1]), Integer.parseInt(operation[2]));
                    if (studentQueue.size() > 0) {
                        int index = studentQueue.size() - 1;
                        boolean isSchoolPresent = false;

//                        Iterator<Student> itr = studentQueue.descendingIterator();
//                        while (itr.hasNext()) {
//                            Student s = itr.next();
//                            if (s.getSchool() == student.getSchool()) {
//                                isSchoolPresent = true;
//                                break;
//                            }
//                            index--;
//                        }

                        for (int studentIndex = studentQueue.size() - 1; studentIndex >= 0; studentIndex--) {

                            if (studentQueue.get(studentIndex).getSchool() == student.getSchool()) {
                                isSchoolPresent = true;
                                index = studentIndex;
                                break;
                            }
                        }

                        if (isSchoolPresent) {
                            studentQueue.add(index + 1, student);
                        } else {
                            studentQueue.add(student);
                        }
                    } else {

                        studentQueue.add(student);
                    }
                    break;
                case "D":
                    if (studentQueue.size() > 0) {
                        student = studentQueue.remove(0);
                        System.out.println(student.getSchool() + " " + student.getRollNumber());
                    }
                    break;
            }

            numberOfOperations--;
        }

    }
}
