/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UsuarioApp.Modelo.DAO;

import DatabaseServerApp.Modelo.ConexionMySql;
import UsuarioApp.Modelo.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author norma
 */
public class LoginDAO {
    int rspta = 0;
    String sql = "";
    ResultSet rs = null;
    ConexionMySql cn = new ConexionMySql();

    public int validarLogin(Usuario tm) throws Exception {
        sql = "SELECT COUNT(*) as cantidad from `usuarios` WHERE id=" + tm.getId() + " AND clave='" + tm.getClave() + "'";
//        sql = "SELECT COUNT(CODTRABAJADOR) AS cantidad FROM `trabajador` WHERE USUARIO='" + tm.getId()+ "' AND CLAVE='" + tm.getClave() + "'";
        rs = cn.ejecutarConsulta(sql);
        while (rs.next()) {
            rspta = rs.getInt("cantidad");
            System.out.println(rspta);
        }
        return rspta;
    }
    
}
