package GUI;

import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * @author Daniel Gaspar Arroyo Herrero
 */

public class MainWindow extends javax.swing.JFrame {
	
	public static Generala generala = new Generala(PlayersWindow.getPlayers()); 
	
	public DefaultTableModel tableModel;
	
	public Object[][] tableBody;
	
	public MainWindow()
	{		
		generala.jugadores = PlayersWindow.getPlayers();
		
		generala.jugadores = new String[] {"Jugadores","debug"}; //DEBUG
		
		generala.tablaPuntajes = new int[generala.jugadores.length][generala.tituloPuntajes.length];
		
		//System.out.println("players = "+Arrays.toString(generala.jugadores)); //DEBUG
		
		
		tableBody = new Object[generala.tituloPuntajes.length][generala.jugadores.length+1];
		
		for (int i = 0; i < generala.tituloPuntajes.length-1; i++)
		{
			for (int j = 1; j < generala.jugadores.length+1; j++)
			{
				tableBody[i][j] = 0;
			}
			tableBody[i][0] = generala.tituloPuntajes[i+1];
		}
		
		this.tableModel = new DefaultTableModel(tableBody, generala.jugadores);
		
		initComponents();
		this.setLocationRelativeTo(this);
		this.setMinimumSize(this.getPreferredSize());
	}
	
	int contadorJugadas = 0;
	int jugador = 1;
	int turno = 0;
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        dicePanel = new javax.swing.JPanel();
        dice1 = new javax.swing.JLabel();
        dice2 = new javax.swing.JLabel();
        dice3 = new javax.swing.JLabel();
        dice4 = new javax.swing.JLabel();
        dice5 = new javax.swing.JLabel();
        holderPanel = new javax.swing.JPanel();
        holder1 = new javax.swing.JLabel();
        holder2 = new javax.swing.JLabel();
        holder3 = new javax.swing.JLabel();
        holder4 = new javax.swing.JLabel();
        holder5 = new javax.swing.JLabel();
        tirar = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        scrollableContainer = new javax.swing.JScrollPane();
        tablaPuntajes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        leftPanel.setBackground(new java.awt.Color(0, 255, 153));

