package leetcode;

import java.util.HashMap;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/public class LRUCache {
	public class LRUcache {
	    private int capacity;
	    private int len;
	    doubleLinkNode head;
	    doubleLinkNode end;
	    private HashMap<Integer, doubleLinkNode> map = new HashMap<Integer, doubleLinkNode>();
	    
	    public LRUcache(int capacity) {
	        this.capacity = capacity;
	        this.len = 0;
	    }
	    
	    public int get(int key) {
	        if (map.containsKey(key)) {
	            remove(map.get(key));
	            setHead(map.get(key));
	            return map.get(key).value;
	        }
	        else {
	            return -1;
	        }
	    }
	    
	    public void set(int key, int value) {
	        if (map.containsKey(key)) {
	            map.get(key).value = value;
	            remove(map.get(key));
	            setHead(map.get(key));
	        }
	        else {
	            if (len < capacity) {
	                doubleLinkNode node = new doubleLinkNode(key, value);
	                map.put(key, node);
	                setHead (node);
	                len++;
	            }
	            else {
	                 doubleLinkNode node = new doubleLinkNode(key, value);
	                 map.put(key, node);
	                 map.remove(end.key);
	                 end = end.pre;
	                 if (end != null) {
	                     end.post = null;
	                 }
	                 setHead (node);
	            }
	        }
	    }
	    
	    public void remove(doubleLinkNode node) {
	        doubleLinkNode pre = node.pre;
	        doubleLinkNode next = node.post;
	        
	        if (pre != null) {
	            pre.post = next;
	        }
	        else {
	            head = next;
	        }
	        
	        if (next != null) {
	            next.pre = pre;
	        }
	        else {
	            end = pre;
	        }
	    }
	    
	    public void setHead(doubleLinkNode node) {
	        node.post = head;
	        node.pre = null;
	        if (head != null) {
	            head.pre = node;
	        }
	        head = node;
	        if (end == null) {
	            end = node;
	        }

	    }
	}

	class doubleLinkNode {
	    public int key;
	    public int value;
	    public doubleLinkNode pre;
	    public doubleLinkNode post;
	    
	    public doubleLinkNode(int key, int value) {
	        this.key = key;
	        this.value = value;
	    }
	}
}
