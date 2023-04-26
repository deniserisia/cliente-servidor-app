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
            socket = new Socket("localhost", 4815);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Random random = new Random();

            while (true) {

                int moeda = random.nextInt(2);
                long numero;


                if(moeda == 0)
                {
                    numero = random.nextInt((int) Math.pow(10, 10));
                }
                else
                { //Cenario ficticio
                    numero = (long) (random.nextDouble() * Math.pow(10, 30));
                }

               //Envio do numero ao servidor
               bufferedWriter.write(Long.toString(numero));
               bufferedWriter.newLine();
               bufferedWriter.flush();

               //Resposta do Servidor
               String respostaServidor = bufferedReader.readLine();
               System.out.println("Servidor: " + respostaServidor + " | " + "Numero recebido pelo cliente: " + numero);
               System.out.println("FIM");

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