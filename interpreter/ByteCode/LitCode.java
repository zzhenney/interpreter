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
public class LitCode extends ByteCode {

    private Integer literal;
    private String id;
    
    @Override
    public void init(ArrayList<String> args) {
        id="";
        literal = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(literal); 
        
    }
    
    public int getLiteral(){
        return literal;
    }
    
    public String getID(){
        return id;
    }
    
    @Override
    public String toString(){
        return "LIT " + literal + " " + id +"  " + "int " + id;
    }
    
    
}
