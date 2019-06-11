package algo;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private Map<Character, Trie> map;
	
	public Trie() {
	    map = new HashMap<Character, Trie>();
	}
	
	public void insert(String word) {
		if (word != null) {
			add(0, word, word.length());
		}
	}
	
	private void add(int i, String word, int length) {
		if (i < length) {
			//word[i]
			char c = word.charAt(i);
			Trie subTrie = map.get(c);
			if (subTrie == null) {
				//没有
				subTrie = new Trie();
				map.put(c, subTrie);
			}else{
				//有
			}
			//下一个字符
			subTrie.add(i + 1, word, length);
		}else{
			//字符串终止标记|null
			map.put(null, new Trie());
		}
	}
	
	public boolean search(String word) {
		if (word != null) {
			return search(0, word, word.length());
		}
		return false;
	}
	
	private boolean search(int i, String word, int length) {
		if (i < length) {
			char c = word.charAt(i);
			Trie subTrie = map.get(c);
			if (subTrie == null){
				return false;
			}
			//下一个字符
			return subTrie.search(i + 1, word, length);
		}
		//字符串终止标记|null
		return map.containsKey(null);
	}
	
	private boolean searchWithPoint(String word) {
		if (word != null) {
			return searchWithPoint(0, word, word.length());
		}
		return false;
	}
	
	private boolean searchWithPoint(int i, String word, int length) {
		if (i < length) {
			char c = word.charAt(i);
			if (c == '.') {
				//循环所有分支
				for (Character child : map.keySet()) {
					if (child != null) {
						Trie subTrie = map.get(child);
						if (subTrie.searchWithPoint(i + 1, word, length)){
							return true;
						}
					}
				}
				return false;
			}else {
				Trie subTrie = map.get(c);
				if (subTrie == null){
					return false;
				}
				//下一个字符
				return subTrie.searchWithPoint(i + 1, word, length);
			}
		}
		//字符串终止标记|null
		return map.containsKey(null);
	}
	
	public boolean startsWith(String prefix) {
		if (prefix != null) {
			return startsWith(0, prefix, prefix.length());
		}
		return false;
	}
	
	private boolean startsWith(int i, String prefix, int length) {
		if (i < length) {
			char c = prefix.charAt(i);
			Trie subTrie = map.get(c);
			if (subTrie == null){
				return false;
			}
			//下一个字符
			return subTrie.startsWith(i + 1, prefix, length);
		}else{
			//
			return true;
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("boxing");
		trie.insert("box");
		System.out.println(trie.search("b"));
		System.out.println(trie.startsWith("b"));
		
		trie.insert("bad");
		trie.insert("mad");
		System.out.println(trie.searchWithPoint("b.d"));
	}
}
