import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.Console;

//v0.1.0

public class Authentication {
    public static Student StuLogin() throws IOException {
        Scanner sc = new Scanner(System.in);
        Console con = System.console();
        Datasource d = new Datasource();
        String inName, inPass;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n        \u001B[34m-----LOG IN-----\u001B[0m");
        System.out.print("        Enter Username : ");
        inName = sc.nextLine();
        System.out.print("        Enter Password(hidden for security) : ");
        char[] ch=con.readPassword();
        inPass = String.valueOf(ch);
        d.readFile();
        for(Student temp : d.users){
            if(Objects.equals(inName, temp.name)){
                if(inPass.equals(temp.pass)){
                    return new Student(temp.name, temp.pass, temp.medals);
                }
            }
        }
        return null;
    }

    public static void StuSignup() throws Exception {
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readFile();
            String inName, inPass;
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n\n        \u001B[34m-----SIGN UP-----\u001B[0m");
            System.out.print("        Enter Username : ");
            inName = sc.nextLine();
            for(Student check : d.users){
                if(check.name.equals(inName)){
                    System.out.print("\n        \u001B[31mUsername already exists. Press ENTER to continue\u001B[0m");
                    sc.nextLine();
                    return;
                }
            }
            System.out.print("        Enter Password : ");
            inPass = sc.nextLine();
            Student newstu = new Student(inName, inPass, 0);
            d.users.add(newstu);
            d.saveFile();
            System.out.print("\n        \u001B[32mAccount created successfully. Press Enter to Continue\u001B[0m");
            sc.nextLine();
    }

    public static boolean AdminLogin() throws IOException {
        Scanner sc = new Scanner(System.in);
        Console con = System.console();
        Datasource d = new Datasource();
        String inName, inPass;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n        \u001B[34m-----LOG IN-----\u001B[0m");
        System.out.print("        Enter Username : ");
        inName = sc.nextLine();
        System.out.print("        Enter Password(hidden for security) : ");
        char[] ch=con.readPassword();
        inPass = String.valueOf(ch);
        if(inName.equals(d.AdminName)){
            return inPass.equals(d.AdminPass);
        }
        return false;
    }
}
