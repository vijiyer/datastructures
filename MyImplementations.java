package datastructures;

import java.util.*;

/**
 * Created by vijaya on 2/14/2017.
 */
public class MyImplementations {

//    Implement  an  algorithm  to  determine  if  a
//    string  has  all  unique  characters

    public static boolean isUniqueCharacters(String str) {
        boolean[] char_set = new boolean[256];

        for (int i = 0; i < str.length(); i++) {

            int val = str.charAt(i);

            if (char_set[val]) return false;

            char_set[val] = true;

        }

        return true;

    }

    public static boolean isAnagram (String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i=0;i<str1.length();i++) {
            char c = str1.charAt(i);
            int index = str2.indexOf(c);
            if (index < 0) {
                return false;

            }
            else {
                str2 = str2.substring(0,index) + str2.substring(index+1);
            }
        }
        return str2.isEmpty();

    }

    // method to compute all permutations of a s tring

    public static List<String> permutations(String str) {
        List<String> perm = new ArrayList();
        if (str.length() == 1) {
            perm.add(str);
            return perm;
        }
        if (str.length() == 2) {
            perm.add(str.substring(0,1) + str.substring(1));
            perm.add(str.substring(1) + str.substring(0,1));
        }

        if (str.length() >= 3) {
            for (int i = 0; i < str.length(); i++) {
                String firstChar = str.substring(i, i + 1);
                String remainingStr = str.substring(0, i) + str.substring(i + 1);
                List<String> remainingPerm = permutations(remainingStr);
                for (String s : remainingPerm) {
                    perm.add(firstChar + s);
                }
            }
        }
        System.out.println(perm.size());
        return perm;
    }

