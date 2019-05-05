package com.badalchowdhary.algos.string;

class WildcardMatching {
    public boolean isMatch(String s, String p) {
        
        if (s == null || p == null) return false;
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        dp[0][0] = true;
        
        // 1st row
        for (int col=1; col<dp[0].length; col++)
        {
            if (p.charAt(0) == '*')
            {
                dp[0][col] = true;
            }
        }
        
        // all cells in 1st col are false. no need to set them to false.
        
        for (int i=1; i<dp.length; i++)
        {
            for (int j=1; j<dp[0].length; j++)
            {
                char str = s.charAt(i-1);
                char pat = p.charAt(j-1);
                
                if (str == pat || pat == '?')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (pat == '*')
                {
                    dp[i][j]= dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
        
        
        
        
    }
    
    public static void main(String[] args)
    {
        String s = "aa";
        String p = "*";
        
        WildcardMatching wm = new WildcardMatching();
        boolean isMatch = wm.isMatch(s, p);
        System.out.println(isMatch);
    }
}