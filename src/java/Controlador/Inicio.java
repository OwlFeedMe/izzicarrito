package Controlador;

import DAO.DaoUsuario;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;

public class Inicio extends HttpServlet { 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identificador = request.getParameter("user");
        String clave = request.getParameter("pass");
        try {
            DaoUsuario daoU = new DaoUsuario();
            boolean respuesta = daoU.validarUsuario(identificador, clave);
            String json = new Gson().toJson(respuesta);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
