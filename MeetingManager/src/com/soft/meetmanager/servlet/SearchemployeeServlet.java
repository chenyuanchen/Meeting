package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.service.FyService;

public class SearchemployeeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchemployeeServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username1=request.getParameter("username1");
		String employeename1=request.getParameter("employeename1");
		int pageNow = Integer.parseInt(request.getParameter("pageNow")); 
		FyService fyservice = new FyService();
		//���Ȼ�ȡ���ж�������¼
		List listsum = fyservice.pageSum(username1, employeename1);
		//���ж�������¼
		int listSum = listsum.size();
		//ÿҳ��������ǰĬ�ϵ�һҳ
		int pageSize = 3;
		 
		//�ж�ҳ��
		
		int pageSum = 0;
 		if(listSum%3 == 0){
			pageSum = listSum/3;
		}else{
			pageSum = listSum/3 + 1;
		}
		
		//��ʼ�ͽ�����������ǰҳ���Ŀ�ʼ��������������
		int sizeBegin = pageNow*pageSize - 2;
		int sizeEnd = pageNow*pageSize;
		//��ǰҳ�����
		List listfy = fyservice.search(username1, employeename1, sizeBegin, sizeEnd);
		
        //String methodCode = request.getParameter("methodCode"); 
		//if(methodCode.equals("selectemployee")){
		//  SearchemployeesDAO  empl=new SearchemployeesDAO();
	      //  List list=empl.lookingEmp(username1,employeename1,status1);
	        //request.setAttribute("list",list);
 		//String pageNow = request.getParameter("pagenow");
 		//����Щ����ǰ̨
 		request.setAttribute("listsum", listSum);//���ж�������¼
 		request.setAttribute("pagesum", pageSum);//���ж���ҳ
 		request.setAttribute("pagenow",pageNow);//��ǰ�ڼ�ҳ
 		request.setAttribute("listfy",listfy);//��ʾ��¼
 		request.setAttribute("usernamek", username1);
 		request.setAttribute("empnamek", employeename1);
 		
	    request.getRequestDispatcher("/searchemployees.jsp").forward(request, response);
	//}
	}
}
