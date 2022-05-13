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

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
    	
    	String btn = (String) request.getParameter("btn");
    	
    	if (btn.equals("back")) {
    		session.invalidate();
    		request.getRequestDispatcher("input.jsp").forward(request, response);
    	}
    	
    	ArrayList<Car> historyList = (ArrayList) session.getAttribute("historyList");
    	String color = (String) request.getParameter("bodyColor");
    	String speed = (String) request.getParameter("speed");
    	
    	Car previousCar = (Car) session.getAttribute("latestCar");
    	Car latestCar = new Car(previousCar.getCarName(), previousCar.getBodyColor(), previousCar.getMaxSpeed(), previousCar.getSpeed());
    	latestCar.setBodyColor(color);
    	latestCar.setSpeed(Integer.parseInt(speed));
    	
    	historyList.add(latestCar);
    	
    	session.setAttribute("historyList", historyList);
    	session.setAttribute("latestCar", latestCar);
    	request.setAttribute("result", "車体の色と現在速度を変更しました");
    	
        // 結果画面へ遷移
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }
}
