package com.mywork.arrays;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<Integer> uniqueNums = removeDuplicates(nums);
    Collections.sort(uniqueNums);
    List<List<Integer>> solution = new ArrayList<>();
    Set<String> uniquertrippletes = new TreeSet<>();
    for(int i = 0; i< uniqueNums.size(); i++) {
      List<List<Integer>> pairs = findPairWithGivenSum(uniqueNums, i , -nums[i]);
      if(!pairs.isEmpty()) {
        for(List<Integer> pair: pairs) {
          pair.add(0, uniqueNums.get(i));
          Collections.sort(pair);
          System.out.println(pair);
          String tripplet = pair.toString();
          if(!uniquertrippletes.contains(tripplet)) {
            uniquertrippletes.add(tripplet);
            solution.add(pair);
          }
        }
      }
    }
    System.out.println(uniquertrippletes);
    return solution;
  }

  private List<Integer> removeDuplicates(int[] nums) {
    TreeSet<Integer> uniqueNums = new TreeSet<>();
    for (int i : nums) {
      uniqueNums.add(i);
    }
    return new ArrayList<>(uniqueNums);
  }

  private List<List<Integer>> findPairWithGivenSum(List<Integer> nums, int skipIndex, int targetSum)
  {
    List<List<Integer>> pairs = new ArrayList<>();
    int i = 0;
    int j = nums.size()-1;
    int sum;
    while(i < j) {
      if( i== skipIndex) {
        i++;
      } else if(j == skipIndex) {
        j--;
      } else {
        sum = nums.get(i) + nums.get(j);
        if(sum == targetSum)
        {
          List<Integer> pair = new ArrayList<>();
          pair.add(nums.get(i) );
          pair.add(nums.get(j) );
          pairs.add(pair);
          i++;
          j--;
        }
        if(sum < targetSum) {
          i++;
        } else {
          j--;
        }
      }
    }
    return pairs;
  }

}

public class TripletsSum {
  public static void main(String[] args) {
    int[] l = new int[]{1,2,3,4};
    Set<Integer> lis =  new TreeSet<>() ;
    for(int i : l) {
      lis.add(i);
    }
    System.out.println(lis);
  }
}
