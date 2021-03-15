package org.manas.design.cache;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> {

	private Map<K, V> map = new ConcurrentHashMap<>();
	private Queue<K> queue = new ConcurrentLinkedQueue<>();
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();
	
	private int maxSize;
	
	public LRUCache(int size){
		maxSize = size;
	}
	
	public V getElement(K key) {
		readLock.lock();
		try {
			if(map.containsKey(key)) {
				queue.remove(key);
				queue.add(key);
				return map.get(key);
			}
			return null;
		}finally {
			readLock.unlock();
		}
	}
	
	public V removeElement(K key) {
		writeLock.lock();
		try {
			if(map.containsKey(key)){
				queue.remove(key);
				return map.remove(key);
			}
			return null;
		}finally {
			writeLock.unlock();
		}
	}
	public void addElement(K key, V value) {
		writeLock.lock();
		try {
			if(map.containsKey(key)) {
				queue.remove(key);
			}
			while(queue.size() >= maxSize) {
				K queueKey = queue.poll();
				map.remove(queueKey);
			}
			queue.add(key);
			map.put(key, value);
		}finally {
			writeLock.unlock();
		}
	}
	
	
}
