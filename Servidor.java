package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private ServerSocket sckServidor;

    public Servidor() throws IOException {
        this.sckServidor = new ServerSocket(4000);

        for (;;) {
            Socket sckEcho;
            InputStream canalEntrada;
            OutputStream canalSaida;
            BufferedReader entrada;
            PrintWriter saida;

            sckEcho = this.sckServidor.accept();
            canalEntrada = sckEcho.getInputStream();
            canalSaida = sckEcho.getOutputStream();
            entrada = new BufferedReader(new InputStreamReader(canalEntrada));
            saida = new PrintWriter(canalSaida, true);

            while (true) {
                String linhaPedido = entrada.readLine();

                if (linhaPedido == null || linhaPedido.length() == 0)
                    break;

                String mensagem = linhaPedido;

                saida.println("Echo: " + mensagem);
            }
            sckEcho.close();
        }
    }
}
