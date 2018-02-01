package com.test.iterator;

public class CustomIterator {
	public static void main(String[] args) {
		MyIteratorList<String> m =new MyIteratorList<>(5);
		for (int i = 0; i < 5; i++) {
			m.add("string" + (i + 1));
		}
		
		Iterator<String> iterator = m.iterator();
		while(iterator.hasNext()){
			String current = iterator.current();
			System.out.println(current);
			iterator.next();
		}
	}
}

interface Iterator<E> {
	void next();
	boolean hasNext();
	E current();
}

class MyIteratorList<T> {
	private Object[] o;
	private int current = 0;
	public MyIteratorList(int size) {
		o = new Object[size];
	}
	
	public void add(T obj){
		if(current < o.length){
			o[current] = obj;
			current++;
		}
	}
	
	public int size(){
		return o.length;
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	class MyIterator implements Iterator<T> {

		private int count = 0;
		
		@Override
		public void next() {
			if(count < o.length){
				count++;
			}
		}

		@Override
		public boolean hasNext() {
			return count < o.length;
		}

		@Override
		@SuppressWarnings("unchecked")
		public T current() {
			return (T) o[count];
		}
		
	}
}