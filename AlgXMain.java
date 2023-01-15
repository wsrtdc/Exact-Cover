import java.util.*;
import java.util.function.*;

public class AlgXMain{
	public static void main(String[] args){
		int[][][] tests= new int[][][] {
			{ {0,0,1},
				{0,1,1},
				{1,0,1},
				{1,1,0}
			},
			{ {0,0,1,0,1,1,0},
				{1,0,0,1,0,0,1},
				{0,1,1,0,0,1,0},
				{1,0,0,1,0,0,0},
				{0,1,0,0,0,0,1},
				{0,0,0,1,1,0,1}
			},
			{ {1,0,0,1,0,0,1},
				{1,0,0,1,0,0,0},
				{0,0,0,1,1,0,1},
				{0,0,1,0,1,1,0},
				{0,1,1,0,0,1,1},
				{0,1,0,0,0,0,1}
			},
			{ {1,1,1},
				{0,0,0},
				{1,1,1}
			},
			{ {1,1,1,0,1,0},
				{1,1,0,0,0,0},
				{0,0,0,1,0,1},
				{0,0,1,1,0,1},
				{0,0,1,0,1,0}
			}
		};
		AlgX.c=new Consumer<>() {
			public void accept(Set<Integer> s) {
				System.out.println("Solution: "+s);
			}
		};
		for (int[][] m:tests) {
			for (int[] r:m) {for (int c:r) System.out.print(c); System.out.println();}
			new AlgX(m).solve();
			System.out.println();
		}
		
		// A Sudoku puzzle as exact cover
		String su="000000010400000000020000000000050407008000300001090000300400200050100000000806000";
		int M=3,N=M*M;
		int[][] a=new int[N*N*N][N*N*4];
		for (int r=0;r<a.length;r++) for (int c=0;c<a[r].length;c++) {
			if (c==0*N*N+r/N
			||	c==1*N*N+r/(N*N)*N+r%N
			||	c==2*N*N+r%(N*N)
			||	c==3*N*N+(r/(N*M)*N)%(N*M)+r/(N*N*M)*N*M+r%N) a[r][c]=1;
		}
		AlgX.c=new Consumer<>() {
			public void accept(Set<Integer> s) {
				char[] c=new char[N*N]; 
				for(int r:s) {int u=r/N; c[u]=(char)('1'+r%N);}
				System.out.println(su);System.out.println(c);
			};
		};
		AlgX algx=new AlgX(a);
		for(int i=0;i<N*N;i++) {
			char ch=su.charAt(i);
			if(ch>'0') algx=new AlgX(algx,i*N+ch-'1');
		}
		long t=System.nanoTime();
		algx.solve();
		System.out.println("time="+(System.nanoTime()-t)+" ns");
	}
}