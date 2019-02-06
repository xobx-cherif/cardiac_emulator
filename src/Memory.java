package com.xobx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// This class controls the virtual memory space of the simulator.
public final class Memory {
    List<String> mem = new ArrayList<String>();
    private static int size=3;

    //This method resets the Cardiac's memory space to all blank strings, as per Cardiac specs.
    public void initMem(){

        IntStream.range(0, 100).forEach(i -> mem.add(i, ""));
        this.mem.set(0 ,"001");
    }
    /*Since our memory storage is *string* based, like the real Cardiac, we need
    a reusable function to grab a integer from memory.                        */
    public int getMemInt(int i){
        String m = this.mem.get(i);
        return Integer.parseInt(m);
    }
    /*This function pads either an integer or a number in string format with
        zeros.  This is needed to replicate the exact behavior of the Cardiac.*/
    public String pad(int data ){
        String dataS = Integer.toString(data);
        return String.format("%3s",dataS).replace(' ','0');

    }

    public String getMem(int addr) {
        return this.mem.get(addr);
    }

    public void setMem(String mem, int addr) {
        this.mem.set(addr, mem);
    }
}
