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
public class BopCode extends ByteCode {

    private String arg;
    @Override
    public void init(ArrayList<String> args) {
        arg = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        
        int operand2 = vm.pop();
        int operand1 = vm.pop();
        int result = 0;
        
        switch(arg){
            
            case "+":
                result = operand1 + operand2;
                break;
            
            case "-":
                result = operand1 - operand2;
                break;
            
            case "/":
                result = operand1 / operand2;
                break; 
            
            case "*":
                result = operand1 * operand2;
                break;    
            
            case "==":
                if(operand1 == operand2){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;   
                
            case "!=":
                if(operand1 != operand2){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;     
            
            case "<=":
                if(operand1 <= operand2){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;   
            
            case "<":
                if(operand1 < operand2){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;    
                
                
            case ">=":
                if(operand1 >= operand2){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;
                
            case ">":
                if(operand1 > operand2){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;  
            
            case "|":
                if(operand1 != 0 || operand2 != 0){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;    
                
            case "&":
                if((operand1 != 0) && (operand2 != 0)){
                    result = 1;
                }
                else{
                    result = 0;
                }
                break;    
        
        }
        
        vm.push(result);
        
        
    }

    
    @Override
    public String toString(){
        return "BOP " + arg;
    }
    
    
}
