package j1.l.p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StudentManagementService {

    private final ArrayList<Student> students = new ArrayList<>();
    private final static Validation val = new Validation();

    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1.Create");
        System.out.println("2.Find and Sort");
        System.out.println("3.Update/Delete");
        System.out.println("4.Report");
        System.out.println("5.Dispaly all students");
        System.out.println("6.Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)");
    }

    public StudentManagementService() {
        students.add(new Student("HE194435", "trinh huy hoang", "SP26", "Java"));
        students.add(new Student("HE194435", "trinh huy hoang", "SP26", ".Net"));
        students.add(new Student("HE194435", "trinh huy hoang", "SU26", "C/C++"));
        students.add(new Student("HE194435", "trinh huy hoang", "SU26", "Java"));
        students.add(new Student("HE194435", "trinh huy hoang", "FA26", ".Net"));
        students.add(new Student("HE194435", "trinh huy hoang", "SP27", "Java"));

        students.add(new Student("HA207812", "le thi linh", "FA25", "Java"));
        students.add(new Student("HA207812", "le thi linh", "FA26", ".Net"));

        students.add(new Student("HS161724", "nguyen van minh", "FA25", "Java"));
        students.add(new Student("HS161724", "nguyen van minh", "SP2", "C/C++"));

        students.add(new Student("HE152832", "le van anh", "SU24", "Java"));
        students.add(new Student("HE152832", "le van anh", "FA25", ".Net"));
    }

    public void displayAll() {
        System.out.printf("%-15s%-25s%-15s%-15s\n", "ID", "Student name", "Semester", "Course Name");
        for (Student student : students) {
            System.out.printf("%-15s%-25s%-15s%-15s\n", student.getId(), student.getStudentName(), student.getSemester(), student.getCourseName());
        }
    }

    public boolean checkStudentExist(String id, String name, String semester, String courseName) {
        for (Student student : students) {
            if (id.equals(student.getId())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && name.equals(student.getStudentName())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    public Student checkIdExist(String id) {
        for (Student student : students) {
            if (id.equals(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public void createStudent() {
        while (true) {
            System.out.print("Enter ID: ");
            String id = val.checkInputId();

            Student student = checkIdExist(id);
            String name;
            if (student == null) {
                System.out.print("Enter name: ");
                name = val.checkString();
            } else {
                name = student.getStudentName();
                System.out.println("Student name: " + name);
            }

            while (true) {
                System.out.print("Enter semester: ");
                String semester = val.checkInputSemester();

                System.out.print("Enter course: ");
                String course = val.checkCourseName();

                if (checkStudentExist(id, name, semester, course)) {
                    students.add(new Student(id, name, semester, course));
                    break;
                } else {
                    System.err.println("This record is existed. Please enter again!");
                }
            }

            if (students.size() > 10) {
                System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
                if (!val.checkInputYN()) {
                    return;
                }
            } else {
                System.out.println("There was not enough student in the list. Please keep entering");
            }
        }
    }

    public void findAndSort() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }

        ArrayList<Student> ListStudent = new ArrayList<>();
        while (true) {
            System.out.print("Enter name: ");
            String name = val.checkString();

            ListStudent.clear();
            for (Student student : students) {
                if (student.getStudentName().contains(name)) {
                    ListStudent.add(student);
                }
            }
            if (ListStudent.isEmpty()) {
                System.err.println("No student found with that name. Please enter again!");
            } else {
                break;
            }
        }

        Collections.sort(ListStudent);
        System.out.println("List of students found:");
        System.out.printf("%-25s%-15s%-15s\n", "Student name", "semester", "Course Name");

        for (Student student : ListStudent) {
            System.out.printf("%-25s%-15s%-15s\n", student.getStudentName(), student.getSemester(), student.getCourseName());
        }
    }

    public ArrayList<Student> findStudentByID(String id) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (id.equals(student.getId())) {
                list.add(student);
            }
        }
        return list;
    }

    public Student displayListStudentFindById(ArrayList<Student> listFindByID) {
        System.out.println("List student found: ");
        System.out.printf("%-5s%-25s%-15s%-15s\n", "No", "Student name", "semester", "Course Name");

        for (int i = 0; i < listFindByID.size(); i++) {
            Student student = listFindByID.get(i);
            System.out.printf("%-5s%-25s%-15s%-15s\n", i + 1, student.getStudentName(), student.getSemester(), student.getCourseName());
        }

        System.out.print("Enter your choice: ");
        int choice = val.checkChoice(1, listFindByID.size());
        return listFindByID.get(choice - 1);
    }

    public void UpdateOrDelete() {
        if (students.isEmpty()) {
            System.err.println("No students in the list.");
            return;
        }

        System.out.print("Enter ID: ");
        String id = val.checkString();

        ArrayList<Student> ListStudentFindByID = findStudentByID(id);
        if (ListStudentFindByID.isEmpty()) {
            System.err.println("Not found student!");
        } else {
            Student student = displayListStudentFindById(ListStudentFindByID);
            System.out.println("Do you want to update (U) or delete (D) student. If user chooses U, the program allows user updating. Choose D for deleting student.");

            if (val.checkInputUD()) {
                System.out.printf("%-25s%-15s%-15s\n", "Student name", "Semester", "Course name");
                System.out.printf("%-25s%-15s%-15s\n", ListStudentFindByID.get(0).getStudentName(),
                        ListStudentFindByID.get(0).getSemester(),
                        ListStudentFindByID.get(0).getCourseName());

                System.out.println("Choose field to update:");
                System.out.println("1. Name");
                System.out.println("2. Semester");
                System.out.println("3. Course");
                System.out.print("Enter your choice: ");
                int Choice = val.checkChoice(1, 3);

                switch (Choice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = val.checkString();
                        if (!checkStudentExist(id, newName, student.getSemester(), student.getCourseName())) {
                            System.err.println("This record already exists. Please enter again!");
                        } else {
                            for (Student s : students) {
                                if (s.getId().equalsIgnoreCase(id)) {
                                    s.setStudentName(newName);
                                }
                            }
                            System.out.println("Name updated successfully!");
                        }
                        break;

                    case 2:
                        System.out.print("Enter new semester: ");
                        String newSemester = val.checkString();
                        if (!checkStudentExist(id, student.getStudentName(), newSemester, student.getCourseName())) {
                            System.err.println("This record already exists. Please enter again!");
                        } else {
                            student.setSemester(newSemester);
                            System.out.println("Semester updated successfully!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter new course: ");
                        String newCourse = val.checkString();
                        if (!checkStudentExist(id, student.getStudentName(), student.getSemester(), newCourse)) {
                            System.err.println("This record already exists. Please enter again!");
                        } else {
                            student.setCourseName(newCourse);
                            System.out.println("Course updated successfully!");
                        }
                        break;
                }
            } else {
                System.out.println("Are you sure to delete this record? Choose Y to continue, N to return main screen.");
                if (val.checkInputYN()) {
                    students.remove(student);
                    System.out.println("Delete successfully!");
                }
            }
        }
    }

    public void Report() {
        HashMap<String, Integer> reportMap = new HashMap<>();
        for (Student student : students) {
            String key = student.getStudentName() + "," + student.getCourseName();
            if (reportMap.containsKey(key)) {
                reportMap.put(key, reportMap.get(key) + 1);
            } else {
                reportMap.put(key, 1);
            }
        }

        ArrayList<String> sortedKey = new ArrayList<>(reportMap.keySet());
        Collections.sort(sortedKey);

        for (String key : sortedKey) {
            String keyComponents[] = key.split(",");
            String name = keyComponents[0];
            String course = keyComponents[1];
            int total_course = reportMap.get(key);
            System.out.println(String.format("%-15s | %-5s | %-5s", name, course, total_course));
        }
    }
}
