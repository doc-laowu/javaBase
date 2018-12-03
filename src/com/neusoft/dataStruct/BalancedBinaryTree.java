package com.neusoft.dataStruct;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		int[] data = new int[20];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100) + 1;
            System.out.print(data[i] + ",");
        }
        System.out.println();

        Node root = new Node();
        root.value = data[0];

        for (int i = 1; i < data.length; i++) {
            root.Store(data[i]);
        }

//        System.out.println(root.Find(data[19]));
//        //先序遍历
//        root.TravelByPre();
//        System.out.println();
        //中序遍历
        root.TravelByMidle();
        System.out.println();
//        //后序遍历
//        root.TravelByAfter();
        System.out.println("深度优先搜索:");
        root.DepthFirstSearch(root);
        System.out.println("\n广度优先搜索:");
        root.BreadthFirstSearch(root);
	}
}

class Node
{
	public int value;
	public Node left;
	public Node right;
	
	public void Store(int value)
	{
		if(value < this.value)
		{
			if(null == this.left)
			{
				this.left = new Node();
				left.value = value;
			}
			else
			{
				this.left.Store(value);
			}
		}
		else
		{
			if(null == this.right)
			{
				this.right = new Node();
				right.value = value;
			}
			else
			{
				this.right.Store(value);
			}
		}
	}
	
	public boolean Find(int value)
	{
		if(this.value == value)
		{
			return true;
		}
		else if(value < this.value)
		{
			if(left == null)
				return false;
			return left.Find(value);
		}
		else
		{
			if(right == null)
				return false;
			return right.Find(value);
		}
	}
	
	public void TravelByPre()
	{
		//根 左 右
		System.out.print(this.value+" ");
		if(this.left != null)
		{
			this.left.TravelByPre();
		}
		if(this.right != null)
		{
			this.right.TravelByPre();
		}
	}
	
	public void TravelByMidle()
	{
		//左 根 右
		if(this.left != null)
			this.left.TravelByMidle();
		System.out.print(this.value+" ");
		if(this.right != null)
			this.right.TravelByMidle();
	}
	
	public void TravelByAfter()
	{
		//左 右 根
		if(this.left != null)
			this.left.TravelByAfter();
		if(this.right != null)
			this.right.TravelByAfter();
		System.out.print(this.value+" ");
	}
	
	
	//深度优先搜索
	public void DepthFirstSearch(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.empty())
		{
			Node node = stack.pop();
			System.out.print(node.value+" ");
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
	}
	
	//广度优先搜索
	public void BreadthFirstSearch(Node root)
	{
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node node = queue.remove();
			System.out.print(node.value+" ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
	}
}