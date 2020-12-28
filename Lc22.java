/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.*/
import java.util.*;

class Lc22{
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;
        
        dfs(res, new StringBuilder(), n, 0 , 0);
        
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder curr, int n, int l, int r){
        if(l + r == 2 * n){
            res.add(curr.toString());
            return;
        }else{
            
            if(l < n){
                curr.append("(");
                dfs(res, curr, n, l + 1, r);
                curr.deleteCharAt(curr.length()-1);
            }
            
            if(r < l){
                curr.append(")");
                dfs(res, curr, n, l, r + 1);
                curr.deleteCharAt(curr.length()-1);
            }
             
        }
    }
}