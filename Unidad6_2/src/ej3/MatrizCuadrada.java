package ej3;

import ej1.Consola;

public class MatrizCuadrada {
	int[][] matriz;

	public MatrizCuadrada(int nFilas, int nColumnas) {
		matriz = new int[nFilas][nColumnas];
	}

	public void ver() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void cargar() {
		int valor;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				do {
					System.out.println("Introduce un valor:");
					System.out.println("Fila : " + i);
					System.out.println("Columna : " + j);
					System.out.println("Introduce un valor:");
					valor = Consola.leeInt();
					matriz[i][j] = valor;
				} while (repetido(valor, i, matriz));
			}
		}
	}

	public static boolean repetido(int valor, int filas, int[][] matriz) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == valor) {
					return true;
				}
			}
		}
		return false;
	}

	public void cargarIdetidad() {
		if (matriz.length != matriz[0].length) {
			System.out.println("las columnas y las filas deben tener el mismo tamaño");
		} else {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (j == i) {
						matriz[i][j] = 1;
					} else {
						matriz[i][j] = 0;
					}
				}
			}
		}
	}

	public int determinate() {
		if((matriz.length!=3)&&(matriz[0].length!=3)) {
			return -1;
		}else {
			int a = matriz[0][0];
			int b = matriz[0][1];
			int c = matriz[0][2];
			int d = matriz[1][0];
			int e = matriz[1][1];
			int f = matriz[1][2];
			int g = matriz[2][0];
			int h = matriz[2][1];
			int i = matriz[2][2];
			int solucion = ((a*e*i)+(d*h*c)+(b*h*g)-(c*e*g)-(d*b*i)-(a*f*h)); 
			return solucion;
		}
	}
	
	public boolean esCuadradoMagico() {
		int aux;
		int sumaFila=0;
		int sumaDiagonal = 0;
		for (int i = 0; i < matriz.length; i++) {
			aux=sumaFila;
			for (int j = 0; j < matriz.length; j++) {
				sumaFila += matriz[i][j];
				if(i==j) {
					sumaDiagonal += matriz[i][j];
				}
			}
			if(i!=0) {
				if(aux!=sumaFila) {
					return false;
				}
			}
		}
		
		int sumaColumna=0;
		for (int i = 0; i < matriz[0].length; i++) {
			aux=sumaColumna;
			for (int j = 0; j < matriz.length; j++) {
				sumaColumna += matriz[j][i];
			}
			if(i!=0) {
				if(aux!=sumaColumna) {
					return false;
				}
			}
		}
		
		if((sumaColumna==sumaFila)&&(sumaFila==sumaDiagonal)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int[][] trasponer() {
		int[][] matriz = this.matriz;
		if (matriz.length != matriz[0].length) {
			System.out.println("las columnas y las filas deben tener el mismo tamaño");
		} else {
			int aux;
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					aux=matriz[j][i];
					matriz[i][j]=aux;
				}
			}
		}
		return matriz;
	}
	
	public boolean esSimetrica() {
		int[][] traspuesta = trasponer();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]!=traspuesta[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean iguales(MatrizCuadrada matriz2) {
		if(matriz2.matriz.length!=matriz.length) {
			return false;
		}else {
			if(matriz2.matriz[0].length!=matriz[0].length) {
				return false;
			}else {
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						if(matriz2.matriz[i][j]!= matriz[i][j]) {
							return false;
						}
					}
				}
				return true;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
