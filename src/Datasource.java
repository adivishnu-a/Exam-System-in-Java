import java.util.*;
import java.io.*;

//v0.1.0

public class Datasource {
    ArrayList<Student> users = new ArrayList<>();
    ArrayList<QuestionPaper> papers = new ArrayList<>();
    String AdminName = "admin";
    String AdminPass = "iamadmin";

    public void readFile() throws IOException{
        File file = new File("files\\studata.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            line = Security.decStr(line);
            String[] parts = line.split(" ");
            String n = parts[0];
            String p = parts[1];
            int m = Integer.parseInt(parts[2]);
            Student stu = new Student(n, p, m);
            users.add(stu);
        }
    }

    public void saveFile() throws Exception{
        File file = new File("files\\studata.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(Student stu : users){
            writer.write(Security.encStr(stu.name+" "+stu.pass+" "+stu.medals));
            writer.newLine();
        }
        writer.close();
    }

    public void readPapers() throws IOException{
        File file = new File("files\\papers.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            line = Security.decStr(line);
            QuestionPaper pap = new QuestionPaper();
            pap.name = line;
            papers.add(pap);
        }
    }

    public void savePapers() throws Exception{
        File file = new File("files\\papers.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(QuestionPaper temp : papers){
            writer.write(Security.encStr(temp.name));
            writer.newLine();
        }
        writer.close();
    }
}
