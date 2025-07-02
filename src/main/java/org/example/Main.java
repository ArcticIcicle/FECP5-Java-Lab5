package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        String inputNumber = getInput.nextLine();
        int numStudents = Integer.parseInt(inputNumber);
        ArrayList<String> classList = new ArrayList<String>();
        List<Integer> gradesList = new ArrayList<>();
        int[] gradeCount = {0,0,0,0,0};
        List<String> topStudents = new ArrayList<>();
        int highestGrade = -1;
        // loop
        for (int i = 1; i <= numStudents; i++) {
            System.out.printf("Enter name of student %d: ", i);
            String tempStudent = getInput.nextLine();
            classList.add(tempStudent);

            System.out.printf("Enter score for %s: ", tempStudent);
            String inputScore = getInput.nextLine();
            int grade = Integer.parseInt(inputScore);
            gradesList.add(grade);

            if (grade > highestGrade){
                highestGrade = grade;
                topStudents.clear();
                topStudents.add(tempStudent);
            } else if (grade == highestGrade){
                topStudents.add(tempStudent);
            }

            if (grade >= 90) {
                System.out.printf("%s got grade: A\n", tempStudent);
                ++gradeCount[0];
            } else if (grade >= 80) {
                System.out.printf("%s got grade: B\n", tempStudent);
                ++gradeCount[1];
            } else if (grade >= 70) {
                System.out.printf("%s got grade: C\n", tempStudent);
                ++gradeCount[2];
            } else if (grade >= 60) {
                System.out.printf("%s got grade: D\n", tempStudent);
                ++gradeCount[3];
            } else {
                System.out.printf("%s got grade: E\n", tempStudent);
                ++gradeCount[4];
            }
        }
        System.out.println("----- Class Summary -----");
        // solving for average
        int sum = 0;
        for (int num : gradesList) {
            sum += num;
        }
        double average = (double)sum / gradesList.size();
        System.out.println("Average Score: " + average);
        System.out.printf("A:%d B:%d C:%d D:%d E:%d\n", gradeCount[0],gradeCount[1],gradeCount[2],gradeCount[3],gradeCount[4]);
        System.out.print("Top Student(s): ");
        for (int i = 0; i < topStudents.size(); i++){
            System.out.printf("%s", topStudents.get(i));
            if (i < topStudents.size()-1){
                System.out.print(", ");
            }
        }
        System.out.print(" ("+ highestGrade + ")\n");

    /*
    A: 90–100
    B: 80–89
    C: 70–79
    D: 60–69
    F: below 60

     */

    }

}