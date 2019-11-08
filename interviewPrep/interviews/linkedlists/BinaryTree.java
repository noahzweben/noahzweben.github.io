//Tree balanced?:
public static int maxDepth(TreeNode root) {
	if (root == null) return 0;
	return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
}
minDepth --> same but with Math.min {}
then isBalanced: return (maxDepth(root)-minDepth(root)<=1);

///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////// Tree BST?

//Tree BST?
  private boolean isBstRec(BinaryNode<T> currentNode){
    
    if (currentNode == null) return true;
   
    T myData = currentNode.data;

    //checks if the current node is greater than the maximum of the left subtree
    if (currentNode.left != null) {
      T maxLeft = findMax(currentNode.left).data;
      int compareResult = myData.compareTo(maxLeft);
      if (compareResult <=0) return false;
    }
    //checks if the current node is less than the minimum of the right subtree
    if (currentNode.right != null) {
      T minRight = findMin(currentNode.right).data;
      int compareResult = myData.compareTo(minRight);
      if (compareResult >=0) return false;
    }
    //recurses down the tree
    if (!isBstRec(currentNode.left) || !isBstRec(currentNode.right) ) return false;

    //if the node is greater than the max of left tree and less than the min of right tree
    // and these conditions hold for all nodes through the tree, it is a BST
    return true;

  }

//example of finding min
    private BinaryNode<T> findMin(BinaryNode<T> t) {
    if (t == null)
      return null;
    else if (t.left == null)
      return t;
    return findMin(t.left);
  }

///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////// Full Binary Tree

 //full binary tree?
  /* This function tests if a binary tree is a full binary tree. */
bool isFullTree (struct Node* root)
{
    // If empty tree
    if (root == NULL)
        return true;
 
    // If leaf node
    if (root->left == NULL && root->right == NULL)
        return true;
 
    // If both left and right are not NULL, and left & right subtrees
    // are full
    if ((root->left) && (root->right))
        return (isFullTree(root->left) && isFullTree(root->right));
 
    // We reach here when none of the above if conditions work
    return false;

//////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////// Complete Tree

 // complete?
    unsigned int countNodes(struct Node* root)
{
    if (root == NULL)
        return (0);
    return (1 + countNodes(root->left) + countNodes(root->right));
}
 
/* This function checks if the binary tree is complete or not  start at index 0 */
bool isComplete (struct Node* root, unsigned int index,
                 unsigned int number_nodes)
{
    // An empty tree is complete
    if (root == NULL)
        return (true);
 
    // If index assigned to current node is more than
    // number of nodes in tree, then tree is not complete
    if (index >= number_nodes)
        return (false);
 
    // Recur for left and right subtrees
    return (isComplete(root->left, 2*index + 1, number_nodes) &&
            isComplete(root->right, 2*index + 2, number_nodes));


////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////// K biggest element?
k Max of BST: or do an in order traversal and grab the second last when a globabl count varialbe is equal to the k count variable
    void kthLargest(Node node, int k, int count) {

      if(node != null) {

         nthLargest(node.left,k,count); //traversing the left node

         //while visit the node we do the following
         count++; // increment the count and check if that is equal to k
         if ( count == k ) {
           System.out.println("Node found "+node.value);
         } 

         nthLargest(node.right,k,count); //traversing the right node
      }

    }
/////////////////////////////////////////////////////// Ancestor

public Node commonAncestor(Node root, Node p, Node q){
	if covers(root.left,p) && covers(root.left,q) -->return  commonAncestor(root.left,p,q);
	if covers root.right ....--> return commonAncestor (root.right...)
	return root

covers{root,p}
if root = null, false
if root = p, true
return covers (root.left,p) || root.right,p
}


DISTANCE BETWEEN 2 NODES is Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 

////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////// Contains Subtree??

/* A utility function to check whether trees with roots as root1 and
   root2 are identical or not */
bool areIdentical(struct node * root1, struct node *root2)
{
    /* base cases */
    if (root1 == NULL && root2 == NULL)
        return true;
 
    if (root1 == NULL || root2 == NULL)
        return false;
 
    /* Check if the data of both roots is same and data of left and right
       subtrees are also same */
    return (root1->data == root2->data   &&
            areIdentical(root1->left, root2->left) &&
            areIdentical(root1->right, root2->right) );
}
 
 
/* This function returns true if S is a subtree of T, otherwise false */
bool isSubtree(struct node *T, struct node *S)
{
    /* base cases */
    if (S == NULL)
        return true;
 
    if (T == NULL)
        return false;
 
    /* Check the tree with root as current node */
    if (areIdentical(T, S))
        return true;
 
    /* If the tree with root as current node doesn't match then
       try left and right subtrees one by one */
    return isSubtree(T->left, S) ||
           isSubtree(T->right, S);
}
////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////// Tree Coordinates
       static void printCoordinate(Tree root,int x, int y){
             if(root == null)
                   return;
   
             System.out.println(root.data +" : ("+x+","+y+")");
             printCoordinate(root.left, x-1, y-1);
             printCoordinate(root.right, x+1,y-1);
       }
 
 /////////////////////////////////// Depth of a node
       /* Helper function for getLevel().  It returns level of the data if data is
   present in tree, otherwise returns 0.*/
int getLevelUtil(struct node *node, int data, int level)
{
    if (node == NULL)
        return 0;
 
    if (node->data == data)
        return level;
 
    int downlevel = getLevelUtil(node->left, data, level+1);
    if (downlevel != 0)
        return downlevel;
 
    downlevel = getLevelUtil(node->right, data, level+1);
    return downlevel;
}
 
/* Returns level of given data value */
int getLevel(struct node *node, int data)
{
    return getLevelUtil(node,data,1);
}
