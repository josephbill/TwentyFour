package com.example;

import com.africastalking.AfricasTalking;
import  com.africastalking.Server;

public class Here {
    private static final int RPC_PORT = 35897;
    public static void main (String[] args) {
        System.out.println("starting server");
        //initialize sdk
        AfricasTalking.initialize("sandbox", "b227098aeb9184380d621bd0e63b1a4b53b164b52abae0b922dab570b2c2b09d");
        //intialize server
        Server server = new Server();
        try {
            server.startInsecure(RPC_PORT);
            while (true){
                Thread.sleep(30000);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
