package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio06
 */
@WebServlet("/Exercicio06")
public class Exercicio06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio06() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    static void arrayInverso(String valores6,String[] listaValores6,PrintWriter out) {
		Arrays.sort(listaValores6);

		
		for(int x=0; x<listaValores6.length; x++) {
			out.println("<h1>Valor na posição :"+(x+1)+" da lista é igual a "+listaValores6[x]+"</h1>");
	
		}
		

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String valores6 = request.getParameter("valores6");
		//Integer valoresInt = Integer.parseInt(valores6.split(","))
		String[] listaValores6= valores6.split(",");

		

		
PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exercício 06 - Ordenando vetores</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Ordenando Vetores do maior para o menor: </h1>");					
		arrayInverso(valores6,listaValores6, out);
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
