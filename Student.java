import java.util.*;
import java.io.*;

abstract class Student {
  private String firstName;
  private String lastName;
  private String course;

  public Student(String firstName, String lastName, String course) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.course = course;
  }

  public abstract double getFinalAverage();

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCourse() {
    return course;
  }

  public char getLetterGrade() {
    double finalAverage = getFinalAverage();
    if (finalAverage >= 90) {
        return 'A';
    } else if (finalAverage >= 80) {
        return 'B';
    } else if (finalAverage >= 70) {
        return 'C';
    } else if (finalAverage >= 60) {
        return 'D';
    } else {
        return 'F';
    }
}
}

class EnglishStudent extends Student {
  private int termPaper;
  private int midterm;
  private int finalExam;

  public EnglishStudent(String firstName, String lastName, String course, int termPaper, int midterm, int finalExam) {
    super(firstName, lastName, course);
    this.termPaper = termPaper;
    this.midterm = midterm;
    this.finalExam = finalExam;
  }

  public double getFinalAverage() {
    return (0.3 * termPaper) + (0.3 * midterm) + (0.4 * finalExam);
  }

  public int getTermPaper() {
    return termPaper;
  }

  public int getMidterm() {
    return midterm;
  }

  public int getFinalExam() {
    return finalExam;
  }
}

class ScienceStudent extends Student {
  private int attendance;
  private int project;
  private int midterm;
  private int finalExam;

  public ScienceStudent(String firstName, String lastName, String course, int attendance, int project, int midterm, int finalExam) {
    super(firstName, lastName, course);
    this.attendance = attendance;
    this.project = project;
    this.midterm = midterm;
    this.finalExam = finalExam;
  }

  public double getFinalAverage() {
    return (0.1 * attendance) + (0.3 * project) + (0.3 * midterm) + (0.3 * finalExam);
  }

  public int getAttendance() {
    return attendance;
  }

  public int getProject() {
    return project;
  }

  public int getMidterm() {
    return midterm;
  }

  public int getFinalExam() {
    return finalExam;
  }
  
}

class MathStudent extends Student {
  private int quiz1;
  private int quiz2;
  private int quiz3;
  private int quiz4;
  private int quiz5;
  private int test1;
  private int test2;
  private int finalExam;

  public MathStudent(String firstName, String lastName, String course, int quiz1, int quiz2, int quiz3, int quiz4, int quiz5, int test1, int test2, int finalExam) {
    super(firstName, lastName, course);
    this.quiz1 = quiz1;
    this.quiz2 = quiz2;
    this.quiz3 = quiz3;
    this.quiz4 = quiz4;
    this.quiz5 = quiz5;
    this.test1 = test1;
    this.test2 = test2;
    this.finalExam = finalExam;
  }
    
    public double getFinalAverage() {
        double quizAverage = (quiz1 + quiz2 + quiz3 + quiz4 + quiz5)/5.0;
        return (0.3 * test1) + (0.2 * test2) + (0.35 * finalExam) + (0.15 * quizAverage);
      }
    
      public int getAttendance() {
        return attendance;
      }
    
      public int getProject() {
        return project;
      }
    
      public int getMidterm() {
        return midterm;
      }
    
      public int getFinalExam() {
        return finalExam;
      }

    }

	
    //output file
    PrintWriter outputFile = new PrintWriter("output.txt");

    for (Student student : students) {
      if (student instanceof EnglishStudent) {
        EnglishStudent englishStudent = (EnglishStudent) student;
        outputFile.println("Subject: English");
        outputFile.println("Student: " + student.getFirstName() + " " + student.getLastName());
        outputFile.println("Final Average: " + englishStudent.calculateAverage());
        outputFile.println("Letter Grade: " + student.calculateLetterGrade(englishStudent.calculateAverage()));
        outputFile.println(" ");
      } else if (student instanceof ScienceStudent) {
        ScienceStudent scienceStudent = (ScienceStudent) student;
        outputFile.println("Subject: Science");
        outputFile.println("Student: " + student.getFirstName() + " " + student.getLastName());
        outputFile.println("Final Average: " + scienceStudent.calculateAverage());
        outputFile.println("Letter Grade: " + student.calculateLetterGrade(scienceStudent.calculateAverage()));
        outputFile.println(" ");
      } else if (student instanceof MathStudent) {
        MathStudent mathStudent = (MathStudent) student;
        outputFile.println("Subject: Math");
        outputFile.println("Student: " + student.getFirstName() + " " + student.getLastName());
        outputFile.println("Final Average: " + mathStudent.calculateAverage());
        outputFile.println("Letter Grade: " + student.calculateLetterGrade(mathStudent.calculateAverage()));
        outputFile.println(" ");
      }
}
