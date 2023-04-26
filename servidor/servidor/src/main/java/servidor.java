import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4815);
        System.out.println("Servidor iniciado na porta 4815...");

        // Cria um ScheduledExecutorService com uma thread que executa o código do servidor a cada 10 segundos
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Conexão estabelecida com o cliente " + socket.getInetAddress()); // Aparece no console
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {
                    String mensagemDoCliente = bufferedReader.readLine();

                    if (mensagemDoCliente == null) {
                        break;
                    }

                    System.out.println("Número recebido do cliente: " + mensagemDoCliente);

                    long numero = Long.parseLong(mensagemDoCliente);
                    int tamanho = mensagemDoCliente.length();
                    String respostaString = "";

                    if(tamanho > 10)
                    {
                        for (int i = 0; i < tamanho; i++)
                            respostaString += "a"; // Pode ser qualquer caracter
                    }
                    else
                    {
                        respostaString = (numero % 2 == 0) ? "par" : "impar";
                    }

                    bufferedWriter.write(respostaString);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    System.out.println("Número recebido do cliente: " + numero);


                    //  Se o número for maior que 999.999.999 (que tem 10 dígitos), a condição é verdadeira e o código dentro do bloco de chaves {} será executado.
                    //if (numero > 999999999L) { // Se o número tiver mais de 10 dígitos, gera uma string de mesmo tamanho
                     //   String respostaString = "";
                      //  for (int i = 0; i < Long.toString(numero).length(); i++) {
                       //     respostaString += "a"; // Pode ser qualquer caracter
                        //}
                        //System.out.println("1º Opção");
                        //System.out.println("Cliente: " + numero);
                        //bufferedWriter.write(Long.toString(numero));
                        //bufferedWriter.newLine();
                        //bufferedWriter.flush();
                        //String servidorResposta = bufferedReader.readLine();
                        //System.out.println("Servidor: " + respostaString + " | " + "Numero recebido pelo cliente: " + numero);
                        //System.out.println("FIM");

                    // Verifica se o número tem mais de 10 casas
                    //if (mensagemDoCliente.length() > 10) {
                        // Gera uma string do mesmo tamanho do número e envia para o cliente
                      //  int numero = Integer.parseInt(mensagemDoCliente);
                      //  String respostaString = gerarString(mensagemDoCliente.length());
                      //  bufferedWriter.write(respostaString);
                      //  bufferedWriter.newLine();
                      //  bufferedWriter.flush();
                      //  System.out.println("Número recebido do cliente: " + numero);
                    //} else {
                        // Converte o número para inteiro e verifica se é par ou ímpar
                      //  int numero = Integer.parseInt(mensagemDoCliente);
                      //  String resposta = (numero % 2 == 0) ? "par" : "impar";
                       // bufferedWriter.write(resposta);
                       // bufferedWriter.newLine();
                       // bufferedWriter.flush();
                       // System.out.println("Número recebido do cliente: " + numero);
                   // }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    // Método para gerar uma string aleatória com o mesmo tamanho do número recebido
    private static String gerarString(int tamanho) {
        StringBuilder stringBuilder = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            char c = (char) (Math.random() * 26 + 'a');
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}