package com.tredence.hay.controller;
import java.awt.*;
import java.io.*;

import com.tredence.hay.config.*;
import com.tredence.hay.model.*;

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
public class PrimaryController extends HttpServlet implements FilePath {
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
	Organizer org;
	Panelist pnl;
	ManageOrganizer mo;
	ManagePanelist mpnl;
	String organizer_synthetic_key, panelist_synthetic_key;
	ManageRounds mr;
	Round rnd;
	ManageFeedback mf;
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
		String form_id=request.getParameter("form_id");
		System.out.println(form_id);
		ArrayList<Round> rounds=new ArrayList<Round>();
		mr=new ManageRounds();
		ArrayList<Profile> profiles=new ArrayList<Profile>();
		ArrayList<Organizer> orgs=new ArrayList<Organizer>();
		ArrayList<Panelist> pnls=new ArrayList<Panelist>();
		if(form_id.equals("profiledetail")){
			String PID=request.getParameter("PID");
			pf=new Profile();
			mp=new ManageProfile();
			profiles=mp.searchProfile("profile_id",PID);
			request.setAttribute("profile",profiles.get(0));
			rounds=mr.getAllRoundsOfProfile(request.getParameter("PID"));
			request.setAttribute("rounds",rounds);
			mo=new ManageOrganizer();
			orgs=mo.getAllOrganizers();
			mpnl=new ManagePanelist();
			pnls=mpnl.getAllPanelists();
			request.setAttribute("orgs",orgs);
			request.setAttribute("pnls",pnls);
			List<UploadDetail> fileList=getResume(PID);
			request.setAttribute("uploadedFiles", fileList);
			rd = request.getRequestDispatcher("/DetailedProfile.jsp");
			rd.forward(request, response);
		}
		else if(form_id.equals("returnhome")){
			session=request.getSession();
			rounds=new ArrayList<Round>();
			mr=new ManageRounds();
			if(session.getAttribute("email")==null){
				rd = request.getRequestDispatcher("/index.jsp?");
				rd.forward(request, response);
			}else {
				rounds = mr.getAllRoundsOfPanelist(session.getAttribute("email").toString());
				session.setAttribute("rounds", rounds);
				rd = request.getRequestDispatcher("/OrganizerHome.jsp?u=" + session.getAttribute("email").toString());
				rd.forward(request, response);
			}
		}
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
					ArrayList<Round> rounds=new ArrayList<Round>();
					mr=new ManageRounds();
					rounds=mr.getAllRoundsOfPanelist(user.getEmail());
					session.setAttribute("rounds", rounds);
					if(user.getRole().equals("Organizer")){
						mo=new ManageOrganizer();
						organizer_synthetic_key=mo.getOrganizerSyntheticKey(user.getEmail());
						session.setAttribute("synthetic_key",organizer_synthetic_key);

					}
					else if(user.getRole().equals("Panelist")){
						mpnl=new ManagePanelist();
						panelist_synthetic_key=mpnl.getPanelistSyntheticKey(user.getEmail());
						session.setAttribute("sythetic_key",panelist_synthetic_key);

					}
					rd = request.getRequestDispatcher("/OrganizerHome.jsp?u="+user.getEmail());
					rd.forward(request, response);
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
			else if(form_id.equals("addorg")){
				 org=new Organizer();
				 org.setOrganizer_synthetic_key("Org1");
				org.setFirst_name(request.getParameter("fname"));
				org.setLast_name(request.getParameter("lname"));
				org.setEmail(request.getParameter("email"));
				org.setPhone(request.getParameter("phn"));
				org.setCity(request.getParameter("city"));
				org.setCountry(request.getParameter("country"));
				org.setDept(request.getParameter("dept"));
				org.setLeadership_profile(request.getParameter("leadership"));
				org.setTimezone(request.getParameter("timezone"));
				org.setTeams_link(request.getParameter("teamslink"));

				mo=new ManageOrganizer();
				int id=mo.addNewOrganizer(org);

				rd = request.getRequestDispatcher("/OrganizerHome.jsp?orgid=R-" + id);
				rd.forward(request, response);
			}
			else if(form_id.equals("addpnl")){
				pnl=new Panelist();
				pnl.setPanelist_synthetic_key("pnl1");
				pnl.setFirst_name(request.getParameter("fname"));
				pnl.setLast_name(request.getParameter("lname"));
				pnl.setEmail(request.getParameter("email"));
				pnl.setPhone(request.getParameter("phn"));
				pnl.setCity(request.getParameter("city"));
				pnl.setCountry(request.getParameter("country"));
				pnl.setDept(request.getParameter("dept"));
				pnl.setLeadership_profile(request.getParameter("leadership"));
				pnl.setLinkedin_url(request.getParameter("linkedinurl"));
				pnl.setTimezone(request.getParameter("timezone"));
				pnl.setSkillset(request.getParameter("skillset"));
				mpnl = new ManagePanelist();
				int id=mpnl.addNewPanelist(pnl);
				rd = request.getRequestDispatcher("/OrganizerHome.jsp?pnlid=I-" + id);
				rd.forward(request, response);


			}

