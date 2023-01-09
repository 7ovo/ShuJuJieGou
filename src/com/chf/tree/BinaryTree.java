package com.chf.tree;

import com.chf.linear.Queue;

public class BinaryTree<K extends Comparable<K>, V> {
    private BinaryTree<K, V>.Node root;
    private int N;

    public int size() {
        return this.N;
    }

    public void put(K key, V value) {
        this.root = this.put(this.root, key, value);
    }

    public BinaryTree<K, V>.Node put(BinaryTree<K, V>.Node node, K key, V value) {
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

    public V get(K key) {
        return this.get(this.root, key);
    }

    public V get(BinaryTree<K, V>.Node node, K key) {
        if (node == null) {
            return null;
        } else {
            int i = key.compareTo(node.key);
            if (i > 0) {
                return this.get(node.right, key);
            } else {
                return i < 0 ? this.get(node.left, key) : node.value;
            }
        }
    }

    public void delete(K key) {
        this.delete(this.root, key);
    }

    public BinaryTree<K, V>.Node delete(BinaryTree<K, V>.Node node, K key) {
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
                if (node.right == null) {
                    return node.left;
                }

                if (node.left == null) {
                    return node.right;
                }

                BinaryTree.Node minNode;
                for(minNode = node.right; minNode.left != null; minNode = minNode.left) {
                }

                BinaryTree.Node n = node.right;

                while(n.left != null) {
                    if (n.left.left == null) {
                        n.left = null;
                    } else {
                        n = n.left;
                    }
                }

                minNode.left = node.left;
                minNode.right = node.right;
                node = minNode;
            }

            return node;
        }
    }

    public K min() {
        return this.min(this.root).key;
    }

    public BinaryTree<K, V>.Node min(BinaryTree<K, V>.Node node) {
        if (node == null) {
            return null;
        } else {
            return node.left != null ? this.min(node.left) : node;
        }
    }

    public K max() {
        return this.max(this.root).key;
    }

    public BinaryTree<K, V>.Node max(BinaryTree<K, V>.Node node) {
        if (node == null) {
            return null;
        } else {
            return node.right != null ? this.max(node.right) : node;
        }
    }

    public Queue<K> preErgodic() {
        Queue<K> queue = new Queue();
        this.preErgodic(this.root, queue);
        return queue;
    }

    public void preErgodic(BinaryTree<K, V>.Node node, Queue<K> keys) {
        if (node != null) {
            keys.enqueue(node.key);
            if (node.left != null) {
                this.preErgodic(node.left, keys);
            }

            if (node.right != null) {
                this.preErgodic(node.right, keys);
            }

        }
    }

    public Queue<K> midErgodic() {
        Queue<K> queue = new Queue();
        this.midErgodic(this.root, queue);
        return queue;
    }

    public void midErgodic(BinaryTree<K, V>.Node node, Queue<K> keys) {
        if (node != null) {
            if (node.left != null) {
                this.midErgodic(node.left, keys);
            }

            keys.enqueue(node.key);
            if (node.right != null) {
                this.midErgodic(node.right, keys);
            }

        }
    }

    public Queue<K> afterErgodic() {
        Queue<K> queue = new Queue();
        this.afterErgodic(this.root, queue);
        return queue;
    }

    public void afterErgodic(BinaryTree<K, V>.Node node, Queue<K> keys) {
        if (node != null) {
            if (node.left != null) {
                this.afterErgodic(node.left, keys);
            }

            if (node.right != null) {
                this.afterErgodic(node.right, keys);
            }

            keys.enqueue(node.key);
        }
    }

    public Queue<K> layerErgodic() {
        Queue<K> keys = new Queue();
        Queue<BinaryTree<K, V>.Node> nodes = new Queue();
        nodes.enqueue(this.root);

        while(!nodes.isEmpty()) {
            BinaryTree<K, V>.Node n = (BinaryTree.Node)nodes.dequeue();
            keys.enqueue(n.key);
            if (n.left != null) {
                nodes.enqueue(n.left);
            }

            if (n.right != null) {
                nodes.enqueue(n.right);
            }
        }

        return keys;
    }

    private class Node {
        public K key;
        public V value;
        public BinaryTree<K, V>.Node left;
        public BinaryTree<K, V>.Node right;

        public Node(K key, V value, BinaryTree<K, V>.Node left, BinaryTree<K, V>.Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
