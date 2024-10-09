package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            String s="";
            Socket mySocket = new Socket("localhost", 5673);
            System.out.println("il client si è collegato");
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            Scanner inputConsole = new Scanner(System.in);

            do  {

                s = inputConsole.nextLine();
                out.writeBytes(s+" \n");
                
                String stringaCambiatadalServer=in.readLine();
                System.out.println("nuova stringa= "+stringaCambiatadalServer);
            }while((s!="0000"));
            mySocket.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}