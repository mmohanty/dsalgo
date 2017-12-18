package org.manas.dsalgo;


/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


public class TestClass {

    static int i ;
    static int j;
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
        */
        //BufferedReader
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Scanner scanner = new Scanner(System.in);
        String line1 = "1,2,3,4,5,6,10,8";//Elements
        String line2 = "1";//i
        String line3 = "1";//j

        i = Integer.parseInt(line2);
        j = Integer.parseInt(line3);

        String []tokens = line1.split(",");

        Integer []auxArray = new Integer[tokens.length];

        int auxIndex = 0;
        boolean isRetaining = true;

        for(int index = 0 ; index < tokens.length  ; ){

            auxIndex = retainElements(index, auxIndex, tokens, auxArray);
            index += i;
            index += j;
        }

        for(int i= 0 ; i < auxIndex ; i ++){

            System.out.print(auxArray[i]);
            if( i+1 != auxIndex){
                System.out.print(",");
            }
        }
    }

    private static int retainElements(int index, int auxIndex, String []tokens, Integer []auxArray){
        int aIndex = auxIndex;
        for(int in=0; in < i ; in++ ){
            if(index+in < tokens.length)
                auxArray[aIndex++] = Integer.parseInt(tokens[index+in]);
        }
        return aIndex;
    }

    class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }
        public void setNext(Node node){
            this.next = node;
        }
    }
}

