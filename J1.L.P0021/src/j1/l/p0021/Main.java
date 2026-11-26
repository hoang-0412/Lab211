package j1.l.p0021;

public class Main {

    private final static Validation val = new Validation();
    private final static StudentManagementService sms = new StudentManagementService();

    public static void main(String[] args) {
        while (true) {
            sms.displayMenu();
            int choice = val.checkChoice(1, 6);
            switch (choice) {
                case 1:
                    sms.createStudent();
                    break;
                case 2:
                    sms.findAndSort();
                    break;
                case 3:
                    sms.UpdateOrDelete();
                    break;
                case 4:
                    sms.Report();
                    break;
                case 5:
                    sms.displayAll();
                    break;
                case 6:
                    return;
            }
        }
    }
}
