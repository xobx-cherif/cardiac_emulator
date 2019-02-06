package com.xobx;

public final class Cpu {

    private int pc;
    private int ir;
    private int acc;
    private boolean running;

    public void reset(){

        this.acc = 0;
        this.ir = 0;
        this.pc = 0;
        this.running = false;

    }

    void incrementPc(){

        this.pc += 1;
    }


    /* setters and getters for the class attributes*/

    public int getAcc() {
        return this.acc;
    }

    public int getIr() {
        return this.ir;
    }

    public int getPc() {
        return this.pc;
    }

    public boolean getRunning(){
        return this.running;
    }

    public void setIr(int ir) {
        this.ir = ir;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
