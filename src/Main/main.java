package Main;

import java.io.*; 

import Scanner.*;
import Tables.Classes;
import Tables.Methods;
import Parser.*;
import AST.*;
import AST.Visitor.*;
import Throwables.*;
import java_cup.runtime.Symbol;

import java.io.FileReader;
import java.util.*;
import java.io.*; 
import java.io.FileReader;

import Scanner.*;
import Parser.*;
import Throwables.*;
import java_cup.runtime.Symbol;
import java.util.Scanner;

import AST.*;
import AST.Visitor.*;

public class main {
    public static void main(String [] args) {
    	Boolean flag = true;
    	String file = null;
    	FileReader iF = null;
    	File oF = null; 
    	scanner s = null;
    	FileOutputStream fos = null;
    	Symbol sy = null;
    	System.out.print("\n Projeto Final da Disciplina de Compiladores\n"
    			+ "aluno: Lucas de Souza Lima\n\n");
    	System.out.print("ATENÇAO!\n"
    			+ "\nSe o arquivo não estiver no mesmo diretório do compilador, digite o caminho completo do arquivo\n"
    			+ "\nDigite o nome do arquivo '.java' aqui:\n");
    	try {
            Scanner in = new Scanner(System.in);
            file = in.next();
            iF = new FileReader(file);
            s = new scanner(iF);
            System.out.print ("\n\nLista de símbolos: \n\n");
            oF = new File(String.valueOf(file) + "_ListofSymbols.out");
            fos = new FileOutputStream(oF);
            sy = s.next_token();
            flag = sy.sym != 0;
        }
        catch (CompilerException e) {
            System.err.println(e.getMessage());
            return;
        }
        catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
            e.printStackTrace();
            return;
        }
        Boolean error = false;
        while (flag.booleanValue()) {
            String tex;
            try {
                if (error.booleanValue()) {
                    sy = s.next_token();
                    error = false;
                }
                String tex2 = String.valueOf(s.symbolToString(sy)) + " ";
                System.out.print(tex2);
                fos.write(tex2.getBytes());
                sy = s.next_token();
                flag = sy.sym != 0;
                continue;
            }
            catch (CompilerException e) {
                error = true;
                tex = "<ERROR: " + e.getMessage() + " >";
                System.err.println(tex);
                try {
                    fos.write(tex.getBytes());
                }
                catch (Exception var11_16) {}
                continue;
            }
            catch (Exception e) {
                error = true;
                tex = "<ERROR: " + e.toString() + " >";
                System.err.println(tex);
                try {
                    fos.write(tex.getBytes());
                }
                catch (Exception var11_17) {
                    // empty catch block
                }
                e.printStackTrace();
            }
        }
        
        System.out.print("\n\nAnalise léxical realizada com sucesso!!\n");
    	
        try {    		
        	Map m = new HashMap();
    		Map m2 = new LinkedHashMap(m);
    		iF = new FileReader(file);
            s = new scanner(iF);
        	
        	System.out.print("\nErros léxicos e sintáticos:\n");
        	
        	parser p = new parser(s);
            Symbol symbol;
            symbol = p.parse();
            
            System.out.print("\nErros de semâtica:\n");
           
            
            Program program = (Program)symbol.value;
            program.accept(new PrettyPrintVisitor(), m2, 0, 0);
            
            Set ss = m2.entrySet();
            Iterator it = ss.iterator();
            while(it.hasNext())
            {
            	Map.Entry entrada = (Map.Entry)it.next();
            	Classes a = (Classes)entrada.getValue();
            	a.verificar(m2);
            	a.verifTypeExist(m2);
            }
            
            iF = new FileReader(file);
            scanner s2 = new scanner(iF);
            parser p2 = new parser(s2);
            Symbol root2;
            root2 = p2.parse();            
            
            program = (Program)root2.value;
            program.accept2(new PrettySecVisitor(), m2, 0, null, null);
            
            System.out.print("\nTabela de símbolos gerada com sucesso!\n"
            		+ "\nTabelas geradas:\n");
            
            ss = m2.entrySet();
            it = ss.iterator();
            while(it.hasNext())
            {
            	Map.Entry entrada = (Map.Entry)it.next();
            	Classes a = (Classes)entrada.getValue();
            	a.print();
            }
            
                      
            System.out.print("\nAnálise concluida!\n"); 
            System.out.print("\nCódigo assembly gerado!\n\n"); 
            
            CodeVisitor cV = new CodeVisitor();
            FileWriter writer = new FileWriter(new File(file+"_Assembly.s"),true);  
            PrintWriter dotS = new PrintWriter(writer);
            
            
            program.accept2(cV, m2, 0, null, null);
            String cd = cV.getCode();
            dotS.print(cd);
            
            writer.close();
            dotS.close();
            
        } catch (CompilerException e) {
            // an error in the user's arguments or input, or some
            // other kind of error that we've already handled in the
            // appropriate way (not a bug that the error got here)
            System.err.println(e.getMessage());
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Unexpected internal compiler error: " + 
                               e.toString());
            // print out a stack dump
            e.printStackTrace();
        }
       
       
   }
}



