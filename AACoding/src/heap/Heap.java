package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {
  public List<T> list;
  public boolean isMin;
  
  public Heap() {
	  this(false);
  }
  public Heap(boolean isMin) {
	  list = new ArrayList<T>();
	  this.isMin = isMin;
  }
  
  public T getHeap() {
	  return this.list.get(0);
  }
  
  public void display(int index) {
	  int lci = 2*index+1;
	  int rci = lci+1;
	  if(lci < this.list.size()) {
		  System.out.print(this.list.get(lci) + " => ");
	  } else {
		  System.out.print("END => ");
	  }
	  System.out.print(this.list.get(index) + " ");
	  if(rci < this.list.size()) {
		  System.out.print("<= " + this.list.get(rci));
	  } else {
		  System.out.print("<= END");
	  }
	  System.out.println();
	  if(lci < this.list.size())
		  this.display(lci);
	  if(rci < this.list.size())
		  this.display(rci);
  }
  
  public boolean satisfyHeapify(int i, int j) {
	  T ith = this.list.get(i);
	  T jth = this.list.get(j);
	  if(this.isMin)
		  return jth.compareTo(ith) < 0;
	  else
		  return jth.compareTo(ith) > 0;
  }
  
  public void swap(int i, int j) {
	  T ith = this.list.get(i);
	  T jth = this.list.get(j);
	  this.list.set(i, jth);
	  this.list.set(j, ith);
  }
  
  public void add(T item) {
	  this.list.add(item);
	  this.upHeapify(this.list.size()-1);
  }
  
  public void upHeapify(int childIndex) {
	  if(childIndex == 0)
		  return;
	  int parentIndex = (childIndex - 1) / 2;
	  if(this.satisfyHeapify(parentIndex, childIndex)) {
	     this.swap(parentIndex, childIndex);
	     this.upHeapify(parentIndex);
	  }
  }
  
  public T remove() {
	  T removed = this.list.get(0);
	  T last = this.list.get(this.list.size() - 1);
	  this.list.set(0, last);  // Set the last.
	  this.list.remove(this.list.size() - 1);  // Remove the last from the list.
	  this.downHeapify(0);
	  return removed;
  }

  public void downHeapify(int parentIndex) {
	  int lci = 2*parentIndex+1;
	  int rci = lci+1;
	  int myIndex = parentIndex;  // Parent is trying to search for it's correct index.
	  if(lci < this.list.size() && this.satisfyHeapify(myIndex, lci)) 
		  myIndex = lci;
	  if(rci < this.list.size() && this.satisfyHeapify(myIndex, rci))
		  myIndex = rci;
	  if(myIndex != parentIndex) {  // Parent has found a new index.
		  this.swap(myIndex, parentIndex);
		  this.downHeapify(myIndex);  // Go on from this new index.
	  }
  }  
  
  public static void main(String[] args) {
	  Heap<Integer> heap = new Heap<Integer>(true);  // Constructing a min heap.
	  heap.add(new Integer(39));
	  heap.add(new Integer(50));
	  heap.add(new Integer(55));
	  heap.add(new Integer(11));
	  heap.add(new Integer(9));
	  heap.display(0);
	  System.out.println("Removing from heap:");
	  heap.remove();
	  heap.display(0);
  }
}
