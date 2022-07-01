
/*
 * Problem Link: https://leetcode.com/problems/subsets-ii/
 * 
 * we can either use a hashset to avoid duplicacy
 * 
 */
import java.util.*;

class Program {
  public static void main(String[] args) {
    int[] A = { 1, 2, 2 };
    Arrays.sort(A);
    List<List<Integer>> res = subsets(A);

    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> subsets(int[] A) {
    List<List<Integer>> subsets = new ArrayList<>();

    backtrack(A, 0, subsets, new ArrayList<>());

    return subsets;

  }

  public static void backtrack(int[] A, int index, List<List<Integer>> res, List<Integer> curr) {

    res.add(new ArrayList<>(curr));

    for (int i = index; i < A.length; i++) {

      if (i > index && A[i] == A[i - 1])
        continue;
      curr.add(A[i]);
      backtrack(A, i + 1, res, curr);
      curr.remove(curr.size() - 1);
    }

  }
}