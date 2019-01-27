package com.algo.stack;
import java.util.EmptyStackException;


public class stack_p_1 {

	public static void main(String[] args) {
		myStack3<Integer> st = new myStack3<>();
		st.push(41);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st);	
		System.out.println(st.size());
		System.out.println(st.pop());		System.out.println(st);System.out.println(st.size());
		System.out.println(st.pop());		System.out.println(st);System.out.println(st.size());
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
	}

}
class myStack3<T>{
	private Node<T> top;	//stack 역할을 수행할 데이터. 
	class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T data){
			this.data = data;
		}
	}
	
	public void push(T data) {
		Node<T> tmp = new Node<>(data);
		tmp.next = top;
		top = tmp;
		
	}
	public T pop() {
		if(top == null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}
	public T peek() {
		if(top == null)
			throw new EmptyStackException();
		return top.data;
	}
	public boolean isEmpty() {return top == null;}
	
	public String size() {
		StringBuffer buf = new StringBuffer("Size : ");
		Node<T> tmp = top;
		int count = 1;
		while(tmp.next != null) {
			tmp = tmp.next;
			count++;
		}
		buf.append(count);
		return buf+"";
	}
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		Node tmp = top;
		buf.append(tmp.data);
		while(tmp.next != null) {
			tmp = tmp.next;
			buf.append(", " + tmp.data);
		}
		buf.append("]");
		return buf+"";
	}
}