class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(0,0,"",n,res);
        return res;
    }
    private void dfs(int openp , int closep , String s, int n, List<String> res){
        if(openp == closep && openp+ closep == n*2){
            res.add(s);
            return ;
        }
        if(openp < n){
          dfs(openp + 1, closep , s+ "(" , n, res);
        }
        if(closep< openp){
            dfs(openp , closep + 1, s +")" ,n, res);
        }
    }

}