import java.util.*;

/*
 problem: https://leetcode.com/problems/combinations/
Combinations: Number of possible arrangements in a collection of items where 
 *               order of selection does not matter
 * 
    The problem is very similar to subset I . We just need to generate subsets of 
    numbers in [1, n] range. We can either create an array or work on the range itself.
    The code difference (from subsets I) will be while saving the result we'll filter it
    (will save only subsets having size k) 
 * 
 * 
 */
class Program {

  public static void main(String[] args) {
    int n = 3;
    int k = 2;

    List<List<Integer>> res = combinations(n, k);

    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> combinations(int n, int k) {
    int[] A = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = i + 1;
    }
    // A: [1, 2, 3, 4]

    List<List<Integer>> res = new ArrayList<>();
    // backtrack(A, k, 0, new ArrayList<>(), res);
    // backtrack1(n, k, 1, new ArrayList<>(), res);
    generateCombinations(A, k, 0, new ArrayList<>(), res);
    return res;
  }

  public static void backtrack(int[] A, int k, int start, List<Integer> curr, List<List<Integer>> res) {

    if (curr.size() == k) {
      res.add(new ArrayList<>(curr));// res: [{}]
    }
    for (int i = start; i < A.length; i++) {
      curr.add(A[i]);// [1];
      backtrack(A, k, i + 1, curr, res); // generate all subsets that follows [1]
      // backtrack
      curr.remove(curr.size() - 1); // []
    }
  }

  // without using additional array
  public static void backtrack1(int n, int k, int start, List<Integer> curr, List<List<Integer>> res) {

    if (curr.size() == k) {
      res.add(new ArrayList<>(curr));
    } else {
      // additional optimization
      // cuz we do not need those subsets having size greater than k
      return;
    }

    for (int i = start; i <= n; i++) {
      curr.add(i); // [1]
      backtrack1(n, k, i + 1, curr, res); // generate all subsets that follows [1, ...]
      // backtrack
      curr.remove(curr.size() - 1);// []
    }
  }

  // using pick / non-pick technique
  public static void generateCombinations(int[] A, int k, int index, List<Integer> curr, List<List<Integer>> res) {

    if (index == A.length) {
      if (curr.size() == k) {
        res.add(new ArrayList<>(curr));
      }
      return;
    }

    // excluding current element
    generateCombinations(A, k, index + 1, curr, res);

    // including current element
    curr.add(A[index]);
    generateCombinations(A, k, index + 1, curr, res);
    curr.remove(curr.size() - 1);
  }
}
