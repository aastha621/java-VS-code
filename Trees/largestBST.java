package Trees;
import Trees.preSuc.TreeNode;

public class largestBST {

    class BSTpair{
        boolean isBST;
        int min;
        int max;
        int size;
        TreeNode lroot;
    }

    public BSTpair validBST(TreeNode root){
        if(root==null){
            BSTpair leaf=new BSTpair();
            leaf.min=Integer.MAX_VALUE;
            leaf.max=Integer.MIN_VALUE;
            leaf.isBST=true;
            return leaf;


        }
        
        BSTpair lp= validBST(root.left);
        BSTpair rp= validBST(root.right);

        BSTpair mp= new BSTpair();

        mp.isBST= lp.isBST && rp.isBST && (root.val>lp.max && root.val<rp.min); //check if bst node

        mp.max= Math.max(root.val, Math.max(lp.max, rp.max)); 
        mp.min=Math.min(root.val, Math.min(lp.min, rp.min));

        return mp;


    }


    public BSTpair largestBSTinBT(TreeNode root){
        if(root==null){
            BSTpair leaf=new BSTpair();
            leaf.min=Integer.MAX_VALUE;
            leaf.max=Integer.MIN_VALUE;
            leaf.isBST=true;
            leaf.size=0;
            leaf.lroot=null;
            return leaf;


        }
        
        BSTpair lp= validBST(root.left);
        BSTpair rp= validBST(root.right);

        BSTpair mp= new BSTpair();

        mp.isBST= lp.isBST && rp.isBST && (root.val>lp.max && root.val<rp.min); //check if bst node

        mp.max= Math.max(root.val, Math.max(lp.max, rp.max)); 
        mp.min=Math.min(root.val, Math.min(lp.min, rp.min));

        if(mp.isBST){
            mp.lroot=root;
            mp.size=lp.size+rp.size+1;
        }
        else if(lp.size>rp.size){
            mp.lroot=lp.lroot;
            mp.size=lp.size;

        }
        else{

            mp.lroot=rp.lroot;
            mp.size=rp.size;

        }

        return mp;

    }



    
}
