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
 * store at index of current frame <- current frame is IMPORTANT
 * pop and store at index of beginning of frame pointer
 */
public class StoreCode extends ByteCode {
    
    private int offset;
    private String id;
    
    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }
    
    @Override
    public String toString(){
        return "STORE " + offset + " " + id + "   " + id + " ";
    }
    
    
}
