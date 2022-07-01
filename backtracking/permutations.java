import java.util.*;

class Program {
  public static void main(String[] args) {
    int[] A = { 1, 2, 3 };
    List<List<Integer>> res = permutations(A);

    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> permutations(int[] A) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[A.length];
    backtrack(A, new ArrayList<>(), res, used);
    return res;
  }

  private static void backtrack(int[] A, List<Integer> curr, List<List<Integer>> res, boolean[] used) {

    if (curr.size() == A.length) {
      res.add(new ArrayList<>(curr));
    }

    for (int i = 0; i < A.length; i++) {
      if (used[i] == true) {
        continue;
      }
      used[i] = true;
      curr.add(A[i]);
      backtrack(A, curr, res, used);
      curr.remove(curr.size() - 1);
      used[i] = false;
    }
  }
}