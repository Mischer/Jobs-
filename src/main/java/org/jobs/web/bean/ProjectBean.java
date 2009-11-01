package org.jobs.web.bean;

import java.util.List;

import org.apache.log4j.Logger;
import org.jobs.persistence.bean.Project;
import org.jobs.web.FacesUtils;
import org.jobs.ws.bean.ProjectsManager;
import org.jobs.ws.bean.UsersManager;

public class ProjectBean {
	
	private static Logger log = Logger.getLogger(UserBean.class);

	private ProjectsManager projectsManager = null;
	private UsersManager usersManager = null;
	
	private Project project = new Project();
	
	public ProjectBean() {
		projectsManager = (ProjectsManager) FacesUtils.getBean("projectsWSClient");
		usersManager = (UsersManager) FacesUtils.getBean("usersWSClient");
    }
	
	public String save(){
		project.getUser().add(usersManager.getUser(new Long(1)));
		Project projectSave = projectsManager.creteProject(project);
		if(log.isDebugEnabled()){
			log.debug(String.format("Save project with id = %s .", projectSave.getId()));
		}
		return "project.list";
	}
	
	public List<Project> getListProject(){
		if(log.isDebugEnabled()){
			log.debug("Get list project.");
		}
		return projectsManager.getProjetsByUserId(new Long(1));
	}
	

	public Project getProject() {
    	return project;
    }

	public void setProject(Project project) {
    	this.project = project;
    }
}
