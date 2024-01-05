package WordAnalysistool;

public class WordInformation {
String word;
LinkedList<WordOccurrence> occList;
int size=0;


public WordInformation(String w,int l, int p ) {
	word=w;
	WordOccurrence wo = new WordOccurrence(l, p);
	occList = new LinkedList<WordOccurrence>();
	occList.insert(wo);
	size++;
}


public void addOccurrence(WordOccurrence wo) {
	occList.insert(wo);
	size++;
}

}
