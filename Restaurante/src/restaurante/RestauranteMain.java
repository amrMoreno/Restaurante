/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import clases.Camarero;
import excepciones.DniInvalidoException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Moreno Ruiz
 */
public class RestauranteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        } catch (SQLException ex) {
            System.err.println("Imposible conectar");
            ex.printStackTrace();
            System.exit(0);
        }
        Scanner sc = new Scanner(System.in);
        
        String menu = "\n\n Elije una opcion :"
                + "\n\t0 - Cerar el programa "
                + "\n\t1 - Entrantes"
                + "\n\t2 - Comida "
                + "\n\t3 - Postres"
                + "\n\t4 - Refrescos"
                + "\n\t5 - Copas"
                + "\n\t6 - Licores"
                + "\n\t7 - Vinos"
                + "\n\t8 - Registrar camarero"
                + "\n\t9 - Eliminar camarero";
        
        int action = 0;
        do {
            try {
                System.out.println(menu);
                action = Integer.parseInt(sc.nextLine());
                switch (action) {
                    case 0:
                        System.out.println("Programa cerrado ");
                        break;
                    case 1:
                        System.out.println("Lista entrantes");
                        
                        Statement stmte = con.createStatement();
                        ResultSet rst = stmte.executeQuery("SELECT * FROM comida WHERE tipo = 'ENTRANTES'");
                        while (rst.next()) {
                            String nombre = rst.getString("nombre");
                            System.out.println(nombre);
                            System.out.println("");
                        }
                        stmte.close();
                        break;
                    case 2:
                        System.out.println("Lista de comidas");
                        
                        Statement stmtem = con.createStatement();
                        ResultSet rstt = stmtem.executeQuery("SELECT * FROM comida WHERE tipo = 'COMIDA'");
                        while (rstt.next()) {
                            String nombre = rstt.getString("nombre");
                            System.out.println(nombre);
                            System.out.println("");
                        }
                        stmtem.close();
                        break;
                    case 3:
                        System.out.println("Lista de postres");
                        
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM comida WHERE tipo = 'POSTRE'");
                        while (rs.next()) {
                            String nombre = rs.getString("nombre");
                            System.out.println(nombre);
                            System.out.println("");
                        }
                        stmt.close();
                        break;
                    case 4:
                        System.out.println("Lista refrescos");
                        
                        Statement st = con.createStatement();
                        ResultSet r = st.executeQuery("SELECT * FROM bebida WHERE tipo = 'REFRESCO';");
                        while (r.next()) {
                            String nombre = r.getString("nombre");
                            System.out.println(nombre);
                            System.out.println("");
                        }
                        st.close();
                        break;
                    
                    case 5:
                        System.out.println("Lista de copas");
                        
                        Statement stt = con.createStatement();
                        ResultSet resultadoC = stt.executeQuery("SELECT * FROM bebida WHERE tipo = 'COPA';");
                        while (resultadoC.next()) {
                            String nombre = resultadoC.getString("nombre");
                            System.out.println(nombre);
                            System.out.println("");
                        }
                        stt.close();
                        break;
                    
                    case 6:
                        System.out.println("Lista de licores");
                        
                        Statement stm = con.createStatement();
                        ResultSet resultadoL = stm.executeQuery("SELECT * FROM bebida WHERE tipo = 'LICORES'");
                        while (resultadoL.next()) {
                            String nombre = resultadoL.getString("nombre");
                            System.out.println(nombre);
                            System.out.println("");
                        }
                        stm.close();
                        break;
                    case 7:
                        System.out.println("Lista de vinos");
                        
                        Statement sttt = con.createStatement();
                        ResultSet resultadoV = sttt.executeQuery("SELECT * FROM bebida WHERE tipo = 'VINO'");
                        while (resultadoV.next()) {
                            String nombre = resultadoV.getString("nombre");
                            System.out.println(nombre);
                            System.out.println("");
                        }
                        sttt.close();
                        break;
                    case 8:
                        System.out.println("Registra camarero");
                        registerUser(sc, con);
                        System.out.println("Camarero Registrado");
                        break;
                    case 9:
                        System.out.println("Eliminar  camarero");
                        eliminarUser(sc, con);
                        System.out.println("Camarero Eliminado");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        
                        break;
                }
                
            } catch (SQLException ex) {
                System.err.println("¡Tengo una excepción!");
                System.err.println(ex.getMessage());
            }
            
        } while (action != 0);
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Registra un camarero  en la base de datos Mysql
  @param sc Escaner para introducir datos
 * @param conn Es la connecion con Mysql
 * @return registra un camarero en la base de datos 
 */
    public static Camarero registerUser(Scanner sc, Connection conn) {
        
        try {
            System.out.println("Nombre");
            String nombre = sc.nextLine();
            System.out.println("Dni:");
            String dni = sc.nextLine();
            System.out.println("Tipo de camarero");
            String tipoDeCamarero = sc.nextLine();
            
            Camarero actual = new Camarero(dni, nombre, tipoDeCamarero);
            
            Statement registerStatement = conn.createStatement();
            registerStatement.executeUpdate(
                    "insert into camarero (dni,nombre,tipoDeCamarero) values('" + dni + "','" + nombre + "','" + tipoDeCamarero + "')");
            registerStatement.close();
            return actual;
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DniInvalidoException ex) {
            Logger.getLogger(RestauranteMain.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
        return null;
    }
/**
 * Funcion eliminar camarero,  con una doble comprobacion de dni por seguridad 
 * @param sc Escaner para introducir datos
 * @param conn Es la connecion con Mysql
 * @return Elimina al camarero previamente introducido 
 */
    public static Camarero eliminarUser(Scanner sc, Connection conn) {
        
        try {
            System.out.println("Nombre");
            String nombre = sc.nextLine();
            System.out.println("Dni:");
            String dni = sc.nextLine();
             System.out.println("Repide el Dni:");
            String dni1 = sc.nextLine();
            if (dni.equals(dni1)) {//Comprobacioón del dni por seguridad 
                Statement registerStatement = conn.createStatement();
                registerStatement.executeUpdate(
                        "delete from camarero where dni=('" + dni + "');");
                registerStatement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteMain.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
}
