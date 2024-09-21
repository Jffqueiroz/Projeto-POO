package primeirob.listas.listadois;

import java.util.Scanner;

public class Romanos {
    public static String toRoman(int num) {
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < valores.length; i++) {
            while (num >= valores[i]) {
                resultado.append(romanos[i]);
                num -= valores[i];
            }
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número para converter para números romanos (1-3999): ");
        int numero = sc.nextInt();
        
        if (numero < 1 || numero > 3999) {
            System.out.println("Por favor, insira um número entre 1 e 3999.");
        } else {
            System.out.println("O número " + numero + " em números romanos é: " + toRoman(numero));
        }
        
        sc.close();
    }
}
