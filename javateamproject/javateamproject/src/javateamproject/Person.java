package javateamproject;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;


public class Person implements Comparable<Person> {
	public String ID;
	public double score;
	public Person(String ID, double score) {
		this.ID=ID;
		this.score=score;
	}
	public String toString() {return ID+","+score;}
	public int compareTo(Person p) {
		if(this.score>p.score) {
			return 1;
		}
		else if(this.score==p.score)
			return 0;
		else
			return -1;
	}
	
}
