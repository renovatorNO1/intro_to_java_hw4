package hw4;

public class R7Q3 {
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("This is sub-problem a");
		for (int i=1;i<10;i++) {
			a[i] = a[i-1];
			System.out.print(a[i]+", ");
		}
		int[] b = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("\nThis is sub-problem b");
		for (int i = 9; i > 0; i--) { b[i] = b[i - 1];}
		for (int i =0; i<10; i++) {System.out.print(b[i]+", ");}
		
		int[] c = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("\nThis is sub-problem c");
		for (int i = 0; i < 9; i++) { c[i] = c[i + 1];}
		for (int i =0; i<10; i++) {System.out.print(c[i]+", ");}
		
		int[] d = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("\nThis is sub-problem d");
		for (int i = 8; i >= 0; i--) { d[i] = d[i + 1];}
		for (int i =0; i<10; i++) {System.out.print(d[i]+", ");}
		
		int[] e = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("\nThis is sub-problem e");
		for (int i = 1; i < 10; i++) {e[i] = e[i] + e[i - 1];}
		for (int i =0; i<10; i++) {System.out.print(e[i]+", ");}
		
		int[] f = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("\nThis is sub-problem f");
		for (int i = 1; i < 10; i = i + 2) { f[i] = 0;}
		for (int i =0; i<10; i++) {System.out.print(f[i]+", ");}
		
		int[] g = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("\nThis is sub-problem g");
		for (int i = 0; i < 5; i++) { g[i + 5] = g[i]; }
		for (int i =0; i<10; i++) {System.out.print(g[i]+", ");}
		
		int[] h = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		System.out.println("\nThis is sub-problem h");
		for (int i = 1; i < 5; i++) { h[i] = h[9 - i];}
		for (int i =0; i<10; i++) {System.out.print(h[i]+", ");}
		
		
		
	}
}
