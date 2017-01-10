package cz.rm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Main
 *
 * @author Daniel.Kec
 * @since 10.1.2017
 */
public class Main {
    public static void main(String[] args) throws IOException, AWTException {
        // Add system tray icon
        final SystemTray systemTray = SystemTray.getSystemTray();
        BufferedImage icon = ImageIO.read(Main.class.getResourceAsStream("/images/trayIcon.png"));
        final TrayIcon trayIcon = new TrayIcon(icon.getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING), "Tooltip");

        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                trayIcon.displayMessage("Ahoj svete", "I have to correct my question, in fact, after testing it a little bit longer, it automatically fades out after, let's say, 7-8 seconds but I find it a little bit too long. Also, it only disappears if the user is executing an action (moving the mouse or typing on the keyboard)", TrayIcon.MessageType.INFO);
            }
        });

        PopupMenu popupMenu = new PopupMenu();
        MenuItem itemRestart = new MenuItem("Restart");
        itemRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //init();
                trayIcon.displayMessage("Ahoj svete", "I have to correct my question, in fact, after testing it a little bit longer, it automatically fades out after, let's say, 7-8 seconds but I find it a little bit too long. Also, it only disappears if the user is executing an action (moving the mouse or typing on the keyboard)", TrayIcon.MessageType.INFO);
            }
        });
        popupMenu.add(itemRestart);

        // Add menu
        MenuItem itemExit = new MenuItem("Exit");
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //scheduledExecutorService.shutdown();
                systemTray.remove(trayIcon);
            }
        });
        popupMenu.add(itemExit);

        trayIcon.setPopupMenu(popupMenu);
        systemTray.add(trayIcon);
        trayIcon.setImageAutoSize(true);
        //trayIcon.displayMessage("Программа диагностики запущена", "", TrayIcon.MessageType.INFO);

        trayIcon.displayMessage("Ahoj svete2","text 2", TrayIcon.MessageType.INFO);
    }
}
