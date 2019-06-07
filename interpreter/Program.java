package interpreter;


import java.util.*;
import interpreter.ByteCode.*;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> labelAddress;

    public Program() {
        program = new ArrayList<>();
        labelAddress = new HashMap<String, Integer>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        //loop through array list program
        for(ByteCode bytecode : this.program){
            //if element is instance of AddrResolve
            if(bytecode instanceof AddressResolver){
                //get label
                //((AddressResolver) bytecode).getLabel();
                ((AddressResolver) bytecode).setTargetAddr(labelAddress.get(((AddressResolver) bytecode).getLabel()));
            
                
            }
     
        }
    }
    
    public void add(ByteCode bytecode){
        program.add(bytecode);
        
        if(bytecode instanceof LabelCode){
            //TODO: split up string and index below into seperate variables //makes it easier to make changes later
            labelAddress.put(((LabelCode) bytecode).getLabel(), program.size()-1); //cast ByteCode to LabelCode to access LabelCode methods
        }
   
    }


}


/*resolveAddrs(){
    loop keep track of bytecode LabelCodes and labels and location
    loop and keep track of jump/branching codes and labels and location


LabelCode possible structure

LABEL, f<<1>>, 14
    

data fields
label
jumpToAddress

simple approach
loop through arrayList multiple times - looking at B(n) = theta(n^2)

better approach
use hashmap for labels
B(n) = theta(n)


*/
    