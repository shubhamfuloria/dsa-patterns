import java.util.*;

class Program {
  public static void main(String[] args) {
    int[] A = { 2, 3, 6, 7 };
    int target = 7;

    List<List<Integer>> res = combinationSum(A, target);

    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }

  private static List<List<Integer>> combinationSum(int[] A, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack2(A, 0, target, new ArrayList<>(), res);
    return res;
  }

  private static void backtrack(int[] A, int pos, int target, List<Integer> curr, List<List<Integer>> res) {

    if (target == 0) {
      res.add(new ArrayList<>(curr));
      return;
    } else if (pos == A.length || target < 0) {
      return;
    }

    // incluing current element
    curr.add(A[pos]);
    backtrack(A, pos, target - A[pos], curr, res);
    curr.remove(curr.size() - 1);

    // exclude current element
    backtrack(A, pos + 1, target, curr, res);
  }

  private static void backtrack2(int[] A, int pos, int target, List<Integer> curr, List<List<Integer>> res) {

    if (target == 0) {
      res.add(new ArrayList<>(curr));
      // return;
    } else if (target < 0) {
      return;
    }

    for (int i = pos; i < A.length; i++) {
      curr.add(A[i]);
      backtrack2(A, i, target - A[i], curr, res);
      curr.remove(curr.size() - 1);
    }
  }
}