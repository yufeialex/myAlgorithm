package chapter_5_stringproblem;

public class Problem_23_TrieTree {

	public static class TrieNode {
		public int path;
		public int end;
		// 这里是用数组做的hash，26个字母，key就是index。但是实际中如果是汉字，那是用真正的hash表来做的。
		public TrieNode[] map;

		public TrieNode() {
			path = 0;
			end = 0;
			map = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.map[index] == null) {
					node.map[index] = new TrieNode();
				}
				node = node.map[index];
				node.path++;
			}
			// 跳出循环的时候，node就是最后一个结点，path已经在循环里面添加过了
			node.end++;
		}

		public void delete(String word) {
			if (search(word)) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (node.map[index].path-- == 1) {
						node.map[index] = null;
						return;
					}
					node = node.map[index];
				}
				node.end--;
			}
		}

		public boolean search(String word) {
			if (word == null) {
				return false;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.map[index] == null) {
					return false;
				}
				node = node.map[index];
			}
			return node.end != 0;
		}

		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.map[index] == null) {
					return 0;
				}
				node = node.map[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
