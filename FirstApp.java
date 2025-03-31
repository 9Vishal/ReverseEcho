import java.awt.*;

public class FirstApp
{
    public static void main(String arg[]){
        Frame f=new Frame("My First App");
        f.setLayout(new FlowLayout());


        Button b = new Button("Ok");
        Label l =new Label("Name ");
        TextField tf = new TextField(20);
        f.add(l);
        f.add(tf);
        f.add(b);
        
        f.setSize(500,500);
        f.setVisible(true);
    }
}