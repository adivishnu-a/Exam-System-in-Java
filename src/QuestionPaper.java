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
        File file = new File("files\\qdata\\"+name+".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        num = Integer.parseInt(Security.decStr(reader.readLine()));
        for(int i=0; i<num; i++){
            Question q = new Question();
            q.que = Security.decStr(reader.readLine());
            for(int j=0; j<4; j++){
                q.ops[j] = Security.decStr(reader.readLine());
            }
            q.ans = Integer.parseInt(Security.decStr(reader.readLine()));
            questions.add(q);
        }
    }

    public void savePaper() throws Exception{
        File file = new File("files\\qdata\\"+name+".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(Security.encInt(num));
        for(int i=0; i<num; i++){
            writer.newLine();
            writer.write(Security.encStr(questions.get(i).que));
            writer.newLine();
            for(int j=0; j<4; j++){
                writer.write(Security.encStr(questions.get(i).ops[j]));
                writer.newLine();
            }
            writer.write(Security.encInt(questions.get(i).ans));
        }
        writer.close();
    }

    public void setPaper(String name) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        this.name = name;
        System.out.print("        Enter the total number of questions : ");
        num = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<num; i++){
            System.out.println("\n        Enter Question "+(i+1)+" : ");
            String ques = sc.nextLine();
            String[] op = {"", "", "", ""};
            for(int j=0; j<4; j++){
                System.out.print("        Enter Option "+(j+1)+" : ");
                op[j] = sc.nextLine();
            }
            System.out.print("        Enter the correct option number : ");
            int sol = sc.nextInt();
            sc.nextLine();
            Question newQue = new Question(ques, op, sol);
            questions.add(newQue);
        }
        savePaper();
    }

    public void editPaper() throws Exception{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n");
        readPaper();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<num; i++){
            System.out.println((i+1)+" "+questions.get(i).que);
        }
        System.out.print("\n        Enter the question number which needs to be edited : ");
        int inp = sc.nextInt();
        sc.nextLine();
        inp=inp-1;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n        Enter the new question : ");
        questions.get(inp).que = sc.nextLine();
        for(int i=0; i<4; i++){
            System.out.print("        Enter option "+(i+1)+" : ");
            questions.get(inp).ops[i] = sc.nextLine();
        }
        System.out.print("        Enter correct option number : ");
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
        System.out.print("\n\n        Press Enter key to START");
        sc.nextLine();
        for(int i=0; i<num; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n\n\t        "+name);
            System.out.println("\n        "+questions.get(i).que+"\n");
            for(int j=0; j<4; j++){
                System.out.println("        "+(j+1)+".  "+questions.get(i).ops[j]);
            }
            System.out.print("\n        Enter your choice : ");
            questions.get(i).ch = sc.nextInt();
            if(questions.get(i).ans == questions.get(i).ch){
                points++;
            }
        }
        return points;
    }
}
