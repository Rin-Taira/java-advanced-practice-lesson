package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartAppServlet() {
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

		App app = null;

	    request.setCharacterEncoding("UTF-8");
	    String name = (String) request.getParameter("name");
	    String selectApp = (String) request.getParameter("app");

	    String result = "";

	    if (name != null && !name.isEmpty()) {
	    	if ("else".equals(selectApp)) {
	    		result = "アプリの実行に失敗しました。";
	    	} else {
	    		switch (selectApp) {
	    		case "cards":
	    			app = new CardGameApp("トランプ");
	    			break;
	    		case "darts":
	    			app = new DartsGameApp("ダーツ");
	    			break;
	    		case "clock":
	    			app = new ClockApp();
	    			break;
	    		}
	    		result = app.start(name);
	    		if (app instanceof GameApp) {
	    			GameApp gameApp = (GameApp) app;
	    			request.setAttribute("time", gameApp.getPlayTime());
	    		}
	    	}
	    }
	    
	    request.setAttribute("result", result);
	    
	    request.getRequestDispatcher("/appStart.jsp").forward(request,  response);
	}

}
