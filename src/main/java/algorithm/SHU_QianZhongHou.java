package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://www.cnblogs.com/hengzhezou/p/11027190.html
 */

public class SHU_QianZhongHou {


    /**
     * 1、申请一个栈stack，然后将头节点压入stack中。
     *
     * 2、从stack中弹出栈顶节点，打印，再将其右孩子节点（不为空的话）先压入stack中，最后将其左孩子节点（不为空的话）压入stack中。
     *
     * 3、不断重复步骤2，直到stack为空，全部过程结束。
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {

            stack.push(root);
            while (!stack.empty()) {
                TreeNode tr = stack.pop();
                list.add(tr.val);
                if (tr.right != null) {
                    stack.push(tr.right);
                }
                if (tr.left != null) {
                    stack.push(tr.left);
                }
            }
        }
        return list;
    }

    /**
     *
     *
     * 1、申请一个栈stack，初始时令cur=head
     *
     * 2、先把cur压入栈中，依次把左边界压入栈中，直到为 null
     *
     * 3、从stack中弹出一个节点，记为node，打印node的值，并令cur=node.right,重复步骤2
     *
     * 4、当stack为空且cur为空时，整个过程停止。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    /**
     *
     *
     * 1、申请一个栈s1，然后将头节点压入栈s1中。
     *
     * 2、从s1中弹出的节点记为cur，然后依次将cur的左孩子节点和右孩子节点压入s1中。
     *
     * 3、在整个过程中，每一个从s1中弹出的节点都放进s2中。
     *
     * 4、不断重复步骤2和步骤3，直到s1为空，过程停止。
     *
     * 5、从s2中依次弹出节点并打印，打印的顺序就是后序遍历的顺序。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {



        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();

        if (root != null) {
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                list.add(stack2.pop().val);
            }
        }
        return list;
    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);

        for (int i = 0; i < list.size(); i++) {


            System.out.println(list.get(i));

        }
    }
}
