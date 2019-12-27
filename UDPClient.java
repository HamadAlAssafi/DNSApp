/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT340;
import java.io.*;

import java.net.*;
/**
 *
 * @author hamad
 */
public class UDPClient {
    public static void main(String[] args) throws IOException{

    	//recive website from the user (client)
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        DatagramSocket cSocket = new DatagramSocket (9876);
        
        InetAddress IPAddress;
        //check weather the user enter a website or not
        if(args.length == 0)
            IPAddress = InetAddress.getLocalHost();
        //if user enter website we will take his name from index 0
        else
            IPAddress = InetAddress.getByName(args[0]);
        
        byte [] sData = new byte [1024];
        byte [] rData = new byte [1024];
        
        System.out.println("Enter Host Name");
        //save the input from user in host varible
        String host = in.readLine();
        //convert String varible (host) to bytes
        sData = host.getBytes();
        //													IP Address machine and port number = 3456
        DatagramPacket packet = new DatagramPacket(sData , sData.length,IPAddress,3456);
        //send data to server
        cSocket.send(packet);
        //packet to recive data from server
        DatagramPacket recivePacket = new DatagramPacket (rData , rData.length);
        //receive it through the socket of client side
        cSocket.receive(recivePacket);
        //convert from byte to String 
        String IP = new String (recivePacket.getData());
        //print the IP Address for the host or website
        System.out.println("IP Address : " + IP);
        
        cSocket.close();

                }
}
