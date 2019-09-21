package com.ray.utilty;


public class HackerRankBinary {
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
		}
		public Node() {
			
		}
	}	
		public static Node insert(Node root,int data) {
			if(root==null) {
				root=new Node();
				root.data=data;
				return root;
			}
			Node temp=root;
			Node parent=null;
			while(temp!=null) {
				parent=temp;
				
				if(data<temp.data) {
					temp=temp.left;
				}else if(data>temp.data) {
					temp=temp.right;
				}
			}
			if(data>parent.data) {
				parent.right=new Node(data);
			}
			else {
				parent.left=new Node(data);
			}
			
			return root;
		}//function
		
		public static void preOrder(Node root) {
			if(root==null) {
				return;
			}
			System.out.print(root.data+">");
			preOrder(root.left);
			preOrder(root.right);
		}// function
		
		public static void inOrder(Node root) {
			if(root==null) {
				return;
			}
			inOrder(root.left);
			System.out.print(root.data+">");
			inOrder(root.right);
		}// function
	
		public static void postOrder(Node root) {
			if(root==null) {
				return;
			}
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+">");
		}// function
		

	public static void main(String[] args) {
		
		System.out.println(" Enter Size of tree");
		int size=Util.nextInt();
		Node root=null;
		while(size-->0) {
			System.out.println("Entder new data");
			int data=Util.nextInt();
			root=insert(root,data);
			System.out.print("\nPostOrder::");
			postOrder(root);
		}
		System.out.print("\nPreOrder::");
		preOrder(root);
 
		System.out.print("\ninOrder::");
		inOrder(root);
		System.out.print("\npostOrde::");
		postOrder(root);
	}

}
