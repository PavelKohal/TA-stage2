package by.epamtc.automation.exceptions;

import by.epamtc.automation.exceptions.customexceptions.*;
import by.epamtc.automation.exceptions.enums.*;
import java.util.*;

public class University {

    private List<Faculty> faculties;

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() throws NoFacultiesAtUniversityException {
        if(faculties.isEmpty()) {
            throw new NoFacultiesAtUniversityException("There are no faculties at the university");
        }
        return faculties;
    }

    public void addFacultiesToUniversity(Faculty faculty) {
        faculties.add(faculty);
    }

    public double findAverageGradeAtUniversity(SubjectList subjectName) throws StudentHasNoSubjectsException,
            NoStudentsInGroupException, NoGroupsAtFacultyException, NoFacultiesAtUniversityException {

        int counter = 0;
        double sum = 0;
        for (Faculty faculty : getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    if (student.getRecordBook().containsKey(subjectName)) {
                        counter++;
                        sum += student.getRecordBook().get(subjectName);
                    }
                }
            }
        }
        return sum/counter;
    }

    public double findAverageGradeAtFaculty(SubjectList subjectName, FacultyList facultyName) throws StudentHasNoSubjectsException,
            NoStudentsInGroupException, NoGroupsAtFacultyException, NoFacultiesAtUniversityException {

        int counter = 0;
        double sum = 0;
        for (Faculty faculty : getFaculties()) {
            if (faculty.getFacultyName().equals(facultyName)) {
                for (Group group : faculty.getGroups()) {
                    for (Student student : group.getStudents()) {
                        if (student.getRecordBook().containsKey(subjectName)) {
                            counter++;
                            sum += student.getRecordBook().get(subjectName);
                        }
                    }
                }
            }
        }
        return sum/counter;
    }

    public double findAverageGradeAtGroup(SubjectList subjectName, GroupList groupName) throws StudentHasNoSubjectsException,
            NoStudentsInGroupException, NoGroupsAtFacultyException, NoFacultiesAtUniversityException {

        int counter = 0;
        double sum = 0;
        for (Faculty faculty : getFaculties()) {
            for (Group group : faculty.getGroups()) {
                if (group.getGroupName().equals(groupName)) {
                    for (Student student : group.getStudents()) {
                        if (student.getRecordBook().containsKey(subjectName)) {
                            counter++;
                            sum += student.getRecordBook().get(subjectName);
                        }
                    }
                }
            }
        }
        return sum/counter;
    }

    public Student findStudentAmongOthers(String lastName) throws NoStudentsInGroupException,
            NoGroupsAtFacultyException, NoFacultiesAtUniversityException, NoFacultiesAtUniversityException {

        for (Faculty faculty : getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    if (student.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
                        return student;
                    }
                }
            }
        }
        return  null;
    }

    public double findAverageMark(String lastName) throws StudentHasNoSubjectsException, IncorrectMarkException,
            NoFacultiesAtUniversityException, NoGroupsAtFacultyException, NoStudentsInGroupException {

        Student student = findStudentAmongOthers(lastName);
        Object[] marksArray = student.getRecordBook().values().toArray();
        double sum = 0;
        for(int i = 0; i < marksArray.length; i++){
            sum += (Integer) marksArray[i];
        }
        return sum/marksArray.length;
    }

    @Override
    public String toString() {
        return "University{" +
                "faculties=" + faculties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties);
    }
}
