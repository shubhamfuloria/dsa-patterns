
/*
 * POWER SET P(S): is a set of all subsets of S.
 * S: {a, b, c}
 * P(S): {{}, {a}, {b}, {c}, {a, b}, {a, c}, {b, c}, {a, b, c}}
 * 
 * Total no of possible subsets of any set will be 2^n (where n is no of element in S)
 * 
 * Iterative method: 
 * IP: [1, 2, 3]
 * 
 * approach: Every array will have at least one subset which is empty subset {}
 * now if our array size is 1 i.e. [1], then all subsets will be [{}, {1}]
 * (either include 1 or exclude 1, two subsets are possible)
 * 
 * ok now, if I'm having all subsets of [1], can I get subset of [1, 2] using that info?
 * Yes I can . How ?
 * 
 * We already have all subsets which do not include 2, so we just need to add those
 * subsets which do include 2
 * so subsets of [1, 2] => [{}, {1}, {2}, {1, 2}]
 * 
 * Now in the same way if array is [1, 2, 3], we already have all subsets which 
 * do not include 3, so we can add all subsets which do include 3
 * so subsets of [1, 2, 3] => [{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {2, 3}, {1, 2, 3}]
 * That is our answer :)
*/
import java.util.*;

class Program {
  public static void main(String[] args) {

    int[] A = { 1, 2, 3 };
    List<List<Integer>> res = subsetsRecursive(A);

    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> subsetsIterative(int[] A) {

    List<List<Integer>> res = new ArrayList<>();
    // every array has an empty subset
    res.add(new ArrayList<>());
    // [{}]
    for (int el : A) {
      int size = res.size();
      // iteract first size elements with element
      for (int i = 0; i < size; i++) {
        List<Integer> curr = new ArrayList<>(res.get(i)); // {}
        curr.add(el); // {1}
        res.add(curr); // [{}, {1}]
      }
    }
    return res;
  }

  public static List<List<Integer>> subsetsRecursive(int[] A) {

    List<List<Integer>> res = new ArrayList<>();
    // backtrack(A, new ArrayList<>(), res, 0);
    // pick non pick technique
    generateSubsets(A, new ArrayList<>(), res, 0);
    return res;
  }

  public static void backtrack(int[] A, List<Integer> curr, List<List<Integer>> res, int start) {

    // every array contains an empty subset {}
    res.add(new ArrayList<>(curr)); // curr: []

    for (int i = start; i < A.length; i++) {
      curr.add(A[i]); // curr: [1]
      // generate all subsets starting with 1
      backtrack(A, curr, res, i + 1);
      // backtrack (remove 1 from the curr)
      curr.remove(curr.size() - 1); // []
    }
  }

  // pick / non pick technique
  public static void generateSubsets(int[] A, List<Integer> curr, List<List<Integer>> res, int start) {

    if (start == A.length) {
      res.add(new ArrayList<>(curr));
      return;
    }

    // do not pick current element
    generateSubsets(A, curr, res, start + 1);

    // pick current element
    curr.add(A[start]);
    generateSubsets(A, curr, res, start + 1);

    // remove last element (backtrack)
    curr.remove(curr.size() - 1);
  }

}