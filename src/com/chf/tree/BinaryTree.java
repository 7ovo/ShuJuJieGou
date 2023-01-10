package com.chf.tree;

import com.chf.linear.Queue;

public class BinaryTree<K extends Comparable<K>, V> {
    private Node root;
    private int N;

    /**
     * 内部私有节点类
     */
    private class Node {
        public K key;//键
        public V value;//值
        public Node left;//左子树
        public Node right;//右子树

        public Node(K key, V value, BinaryTree<K, V>.Node left, BinaryTree<K, V>.Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return this.N;
    }

    /**
     * 向树中插入元素
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        this.root = this.put(this.root, key, value);
    }

    /**
     * 向树中插入元素
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, K key, V value) {
        if (node == null) {
            ++this.N;
            return new Node(key, value, null,null);
        } else {
            int i = key.compareTo(node.key);
            if (i > 0) {
                node.right = this.put(node.right, key, value);
            } else if (i < 0) {
                node.left = this.put(node.left, key, value);
            } else {
                node.value = value;
            }
            return node;
        }
    }

    /**
     * 根据键获取树中的元素的值
     * @param key
     * @return
     */
    public V get(K key) {
        return this.get(this.root, key);
    }

    /**
     * 根据键获取树中的元素的值
     * @param node
     * @param key
     * @return
     */
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        } else {
            int i = key.compareTo(node.key);
            if (i > 0) {
                return this.get(node.right, key);
            } else if(i < 0){
                return this.get(node.left, key);
            } else {
                return node.value;
            }
        }
    }

    /**
     * 根据键删除树中对应元素
     * @param key
     */
    public void delete(K key) {
        this.delete(this.root, key);
    }

    /**
     * 根据键删除树中对应元素
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        } else {
            int i = key.compareTo(node.key);
            if (i > 0) {
                node.right = this.delete(node.right, key);
            } else if (i < 0) {
                node.left = this.delete(node.left, key);
            } else {
                --this.N;
                if (node.right == null) return node.left;
                if (node.left == null) return node.right;

                Node minNode = node.right;
                while (minNode.left != null){
                    minNode = minNode.left;
                }
                //删除右子树中最小的节点
                Node n = node.right;
                while(n.left != null) {
                    if (n.left.left == null) {
                        n.left = null;
                    } else {
                        n = n.left;
                    }
                }
                //让node节点的左子树成为minNode节点的左子树
                minNode.left = node.left;
                //让node节点的右子树成为minNode节点的右子树
                minNode.right = node.right;
                //让node节点的父节点指向minNode节点
                node = minNode;
            }
            return node;
        }
    }

    /**
     * 获取树中最小的元素值
     * @return
     */
    public K min() {
        return this.min(this.root).key;
    }

    /**
     * 获取指定树中最小的元素
     * @param node
     * @return 返回元素
     */
    private Node min(Node node) {
        if (node == null) {
            return null;
        } else {
            return node.left != null ? this.min(node.left) : node;
        }
    }

    /**
     * 获取树中最大的元素值
     * @return
     */
    public K max() {
        return this.max(this.root).key;
    }

    /**
     * 获取指定树中最大的元素
     * @param node
     * @return 返回元素
     */
    private Node max(Node node) {
        if (node == null) {
            return null;
        } else {
            return node.right != null ? this.max(node.right) : node;
        }
    }

    /**
     * 前序遍历
     * @return
     */
    public Queue<K> preErgodic() {
        Queue<K> queue = new Queue();
        this.preErgodic(this.root, queue);
        return queue;
    }

    /**
     * 前序遍历
     * @param node
     * @param keys
     */
    private void preErgodic(Node node, Queue<K> keys) {
        if(node == null) return;
        keys.enqueue(node.key);
        if (node.left != null) this.preErgodic(node.left, keys);
        if (node.right != null) this.preErgodic(node.right, keys);
    }

    /**
     * 中序遍历
     * @return
     */
    public Queue<K> midErgodic() {
        Queue<K> queue = new Queue();
        this.midErgodic(this.root, queue);
        return queue;
    }

    /**
     * 中序遍历
     * @param node
     * @param keys
     */
    private void midErgodic(Node node, Queue<K> keys) {
        if(node == null) return;
        if (node.left != null) this.preErgodic(node.left, keys);
        keys.enqueue(node.key);
        if (node.right != null) this.preErgodic(node.right, keys);
    }

    /**
     * 后序遍历
     * @return
     */
    public Queue<K> afterErgodic() {
        Queue<K> queue = new Queue();
        this.afterErgodic(this.root, queue);
        return queue;
    }

    /**
     * 后序遍历
     * @param node
     * @param keys
     */
    private void afterErgodic(Node node, Queue<K> keys) {
        if(node == null) return;
        if (node.left != null) this.preErgodic(node.left, keys);
        if (node.right != null) this.preErgodic(node.right, keys);
        keys.enqueue(node.key);
    }

    /**
     * 层序遍历
     * @return
     */
    public Queue<K> layerErgodic() {
        Queue<K> keys = new Queue();//存储树中所有的节点的值
        Queue<Node> nodes = new Queue();//存储树中所有节点
        nodes.enqueue(this.root);//默认将根节点放入
        while(!nodes.isEmpty()) {
            Node n = nodes.dequeue();//取出当前节点
            keys.enqueue(n.key);//将当前节点的值放入keys队列中
            //根据当前节点去放入其左右子树值
            if (n.left != null) nodes.enqueue(n.left);
            if (n.right != null) nodes.enqueue(n.right);
        }
        return keys;
    }

    /**
     * 获取整个树的最大深度
     * @return
     */
    public int maxDepth(){
        return maxDepth(this.root);
    }

    /**
     * 获取指定树的最大深度
     * @param node
     * @return
     */
    private int maxDepth(Node node){
        if(node == null) return 0;
        //计算根结点的左子树最大深度
        int maxLeft = 0;
        if(node.left != null) maxLeft = maxDepth(node.left);
        //计算根结点的右子树最大深度
        int maxRight = 0;
        if(node.right != null) maxRight = maxDepth(node.right);
        //比较即可
        return maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;
    }
}
