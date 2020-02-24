package by.epamtc.automation.exceptions;

import by.epamtc.automation.exceptions.customexceptions.*;
import by.epamtc.automation.exceptions.enums.*;
import java.util.*;

public class Group {

    private GroupList groupName;
    private List<Student> students;

    public Group(GroupList groupName, List<Student> students) {
        this.groupName = groupName;
        this.students = students;
    }

    public GroupList getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() throws NoStudentsInGroupException {
        if(students.isEmpty()) {
            throw new NoStudentsInGroupException("There are no students in this group");
        }
        return students;
    }

    public void addStudentsToGroup(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupName == group.groupName &&
                Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName=" + groupName +
                ", students=" + students +
                '}';
    }
}
