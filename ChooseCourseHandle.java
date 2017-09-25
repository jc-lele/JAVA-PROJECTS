package vcampus.server.choosecoursehandle;

import vcampus.Message;
import vcampus.database.classtype.Course;
import vcampus.database.classtype.StudentGrade;
import vcampus.database.database.CourseDB;
import vcampus.database.database.StudentGradeDB;


public class ChooseCourseHandle {
	public void chooseCourseGetMessageBox_add(Message messageBox)throws InterruptedException {
		String courseID = messageBox.getData().getCourseID();
		String sID = messageBox.getData().getID();
		
		Course course = new Course();
		CourseDB cdb = new CourseDB();
		
		course = cdb.selectCourse(courseID);
		
		StudentGrade sg = new StudentGrade();
		
		sg.setsID(sID);
		sg.setSubject(course.getCourseName());
		sg.setScore(course.getScore());
		sg.setCourseTime(course.getCourseTime());
		
		cdb.addSG(sg);
		
		messageBox.sendToClient();
		
	}
	public void chooseCourseGetMessageBox_delete(Message messageBox)throws InterruptedException{
		String courseID = messageBox.getData().getCourseID();
		String sID = messageBox.getData().getID();
		
		Course course = new Course();
		CourseDB cdb = new CourseDB();
		
		course = cdb.selectCourse(courseID);
		
		String subject = course.getCourseName();
		
		cdb.deleteSG(sID, subject);
		
		messageBox.sendToClient();

	}
	
	public void chooseCourseGetMessageBox_show(Message messageBox)throws InterruptedException{
		
		CourseDB cdb = new CourseDB();
		
		String scourse[] = new String[15];
		String scoursescore[] = new String[15];
		String scoursetime[] = new String[15];
		String cid[] = new String[15];
		
		
		cdb.showCourse(cid,scourse, scoursescore, scoursetime);
		
		messageBox.getData().setscourse(scourse);
		messageBox.getData().setscoursescore(scoursescore);
		messageBox.getData().setscoursetime(scoursetime);
		messageBox.getData().setCid(cid);
		
		messageBox.sendToClient();
	}
	
	
	public void chooseCourseGetMessageBox_print_scourse(Message messageBox)throws InterruptedException{
		
		String sID = messageBox.getData().getID();
		
		StudentGradeDB sgdb = new StudentGradeDB();
		
		String course[] = new String[15];
		String coursescore[] = new String[15];
		String coursetime[] = new String[15];
		
		sgdb.print_course(sID, course, coursescore, coursetime);
		
		messageBox.getData().setcourse(course);
		messageBox.getData().setcoursescore(coursescore);
		messageBox.getData().setcoursetime(coursetime);
		
		messageBox.sendToClient();
		
	}
	
	
	
	
}
