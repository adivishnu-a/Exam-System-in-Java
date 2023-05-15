import java.util.*;
import java.io.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ch;
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--------------------------------");
            System.out.println("-------EXAMINATION SYSTEM-------");
            System.out.println("--------------------------------");
            System.out.println("        Select User Type        ");
            System.out.println("       1. EXISTING STUDENT      ");
            System.out.println("          2. NEW STUDENT        ");
            System.out.println("            3. ADMIN            ");
            System.out.println("--------------------------------");
            System.out.println("        Select 4 to EXIT        ");
            System.out.println("--------------------------------");
            System.out.println("Enter : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    Student stu = Authentication.StuLogin();
                    if (stu != null) {
                        stu.stuMenu();
                    } else {
                        System.out.println("Login Failed, Press Enter to continue");
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
                        System.out.println("Login Failed, Press Enter to continue");
                        sc.nextLine();
                    }
                }
                case 4 -> exit(0);
                default -> System.out.println("\nInvalid Choice, try again");
            }
        }
    }
}
