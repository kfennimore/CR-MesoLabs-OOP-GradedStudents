package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Student extends Classroom{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;




    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList(Arrays.asList(testScores));

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getTestScores() {
        return examScores;
    }
    public int getNumberofExamsTaken() {

        return examScores.size();
    }

    public String getExamScores(){
        StringBuilder examScore = new StringBuilder();
        examScore.append("Exam Scores: \n");

        for(int i = 0; i < examScores.size(); i++){
            int count = (i + 1);
            double score = examScores.get(i);
            double newScore = score;
            examScore.append("\t   Exam " + count + " -> " + newScore + "\n");
            }
        return examScore.toString();
    }

    public void addExamScore(double examScore) {

        examScores.add(examScore);
    }

    public Double setExamScore(int examNumber, double newScore) {

        return examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        double total = 0;

        for (int i = 0; i < examScores.size(); i++){
            total += examScores.get(i);
        }
        return (total / examScores.size());

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Student Name: " + firstName + " " + lastName + "\n");
        sb.append("> Average Score: " + getAverageExamScore() + "\n");
        sb.append("> " + getExamScores());
        String result = sb.toString();

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
}
