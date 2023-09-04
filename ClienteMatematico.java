import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteMatematico {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso incorreto. Sintaxe: ClienteMatematico operacao primeiro_valor segundo_valor");
            return;
        }

        String host = "localhost";
        int porta = 7890;

        try {
            Socket socket = new Socket(host, porta);

            // Configura um BufferedReader para ler a resposta do servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Configura um PrintWriter para enviar a solicitação ao servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String operacao = args[0];
            double primeiro_valor = Double.parseDouble(args[1]);
            double segundo_valor = Double.parseDouble(args[2]);

            // Envia a solicitação para o servidor
            out.println(operacao + ":" + primeiro_valor + ":" + segundo_valor);

            // Lê a resposta do servidor e imprime na tela
            String resposta = in.readLine();
            System.out.println("Resposta do servidor: " + resposta);

            // Fecha o socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}