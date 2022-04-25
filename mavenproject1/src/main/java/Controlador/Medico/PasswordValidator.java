/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Medico;

/**
 *
 * @author norma
 */
public class PasswordValidator {
    public static int isValidPassword(String password) {
        int code = 1;
        if (password.length() > 15 || password.length() < 8) {
            code = -1;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            code = -2;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            code = -3;
        }
        return code;
    }
    
}
