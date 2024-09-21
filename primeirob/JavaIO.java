import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> linhas = new ArrayList<>();

        System.out.println("Quantas colunas sua planilha tera?");
        int numColunas = scanner.nextInt();
        scanner.nextLine();

        String[] cabecalho = new String[numColunas];

        for (int i = 0; i < numColunas; i++) {
            System.out.println("Digite o nome da coluna " + (i + 1) + ":");
            cabecalho[i] = scanner.nextLine();
        }
        linhas.add(cabecalho);

        boolean continuar = true;
        while (continuar) {
            String[] linha = new String[numColunas];
            for (int i = 0; i < numColunas; i++) {
                System.out.println("Digite o valor para a coluna '" + cabecalho[i] + "':");
                linha[i] = scanner.nextLine();
            }
            linhas.add(linha);

            System.out.println("Deseja inserir outra linha? (s/n)");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("Digite o nome do arquivo (sem extensão):");
        String nomeArquivo = scanner.nextLine();
        
        try (FileWriter csvWriter = new FileWriter(nomeArquivo + ".csv")) {
            for (String[] linha : linhas) {
                csvWriter.append(String.join(",", linha));
                csvWriter.append("\n");
            }
            System.out.println("Arquivo CSV criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV.");
            e.printStackTrace();
        }
    }
}
