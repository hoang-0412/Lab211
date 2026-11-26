package j1.s.p0071;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskManagementService {

    private final static Validation val = new Validation();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int id = 1;

    public TaskManagementService() {
        tasks.add(new Task(1, "code", "dev program", "23-04-2026", "8.0", "10.0", "trinh huy hoang", "nguyen van a"));
        tasks.add(new Task(2, "test", "test app", "01-05-2026", "10.0", "12.0", "trinh huy hoang", "nguyen van b"));
        tasks.add(new Task(3, "design", "design UI", "23-04-2026", "10.0", "12.5", "tran van nam", "nguyen van c"));
        tasks.add(new Task(4, "review", "review project", "24-04-2026", "13.0", "15.0", "trinh huy hoang", "nguyen van d"));
        tasks.add(new Task(5, "code", "dev app", "25-04-2026", "15.0", "17.5", "le van an", "nguyen van e"));
    }

    public boolean checkTaskExist(String requirementName, String taskTypeId, String date, String planFrom, String planTo, String assignee, String reviewer, ArrayList<Task> listTask) {
        for (Task task : listTask) {
            if (requirementName.equalsIgnoreCase(task.getRequirementName())
                    && taskTypeId.equals(task.getTaskTypeId())
                    && date.equals(task.getDate())
                    && planFrom.equals(task.getPlanFrom())
                    && planTo.equals(task.getPlanTo())
                    && assignee.equalsIgnoreCase(task.getassignee())
                    && reviewer.equalsIgnoreCase(task.getreviewer())) {
                return false;
            }
        }
        return true;
    }

    public boolean isAssigneeBusy(String assignee, String date, String planFrom, String planTo) {
        double newFrom = Double.parseDouble(planFrom);
        double newTo = Double.parseDouble(planTo);

        for (Task task : tasks) {
            if (task.getassignee().equalsIgnoreCase(assignee) && task.getDate().equals(date)) {
                double oldFrom = Double.parseDouble(task.getPlanFrom());
                double oldTo = Double.parseDouble(task.getPlanTo());

                if (newFrom < oldTo && newTo > oldFrom) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getNextId() {
        int lastId = 0;
        for (Task task : tasks) {
            if (task.getId() > lastId) {
                lastId = task.getId();
            }
        }
        return lastId + 1;
    }

    public void addTask(int id) {
        System.out.println("=========== ADD TASK ===========");
        while (true) {
            System.out.print("Requirement Name: ");
            String requirementName = val.checkString();

            System.out.print("Task Type: ");
            String taskTypeId = val.checkTaskTypeId();

            System.out.print("Date: ");
            String date = val.checkDate();

            String planFrom, planTo;
            while (true) {
                System.out.print("From: ");
                planFrom = val.checkPlan();

                System.out.print("To: ");
                planTo = val.checkPlan();
                if (Double.parseDouble(planTo) > Double.parseDouble(planFrom)) {
                    break;
                } else {
                    System.err.println("'PLAN TO' MUST BE GREATER THAN 'PLAN FROM'. PLEASE ENTER AGAIN");
                }
            }

            System.out.print("Assignee: ");
            String assignee = val.checkString();

            if (isAssigneeBusy(assignee, date, planFrom, planTo)) {
                System.err.println("THIS ASSIGNEE ALREADY HAS A TASK AT THIS TIME. PLEASE ENTER AGAIN");
                continue;
            }

            System.out.print("Reviewer: ");
            String reviewer;
            while (true) {
                reviewer = val.checkString();
                if (reviewer.equalsIgnoreCase(assignee)) {
                    System.err.println("ASSIGNEE CAN NOT STILL BE REVIEWR");
                    System.out.print("ENTER AGAIN: ");
                } else {
                    break;
                }
            }

            if (checkTaskExist(requirementName, taskTypeId, date, planFrom, planTo, assignee, reviewer, tasks)) {
                tasks.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assignee, reviewer));
                System.out.println("THE TASK IS ADDED SUCCESSFULLY");
                break;
            } else {
                System.err.println("THIS RECORD WAS EXISTED. PLEASE ENTER AGAIN");
            }
        }
    }

    public int findTaskById(ArrayList<Task> listTask) {
        System.out.println("========= DELETE TASK ==========");
        System.out.print("ID: ");
        int findId = val.checkInt();
        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getId() == findId) {
                return i;
            }
        }
        System.err.println("THIS ID CAN NOT FOUND IN THE LIST");
        return -1;
    }

    public void deleteTask(int id) {
        if (tasks.isEmpty()) {
            System.err.println("LIST TASK IS EMPTY");
        }

        id = findTaskById(tasks);
        if (id != -1) {
            LocalDate taskDate = LocalDate.parse(tasks.get(id).getDate(), formatter);
            if (taskDate.isBefore(LocalDate.now())) {
                System.err.println("CAN NOT DELETE TASK IN THE PAST BECAUSE IT WAS DONE");
                return;
            }
            tasks.remove(id);
            System.out.println("THE TASK IS DELETED SUCCESSFULLY");
        }
    }

    public void displayTask() {
        if (tasks.isEmpty()) {
            System.err.println("LIST TASK IS EMPTY");
        }

        System.out.println("============================================== Task ==============================================");
        System.out.printf("%-5s%-20s%-15s%-15s%-10s%-25s%-25s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%-5d%-20s%-15s%-15s%-10.1f%-25s%-25s\n",
                    tasks.get(i).getId(),
                    tasks.get(i).getRequirementName(),
                    tasks.get(i).getTaskTypeId(),
                    tasks.get(i).getDate(),
                    Double.parseDouble(tasks.get(i).getPlanTo()) - Double.parseDouble(tasks.get(i).getPlanFrom()),
                    tasks.get(i).getassignee(),
                    tasks.get(i).getreviewer()
            );
        }
    }
}
