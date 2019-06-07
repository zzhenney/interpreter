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
 * caller sets up function 
 * when args is called set up new frame - ie args 3 means 3 arguments which will determine size of new frame. from top of stack count down 
 * 3 spaces
 */
public class ArgsCode extends ByteCode {

    private int argCount;
    
    @Override
    public void init(ArrayList<String> args) {
        argCount = Integer.parseInt(args.get(0));
        
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(argCount);
        
    }

    @Override
    public String toString(){
        return "ARGS " + argCount;
    }

}
