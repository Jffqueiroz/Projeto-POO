package primeirob.primeraatv;

import java.io.FileWriter;
import java.io.IOException;

public class Teste {
    public static void main(String[] args) throws IOException {

        //Scanner input = new Scanner

            try (FileWriter writer= new FileWriter("Exemplo_bala.txt")) {
            writer.write("Pega!😎\n");
            writer.write("Bem vindo a leitura e escrita com Java");
            } catch (IOException e) {
                //e.printStackTrace();
            }
            
            /*  Ler de um arquivo
            try (FileReader reader = new FileReader("exemplo_bala.txt")) {
                int character;
                while ((character = reader.read()) != -1) {
                    System.out.print((char) character);
                }
            } //catch (IOException e) {
                //e.printStackTrace();
        } */
    }
}
