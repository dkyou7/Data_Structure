
public class binarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree1 tree = new BinarySearchTree1();
		tree.insert(1);
		tree.insert(23);
		tree.insert(23);
		tree.insert(46);
		tree.insert(34);
		tree.insert(3);
		tree.insert(4);
		tree.inorder();
		tree.delete(5);
		tree.inorder();
	}

}
class BinarySearchTree1{
	class Node{
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	Node root;
	public Node search(Node root,int key) {
		if(root == null || root.data == key) return root;	//���� ��忡 �����߰ų�, �˸��� ���� ������ ��
		if(root.data>key) return search(root.left,key);	// Ű���� �����ͺ��� ������ �������� ���ÿ�.
		return search(root.right,key);	// Ű���� �����ͺ��� ũ�� ���������� ���ÿ�..
	}
	public void insert(int data) {
		root = insert(root,data);
	}
	public Node insert(Node root,int data) {
		if(root == null) {	// ��Ʈ�� �ƿ� �������� �ʰų� , ������ �������� ���.
			root = new Node(data);
			return root;
		}
		if(data < root.data) {
			root.left = insert(root.left,data);	//��� �Լ��� ȣ��.
		}else if(data > root.data) {
			root.right = insert(root.right,data);
		}
		return root;	//���� �ϳ� �޾Ƽ� �����Ѵ�.
	}
	public void delete(int data) {
		root = delete(root,data);
	}
	public Node delete(Node root,int data) {
		if(root == null) return root;
		if(data<root.data) {
			root.left = delete(root.left,data);
		}else if(data>root.data) {
			root.right = delete(root.right,data);
		}else {
			if(root.left == null && root.right == null) return null;
			else if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			
			root.data = findMin(root.right);
			root.right = delete(root.right,root.data);
		}
		return root;
	}
	public int findMin(Node root) {
		int min = root.data;
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	public void inorder() {
		inorder(root);
		System.out.println("");
	}
	private void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	
	
	
	
}