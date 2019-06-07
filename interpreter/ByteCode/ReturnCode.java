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
public class ReturnCode extends ByteCode {
    
    private String currFunc ="";
    private int topStack;
    
    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty()){
            currFunc = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        vm.setPC(vm.getReturnAddr());
        topStack = vm.peek();
    }
    
    @Override
    public String toString(){
        return "RETURN " + currFunc + "   " + "exit " + currFunc + ": ";
    }
    
}
