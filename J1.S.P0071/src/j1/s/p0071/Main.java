package j1.s.p0071;

public class Main {

    private final static Validation val = new Validation();
    private final static TaskManagementService tms = new TaskManagementService();

    private static void displayMenu() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) throws Exception {
        int choice;
        int id = 1;
        while (true) {
            displayMenu();
            choice = val.checkChoice(1, 4);
            switch (choice) {
                case 1:
                    tms.addTask(tms.getNextId());
                    break;
                case 2:
                    tms.deleteTask(id);
                    break;
                case 3:
                    tms.displayTask();
                    break;
                case 4:
                    return;
            }
        }
    }
}
