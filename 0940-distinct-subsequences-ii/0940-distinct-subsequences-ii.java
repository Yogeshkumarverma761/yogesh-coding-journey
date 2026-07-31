// class Solution {

//     public int distinctSubseqII(String s) {
//         StringBuilder sb = new StringBuilder();
//         HashSet<String> set = new HashSet<>();

//         int n = dfs(s, 0, sb, 0 , set);
//         return n;
//     }

//     public static int dfs(String s, int i ,  StringBuilder ss, int ch , HashSet<String> set) {
//         if (ch >= s.length()) {
//             return set.size();
//         }

//         ss.append(s.charAt(ch));
//         set.add(ss.toString());

//         dfs(s, i + 1, ss, ch + 1 ,set );

//         ss.deleteCharAt(ss.length() - 1);

//           dfs(s, i, ss, ch + 1 , set)  ;

//          return set.size();


//     }



// }

class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;

        int[] dp = new int[n+1];
        int[] last = new int[26];
        Arrays.fill(last, -1);

        dp[0] = 1; 
        for(int i = 1; i <= n; i++){
            char ch = s.charAt(i-1);

            dp[i] = (dp[i-1]*2)%MOD;

            if(last[ch-'a'] != -1){
                dp[i] = (dp[i] - dp[last[ch-'a'] - 1] + MOD)%MOD;
            }

            last[ch-'a'] = i;
        }

        return (dp[n]-1 + MOD)%MOD;
    }
}