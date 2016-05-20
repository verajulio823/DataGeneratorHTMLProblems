package com.citec.generator;

import java.util.HashMap;
import java.util.Map;

public class Error {
	
	public static Map<Integer,String> eTagH;
	public static Map<Integer,String> eTagBody;
	public static Map<Integer,String> eTagP;
	public static Map<Integer,String> eTagLi;
	public static Map<Integer,String> eTagLo;
	public static Map<Integer,String> eTagStyle;
	public static Map<Integer,String> eTagHead;
	
	public static Map<Integer,String> eConP;
	public static Map<Integer,String> eConTitle;
	public static Map<Integer,String> eConH;
	
	public static Map<Integer,String> eStyle;
	
	public static String contTitle ="Laboratoria Curso Básico";
	public static String contH ="Laboratoria";
	public static String contP ="En Laboratoria aprendemos varios lenguajes para crear páginas web. A continuación presentamos una lista de los lenguajes que aprendemos.";
	
	public static String attribute= "\"color:blue;font-size:22px\"";
	
	public static void loadError(){
		eTagH = new HashMap<Integer, String>();
		eTagH.put(1, "h1");
		eTagH.put(2, "h2");
		eTagH.put(3, "h3");
		eTagH.put(4, "h4");
		eTagH.put(5, "h5");
		eTagH.put(5, "h6");
		
		eTagBody = new  HashMap<Integer, String>();
		eTagBody.put(1,"body");
		eTagBody.put(2,"bodi");
		eTagBody.put(3,"ebody");
		eTagBody.put(4,"bodi");
		eTagBody.put(5,"boddy");
		
		eTagP = new HashMap<Integer, String>();
		eTagP.put(1, "p");
		eTagP.put(2, "pp");
		eTagP.put(3, "e");
		eTagP.put(4, "q");
		eTagP.put(5, "p_");
		
		eTagLi = new HashMap<Integer, String>();
		eTagLi.put(1, "Lii");
		eTagLi.put(2, "Il");
		eTagLi.put(3, "ill");
		eTagLi.put(4, "pl");
		eTagLi.put(5, "il");
		
		eTagLo = new HashMap<Integer, String>();
		eTagLo.put(1, "Loo");
		eTagLo.put(2, "Ol");
		eTagLo.put(3, "oll");
		eTagLo.put(4, "pl");
		eTagLo.put(5, "lo");
		
		eTagHead = new HashMap<Integer, String>();
		eTagHead.put(1, "head");
		eTagHead.put(2, "heead");
		eTagHead.put(3, "deaht");
		eTagHead.put(4, "heart");
		eTagHead.put(5, "hean");
		
		eTagStyle = new HashMap<Integer, String>();
		eTagStyle.put(1, "style");
		eTagStyle.put(2, "pstyle");
		eTagStyle.put(3, "stile");
		eTagStyle.put(4, "stille");
		eTagStyle.put(5, "stely");

		eConH = new HashMap<Integer, String>();
		eConH.put(1, "Laboratoria");
		eConH.put(2, "Labpratoria");
		eConH.put(3, "Laborratoria");
		eConH.put(4, "Laboratorio");
		eConH.put(5, "Laboratoriaa");
		
		eConTitle = new HashMap<Integer, String>();
		eConTitle.put(1, "Laboratoria Curso Básico");
		eConTitle.put(2, "Labpratoria Curso Normal");
		eConTitle.put(3, "Laborratoro Cusco Base");
		eConTitle.put(4, "Laboratorio Basico Curso");
		eConTitle.put(5, "Laboratoria Basico nrormal");
		
		eConP = new HashMap<Integer, String>();
		eConP.put(1, "En Laboratorio aprendemos varios lenguajs para crear páginas webss. A continuación presentamos una listos de los lenguajeeess que aprendemos");
		eConP.put(2, "En Laboratoria aprendemos varios lenguajes para crear páginas web. A continuación presentamos una lista de los lenguajes que aprendemos");
		eConP.put(3, "En Laboratoria valoramos varios lenguas para crear páginas Html. A continuación presentamos una lista de los lenguajes de programación");
		eConP.put(4, "En Laboratorio aprendemosss varios lenguajes para diseñar páginas web. A continuación presentamos una lista de los lenguajes que valoramos");
		eConP.put(5, "En Laboratoria aprendemosqq varios lenguajes para crear págianas eweb. A continauación presebntamos una lisata deee los lenguajes que aprendemos");
		
		eStyle = new  HashMap<Integer, String>();
		eStyle.put(1, "color:blue;font-size:22px;");
		eStyle.put(2, "font-size:22px;color:blue;");
		eStyle.put(3, "color:green;font-size:22px;");
		eStyle.put(4, "color:blue;font-size:23px;");
		eStyle.put(5, "color:blue;font-sizes:22px;");
		
		
	}
	

}
