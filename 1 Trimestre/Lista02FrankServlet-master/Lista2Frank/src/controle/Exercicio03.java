package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio03
 */
@WebServlet("/Exercicio03")
public class Exercicio03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Exercicio03() {
        // TODO Auto-generated constructor stub
    	super();
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
		//doGet(request, response);
		Double mesesDouble= 0.0;
		Double valorPagar = 0.0;
		Double resultadoSimples, resultadoComposto;
		
		mesesDouble = Double.parseDouble(request.getParameter("mesesDouble"));
		valorPagar= Double.parseDouble(request.getParameter("valorPagar"));
		
		
		
		resultadoComposto = valorPagar*Math.pow(1.05, mesesDouble);
		resultadoSimples = (valorPagar +((valorPagar*0.05)*mesesDouble));
		
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exercício 03 - Dizendo os Juros</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Valor final juros simples:"+resultadoSimples +"</h1>");
		out.println("<h1>Valor final juros composto:"+resultadoComposto +"</h1>");
		out.println("</body>");
		out.println("</html>");
	
	}
}



		
		
	
