import java.util.*;

class Lc17{
	/*	Given a string containing digits from 2-9 inclusive, return all 
		possible letter combinations that the number could represent. Return 
		the answer in any order.
	*/

	public static void main(String [] args){
		List<String> test1 = Arrays.asList(new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"});
		List<String> test2 = Arrays.asList(new String[]{"d","e","f"});

		System.out.println(test1.equals(new Lc17().letterCombinations("23")));
		System.out.println(test2.equals(new Lc17().letterCombinations("3")));
	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();

		// sanity check 
		if(digits == null || digits.length() == 0)
			return res;

		String [] mapping = new String [] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv","wxyz"};

		dfs(digits, res, new StringBuilder(), mapping, 0);

		return res;
	}

	private void dfs(String digits, List<String> res, StringBuilder curr, String [] mapping, int pos){
		if(digits.length() == pos){
			res.add(curr.toString());
			return;
		}else{
			String chars = mapping[digits.charAt(pos)-'0'];
			for(int i = 0; i < chars.length(); i++){
				curr.append(mapping[digits.charAt(pos)-'0'].charAt(i));
				dfs(digits, res, curr, mapping, pos + 1);
				curr.deleteCharAt(curr.length()-1);
			}
		}
	}
}