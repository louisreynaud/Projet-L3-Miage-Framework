package csi.grp6;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import in.ui.Homechat;

public final class Program {
	private static void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
		}
	}

	public static void main(String[] args) throws IOException {
		setSystemLookAndFeel();
		new Homechat().setVisible(true);

	}
}
