package com.xobx;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cardiac c = new Cardiac();
        c.io.deck=args[0];
        System.out.print("===============================================");
        System.out.print("\n Cardiac core emulator by xobx :");
        System.out.print("\n===============================================");
        System.out.print("\n READING THE DECK: "+args[0]);
        System.out.print("\n-----------------------------------------------\n");
        c.init();
        System.out.print(c.io.formatInput());
        System.out.print("\n-----------------------------------------------");

        try{
            System.out.print("\n RUNNING THE CODE:\n");
            c.run();
        }catch(Exception e){

            System.out.print(" DONE\n");
        }
        System.out.print("-----------------------------------------------");
        System.out.print("\n OUTPUT: \n");
        System.out.print("===============================================\n");
        System.out.print(c.io.formatOutput());
        System.out.print("\n===============================================\n");
        System.out.print("END \n");
        System.out.print("===============================================\n");
    }
}
