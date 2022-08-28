package Algorithm.niukewang;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: CristianoRonaldo
 * @description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author: wang chi
 * @create: 2020-06-30 02:01
 */
public class N_027_3 {

    // 使用一个动态数组保存所有可能的全排列
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            System.out.println("i = " + i);
            System.out.println("used[i] = " + used[i]);
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;


                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);

                System.out.println("递归之后 => " + path);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        N_027_3 solution = new N_027_3();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
