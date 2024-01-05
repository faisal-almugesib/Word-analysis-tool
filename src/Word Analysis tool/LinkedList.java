package newDesignProject;

public class LinkedList<T> implements List<T>{
private Node<T> head;
private Node<T> cur;
public int size = 0;
public LinkedList() {
	head=cur=null;
}

public boolean empty() {
	return head==null;
}

public boolean full() {
	return false;
}

public boolean last() {
	return cur.getNext()==null;
}

public void findFirst() {
	cur=head;
}

public void findNext() {
	cur=cur.getNext();
}

public void update(T e) {
	cur.setData(e);
}

public void insert(T e) {
	Node<T> tmp = new Node<T>(e);
	if(empty()) {
		head=tmp;
		cur=head;
		size++;
		return;
		}
	tmp.setNext(cur.getNext());
	cur.setNext(tmp);
	cur=tmp;
	size++;
}

public T retrieve() {
	return cur.getData();
}

public void remove() {
	if(cur==head) {
		head=cur=null;
		return;
		}
	
	Node<T> tmp = head;
	
		while(!tmp.getNext().equals(cur))
			tmp=tmp.getNext();
		tmp.setNext(cur.getNext());
		
		if(cur.getNext() == null)
			cur = head;
		else
			cur=cur.getNext();
}

public void display() {
	findFirst();
	while(!last()) {
		System.out.println(cur.getData());
		findNext();
	}
	System.out.println(cur.getData());
}



}
