package Controlador;


import DAO.DaoUsuario;
import Modelo.Usuario;
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

public class Registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String identificador  = request.getParameter("identificador");
        String clave = request.getParameter("pwd2");
        String colegio = request.getParameter("colegio");
        
        try {
            DaoUsuario daoU = new DaoUsuario();
            boolean respuesta = daoU.validarRegistro(identificador, clave, colegio);
            String json = new Gson().toJson(respuesta);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
