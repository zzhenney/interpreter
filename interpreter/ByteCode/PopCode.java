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
 * look for typo and make sure to validate bytecodes in stack
 * 
 */
public class PopCode extends ByteCode {
    
    private int args;
    
    
    @Override
    public void init(ArrayList<String> args) {
         this.args = Integer.parseInt(args.get(0));
    }

    
    public void execute(VirtualMachine vm) {
       
        if(args>vm.stackSize()){
            
            for(int i = 0; i < vm.stackSize(); i++)
            {
            
                vm.pop(); 
            
            }
        }
        else{
            vm.pop();
        }
        
        
        //vm.setPC(vm.getPC()-args);
   
    }
    
    @Override
    public String toString(){
        return "POP " + args;
    }
    
}
