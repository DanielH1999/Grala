/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author danielh
 */
public class PlayersWindow extends javax.swing.JFrame {
	
	public static boolean isOpen;
	public static boolean gotPlayers;
	
	public DefaultListModel defaultListModel;
	
	public static String nombres = "";
	
	public int contador = 1;
	
	public PlayersWindow()
	{
		this.defaultListModel = new DefaultListModel();
	
		defaultListModel.addElement("Jugadores");
		nombres += "Jugadores, ";
		
		initComponents();
		
		this.setLocationRelativeTo(this);
		
		this.setSize(this.getPreferredSize());
				
		isOpen = true;
		gotPlayers = false;
		
		playerList.setModel(defaultListModel);
	}
	/**
	 * This method is called from within the constructor to initialize the form. WARNING:
	 * Do NOT modify this code. The content of this method is always regenerated by the
	 * Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        nombreTxt = new javax.swing.JTextField();
        jugadorxLbl = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        listScroll = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList<>();
        removeBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 200));
        setPreferredSize(new java.awt.Dimension(420, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel.setBackground(new java.awt.Color(153, 255, 153));
        panel.setMinimumSize(new java.awt.Dimension(400, 130));
        panel.setPreferredSize(new java.awt.Dimension(400, 150));
        panel.setRequestFocusEnabled(false);

        nombreTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreTxt.setText("Nombre del jugador");
        nombreTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreTxtFocusLost(evt);
            }
        });
        nombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTxtActionPerformed(evt);
            }
        });

        jugadorxLbl.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jugadorxLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugadorxLbl.setText("Jugador 1");

        addBtn.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        addBtn.setText("+");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        listPanel.setBackground(new java.awt.Color(102, 255, 153));

        playerList.setBackground(new java.awt.Color(153, 255, 153));
        playerList.setBorder(null);
        playerList.setFont(new java.awt.Font("Noto Sans", 2, 15)); // NOI18N
        listScroll.setViewportView(playerList);

        removeBtn.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        removeBtn.setText("-");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addComponent(removeBtn)
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addComponent(listScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeBtn)
                .addContainerGap())
        );

        closeBtn.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        closeBtn.setText("Listo");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBtn))
                    .addComponent(jugadorxLbl)
                    .addComponent(closeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugadorxLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(nombreTxt)
                        .addGap(1, 1, 1))
                    .addComponent(addBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addContainerGap())
            .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void onClose()
	{
		isOpen = false;
		
		if (gotPlayers)
		{
			MainWindow mainWindow = new MainWindow();

			mainWindow.setVisible(!isOpen);

			this.dispose();
		}
		
		else
		{
			JOptionPane.showMessageDialog(this, "No agregaste ningun jugador...", "", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static String[] getPlayers()
	{
		String[] players = nombres.split(", ");
		
		return players;
	}
	
	private void addToList()
	{
		if (!nombreTxt.getText().isEmpty())
		{
			jugadorxLbl.setText("jugador "+ (contador + 1));
			
			defaultListModel.addElement(nombreTxt.getText());
			
			nombres += nombreTxt.getText() + ", ";
			
			nombreTxt.setText("");
			
			contador++;
			
			gotPlayers = true;
		}
		else
		{
			JOptionPane.showMessageDialog(this, "nada que agregar...");
		}
	}
	
	private void removeFromList()
	{
		if (defaultListModel.getSize() > 1)
		{
			//System.out.println("removing: "+defaultListModel.lastElement()); //DEBUG
			defaultListModel.removeElement(defaultListModel.lastElement());
			nombres = defaultListModel.toString();
			nombres = nombres.replace("[", "");
			nombres = nombres.replace("]", "");
			contador--;
			jugadorxLbl.setText("jugador "+(contador));
		}
		else
		{
			JOptionPane.showMessageDialog(this, "lista de jugadores vacia...");
		}
	}
	
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        addToList();
    }//GEN-LAST:event_nombreTxtActionPerformed

    private void nombreTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreTxtFocusGained
        nombreTxt.setText("");
    }//GEN-LAST:event_nombreTxtFocusGained

    private void nombreTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreTxtFocusLost
        
		if (nombreTxt.getText().isEmpty())
		{
			nombreTxt.setText("Nombre del jugador");
		}
				
    }//GEN-LAST:event_nombreTxtFocusLost

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        addToList();
    }//GEN-LAST:event_addBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
		removeFromList();
    }//GEN-LAST:event_removeBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        onClose();
    }//GEN-LAST:event_closeBtnActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("FlatLaf Light".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PlayersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PlayersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PlayersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PlayersWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PlayersWindow().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jugadorxLbl;
    private javax.swing.JPanel listPanel;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JList<String> playerList;
    private javax.swing.JButton removeBtn;
    // End of variables declaration//GEN-END:variables
}
