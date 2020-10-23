package com.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/17 19:05
 * Remark:
 */
public class DimensionUtil {
	public static Rectangle getBounds() {
		// 点击缩小之后的大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 屏幕边界
		Insets screenInsets=Toolkit.getDefaultToolkit().getScreenInsets(new JFrame().getGraphicsConfiguration());
		final Rectangle frameBounds=new Rectangle(
				screenInsets.left, screenInsets.top,
				screenSize.width-screenInsets.left-screenInsets.right,
				screenSize.height-screenInsets.top-screenInsets.bottom);
		return frameBounds;
	}
}
