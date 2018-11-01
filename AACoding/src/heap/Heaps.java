package heap;

import java.util.ArrayList;

public class Heaps<T extends Comparable<T>>{
   // Data field.
   private ArrayList<T> list;
   private boolean isMin;
   // Constructor.
   public Heaps() {
	   this(false);
   }
   public Heaps(boolean isMin) {
	   this.list = new ArrayList<>();
	   this.isMin = isMin;
   }
   public int size() {
	   return this.list.size();
   }
   public boolean isEmpty() {
	   return (this.list.size() == 0);
   }
   public T getHP() {	   
	   return this.list.get(0);	   
   }
   public void add(T value) {
	   this.list.add(value);
	   upHeapify(this.list.size()-1);
   }
   private void upHeapify(int ci) {
	   if(ci == 0)
		   return;
	   int pi = (ci-1)/2;
	   if(!isLarger(pi,ci)) {
		   swap(pi,ci);
		   upHeapify(pi);
	   }
   }
   public T remove() {
	   T removed = this.list.get(0);
	   T last = this.list.get(this.list.size()-1);
	   this.list.set(0, last);
	   this.list.remove(this.list.size()-1);
	   downHeapify(0);
	   return removed;
   }
   private void downHeapify(int pi) {	   
	   int lci = 2*pi+1;
	   int rci = 2*pi+2;
	   int mi = pi;
	   if(lci < this.list.size() && isLarger(lci, mi)) {
		   mi = lci;
	   }
	   if(rci < this.list.size() && isLarger(rci, mi)) {
		   mi = rci;
	   }
	   if(mi != pi) {
		   swap(mi, pi);
		   this.downHeapify(mi);
	   }
   }
   
   public void display() {
	   this.display(0);
   }
   private void display(int index) {
	   int lci = 2*index+1;
	   int rci = 2*index+2;
	   String str = "";
	   if(lci < this.list.size()) 
		   str += (this.list.get(lci) + "=>"); 
	   else
		   str += "END=>";
	   str += this.list.get(index);
	   if(rci < this.list.size()) 
		   str += ("<=" + this.list.get(rci)); 
	   else
		   str += "<=END";
	   System.out.println(str);
	   if(lci < this.list.size()) 
		   display(lci);
	   if(rci < this.list.size()) 
	       display(rci);
   }
   private boolean isLarger(int i, int j) {
	   T ith = this.list.get(i);
	   T jth = this.list.get(j);
	   if(isMin) 
		   return (ith.compareTo(jth) < 0);
	   else
		   return (ith.compareTo(jth) > 0);
   }
   private void swap(int i, int j) {
	   T ith = this.list.get(i);
	   T jth = this.list.get(j);
	   this.list.set(i, jth);
	   this.list.set(j, ith);
   }	
   
   
   
	
}  // End of class.
