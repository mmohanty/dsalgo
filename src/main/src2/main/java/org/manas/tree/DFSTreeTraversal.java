package org.manas.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohanty on 03-08-2016.
 */
public class DFSTreeTraversal {
    private final Node node;

    public DFSTreeTraversal(Node node) {
        this.node = node;
    }

    /**
     * Traverse left node, root and right node sequentially.
     * @return
     */
    public List<Integer> inorderTraversal() {
        List<Integer> list = new ArrayList<Integer>();
        traverseInorder(this.node, list);
        return list;
    }

    public List<Integer> preorderTraversal() {
        List<Integer> list = new ArrayList<Integer>();
        traversePreorder(this.node, list);
        return list;
    }

    public List<Integer> postorderTraversal() {
        List<Integer> list = new ArrayList<Integer>();
        traversePostorder(this.node, list);
        return list;
    }

    private void traverseInorder(Node node, List<Integer> list){
        if(node == null){
            return;
        }else{
            traverseInorder(node.getLeftNode(), list);
            list.add(node.getNodeValue());
            traverseInorder(node.getRightNode(), list);
        }
    }

    private void traversePreorder(Node node, List<Integer> list){
        if(node == null){
            return;
        }else{
            list.add(node.getNodeValue());
            traversePreorder(node.getLeftNode(), list);
            traversePreorder(node.getRightNode(), list);
        }
    }

    private void traversePostorder(Node node, List<Integer> list){
        if(node == null){
            return;
        }else{
            traversePostorder(node.getLeftNode(), list);
            traversePostorder(node.getRightNode(), list);
            list.add(node.getNodeValue());
        }
    }
}
