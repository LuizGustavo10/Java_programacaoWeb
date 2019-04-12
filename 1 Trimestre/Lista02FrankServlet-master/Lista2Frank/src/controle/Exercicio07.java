package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercicio07
 */
@WebServlet("/Exercicio07")
public class Exercicio07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio07() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    static void calcularImc(Integer sexo,String resultado, Double peso, Double altura, Double imc, PrintWriter out) {


    	if (sexo==1) {

        if (imc < 19.1)
           resultado = "Abaixo do Peso";
        else
           if (imc>=19.1 && imc< 25.8)
        	   resultado = "Peso normal";
           else
              if (imc>=25.8 && imc < 27.3)
            	  resultado = "Marginalmente acima do Peso";
              else
                 if (imc>=27.3 && imc <32.3)
                	 resultado = "Acima do peso ideal";
                 else
                	 resultado = "Obeso"; 
    	}
    	
    	if (sexo==2) {

            if (imc < 20.7)
               resultado = "Abaixo do Peso";
            else
               if (imc>=20.7 && imc< 26.4)
            	   resultado = "Peso normal";
               else
                  if (imc>=26.4 && imc < 27.8)
                	  resultado = "Marginalmente acima do Peso";
                  else
                     if (imc>=27.8 && imc <31.1)
                    	 resultado = "Acima do peso ideal";
                     else
                    	 resultado = "Obeso"; 
        	}
    	
        out.println("<h1>Seu peso é: "+peso+" kgs</h1>");
        out.println("<h1>Sua altura é:"+altura+"</h1>");
        out.println("<h1>Seu imc é "+imc+"</h1>");
        out.println("<h1>O resultado é:"+resultado+"</h1>");
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
   
    	
		Integer sexo=null;
		String resultado = null;
		Double peso = null,altura = null, imc;

		
		sexo=Integer.parseInt(request.getParameter("sexo"));
		peso = Double.parseDouble(request.getParameter("peso"));
		altura = Double.parseDouble(request.getParameter("altura"));
		
		
		imc = peso/(altura*altura);
		
		
		
PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Exercício 06 - Ordenando vetores</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Seu imc é : </h1>");					
		calcularImc(sexo,resultado,peso,altura,imc,out);
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
