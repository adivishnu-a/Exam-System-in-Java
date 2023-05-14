public class Student {
    String name;
    String pass;
    int medals;

    public Student(String n, String p, int m){
        this.name = n;
        this.pass = p;
        this.medals = m;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setPass(String p){
        this.pass = p;
    }

    public void setName(int m){
        this.medals = m;
    }

    public String getName(){
        return name;
    }

    public String getPass(){
        return pass;
    }

    public int getMedals(){
        return medals;
    }


}
