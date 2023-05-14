import java.awt.event.*;
import javax.swing.*;

class BetaQuiz extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton[] jb =new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0;
    int current=0;
    int x=1;
    int now=0;
    int[] m =new int[10];
    BetaQuiz(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Bookmark"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"correct ans="+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Which component is used to compile, debug and execute the java programs?");
            jb[0].setText("JRE");jb[1].setText("JIT");jb[2].setText("JDK");jb[3].setText("JVM");
        }
        if(current==1)
        {
            l.setText("Que2: Which one of the following is not a Java feature?");
            jb[0].setText("Object-oriented");jb[1].setText("Use of pointers");jb[2].setText("Portable");jb[3].setText("Dynamic and Extensible");
        }
        if(current==2)
        {
            l.setText("Que3: Which package is directly available to our class without importing it");
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
        }
        if(current==3)
        {
            l.setText("Que4: String class is defined in which package");
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
        }
        if(current==4)
        {
            l.setText("Que5: Which of these cannot be used for a variable name in Java?");
            jb[0].setText("identifier & keyword");jb[1].setText("identifier");jb[2].setText("keyword");jb[3].setText("none of the mentioned");
        }
        if(current==5)
        {
            l.setText("Que6: Which environment variable is used to set the java path?");
            jb[0].setText("MAVEN_Path");jb[1].setText("JavaPATH");jb[2].setText("JAVA");jb[3].setText("JAVA_HOME");
        }
        if(current==6)
        {
            l.setText("Que7: What is the extension of java code files?");
            jb[0].setText(".js");jb[1].setText(".txt");jb[2].setText(".java");jb[3].setText(".class");
        }
        if(current==7)
        {
            l.setText("Que8: What is not the use of “this” keyword in Java?");
            jb[0].setText("Referring to the instance variable when a local variable has the same name");jb[1].setText("Passing itself to the method of the same class");jb[2].setText("Passing itself to another method");jb[3].setText("Calling another constructor in constructor chaining");
        }
        if(current==8)
        {
            l.setText("Que9: Which of the following is a type of polymorphism in Java Programming?");
            jb[0].setText("Multiple polymorphism");jb[1].setText("Compile time polymorphism");jb[2].setText("Multilevel polymorphism");jb[3].setText("Execution time polymorphism");
        }
        if(current==9)
        {
            l.setText("Que10: Which of these keywords is used to define interfaces in Java?");
            jb[0].setText("intf");jb[1].setText("Intf");jb[2].setText("interface");jb[3].setText("Interface");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[2].isSelected());
        if(current==1)
            return(jb[1].isSelected());
        if(current==2)
            return(jb[3].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[3].isSelected());
        if(current==6)
            return(jb[2].isSelected());
        if(current==7)
            return(jb[1].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
    public static void main(String[] s)
    {
        new BetaQuiz("Online Java Examination");
    }


}