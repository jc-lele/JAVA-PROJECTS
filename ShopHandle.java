package vcampus.server.shophandle;

import vcampus.Message;
import vcampus.database.classtype.Goods;
import vcampus.database.classtype.StudentGoods;
import vcampus.database.database.GoodsDB;
import vcampus.database.database.StudentGoodsDB;

public class ShopHandle {
	public void shopGetMessageBox_print_goods(Message messageBox)throws InterruptedException{
		
		GoodsDB gdb = new GoodsDB();
		
		String goods[] = new String[15];
		String value[] = new String[15];
		String gid[] = new String[15];
		
		gdb.showGoods(goods, value, gid);
		
		messageBox.getData().setgoods(goods);
		messageBox.getData().setvalue(value);
		messageBox.getData().setgid(gid);
		
		messageBox.sendToClient();
	}
	
	public void shopGetMessageBox_add(Message messageBox)throws InterruptedException{
		
		String goodsID = messageBox.getData().getgoodsID();
		String sID = messageBox.getData().getID();
		
		Goods goods = new Goods();
		GoodsDB gdb = new GoodsDB();
		
		goods = gdb.selectGoods(goodsID);
		
		StudentGoodsDB sgdb = new StudentGoodsDB();
		
		sgdb.addGoods(sID, goods);
		
		messageBox.sendToClient();

	}
	
	public void shopGetMessageBox_delete(Message messageBox)throws InterruptedException{
		
		String goodsID = messageBox.getData().getgoodsID();
		String sID = messageBox.getData().getID();
		
		StudentGoods sg = new StudentGoods();
		StudentGoodsDB sgdb = new StudentGoodsDB();
		
		sg = sgdb.selectSG(sID, goodsID);
		
		sgdb.deleteGoods(sg);
		
		messageBox.sendToClient();
	}
	
	
	public void shopGetMessageBox_print_person_car(Message messageBox)throws InterruptedException{
		
		String sID = messageBox.getData().getID();
		
		StudentGoodsDB sgdb = new StudentGoodsDB();
		
		String goodscar[] = new String[15];
		String valuecar[] = new String[15];
		
		sgdb.print_person_goods(sID, goodscar, valuecar);
		
		messageBox.getData().setgoodscar(goodscar);
		messageBox.getData().setvaluecar(valuecar);
		
		messageBox.sendToClient();
		
	}

}
