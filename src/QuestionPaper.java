import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Question{
    String que;
    String[] ops = {"","","",""};
    int ans,ch;

    public Question(){
        //Place Holder
    }

    public Question(String q, String[] o, int a){
        this.que = q;
        this.ops = o;
        this.ans = a;
    }
}

public class QuestionPaper {
    String name;
    int num;
    ArrayList<Question> questions = new ArrayList<>();

    public void readPaper() throws Exception {
        File file = new File("files/"+name+".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        num = Integer.parseInt(reader.readLine());
        for(int i=0; i<num; i++){
            Question q = new Question();
            q.que = reader.readLine();
            for(int j=0; j<4; j++){
                q.ops[j] = reader.readLine();
            }
            q.ans = Integer.parseInt(reader.readLine());
            questions.add(q);
        }
    }

    public void savePaper() throws Exception{
        File file = new File("files/"+name+".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(num);
        for(int i=0; i<num; i++){
            writer.newLine();
            writer.write(questions.get(i).que);
            writer.newLine();
            for(int j=0; j<4; j++){
                writer.write(questions.get(i).ops[j]);
                writer.newLine();
            }
            writer.write(questions.get(i).ans);
        }
        writer.close();
    }

    public void setPaper() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter Test Name Once Again to Start : ");
        name = sc.nextLine();
        System.out.println("Enter the total number of questions : ");
        num = sc.nextInt();
        for(int i=0; i<num; i++){
            System.out.println("\nEnter Question "+(i+1)+" : \n");
            String ques = sc.nextLine();
            String[] op = {"", "", "", ""};
            for(int j=0; j<4; j++){
                System.out.println("Enter Option "+(j+1)+" : ");
                op[j] = sc.nextLine();
            }
            System.out.println("Enter the correct option number : ");
            int sol = sc.nextInt();
            Question newQue = new Question(ques, op, sol);
            questions.add(newQue);
        }
        savePaper();
    }

    public void editPaper() throws Exception{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        readPaper();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<num; i++){
            System.out.println((i+1)+" "+questions.get(i).que);
        }
        System.out.println("\nEnter the question number which needs to be edited : ");
        int inp = sc.nextInt();
        inp=inp-1;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the new question : \n");
        questions.get(inp).que = sc.nextLine();
        for(int i=0; i<4; i++){
            System.out.println("Enter option "+(i+1)+" : ");
            questions.get(inp).ops[i] = sc.nextLine();
        }
        System.out.println("Enter correct option number : ");
        questions.get(inp).ans = sc.nextInt();
        savePaper();
    }

    public int takeExam() throws Exception{
        readPaper();
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        int points=0;
        readPaper();
        System.out.println("Press Enter key to continue");
        sc.next();
        for(int i=0; i<num; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\t"+name);
            System.out.println("\n"+questions.get(i).que+"\n");
            for(int j=0; j<4; j++){
                System.out.println((j+1)+questions.get(i).ops[j]);
            }
            System.out.println("\nEnter your choice : ");
            questions.get(i).ch = sc.nextInt();
            if(questions.get(i).ans == questions.get(i).ch){
                points++;
            }
        }
        return points;
    }
}
