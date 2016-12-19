package snakegamePackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameSnake extends JFrame implements Constantes{
	
	private JPanel contentPane;
	private Modele modele;
	
	/*LAUNCHER*/
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					FrameSnake frameSnake = new FrameSnake();
					frameSnake.setVisible(true);
					frameSnake.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	/*CONSTRUCTEUR*/
	public FrameSnake() {
		this.modele = new Modele();
		
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300,300,455, 480);	
		
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				FrameSnake.this.modele.affichage(g);
			}
		};
		contentPane.setBackground(Color.BLACK);
		contentPane.setPreferredSize(new Dimension(
								NBRE_DE_COLONNES * CASE_EN_PIXEL,
								NBRE_DE_LIGNES * CASE_EN_PIXEL ));
		
		setContentPane(contentPane);
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				FrameSnake.this.modele.gestionDuClavier(e);				
			}
		});
		setFocusable(false);
		contentPane.setFocusable(true);
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					FrameSnake.this.modele.calcul();
					contentPane.repaint();
					try{
						Thread.sleep(FrameSnake.this.modele.getTemporisation());
					}catch(InterruptedException e){
						
					}
				}
			}
		});
		thread.start();
		
	}
	

}
