import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
    public void viewPapers() throws IOException{
        Datasource d = new Datasource();
        d.readPapers();
        int no=0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for(QuestionPaper paper : d.papers){
            no++;
            System.out.println(no+" "+paper.name);
        }
    }

    public void addPaper() throws Exception {
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        QuestionPaper newPaper = new QuestionPaper();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter Paper Name : ");
        newPaper.name = sc.nextLine();
        newPaper.setPaper();
        newPaper.savePaper();
        d.papers.add(newPaper);
        d.savePapers();
        System.out.println("Paper created successfully. Press Enter to Continue");
        sc.nextLine();
    }

    public void editPaper() throws Exception {
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        viewPapers();
        System.out.println("\nEnter the Paper number to be edited : ");
        int ch = sc.nextInt();
        ch=ch-1;
        d.papers.get(ch).editPaper();
    }

    public void deletePaper() throws Exception{
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readPapers();
        viewPapers();
        System.out.println("\nEnter the Paper number to be deleted : ");
        int ch = sc.nextInt();
        ch=ch-1;
        File f= new File("files\\"+d.papers.get(ch).name+".txt");
        if(f.delete())
        {
            System.out.println(f.getName() + " Deleted");
        }
        else
        {
            System.out.println("Failed");
        }
        d.papers.remove(ch);
        d.savePapers();
    }

    public void adminMenu() throws Exception {
        int ch;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--------ADMIN DASHBOARD--------");
            System.out.println("   1. View Question Papers     ");
            System.out.println("   2. Add Question Paper       ");
            System.out.println("   3. Edit Question Paper      ");
            System.out.println("   4. Delete Question Paper    ");
            System.out.println("   5. View Leaderboard         ");
            System.out.println("   6. LOG OUT                  ");
            System.out.println("-------------------------------");
            System.out.println("Enter Your Choice : ");
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
                default -> System.out.println("\nInvalid Choice, try again");
            }
        }
    }
}
