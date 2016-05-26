package com.citec.generator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.gui.TreeViewer;



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
		List<CodeEntity> solutionsSave = new ArrayList<CodeEntity>();
		
		int i=0;
		String treeString="";
		for (CodeEntity code : solutions) {
		//	System.out.println(code.getCode());
			if(i==0){
			ANTLRInputStream input = new ANTLRInputStream(code.getCode());
			HTMLLexer lexer = new HTMLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			
			HTMLParser parser = new HTMLParser(tokens);
		
			ParseTree tree = parser.htmlDocument(); // parse; start at prog
			
			List<String> ruleNames = Arrays.asList(parser.ruleNames);
			
			
			TreeViewer view = new TreeViewer(ruleNames, tree);
			view.open();
			treeString= tree.toStringTree(parser);
			
			String json=parser(treeString, ruleNames);
			System.out.println(json);
			System.out.println(treeString);
			
			}
			i++;
	}
		
		
		
// SE ENCARGA DE GUARDAR LOS DATOS GENERICOS.		
/*		for (CodeEntity code : solutions) {
			for(int i=0; i<1000; i++){
				ANTLRInputStream input = new ANTLRInputStream(code.getCode());
				HTMLLexer lexer = new HTMLLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				
				HTMLParser parser = new HTMLParser(tokens);
			
				ParseTree tree = parser.htmlDocument(); // parse; start at prog
				EvalVisitor eval = new EvalVisitor();
				eval.visit(tree);
				//System.out.println(eval.getSolucion());
				CodeEntity cde = new CodeEntity();
				cde.setCode(eval.getSolucion());
				cde.setPageId(code.getPageId());
				solutionsSave.add(cde);
				//System.out.println("TERMINO CODIGO");
			}
		}
		
		boolean results = ConnectionManager.saveSinteticSolutions(solutionsSave);
*/		
	//}
	
	public static String parser(String s, List<String> r){
		String json="{";
		String temp ="";
		String sdata="";
		Boolean iData=false;
		Boolean it=false;
		for(int i=0; i<s.length(); i++){
			if(Character.isLetter(s.charAt(i))){ 
				temp+=s.charAt(i);	
			}
			
			if(s.charAt(i)=='<'){
				json+="\"open\": \"<\",";
			}
			if(s.charAt(i)=='>'){
				json+="\"closed\": \">\",";
			}
			
			if(s.charAt(i)==' ' ||s.charAt(i)=='(' || s.charAt(i)==')' && iData==false){
				it=isToken(temp, r);
				if(it==true){
					if(temp.equals("htmlChardata") || temp.equals("htmlTagName")){
						json+="\""+ temp+ "\":";
						temp="";
						iData=true;
					}
					else{
						json+="\""+temp+"\" : {";
						temp="";
					}
					
				}else{
					/*if(s.charAt(i)==')'){
						json+=temp+","
					}
					if(!temp.equals("")){
						json+="\""+temp+"\",";
						temp="";
					}*/
				}
				
			}
			
			
			if(iData==true){
				if(s.charAt(i)==')'){
					json+="\""+sdata+"\",";
					iData=false;
					sdata="";
					temp="";
				}else{
					sdata+=s.charAt(i);	
				}
				
				
			}
			
		}
		
		return json; 
	}
	
	
	public static String analizadorLexico(String s,List<String> r){
		String json="";
		String temp="";
		Boolean istok=false;
		Boolean isdata=false;
		Boolean isRoot=false;
		Boolean flag = false;
		int sizeFlag=0;
		
		Stack<String> st = new Stack<String>();
		
		for(int i =0; i<s.length(); i++){
			if(s.charAt(i)=='('){
				//st.push("(");
				
				if(isRoot==true){
					if(flag==false){
						json+="{";
						temp="";
						flag=true;
						st.push("(");
						sizeFlag=st.size();
						
					}
				}else{
					json+="{";
					temp="";
					st.push("(");
				}
			}
			if(s.charAt(i)==')'){
				st.pop();
				
				json += " \""+temp+"\"";
				json+="}";
				temp="";
				isdata=false;
			}
			if(Character.isLetter(s.charAt(i))){ 
				temp+=s.charAt(i);	
			}
			if(s.charAt(i)==' '){
				
				if(isdata==true){
					json+=temp;
					temp="";
				}
				
				if(temp.equals("htmlChardata")){
					isdata=true;
				}
				if(temp.equals("htmlElements")){					
					isRoot=true;
				
				}
				
				if(!temp.equals("")){
					json+="\""+temp+"\":";
					temp="";	
				}
				
				
			}
			if(s.charAt(i)=='<'){
				json+="\"open\":\"<\",";
			}
			if( s.charAt(i)=='>'){
				json+="\"close\":\">\",";
			}
			
		}
		return json;
	}
	
	public static Boolean isToken(String palabra,List<String> r){
		for (String s : r) {
			if(palabra.equals(s)){
				return true;
			}
		}
		return false;
	}


}
