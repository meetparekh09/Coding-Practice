package practice;

import java.util.ArrayList;
import java.util.LinkedList;


public class Tree {
    TreeNode root;

    public boolean insert(int value) {
        if(root == null) {
            root = new TreeNode(value, null, null, null);
            return true;
        }

        TreeNode traveller = root;
        TreeNode follower = root;

        while(traveller != null) {
            follower = traveller;
            if(value <= traveller.value) {
                traveller = traveller.left;
            } else {
                traveller = traveller.right;
            }
        }

        if(value <= follower.value) {
            follower.left = new TreeNode(value, null, null, follower);
        } else {
            follower.right = new TreeNode(value, null, null, follower);
        }

        return true;
    }

    public TreeNode get(int value) {
        if(root == null) {
            return null;
        }

        TreeNode traveller = root;

        while(traveller != null) {
            if(value == traveller.value) {
                return traveller;
            } else if(value < traveller.value) {
                traveller = traveller.left;
            } else {
                traveller = traveller.right;
            }
        }

        return traveller;
    }



    public TreeNode getMax(TreeNode r) {
        TreeNode traveller = r;
        while(traveller.right != null) {
            traveller = traveller.right;
        }

        return traveller;
    }

    public TreeNode getMin(TreeNode r) {
        TreeNode traveller = r;
        while(traveller.left != null) {
            traveller = traveller.left;
        }

        return traveller;
    }

    public TreeNode getPredecessor(int value) {
        TreeNode node = get(value);
        if(node == null) {
            return null;
        }

        if(node.left != null) {
            return getMax(node.left);
        } else {
            TreeNode traveller = node;

            while(node != null) {
                if(node.parent != null && node.parent.right == node) {
                    node = node.parent;
                    break;
                }
                node = node.parent;
            }

            return node;
        }
    }

    public TreeNode getSuccessor(int value) {
        TreeNode node = get(value);
        if(node == null) {
            return null;
        }

        if(node.right != null) {
            return getMin(node.right);
        } else {
            TreeNode traveller = node;

            while(node != null) {
                if(node.parent != null && node.parent.left == node) {
                    node = node.parent;
                    break;
                }
                node = node.parent;
            }

            return node;
        }
    }

    public void printInorder(TreeNode r) {
        if(r == null) return;
        printInorder(r.left);
        System.out.println(r.value);
        printInorder(r.right);
    }

    public int getHeight() {
        return getHeight(root, 0);
    }

    private int getHeight(TreeNode r, int height) {
        if(r == null) return height;
        // System.out.println("At " + r.value + " Height " + height);
        int h1 = getHeight(r.left, height + 1);
        int h2 = getHeight(r.right, height + 1);
        // System.out.println("At " + r.value + " Height at this subtree " + height);
        return Math.max(h1, h2);
    }

    public ArrayList<LinkedList<Integer>> listOfDepths() {
        int height = getHeight();
        ArrayList<LinkedList<Integer>> dList = new ArrayList<>();

        for(int i = 0; i < height; i++) {
            dList.add(new LinkedList<Integer>());
        }

        addToDepth(root, 0, dList);

        return dList;
    }

    private void addToDepth(TreeNode r, int height, ArrayList<LinkedList<Integer>> dList) {
        if(r == null)
            return;
        dList.get(height).add(new Integer(r.value));
        addToDepth(r.left, height+1, dList);
        addToDepth(r.right, height+1, dList);
    }

    public static void main(String []args) {
        Tree tree = new Tree();
        int []vals = new int[]{20, 10, 30, 27, 21, 25, 28, 17, 13};

        for(int val: vals) {
            tree.insert(val);
        }

        //tree.printInorder(tree.root);

        TreeNode pre = tree.getPredecessor(30);
        // System.out.println(pre.value);
        pre = tree.getPredecessor(21);
        // System.out.println(pre.value);
        TreeNode suc = tree.getSuccessor(10);
        // System.out.println(suc.value);
        suc = tree.getSuccessor(28);
        // System.out.println(suc.value);
        // System.out.println(tree.getHeight());


        vals = new int[]{10, 13, 32, 54, 64, 72, 89, 99, 203, 501};
        tree = new Tree();
        insert(vals, tree, 0, vals.length - 1);
        // System.out.println(tree.getHeight());
        // tree.printInorder(tree.root);

        ArrayList<LinkedList<Integer>> dList = tree.listOfDepths();
        int depth = 0;
        for(LinkedList<Integer> list : dList) {
            System.out.print(depth + " :: ");
            for(int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
            depth++;
        }
    }

    public static void insert(int []vals, Tree tree, int start, int end) {
        if(start > end) return;
        int mid = (start + end) / 2;
        // System.out.println("Inserting " + vals[mid]);
        tree.insert(vals[mid]);
        insert(vals, tree, start, mid-1);
        insert(vals, tree, mid+1, end);
    }


}


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(int value, TreeNode left, TreeNode right, TreeNode parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
