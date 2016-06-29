package com.yudu.cyk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CykParser {

		public String phrase;
		public List<String> motsDansPhrase = null;
		public ArrayList[][] matrix = null;
		public int length;
		public List<List<String>> grammaires = null;
		public List<String> grammaire = null;
		
		public CykParser(){
			this.motsDansPhrase = new ArrayList<String>();
			this.grammaires = new ArrayList<List<String>>();
			this.grammaire = new ArrayList<String>();
		}
		
		public void init() throws IOException{
			try {
				BufferedReader br = new BufferedReader(new FileReader("F:/javaEE/workspace/cyk/WebContent/grammar.txt"));
				while(br.ready()){
					String regle = br.readLine().trim();
					String[] regles = regle.split(" ");
					List list = new ArrayList();
					for(String s : regles){
						list.add(s);
						}
					grammaires.add(list);
					}
				//System.out.println(grammaires);								
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		@SuppressWarnings("unchecked")
		public void cyk(String phrase){
			this.phrase = phrase;
			int i,j,k;
			String[] mots = phrase.split(" ");
			for(String mot : mots){	
				this.motsDansPhrase.add(mot);
			}
			this.length = motsDansPhrase.size();
			this.matrix = new ArrayList[length][length];
			//System.out.println(motsDansPhrase);
			for(i=0;i<length;i++){
				for(j=0;j<length;j++){
					matrix[i][j] = new ArrayList<>();
				}
			}
				for(j=0;j<length;j++){	
					for(List regle : grammaires){
						if(regle.size() == 2){
							//System.out.println("R¨¨gle est de la forme A->aj : " + regle);
							if(regle.get(1).equals(motsDansPhrase.get(j))){
								this.matrix[0][j].add(regle.get(0));
						}
							
							//this.matrix[0][j].add(regle.get(0));
							
						}
					}
					//System.out.print(matrix[0][j]);
				}
				
				for(i=1;i<length;i++){
					for(j=0;j<length-i;j++){
						for(k=0;k<i;k++){
							for(List regle : grammaires){
								//System.out.println("R¨¨gle est de la forme A->B C : " + regle)
								if((regle.size() == 3) && (matrix[k][j].contains(regle.get(1)) && matrix[i-k-1][j+k+1].contains(regle.get(2)))){
									this.matrix[i][j].add(regle.get(0));
								}
							}
						}
					}
				}
				System.out.println("----------------------------------------------------------");
				System.out.println("Affichage du matrix obtenue avec la phrase et le grammaire");
				System.out.println();
				System.out.println(motsDansPhrase);
				for(i=0;i<length;i++){
					for(j=0;j<length;j++){
						System.out.print(this.matrix[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println("------------------------------------------------------------");
				
			}	
		
		
		public static void main(String[] args){
			CykParser cyk = new CykParser();
			
			try {
				cyk.init();
				cyk.cyk("Il fait un programme");
				//cyk.cyk("Le fait qu' il le programme constitue un exploit");
				//cyk.cyk("Le fait qu' il programme est tres complexe");
				//cyk.cyk("Ce programme ne le fait pas ou ne sait pas le faire");
				//cyk.cyk("Le faire est mieux que le dire");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
}
