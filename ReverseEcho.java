import java.util.*;
import java.net.*;
import java.io.*;

class reverseEcho{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(2000);
        Socket stk=ss.accept();

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


 