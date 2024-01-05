package WordAnalysistool;

import java.io.File;
import java.io.FileNotFoundException;

public class TestMain {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("");
		WordAnalysis wa = new WordAnalysis(f);
        
//		wa.readFileAndAnalyse(f);
//		System.out.println(wa.documentLength());
//		System.out.println(wa.uniqueWords());
//		System.out.println(wa.totalOccurence("the"));
//		System.out.println(wa.totalWordsForLength(3));
		wa.displayUniqueWords();
		
//		LinkedList<WordOccurrence> occ = wa.occurences("data");
//		occ.findFirst();
//		while(!occ.last()) {
//			System.out.print("(" + occ.retrieve().lineNo + ", " + occ.retrieve().position + "), ");
//		occ.findNext();
//		 }
//		System.out.println("(" + occ.retrieve().lineNo + ", " + occ.retrieve().position + ")");
	}

}
