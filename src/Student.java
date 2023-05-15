import java.util.*;
import java.io.*;

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
        Datasource d = new Datasource();
        d.readPapers();
        int no=0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n");
        for(QuestionPaper paper : d.papers){
            no++;
            System.out.println("        "+no+" "+paper.name);
        }
    }

    public void startExam() throws Exception{
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        viewPapers();
        System.out.print("\n        Enter the Paper number to be start exam : ");
        int ch = sc.nextInt();
        ch=ch-1;
        int add = d.papers.get(ch).takeExam();
        medals = medals+add;
        d.readFile();
        int i=0;
        for(Student stu : d.users){
            if(stu.name.equals(this.name))
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
            System.out.println("\n\n          -----STUDENT DASHBOARD-----");
            System.out.println("              1. View Question Papers");
            System.out.println("              2. Take Exam");
            System.out.println("              3. View Leaderboard");
            System.out.println("              4. LOG OUT");
            System.out.println("          ---------------------------");
            System.out.print("          Enter Your Choice : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    viewPapers();
                    System.out.print("\n\n        Press Enter key to Continue");
                    sc.nextLine();
                }
                case 2 -> startExam();
                case 3 -> {
                    Leaderboard.showBoard();
                    System.out.print("\n\n        Press Enter key to Continue");
                    sc.nextLine();
                }
                case 4 -> {
                    return;
                }
                default -> {
                    System.out.println("\n        Invalid Choice, try again");
                    System.out.print("        Login Failed, Press Enter to continue");
                    sc.nextLine();
                }
            }
        }
    }
}
