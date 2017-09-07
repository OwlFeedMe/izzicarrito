package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.net.URISyntaxException;
import java.sql.ResultSet;

public class DaoUsuario {

    private Connection conexion;

    public DaoUsuario() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public ArrayList validarRegistro(String usuario, String clave, String colegio) {
        ArrayList<Boolean> arr1 = new ArrayList<>();
        boolean res = false;
        try {
            String consulta = "select * from usuarios where identificador=? and colegio=?";            
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            statement.setString(1, usuario);
            statement.setString(2, colegio);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                res = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        boolean res2 = crearUsuarioActivo(usuario, clave);
        arr1.add(res);
        arr1.add(res2);
        return arr1;
        
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
