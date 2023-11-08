import java.util.PriorityQueue;

class HuffmanNode {
  int item;
  char c;
  HuffmanNode left;
  HuffmanNode right;
}

// Implementing the Huffman algorithm
public class A2 {
	
  public static void printCode(HuffmanNode root, String s) {
    if (root.left == null && root.right == null && Character.isLetter(root.c)) {
      System.out.println(root.c + "   |  " + s);
      return;
    }
    printCode(root.left, s + "0");
    printCode(root.right, s + "1");
  }

  public static void main(String[] args) {
    int n = 4;
    char[] charArray = { 'A', 'B', 'C', 'D' };
    int[] charfreq = { 5, 1, 6, 3 };

    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, (a, b) -> a.item - b.item);

    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode();
      hn.c = charArray[i];
      hn.item = charfreq[i];
      hn.left = null;
      hn.right = null;
      q.add(hn);
    }

    HuffmanNode root = null;

    while (q.size() > 1) {
      HuffmanNode x = q.poll();
      HuffmanNode y = q.poll();
      HuffmanNode f = new HuffmanNode();
      f.item = x.item + y.item;
      f.c = '-';
      f.left = x;
      f.right = y;
      root = f;
      q.add(f);
    }

    System.out.println(" Char | Huffman code ");
    System.out.println("--------------------");
    printCode(root, "");
  }
}
