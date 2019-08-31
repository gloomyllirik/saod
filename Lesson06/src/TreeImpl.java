import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;
    private int level;
    int leftMaxHeight;
    int rightMaxHeight;
    int maxHeight;
    private boolean recurse = false;


    @Override
    public boolean find(E value) {
        return doFind(value).node != null;
    }

    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);

        if (root == null) {
            this.root = node;
            this.level = 1;
            node.setCur_level(1);
            return true;
        }

        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.node != null) {
            return false;
        }

        Node<E> previous = nodeAndParent.parent;

        if (previous.shouldBeLeft(value)) {
            previous.setLeftChild(node);
        } else {
            previous.setRightChild(node);
        }

        if ((previous.getCur_level() + 1) > level){
            level++;
            node.setCur_level(level);
        } else {
            node.setCur_level(previous.getCur_level() + 1);
        }

        size++;
        return true;
    }

    //O(log N) -> O(N)
    private NodeAndParent doFind(E value) {
        Node<E> parent = null;
        Node<E> current = this.root;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent);
            }

            parent = current;

            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(null, parent);
    }

    private boolean findLevel(Node<E> node) {
        if (node.getCur_level() == level)
            return true;
        if (node.getRightChild() != null)
            findLevel(node.getRightChild());
        if (node.getLeftChild() != null)
            findLevel(node.getLeftChild());

        return false;
    }

    private int findMaxHeight(Node<E> node) {
        int max = 0;
        if (node != null) {
            max = node.getCur_level();
            if (node.getRightChild() != null)
                max = findMaxHeight(node.getRightChild());
            if (node.getLeftChild() != null)
                max = findMaxHeight(node.getLeftChild());
        }
        if (maxHeight < max)
            maxHeight = max;

        return max;
    }

    private void repLevel(Node<E> node, int level) {
        if (recurse) {
            node.setCur_level(level);
            System.out.println(node.getValue());
            System.out.println(node.getCur_level());
        }
        if (node.getLeftChild() != null) {
            recurse = true;
            repLevel(node.getLeftChild(), level + 1);
        }
        if (node.getRightChild() != null) {
            recurse = true;
            repLevel(node.getRightChild(), level + 1);
        }
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removedNode = nodeAndParent.node;
        Node<E> parent = nodeAndParent.parent;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()) {
            removeLeafNode(parent, removedNode);
        } else if (removedNode.hasOnlySingleChild()) {
            removeNodeWithSingleChild(parent, removedNode);
        } else {
            removeCommonNode(parent, removedNode);
        }

        if (findLevel(root))
            level--;

        size--;
        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }
        successor.setLeftChild(removedNode.getLeftChild());
        successor.setCur_level(removedNode.getCur_level());
        repLevel(successor, successor.getCur_level());
        recurse = false;
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> child = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();

        if (removedNode == root) {
            root = child;
            child.setCur_level(1);
        } else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(child);
            child.setCur_level(removedNode.getCur_level());
        } else {
            parent.setRightChild(child);
            child.setCur_level(removedNode.getCur_level());
        }
        repLevel(child, child.getCur_level());
        recurse = false;
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root) {
            root = null;
            level = 0;
        } else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        if (root.getLeftChild() != null) {
            maxHeight = 0;
            findMaxHeight(root.getLeftChild());
            leftMaxHeight = maxHeight;
        }
        if (root.getRightChild() != null) {
            maxHeight = 0;
            findMaxHeight(root.getRightChild());
            rightMaxHeight = maxHeight;
        }
        if (Math.abs(leftMaxHeight-rightMaxHeight) > 1)
            return false;
        else
            return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.println(node.getValue() + " " + node.getCur_level());
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getValue() + " " + node.getCur_level());
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeftChild());
        System.out.println(node.getValue() + " " + node.getCur_level());
        inOrder(node.getRightChild());
    }

    private class NodeAndParent {
        Node<E> node;
        Node<E> parent;

        public NodeAndParent(Node<E> node, Node<E> parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    @Override
    public int level() {
        return level;
    }
}
