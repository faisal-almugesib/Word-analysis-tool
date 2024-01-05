package newDesignProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordAnalysis {
LinkedList<WordInformation>[] arrayOfDifferentLengths;
Scanner reader;
int numAllWords = 0;
int numUniqueWords=0;
WordInformation[] sortedArray = null;
int k = 0;


 public WordAnalysis(File f) throws FileNotFoundException {
	reader = new Scanner(f);
	String tmp;
	
	while(reader.hasNext()) {
		tmp = reader.next();
		if(tmp.length()>k)
			k=tmp.length();
	}
	arrayOfDifferentLengths=(LinkedList<WordInformation>[]) new LinkedList<?>[k+1];
	
	for(int i = 0; i<=k; i++) {
		arrayOfDifferentLengths[i] = new LinkedList<WordInformation>();
	}
}
 
 public void readFileAndAnalyse(File f) throws FileNotFoundException {
	 reader = new Scanner(f);
	 String tmp;
	 LinkedList<WordInformation> tmpList;
	 int line=0;
	 String[] words;
	 while(reader.hasNextLine()){
		    tmp = reader.nextLine();
		    line++;
		     words=tmp.split(" ");
		    
		    	 
		     
		     for(int j =0; j<words.length;j++){
		    	 
		    	
		    	 if(words[j].equalsIgnoreCase("")) 
		    		 continue;
		    		 words[j] = words[j].replace(",", "");
		    		 words[j] = words[j].replace(".", "");
		    		
		    	 
		    	 	
//		           	if(32 <= words[j].charAt(words[j].length()-1) && words[j].charAt(words[j].length()-1) <= 47){
//		           		words[j]= words[j].substring(0, words[j].length()-1);
		           		boolean flag = false;
		           		
		             
		           		
	 
	
		
			 tmpList = arrayOfDifferentLengths[words[j].length()]; // suppose no -1
			 if(tmpList.empty()) {
				 WordInformation wi = new WordInformation(words[j], line, j+1);
				 tmpList.insert(wi); 
				 numUniqueWords++;
				 numAllWords++; 
				 flag=true;
			
				 continue;
			 }
			 tmpList.findFirst();
			 while(!tmpList.last()) {
				 if(tmpList.retrieve().word.equalsIgnoreCase(words[j])) {
					 WordOccurrence w = new WordOccurrence(line, j+1);
					 tmpList.retrieve().addOccurrence(w);
					 numAllWords++;
					 flag=true;
					
					 
				 }
				tmpList.findNext(); 
			 }
			 if(tmpList.retrieve().word.equalsIgnoreCase(words[j])) {
				 WordOccurrence w = new WordOccurrence(line, j+1);
				 tmpList.retrieve().addOccurrence(w);
				 numAllWords++;
				 flag=true;
				 
				 
			 }
			 if(!flag){
				 WordInformation wi = new WordInformation(words[j], line, j+1);
				 tmpList.insert(wi); 
				 numUniqueWords++;
				 numAllWords++;
				
			 }
		 } 
	 
		     }
	
//	 int counter = 0;
//	 int max=0;
//	 for(int i = 1; i<arrayOfDifferentLengths.length; i++) {
//		 tmpList = arrayOfDifferentLengths[i];
//		 tmpList.findFirst();
//		 for(int j = 0; j<tmpList.size; j++) {
//			 if(tmpList.retrieve().occList.size>max)//
//				 max = tmpList.retrieve().occList.size;
//			 tmpList.findNext();
//		 } 
//	 }
//	 
//	 for(int i = max; i>0; i--) {
//		 for(int j = 1; j<arrayOfDifferentLengths.length; j++) {
//			 tmpList = arrayOfDifferentLengths[j];
//			 tmpList.findFirst();
//			 for(int v = 0; v<tmpList.size; v++) {
//				 if(tmpList.retrieve().occList.size==i) {
//					 sortedArray[counter] = tmpList.retrieve();
//					 System.out.println(sortedArray[counter].word);
//					 counter++;
//				 }
//				 
//				 tmpList.findNext();
//			 }
//		 }
//	 }
	 
	 
	 
	 
		 
	 //here we will handle the sorted array
	 //
	 }
	// } this is the block of the if that trims the word
 public int documentLength() {
	 return numAllWords;
 }
 
 public int uniqueWords() {
	 return numUniqueWords;
 }
 
 
 public int totalOccurence(String w) {
	 if(w.length()>arrayOfDifferentLengths.length)
		 return -1;
	 LinkedList<WordInformation> tmpList = arrayOfDifferentLengths[w.length()];
	 LinkedList<WordOccurrence> wOcc = null;
	 tmpList.findFirst();
	 for(int i = 0; i<tmpList.size; i++) {
		 if(tmpList.retrieve().word.equalsIgnoreCase(w))
			 return tmpList.retrieve().occList.size;
		 tmpList.findNext();
	 }
	 return -1;
	 
	 
 }
 
 public int totalWordsForLength(int l) {
	 if(l>arrayOfDifferentLengths.length)
		 return -1;
	 return arrayOfDifferentLengths[l].size;
 }
 
 public void displayUniqueWords() {
	;
	 sortedArray = new WordInformation[numUniqueWords];
	 LinkedPQ<WordInformation> p = new LinkedPQ<WordInformation>();
	 for(int i = 1; i<k; i++) {
		 LinkedList<WordInformation> tmpList = arrayOfDifferentLengths[i];
		 tmpList.findFirst();
		 for(int j = 0; j<tmpList.size; j++) {
			 System.out.println(tmpList.retrieve().word);
			 p.enqueue(tmpList.retrieve(), tmpList.retrieve().occList.size);
		 }
	 }
	 int l = p.length();
	 for(int i = 0; i<l; i++)
		 sortedArray[i] = p.serve().data;
	 for(int i = 0; i<sortedArray.length; i++) {
		 if(i < sortedArray.length-1)
			 System.out.print("(" + sortedArray[i].word + ", " + sortedArray[i].size + "), ");
		 else
			 System.out.println("(" + sortedArray[i].word + ", " + sortedArray[i].size + ")");
	 }
 }
 
 public LinkedList<WordOccurrence> occurences(String w){
	 LinkedList<WordInformation> tmpList = arrayOfDifferentLengths[w.length()];
	 tmpList.findFirst();
	 for(int i = 0; i<tmpList.size; i++) {
		 if(tmpList.retrieve().word.equalsIgnoreCase(w))
			 return tmpList.retrieve().occList;
		 tmpList.findNext();
	 }
	 return null;
 }
 
 public boolean checkAdjacent(String w1, String w2) {
	 if(w1.length()>arrayOfDifferentLengths.length || w2.length()>arrayOfDifferentLengths.length)
		 return false;
	 LinkedList<WordInformation> tmpList = arrayOfDifferentLengths[w1.length()];
	 LinkedList<WordOccurrence> w1Occ = null;
	 tmpList.findFirst();
	 for(int i = 0; i<tmpList.size; i++) {
		 if(tmpList.retrieve().word.equalsIgnoreCase(w1))
			 w1Occ = tmpList.retrieve().occList;
		 tmpList.findNext();
	 }
	 if(w1Occ == null)
		 return false;
	 
	 tmpList = arrayOfDifferentLengths[w2.length()];
	 LinkedList<WordOccurrence> w2Occ = null;
	 tmpList.findFirst();
	 for(int i = 0; i<tmpList.size; i++) {
		 if(tmpList.retrieve().word.equalsIgnoreCase(w2))
			 w2Occ = tmpList.retrieve().occList;
		 tmpList.findNext();
	 }
	 if(w2Occ == null)
		 return false;
	 return true; //
	 
	 
	 
 }
 
 
 
 
 
 
}
