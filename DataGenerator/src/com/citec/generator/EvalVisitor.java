package com.citec.generator;

import com.citec.generator.HTMLParser.DtdExprContext;
import com.citec.generator.HTMLParser.HtmlAttContext;
import com.citec.generator.HTMLParser.HtmlAttEqualsContext;
import com.citec.generator.HTMLParser.HtmlAttNameContext;
import com.citec.generator.HTMLParser.HtmlAttValueContext;
import com.citec.generator.HTMLParser.HtmlCharDataHtmlTextContext;
import com.citec.generator.HTMLParser.HtmlCharDataSeaWsContext;
import com.citec.generator.HTMLParser.HtmlCommentCommentConditionalContext;
import com.citec.generator.HTMLParser.HtmlCommentCommentContext;
import com.citec.generator.HTMLParser.HtmlContentExprContext;
import com.citec.generator.HTMLParser.HtmlDocumentExprContext;
import com.citec.generator.HTMLParser.HtmlElementsExprContext;
import com.citec.generator.HTMLParser.HtmlMiscCommentContext;
import com.citec.generator.HTMLParser.HtmlMiscSeaWsContext;
import com.citec.generator.HTMLParser.HtmlTagNameExprContext;
import com.citec.generator.HTMLParser.HtmlTagOpenAttCloseContext;
import com.citec.generator.HTMLParser.HtmlTagOpenAttContSlashCloseContext;
import com.citec.generator.HTMLParser.HtmlTagOpenAttSlashContext;
import com.citec.generator.HTMLParser.HtmlTagScriptContext;
import com.citec.generator.HTMLParser.HtmlTagScriptLetContext;
import com.citec.generator.HTMLParser.HtmlTagStyleContext;
import com.citec.generator.HTMLParser.ScriptOpenContext;
import com.citec.generator.HTMLParser.ScriptletExprContext;
import com.citec.generator.HTMLParser.StyleOpenContext;
import com.citec.generator.HTMLParser.XhtmlCDataContext;
import com.citec.generator.HTMLParser.XmlDeclarationContext;

public class EvalVisitor extends HTMLParserBaseVisitor<String> {

	String solucion="";
	Boolean flag = false;
	
	public String getSolucion(){
		return solucion;
	}
	
	@Override
	public String visitHtmlTagScriptLet(HtmlTagScriptLetContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagScriptLet(ctx);
	}

	@Override
	public String visitHtmlTagOpenAttContSlashClose(
			HtmlTagOpenAttContSlashCloseContext ctx) {
		
		// TODO Auto-generated method stub
		//System.out.println("XTX "+ctx.getText());
		if(flag==false){
			solucion= ctx.getText();
			flag = true;
		}
		
		if(!(ctx.htmlAttribute().size()==0)){
			String ss1=ctx.htmlAttribute().get(0).getText().toLowerCase();
			if(ss1.equals(Error.attribute)){
				int p=	(int)Math.ceil(Math.random()*5);
				String h=Error.eStyle.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(ss1,h);
			}
		}
		
		//System.out.println(ctx.TAG_OPEN().get(0).getText() + ctx.htmlTagName().get(0).getText() +  ctx.htmlAttribute().get(0).getText()+ ctx.TAG_CLOSE().get(0).getText());
		
		//System.out.println(""+ctx.getText());
	//	if(ctx.TAG_OPEN(0)!=null)
	//	System.out.println("TAG OPEN: "+ ctx.TAG_OPEN(0).getText());
	//	if(ctx.TAG_CLOSE(0)!=null)
	//	System.out.println("TAG OPEN: "+ ctx.TAG_CLOSE(0).getText());
		//System.out.println("Tag: "+ ctx.htmlTagName().get(0).getText());
		//System.out.println("Contenido: "+ ctx.html);
		//System.out.println("ENTROOo");
		
		return super.visitHtmlTagOpenAttContSlashClose(ctx);
	}

	@Override
	public String visitDtdExpr(DtdExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDtdExpr(ctx);
	}

	@Override
	public String visitHtmlTagStyle(HtmlTagStyleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagStyle(ctx);
	}

	@Override
	public String visitHtmlAttValue(HtmlAttValueContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAttValue(ctx);
	}

	@Override
	public String visitScriptOpen(ScriptOpenContext ctx) {
		// TODO Auto-generated method stub
		return super.visitScriptOpen(ctx);
	}

	@Override
	public String visitHtmlAttName(HtmlAttNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAttName(ctx);
	}

