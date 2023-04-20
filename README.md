<h1>cliente-servidor-app</h1>

> Status: Desenvolvendo ⚠️

### Uma aplicação cliente que se conecta a um servidor e uma aplicação servidor.

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


## Ação do Sistema: 

**1ª Opção**
<br />Cliente: 14510936338
<br />Servidor: aaaaaaaaaa | Numero recebido pelo cliente: 14510936338
FIM

**2ª Opção**
<br />Cliente: 488094175
<br />Servidor: Impar | Numero recebido pelo cliente: 488094175

**3ª Opção**
<br />Cliente: 1211625196
<br />Servidor: aaaaaaaaaa | Numero recebido pelo cliente: 1211625196

**4ª Opção**
<br />Cliente: 652729982
<br />Servidor: par | Numero recebido pelo cliente: 652729982


## Outras Funções Aplicadas

**Cliente**

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
 
