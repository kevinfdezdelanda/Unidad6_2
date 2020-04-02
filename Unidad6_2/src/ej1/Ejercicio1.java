package ej1;

public class Ejercicio1 {
	public static void main(String[] args) {
		System.out.println("Instroduce el numero de alumnos: ");
		int nAlumnos = Consola.leeInt();

		System.out.println("Instroduce el numero de asisgnaturas: ");
		int nAsisgnaturas = Consola.leeInt();

		float[][] matriz = new float[nAlumnos][nAsisgnaturas];

		rellenarMatriz(matriz);

		verMatriz(matriz);

		System.out.println("nota Media: " + notaMedia(matriz, 2));
		
		float[] notaMax = notaMaxima(matriz);
		
		System.out.println();
		for (int i = 0; i < notaMax.length; i++) {
			System.out.println("Nota maxima del alumno "+(i+1)+": "+notaMax[i]);
		}
		
		float[][] tablaNotas = tablaNotas(matriz);
		System.out.println();
		verMatriz(tablaNotas);
	}

	public static void rellenarMatriz(float[][] matriz) {
		int nota;
		for (int i = 0; i < matriz[0].length; i++) {
			System.out.println("Asignatura " + (i + 1) + ":");
			for (int j = 0; j < matriz.length; j++) {
				do {
					System.out.println("Introduce la nota del alumno: " + (j + 1));
					nota = Consola.leeInt();
				}while((nota<0)||(nota>10));
				matriz[j][i] = nota;
			}
			System.out.println();
		}
	}

	public static void verMatriz(float[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("Alumno "+(i+1)+": ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.println("Asignatura "+(j+1)+": "+matriz[i][j]);
			}
			System.out.println();
		}
	}

	public static float notaMedia(float[][] matriz, int alumno) {
		alumno--;
		float sumaNotas = 0;

		for (int i = 0; i < matriz[alumno].length; i++) {
			sumaNotas += matriz[alumno][i];
		}

		return sumaNotas / matriz[alumno].length;
	}
	
	public static float[] notaMaxima(float[][] matriz) {
		float[] notaMaxima = new float[matriz.length];
		float maxNota=Integer.MIN_VALUE;
		
		for (int i = 0; i < matriz.length; i++) {
			maxNota=Integer.MIN_VALUE;
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]>maxNota) {
					maxNota = matriz[i][j];
				}
			}
			notaMaxima[i]=maxNota;
		}
		return notaMaxima;
	}
	
	public static float[][] tablaNotas(float[][] matriz){
		float[][] tablaNotas = new float[matriz.length][4];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]<5) {
					tablaNotas[i][0]++;
				}else {
					if(matriz[i][j]<7){
						tablaNotas[i][1]++;
					}else {
						if(matriz[i][j]<9) {
							tablaNotas[i][2]++;
						}else {
							tablaNotas[i][3]++;
						}
					}	
				}
			}
		}
		return tablaNotas;
	}
	
	
}
