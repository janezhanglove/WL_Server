package com.geek99.serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geek99.dao.Order;
import com.geek99.dao.OrderDao;
import com.geek99.dao.OrderDaoImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String json = request.getParameter("order_json");
		
		System.out.println(json);
		Order o = null;
		Gson gson = new Gson();
		Type type = new TypeToken<Order>(){}.getType();
		o = gson.fromJson(json, type);
		OrderDao dao = new OrderDaoImpl();
		int r = dao.addOrder(o);
		PrintWriter out = response.getWriter();
		if(r==1){
			out.print("chengongxiadingdan！");
		}else{
			out.print("xiadingdanshibai！");
		}
	}

}
