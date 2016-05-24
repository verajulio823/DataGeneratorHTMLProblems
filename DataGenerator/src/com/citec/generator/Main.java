package com.citec.generator;

import java.sql.SQLException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;



public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ConnectionManager.GetConnection();
		Error.loadError();
		
		
		List<CodeEntity> solutions = ConnectionManager.getSolutions();
		for (CodeEntity code : solutions) {
		//	System.out.println(code.getCode());
			for(int i=0; i<1000; i++){
				ANTLRInputStream input = new ANTLRInputStream(code.getCode());
				HTMLLexer lexer = new HTMLLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				
				HTMLParser parser = new HTMLParser(tokens);
			
				ParseTree tree = parser.htmlDocument(); // parse; start at prog
				EvalVisitor eval = new EvalVisitor();
				eval.visit(tree);
				System.out.println(eval.getSolucion());
				
				System.out.println("TERMINO CODIGO");
			}
		}
		
		
		
		//List<CodeEntity> results = ConnectionManager.getSolutionEstudents();
		
		
		//for(int i=0; i<10; i++)			
		//System.out.println((int)Math.ceil(Math.random()*10));

	}

}
