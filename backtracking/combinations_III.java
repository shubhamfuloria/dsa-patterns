import java.util.*;

/*Problem Link: https://leetcode.com/problems/combination-sum-iii/
 * 
 * we need to find combinations of k elements, which sums n.
 * we can use [1, 9] numbers, (1 number at most once)
 * 
 * 
 */
class Program {
  public static void main(String[] args) {
    int k = 3, n = 7;

    List<List<Integer>> combs = combinations(k, n);

    for (List<Integer> list : combs) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> combinations(int k, int n) {
    List<List<Integer>> combs = new ArrayList<>();
    // backtrack(k, n, 1, new ArrayList<>(), combs);
    backtrack1(k, n, 1, 0, new ArrayList<>(), combs);
    return combs;

  }

  public static void backtrack(int k, int n, int start, List<Integer> curr, List<List<Integer>> combs) {

    if (curr.size() == k && sum(curr) == n) {
      combs.add(new ArrayList<>(curr));
    }

    for (int i = start; i <= 9; i++) {
      curr.add(i); // [1]
      backtrack(k, n, i + 1, curr, combs);
      curr.remove(curr.size() - 1); // []
    }

  }

  // not using extra sum() function, instead calculating sum OTG
  public static void backtrack1(int k, int n, int start, int sum, List<Integer> curr, List<List<Integer>> combs) {

    if (curr.size() == k && sum == n) {
      combs.add(new ArrayList<>(curr));
    }

    for (int i = start; i <= 9; i++) {
      curr.add(i); // [1]
      backtrack1(k, n, i + 1, sum + i, curr, combs);
      curr.remove(curr.size() - 1); // []
    }

  }

  // utility functions

  public static int sum(List<Integer> A) {
    int sum = 0;
    for (int el : A) {
      sum += el;
    }
    return sum;
  }
}
