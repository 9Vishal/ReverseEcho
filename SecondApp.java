import java.awt.*;

class MyFrame extends Frame
{
    Label l;
    TextField tf;
    Button b;
    
    public MyFrame()
    {
        super("My App");

        setLayout(new FlowLayout());

        l=new Label("Name");
        tf=new TextField(20 );
        b= new Button("Ok");

        add(l);
        add(tf);
        add(b);

    }
}
public class SecondApp
{
    public static void main(String arg[]){
        MyFrame f= new MyFrame();
        f.setSize(500,500);
        f.setVisible(true);
    }
}