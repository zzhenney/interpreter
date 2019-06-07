package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import sun.misc.Version;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer; //0 is at bottom //is either popped or pushed //not modified
   //private /*static*/ HashMap<Integer, String> frameTable;
    
    
    public RunTimeStack()   //only integers should be used for init
    {
        runTimeStack = new ArrayList<>();  //ArrayList<Integer> runTimeStack;
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
        
    
        //frameTable =  new HashMap<>();
    }
    
    //stack methods
    
/*    
    public void dump(){
        //System.out.println("size framestack " + framePointer.size());
        //System.out.println("size runstack " + runTimeStack.size());
        
        //Iterator iter = framePointer.iterator();
        
        //System.out.println("frameCount: ");
        int frameCount = framePointer.size();
        int frameSize;
        //System.out.println("frameCount: " + frameCount);
        //System.out.println("size framestack " + framePointer.size());
        //int frameElm = (Integer)iter.next();
        //int frameArgs = (Integer)iter.indexOf(frameElm);
        
        ArrayList<Integer> frameArray = new ArrayList<Integer>();
        
        for(int n = frameCount; n > 0; n--){
            frameArray.add(framePointer.pop());
        }
        
        //replace stack
        for(int n = 0; n < frameCount; n++){
            framePointer.push(frameArray.get(n));
        }
        
        
        
        for(int i = 1; i <= frameCount; i++){
          
            int m = 1;
            frameSize = runTimeStack.size()-(frameArray.get(frameArray.size()-m));
                System.out.print("[");          //base case begin

            
                if(!(runTimeStack.isEmpty()) && i > 1){
                    
                   
                    for(int j = 0; j < frameSize; j++){
                        
                                        //issue is when frameSize is 0
                            System.out.print(runTimeStack.get(size()-frameSize) + ",");
                            frameSize--;
                        
                        
              
                    }           
                    
                }
            m++;
            
            System.out.print("]");     
        
                
            
            
        
    }
      System.out.println();  
    }     
        
 */   
    
    
    public void dump() {
        Iterator iter = framePointer.iterator();
        int nextFrame, currFrame = (Integer) iter.next();
        //print runtime stack frame by frame
        for (int i = 0; i < framePointer.size(); i++) {
            if (iter.hasNext()) {
                nextFrame = (Integer) iter.next();
            } else {
                nextFrame = runTimeStack.size();
            }

            System.out.print("[");
            //print contents of curr frame
            for (int j = currFrame; j < nextFrame; j++) {
                System.out.print(runTimeStack.get(j));
                if (j != nextFrame - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            currFrame = nextFrame;
        }
        System.out.println();
    }
    
    
    
    
    

    public int peek(){
        return runTimeStack.get(lastIndex());
    }
    
    public int pop(){
        int topItem = runTimeStack.get(lastIndex());
        runTimeStack.remove(lastIndex());
        return topItem;
    }
    
    public int push(int i){
        runTimeStack.add(i);
        return i;
    }
    
    public void newFrameAt(int offset){
        framePointer.push(runTimeStack.size() - offset); //need to record previous location - found by rTS-offset 
    }
    
    public void popFrame(){
     /* int returnValue = runTimeStack.get(lastIndex());
        int offset = framePointer.pop();
        while((lastIndex()) != offset){
            runTimeStack.remove(lastIndex());
        }
      */
        int returnValue = runTimeStack.get(lastIndex());
        int topIndex = lastIndex();
        int bottomIndex = framePointer.pop();
        for(; topIndex >= bottomIndex; topIndex--){
            runTimeStack.remove(topIndex);
        }

        runTimeStack.add(returnValue);   
    }
    
    public int store(int offset){
        int topItem = runTimeStack.get(lastIndex());
        runTimeStack.remove(lastIndex());
        runTimeStack.set(framePointer.peek() + offset, topItem);
        return runTimeStack.get(lastIndex());
    }
    
    public int load(int offset){
        int loadItem = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(loadItem);
        return loadItem;
        
        
        
    }
    
    //Use with LIT
    public Integer push(Integer i){
        runTimeStack.add(i);
        return i;
    }
    
    //helper methods
    // was using runTimeStack.size()-1 to get last index
    public int lastIndex(){
        return (runTimeStack.size()-1);
    }
    
    public int lastArg(){
        if(!runTimeStack.isEmpty()){
            return runTimeStack.get(runTimeStack.size()-1);
        }
        
        else
            return 0;
    }
    
    public int size(){
        return runTimeStack.size();
    }

}
