package ok;

import java.util.Scanner;

public class ok {

	void preg5() {
		Scanner teclado = new Scanner(System.in);
		int a,b,c = 4;
		System.out.print("D numero");
		a= teclado.nextInt();
		System.out.println("d numero");
		b=teclado.nextInt();
		a++;
		--c;
		c=++a-b--;
		System.out.println(a +" "+b+" "+c);
	}
}