	@Override
	public String visitHtmlTagNameExpr(HtmlTagNameExprContext ctx) {
		
		int prob =(int)Math.ceil(Math.random()*10);
		if(prob >8){
			String s=ctx.getText();
			if(s.equals("h1") || s.equals("h2") || s.equals("h3") || s.equals("h4") || s.equals("h5")|| s.equals("h6")){
				int p=	(int)Math.ceil(Math.random()*5);
				String h=Error.eTagH.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(s,h);	
			
			}
			if(s.equals("body")){
				int p=	(int)Math.ceil(Math.random()*5);
				String body=Error.eTagBody.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(s,body);
				
			}
			if(s.equals("head")){
				int p=	(int)Math.ceil(Math.random()*5);
				String head=Error.eTagHead.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(s,head);				
			}
			if(s.equals("style")){
				int p=	(int)Math.ceil(Math.random()*5);
				String style=Error.eTagStyle.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(s,style);				
			}
			if(s.equals("li")){
				int p=	(int)Math.ceil(Math.random()*5);
				String li=Error.eTagLi.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(s,li);				
			}
			if(s.equals("ol")){
				int p=	(int)Math.ceil(Math.random()*5);
				String ol=Error.eTagLo.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(s,ol);				
			}
			if(s.equals("p")){
				int p=	(int)Math.ceil(Math.random()*5);
				String pp=Error.eTagP.get(Integer.parseInt(p+""));
				solucion = solucion.replaceFirst(s,pp);				
			}
			
			
				
		}
		
		
		// TODO Auto-generated method stub
		//System.out.println("CTX TAG NAME: "+ctx.TAG_NAME().getText());
		//System.out.println("TAG NAME: "+  ctx.getText());
		return super.visitHtmlTagNameExpr(ctx);
	}

	@Override
	public String visitHtmlCharDataHtmlText(HtmlCharDataHtmlTextContext ctx) {
		// TODO Auto-generated method stub
		int prob =(int)Math.ceil(Math.random()*10);
		if(prob >6){
			String s= ctx.getText();
			if(s.equals(Error.contH)){
				int p=	(int)Math.ceil(Math.random()*5);
				String pc=Error.eConH.get(Integer.parseInt(p+""));			
				solucion = solucion.replaceFirst(s,pc );	
			}
			if(s.equals(Error.contTitle)){
				int p=	(int)Math.ceil(Math.random()*5);
				String pc=Error.eConTitle.get(Integer.parseInt(p+""));			
				solucion = solucion.replaceFirst(s,pc );	
			}
			if(s.equals(Error.contP)){
				int p=	(int)Math.ceil(Math.random()*5);
				String pc=Error.eConP.get(Integer.parseInt(p+""));			
				solucion = solucion.replaceFirst(s,pc );	
			}
			
			
				
		}
		
	//	System.out.println("CHAR DATA: "+ ctx.getText());
		
		return super.visitHtmlCharDataHtmlText(ctx);
	}

	@Override
	public String visitHtmlElementsExpr(HtmlElementsExprContext ctx) {
		// TODO Auto-generated method stub
	//	System.out.println("ELÑEMENT: "+ctx.getText());
	//	System.out.println("ELÑEMENT: "+ctx.htmlElement().getText());
		
		return super.visitHtmlElementsExpr(ctx);
	}

	@Override
	public String visitHtmlDocumentExpr(HtmlDocumentExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlDocumentExpr(ctx);
	}

	@Override
	public String visitHtmlCharDataSeaWs(HtmlCharDataSeaWsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlCharDataSeaWs(ctx);
	}

	@Override
	public String visitScriptletExpr(ScriptletExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitScriptletExpr(ctx);
	}

	@Override
	public String visitHtmlAttEquals(HtmlAttEqualsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAttEquals(ctx);
	}

	@Override
	public String visitHtmlMiscSeaWs(HtmlMiscSeaWsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlMiscSeaWs(ctx);
	}

	@Override
	public String visitHtmlTagScript(HtmlTagScriptContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagScript(ctx);
	}

	@Override
	public String visitHtmlCommentComment(HtmlCommentCommentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlCommentComment(ctx);
	}

	@Override
	public String visitHtmlTagOpenAttClose(HtmlTagOpenAttCloseContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagOpenAttClose(ctx);
	}

	@Override
	public String visitXmlDeclaration(XmlDeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitXmlDeclaration(ctx);
	}

	@Override
	public String visitXhtmlCData(XhtmlCDataContext ctx) {
		// TODO Auto-generated method stub
		return super.visitXhtmlCData(ctx);
	}

	@Override
	public String visitHtmlCommentCommentConditional(
			HtmlCommentCommentConditionalContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlCommentCommentConditional(ctx);
	}

	@Override
	public String visitHtmlAtt(HtmlAttContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlAtt(ctx);
	}

	@Override
	public String visitHtmlContentExpr(HtmlContentExprContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println("Contenido: "+ ctx.getText());
		return super.visitHtmlContentExpr(ctx);
	}

	@Override
	public String visitHtmlTagOpenAttSlash(HtmlTagOpenAttSlashContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlTagOpenAttSlash(ctx);
	}

	@Override
	public String visitStyleOpen(StyleOpenContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStyleOpen(ctx);
	}

	@Override
	public String visitHtmlMiscComment(HtmlMiscCommentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHtmlMiscComment(ctx);
	}

}
