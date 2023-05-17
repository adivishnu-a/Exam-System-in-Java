import java.util.*;
import static java.lang.System.exit;

//v0.1.0

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ch;
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n\n        --------------------------------");
            System.out.println("        \u001B[33m-------EXAMINATION SYSTEM-------\u001B[0m");
            System.out.println("        --------------------------------");
            System.out.println("                Select User Type        ");
            System.out.println("               1. EXISTING STUDENT      ");
            System.out.println("                  2. NEW STUDENT        ");
            System.out.println("                    3. ADMIN            ");
            System.out.println("        --------------------------------");
            System.out.println("                \u001B[31mSelect 4 to EXIT\u001B[0m        ");
            System.out.println("        --------------------------------");
            System.out.print("        \u001B[33mEnter : \u001B[0m");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> {
                    Student stu = Authentication.StuLogin();
                    if (stu != null) {
                        stu.stuMenu();
                    } else {
                        System.out.print("\n        \u001B[31mLogin Failed, Press Enter to continue\u001B[0m");
                        sc.nextLine();
                    }
                }
                case 2 -> Authentication.StuSignup();
                case 3 -> {
                    Admin adm = new Admin();
                    boolean flag = Authentication.AdminLogin();
                    if (flag) {
                        adm.adminMenu();
                    } else {
                        System.out.print("\n        \u001B[31mLogin Failed, Press Enter to continue\u001B[0m");
                        sc.nextLine();
                    }
                }
                case 4 -> exit(0);
                default -> {
                    System.out.println("\n         \u001B[31mInvalid Choice, try again");
                    System.out.print("        Press Enter to continue\u001B[0m");
                    sc.nextLine();
                }
            }
        }
    }
}
