import java.util.*;
import java.util.function.*;

public class AlgX {
	Map<Integer,Set<Integer>> rs=new TreeMap<>(),cs=new TreeMap<>();
	Set<Integer> s=new TreeSet<>();
	static Consumer<Set<Integer>> c;
	
	AlgX(int[][] a) {
		for (int y=0;y<a.length;y++) for (int x=0;x<a[y].length;x++) if (a[y][x]!=0) {
			cs.computeIfAbsent(x,i->new HashSet<>()).add(y);
			rs.computeIfAbsent(y,i->new HashSet<>()).add(x);
		}
	}
	AlgX(AlgX a,int y){
		for (int i:a.rs.keySet()) rs.put(i,new HashSet<>(a.rs.get(i)));
		for (int i:a.cs.keySet()) cs.put(i,new HashSet<>(a.cs.get(i)));
		s.addAll(a.s); s.add(y); Set<Integer> r=new HashSet<>();
		for (int c:rs.get(y)) {r.addAll(cs.get(c)); cs.remove(c);}
		rs.keySet().removeAll(r); for (Set<Integer> c:cs.values()) c.removeAll(r);
	}
	void solve() {
		if (cs.isEmpty()) c.accept(s); else
		for (int y:Collections.min(cs.values(),new Comparator<Set<?>>() {
			public int compare(Set<?> o1,Set<?> o2){return Integer.compare(o1.size(),o2.size());}
		})) new AlgX(this,y).solve();
	}
}