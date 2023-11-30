
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Systemtray {
	
	TrayIcon icon;
	
	
	public Systemtray() throws AWTException, IOException{
		
		this.setup();

    }
	
	private void setup() throws AWTException, IOException {
		
		SystemTray tray = SystemTray.getSystemTray();
		Image image = ImageIO.read(new File("zaka.jpeg"));
        PopupMenu popupmenu = new PopupMenu();
        icon = new TrayIcon(image,"デスクトップマスコット",popupmenu);
        
        icon.setImageAutoSize(true);
        
        
        
        MenuItem item1 = new MenuItem("移動開始");
        item1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	Main.moveStartMain();
                System.out.println("移動開始");
            }
        });
        
        MenuItem item2 = new MenuItem("移動停止");
        item2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	Main.moveStopMain();
                System.out.println("移動停止");
            }
        });

        MenuItem item3 = new MenuItem("プログラム終了");
        item3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//システムトレイを閉じる
                tray.remove(icon);
                System.out.println("システムトレイ閉じる");
                System.exit(0);
                
            }
        });
        
        
        popupmenu.add(item1);
        popupmenu.add(item2);
        popupmenu.add(item3);
        
        tray.add(icon);
	}

}
