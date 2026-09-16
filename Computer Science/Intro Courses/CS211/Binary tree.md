---

---
----------------------------------------
@PauL
[<8/2026>]
## Binary Tree node

Binary tree, like linked list, by itself is a node. The on distinction is that it have 2 fields that pointed to two different nod of its kind. It seem the confusing part about the code is of which the class you declare the field is also in the same constructor. This is intuitively harder early on when trying to visualize the node. The problem is of which the translation of those intention within the code into a visualize object of which abstractive. The code for binary tree often as follows

``` Java
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}
```

Notice the 'left' and 'right' field is of the same object of which also containing the field of 'data' as well as node 'left' that also have its own 'data' field and the another separate 'left' and 'right' node that pointing to another node, of which in this case is point at 'null'. The same thing would appear to the 'right' node from the main Treenode declared.

``` Java
----------------
      [1]          -- level 1 --
     /-- \                              '--' the main data field 
   [2]    [3]      -- level 2 --
  /.  \  /.  \
[.]  [.][.]. [.]   -- level 3 --         '.' pointing to a null value
	-----------------    
```

When initialized, the node of a binary tree will contain the [1] tree node that is the one being initialized that containing the suppose 'data' field. While the [2] and [3] is 'right' and 'left' respectively point to a new node of the binary that carry the same capacity. The confusing part is how little the code gives you the information of how much more information it contain. For that reason the node [2] and [3] also exist and thus able to be manipulated. Allows to access up to level three of the binary on a single initialization. 

** This most important thing about a node; and in this case, the tree node of a binary tree; is that of its recursive nature of which the node would call a stack and within that stack contain another stack 

``` Java
     f(---)     base level
	   / \     
  f(---)  f(---)      the 'depth' of a tree is how deep the level 
                      relative to the base root or base level 
```

As so, the constructors of binary tree node usually as follows 
``` Java
class TreeNode {
	private int data;
	private TreenNode left;
	private TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode (int data, Treenode left, Treenode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
```
---------------------
## Traversing through Binary Tree

There are three methods of which convention to traversing the binary tree. There three methods are pre-order, in-order and post-order traversing as follows. Consider the follows binary tree
``` Java
      +---+
      | 3 |
      +---+
       / \
   +---+ +---+
   | 5 | | 2 |
   +---+ +---+
   /      / \
+---+  +---+ +---+
| 1 |  | 4 | | 6 |
+---+  +---+ +---+
```

The three method will following the same round, but the appearance of the data in the binary tree depended on the "facet" that we are considering to count first on the traversal of the algorithms 
``` Java
              +---+
pre-order --> | 3 | <-- post-order
              +---+
                ^
			 in-order      
    
```

Path of traversal --
Imaging a ship moving around the data structure, starting from the root node traveling down through the layer and move from left to right. We can see that the ship will move as subsequence from left side of the root node 3, then left side of 5, then again left facet of 1. After reaching the left facet of 1, the ship move under then to the left facet of 1. Eventually reach the right facet of 5 and the bottom facet of 3. Then round to the right side and landed on the left facet of 2, then to left facet of 4, similarly to 1, wrap around 4. Then reach the facet under 2 and the to the left facet of 6 and wrap around. Finally back to the right facet of 2 then 3 then complete the route. 
Through this journey, depended on the facet of which the ship choose to record, we thus have different result. If the ship decided to count in the "pre-order" style, then it would subsequence count the data the first instant it reach the left facet of each note on its travel. The same for post-order and in-order traversal. With that, we have the following result. 

``` Java 
// Output
Pre-order : [ 3, 5, 1, 2, 4, 6]
In-order : [ 1, 5, 3, 4, 2, 6]
Post-order : [ 1, 5, 4, 6, 2, 3]
```

The following code allows to traversal through different ways
``` Java
class BinaryTree {
	
	private TreeNode root;
	private class TreeNode{
		<....>
	}
	
	public void print() {
		print(root);
	}
	
	public void print(TreeNode current) {
		if (current == null) {
			return;
		}
		
		/*   Pre-order		
		 *System.out.print(current.data + " ");
		 *print(current.left);
		 *print(current.right);		
		 */ 
		
		/*   In-order
		 *print(current.left);
		 *print(crrent.right);
		 *System.out.print(current.data + " ");
		 */
		 
		 //  Post-order
		 print(current.left);
		 print(current.right);
		 System.out.print(current.data + " ");
	}
	
}

```
-------------------------------------------
## Construct a binary tree

Before we could able implement or using a binary tree, we must construct one. Suppose we have the following tree with the starting value of 1 and we wanted to construct a tree with a root that increase in its value as we construct a new three node each increment value. 
``` Java
``` Java
          +---+
          | 1 |
          +---+
           / \
          /   \
      +---+   +---+
      | 2 |   | 3 |
      +---+   +---+
	   /\       /\
      /  \     /  \
  +---++---+ +---++---+
  | 4 || 5 | | 6 || 7 | 
  +---++---+ +---++---+

```
Thus we have the following code for such binary tree construction. Notice that so far we are using "int" as our data type. This code for constructing a binary tree will hence taking an "int" in its constructor.
``` Java
public class BinaryTree {
	private TreeNode root;
	
