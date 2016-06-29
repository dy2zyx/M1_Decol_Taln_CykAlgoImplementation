package com.yudu.cyk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CykServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String phrase = request.getParameter("query");
		CykParser cyk = new CykParser();
		cyk.phrase = phrase;
		out.print("<p> Votre phrase saisie est :" + "<p style=\"color:blue;font-family:verdana\">" +phrase + "</p>" + "</p></br>");
		cyk.init();
		cyk.cyk(phrase);
		ArrayList[][] matrix = new ArrayList[cyk.length][cyk.length];
		matrix = cyk.matrix;
		
		out.print("----------------------------------------------------------</br>");
		out.print("<b>Affichage du matrix obtenue avec la phrase et le grammaire : </b></br>");
		out.print("</br>");
		List motsDansPhrase = cyk.motsDansPhrase;
		out.print("<table border=\"1\">");
		out.print("<tr>");
		for(int i=0;i<motsDansPhrase.size();i++){
			out.print("<td style=\"color:red;font-family:verdana\">" + motsDansPhrase.get(i) + "</td>");
		}
		out.println("</tr>");
		for(int i=0;i<cyk.length;i++){
			out.print("<tr>");
			for(int j=0;j<cyk.length;j++){
				out.print("<td style=\"font-family:verdana\">" + matrix[i][j] + "</td>");
				//out.print(matrix[i][j] + " ");
			}
			out.print("</tr>");
			out.print("</br>");
		}
		
		

	}

	

}
