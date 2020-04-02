package ej2;

public class Prueba_Matriz1 {

	public static void main(String[] args) {
		Matriz1 m1 = new Matriz1(3,3);
		
		m1.cargarPorFilas();
		m1.ver();
		
		System.out.println();
		
		m1.cargarPorColumnas();
		m1.ver();
		
		System.out.println();
		
		System.out.println("Intercambia de fila: "+m1.intercambiarFilas(1, 3));
		m1.ver();
		
		System.out.println();
		
		System.out.println("Intercambia de columna: "+m1.intercambiarColumnas(1,2));
		m1.ver();
		
		int[] negativos = m1.negativos();
		
		System.out.println("negativos:");
		for (int i = 0; i < negativos.length; i++) {
			System.out.print(negativos[i]+"\t");
		}
		System.out.println();
		
		Matriz1 m2 = new Matriz1(3,3);
		Matriz1 m3 = new Matriz1(2,3);
		Matriz1 m4 = new Matriz1(3,4);
		Matriz1 m5 = new Matriz1(1,3);
		
		Matriz1[] matriz2 = {m2,m3,m4,m5};
		
		for (int i = 0; i < matriz2.length; i++) {
			matriz2[i].cargarPorFilas();
			matriz2[i].ver();
		}
		
		for (int i = 0; i < matriz2.length; i++) {
			if (matriz2[i].getArrayBi()[0].length>=5) {
				matriz2[i].invertirFilas();
				matriz2[i].ver();
			}
		}
		
		
	}

}
