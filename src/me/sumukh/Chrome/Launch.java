package me.sumukh.Chrome;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import me.sumukh.start.Main;

public class Launch {
	
	Runtime run = Runtime.getRuntime();

	public Launch(String name , String num) throws Exception {
		
		
		
		openChrome(name , num);
		
	}
	
	public void openChrome(String name , String num) throws Exception{
		
		String[] chrome = new String[]{"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","https://web.whatsapp.com/send?phone=91"+num+"&text=Happy%20Birthday%20"+name+"%20!!%20%F0%9F%A5%B3%F0%9F%A5%B3&type=phone_number&app_absent=0"};

		
		Runtime run = Runtime.getRuntime();
		try {
			
		run.exec(chrome);
		Thread.sleep(12000);
		Type();
			
		} catch(IOException e){
			
			JOptionPane.showMessageDialog(null, "Chrome Cannot Be Launch", "Error", JOptionPane.ERROR_MESSAGE);
			run.exit(1);
		}
	}
	
	public void Type() throws Exception {
		
		Robot robot = new Robot();
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep((long) 8.64e+7);
		
		new Main();
	}
	

}
