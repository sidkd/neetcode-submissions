
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Long> stringS = new HashMap();
        Map<Character, Long> stringT = new HashMap();

        stringS = s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(java.util.function.Function.identity(),Collectors.counting()));
        stringT = t.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(java.util.function.Function.identity(),Collectors.counting()));
        
        return stringS.equals(stringT);
    }
}
