package by.epamtc.automation.exceptions;

import by.epamtc.automation.exceptions.customexceptions.*;
import by.epamtc.automation.exceptions.enums.*;
import java.util.*;

public class Student {

    private String firstName;
    private String lastName;
    private Map<SubjectList, Integer> recordBook;

    public Student(String firstName, String lastName, Map<SubjectList, Integer> recordBook) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.recordBook = recordBook;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<SubjectList, Integer> getRecordBook() throws StudentHasNoSubjectsException{
        if(recordBook.isEmpty()) {
            throw new StudentHasNoSubjectsException("Student has no subjects");
        }
        return recordBook;
    }

    public void addMarkAndSubjectToRecordBook(SubjectList subject, Integer mark) throws IncorrectMarkException{
        if(mark > 10 || mark < 0) {
            throw new IncorrectMarkException("This grade has an incorrect value");
        }
        recordBook.put(subject, mark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(recordBook, student.recordBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, recordBook);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", recordBook=" + recordBook +
                '}';
    }
}
