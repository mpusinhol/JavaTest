import java.util.Random;

public class BinaryTree {
    private int value;
    private BinaryTree left;
    private BinaryTree right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        setValue(value);
        setLeft(left);
        setRight(right);
    }

    public BinaryTree(int value) {
        this(value, null, null);
    }

    /**
     * A method to insert a new node on the left or right of the current node.
     * @param node The new node to be inserted
     * @param left The direction the new node is to be inserted
     */
    public void insert(BinaryTree node, boolean left) {
        if (left) {
            setLeft(node);
        } else {
            setRight(node);
        }
    }

    /**
     * A function to sum the value of the whole tree starting on the current node
     * @return The sum of the whole tree
     */
    public int sumTree() {
        int sum = getValue();

        BinaryTree left = getLeft(),
                right = getRight();

        if (left != null) {
            sum += left.sumTree();
        }

        if (right != null) {
            sum += right.sumTree();
        }

        return sum;
    }

    /**
     * A static function to sum a binary tree starting from the node passed as parameter
     * @param node The root node to sum the tree
     * @return The summed value of the whole tree
     * @throws Exception if the root node is null
     */
    public static int sumTree(BinaryTree node) throws Exception {
        if (node != null) {
            return node.sumTree();
        } else {
            throw new Exception("Node cannot be null in order to be summed.");
        }
    }

    /**
     * A static function to generate a random tree with values from 1 to 10.
     * The function is limited to have only one node per level as it was only created for testing purposes and not requested by the test.
     * The commented lines can be uncommented in order to see what the values of the tree are.
     * @param height The height of the tree that is to be generated
     * @return The root node of the created tree
     * @throws Exception if the height is lower than 0, as the minimum height a tree may have is 0
     */
    public static BinaryTree generateRandomTree(int height) throws Exception{
        if (height >= 0) {
            Random random = new Random();

            BinaryTree root = new BinaryTree(random.nextInt(10) + 1);
            BinaryTree aux = root;

//           System.out.println(root.getValue());

            while (height-- > 0) {
                BinaryTree node = new BinaryTree(random.nextInt(10) + 1);
                boolean left = random.nextInt(2) == 0 ? true : false;

                aux.insert(node, left);
                aux = left ? aux.getLeft() : aux.getRight();

//                System.out.println(node.getValue());
            }

            return root;
        } else {
            throw new Exception("A tree cannot have a height lower than 0");
        }
    }
}
