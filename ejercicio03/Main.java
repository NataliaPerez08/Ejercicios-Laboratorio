/** 
 * Autor: Natalia Perez
 * Fecha: 10-11-2021
 * Version: 1.0
 * */
import java.io.IOException;
import java.util.Scanner;

public class Main{
	static int[] givenArray;
	/** Este metodo hace el trabajo
	 * k -> ExpectedOccurrences Las ocurrencias indicadas por v
	 * v -> number numero que se repite
	 * ooc -> Ocurrence
	 * La idea es recorrer el arreglo y contar las ocurrencias
	 * del numero con una variable occ, si occ == v regresar i
	 * (que es el iterador en el ciclo for usado para recorrer el arreglo)+1 porque
	 * se cuenta a partir de 1
	 * Si nunca pasa occ==v método regresa 0
	 * */
	public static int returnLocation(int k,int v){
		int occ=0;
		for(int i=0; i < givenArray.length; i++){
			if(givenArray[i] == v)
				++occ;
			if(occ == k)
				return i+1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			int l = scan.nextInt();
			arr[i]=l;
		}
		givenArray = arr;

		for(int j=1; j<= m; j++){
			int k = scan.nextInt();
			int v = scan.nextInt();
			int result = returnLocation(k,v);
			System.out.println(result);
		}
		scan.close();
	}
}
