package Algorithm.shu;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-04 00:37
 */
public class CreateTree {

    public Node createTree(long [] arr){

        Node c,pa = null;
        Node root = new Node(arr[0]);
        root.leftChild = null;
        root.rightChild = null;

        for (int i = 1; i < arr.length; i++) {

            Node p = new Node(arr[i]);
            p.leftChild = null;
            p.rightChild = null;
            c = root;
            while (c != null){
                pa = c;
                if (c.data > p.data){
                    c = c.leftChild;
                } else {
                    c = c.rightChild;
                }
            }

            if (pa.data > p.data){
                pa.leftChild = p;
            } else {
                pa.rightChild = p;
            }
        }
        return root;
    }

    /**
     * 前序遍历
     * @param node
     */
    public void FirstOrder (Node node){
        if (node != null){
            System.out.println(node.data);
            FirstOrder(node.leftChild);
            FirstOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历
     */
    public void IOrder(Node node){
        if (node != null){
            IOrder(node.leftChild);
            System.out.println(node.data);
            IOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历
     */
    public void lastOrder(Node node){
        if (node != null){
            lastOrder(node.leftChild);
            lastOrder(node.rightChild);
            System.out.println(node.data);
        }
    }

    /**
     * 插入节点
     */
    public void insert(long value, Node root){
        // 封装节点
        Node newNode = new Node(value);
        Node current = root;
        Node parent;
        while (true){
            parent = current;
            if (value < current.data){
                current = current.leftChild;
                if (current == null){
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null){
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    /**
     * 查找节点
     */
    public Node find(long value, Node root){
        Node current = root;
        while (current.data != value){
            if (current.data > value){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    /**
     * 查找节点
     */
    public Node find1(long value, Node root){
        if (root == null){
            return null;
        }
        if (root.data == value){
            return root;
        }
        Node p = find1(value, root.leftChild);
        if (p != null){
            return p;
        }
        return find1(value, root.rightChild);
    }

    /**
     * 删除节点，首先找到要删除的节点，找到之后有三种情况需要考虑
     * 1、该节点是叶子节点，直接将它的父节点的引用设为 null
     * 2、该节点是有一个子节点，有四种情况需要考虑，总之改变父节点的引用，将其直接指向当前节点的子节点
     * 3、该节点有两个子节点，使用该节点的中序后继节点替代当前节点（中序后继节点：比该节点的数据大的所有数据里面最小的一个）
     */
    public boolean delete (long value, Node root){

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.data != value){
            parent = current;
            if (current.data > value){
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
        }

        if (current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;
            } else if (isLeftChild){
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null){
            if (current == root){
                root = current.leftChild;
            } else if (isLeftChild){
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null){
            if (current == root){
                root = current.rightChild;
            } else if (isLeftChild){
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            } else if (isLeftChild){
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor (Node delNode){
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.rightChild;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
