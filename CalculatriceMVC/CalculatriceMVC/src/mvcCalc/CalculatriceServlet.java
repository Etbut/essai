package mvcCalc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatriceServlet
 */
@WebServlet("/CalculatriceServlet")
public class CalculatriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatriceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CalculatriceBean bean = new CalculatriceBean();

		Integer a = 0;
		Integer b = 0;
		Integer res = 0;
		String error = "";

		// Récupération des paramètres
		String inputA = request.getParameter("a");
		String inputB = request.getParameter("b");

		// vérification de l'existance des paramètres

		if (inputA != null) {

			// Test et transformation des paramètres
			try {
				a = Integer.parseInt(inputA);
				b = Integer.parseInt(inputB);
			} catch (Exception e) {
				error = "Les données doivent être des chiffres";
			}

			// appel au métier, ici on le fait directement dans le controleur
			if ("".equals(error)) {
				res = a + b;
			}

			// Remplissage du bean
			if (!"".equals(error)) {
				bean.setA(inputA);
				bean.setB(inputB);
				bean.setResultat("");
				bean.setError(error);
			} else {
				bean.setA(String.valueOf(a));
				bean.setB(String.valueOf(b));
				bean.setResultat(String.valueOf(res));
				bean.setError("");
			}
		} else {
			// initialisation du bean pour le premier affichage de la page
			bean.setA("");
			bean.setB("");
			bean.setResultat("");
			bean.setError("");
		}

		request.setAttribute("bean", bean);
		request.getRequestDispatcher("Calculatrice.jsp").forward(request, response);

	}

}
