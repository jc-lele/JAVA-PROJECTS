package vcampus.server.loginhandle;

import vcampus.Message;
import vcampus.database.classtype.Student;
import vcampus.database.classtype.Teacher;
import vcampus.database.classtype.User;
import vcampus.database.database.StudentDB;
import vcampus.database.database.TeacherDB;
import vcampus.database.database.UserDB;

public class LoginHandle {
	public void logGetMessageBox(Message messageBox) throws InterruptedException{
		
		String UserStr = messageBox.getData().getID();
		String PassStr = messageBox.getData().getPassword();
		
		UserDB userdb = new UserDB();
		User user = new User();
		user = userdb.selectUser(UserStr);
		
		StudentDB sdb = new StudentDB();
		Student student = new Student();
		student = sdb.selectStudent(UserStr);
		
		TeacherDB tdb = new TeacherDB();
		Teacher teacher = new Teacher();
		teacher = tdb.selectTeacher(UserStr);
		
		
		if(student != null) {										//判断是否是学生
			if(student.getPassword() != null) {
				
				messageBox.getData().setName(student.getName());   	//返回学生名字
				messageBox.getData().setSex(student.getSex());		//返回性别
				messageBox.getData().setDepartment(student.getMajor());;//返回部门
				messageBox.getData().setPolityStatus(student.getPoliStatus());//返回政治面貌
				messageBox.getData().setNationality(student.getNationality());//返回民族
				messageBox.getData().setMail(student.getEmailAddress());//返回邮箱
				messageBox.getData().setID(student.getsID());//返回学号
				
			}
		}
		
		if(teacher != null) {										//判断是否是老师
			if(teacher.getPassword() != null) {
				messageBox.getData().setName(teacher.getName());//名字
				messageBox.getData().setSex(teacher.getSex());//性别
				messageBox.getData().setNationality(teacher.getNationality());//民族
				messageBox.getData().setMail(teacher.getEmailAddress());//邮箱
				messageBox.getData().setPolityStatus(teacher.getPoliStatus());//政治面貌
				messageBox.getData().setDepartment(teacher.getDepartment());//部门
				messageBox.getData().setID(teacher.getTeacherID());//返回账号
			}
		}
		
		
		if(user != null) {
			if(user.getPassword() == null) {
				messageBox.getData().setIsAssigned(0);
			}
			else {
				if(PassStr.equals(user.getPassword())) {
					messageBox.setWho(user.getWho());
					messageBox.setIsCompleted(1);
					messageBox.getData().setIsAssigned(1);
				}else messageBox.setIsCompleted(0); messageBox.getData().setIsAssigned(1);
			}
		}
		if(user == null) {
			messageBox.setIsCompleted(0);
			messageBox.getData().setIsAssigned(1);
		}
		messageBox.sendToClient();
	}
}
