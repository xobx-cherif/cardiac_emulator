package com.xobx;

import java.util.stream.IntStream;

public class Cardiac {

    public Io io = new Io();
    private Memory mem = new Memory();
    private Cpu cpu = new Cpu();

    private int opcode , data;

    Cardiac(){

        this.io.initOutput();
        this.io.initReader();
        this.mem.initMem();
        this.cpu.reset();

    }

    public void init(){

        this.io.readDeck();
    }

    public void fetch(){

        this.cpu.setIr(mem.getMemInt(this.cpu.getPc()));
        this.cpu.incrementPc();
    }

    public void decode(){

        opcode = (int)Math.floor(this.cpu.getIr() / 100);
        data =  this.cpu.getIr() % 100;

        switch (opcode){

            case 0: opcode_0();
                    break;
            case 1: opcode_1();
                    break;
            case 2: opcode_2();
                    break;
            case 3: opcode_3();
                    break;
            case 4: opcode_4();
                    break;
            case 5: opcode_5();
                    break;
            case 6: opcode_6();
                    break;
            case 7: opcode_7();
                    break;
            case 8: opcode_8();
                    break;
            case 9: opcode_9();
                    break;

        }

    }

    public void execute(){

        this.fetch();
        this.decode();

    }

    /* INP: input operation */

    public void opcode_0(){

        this.mem.setMem(this.io.getInput(),this.data);
        System.out.print("INP "+ this.data+"\n");

    }

    /* CLA: Clear accumulator and add from memory (load)*/

    public void opcode_1(){

        this.cpu.setAcc(this.mem.getMemInt(this.data));
        System.out.print("CLA "+ this.data+"\n");
    }

    /* ADD: Add from memory to accumulator*/

    public void opcode_2(){

        this.cpu.setAcc(this.cpu.getAcc()+this.mem.getMemInt(this.data));
        System.out.print("ADD "+ this.data+"\n");
    }

    /* TAC: Test accumulator and jump if negative*/

    public void opcode_3(){

        if(this.cpu.getAcc()<0){

            this.cpu.setPc(this.data);
        }
        System.out.print("TAC "+ this.data+"\n");
    }

    /* SHT: Shift accumulator*/

    public void opcode_4(){

        int x,y;

        x = (int)Math.floor(this.data / 10);
        y = this.data % 10;

        IntStream.range(0, x).forEach(i -> this.cpu.setAcc((this.cpu.getAcc() * 10) % 10000));
        IntStream.range(0, y).forEach(i -> this.cpu.setAcc((int)Math.floor(this.cpu.getAcc() /10)));
        System.out.print("SHT "+ this.data+"\n");
    }

    /* OUT: Output operation */

    public void opcode_5(){

        this.io.stdOut(this.mem.getMem(this.data));
        System.out.print("OUT "+ this.data+"\n");
    }

    /* STO: Store accumulator to memory*/

    public void opcode_6(){

        this.mem.setMem(this.mem.pad(this.cpu.getAcc()), this.data);
        System.out.print("STO "+ this.data+"\n");
    }

    /* SUB: Subtract memory from accumulator */

    public void opcode_7(){

        this.cpu.setAcc(this.cpu.getAcc() - this.mem.getMemInt(this.data));
        System.out.print("SUB "+ this.data+"\n");
    }

    /* JMP: Jump and save PC */

    public void opcode_8(){

        this.cpu.setPc(this.data);
        System.out.print("JMP "+ this.data+"\n");
    }

    /* HRS: reset and halt */

    public void opcode_9(){

        this.cpu.reset();
        System.out.print("HRS "+ this.data+"\n");

    }

    public void run(){

        this.cpu.setRunning(true);
        while(this.cpu.getRunning()) {

            this.execute();

        }
    }

}
