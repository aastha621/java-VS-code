package Trees;

public class preSuc {
    
    public class TreeNode {
          int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    
    public static TreeNode pre=null;
    public static TreeNode suc=null;

    public static void findPreSucHelp(TreeNode root, int key) {

        //case 1: if root is the key

        if(root.val==key){

            //pre
            if(root.left!=null){
                TreeNode temp=root.left;

                while(temp.right!=null)
                {
                    temp=temp.right;
                }

                pre=temp;
            }


            //succ
            if(root.right!=null)
            {
                TreeNode temp=root.right;

                while(temp.left!=null)
                {
                    temp=temp.left;
                }

                pre=temp;
            }
        }


        else if(root.val>key){
            suc=root; 
            findPreSucHelp(root.left, key);
        }
        else{
            pre=root;
            findPreSucHelp(root.right, key);
        }




    }

    int ans=Integer.MIN_VALUE;

    public static int maxSubtreeSum(TreeNode root, int sum){

        if(root==null)return 0;


        int currSum=root.val+maxSubtreeSum(root.left, sum)+maxSubtreeSum(root.right, sum);

        sum=Math.max(sum, currSum);


        return sum;




    }

    
}
