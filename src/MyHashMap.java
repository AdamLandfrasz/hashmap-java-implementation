public class MyHashMap {
    private static class Node {
        private final int hash;
        private final Object key;
        private Object value;
        private Node next;

        private Node(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private static final int DEFAULT_INTERNAL_ARRAY_SIZE = 16;
    private Node[] internalArray;

    public MyHashMap() {
        internalArray = new Node[DEFAULT_INTERNAL_ARRAY_SIZE];
    }

    public MyHashMap(int initialCapacity) {
        this.internalArray = new Node[initialCapacity];
    }

    private Node findNode(Object key) {
        int hash = key == null ? 0 : key.hashCode();
        int bucketIndex = hash % internalArray.length;

        Node head = internalArray[bucketIndex];
        if (head == null) {
            return null;
        }

        while (head.getKey() != key && head.getNext() != null) {
            head = head.getNext();
        }

        if (head.getKey() != key) {
            return null;
        }

        return head;
    }

    public void put(Object key, Object value) {
        if (this.contains(key)) {
            Node node = this.findNode(key);
            if (node != null) {
                node.setValue(value);
            }
            return;
        }

        int hash = key == null ? 0 : key.hashCode();
        int bucketIndex = hash % internalArray.length;

        if (internalArray[bucketIndex] == null) {
            internalArray[bucketIndex] = new Node(hash, key, value);
            return;
        }

        Node head = internalArray[bucketIndex];
        while (head.getNext() != null) {
            head = head.getNext();
        }
        head.setNext(new Node(hash, key, value));
    }

    public Object get(Object key) {
        Node head = findNode(key);
        if (head == null) return null;
        return head.getValue();
    }

    public boolean contains(Object key) {
        Node head = this.findNode(key);
        return head != null;
    }

    public int size() {
        int count = 0;

        for (Node node : internalArray) {
            Node head = node;
            if (head != null) {
                count++;
                while (head.getNext() != null) {
                    count++;
                    head = head.getNext();
                }
            }
        }

        return count;
    }
}
