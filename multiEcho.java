import java.util.*;
import java.net.*;
import java.io.*;

public class multiEcho extends Thread
{
    Socket stk;
    public multiEcho (Socket st){
        stk=st;
    }
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
            PrintStream ps = new PrintStream(stk.getOutputStream());
            String msg;
            StringBuilder reversedMsg;
            do{
                msg = br.readLine(); // reading 

                reversedMsg = new StringBuilder(msg);
                reversedMsg.reverse();
                msg=reversedMsg.toString();// reversing

                ps.println(msg); // writing 
            }while(!msg.equals("dne"));
            stk.close();
        }catch(Exception e){};
    }
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(2000);
        Socket stk;
        multiEcho re;
        int count=0;
        do{
            stk=ss.accept();
            System.out.println("Client Connected " + count++);
            re=new multiEcho(stk);
            re.start();
        }while(true);
    }
}

class Client{
    public static void main(String[] arg) throws Exception{
        Socket stk = new Socket("localhost",2000);

        BufferedReader keyb=new BufferedReader(new InputStreamReader(System.in));
         BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
        PrintStream ps = new PrintStream(stk.getOutputStream());
        String msg;
        do{
            msg=keyb.readLine();
            ps.println(msg);
            msg=br.readLine();
            System.out.println("From Server "+ msg);
        }while (!msg.equals("dne"));

    }
}


 