
package Funciones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class funConexion {
    
    public String db="basereservas";
    public String url="jdbc:mysql://localhost:3306/" +db;
    public String user="root";
    public String pass="";

    public funConexion() {
        
    }
    
   public Connection conectar(){
       Connection link=null;
       
       try{
           Class.forName("org.gjt.mm.mysql.Driver");
           link=DriverManager.getConnection(this.url, this.user, this.pass);
       }catch(Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return link;
   }
    
    
}
