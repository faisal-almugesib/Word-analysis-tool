package WordAnalysistool;

public interface List <T>{
void findFirst();
void findNext();
boolean last();
boolean full();
boolean empty();
void insert(T e);
void remove();
T retrieve();
void update(T e);
}
