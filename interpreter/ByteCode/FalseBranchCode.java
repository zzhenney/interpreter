/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author zachenney
 */
public class FalseBranchCode extends ByteCode implements AddressResolver {
    
    protected String label;
    protected int address;
    
    
    
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int stackTop;
        stackTop = vm.pop();
        if(stackTop == 0){
            vm.setPC(address);
        }
        
        
        
    }
    

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public int getTargetAddr() {
        return address;
    }

    @Override
    public void setTargetAddr(int address) {
        this.address = address;
    }
    
    @Override
    public String toString(){
        return "FALSEBRANCH " + label;
    }
  
    
}
