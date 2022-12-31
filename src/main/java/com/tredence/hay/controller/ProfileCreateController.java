package com.tredence.hay.controller;
import com.tredence.hay.config.ManageProfile;
import com.tredence.hay.config.ManageUsers;
import com.tredence.hay.model.Profile;
import com.tredence.hay.model.Users;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
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
 * Servlet implementation class SecondaryController
 */
public class ProfileCreateController extends HttpServlet implements FilePath{
	HttpSession session;
	private static final long serialVersionUID = 1L;
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	String form_id;
	ManageProfile mp;
	RequestDispatcher rd;
	FileItem resume;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		String last_update_by=session.getAttribute("email").toString();

		if (!ServletFileUpload.isMultipartContent(request)) {
			// if not, we stop here
			PrintWriter writer = response.getWriter();
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		Profile pf = new Profile();
		pf.setProfile_sythetic_key("Profile1");
		pf.setLast_updated_by(last_update_by);
		try {

			@SuppressWarnings("unchecked")
			List<FileItem> uploadItems = upload.parseRequest(request);

			for (FileItem uploadItem : uploadItems) {
				if (uploadItem.isFormField()) {
					String fieldName = uploadItem.getFieldName();
					String value = uploadItem.getString();
					if (fieldName.equals("form_id")) {
						 form_id=request.getParameter("form_id");
					}
					else if(fieldName.equals("fname")){
						pf.setFirst_name(value);
					}
					else if(fieldName.equals("lname")){
						pf.setLast_name(value);
					}
					else if(fieldName.equals("phn")){
						pf.setPrimary_phn(value);
					}
					else if(fieldName.equals("email")){
						pf.setPrimary_email(value);
					}
					else if(fieldName.equals("city")){
						pf.setCity(value);
					}
					else if(fieldName.equals("country")){
						pf.setCountry(value);
					}
					else if(fieldName.equals("source")){
						pf.setSource(value);
					}
					else if(fieldName.equals("ref")){
						pf.setRef_emp_id(value);
					}
					else if(fieldName.equals("linkedinprof")){
						pf.setLinkedin_url(value);
					}
					else if(fieldName.equals("githublink")){
						pf.setGithub_url(value);
					}
					else if(fieldName.equals("visa")){
						pf.setVisa_status(value);
					}
					else if(fieldName.equals("status")){
						pf.setStatus(value);
					}
					else if(fieldName.equals("exemp_flg")){
						pf.setExemp_flg(value);
					}
					else if(fieldName.equals("exempid")){
						pf.setExemp_id(value);
					}
					else if(fieldName.equals("gender")){
						pf.setGender(value);
					}

				} else {
					 resume = uploadItem;

				}
			}
			mp = new ManageProfile();
			int pid = mp.checkDuplicate(pf);
			if (pid > 0) {
				rd = request.getRequestDispatcher("/OrganizerHome.jsp?dupid=P-" + pid);
				rd.forward(request, response);
			} else {
				int id = mp.addNewProfile(pf);
				if (id > 0) {
					String fileName = new File(resume.getName()).getName();
					String uploadpath=config_path + File.separator + "Resume" + File.separator + "P-"+id;
					String filePath = config_path + File.separator + "Resume" + File.separator + "P-"+id
							+ File.separator + fileName;
					File uploadDir = new File(uploadpath);
					if (!uploadDir.exists()) {
						uploadDir.mkdir();
					}
					//System.out.println(filePath);
					File storeFile = new File(filePath);

					// saves the file on disk
					resume.write(storeFile);
					rd = request.getRequestDispatcher("/OrganizerHome.jsp?profileid=P-" + id);
					rd.forward(request, response);
				}
			}
			}catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
