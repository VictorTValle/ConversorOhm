package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteConversor {

    public static void main(String[] args) {

        Socket socket;
        InputStream canalEntrada;
        OutputStream canalSaida;
        BufferedReader entrada;
        PrintWriter saida;

        try {
            socket = new Socket("127.0.0.1", 4000);

            canalEntrada = socket.getInputStream();
            canalSaida = socket.getOutputStream();

            entrada = new BufferedReader(new InputStreamReader(canalEntrada));
            saida = new PrintWriter(canalSaida, true);

            Scanner leitor = new Scanner(System.in);

            System.out.println("O que você deseja calcular? (1: Resistência, 2: Tensão, 3: Corrente):");

                int choice = leitor.nextInt();
                double resistencia, voltagem, corrente;

                        switch (choice) {
                            case 1:
                                System.out.println("Insira a tensão em volts:");
                                 voltagem = leitor.nextDouble();

                                System.out.println("Insira a corrente eletrica:");
                                corrente = leitor.nextDouble();

                                resistencia = voltagem / corrente;
                                System.out.println("O valor da resistência em Ohm é: " + resistencia);

                            case 2:
                                System.out.println("Insira o valor da resistência em Ohm:");
                                resistencia = leitor.nextDouble();

                                System.out.println("Insira a corrente eletrica:");
                                corrente = leitor.nextDouble();

                                voltagem =resistencia*corrente;
                                System.out.println("O valor da tensão é: " + voltagem);

                            case 3:
                                System.out.println("Insira o valor da resistência em Ohm:");
                                resistencia = leitor.nextDouble();

                                System.out.println("Insira o valor da tensão em volts:");
                                voltagem = leitor.nextDouble();

                                corrente = voltagem / resistencia;
                                System.out.println("O valor da corrente eletrica é: " + corrente);

                        }






            socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}