//    Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and
//  pennies (1 cent), write code to calculate the number of ways of representing n cents

    static HashMap<Integer, List> moneyMap = new HashMap();

    public static List moneyCombinations(int n) {
        List<String> moneyComb = new ArrayList();
        if (moneyMap.containsKey(n)) {
            return moneyMap.get(n);
        }
        StringBuilder comb = new StringBuilder();
        if (n == 1) {
            comb.append("1");

            moneyComb.add(comb.toString());
            moneyMap.put(n, moneyComb);
            return moneyComb;
        }


            moneyComb.addAll(moneyCombinations(n-1));
        for (int i = 0; i < moneyComb.size(); i++) {
            String elem = moneyComb.get(i);
            moneyComb.set(i, elem + "," + "1");
        }
//        if (n%5 == 0) {
//            int div = n/5;
//            for (int j = 0;j<div;j++) {
//                moneyComb.add("5");
////                if (j <= div) {
////                    moneyComb.add(",");
////                }
//            }
//        }
        if (n==5) {
            // moneyComb.add("5,5");
            moneyComb.add("5");

        }
        if (n==10) {
           // moneyComb.add("5,5");
            moneyComb.add("10");

        }
        if (n==25) {
            moneyComb.add("25");
        }

        moneyMap.put(n, moneyComb);


               return moneyMap.get(n);

    }

    /**
     *
     * @param hour - int from 1 to 12, each hour is 30 deg, + for each min, 0.5 deg
     * @param min - int from 1 to 59, each min is 6 deg
     * @return angle between the 2 hands
     */
    public static double getAngleForTime(int hour, int min) {
        double minDeg = min*6;
        double hourDeg = hour*30 + min*0.5;
        double angleForTime = Math.abs(minDeg - hourDeg);
        System.out.println("getAngleForTime(" + hour + ":" + min + ")" + " = " + angleForTime);
        return angleForTime;
    }

    public static boolean isPalindromePermutation(String word) {
        String trimmedWord = word.toLowerCase().trim();
        char[] chars = trimmedWord.toCharArray();
        HashMap map = new HashMap();
        for (int i=0;i<chars.length;i++) {
            char c = chars[i];
            Integer count = (Integer) map.get(c);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(c, count);
        }
        Collection<Integer> values = map.values();
        int numberOfOddCounts = 0;
        for (Integer count : values) {
            if (count%2 !=0) {
                numberOfOddCounts++;
            }
        }
        boolean isPalindrome = numberOfOddCounts<=1;
        System.out.println("String " + word + " " + (isPalindrome?"is ":"is not ") + "a palindrome permutation");
        return (isPalindrome);

    }

    public static boolean isCheck(String kingPos, String queenPos) {
        // convert kingPos and queen Pos to places on 2 d array
      //  boolean[][] chess = new boolean[8][8];

        int kingFile = kingPos.charAt(0) - (int)'a' + 1;
        int kingRank = Character.getNumericValue(kingPos.charAt(1));
       // chess[kingRank-1][kingFile-1] = true;
System.out.println("King pos : " + kingPos + ": "
        + "file = " + kingFile + ", rank = " + kingRank);
        int queenFile = queenPos.charAt(0) - (int)'a' + 1;
        int queenRank = Character.getNumericValue(queenPos.charAt(1));
        System.out.println("Queen pos : " + queenPos + ": "
                + "file = " + queenFile + ", rank = " + queenRank);

        // now check for moves between the 2 positions,
        if ((kingFile==queenFile) || (kingRank==queenRank)
           // || ((kingFile-kingRank) == (queenFile-queenRank))
                || (Math.abs(kingFile-queenFile) == Math.abs(kingRank-queenRank)) ) {
            System.out.println("***CHECK");
            return true;
        }
       System.out.println("NO CHECK");
    return false;
    }

    /**
     * write sort function so that anagrams are grouped together
     * @param args a list
     */
    public static List<String> sortByAnagram(List<String> words) {
System.out.println("Before sorting " + words);
       // List<String> sortedList = new ArrayList<String>();
     Collections.sort(words, new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {
             if (o1.equals(o2)) {
                 return 0;
             }
             if (isAnagram(o1, o2)) {
                 return 1;
             }
             else {
                 return o1.compareTo(o2);
             }
         }});
        System.out.println("After sorting " + words);
        return words;
    }

    //"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."
    //Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).
    public static int findMatchingParen(String str,  int left) {
        int right=-1;
       // Stack s1 = new Stack();
        char leftParen = str.charAt(left);
        int start = left + 1;
        boolean found = false;
        int rightMatch = -1;
        while (!found) {
            rightMatch = str.indexOf(')', start);
            if (rightMatch >= 0) {
                int leftMatch = str.indexOf('(', start);
                if (leftMatch >= 0 && leftMatch < rightMatch) {
                    start = rightMatch+1;
                }
                else {
                    found = true;
                }
            }

        }
        if (rightMatch == -1) {
            System.out.println("Not found for " + str + " left " + left);
        }
        System.out.println("found for " + str + " left " + left +  " right " + rightMatch + "**" + str.substring(left, rightMatch+1));
        return rightMatch;



//        // s1.push (leftParen);
//        boolean found = false;
//       // int start = left;
////        while (!found) {
////             int loc = str.indexOf('(', start);
////             if (loc >=0) {
////                 s1.push(str.charAt(loc));
////             }
////        }
//
//        return right;
    }

    public static void main(String[] args) {
        // System.out.println("permutations " + permutations("norbw"));
        // System.out.println("moneyCombinations " + moneyCombinations(25));
      // getAngleForTime(3,30);
//        getAngleForTime(3,30);
//        getAngleForTime(3,40);
//        getAngleForTime(3,45);
//        getAngleForTime(4,0);
//        getAngleForTime(12,30);
//        getAngleForTime(6,0);
//        isPalindromePermutation("civic");
//        isPalindromePermutation("ivicc");
//        isPalindromePermutation("civil");
//        isPalindromePermutation("livci");
//        isPalindromePermutation("malayalam");
//        isPalindromePermutation("hoho");
//        isPalindromePermutation("Red rum, sir, is murder");

//        isCheck("a1","a4");
//        isCheck("a1","k1");
//        isCheck("a1","h8");
//        isCheck("a1","b2");
//        isCheck("a1","c2");
//
//        isCheck("g2","h1");
//
//        isCheck("h8","g7");
//        isCheck("a2","c1");


//List words = new ArrayList<String>();
//        words.add("rat");
//        words.add("and");
//        words.add("tar");
//        words.add("art");
//        words.add("act");
//        sortByAnagram(words);

        //String str = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        String str = "((abc))";
        findMatchingParen(str, 0);
        findMatchingParen(str, 1);
        String str1 = "(()(())).";
        findMatchingParen(str1, 0);
    }


}
