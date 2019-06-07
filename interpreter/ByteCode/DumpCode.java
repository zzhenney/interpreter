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
 * changing boolean in vm
 * if dump on tell vm to turn on
 * if dump off tell vm to turn off
 * 
 */
public class DumpCode extends ByteCode {

    String label;
    
    @Override
    public void init(ArrayList<String> args) {
        label = (String)args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(label.equals("ON")){
            vm.dumpOn();
        }
        else{
            vm.dumpOff();
        }
    }
    
    @Override
    public String toString(){
        return "DUMP " + label;
    }
    
    public String getLabel(){
        return label;
    }
    
    
}
