import java.io.*;
import java.net.Socket;
import java.util.Random;

public class cliente {

    private static final int INTERVALO = 10000; // 10 segundos

    public static void main(String[] args) throws InterruptedException {

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            socket = new Socket("localhost", 1235);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Random random = new Random();

            while (true) {
                int numero = random.nextInt((int) Math.pow(1000, 30)); // Gera um número inteiro com até 30 casas

                if (numero > 1000000000000000000L) { // Se o número tiver mais de 10 dígitos, gera uma string de mesmo tamanho
                    String respostaString = "";
                    for (int i = 0; i < Long.toString(numero).length(); i++) {
                        respostaString += "a"; // Pode ser qualquer caracter
                    }
                    System.out.println("Cliente: " + numero + " - Resposta: " + respostaString);
                    bufferedWriter.write(Long.toString(numero));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    String servidorResposta = bufferedReader.readLine();
                    System.out.println("Servidor: " + servidorResposta + " | " + "Numero recebido pelo cliente: " + numero);
                    System.out.println("FIM");

                    if (servidorResposta.equalsIgnoreCase("Adeus!")) {
                        break;
                    }

                } else { // Se o número tiver 10 dígitos ou menos, verifica se é par ou ímpar

                    String resposta = (numero % 2 == 0) ? "par" : "ímpar";
                    System.out.println("2 Opções - Retorna um conjunto de strings ou retorna par ou impar:");
                    System.out.println("Cliente: " + numero);

                    bufferedWriter.write(Long.toString(numero));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    String servidorResposta = bufferedReader.readLine();

                    System.out.println("Servidor: " + servidorResposta + " | " + "Numero recebido pelo cliente: " + numero);
                    System.out.println("FIM");
                    System.out.println("---------------------------------------------------------------------");
                    if (servidorResposta.equalsIgnoreCase("Adeus!")) {
                        break;
                    }
                }

                Thread.sleep(INTERVALO); // Aguarda 10 segundos antes de enviar o próximo número
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (outputStreamWriter != null)
                    outputStreamWriter.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {

            }
        }
    }
}