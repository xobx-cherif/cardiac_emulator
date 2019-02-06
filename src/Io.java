package com.xobx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class controls the virtual I/O of the simulator.
public final class Io {

    private List<String> reader = new ArrayList<String>() ;
    private List<String> output = new ArrayList<String>() ;
    public String deck;

    /*This method initializes the input reader.*/
    public void initReader(){

        this.reader.clear();
    }

    /*This method initializes the output.*/

    public void initOutput(){

        this.output.clear();
    }

    /*This method will read a list of instructions into the reader.*/

    public void readDeck(){

        try{
            BufferedReader br= new BufferedReader(new FileReader(deck));
            String line = br.readLine();
            while(line != null){

                reader.add(line);
                line = br.readLine();

            }
        } catch(Exception e){

            System.out.print("error: Deck file doesn't exist");
        }


        //Collections.reverse(reader);

    }


    /*This method is to format the output of this virtual IO device.*/

    public String formatOutput(){

        String[] outs = this.output.toArray(new String[0]);
        return String.join("\n",outs);
    }

    /*This method is to format the input of this virtual IO device.*/
    public String formatInput(){

        String[] ins = this.reader.toArray(new String[0]);
        return String.join("\n",ins);
    }

    public void stdOut(String data){

        output.add(data);

    }

    public String getInput() {
        try {
            String g = reader.get(0);
            reader.remove(0);
            return g;
        } catch (IndexOutOfBoundsException e){
            System.out.print("INP: ");
    }
        return "000";
    }

    // Output getter.
    public List<String> getOutput() {
        return this.output;
    }
    // Input getter.
    public List<String> getReader() {
        return this.reader;
    }
}
