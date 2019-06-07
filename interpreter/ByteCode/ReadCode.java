/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author zachenney
 */
public class ReadCode extends ByteCode {
    
    Scanner keyboard = new Scanner(System.in);
    
    @Override
    public void init(ArrayList<String> args) {
        
    }

    @Override
    public void execute(VirtualMachine vm) {
        
        
        int input;
        while(true){
            try{
                System.out.print("input integer: ");
                input = keyboard.nextInt();
                break;
            } catch(InputMismatchException e){             
                keyboard.next(); //consume previous token to prevent infinite loop
            }
        }
        
        vm.push(input);
    }
    
    @Override
    public String toString(){
        return "READ ";
    }
   
}
