/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import interpreter.VirtualMachine;
import java.util.*;

/**
 *
 * @author zachenney
 */
public abstract class ByteCode {
    
    
    
    public abstract void init(ArrayList<String> args);   
    public abstract void execute(VirtualMachine vm);
    
    
}
