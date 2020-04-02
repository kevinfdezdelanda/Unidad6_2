package ej2;

import ej1.Consola;

public class Matriz1 {
	private final int NF = 10;
	private final int NC = 15;

	private int[][] arrayBi;

	public Matriz1() {
		arrayBi = new int[NF][NC];
	}

	public Matriz1(int nFilas, int nColumnas) {
		arrayBi = new int[nFilas][nColumnas];
	}

	public void cargarPorFilas() {
		for (int i = 0; i < arrayBi.length; i++) {
			System.out.println("Fila " + (i + 1) + ": ");
			for (int j = 0; j < arrayBi.length; j++) {
				System.out.println("Introduce una valor para la columna " + (j + 1) + ": ");
				arrayBi[i][j] = Consola.leeInt();
			}
		}
	}

	public void cargarPorColumnas() {
		for (int i = 0; i < arrayBi[0].length; i++) {
			System.out.println("Columna " + (i + 1) + ": ");
			for (int j = 0; j < arrayBi.length; j++) {
				System.out.println("Introduce una valor para la fila " + (j + 1) + ": ");
				arrayBi[j][i] = Consola.leeInt();
			}
		}
	}

	public void ver() {
		for (int i = 0; i < arrayBi.length; i++) {
			for (int j = 0; j < arrayBi.length; j++) {
				System.out.print(arrayBi[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void invertirFilas() {
		int aux;
		for (int i = 0; i < arrayBi.length; i++) {
			for (int j = 0; j < arrayBi[i].length/2; j++) {
				aux = arrayBi[i][j];
				arrayBi[i][j] = arrayBi[i][(arrayBi[i].length - (j+1))];
				arrayBi[i][arrayBi[i].length - (j+1)] = aux;
			}
		}
	}

	public boolean intercambiarFilas(int fila1, int fila2) {
		fila1--;
		fila2--;
		
		int aux;
		if (((fila1 < 0) || (fila2 < 0)) || ((fila1 >= arrayBi.length) || (fila2 >= arrayBi.length))) {
			return false;
		}

		for (int i = 0; i < arrayBi.length; i++) {
			aux = arrayBi[fila1][i];
			arrayBi[fila1][i] = arrayBi[fila2][i];
			arrayBi[fila2][i] = aux;
		}
		return true;
	}

	public boolean intercambiarColumnas(int columna1, int columna2) {
		columna1--;
		columna2--;
		
		int aux;
		if (((columna1 < 0) || (columna2 < 0))
				|| ((columna1 >= arrayBi[0].length) || (columna2 >= arrayBi[0].length))) {
			return false;
		}

		for (int j = 0; j < arrayBi.length; j++) {
			aux = arrayBi[j][columna1];
			arrayBi[j][columna1] = arrayBi[j][columna2];
			arrayBi[j][columna2] = aux;
		}
		return true;
	}

	public int[] mayorFila() {
		int[] mayorFila = new int[arrayBi[0].length];
		
		int total=0;
		int maxMedia=Integer.MIN_VALUE;
		int posicionMayor=0;
		int media;
		
		for (int i = 0; i < arrayBi.length; i++) {
			total=0;
			for (int j = 0; j < arrayBi[i].length; j++) {
				total += arrayBi[i][j];
			}
			media = total/arrayBi[i].length;
			if(media>maxMedia) {
				maxMedia=media;
				posicionMayor=i;
			}
		}
		
		for (int i = 0; i < mayorFila.length; i++) {
			mayorFila[i] = arrayBi[posicionMayor][i];
		}
		
		return mayorFila;
	}
	
	public int[] negativos() {
		int contador = 0;
		
		for (int i = 0; i < arrayBi.length; i++) {
			for (int j = 0; j < arrayBi[i].length; j++) {
				if(arrayBi[i][j]<0) {
					contador++;
				}
			}
		}
		
		int[] negativos = new int[contador];
		int contadorPosicion = 0;
		
		for (int i = 0; i < arrayBi.length; i++) {
			for (int j = 0; j < arrayBi[i].length; j++) {
				if(arrayBi[i][j]<0) {
					negativos[contadorPosicion] = arrayBi[i][j];
					contadorPosicion++;
				}
			}
		}
		
		return negativos;
	}

	public int[][] getArrayBi() {
		return arrayBi;
	}

	public void setArrayBi(int[][] arrayBi) {
		this.arrayBi = arrayBi;
	}
	
	

}
