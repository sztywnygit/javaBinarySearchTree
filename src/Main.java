public class Main {
    public static void main(String[] args) {

        //demo usage
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addElement(10);
        binaryTree.addElement(12);
        binaryTree.addElement(13);
        binaryTree.addElement(7);
        binaryTree.addElement(6);
        binaryTree.addElement(9);
        binaryTree.addElement(4);
        binaryTree.addElement(3);
        binaryTree.addElement(5);

        binaryTree.deleteElement(10);


        binaryTree.printPathToElement(13);


    }
}
