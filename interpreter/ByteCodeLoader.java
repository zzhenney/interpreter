
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import interpreter.ByteCode.*;
//import java.io.*;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes(){
       
       program = new Program();
       String value;
       ArrayList<String> args = new ArrayList<>();
       
       try{
        String srcLine = byteSource.readLine();
       
        while (srcLine != null){
            StringTokenizer tok = new StringTokenizer(srcLine);
            value = CodeTable.getClassName(tok.nextToken());
            ByteCode bytecode = (ByteCode)(Class.forName("interpreter.ByteCode." + value).newInstance());

            while(tok.hasMoreTokens()){
                args.add(tok.nextToken());
            }

            bytecode.init(args);
      
            program.add(bytecode);
            args.clear();
            srcLine = byteSource.readLine();

        }
       
       }catch(Exception e){
           System.out.println("error bcl");
       }
       
       
       program.resolveAddrs(program);
       return program;
    }
}