        dicePanel.setBackground(new java.awt.Color(0, 255, 153));
        dicePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dice1.setBackground(new java.awt.Color(255, 255, 255));
        dice1.setForeground(new java.awt.Color(255, 255, 255));
        dice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dice1.setMaximumSize(new java.awt.Dimension(50, 50));
        dice1.setMinimumSize(new java.awt.Dimension(50, 50));
        dice1.setPreferredSize(new java.awt.Dimension(50, 50));
        dice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice1MouseClicked(evt);
            }
        });
        dicePanel.add(dice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        dice2.setBackground(new java.awt.Color(255, 255, 255));
        dice2.setForeground(new java.awt.Color(255, 255, 255));
        dice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dice2.setMaximumSize(new java.awt.Dimension(50, 50));
        dice2.setMinimumSize(new java.awt.Dimension(50, 50));
        dice2.setPreferredSize(new java.awt.Dimension(50, 50));
        dice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice2MouseClicked(evt);
            }
        });
        dicePanel.add(dice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, -1));

        dice3.setBackground(new java.awt.Color(255, 255, 255));
        dice3.setForeground(new java.awt.Color(255, 255, 255));
        dice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dice3.setMaximumSize(new java.awt.Dimension(50, 50));
        dice3.setMinimumSize(new java.awt.Dimension(50, 50));
        dice3.setPreferredSize(new java.awt.Dimension(50, 50));
        dice3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice3MouseClicked(evt);
            }
        });
        dicePanel.add(dice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        dice4.setBackground(new java.awt.Color(255, 255, 255));
        dice4.setForeground(new java.awt.Color(255, 255, 255));
        dice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dice4.setMaximumSize(new java.awt.Dimension(50, 50));
        dice4.setMinimumSize(new java.awt.Dimension(50, 50));
        dice4.setPreferredSize(new java.awt.Dimension(50, 50));
        dice4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice4MouseClicked(evt);
            }
        });
        dicePanel.add(dice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        dice5.setBackground(new java.awt.Color(255, 255, 255));
        dice5.setForeground(new java.awt.Color(255, 255, 255));
        dice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dice5.setMaximumSize(new java.awt.Dimension(50, 50));
        dice5.setMinimumSize(new java.awt.Dimension(50, 50));
        dice5.setPreferredSize(new java.awt.Dimension(50, 50));
        dice5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dice5MouseClicked(evt);
            }
        });
        dicePanel.add(dice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        holderPanel.setBackground(new java.awt.Color(0, 255, 153));

        holder1.setBackground(new java.awt.Color(255, 255, 255));
        holder1.setForeground(new java.awt.Color(255, 255, 255));
        holder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        holder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/diceHolder.png"))); // NOI18N
        holder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                holder1MouseClicked(evt);
            }
        });

        holder2.setBackground(new java.awt.Color(255, 255, 255));
        holder2.setForeground(new java.awt.Color(255, 255, 255));
        holder2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        holder2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/diceHolder.png"))); // NOI18N
        holder2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                holder2MouseClicked(evt);
            }
        });

        holder3.setBackground(new java.awt.Color(255, 255, 255));
        holder3.setForeground(new java.awt.Color(255, 255, 255));
        holder3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        holder3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/diceHolder.png"))); // NOI18N
        holder3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                holder3MouseClicked(evt);
            }
        });

        holder4.setBackground(new java.awt.Color(255, 255, 255));
        holder4.setForeground(new java.awt.Color(255, 255, 255));
        holder4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        holder4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/diceHolder.png"))); // NOI18N
        holder4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                holder4MouseClicked(evt);
            }
        });

        holder5.setBackground(new java.awt.Color(255, 255, 255));
        holder5.setForeground(new java.awt.Color(255, 255, 255));
        holder5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        holder5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/diceHolder.png"))); // NOI18N
        holder5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                holder5MouseClicked(evt);
            }
        });

        tirar.setBackground(new java.awt.Color(0, 153, 102));
        tirar.setFont(new java.awt.Font("Nimbus Sans", 0, 18)); // NOI18N
        tirar.setForeground(new java.awt.Color(255, 255, 255));
        tirar.setText("Tirar (3)");
        tirar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tirar.setIconTextGap(0);
        tirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tirarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout holderPanelLayout = new javax.swing.GroupLayout(holderPanel);
        holderPanel.setLayout(holderPanelLayout);
        holderPanelLayout.setHorizontalGroup(
            holderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holderPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(holderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(holderPanelLayout.createSequentialGroup()
                        .addComponent(holder2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(holder3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(holder4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tirar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(holder5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        holderPanelLayout.setVerticalGroup(
            holderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, holderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tirar)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(holderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(holder1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(holder2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(holder3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(holder4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(holder5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(holderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(holderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));

        scrollableContainer.setForeground(new java.awt.Color(255, 255, 255));

        tablaPuntajes.setModel(tableModel);
        tablaPuntajes.setToolTipText("tabla de puntuaciones");
        tablaPuntajes.setEnabled(false);
        tablaPuntajes.setRowHeight(25);
        tablaPuntajes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollableContainer.setViewportView(tablaPuntajes);

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollableContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	public int takenHolders = 0;

    private void dice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice1MouseClicked
		swapDice(dice1, holder1, 1);
    }//GEN-LAST:event_dice1MouseClicked

    private void dice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice2MouseClicked
		swapDice(dice2, holder2, 2);
    }//GEN-LAST:event_dice2MouseClicked

    private void dice3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice3MouseClicked
		swapDice(dice3, holder3, 3);
    }//GEN-LAST:event_dice3MouseClicked

    private void dice4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice4MouseClicked
		swapDice(dice4, holder4, 4);
    }//GEN-LAST:event_dice4MouseClicked

    private void dice5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dice5MouseClicked
		swapDice(dice5, holder5, 5);
    }//GEN-LAST:event_dice5MouseClicked

    private void holder5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holder5MouseClicked
		swapDice(dice5, holder5, 5);
    }//GEN-LAST:event_holder5MouseClicked

    private void holder4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holder4MouseClicked
		swapDice(dice4, holder4, 4);
    }//GEN-LAST:event_holder4MouseClicked

    private void holder3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holder3MouseClicked
		swapDice(dice3, holder3, 3);
    }//GEN-LAST:event_holder3MouseClicked

    private void holder2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holder2MouseClicked
		swapDice(dice2, holder2, 2);
    }//GEN-LAST:event_holder2MouseClicked

    private void holder1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holder1MouseClicked
		swapDice(dice1, holder1, 1);
    }//GEN-LAST:event_holder1MouseClicked

    private void tirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tirarActionPerformed
		turno++;
		//System.out.println("turno = "+turno); //DEBUG
		
		tirar.setText("Tirar ("+(generala.turnos-turno)+")");
		
		JLabel[] holderList = {holder1, holder2, holder3, holder4, holder5};
		JLabel[] diceList = {dice1, dice2, dice3, dice4, dice5};
		
		evaluatePlays(jugador);
		
		tirarDados();
		
		//poner los iconos de los dados en pantalla
		setDiceIcons(diceList);
		
		//al terminar los turnos, pasar todos los dados a los holders
		finishTurn(diceList, holderList);
		
		
    }//GEN-LAST:event_tirarActionPerformed
	
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainWindow().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dice1;
    private javax.swing.JLabel dice2;
    private javax.swing.JLabel dice3;
    private javax.swing.JLabel dice4;
    private javax.swing.JLabel dice5;
    private javax.swing.JPanel dicePanel;
    private javax.swing.JLabel holder1;
    private javax.swing.JLabel holder2;
    private javax.swing.JLabel holder3;
    private javax.swing.JLabel holder4;
    private javax.swing.JLabel holder5;
    private javax.swing.JPanel holderPanel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JScrollPane scrollableContainer;
    private javax.swing.JTable tablaPuntajes;
    private javax.swing.JButton tirar;
    // End of variables declaration//GEN-END:variables
	
	private void tirarDados()
	{		
		generala.dados = generala.lanzar(generala.dados.length); //tirar 5 dados

		for (int index = 0; index < generala.dados.length; index++)
		{
			if (generala.guardados[index] != 0) //si el dado fue guardado
			{
				generala.dados[index] = 0; //vaciar su posicion
			}
		}
	}
	
	private void setDiceIcons(JLabel[] dice)
	{		
		for (int i = 0; i < generala.dados.length; i++)
		{
			if (generala.dados[i] > 0)
			{
				dice[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/d"+generala.dados[i]+".png")));
			}
			else
			{
				dice[i].setIcon(null);
			}
		}
	}
	
	private boolean hasIcon(JLabel label)
	{
		if (label.getIcon() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private boolean isHolding(JLabel holder)
	{
		if (holder.getIcon().toString().equals("file:/home/danielh/Documentos/Programs/java/netbeans/Grala/build/classes/Pictures/diceHolder.png"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private void setHolderIcon(JLabel holder)
	{
		holder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/diceHolder.png")));
	}
	
	private void guardar(int index)
	{
		index--;
		
		//System.out.println("\nguardado: dado "+index+"\n"); //DEBUG
		
		generala.guardados[index] = generala.dados[index];
		generala.dados[index] = 0;
	}
	
	private void descartar(int index)
	{
		index--;
		
		//System.out.println("\ndevuelto: dado "+index+"\n"); //DEBUG
		
		generala.dados[index] = generala.guardados[index];
		generala.guardados[index] = 0;
	}
	
	private void changeButton()
	{
		if (takenHolders == 5)
		{
			tirar.setText("Puntuar");
		}
		else
		{
			tirar.setText("Tirar ("+(generala.turnos-turno)+")");
		}
	}
	
	private void evaluatePlays(int jugador)
	{
		if (takenHolders == 5)
		{
			//System.out.println("evaluating: "+Arrays.toString(generala.guardados)); //DEBUG
			generala.calcularJugadas(generala.jugadasPosibles, generala.guardados, turno);
			
			this.setFocusable(false);
			
			SelectionWindow selectionWindow = new SelectionWindow(this);
			selectionWindow.jugador = jugador;
			selectionWindow.turno = turno;
			selectionWindow.setVisible(true);
		}
	}

	private void getWinner() {
		if (contadorJugadas == 10 * (generala.jugadores.length - 1))
		{
			String WINNER = generala.jugadores[generala.determinarGanador(generala.jugadores, generala.tablaPuntajes)];
			JOptionPane.showMessageDialog(this, WINNER+" gano la partida!", "felicitaciones", JOptionPane.INFORMATION_MESSAGE);
			tirar.setVisible(false);
		}
	}

	private void finishTurn(JLabel[] diceList, JLabel[] holderList)
	{
		if (generala.turnos - turno == 0)
		{
			for (int i = 0; i < diceList.length; i++)
			{
				if (!isHolding(holderList[i]))
				{
					swapDice(diceList[i], holderList[i], i+1);
				}
			}
			evaluatePlays(jugador);
		}
	}
	
	public void clearDice()
	{
		JLabel[] diceList = {dice1, dice2, dice3, dice4, dice5};
		JLabel[] holderList = {holder1, holder2, holder3, holder4, holder5};
		
		for (int i = 0; i < generala.dados.length; i++)
		{
			generala.guardados[i] = 0;
			generala.dados[i] = 0;
			
			takenHolders -= takenHolders;
			
			setHolderIcon(holderList[i]);
		}
		
		setDiceIcons(diceList);
		
		//System.out.println("interfaz limpia: "+Arrays.toString(generala.dados)+" "+Arrays.toString(generala.guardados)); //DEBUG
		
		changeButton();
	}
	
	private void swapDice(JLabel dice, JLabel holder, int index)
	{
		if (hasIcon(dice))
		{
			guardar(index);
			takenHolders++;
			holder.setIcon(dice.getIcon());
			dice.setIcon(null);
		}
		else if (isHolding(holder))
		{
			descartar(index);
			takenHolders--;
			dice.setIcon(holder.getIcon());
			setHolderIcon(holder);
		}
		
		changeButton();

		//System.out.println("\ndice:\t"+Arrays.toString(generala.dados)); //DEBUG
		//System.out.println("saved:\t"+Arrays.toString(generala.guardados)); //DEBUG
	}
	
	public void updateScoreboard(int value, int row, int column)
	{
		String tachado = "[tachado]";
		
		//System.out.println("MainWindow entering "+value+" in the table"); //DEBUG

		if (value < 0)
		{
			tableModel.setValueAt(tachado, row, column);
		}
		else
		{
			tableModel.setValueAt(value, row, column);
		}
		
		
		int newTotal = 0;
		
		for (int i = 0; i < 10; i++)
		{
			if (!tableModel.getValueAt(i, column).equals(tachado))
			{
				newTotal += (int) tableModel.getValueAt(i, column);
			}
		}
		
		tableModel.setValueAt(newTotal, 10, column);
		
		//System.out.println(value+" insertado en (C"+column+", F"+(row+1)+")"); //DEBUG
		
		//System.out.println("jugador actual: "+generala.jugadores[jugador]); //DEBUG
		
		if (jugador < generala.jugadores.length-1)
		{
			jugador++;
		}
		else
		{
			jugador = 1;
		}
		turno = 0;
		contadorJugadas++;
		
		getWinner(); //cuando termina la partida
		
		//System.out.println("turno vuelve a 0 para "+generala.jugadores[jugador]); //DEBUG
		
		//System.out.println("cambiado a: "+generala.jugadores[jugador]); //DEBUG
	}
}
