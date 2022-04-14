
package DatabaseServerApp.Modelo;

import DatabaseServerApp.SQLConnection.SQLExecutor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionHandler  extends  Thread {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private final String usernameBD = "sa";
    private final String passwordBD = "password";
    private SQLExecutor executor;
    
    public ConnectionHandler(Socket socket) {
    this.socket = socket;
    crearFlujos();
    }
    
    public void crearFlujos() {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // espera la información para ser capturada y mostrada
            bufferedReader = new BufferedReader(inputStreamReader);

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            // espera la información para escribirse y enviarse
            bufferedWriter = new BufferedWriter(outputStreamWriter);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensajeDeError(String mensaje) {
        try {
            bufferedWriter.write("Error: " + mensaje);
            //Preparar el buffer para que quede limpio en el caso de ingresar
            //enviar más información
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            //Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
            salir();
        }
    }
    
    public void enviarMensaje(String mensaje) {
        try {
            bufferedWriter.write(mensaje);
            //Preparar el buffer para que quede limpio en el caso de ingresar
            //enviar más información
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            //Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
            salir();
        }
    }
    
    private void realizarLogin(String username, String password, String id, String tipo) {
        String cadena;
        ResultSet resultSet;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            resultSet = executor.ejecutaQuery("select * from usuarios");
            while (resultSet.next()) {
                if (resultSet.getString("nombre").equals(username) &&
                        resultSet.getString("clave").equals(password) &&
                        resultSet.getString("id").equals(id) && 
                        resultSet.getString("tipo").equals(tipo)) {
                    break;
                }
            }
            cadena = resultSet.getString("nombre");
            enviarMensaje("Conexión exitosa. ¡Bienvenido " + cadena + "!");
            enviarMensaje(resultSet.getString("id"));
        } catch (SQLException throwables) {
            enviarMensajeDeError("Nombre de usuario, identificación o contraseña incorrecto");
        }
    }
    
    private void realizarRegistroGeneral(String username, String id, String password, String tipo){
        if(!verificaUsuarioExiste(id)){
            try{
            
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores[] = new String[5];
                valores[0] = "insert into usuarios(id, nombre, clave, tipo) values (?, ?, ?, ?);";
                valores[1] = id;
                valores[2] = username;
                valores[3] = password;
                valores[4] = tipo;
                executor.prepareStatement(valores);
                enviarMensaje("Proceso completado exitosamente");
            } catch(Exception throwables){
            throwables.printStackTrace();
            enviarMensajeDeError("Hubo un fallo en el proceso");
            }
        }
        else{
            enviarMensajeDeError("El usuario ya se encuentra registrado");
        }
    }
    
    private void registrarMedico(String id, String especialidad, String costo, String ciudad, String clinica, String estado){
         try{
            executor = new SQLExecutor(usernameBD, passwordBD);
           
            String valores[] = new String[7];
            valores[0] = "insert into medicos(id, especialidad, costo, ciudad, clinica, estado) values (?, ?, ?, ?, ?, ?);";
            valores[1] = id;
            valores[2] = especialidad;
            valores[3] = costo;
            valores[4] = ciudad;
            valores[5] = clinica;
            valores[6] = estado;

            executor.prepareStatement(valores);
            enviarMensaje("Proceso completado exitosamente");
         
            } catch(Exception throwables){
            throwables.printStackTrace();
            enviarMensajeDeError("Hubo un fallo en el proceso");
        }   
    }
    
    private boolean verificaUsuarioExiste(String id){
         ResultSet resultSet;
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            resultSet = executor.ejecutaQuery("select * from usuarios");
            while(resultSet.next()){
                if(resultSet.getString("id").equals(id)){
                    return true;
                }
            }
        }catch(SQLException exception){
            exception.printStackTrace();
            enviarMensaje("Hubo un fallo en el proceso");
        }
        return false;
    }
    
    public String recibirMensaje() {
        try {
                return bufferedReader.readLine();
        } catch (IOException ex) {
            salir();
            //Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
     public void salir(){

        try {
            //this.interrupt();

            if(bufferedWriter != null)
                bufferedWriter.close();

            if(bufferedReader != null)
                bufferedReader.close();

            if(socket != null){
                socket.close();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
     
    @Override
    public void run() {
        try {
            while (socket.isConnected()) {
                String mensaje = recibirMensaje();
                
                String username;
                String id;
                String password;
                String tipo;
                String especialidad;
                String costo;
                String ciudad;
                String clinica;
                String estado;
                
                switch (mensaje) {
                    case "registroGeneral": 
                        username = recibirMensaje();
                        id = recibirMensaje();
                        password = recibirMensaje();
                        tipo = recibirMensaje();
                        realizarRegistroGeneral(username, id, password, tipo);
                    break;
                    case "registroMedico":
                        id = recibirMensaje();
                        especialidad = recibirMensaje();
                        costo = recibirMensaje();
                        ciudad = recibirMensaje();
                        clinica = recibirMensaje();
                        estado = recibirMensaje();
                        registrarMedico(id, especialidad, costo, ciudad, clinica, estado);
                    break;
                    case "salir":
                        salir();
                    break;
                }
            }
        } catch (Exception exception) {
            //exception.printStackTrace();
            //enviarMensajeDeError("Hubo un fallo en el proceso");
            salir();
        }
    }
}

