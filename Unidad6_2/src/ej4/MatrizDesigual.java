package ej4;

public class MatrizDesigual {
	private Float[][] nums;
	
	public MatrizDesigual() {
		nums = new Float[4][];
	}
	
	public void cargarFila(Float[] numeros, int fila) {
		if (fila>nums.length){
			System.out.println("error");
		}else {
			nums[fila]=numeros;
		}
	}
	
	public void cargarFila(int n, int fila) {
		if (fila>nums.length){
			System.out.println("error");
			return;
		}else {
			Float[] aleatorio = new Float[n];
			Float num= null;
			for (int i = 0; i < n; i++) {
				do {
					num = (float) ((Math.random()*100)-50);
				} while (repetido(aleatorio, i, num));
				aleatorio[i]=num;
			}
			nums[fila]=aleatorio;
		}	
	}
	
	public void verFila(int fila) {
		if((fila<0)&&(fila>nums.length)){
			System.out.println("Error");
		}else {
			for (int i = 0; i < nums[fila].length; i++) {
				System.out.print(nums[fila][i]+" ");
			}
			System.out.println();
		}
	}
	
	public void verMatriz(){
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != null) {
				for (int j = 0; j < nums[i].length; j++) {
					System.out.print(nums[i][j]+" ");
				}
				System.out.println();
			}	
		}
	}
	
	public boolean repetido(Float[] numeros, int posicion, Float num) {
		for (int i = 0; i < posicion; i++) {
			if(numeros[i].equals(num)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MatrizDesigual md1 = new MatrizDesigual();
		
		Float[] f1 = new Float[7];
		for (int i = 0; i < f1.length; i++) {
			f1[i] = (float) Math.pow(3, i);
		}
		
		md1.cargarFila(f1, 0);
		md1.verMatriz();
		
		Float[] f2 = new Float[10];
		int angulos=0;
		for (int i = 0; i < f2.length; i++) {
			f2[i] = (float) Math.cos(angulos);
			angulos+=5;
		}
		
		System.out.println();
		md1.cargarFila(f2, 1);
		md1.verFila(1);
		
		System.out.println();
		md1.cargarFila(10, 2);
		md1.verMatriz();
	}
}
