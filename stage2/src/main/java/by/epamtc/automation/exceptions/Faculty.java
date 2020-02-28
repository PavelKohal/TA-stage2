package by.epamtc.automation.exceptions;

import by.epamtc.automation.exceptions.customexceptions.*;
import by.epamtc.automation.exceptions.enums.*;

import java.util.*;

public class Faculty {

    private FacultyList facultyName;
    private List<Group> groups;

    public Faculty(FacultyList facultyName, List<Group> groups) {
        this.facultyName = facultyName;
        this.groups = groups;
    }

    public FacultyList getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() throws NoGroupsAtFacultyException {
        if(groups.isEmpty()) {
            throw new NoGroupsAtFacultyException("There are no groups at this faculty");
        }
        return groups;
    }

    public void addGroupsToFaculties(Group group) {
        groups.add(group);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyName == faculty.facultyName &&
                Objects.equals(groups, faculty.groups);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + facultyName +
                ", groups=" + groups +
                '}';
    }
}
