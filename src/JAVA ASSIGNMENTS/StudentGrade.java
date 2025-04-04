import java.util.*;

public class StudentGrade{
    public static void main(String[] args){

        Scanner value = new Scanner(System.in);


        int eachStudentHighScore = 0;
        int eachStudentLowScore = 0;
        int eachSubjectTotal;

        int failure = 0;
        int passed = 0;
        int easiestSubject = 0;
        int hardestSubject = 0;

        double classOverallTotalScore = 0;
        double classOverallAverage;

        int worstGraduatingStudent = 0;
        int bestGraduatingStudent = 0;
        int numOfStudents;
        int numOfSubjects;

        while (true){
            try {
        System.out.println("How many student do you have?");
         numOfStudents = value.nextInt();
                if (numOfStudents >= 1){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number of students!");
                value.nextLine();
            }
        }

        while (true){
            try {
        System.out.println("How many subject do they offer?");
         numOfSubjects = value.nextInt();

         if (numOfSubjects >= 1){
             break;
         }

            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number of subjects!");
                value.nextLine();
            }
        }

        System.out.printf("%s%n%s%n%n","Saving >>>>>>>>>>>>>>>>>>>>>>>>>", "Saved successfully");

        double[][] studentScores = new double [numOfStudents][numOfSubjects];

        double overallHighScore = studentScores[0][0];
        double overallLowestScore = Double.MAX_VALUE;

        for(int student = 0; student < numOfStudents; student++){
            System.out.println("Entering score for student " + (student + 1));
            for(int subject = 0; subject < numOfSubjects; subject++){

                while(true) {
                    try {
                        System.out.println("Enter score for subject " + (subject + 1));
                        studentScores[student][subject] = value.nextDouble();
                        if (studentScores[student][subject] >= 1){
                            break;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Please enter a valid integer score for subject!");
                        value.nextLine();

                    }
                }

                System.out.printf("%s %n %s %n %n","Saving >>>>>>>>>>>>>>>>>>>>>>>>>", "Saved successfully");
            }

        }

        double [] eachTotal = new double[numOfStudents];
        double [] eachAverage = new double [numOfStudents];

        for(int student = 0; student < numOfStudents; student++){
            for(int subject = 0; subject < numOfSubjects; subject++){
                eachTotal[student] += studentScores[student][subject];
            }
            eachAverage[student] =  eachTotal[student] / numOfSubjects;
        }


        int [] eachPosition = new int [numOfStudents];

        for(int student = 0; student < numOfStudents; student++){
            int position = 1;
            for(int check = 0; check < numOfStudents; check++){
                if(eachAverage[student] < eachAverage[check]){
                    position++;
                }
                eachPosition[student] = position;
            }

        }

        System.out.println("=============================================================================================");
        System.out.printf("%-10s", "STUDENT");

        for(int sub = 1; sub <= numOfSubjects; sub++){
            System.out.printf("%-10s","SUB" + sub );
        }
        System.out.printf("%-10s %-10s %-10s\n", "TOT", "AVG", "POS");
        System.out.println("================================================================================================");


        for(int student = 0; student < numOfStudents; student++){
            System.out.printf("%-10s ", "Student " + (student + 1));

            for(int subject = 0; subject < numOfSubjects; subject++){
                System.out.printf("%-10.2f", + studentScores[student][subject]);
            }
            System.out.printf("%-10.2f %-10.2f %-10d%n%n", eachTotal[student], eachAverage[student], eachPosition[student]);

        }



        System.out.println("SUBJECT SUMMARY \n");

        for(int subject = 0; subject < numOfSubjects; subject++){

            double maximum = Double.MIN_VALUE;
            double minimum = Double.MAX_VALUE;
            eachSubjectTotal = 0;
            double averageForEachSubject = 0;
            passed = 0;
            failure = 0;
            System.out.println("Subject " + (subject + 1));
            for(int student = 0; student < numOfStudents ; student++){

                if(studentScores[student][subject] > maximum){
                    maximum = studentScores[student][subject];
                    eachStudentHighScore = student;
                }
                if(studentScores[student][subject] < minimum){
                    minimum = studentScores[student][subject];
                    eachStudentLowScore = student;
                }
                if(studentScores[student][subject] < 45){
                    failure++;
                    hardestSubject = subject;
                }else if(studentScores[student][subject] > 45 && studentScores[student][subject] <= 100){
                    passed++;
                    easiestSubject = subject;
                }

                if(studentScores[student][subject] > overallHighScore){
                    overallHighScore = studentScores[student][subject];

                }if(studentScores[student][subject] < overallLowestScore){
                    overallLowestScore = studentScores[student][subject];
                }

                eachSubjectTotal += (int) studentScores[student][subject];
                averageForEachSubject = (double) eachSubjectTotal / numOfStudents;
            }
            System.out.printf("%n %s %d %s %.2f%n", "The highest scoring student is: Student", eachStudentHighScore + 1, "Scoring", maximum);
            System.out.printf("%s %d %s %.2f%n", "The lowest scoring student is: Student", eachStudentLowScore + 1, "Scoring", minimum);
            System.out.printf("%s %d%n", "The Total  Score is ->: ", eachSubjectTotal);
            System.out.printf("%s %.2f%n", "The Average  Score is ->: ", averageForEachSubject);
            System.out.printf("%s %d%n", "The Number of passes is ->: ", passed);
            System.out.printf("%s %d%n%n%n%n%n", "The Number of failure is ->: ", failure);
        }


        double overallStudentHighTotal = Integer.MIN_VALUE;
        double overallStudentLowTotal = Integer.MAX_VALUE;

        for(int student = 0; student < numOfStudents; student++){
            if(eachTotal[student] > overallStudentHighTotal){
                overallStudentHighTotal =  eachTotal[student];
                bestGraduatingStudent = student;
            }

            if(eachTotal[student] < overallStudentLowTotal){
                overallStudentLowTotal =  eachTotal[student];
                worstGraduatingStudent = student;
            }

            classOverallTotalScore += eachTotal[student];
        }
        classOverallAverage = classOverallTotalScore / numOfStudents;

        int winner = 0;
        int loser = 0;

        int winnerSub = 0;
        int loserSub = 0;
        for(int student = 0; student < numOfStudents; student++){
            for(int subject = 0; subject < numOfSubjects; subject++){

                if(studentScores[student][subject] == overallHighScore){
                    winner = student;
                    winnerSub = subject;
                }

                if(studentScores[student][subject] == overallLowestScore){
                    loser = student;
                    loserSub = subject;
                }

            }
        }
        System.out.printf("%s %d %s %d %s%n","The hardest subject is subject", (hardestSubject + 1), "With", failure, "Failures");
        System.out.printf("%s %d %s %d %s%n","The easiest Subject is subject", (easiestSubject + 1), "With", passed, "passes");

        System.out.printf("%s %d %s %d %s %.2f%n","The Overall Highest Score is scored by Student", (winner + 1), "in subject", (winnerSub + 1), "Scoring", overallHighScore);
        System.out.printf("%s %d %s %d %s %.2f%n", "The Overall lowest Score is scored by Student", (loser + 1),  "in subject", (loserSub + 1), "Scoring",overallLowestScore);





        System.out.println("=========================================================== \n \n");



        System.out.println("CLASS SUMMARY");
        System.out.println("===========================================================");

        System.out.printf("%s %d %s %.2f%n","Best graduating student is : Student", (bestGraduatingStudent + 1), "scoring", overallStudentHighTotal);
        System.out.println("===========================================================");



        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.printf("%s %d %s %.2f%n", "Worst graduating student is: student", (worstGraduatingStudent + 1), "Scoring" , overallStudentLowTotal);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println("===============================================================");

        System.out.println("Class overall Total Score is ->: " + classOverallTotalScore);
        System.out.println("Class overall Average Score is -> : " +classOverallAverage);

        System.out.println("==============================================================");





    }
}