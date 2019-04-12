package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio04
 */
@WebServlet("/Exercicio04")
public class Exercicio04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio04() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    static void MostraInverso(String[] valorListadaFuncao, PrintWriter out) {
    	for (int x=valorListadaFuncao.length-1; x>=0;x--) {
			out.println("<h1>Valor na posição" + (x+1) +" É igual a"+valorListadaFuncao[x]+ "</h1>");
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String valoresDigitados = request.getParameter("valoresDigitados");
		String[] valoresLista= valoresDigitados.split(",");
		
		
PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exercício 04 - Dizendo a ordem inversa do vetor</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>A ordem normal é:"+valoresDigitados	+"</h1>");
		out.println("<h1>A ordem inversa é: </h1>");
		MostraInverso(valoresLista, out);
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
