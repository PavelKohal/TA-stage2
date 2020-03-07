package by.epamtc.automation.exceptions;

import by.epamtc.automation.exceptions.customexceptions.*;
import by.epamtc.automation.exceptions.enums.FacultyList;
import by.epamtc.automation.exceptions.enums.GroupList;
import by.epamtc.automation.exceptions.enums.SubjectList;

import java.util.*;


public class Runner {

    public static void main(String[] args) throws IncorrectMarkException, NoGroupsAtFacultyException,
            NoFacultiesAtUniversityException, StudentHasNoSubjectsException, NoStudentsInGroupException {

        Student ivanov = new Student("Ivan", "Ivanov", new HashMap<>());
        ivanov.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 8);
        ivanov.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 6);
        ivanov.addMarkAndSubjectToRecordBook(SubjectList.STATISTICS, 9);
        Student petrov = new Student("Petr", "Petrov", new HashMap<>());
        petrov.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 9);
        petrov.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 7);
        petrov.addMarkAndSubjectToRecordBook(SubjectList.STATISTICS, 4);
        Student pavlov = new Student("Pavel", "Pavlov", new HashMap<>());
        try {
            pavlov.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 10);
        } catch(IncorrectMarkException e) {
            System.err.println(e);
        }
        pavlov.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 8);
        pavlov.addMarkAndSubjectToRecordBook(SubjectList.STATISTICS, 8);
        Student nikolaev = new Student("Nikolay", "Nikolaev", new HashMap<>());
        nikolaev.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 6);
        nikolaev.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 5);
        nikolaev.addMarkAndSubjectToRecordBook(SubjectList.STATISTICS, 6);

        Student suvorov = new Student("Serg", "Suvorov", new HashMap<>());
        suvorov.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 4);
        suvorov.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 7);
        suvorov.addMarkAndSubjectToRecordBook(SubjectList.DRAWING, 6);
        Student alekseev = new Student("Petr", "Alekseev", new HashMap<>());
        alekseev.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 10);
        alekseev.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 9);
        alekseev.addMarkAndSubjectToRecordBook(SubjectList.DRAWING, 10);
        Student kirov = new Student("Kirill", "Kirov", new HashMap<>());
        kirov.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 7);
        kirov.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 7);
        kirov.addMarkAndSubjectToRecordBook(SubjectList.DRAWING, 5);
        Student sergeev = new Student("Mark", "Sergeev", new HashMap<>());
        sergeev.addMarkAndSubjectToRecordBook(SubjectList.MATHS, 9);
        sergeev.addMarkAndSubjectToRecordBook(SubjectList.ENGLISH, 6);
        sergeev.addMarkAndSubjectToRecordBook(SubjectList.DRAWING, 8);

        Group E101 = new Group(GroupList.E101, new ArrayList<>());
        E101.addStudentsToGroup(ivanov);
        E101.addStudentsToGroup(petrov);
        Group E102 = new Group(GroupList.E102, new ArrayList<>());
        E102.addStudentsToGroup(pavlov);
        E102.addStudentsToGroup(nikolaev);
        Group M101 = new Group(GroupList.M101, new ArrayList<>());
        M101.addStudentsToGroup(suvorov);
        M101.addStudentsToGroup(alekseev);
        Group M102 = new Group(GroupList.M102, new ArrayList<>());
        M102.addStudentsToGroup(kirov);
        M102.addStudentsToGroup(sergeev);

        Faculty ef = new Faculty(FacultyList.ECONOMICS, new ArrayList<>());
        ef.addGroupsToFaculties(E101);
        ef.addGroupsToFaculties(E102);
        Faculty mf = new Faculty(FacultyList.MECHANICS, new ArrayList<>());
        mf.addGroupsToFaculties(M101);
        mf.addGroupsToFaculties(M102);

        University mgup = new University(new ArrayList<>());
        mgup.addFacultyToUniversity(ef);
        mgup.addFacultyToUniversity(mf);

        System.out.printf("Ivanov's average score is %.1f\n", mgup.findAverageMark("Ivanov"));
        System.out.printf("The average score of M102 group in English is %.1f\n",
                mgup.findAverageGradeAtGroup(SubjectList.ENGLISH, GroupList.M102));
        System.out.printf("The average score at the faculty of economics in statistics is %.1f\n",
                mgup.findAverageGradeAtFaculty(SubjectList.STATISTICS, FacultyList.ECONOMICS));
        System.out.printf("The average score at the university in math is %.1f",
                mgup.findAverageGradeAtUniversity(SubjectList.MATHS));
    }
}