	public BinaryTree(int max) {
		this.root = buildTree(max, 1);
	}	
	private TreeNote buildTree(int max, int current) {
		if (n > max) {
			return null;
		} else {
			TreeNode left = buildTree(2 * n, max); //even number left 
			TreeNode right = buildTree(2 * n + 1, max; // odd number right
			return new TreeNode(n, left, right);	
		}
	}
}

```

-------------------------------------------
## Some useful methods for Binary Tree

* Method finding the size of the binary tree
``` Java
public class BinaryTree {
	private TreeNode root;
	<...>
	class TreeNode { <...> }
	public int size() {
		size(root);
	}
	
	private int size (TreenNode root) {
		 if (current == null) {
		 	return 0;
		 }
		 
		 int left = size(root.left); // Traversing post-order
		 int right = size(root.right);
		 return 1 + left + right;  // accounting the root by +1
	}
}
```

* Method finding the height (levels) of the binary tree
```Java
public class BinaryTree {
	private TreeNode root;
	<...>
	class TreeNode{ <...> }
	
	public int height() {
		return height(root) - 1;
	}
	
	private int height(TreeNode root) {
		if (current == null) {
			return 0;
		}
		
		int left = height(root.left);
		int right = height(root.right);
		
		// Return the height 
		if (left < right) {
			return 1 + right;
		} else {
			return 1 + left;
		}
		
		// Alternate if-else statement
		// return 1 + (left < right ? right : left);
		
		// Alternative math library ultilize
		// return 1 + Math.max(left, right);
	}
}
```

* Method to calculate the sum of a binary tree
``` Java
public int sum() {
	return sum(root);
}
private int sum(TreeNode root) {
	if (root == null) {
		return 0;
	} else {
		return root.data + sum(root.left) + sum(root.right);
	}
}
```

* Method to count the leaf nodes in the a tree. A leaf node is a node tree that has no children of which both of it left and right node are pointing to null. In Binary Tree, the concept of child, parents, grandparents, siblings,... are rather straight forward and thus no are no further need for introduction. 
``` Java
public int countLeaves() {
	return countLeaves(root);
}

private int countLeaves(TreeNode root) {
	if(root == null) {
		return 0;
	} else if(root.left == null && root.right == null ) {
		return 1;  // i++
	} else {
		return countLeaves(root.left) + count(root.right)
	}
}

```
-----------------------------------------

## Types of Binary Tree
Depending on the shape of the Binary Tree, there are a couple ways of which define these different tree shapes.

* Full : All the nodes have no child or two children 
* Complete : all the level of the tree are filled except for the lowest one possible, of which filled form the left side.
* Balance : One subtree differ in height by most 1 level relative to each others.
* Perfect : Every node has exact two children, and all leaf nodes are ath the same level.
* Degenerate : Every node has only one child and even either to the left or to the right. 
* Skewed : is a pathological/degenerate tree that either dominant completely left or right nodes.
---------------------------------------
## Binary Search Tree (BST)

A Binary Search Tree is a special type of a binary tree that is stored in a special sorted order. BST can never be empty and contain a special property in its tree node. The element of the tree node of a BST left subtree must has value less than the right subtree and conversely, the right subtree has value greater than R's data.

``` Java
// Binary search property
        [Root data : n]
          /      \  
[values <= n ] [values >= n]    
```
Since the BST is sorted, sometime there are duplicates value are allows. When such duplicate does happen, the value often appears on the left subtree. Since the value already in the tree, it would do nothing and does increase the counter variable in the node. 

The follows code is a binary search tree that implement add and remove method. A major thing about this code is that we are substitute the 'int' type to 'E' type to take more type of data

``` Java
public class BST<Type extends Comparable<Type>> {
	private TreeNode<Type> root;
	
	public BST() {
		this.root = null;
	}
	
	// Add 
	public void add(Type value) {
		root = add(value, root);
	}
	private TreeNode<Type> add(Type value, TreeNode<Type> root) {
		if (current == null) {
			current = new TreeNode<Type>(value);
		} else if (value.compareTo(root.data) < 0) {
			add(value, current.left);
			current.left = add(value, root.left);
		} else {
			add(value, root.right);
			current.right = add(value, root.right);
			return root;
		}
	}
	
	
	// Remove
	public void remove(Type value) {
		root = remove(value, root);
	}
	
	private TreeNode<Type> remove(Type value, TreeNode<Type> root) {
		if (root == null) {
			return null;
		}
		
		if (value.compareTo(root.data) < 0) {
			root.left = remove(value, root.left);
		} else if root.right = remove(value, root.right);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.rifht == null) {
				return root.left;
			}
			
			root.data = findMin(root.right);
			root.right = remove(root.right, root.data);
		} 
		
		private Type findMin(TreeNode root) {
			Type min = root.data;
			while (root. left != null) {
				min = root.left.data;
				root = root.left;
			}
			return min;
		}
	
	
	class TreeNode<Type> {
		Type data;
		Treenode<type> right;
		Treenode<type> left;
	}
}

```
