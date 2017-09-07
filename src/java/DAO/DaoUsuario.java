package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Elemento;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUsuario {

    private Connection conexion;

    public DaoUsuario() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public boolean validarRegistro(String usuario, String clave, String colegio) {
        boolean res = false;
        try {
            //1.Establecer la consulta
            String consulta = "select * from usuarios where identificador=? and colegio=?";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, usuario);
            statement.setString(2, colegio);
            //3. Hacer la ejecucion
            res = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        crearUsuarioActivo(usuario, clave);
        return res;
        
    }

    public boolean crearUsuarioActivo(String usuario, String clave) {
        boolean res = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into usuarioActivo values (?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, usuario);
            statement.setString(2, clave);
            //3. Hacer la ejecucion
            res = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res;
    }

}
