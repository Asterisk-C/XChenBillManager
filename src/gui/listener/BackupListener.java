package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class BackupListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		BackupPanel p = BackupPanel.getInstance();
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if(mysqlPath.length() == 0)
		{
			JOptionPane.showMessageDialog(p, "Please set up mysql path before backup");
			MainPanel.getInstance().workingPanel.show(ConfigPanel.getInstance());
			ConfigPanel.getInstance().tfMysqlPath.grabFocus();
			return;
		}
		JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("xchenbillmanager.sql"));
        fc.setFileFilter(new FileFilter() {
             
            @Override
            public String getDescription() {
                return ".sql";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });
        int returnVal =  fc.showSaveDialog(p);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //如果保存的文件名没有以.sql结尾，自动加上.sql
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(),file.getName()+".sql");
            System.out.println(file);
             
           try {
               MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
               JOptionPane.showMessageDialog(p, "Backup successful, backup file locates at:\r\n"+file.getAbsolutePath());
           } catch (Exception e1) {
               e1.printStackTrace();
               JOptionPane.showMessageDialog(p, "Backup failure\r\n, error:\r\n"+e1.getMessage());  
           }
             
        }     
	}

}