			else if(form_id.equals("createscrround")){
				rnd=new Round();
				rnd.setRound_synthetic_key("Round1");
				rnd.setRound_Name(request.getParameter("roundname"));
				rnd.setRound_type(request.getParameter("roundtype"));
				rnd.setMode(request.getParameter("mode"));
				rnd.setPanelist_id(request.getParameter("Panelist"));
				rnd.setScheduled_on(request.getParameter("scheduled_on").concat(" ").concat(request.getParameter("timezone")));
				rnd.setIsRescheduled((request.getParameter("rsch")==null?"N":request.getParameter("rsch")));
				rnd.setDuration(request.getParameter("duration"));
				rnd.setOrganizer_id(session.getAttribute("synthetic_key").toString());
				rnd.setProfile_id(request.getParameter("profile_id"));
				rnd.setStatus("Scheduled");
				mr=new ManageRounds();

				int id=mr.addNewRound(rnd);
				String PID=request.getParameter("profile_id");
				ArrayList<Round> rounds=new ArrayList<Round>();
				mr=new ManageRounds();
				ArrayList<Profile> profiles=new ArrayList<Profile>();
				ArrayList<Organizer> orgs=new ArrayList<Organizer>();
				ArrayList<Panelist> pnls=new ArrayList<Panelist>();
				pf=new Profile();
				mp=new ManageProfile();
				profiles=mp.searchProfile("profile_id",PID);
				request.setAttribute("profile",profiles.get(0));
				rounds=mr.getAllRoundsOfProfile(PID);
				request.setAttribute("rounds",rounds);
				mo=new ManageOrganizer();
				orgs=mo.getAllOrganizers();
				mpnl=new ManagePanelist();
				pnls=mpnl.getAllPanelists();
				request.setAttribute("orgs",orgs);
				request.setAttribute("pnls",pnls);
				List<UploadDetail> fileList=getResume(PID);
				request.setAttribute("uploadedFiles", fileList);
				rd = request.getRequestDispatcher("/DetailedProfile.jsp");
				rd.forward(request, response);;

			}

			else if(form_id.equals("startround")){
				String TaskId=request.getParameter("round_id");
				String profile_id=request.getParameter("profile_id");
				String org_syn_key=request.getParameter("org_syn_key");
				mo=new ManageOrganizer();
				String teams_link=mo.getTeamsLink(org_syn_key);
				request.setAttribute("teams_link",teams_link);
				rd = request.getRequestDispatcher("/Feedback.jsp?TaskId="+TaskId+"&ProfileId="+profile_id);
				rd.forward(request, response);;

			}
			else if(form_id.equals("finishround")){

				Feedback fd=new Feedback();
				fd.setRound_synthetic_key(request.getParameter("round_id"));
				fd.setTech_Skill_Score(request.getParameter("skillset"));
				fd.setBiz_Skill_Score(request.getParameter("biz"));
				fd.setComm_Score(request.getParameter("comm"));
				fd.setProposed_Employment_type(request.getParameter("emp_type"));
				fd.setProposed_Designation(request.getParameter("desg"));
				fd.setComment(request.getParameter("comment"));
				fd.setResult(request.getParameter("result"));

				mf=new ManageFeedback();
				mf.addFeedback(fd);
				String PID=request.getParameter("profile_id");
				ArrayList<Round> rounds=new ArrayList<Round>();
				mr=new ManageRounds();
				ArrayList<Profile> profiles=new ArrayList<Profile>();
				ArrayList<Organizer> orgs=new ArrayList<Organizer>();
				ArrayList<Panelist> pnls=new ArrayList<Panelist>();
				pf=new Profile();
				mp=new ManageProfile();
				profiles=mp.searchProfile("profile_id",PID);
				request.setAttribute("profile",profiles.get(0));
				rounds=mr.getAllRoundsOfProfile(PID);
				request.setAttribute("rounds",rounds);
				mo=new ManageOrganizer();
				orgs=mo.getAllOrganizers();
				mpnl=new ManagePanelist();
				pnls=mpnl.getAllPanelists();
				request.setAttribute("orgs",orgs);
				request.setAttribute("pnls",pnls);
				List<UploadDetail> fileList=getResume(PID);
				request.setAttribute("uploadedFiles", fileList);
				rd = request.getRequestDispatcher("/DetailedProfile.jsp");
				rd.forward(request, response);;



			}

		}

		

	}

	public List<UploadDetail> getResume(String profile_syn_key)
	{
		List<UploadDetail> fileList =null;
				String docpath=config_path + File.separator + "Resume" + File.separator + profile_syn_key;
		File fileUploadDirectory = new File(docpath);
		System.out.println(docpath);
		if (fileUploadDirectory.exists()) {
			//System.out.println(docpath);
			UploadDetail details = null;
			File[] allFiles = fileUploadDirectory.listFiles();
			 fileList = new ArrayList<UploadDetail>();

			for (File file : allFiles) {
				//System.out.println("here");
				details = new UploadDetail();
				details.setFileName(file.getName());
				// System.out.println(details.getFileName());
				details.setFileSize(file.length() / 1024);
				fileList.add(details);
			}


		}
		return fileList;
	}

}
