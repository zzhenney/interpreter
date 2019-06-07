/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

/**
 *
 * @author zachenney
 */
public interface AddressResolver {
    
    public abstract String getLabel();   
    
    public abstract int getTargetAddr();
    
    public abstract void setTargetAddr(int address);
    
}
