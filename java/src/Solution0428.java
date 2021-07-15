import sun.awt.image.ImageWatched;

import java.util.*;

class Node428 {
    public int val;
    public List<Node428> children;

    public Node428(){}

    public Node428(int val) {
        this.val = val;
    }

    public Node428(int val, List<Node428> children) {
        this.val = val;
        this.children = children;
    }
}
public class Solution0428 {
    // Encodes a tree to a single string.
    public String serialize(Node428 root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        dfsSerialize(sb, root, 0, 1);
        return sb.toString();
    }

    public void dfsSerialize(StringBuilder sb, Node428 node, int index, int size) {
        sb.append(" " + String.valueOf(node.val) + " ");
        if (!node.children.isEmpty()) {
            sb.append("[");
        }
        if (!node.children.isEmpty()) {
            List<Node428> children = node.children;
            int s = children.size();
            for (int i = 0; i < children.size(); i++) {
                dfsSerialize(sb, children.get(i), i, s);
            }
            sb.append(" ] ");
        }
    }

    // Decodes your encoded data to tree.
    public Node428 deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Stack<Node428> stack = new Stack<>();
        Node428 root = null;
        Node428 cur = null;
        String[] datas = data.split(" ");
        List<String> ds = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {
            if (!datas[i].equals(" ") && !datas[i].equals("")) {
                ds.add(datas[i]);
            }
        }

        for (int i = 0; i < ds.size(); i++) {
            String ts = ds.get(i);
            if (ts.equals("[")) {
                stack.push(cur);
            } else if (ts.equals("]")) {
                stack.pop();
            } else {
                Node428 node = new Node428(Integer.parseInt(ts), new ArrayList<>(0));
                if (root == null) {
                    root = node;
                } else {
                    Node428 parent = stack.peek();
                    parent.children.add(node);
                }
                cur = node;
            }
        }
        return root;
    }
}
//ac的答案。本地node改成了node428
//public class Solution {
//    // Encodes a tree to a single string.
//    public String serialize(Node root) {
//        if (root == null) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder("");
//        dfsSerialize(sb, root, 0, 1);
//        return sb.toString();
//    }
//
//    public void dfsSerialize(StringBuilder sb, Node node, int index, int size) {
//        sb.append(" " + String.valueOf(node.val) + " ");
//        if (!node.children.isEmpty()) {
//            sb.append("[");
//        }
//        if (!node.children.isEmpty()) {
//            List<Node> children = node.children;
//            int s = children.size();
//            for (int i = 0; i < children.size(); i++) {
//                dfsSerialize(sb, children.get(i), i, s);
//            }
//            sb.append(" ] ");
//        }
//    }
//
//    // Decodes your encoded data to tree.
//    public Node deserialize(String data) {
//        if (data.isEmpty()) {
//            return null;
//        }
//        Stack<Node> stack = new Stack<>();
//        Node root = null;
//        Node cur = null;
//        String[] datas = data.split(" ");
//        List<String> ds = new ArrayList<>();
//        for (int i = 0; i < datas.length; i++) {
//            if (!datas[i].equals(" ") && !datas[i].equals("")) {
//                ds.add(datas[i]);
//            }
//        }
//
//        for (int i = 0; i < ds.size(); i++) {
//            String ts = ds.get(i);
//            if (ts.equals("[")) {
//                stack.push(cur);
//            } else if (ts.equals("]")) {
//                stack.pop();
//            } else {
//                Node node = new Node(Integer.parseInt(ts), new ArrayList<>(0));
//                if (root == null) {
//                    root = node;
//                } else {
//                    Node parent = stack.peek();
//                    parent.children.add(node);
//                }
//                cur = node;
//            }
//        }
//        return root;
//    }
//}
