package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bbdd.BBDD;
import laboral.DatosNoCorrectosException;

/**
 * Servlet implementation class ActualizaNominas
 */
public class ActualizaNominas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BBDD bbdd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizaNominas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out;
		String title = "Nominas";
		try {
			bbdd = new BBDD();
			bbdd.calcularSueldo(bbdd.buscarEmpleado(request.getParameter("salario_actualizado")));
			out = response.getWriter();
		    out.println("<html><head><title>");
		    out.println(title);
		    out.println("</title></head><body>");
		    out.println("<H1>" + title + "</H1>");
		    out.println("<p>El salario del empleado: <b>" + request.getParameter("salario_actualizado") +  "</b> ha sido actualizado.</p>");
		    out.println("<a href=''><button>Pagina Principal</button></a>");
		    out.println("</body></html>");
		    out.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
