package org.manas.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohanty on 06-08-2016.
 */
public class TestTreeConverter {

    private TreeConverter treeConverter;

    @Before
    public void init(){
        treeConverter = new TreeConverter();
    }

    @Test
    public  void testTreeCreationFromPostAndPreOrederTree(){

        int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
        Node node = treeConverter.convertTreeFromInorderAndPostOrderTree(in, post);

        System.out.print(node.getLeftNode());
;    }
}
