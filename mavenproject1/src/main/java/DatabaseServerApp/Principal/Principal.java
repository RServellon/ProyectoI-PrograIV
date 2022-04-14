package DatabaseServerApp.Principal;

import DatabaseServerApp.Modelo.Servidor;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println("Servidor");
            Servidor modelo = new Servidor();
            modelo.close();
            modelo.esperarAlCliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}