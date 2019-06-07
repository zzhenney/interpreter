package interpreter;

import interpreter.ByteCode.*;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;      
    private Stack<Integer> returnAddrs;          //returnAddress.push(pc);
    private Program program;
    private int pc;                     //is an index location on Program program
    private boolean isRunning;          //data fields remain private but can use getter and setters  
    private boolean dumping;                                   //bytecode cannot say vm.returnRuntimeStack()
                                        //cannot return larger data structures to bytecodes
    protected VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(dumping && !(code instanceof DumpCode)){
                if(code instanceof CallCode){
                    System.out.println(code.toString() + "f(" + lastArg() + ")");
                    runStack.dump();
                }
                else if(code instanceof StoreCode){
                    System.out.println(code.toString() + runStack.peek());
                }
                else if(code instanceof ReturnCode){
                    System.out.println(code.toString() + runStack.peek());
                }
                else{
        
                System.out.println(code.toString());
                runStack.dump();
                }
            }
            //runStack.dump(); //check that the operation is correct
            pc++;
        }
    }
    
    public int peek(){
        return runStack.peek();
    }
    
    public int pop(){
        return runStack.pop();
    }
    
    public int push(int i){
        runStack.push(i);
        return i;
    }
    
    public void newFrameAt(int offset){
        runStack.newFrameAt(offset);
    }
    
    public void popFrame(){
        runStack.popFrame();
    }
    
    public int store(int offset){
        return runStack.store(offset);
    }
    
    public int load(int offset){
        return runStack.load(offset);
    }
    
    //TODO: may not be necessary
    public Integer push(Integer i){
        runStack.push(i);
        return i;   
    }
    
    public void stopVM(){
        isRunning = false;
    }
    
    public int getPC(){
        return pc;
    }
    
    public void setPC(int i){
        pc = i;
    }
    
    public void pushReturnAddr(int i){
        returnAddrs.push(i);
    }
    
    public int getReturnAddr(){
        return returnAddrs.pop();
    }
    
    public int stackSize(){
        return runStack.size();
    }
    
    public void dumpOn(){
        dumping = true;
    }
    
    public void dumpOff(){
        dumping = false;
    }
    
    public int lastArg(){
        return runStack.lastArg();
    }
    
}
