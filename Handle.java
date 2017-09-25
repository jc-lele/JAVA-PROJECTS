package vcampus.server.handle;

import vcampus.Message;
import vcampus.server.choosecoursehandle.ChooseCourseHandle;
import vcampus.server.libraryhandle.LibraryHandle;
import vcampus.server.loginhandle.LoginHandle;
import vcampus.server.shophandle.ShopHandle;
import vcampus.server.sighuphandle.SighUpHandle;
import vcampus.server.sstatushandle.SstatusHandle;
import vcampus.server.sumhandle.SumHandle;
import vcampus.server.superusermanage.SuperUserHandle;
import vcampus.server.tstatushandle.TstatusHandle;
import vcampus.server.userManage.UserHandle;

public class Handle {
		public void getMessageBox(Message messageBox) throws InterruptedException {							//分别给下面的类建一个包，父包为server
			
			if(messageBox.getData().getOrder().equals("01")) {
				(new LoginHandle()).logGetMessageBox(messageBox);
			}
			if(messageBox.getData().getOrder().equals("03")) {
				new UserHandle().UserGetMessageBox(messageBox);
			}
			if(messageBox.getData().getOrder().equals("02")) {
				new SighUpHandle().sighUpGetMessageBox(messageBox);
			}
			//System.out.println("服务器的messageBox："+messageBox.getData().getID());
			if(messageBox.getData().getOrder().equals("09")) {
				new SuperUserHandle().SuperUserGetMessageBox_add(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("10")) {
				new SuperUserHandle().SuperUserGetMessageBox_delete(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("27")) {
				new SstatusHandle().sstatusGetMessageBox_print_exam(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("26")) {
				new SstatusHandle().sstatusGetMessageBox_print_grade(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("32")) {
				new TstatusHandle().tstatusGetMessageBox_print_grade(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("33")) {
				new TstatusHandle().tstatusGetMessageBox_update_grade(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("34")) {
				new SumHandle().SumGetMessageBox(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("35")) {
				new ChooseCourseHandle().chooseCourseGetMessageBox_add(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("36")) {
				new ChooseCourseHandle().chooseCourseGetMessageBox_delete(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("37")) {
				new ChooseCourseHandle().chooseCourseGetMessageBox_show(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("25")) {
				new ChooseCourseHandle().chooseCourseGetMessageBox_print_scourse(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("20")) {
				new ShopHandle().shopGetMessageBox_print_goods(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("38")) {
				new ShopHandle().shopGetMessageBox_add(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("39")) {
				new ShopHandle().shopGetMessageBox_delete(messageBox);
			}
			
			if(messageBox.getData().getOrder().equals("40")) {
				new ShopHandle().shopGetMessageBox_print_person_car(messageBox);
			}
			String order = messageBox.getData().getOrder();
			System.out.println("handle--"+order);
			if(order.equals("04")||order.equals("05")||order.equals("07")||order.equals("08")){
				(new LibraryHandle()).libGetMessageBox(messageBox);					//图书馆的相关模块放在类LibraryHandle中
			}
		}
}
