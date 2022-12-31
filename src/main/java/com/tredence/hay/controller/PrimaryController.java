package com.tredence.hay.controller;
import java.io.*;

import com.tredence.hay.config.ManageProfile;
import com.tredence.hay.config.ManageUsers;
import com.tredence.hay.model.Profile;
import com.tredence.hay.model.Users;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.tredence.hay.controller.FilePath;
/**
 * Servlet implementation class PrimaryController
 */
public class PrimaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
	HttpSession session;
	PrintWriter pwriter ;
	Profile pf;
	ManageProfile mp;
	ManageUsers mu;
	Users user;
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
     * Default constructor. 
     */
    public PrimaryController() {
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
		if (ServletFileUpload.isMultipartContent(request)) {

			rd = request.getRequestDispatcher("/Router");
			request.setAttribute("email",session.getAttribute("email").toString());

			rd.forward(request, response);
			
		}
		else {
			String form_id=request.getParameter("form_id");
			

			if(form_id.equals("login")){
				mu=new ManageUsers();
				user=new Users();
				user.setEmail(request.getParameter("userid"));
				user.setRole(request.getParameter("role"));
				boolean login_valid=mu.validateLogin(user);
				if(login_valid) {
					session=request.getSession();
					session.setAttribute("email",user.getEmail());
					session.setAttribute("role",user.getRole());

					if(user.getRole().equals("Organizer")){
						rd = request.getRequestDispatcher("/OrganizerHome.jsp?u="+user.getEmail());
						rd.forward(request, response);
					}
					else if(user.getRole().equals("Panelist")){
						rd = request.getRequestDispatcher("/PanelistHome.jsp?u="+user.getEmail());
						rd.forward(request, response);
					}
				}
				else {
					rd = request.getRequestDispatcher("/index.jsp?e=login_fail");
					rd.forward(request, response);

				}
			}
			else if(form_id.equals("searchprof")){

				mp=new ManageProfile();
				ArrayList<Profile> profiles=new ArrayList<Profile>();

				profiles=mp.searchProfile(request.getParameter("search_by"),request.getParameter("search_val"));
				if(profiles.size()>0){
					session.setAttribute("profiles",profiles);
					rd = request.getRequestDispatcher("/SearchProfile.jsp?msg=found_profile");
					rd.forward(request, response);
				}
				else {
					rd = request.getRequestDispatcher("/SearchProfile.jsp?msg=found_no_profile");
					rd.forward(request, response);
				}
			}
		}

		
		//else if(form_id.equals("addprof")){




		//}
	}

}
