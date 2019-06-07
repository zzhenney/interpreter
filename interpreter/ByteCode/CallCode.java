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
 * 
 * First push return address to return address stack
 * make sure not to jump over bytecodes when returning. watch for ++ and +1 issues
 */
public class CallCode extends ByteCode implements AddressResolver {
    
    protected String label;
    protected int address;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddr(vm.getPC());
        vm.setPC(address);
        
        
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
        return "CALL " + label + "   ";
    }
    
    
}
