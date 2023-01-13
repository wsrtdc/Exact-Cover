import java.util.*;

public class AlgX {
	Map<Integer,Set<Integer>> rs=new TreeMap<>(),cs=new TreeMap<>();
	Set<Integer> s=new TreeSet<>();
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
	int minc() {
		int min=Integer.MAX_VALUE,c=-1,s;
		for (int i:cs.keySet()) if ((s=cs.get(i).size())<min) {min=s; c=i;}
		return c;
	}
	void solve() {
		if (cs.isEmpty()) System.out.println("Solution: "+s);
		else for (int y:cs.get(minc())) new AlgX(this,y).solve();
	}
}
