<h1>cliente-servidor-app</h1>

> Status: Desenvolvendo ⚠️

### Uma aplicação cliente que se conecta a um servidor e uma aplicação servidor.

## Exemplificação 📷

![image](https://user-images.githubusercontent.com/98546863/233650501-9fcd0e96-51af-4870-afff-3d2b295864f5.png)

## Descrição 🖉

**Programa Cliente**
1. O programa cliente irá se conectar ao servidor;
2. Gerar um número inteiro com até 30 casas;
3. Enviar esse número para o servidor;
4. Deve receber, imprimir no console e devolver o valor recebido do servido + “FIM”
5. Fecha a conexão.
Obs.: Repete a cada 10 segundo.

Programa Servidor
1. O programa servidor irá esperar a conexão de clientes;
2. Recebe o número;
3. Se o número tiver mais de 10 casas, gera e envia uma string do mesmo tamanho para o cliente;
4. Se for menor que 10, verifica se é par ou ímpar e envia “PAR” ou “ÍMPAR” para o cliente.

## Alguns campos que este projeto utiliza:

+ Descrição/Titulo
+ Validação
+ Endereço de Host
+ Gerador de Numero Inteiro
+ Condição
+ Retorno Fim

## Outros campos obrigatorios:

+ Gerador 30 Digitos
+ Gerador String
+ Validação Par e Impar

## Linguagem Utilizada
<table> 
 <tr>
  <td>Java</td>
 </tr>
 <tr>
  <td>1.8</td>
 </tr>
</table>


## Ação do Sistema: 

**1ª Opção**
<br />Cliente: 1773760102
<br />Servidor: aaaaaaaaaa | Numero recebido pelo cliente: 1773760102
FIM

**2ª Opção**
<br />Cliente: 326615153
<br />Servidor: Impar | Numero recebido pelo cliente: 488094175
FIM

## Outras Funções Aplicadas

### Cliente

* Intervalo
> Adicionado 10 segundos de intervalo.
<br /> **Corte do codigo:** int INTERVALO = 10000

* Input e Output
> Para escrita e leitura.
<br /> **Corte do codigo:** InputStreamReader inputStreamReader = null;
 <br /> OutputStreamWriter outputStreamWriter = null;
  <br /> BufferedReader bufferedReader = null;
   <br /> BufferedWriter bufferedWriter = null;
   
* Socket
> A ele foi adicionado o endereço da porta.
<br /> **Corte do codigo:** socket = new Socket("localhost", 4815);

* Math pow()
> Gera um numero inteiro com ate 30 casas.
  <br /> **Corte do codigo:** int numero = random.nextInt((int) Math.pow(10, 15));
  
* Condição Verdadeira
> Se o número for maior que 999.999.999 (que tem 10 dígitos), a condição é verdadeira e o código dentro do bloco de chaves {} será executado.
 <br /> Se o número tiver mais de 10 dígitos, gera uma string de mesmo tamanho.
  <br /> **Corte do codigo:** if (numero > 999999999L) { 
    <br /> String respostaString = "";
      <br /> for (int i = 0; i < Long.toString(numero).length(); i++) {
        <br /> respostaString += "a";
  
* Par ou Impar
> Se o número tiver 10 dígitos ou menos, verifica se é par ou ímpar.
<br />  String resposta = (numero % 2 == 0) ? "par" : "ímpar";

* Exceção
> Sinaliza que ocorreu algum tipo de exceção de E/S.
<br /> **Corte do codigo:** catch (IOException e)
 
### Servidor

* Exceção
> Sinaliza que ocorreu algum tipo de exceção de E/S.
<br /> **Corte do codigo:** catch (IOException e)

* Iniciando Socket
> Iniciando a porta informada no Cliente.
<br /> **Corte do codigo:** ServerSocket serverSocket = new ServerSocket(4815);

* Executor Service 
> Cria um ScheduledExecutorService com uma thread que executa o código do servidor a cada 10 segundos.
<br /> **Corte do codigo:** ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
  <br /> executorService.scheduleAtFixedRate(() -> {
   <br /> **Fechando:** }, 0, 10, TimeUnit.SECONDS);
   
* Validação de Mensagem Null
> Caso a mensagem ddo Cliente seja NULL o sistema para. 
<br /> **Corte do codigo:** if (mensagemDoCliente == null)

* Validação Numero de Casas
> Verifica se o numero tem mais de 10 casas. 
<br /> **Corte do codigo:** if (mensagemDoCliente.length() > 10)

* Gerador de String 
> Gera uma string do mesmo tamanho do número e envia para o cliente.
<br /> **Corte do codigo:** String respostaString = gerarString(mensagemDoCliente.length());

* Else Conversão de Numero 
> Converte o número para inteiro e verifica se é par ou ímpar
<br /> **Corte do codigo:** int numero = Integer.parseInt(mensagemDoCliente);
 <br />String resposta = (numero % 2 == 0) ? "par" : "impar";
 
* Gerador de String Aleatoria
> Método para gerar uma string aleatória com o mesmo tamanho do número recebido
<br /> **Corte do codigo:** StringBuilder stringBuilder = new StringBuilder(tamanho);
 <br /> for (int i = 0; i < tamanho; i++) {
  <br /> char c = (char) (Math.random() * 26 + 'a');
   <br />stringBuilder.append(c);

