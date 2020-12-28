/**/

class Lc39{
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return res;
        
        
        // saves us some time (see after drawing recursion tree)
        //Arrays.sort(candidates);
        
        dfs(res, new ArrayList<>(), candidates, target,  0);
        
        
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> curr, int [] candidates, int target, int pos){
        if(target == 0){
            res.add(new ArrayList<Integer>(curr));
            return;
        }else{
            for(int i = pos; i < candidates.length; i++){
                if(candidates[i] <= target){
                    curr.add(candidates[i]);
                    dfs(res, curr, candidates, target-candidates[i], i);
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
}