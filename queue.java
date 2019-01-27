package com.algo.queue;

import java.util.NoSuchElementException;

public class myQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
	}

}

class Queue<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void add(T item) {
		Node<T> tmp = new Node<T>(item);
		if(last != null) {
			last.next = tmp;
		}
		last = tmp;
		if(first == null) {
			first = last;
		}
	}
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		if(first == null) {	//���� ĭ���� �ű�� ���� null�̸� 
			last = null;	//last�� null�� �ٲپ��ش�.
		}
		return data;
	}
	public T peek() {
		if( first == null)
			throw new NoSuchElementException();
		return first.data;
	}
	public boolean isEmpty() {
		return first==null;
	}
	
	
}