package Trees;
import java.util.ArrayList;
import Trees.preSuc.TreeNode;

public class paths {


    //root to leaf target sum
    public static boolean pathSum(TreeNode root, int target)
    {
        if(root==null)return false;

        if(root.left==null && root.right==null && root.val==target) return true;

        boolean left= pathSum(root.left, target-root.val);
        boolean right= pathSum(root.right, target-root.val);

        return left||right;

    }

    //print any path sum, not necessarily root to leaf
    public static void kSumPath(TreeNode root, int k, ArrayList<Integer> path)
    {
        if(root==null) return;

        path.add(root.val);

        kSumPath(root.left, k, path); 
        kSumPath(root.right, k, path);

        int sum=0;

        for(int j=path.size()-1; j>=0; j--)
        {
            sum+=path.get(j);

            if(sum==k){
                printPath(path, j);
            }

        }

        path.remove(path.size()-1);
    }


    //find if a path exists from root to a particular node and print path if found
    //to store path, we will populate an arraylist while traversing

    public ArrayList<Integer> arr= new ArrayList<>();
    
    public boolean hasPath(TreeNode root, int x)
    {

        if(root==null) return false;

        arr.add(root.val);

        if(hasPath(root.left, x)|| hasPath(root.right, x)) //check if node is present in left or right subtree
        return true;

        //if not present in any subtree of that node, then remove the node from path
        arr.remove(arr.size()-1);

        return false;

    }


    




    public static void printPath(ArrayList<Integer> path, int i)
    {
        for(int j=i; j<path.size(); j++)
        {
            System.out.print(path.get(j)+" ");
        }
    }

    

    public static void main(String[] args) {
        
    }






    
}
