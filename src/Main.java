import Utils.NumberUtils;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    //Set firstNumber and secondNumber according to the test desired
    public static void questionEight() {
        Integer firstNumber = 10250,
                secondNumber = 512;

        System.out.println("Question 8:");

        try {
            System.out.println(NumberUtils.mixNumbers(firstNumber, secondNumber));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //BinaryTree.generateRandomTree(5) is used to generate the tree, however it can be replaced
    public static void questionNine() {
        try {
            System.out.println("\nQuestion nine:");

            BinaryTree tree = BinaryTree.generateRandomTree(5);
            System.out.println(BinaryTree.sumTree(tree));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        questionEight();
        questionNine();
    }
}
