import java.io.*;
import java.util.Scanner;

//v0.1.0

public class Leaderboard {
    public static void showBoard() throws IOException {
        Scanner sc = new Scanner(System.in);
        Datasource d = new Datasource();
        d.readFile();
        for (int i = 0; i < d.users.size(); i++) {
            for (int j = 1; j < (d.users.size() - i); j++) {
                if (d.users.get(j - 1).medals < d.users.get(j).medals) {
                    //swap elements
                    Student temp = d.users.get(j - 1);
                    d.users.set(j - 1, d.users.get(j));
                    d.users.set(j, temp);
                }
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n        ----------LEADERBOARD----------");
        System.out.println("         "+"\u001B[33mRank\tUsername\tMedals\u001B[0m");
        System.out.println("        -------------------------------");
        int rank=0;
        for(Student stu : d.users){
            rank++;
            System.out.println("         "+rank+"\t"+stu.name+"\t\t"+stu.medals);
        }
        System.out.print("\n\n        \u001B[32mPress Enter key to Continue\u001B[0m");
        sc.nextLine();
    }
}
