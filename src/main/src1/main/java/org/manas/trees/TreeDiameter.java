package org.manas.trees;

/**
 * Created by mohanty on 15-08-2016.
 */
public class TreeDiameter {
    
    public int findDiameter(final Node node){
        if(node == null){
            return 0;
        }
        int lHeight = getHeight(node.getLeftChild());
        int rHeight = getHeight(node.getRightChild());
        
        int lDiameter = findDiameter(node.getLeftChild());
        int rDiameter = findDiameter(node.getRightChild());
        
        int totalHeight = lHeight+rHeight+1;

        return Math.max(totalHeight, Math.max(lDiameter, rDiameter));
    }

    private int getHeight(Node node) {
        if(node == null){
            return 0;
        }
        int lHeight = getHeight(node.getLeftChild());
        int rHeight = getHeight(node.getRightChild());

        return Math.max(lHeight+1, rHeight+1);
    }
}
