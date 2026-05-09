class Solution {
    class trieNode{
        trieNode[] arr;
        boolean isEnd;
        trieNode(){
            arr = new trieNode[26];
            isEnd = false;
        }
    }
    private trieNode root = new trieNode();
    private Integer[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        for(String word: dictionary){
            insert(word);
        }

        memo = new Integer[s.length()];
        return solve(0,s);
    }

    public int solve(int index, String s){
        if(index==s.length()) return 0;

        if(memo[index]!=null) return memo[index];

        int res = 1+solve(index+1, s);

        trieNode curr = root;
        for(int i=index; i<s.length(); i++){
            int idx = s.charAt(i)-'a';
            if(curr.arr[idx]==null) break;

            curr = curr.arr[idx];
            if(curr.isEnd){
                res = Math.min(res, solve(i+1, s));
            }
        }

       return memo[index] = res;
    }
    public void insert(String word){
        trieNode curr = root;
        for(char c: word.toCharArray()){
            int index = c-'a';
            if(curr.arr[index]==null){
                curr.arr[index] = new trieNode();
            }
            curr = curr.arr[index];
        }
        curr.isEnd = true;
    }
}