// Exercises to create and traverse complete binary trees
/******************************************************************************
* @author Curt Powley
*   <A HREF="mailto:cpowley@hpu.edu"> (cpowley@hpu.edu) </A>
******************************************************************************/
import edu.colorado.nodes.IntBTNode;
import java.util.LinkedList;
import java.util.Queue;

public class TreeDemo
{
   public static void main(String[ ] args)
   {
      // EXERCISE: create and print tree:
      //     1  
      //    / \
      //   2   3
      //  /
      // 4
      IntBTNode n4 = new IntBTNode(4, null, null);
      IntBTNode n2 = new IntBTNode(2, n4,   null);
      IntBTNode n3 = new IntBTNode(3, null, null);
      IntBTNode n1 = new IntBTNode(1, n2,   n3);

      System.out.println("\ninorder:");   n1.inorderPrint();
      System.out.println("\npostorder:"); n1.postorderPrint();
      System.out.println("preorder:");    n1.preorderPrint();
      System.out.println("");


      System.out.println("print tree in breadth-first order:");
      // print tree in breadth-first order
      printBF1(n1);
      IntBTNode x = createTree(1, 15); 

      printBF1(x);

      // Exercise: sum all node data from a tree:
      System.out.println("tree sum 1..4: " + treeSum(n1));

      // EXERCISE: Create a Complete Binary Tree With Data 1..N 
      // Approach one - put nodes in array to make it easy to create
      // links by using a nodes's index to calculate its children indices.
      // Note that the array is just used to create the tree. Once the 
      // tree is created, it can be manipulated without referencing the array
      int N = 10;   // largest node data
      IntBTNode[] a = new IntBTNode[N]; // array to hold nodes
      int n = N;                    // number for node data
      // Fill array R to L, bottom to top, so when a node 
      // is created, its children already exist. Inserted data = n. 
      for (int i = (N-1); i >= 0; i--) {// array index
	  a[i] = new IntBTNode(n, null, null);
	  if ( (2*i+1) < N ) {      // if there is a left child
	      a[i].setLeft(a[2*i+1]);
	      if ((2*i+2) < N)    // if there is a right child
		  a[i].setRight(a[2*i+2]);
	  }
	  n--; // next number for next node
      }
      for (int j = 0; j<N; j++)
	  System.out.print(a[j].getData() + " ");
      System.out.println();
      
      IntBTNode root = a[0]; 
      root.preorderPrint();
      printBF1(root);
      System.out.println("number of tree items: " + IntBTNode.treeSize(root));
      System.out.println("Sum of tree items: " + IntBTNode.treeAdd(root));

      System.out.println("preorder for 1.." + N + " tree created with array:");
      root.preorderPrint();

      // if we sum the node values, note that this is sum i=1 to N of i.
      // recall that the closed-form formulas for this is N^2/2 + N/2
      // let's check that treeAdd gives us this result
      System.out.println("/////////////////////////////////");
      System.out.println("treeAdd sum: " + IntBTNode.treeAdd(root) );      
      System.out.println("closed-form sum: " + (N*N/2 + N/2) );

      // EXERCISE: Create a Complete Binary Tree With Data 1..N 
      // approach two: Recursively without an array
      root = createTree(1, N);
      System.out.println("preorder for 1.." + N + " tree created with DFID recursively without array:");
      printBF1(root); // DFID (depth-first iterative deepening)
      root.preorderPrint();

      // EXERCISE: print contents of a tree in breadth-first order
      System.out.println("breadth-first print order for 1.." + N + " tree:");
      root = createTree(1, N);   // create tree in depth-first L-to-R order
      printBF2(root); // uses a queue to print out the tree
   }

    public static IntBTNode createTree(int n, int N) // depth-first L2R
    {   // n is this node's number; N is maximum number to be assigned
       // Don't start n at 0, since 2*0 is 0 below ==> infinite recursion
      if (n > N)
         return null;

      // create this node
      IntBTNode node = new IntBTNode(n, createTree(2*n, N), 
                            createTree(2*n+1, N));
      return node;
    }

    // example N = 5:
    //         1
    //      2
    //   4
    // 8>5, return null


    //              1
    //           2
    //   4 (0,0)   5 (same as for 4, ==> 5(null,null)

    
    //                 1
    //           2           3
    //   4 (0,0)   5 (0,0)

    //                    1
    //           2                 3
    //   4 (0,0)   5 (0,0)  6(0,0)   7(0,0)

    

    // print in breadth-first order: from top-to-bottom, left-to-right
    public static void printBF1(IntBTNode root)  // approach 1 - iterative deepening
    {
	for (int D = 0; D < 11; D++) {  // could calculate D as function of N 
	    printAtDepth(root, 0, D);
	    System.out.println();
	}
    }
    
   public static void printAtDepth(IntBTNode node, int d, int D)
   {  // node is current node, d is depth of this node, 
      // D is print depth
      if (d == D)
      {
	  System.out.print(node.getData() + " ");
	  if ( node.getData() == (Math.pow(2,d+1)-1) )
	      System.out.println(); // line break at end of each level
      }          
      else
      {
	  if (node.getLeft() != null)
	      printAtDepth(node.getLeft(),  d+1, D);
	  if (node.getRight() != null)
	      printAtDepth(node.getRight(), d+1, D);
      }
   }

   // print in breadth-first order: from top-to-bottom, left-to-right
   public static void printBF2(IntBTNode root)  // approach 2 - use a queue
   {
       Queue<IntBTNode> q = new LinkedList<IntBTNode>( );
       IntBTNode n;

       q.add(root);
       System.out.println();
       while (!q.isEmpty( ))
       {
	   n = q.remove();
           System.out.println(n.getData() + " ");
	   if (n.getLeft() != null)
	       q.add(n.getLeft());
           if (n.getRight() != null)
	       q.add(n.getRight());
       }
       System.out.println();
   }

   public static int treeSum(IntBTNode root)
   {
      if (root == null)
	  return 0;
      else
	  return root.getData() + treeSum(root.getLeft()) + treeSum(root.getRight());
   }   

}




