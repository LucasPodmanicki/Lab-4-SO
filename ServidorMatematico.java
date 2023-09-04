import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMatematico {

    public static void main(String[] args) {
        System.out.println("Servidor Matem�tico online");
        int porta = 7890;

        try {
            ServerSocket serverSocket = new ServerSocket(porta);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado");

                // Configura um BufferedReader para ler a solicita��o do cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // Configura um PrintWriter para enviar a resposta ao cliente
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputLine = in.readLine();

                if (inputLine != null) {
                    // Divide a mensagem recebida em operacao, primeiro_valor e segundo_valor
                    String[] parts = inputLine.split(":");
                    
                    if (parts.length == 3) {
                        String operacao = parts[0];
                        double primeiro_valor = Double.parseDouble(parts[1]);
                        double segundo_valor = Double.parseDouble(parts[2]);
                        
                        double resultado = 0;

                        // Realiza a opera��o especificada
                        switch (operacao) {
                            case "soma":
                                resultado = primeiro_valor + segundo_valor;
                                break;
                            case "subtrai":
                                resultado = primeiro_valor - segundo_valor;
                                break;
                            case "multiplica":
                                resultado = primeiro_valor * segundo_valor;
                                break;
                            case "divide":
                                if (segundo_valor != 0) {
                                    resultado = primeiro_valor / segundo_valor;
                                } else {
                                    out.println("Erro: Divis�o por zero");
                                }
                                break;
                            default:
                                out.println("Erro: Opera��o n�o suportada");
                        }

                        // Envia a resposta para o cliente
                        out.println(resultado);
                    } else {
                        out.println("Erro: Formato de mensagem inv�lido");
                    }
                }

                // Fecha a conex�o com o cliente
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}