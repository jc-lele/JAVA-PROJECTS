package vcampus;

public interface ScreenSize {
	int sWidth = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
	int sHeight = ((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
	int width = (int) (sWidth * 0.75);
	int height = (int) (sHeight * 0.85);	// 顶部面板的宽度，去掉5的窗口边界
	int tHeight = (int) (height * 0.125); // 顶部面板的高度
	int mHeight = (int) (height * 0.04); // 中部面板的高度
	int dHeight = (int) (height * 0.8); // 下部面板的高度
	int lWidth = (int) (width * 0.2); // 左部分面板宽度
	int rWidth = (int) (width * 0.8 - 1);
	int d_y = tHeight + mHeight; // 底部面板的y值
}