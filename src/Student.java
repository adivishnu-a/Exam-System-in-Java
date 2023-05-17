import java.util.*;
import java.io.*;

//v0.1.0

public class Student {
    String name;
    String pass;
    int medals;

    public Student(String n, String p, int m){
        this.name = n;
        this.pass = p;
        this.medals = m;
    }

    public void viewPapers() throws IOException{
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        int no=0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n");
        for(QuestionPaper paper : d.papers){
            no++;
            System.out.println("        "+no+". "+paper.name);
        }
        System.out.print("\n\n        Press Enter key to Continue");
        sc.nextLine();
    }

    public void startExam() throws Exception{
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        viewPapers();
        int add=0;
        try {
            System.out.print("\n        Enter the Paper number to be start exam : ");
            int ch = sc.nextInt();
            ch = ch - 1;
            add = d.papers.get(ch).takeExam();
        } catch (Exception e){
            System.out.println("        \u001B[31mPaper Not Found");
            System.out.print("\n\n        Press Enter key to Continue\u001B[30m");
            sc.nextLine();
        }
        medals = medals + add;
        d.readFile();
        int i = 0;
        for (Student stu : d.users) {
            if (stu.name.equals(this.name))
                break;
            else
                i++;
        }
        d.users.get(i).medals = this.medals;
        d.saveFile();
    }

    public void stuMenu() throws Exception{
        int ch;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n\n          \u001B[32m-----STUDENT DASHBOARD-----\u001B[0m");
            System.out.println("              1. View Question Papers");
            System.out.println("              2. Take Exam");
            System.out.println("              3. View Leaderboard");
            System.out.println("              \u001B[31m4. LOG OUT\u001B[0m");
            System.out.println("          ---------------------------");
            System.out.print("          \u001B[33mEnter Your Choice : \u001B[0m");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> viewPapers();
                case 2 -> startExam();
                case 3 -> Leaderboard.showBoard();
                case 4 -> {
                    return;
                }
                default -> {
                    System.out.println("\n        \u001B[31mInvalid Choice, try again");
                    System.out.print("        Press Enter to continue\u001B[0m");
                    sc.nextLine();
                }
            }
        }
    }
}
