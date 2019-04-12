package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio02
 */
@WebServlet("/Exercicio02")
public class Exercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Exercicio02() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String nomeCompleto = request.getParameter("nomeCompleto");

		String[] nomeSeparado = nomeCompleto.split(" ");
		
		 Integer resultado = 0 ;
		for(int x=0 ; x<nomeSeparado.length; x++) {
			 Integer contagem = nomeSeparado[x].length();
			 resultado = (resultado + contagem);
		 }
				
		 
PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exercicio02 - Contagem</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Nome Completo:"+nomeCompleto +"</h1>");
		for(int x=0 ; x<nomeSeparado.length; x++) {
			out.println("<h1>"+(x+1)+" Posição - Nome:"+nomeSeparado[x] +"</h1>");
		}
		out.println("<h1>Contagem de letras do nome completo:"+resultado +"</h1>");
		out.println("</body>");
		out.println("</html>");
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
