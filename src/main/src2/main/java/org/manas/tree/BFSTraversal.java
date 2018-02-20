package org.manas.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mohanty on 03-08-2016.
 */
public class BFSTraversal {

    private Node node;

    public BFSTraversal(Node node) {
        this.node = node;
    }

    public List<Integer> traverse() {
        int height = getHeightOfTree(this.node);
        List<Integer> list = new ArrayList<Integer>((int)Math.pow(2,height));
        for (int i=1; i<=height; i++){
            traverse(list,this.node, i);
        }
        return list;
    }

    public List<Integer> traverseThroughQueue(){
        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(this.node);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node.getNodeValue());
            if(node.getLeftNode() != null){
                queue.add(node.getLeftNode());
            }
            if(node.getRightNode() != null){
                queue.add(node.getRightNode());
            }
        }
        return list;
    }

    private void traverse(List<Integer> list, Node node, int level) {
        if (node == null) {
            return;
        }else if(level ==1){
            list.add(node.getNodeValue());
        }else if(level > 1){
            traverse(list, node.getLeftNode(), level-1);
            traverse(list, node.getRightNode(), level-1);
        }
    }

    private int getHeightOfTree(Node node) {
        if(node == null){
            return 0;
        }
        else{
            int heightOfLeftTree = getHeightOfTree(node.getLeftNode());
            int heightOfRightTree = getHeightOfTree(node.getRightNode());

            if(heightOfLeftTree > heightOfRightTree){
                return  heightOfLeftTree + 1;
            }else{
                return heightOfRightTree + 1;
            }
        }
    }
}


