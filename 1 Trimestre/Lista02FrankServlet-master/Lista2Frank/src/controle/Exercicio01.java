package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio01
 */
@WebServlet("/Exercicio01")
public class Exercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio01() {
        super();
        // TODO Auto-generated constructor stub
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
		
		Integer n1 = Integer.parseInt(request.getParameter("n1"));
		String classificacaoIdade=null;
		if (n1<=10) {
			classificacaoIdade ="0 a 10 Anos - Criança";
		}
		
		if (n1>10 && n1<=18) {
			classificacaoIdade ="11 a 18 anos - Adolescente";
		}
		
		if (n1>18 && n1<65) {
			classificacaoIdade ="19 a 64 anos - Adulto";
		}
		
		if (n1>=65) {
			classificacaoIdade ="65 anos ou mais - Idoso";
		}
		
		//Double n2 = Double.parseDouble(request.getParameter("n2"));
		//Double resposta = n1+;
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exercício 01 - Classificando a idade</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>O resultado é:"+classificacaoIdade +"</h1>");
		out.println("</body>");
		out.println("</html>");
	
	}

}
