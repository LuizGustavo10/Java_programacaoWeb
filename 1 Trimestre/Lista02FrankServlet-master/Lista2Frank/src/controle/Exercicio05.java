package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio05
 */
@WebServlet("/Exercicio05")
public class Exercicio05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio05() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    static void mostrarMaior(Double num1, Double num2,Double num3, PrintWriter out) {
		Double maiorNum=0.0;
		Double segNum=0.0;
		Double ultNum=0.0;
		
		if (num1>num2 && num1>num3) {
			maiorNum=num1;
		
		if(num2>num3) {
			segNum=num2;
			ultNum=num3;
		}
		
		if (num3>num2) {
			segNum=num3;
			ultNum=num2;
		}
		}		
		
		if(num2>num1 && num2>num3) {
			maiorNum=num2;
		
		if(num1>num3) {
			segNum=num1;
			ultNum=num3;
		}
		
		if (num3>num1) {
			segNum=num3;
			ultNum=num1;
		}
		}
		
		if (num3>num1 && num3>num2) {
			maiorNum=num3;
			
			
			if(num1>num2) {
				segNum=num1;
				ultNum=num2;
			}
			
			if (num2>num1) {
				segNum=num2;
				ultNum=num1;
			}
		}
		out.println("<h1>Maior num:"+maiorNum	+"</h1>");
		out.println("<h1>Segundo maior num:"+segNum +"</h1>");
		out.println("<h1>Menor num:"+ultNum	+"</h1>");

	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Double num1 = Double.parseDouble(request.getParameter("num1"));
		Double num2= Double.parseDouble(request.getParameter("num2"));
		Double num3= Double.parseDouble(request.getParameter("num3"));

		
PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exercício 05 - Maior para o menor de 3 input</title>");
		out.println("</head>");
		out.println("<body>");
		mostrarMaior(num1,num2,num3,out);	
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
