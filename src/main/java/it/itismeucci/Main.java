package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            Socket mySocket = new Socket("localhost", 5673);
            System.out.println("il client si è collegato");
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            out.writeBytes("ciao che bello essere collegati insieme \n");
            
            String stringaCambiatadalServer=in.readLine();
            System.out.println("nuova stringa= "+stringaCambiatadalServer);

            mySocket.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}