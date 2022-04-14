package DatabaseServerApp.Modelo;

import DatabaseServerApp.Modelo.ConnectionHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;



public class Servidor {
     final int PUERTO = 7020;
    private ServerSocket serverSocket; // se va a ejecutar siempre

    public Servidor() {
        try{
            abrirPuerto();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirPuerto() {
        try {
            serverSocket = new ServerSocket(PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Para cerrar el servidor ingrese 'close': ");
                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                if (msg.equals("close")){
                    try {
                        serverSocket.close();
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void esperarAlCliente() {
        Socket socket = null;
        try {
            while (!serverSocket.isClosed()){
                socket = serverSocket.accept();      

                ConnectionHandler conectionHandler = new ConnectionHandler(socket);
                Thread thread = new Thread((Runnable) conectionHandler);
                thread.start();
            }
        } catch (IOException ex) {
            close();
        }
    }
}
