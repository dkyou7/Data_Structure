package com.algo.linkedlist;

public class linkedlist {

	public static void main(String[] args) {
		LinkedList1 ll = new LinkedList1();
		ll.append(1);
		ll.append(2);
		ll.append(5);
		ll.append(4);
		ll.append(5);
		ll.showAll();
		ll.delete(4);
		ll.showAll();
		System.out.println(ll.retrive(6));
	}

}
class LinkedList1{
	Node header;
	
	class Node{
		int data;
		Node next = null;
	}
	
	LinkedList1(){
		header = new Node();
	}
	void append(int data) {
		Node end = new Node();
		end.data = data;
		Node n = header;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	void delete(int data) {
		Node tmp = header;
		while(tmp.next != null) {
			if(tmp.next.data == data) {
				tmp.next = tmp.next.next;
			}else {
				tmp = tmp.next;
			}
		}
	}
	void showAll() {
		Node tmp = header.next;
		while(tmp.next != null) {
			System.out.print(tmp.data+"-");
			tmp = tmp.next;
		}
		//다음이 null값이란 이야기는 마지막 노드라는 이야기가 된다.지금 출력하는 값이 노드의 마지막이라는 이야기이다.
		System.out.println(tmp.data);
	}
	int retrive(int data) {
		Node tmp = header.next;
		while(tmp.next != null) {
			if(tmp.next.data == data){return tmp.next.data;}
			tmp = tmp.next;
		}
		return -1;
	}
}