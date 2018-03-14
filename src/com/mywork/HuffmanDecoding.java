package com.mywork;

/**
 * @author ManiKanta Kandagatla
 */

class CharNode
{
    char value;

    CharNode left;

    CharNode right;

    public CharNode(char value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class HuffmanDecoding
{

    public static void main(String[] args)
    {
        HuffmanDecoding decodeObj = new HuffmanDecoding();
        decodeObj.testHuffmanDecoding();
    }

    /**
     * Given Huffman code of followling format "char1: code1, char2: code2..." Insert these codes
     * into huffman tree
     * 
     * @param huffmancode
     * @return
     */
    public CharNode constructHuffmanTree(String huffmancode)
    {
        String[] codes = huffmancode.split(",");
        CharNode root = new CharNode('D');
        for (String code : codes)
        {
            CharNode temp = root;
            String[] keyValue = code.split(": ");
            for (int index = 0; index < keyValue[1].length(); index++)
            {
                if (keyValue[1].charAt(index) == '0')
                {
                    // Non-Overlapping node
                    if (temp.left == null)
                    {
                        temp.left = new CharNode('0');
                    }
                    temp = temp.left;
                }
                else
                {
                    // Non-overlapping node
                    if (temp.right == null)
                    {
                        temp.right = new CharNode('1');
                    }
                    temp = temp.right;
                }
            }
            temp.left = new CharNode(keyValue[0].charAt(0));
        }
        return root;
    }

    /**
     * Print Huffman Tree in inorder Traversal
     * 
     * @param root
     */
    public void printHuffmanTree(CharNode root)
    {
        if (root != null)
        {
            printHuffmanTree(root.left);
            System.out.print("" + root.value + ", ");
            printHuffmanTree(root.right);
        }
    }

    /**
     * Traverse the huffman tree and print the decoded string character by character
     * 
     * @param huffmannTree
     * @param decodedString
     */
    public void printDecodedString(CharNode huffmannTree, String decodedString)
    {
        CharNode temp = huffmannTree;
        System.out.print("Decoded String: ");
        for (int index = 0; index < decodedString.length(); index++)
        {
            if (decodedString.charAt(index) == '0')
            {
                temp = temp.left;
            }
            else if (decodedString.charAt(index) == '1')
            {
                temp = temp.right;
            }
            if (temp.left.value != '0' && temp.left.value != '1')
            {
                System.out.print(temp.left.value);
                temp = huffmannTree;
            }
        }
    }

    public void testHuffmanDecoding()
    {
        String[] codes = {
                "e: 000,i: 001000,b: 001001,f: 00101,a: 0011,c: 01,h: 100,g: 101,d: 11" };
        String[] decodedStrings = { "0000010000010010010100110110010111", "10010010111000" };
        for (int index = 0; index < codes.length; index++)
        {
            CharNode huffmanTree = constructHuffmanTree(codes[index]);
            // printHuffmanTree(huffmanTree);
            for (int i = 0; i < decodedStrings.length; i++)
            {
                printDecodedString(huffmanTree, decodedStrings[i]);
                System.out.println("");
            }

        }
    }
}
