import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//v0.1.0

public class Admin {
    public void viewPapers() throws Exception {
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        int no=0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n");
        for(QuestionPaper paper : d.papers){
            no++;
            System.out.println("        "+no+".  "+paper.name);
        }
        System.out.print("\n        Enter the Paper number to view : ");
        int ch = sc.nextInt();
        ch=ch-1;
        d.papers.get(ch).readPaper();
        d.papers.get(ch).viewPaper();
    }

    public void addPaper() throws Exception {
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        QuestionPaper newPaper = new QuestionPaper();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n");
        System.out.println("        Enter Paper Name : ");
        newPaper.name = sc.nextLine();
        newPaper.setPaper(newPaper.name);
        newPaper.savePaper();
        d.papers.add(newPaper);
        d.savePapers();
        System.out.print("\n        Paper created successfully. Press Enter to Continue");
        sc.nextLine();
    }

    public void editPaper() throws Exception {
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        viewPapers();
        System.out.print("\n        Enter the Paper number to be edited : ");
        int ch = sc.nextInt();
        ch=ch-1;
        d.papers.get(ch).editPaper();
        System.out.print("\n\n        Press Enter key to Continue");
        sc.nextLine();
    }

    public void deletePaper() throws Exception{
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        viewPapers();
        System.out.println("\n        Enter the Paper number to be deleted : ");
        int ch = sc.nextInt();
        ch=ch-1;
        File f= new File("C:\\Users\\adivi\\IdeaProjects\\ExamSystem\\files\\"+d.papers.get(ch).name+".txt");
        if(f.delete())
        {
            System.out.println("        "+f.getName() + " Deleted");
        }
        else
        {
            System.out.println("        Failed");
        }
        d.papers.remove(ch);
        d.savePapers();
        System.out.print("\n\n        Press Enter key to Continue");
        sc.nextLine();
    }

    public void adminMenu() throws Exception {
        int ch;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n\n        --------ADMIN DASHBOARD--------");
            System.out.println("           1. View Question Papers     ");
            System.out.println("           2. Add Question Paper       ");
            System.out.println("           3. Edit Question Paper      ");
            System.out.println("           4. Delete Question Paper    ");
            System.out.println("           5. View Leaderboard         ");
            System.out.println("           6. LOG OUT                  ");
            System.out.println("        -------------------------------");
            System.out.print("        Enter Your Choice : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> viewPapers();
                case 2 -> addPaper();
                case 3 -> editPaper();
                case 4 -> deletePaper();
                case 5 -> Leaderboard.showBoard();
                case 6 -> {
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
