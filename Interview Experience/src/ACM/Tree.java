package ACM;



import java.math.BigDecimal;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }



}


public class Tree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> subsequences = tree.findSubsequences(nums);
        for (List<Integer> list : subsequences) {
            for (int j : list) {
                System.out.print(j);
            }
            System.out.println(",");
        }


    }

    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            if (temp != null) list.add(temp.val);
            else continue;

            st.push(temp.right);
            st.push(temp.left);

        }
        Collections.reverse(list);
        return list;

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode peek = st.peek();
            if (peek.left != null) st.push(peek.left);
            else {
                list.add(st.pop().val);
                if (peek.right != null) st.push(peek.right);
                else list.add(st.pop().val);
            }
        }

        return list;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> Outlist = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                size--;
            }
            Outlist.add(list);
        }
        return Outlist;

    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return Symmetric(root.left, root.right);


    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        boolean result = false;
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            if (temp != null && temp.val == subRoot.val) result = Symmetric(temp, subRoot);
            if (result) return result;
            st.push(temp.left);
            st.push(temp.right);
        }

        return result;


    }

    private boolean Symmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        boolean out = Symmetric(left.left, right.right);
        boolean in = Symmetric(left.right, right.left);

        boolean result = out && in;

        return result;


    }

    //组合的回溯算法
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking1(n, k, 1, list, outlist);
        return outlist;
    }

    private void backtracking1(int n, int k, int startindex, List<Integer> list, List<List<Integer>> outlist) {
        if (list.size() == k) {
            outlist.add(new ArrayList(list));
            return;
        }
        for (int i = startindex; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtracking1(n, k, i + 1, list, outlist);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int result = 0;
        backtracking2(n, k, 1, list, outlist, result);
        return outlist;

    }

    private void backtracking2(int n, int k, int startindex, List<Integer> list, List<List<Integer>> outlist, int result) {
        if (list.size() == k) {
            if (result == n) outlist.add(new ArrayList(list));
            return;
        }
        for (int i = startindex; i < 10; i++) {
            list.add(i);
            result += i;
            backtracking2(n, k, i + 1, list, outlist, result);
            result -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }

    String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };

    public List<String> letterCombinations(String digits) {
        int k = digits.length();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] newdigits = new String[k];
        if (digits == null || digits.length() == 0) {
            return list;
        }
        for (int i = 0; i < k; i++) {
            newdigits[i] = letterMap[Integer.parseInt(String.valueOf(digits.charAt(i)))];
        }
        backtracking3(newdigits, k, 0, sb, list);
        return list;

    }

    private void backtracking3(String[] digits, int k, int startindex1, StringBuilder sb, List<String> list) {
        if (sb.length() == k) {
            list.add(sb.toString());
            return;
        }
        String s = digits[startindex1];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtracking3(digits, k, startindex1, sb, list);
            sb.deleteCharAt(startindex1);
        }


    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int result = 0;
        backtracking4(candidates, target, 0, result, list, outlist);
        return outlist;
    }

    private void backtracking4(int[] candidates, int target, int startindex, int result, List<Integer> list, List<List<Integer>> outlist) {
        if (result == target) {
            outlist.add(new ArrayList<>(list));
            return;
        } else if (result > target) return;
        for (int i = startindex; i < candidates.length; i++) {
            list.add(candidates[i]);
            result += candidates[i];
            backtracking4(candidates, target, i, result, list, outlist);
            list.remove(list.size() - 1);
            result -= candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int result = 0;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used, false);
        backtracking5(candidates, target, 0, result, list, outlist, used);
        return outlist;
    }

    private void backtracking5(int[] candidates, int target, int startindex, int result, List<Integer> list, List<List<Integer>> outlist, boolean[] used) {
        if (result == target) {
            outlist.add(new ArrayList<>(list));
            return;
        } else if (result > target) return;

        for (int i = startindex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            list.add(candidates[i]);
            result += candidates[i];
            used[i] = true;
            backtracking5(candidates, target, i + 1, result, list, outlist, used);
            list.remove(list.size() - 1);
            result -= candidates[i];
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> outlist = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtracking6(s, 0, outlist, list);
        return outlist;

    }

    private void backtracking6(String s, int startindex, List<List<String>> outlist, List<String> list) {
        if (startindex >= s.length()) {
            outlist.add(new ArrayList<>(list));
            return;
        }
        for (int i = startindex; i < s.length(); i++) {
            if (isPalindrome(s.substring(startindex, i + 1))) {
                String str = s.substring(startindex, i + 1);
                list.add(str);
            } else continue;
            backtracking6(s, i + 1, outlist, list);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        boolean result = false;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return result;
            i++;
            j--;
        }
        return true;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> resultlist = new ArrayList<>();
        backtracking7(s, 0, list, resultlist);
        return resultlist;
    }

    private void backtracking7(String s, int startindex, List<String> list, List<String> resultlist) {
        if (startindex >= s.length() && list.size() == 4) {
            resultlist.add(getString(list));
            return;
        }
        for (int i = startindex; i < s.length(); i++) {
            if (isEffectNum(s.substring(startindex, i + 1))) {
                String str = s.substring(startindex, i + 1);
                list.add(str);
            } else continue;

            backtracking7(s, i + 1, list, resultlist);
            list.remove(list.size() - 1);
        }

    }

    private String getString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            if (s != list.get(list.size() - 1)) sb.append('.');
        }
        return sb.toString();
    }

    private boolean isEffectNum(String s) {
        if (s == null) return false;
        else if (s.length() > 1 && s.charAt(0) == '0') return false;
        Long temp = Long.parseLong(s);
        if (temp > 255) return false;
        return true;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        outlist.add(new ArrayList<>());
        backtracking8(nums, 0, outlist, list);
        return outlist;
    }

    private void backtracking8(int[] nums, int startindex, List<List<Integer>> outlist, List<Integer> list) {
        if (startindex >= nums.length) {
            outlist.add(new ArrayList<>(list));
            return;
        }
        for (int i = startindex; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking8(nums, i + 1, outlist, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        outlist.add(new ArrayList<>());
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking9(nums, 0, outlist, list, used);
        return outlist;
    }

    private void backtracking9(int[] nums, int startindex, List<List<Integer>> outlist, List<Integer> list, boolean[] used) {
        if (startindex >= nums.length) {
            return;
        }
        for (int i = startindex; i < nums.length; i++) {
            if ((i > 0 && nums[i - 1] == nums[i] && used[i - 1]) == true) continue;
            list.add(nums[i]);
            outlist.add(new ArrayList<>(list));
            backtracking9(nums, i + 1, outlist, list, used);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking10(nums, 0, outlist, list);
        return outlist;
    }

    private void backtracking10(int[] nums, int startindex, List<List<Integer>> outlist, List<Integer> list) {
        if (list.size() > 1) {
            outlist.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startindex; i < nums.length; i++) {
            if (!list.isEmpty() && nums[i] < list.get(list.size() - 1) && set.contains(nums[i])) continue;
            list.add(nums[i]);
            set.add(nums[i]);
            backtracking10(nums, i + 1, outlist, list);
            list.remove(list.size() - 1);

        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking11(nums, 0, outlist, list, used);
        return outlist;
    }

    private void backtracking11(int[] nums, int startindex, List<List<Integer>> outlist, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            outlist.add(new ArrayList<>(list));
            return;
        }

        for (int i = startindex; i < nums.length; i++) {
            if (i > 0 && used[i]) continue;
            list.add(nums[i]);
            backtracking11(nums, i, outlist, list, used);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> outlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking12(nums, outlist, list, used);
        return outlist;
    }

    private void backtracking12(int[] nums, List<List<Integer>> outlist, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            outlist.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
            if (used[i] == true) continue;
            list.add(nums[i]);
            used[i] = true;
            backtracking12(nums, outlist, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }


    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0,count = 0;
        for(int i = 0 ;i < g.length;i++){
            if(j < s.length-1 && g[i] >= s[j] ){
                count++;
            }else {
                j++;
            }
        }

      return  count;
    }

    public int wiggleMaxLength(int[] nums) {
    if (nums.length == 1) return 1;
    int prenums = 0;
    int curnums = 0;
    int result = 1;
    for(int i = 0;i < nums.length-1;i++){
        curnums = nums[i+1] - nums[i];
        if((prenums >=0 && curnums < 0)||(prenums <= 0 && curnums > 0)){
            result++;
            prenums = curnums;
        }
    }
    return result;

    }


    public int maxSubArray(int[] nums) {
    int result = nums[0];
    int count = 0 ;
    int first = 0;
    for(int j = 0 ;j < nums.length;j++){
        if(nums[j] > 0) {
            first = j;
            break;
        }
    }

    for(int i = first ; i < nums.length;i++){
        count = count + nums[i];
        if(count > result) result = count;
        if(count < 0) count = 0;
    }
    return result;

    }















}
