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
public class UDPServer {
    public static void main(String[] args) throws IOException {
        while(true){
            DatagramSocket socket = new DatagramSocket(3456);
            
            byte [] sData = new byte [1024];
            byte [] rData = new byte [1024];
            
            DatagramPacket reciverPacket = new DatagramPacket (rData,rData.length);
            
            socket.receive(reciverPacket);
            //The IP of machine
            InetAddress IPAddress = reciverPacket.getAddress();
            
            String IP;
            
            InetAddress Address;
            
            //convert data from byte to string
            String host = new String (reciverPacket.getData());
            
            System.out.println(host);
            		// gives the ip from the URL
                Address = InetAddress.getByName(host);
                // Give me the IP address in String format
                IP = Address.getHostAddress();
                //convert the IP to byte and send it to client side
               sData = IP.getBytes();
               //												machine IP address    port number of client side =9876
               DatagramPacket packet = new DatagramPacket (sData , sData.length,IPAddress,9876);

               //send packet to client side
               socket.send(packet);
            
           
            socket.close();
        }
    }
}
