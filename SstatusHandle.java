package vcampus.server.sstatushandle;

import vcampus.Message;
import vcampus.database.classtype.StudentGrade;
import vcampus.database.classtype.StudentLesson;
import vcampus.database.database.StudentGradeDB;
import vcampus.database.database.StudentLessonDB;

public class SstatusHandle {
	public void sstatusGetMessageBox_print_exam(Message messageBox)throws InterruptedException{
		
		String sID = messageBox.getData().getID();
		String year = messageBox.getData().getYear();
		
		StudentLesson sl = new StudentLesson();
		StudentLessonDB sldb = new StudentLessonDB();
		
		sl = sldb.selectSL(sID);			//获取了sl对象
		
		String exam[] = new String[5];                                          
		String classroom[] = new String[5];                                       
		String examtime[] = new String[5];
		
		
		sldb.print_lesson(sl, year, exam, classroom, examtime);
		
		messageBox.getData().setexam(exam);
		messageBox.getData().setclassroom(classroom);
		messageBox.getData().setexamtime(examtime);
		
		messageBox.sendToClient();
	}
	
	public void sstatusGetMessageBox_print_grade(Message messageBox)throws InterruptedException{
		
		String sID = messageBox.getData().getID();
		String year = messageBox.getData().getYear();
		
		StudentGrade sg = new StudentGrade();
		StudentGradeDB sgdb = new StudentGradeDB();
		
		sg = sgdb.selectSG(sID);
		
		String subject[] = new String[5];
		String score[] = new String[5];
		String grade[] = new String[5];
		
		sgdb.print_grade(sg, year, subject, score, grade);
		
		messageBox.getData().setsubject(subject);
		messageBox.getData().setscore(score);
		messageBox.getData().setexgrade(grade);
		
		messageBox.sendToClient();
		
		
	}
	
	
	
	
	
}
