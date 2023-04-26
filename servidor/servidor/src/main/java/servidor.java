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