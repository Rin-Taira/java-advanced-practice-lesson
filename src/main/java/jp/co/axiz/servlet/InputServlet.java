package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.entity.Car;
import jp.co.axiz.util.Utility;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/inputServlet")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	// ここに必要な処理を記述してください。
    	HttpSession session = request.getSession();
    	String name = (String) request.getParameter("carName");
    	String color = (String) request.getParameter("bodyColor");
    	String maxSpeed = (String) request.getParameter("maxSpeed");
    	
    	if (Utility.isNullOrEmpty(name) || Utility.isNullOrEmpty(color) || Utility.isNullOrEmpty(maxSpeed)) {
    		request.setAttribute("result", "未入力の項目があります。");
    		request.getRequestDispatcher("input.jsp").forward(request, response);
    	}
    	
    	Car latestCar = new Car();
    	latestCar.setCarName(name);
    	latestCar.setBodyColor(color);
    	latestCar.setMaxSpeed(Integer.parseInt(maxSpeed));
    	
    	session.setAttribute("latestCar", latestCar);
    	
    	ArrayList<Car> historyList = new ArrayList<Car>();
    	historyList.add(latestCar);

    	session.setAttribute("historyList", historyList);
    	

        // 結果画面へ遷移
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
