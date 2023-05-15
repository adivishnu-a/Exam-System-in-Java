import java.util.*;
import java.io.*;
public class Datasource {
    ArrayList<Student> users = new ArrayList<>();
    String AdminName = "Admin1";
    String AdminPass = "iamadmin";

    public void readFile() throws IOException{
        File file = new File("files/studata.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String n = parts[0];
            String p = parts[1];
            int m = Integer.parseInt(parts[2]);
            Student stu = new Student(n, p, m);
            users.add(stu);
        }
    }

    public void saveFile() throws Exception{
        File file = new File("files/studata.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(Student stu : users){
            writer.write(stu.name+" "+stu.pass+" "+stu.medals);
            writer.newLine();
        }
        writer.close();
    }
}
