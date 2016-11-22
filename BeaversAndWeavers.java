//Anjan Amarnath & Matt Crooks
//05-15-15
//Beavers and Weavers
//Introduction to Java Programming Final Project 



import java.awt.*;//import all the libraries needed
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;

	public class BeaversAndWeavers extends JFrame //start out with a jframe
	{
		public Holder p;
		public static void main(String[] args)
		{
			BeaversAndWeavers g = new BeaversAndWeavers();
		}
	
		public BeaversAndWeavers()
		{
			super("Beavers and Weavers");
            setSize(1500,1000); //fit the entire screen 
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocation(0,0); //set location to 0,0
            setResizable(true); //this will not be resizable
            p = new Holder();
            add(p);
			setContentPane(p); 
            setVisible(true); // set visible to true
        }
	
	


		class Holder extends JPanel{
			public CardLayout card;
			public StartCard start;
			public Rules gameInfo;
			public GameCard1 gamecard1; 
			public Fail fail;
			public QuestionPanel1 qp1;
			public GameCard2 gamecard2;
			public QuestionPanel2 qp2;
			public GameCard3 gamecard3;
			public GameCard4 gamecard4;
			public GameCard5 gamecard5;
			public QuestionPanel3 qp3;
			public QuestionPanel4 qp4;
			public QuestionPanel5 qp5;
		
			public Holder(){
				card= new CardLayout();
				setLayout(card);
				start = new StartCard();
				gameInfo = new Rules();
				gamecard1 = new GameCard1();
				fail = new Fail();
				qp1 = new QuestionPanel1();
				gamecard2=new GameCard2();
				qp2 = new QuestionPanel2();
				gamecard3 = new GameCard3();
				gamecard4 = new GameCard4();
				gamecard5 = new GameCard5();
				qp3 = new QuestionPanel3();
				qp4 = new QuestionPanel4();
				qp5 = new QuestionPanel5();
				add(start, "Start"); //make card layout for all the different possible panels there will be
				add(gameInfo, "gameInfo");
				add(gamecard1, "Game Card1");
				add(fail, "Fail");
				add(qp1, "qp1");
				add(gamecard2, "Game Card2");
				add(qp2, "qp2");
				add(gamecard3, "Game Card3");
				add(gamecard4, "Game Card4");
				add(gamecard5, "Game Card5");
				add(qp3, "qp3");
				add(qp4, "qp4");
				add(qp5, "qp5");
			}
	

			class StartCard extends JPanel{

				private JPanel Start1; //make 5 panels for the 5 parts to border layout
				private JPanel Start2;
				private JPanel Start3;
				private JPanel Start4;
				private JPanel Start5;
				private boolean pressed;
				private boolean pushed;
	
				public StartCard()
				{
					setLayout(new BorderLayout());
    
	
					Start1 title = new Start1();
					Start2 rules = new Start2();
					Start3 startGame = new Start3();
					Start4 mainRiver = new Start4();
					Start5 author = new Start5();

					add(title, BorderLayout.NORTH);
					add(rules, BorderLayout.WEST);
					add(startGame, BorderLayout.EAST);
					add(mainRiver, BorderLayout.CENTER);
					add(author, BorderLayout.SOUTH);
	
				}
				public void paintComponent(Graphics g){
					setBackground(Color.GREEN);
					super.paintComponent(g);
	
				}//make the first panel border layout and put in the different components
//refer to nick.java on how to make border layout and all the visibilities for the card layout
	

	

		//1st PANEL (TITLE SCREEN)	
		
				class Start1 extends JPanel{//border layout north is the name of the game
					JLabel title;
					public Start1(){
					}
					public void paintComponent(Graphics g){
						title = new JLabel("BEAVERS AND WEAVERS");
						title.setHorizontalAlignment(JLabel.CENTER);
						add(title);
						title.setFont(new java.awt.Font("Serif", 1, 100)); //make a new font that is size 20 and bold
				
					
						}
				}
			
				class Start2 extends JPanel implements ActionListener{
					JButton rulesButton;
			
					public Start2(){
						rulesButton = new JButton("              Rules              ");

						add(rulesButton);
						rulesButton.addActionListener(this);
					}	
			
					public void paintComponent(Graphics g){
						setBackground(Color.GREEN);
						super.paintComponent(g);
					}
				
					public void actionPerformed(ActionEvent evt){
						if(evt.getSource()== rulesButton);
							pressed = true;//says whether button has been pressed or not
						if(pressed) 
							card.show(p, "gameInfo"); //next card is the GameInformation panel

					}		
				}
		
				class Start3 extends JPanel implements ActionListener{
					JButton startGame;
					public Start3(){
						startGame = new JButton("              Start Game              ");
						add(startGame);
						startGame.addActionListener(this);
					}
			
					public void paintComponent(Graphics g){
						setBackground(Color.GREEN);
						super.paintComponent(g);
					}
				
					public void actionPerformed(ActionEvent evt){
						if(evt.getSource()== startGame); //says whether button has been pressed or not
							pushed=true;
						if(pushed)
							card.show(p, "Game Card1"); //card with first gameplay panel
					}
				}
			
				class Start4 extends JPanel {
					public Start4(){
				
					}
			
					public void paintComponent(Graphics g){
						super.paintComponent(g);
						Image beaver = Toolkit.getDefaultToolkit().getImage("Beaver.jpg");
						g.drawImage(beaver, 0, 0, 1150, 900, this); 
					}		
			 
				}
						 
				 class Start5 extends JPanel {
					 JLabel by;
					 JLabel anjan;
					 JLabel matt;
					 
					 public Start5(){
						 by = new JLabel("Created by: ");
						 anjan = new JLabel("Anjan Amarnath,");
						 matt = new JLabel("Matthew Crooks");
						 add(by);
						 add(anjan);
						 add(matt);
					 }
					 
					public void paintComponent (Graphics g){
						setBackground(Color.GREEN);
						super.paintComponent(g);
					}
					
				}
			}

			class Rules extends JPanel implements ActionListener{
				JButton gameInfoBack;
				JTextArea info;
				boolean clicked;
				
				public Rules(){
					info = new JTextArea("Beavers and Weavers: Rules \n \n Objective: The goal of the game is to navigate the beaver across the river to the other side(the top of the screen). \n Once you reach the other side, a question regarding ecology will apear. If the answer is answered correctly you will be able to move on to the next level. \n \n Rules: \n 1. Press the start button from the home screen to start game. \n 2. Use the arrow keys to move the boat. Move around the logs and damns in the river using the arrow keys. \n 4. If you crash into an obstacle, restart the level. \n 5. After you reach the other side, answer a question correctly to proceed to the next level. \n 6. If you answer the question incorrectly, you will restart that level. \n 7. Have Fun! ", 10, 10);
					info.setFont(new Font("Comic Sans MS", 2, 20));
					add(info);
					gameInfoBack = new JButton("Return to Home Screen");
					gameInfoBack.addActionListener(this);
					add(gameInfoBack);
				}
				
				public void paintComponent(Graphics g){
					super.paintComponent(g);
				}
				
				public void actionPerformed(ActionEvent evt){
					if(evt.getSource() == gameInfoBack); //says whether button has been pressed or not
						clicked=true;
					if(clicked)    
						card.show(p, "Start"); // next card is the homeScreen Panel                                    
				}
			}

	/*class GameCard1 extends JPanel implements KeyListener, MouseListener, FocusListener{

	 int a=(int)(Math.random()*2+200);
	 int b=(int)(Math.random()*2+200);
	 int x1=0;
	 int x2=0;
	 int x3=0;
	 int x4=0;
	 int x5=0;
	 int x6=0;
	 int x7=0;
	 int x8=0;
	 int y1=0;
	 int y2=0;
	 int y3=0;
	 int y4=0;
	 int y5=0;
	 int y6=0;
	 int y7=0;
	 int y8=0;	 
	 int ovalx=0;
	 int ovaly=0;
	 int [][] values = new int[10][2];
	//position for the boat
	 int z;		
	 
	 public GameCard1(){//add in pseudocode for the math.random position of the obstacles
		addKeyListener(this);
		addMouseListener(this);
		addFocusListener(this);
		for(int i=0; i<10; i++)
		{
			a=(int)(Math.random()*800+200);
			b=(int)(Math.random()*800+200);
			values[i][0]=a;
			values[i][1]=b;
		
		}
 }
 
	 	 public void paintComponent (Graphics g){
			super.paintComponent(g);
			Color boat = new Color(100,60,0);
			int[] x ={x1+440,x2+480,x3+490,x4+500,x5+540,x6+500,x7+490,x8+480};
			int[] y ={y1+900,y2+770,y3+760,y4+770,y5+900,y6+990,y7+1000,y8+990}; 
			for(z=0; z<10; z++){ 		
				g.setColor(Color.BLACK);
				g.fillRect(values[z][0], values[z][1], 40, 20);
				}	
			g.setColor(boat);
			g.fillPolygon(x, y, 8);
			g.fillOval(ovalx+465,ovaly+810, 50, 130);
			
			}

	public void focusGained(FocusEvent evt){}
	public void focusLost(FocusEvent event){}
	public void mousePressed(MouseEvent evt){}
	public void mouseReleased(MouseEvent evt){}
	public void mouseEntered(MouseEvent evt){
		requestFocus();
	}
	public void mouseExited(MouseEvent evt){}
	public void mouseClicked(MouseEvent evt){}
			
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}
	public void keyPressed(KeyEvent evt){
		
			if(evt.getKeyCode() == KeyEvent.VK_DOWN){
				y1=(y1+100);
				y2=(y2+100);
				y3=(y3+100);
				y4=(y4+100);
				y5=(y5+100);
				y6=(y6+100);
				y7=(y7+100);
				y8=(y8+100);
				ovaly=(ovaly+100);
				repaint();
			}
			if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
				x1=(x1+100);
				x2=(x2+100);
				x3=(x3+100);
				x4=(x4+100);
				x5=(x5+100);
				x6=(x6+100);
				x7=(x7+100);
				x8=(x8+100);
				ovalx=(ovalx+100);
				repaint();
			}	
			if(evt.getKeyCode() == KeyEvent.VK_LEFT){
				x1=(x1-100);
				x2=(x2-100);
				x3=(x3-100);
				x4=(x4-100);
				x5=(x5-100);
				x6=(x6-100);
				x7=(x7-100);
				x8=(x8-100);
				ovalx=(ovalx-100);
				repaint();
			}
			if(evt.getKeyCode() == KeyEvent.VK_UP){
				y1=(y1-100);
				y2=(y2-100);
				y3=(y3-100);
				y4=(y4-100);
				y5=(y5-100);
				y6=(y6-100);
				y7=(y7-100);
				y8=(y8-100);
				ovaly=(ovaly-100);
				repaint();
				System.out.println("Hi");
				
		
			}			
				
	}
}*/

		
			class GameCard1 extends JPanel implements KeyListener, MouseListener, FocusListener{
				int x = 0;
				int y = 0;
				int[] xval = {725, 750, 760, 770, 795, 770, 760, 750}; //x coordinates for the boat, (isn't the boat meant to be at the bottom of the screen and with the arrow keys it will be trying to reach the top? this starts it in the top left corner
				int[] yval = {910, 820, 810, 820, 910, 990, 1000, 990}; //position for the boat
				boolean drawBoat = false;
				boolean checker = false;
				int [][] values = new int[10][2];
				Rectangle[] w = new Rectangle[100];
				Rectangle playerRect = new Rectangle(725, 810,70,190);
				int [][] blackBox = new int[15][18]; 
				 
				
				public GameCard1(){//add in pseudocode for the math.random position of the obstacles
					addKeyListener(this);
					addMouseListener(this);
					addFocusListener(this);
					for(int x=0; x<15; x++){
						for(int y=0;y<18;y++){
							int aNum = (int)(Math.random()*10);
							blackBox[x][y]=aNum;
						}
					}
								
					for(int i=0; i<10; i++)
					{
						x =(int)(Math.random()*800+200);
						y =(int)(Math.random()*800+200);
						w[i]= new Rectangle(x,y,80,40);
						values[i][0]= x;
						values[i][1]= y;
					}
				}
		 
				 public void paintComponent (Graphics g){
					super.paintComponent(g);
					Image trash = Toolkit.getDefaultToolkit().getImage("javatrash1.jpg");
					g.drawImage(trash, 0 ,0, 1500, 1000, this); 
					g.setColor(Color.BLACK);
					g.drawRect(playerRect.x,playerRect.y,playerRect.width,playerRect.height);
					Color boat = new Color(100,60,0);
					g.setColor(Color.BLACK);
					for(int x=0; x<15; x++){
						for(int y=0;y<18;y++){
							if(blackBox[x][y]==0)
								g.fillRect(80+y*80,40+x*40,40,80);

					}
				}
			//for(int z=0; z<10; z++){ 		
			//	g.setColor(Color.BLACK);
			//	g.fillRect(w[z].x,w[z].y,w[z].width,w[z].height);
			//	}
					if(drawBoat = true){
						g.fillPolygon(xval, yval, 8);
					}
					g.setColor(boat);
					g.fillPolygon(xval, yval, 8);
					}
				
					public void focusGained(FocusEvent evt){}
					public void focusLost(FocusEvent event){}
					public void mousePressed(MouseEvent evt){}
					public void mouseReleased(MouseEvent evt){}
					public void mouseEntered(MouseEvent evt){
						requestFocus();
					}
					public void mouseExited(MouseEvent evt){}
					public void mouseClicked(MouseEvent evt){}
							
					public void keyReleased(KeyEvent evt){}
					public void keyTyped(KeyEvent evt){}
					public void keyPressed(KeyEvent evt){
						
					for(int i = 0; i < yval.length; i++){ //make a for loop so for(int 1 = 0; i < yval.length; i++)
						if(evt.getKeyCode() == KeyEvent.VK_UP){ //then do the if expression for the up arrow key being pressed
							yval[i] -= 160;
							playerRect.y-=20;
							if(yval[i] <= 0){
								card.show(p, "qp1");
							}
							else if(playerRect.intersects(w[i]))							
								card.show(p, "Fail");//every time up key is pressed, all coordinates in yval are decremented by 20, could possibly be done by doing, yval[i] -= 20;
							else{
								drawBoat = true;
								repaint();
							}
								
							}
							else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
								yval[i] += 160;
								playerRect.y+=20;
								if(playerRect.intersects(w[i]))
									card.show(p,"Fail");
								else{
									drawBoat = true;
									repaint();
								}
							}
						}
						for(int j = 0; j < xval.length; j++){
							if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
								xval[j] += 160;
								playerRect.x+=20;
								if(playerRect.intersects(w[j]))					
									card.show(p, "Fail");
								
								else{
									drawBoat = true;
									repaint();
								}
							}	
					
							else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
								xval[j] -= 160;
								playerRect.x-=20;
								if(playerRect.intersects(w[j]))
									card.show(p, "Fail");
								else{
									drawBoat = true;
									repaint();
								}
								
							}
						}
					}					
				}

			class QuestionPanel1 extends JPanel implements ActionListener{
				JLabel question;
				JRadioButton a;
				JRadioButton b;
				JRadioButton c;
				JRadioButton d;
				//File IO stuff

				QuestionPanel1(){
					question = new JLabel("If trash were to be put in a river, what are some ways it would affect the ecosystem?");
					add(question);
					a=new JRadioButton("It would helps animals in allowing them to jump across the river");
					add(a);
					a.addActionListener(this);
					b=new JRadioButton("B)it would rpovide a useful network of getting rid of trash ");
					add(b);
					b.addActionListener(this);
					c=new JRadioButton("C)Construction debris and water pollutants kill the animals directly and eventually their habitat");
					add(c);
					c.addActionListener(this);
					d=new JRadioButton("D) It is necessary in order to declutter our streets");
					add(d);
					d.addActionListener(this);
				}

				public void paintComponent(Graphics g){
					super.paintComponent(g);
					Image river1 = Toolkit.getDefaultToolkit().getImage("javariver1.jpg");
					g.drawImage(river1, 0 ,0, 1500, 1000, this);
					Font MyFont = new Font("Serif", Font.PLAIN, 45);
		  
				}
				
				
				public void actionPerformed(ActionEvent evt){
					if(evt.getSource()== c)
						card.show(p, "Game Card2");
					else if(evt.getSource()== a)
						card.show(p, "Fail");
					else if(evt.getSource()== b) 
						card.show(p, "Fail");
					else if(evt.getSource()== d)
						card.show(p, "Fail");
				}
			}



			class Fail extends JPanel implements ActionListener{
				JButton restart1;
				JLabel incorrect;

				public Fail(){
					incorrect=new JLabel("I am sorry! You chose the incorrect answer. \n Please press the button to try the level again.");
					add(incorrect);
					restart1=new JButton("Restart Level");
					add(restart1);
					restart1.addActionListener(this);
				}
					
				public void actionPerformed(ActionEvent evt){
					if(evt.getSource()==restart1)
						card.show(p, "Game Card1");
				}
									
			}
		
		class GameCard2 extends JPanel, MouseListener, FocusListener{
			int x = 0;
			int y = 0;
			int[] xval = {725, 750, 760, 770, 795, 770, 760, 750}; //x coordinates for the boat, (isn't the boat meant to be at the bottom of the screen and with the arrow keys it will be trying to reach the top? this starts it in the top left corner
			int[] yval = {910, 820, 810, 820, 910, 990, 1000, 990}; //position for the boat
			boolean drawBoat = false;
			boolean checker = false;
			int [][] values = new int[10][2];
			Rectangle[] w = new Rectangle[100];
			Rectangle playerRect = new Rectangle(725, 810,70,190);
			//int [][] 
			 
			
			public GameCard2(){//add in pseudocode for the math.random position of the obstacles
			addKeyListener(this);
			addMouseListener(this);
			addFocusListener(this);
			for(int i=0; i<10; i++)
			{
				x =(int)(Math.random()*800+200);
				y =(int)(Math.random()*800+200);
				w[i]= new Rectangle(x,y,80,40);
				values[i][0]= x;
				values[i][1]= y;
			}
			}
	 
			 public void paintComponent (Graphics g){
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.drawRect(playerRect.x,playerRect.y,playerRect.width,playerRect.height);
				Color boat = new Color(100,60,0);
				for(int z=0; z<10; z++){ 		
					g.setColor(Color.RED);
					g.fillRect(w[z].x,w[z].y,w[z].width,w[z].height);
					}
				if(drawBoat = true){
					g.fillPolygon(xval, yval, 8);
				}
				g.setColor(boat);
				g.fillPolygon(xval, yval, 8);
				}
			
				public void focusGained(FocusEvent evt){}
				public void focusLost(FocusEvent event){}
				public void mousePressed(MouseEvent evt){}
				public void mouseReleased(MouseEvent evt){}
				public void mouseEntered(MouseEvent evt){
					requestFocus();
				}
				public void mouseExited(MouseEvent evt){}
				public void mouseClicked(MouseEvent evt){}
						
				public void keyReleased(KeyEvent evt){}
				public void keyTyped(KeyEvent evt){}
				public void keyPressed(KeyEvent evt){
					
				for(int i = 0; i < yval.length; i++){ //make a for loop so for(int 1 = 0; i < yval.length; i++)
					if(evt.getKeyCode() == KeyEvent.VK_UP){ //then do the if expression for the up arrow key being pressed
						yval[i] -= 160;
						playerRect.y-=20;
						if(yval[i] <= 0){
							card.show(p, "qp2");
							}
						else if(playerRect.intersects(w[i]))							
							card.show(p, "Fail");//every time up key is pressed, all coordinates in yval are decremented by 20, could possibly be done by doing, yval[i] -= 20;
						else{
							drawBoat = true;
							repaint();
						}
							
						}
						else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
							yval[i] += 160;
							playerRect.y+=20;
							if(playerRect.intersects(w[i]))
								card.show(p,"Fail");
							else{
								drawBoat = true;
								repaint();
							}
						}
					}
					for(int j = 0; j < xval.length; j++){
						if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
							xval[j] += 160;
							playerRect.x+=20;
							if(playerRect.intersects(w[j]))					
								card.show(p, "Fail");
							
							else{
								drawBoat = true;
								repaint();
							}
						}	
				
						else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
							xval[j] -= 160;
							playerRect.x-=20;
							if(playerRect.intersects(w[j]))
								card.show(p, "Fail");
							else{
								drawBoat = true;
								repaint();
							}
							
						}
					}
				}					
			}

			class QuestionPanel2 extends JPanel implements ActionListener{
				JLabel question;
				JRadioButton a;
				JRadioButton b;
				JRadioButton c;
				JRadioButton d;
				//File IO stuff

				QuestionPanel2(){
					question = new JLabel("Trash affects an ecosystem in many ways. What is one way in which plastic can affect water?");
					add(question);
					a=new JRadioButton("A) Answer");
					add(a);
					a.addActionListener(this);
					b=new JRadioButton("B) Fake Answer ");
					add(b);
					b.addActionListener(this);
					c=new JRadioButton("C) Fake Answer");
					add(c);
					c.addActionListener(this);
					d=new JRadioButton("D) Fake Answer");
					add(d);
					d.addActionListener(this);
				}

				public void paintComponent(Graphics g){
					super.paintComponent(g);
					Image river1 = Toolkit.getDefaultToolkit().getImage("javariver1.jpg");
					g.drawImage(river1, 0 ,0, 1500, 1000, this);
					Font MyFont = new Font("Serif", Font.PLAIN, 45);
		  
				}
				
				
				public void actionPerformed(ActionEvent evt){
					if(evt.getSource()== a)
						card.show(p, "Game Card3");
					else if(evt.getSource()== c)
						card.show(p, "Fail");
					else if(evt.getSource()== b) 
						card.show(p, "Fail");
					else if(evt.getSource()== d)
						card.show(p, "Fail");
				}
			}

		class GameCard3 extends JPanel implements KeyListener, MouseListener, FocusListener{
			int x = 0;
			int y = 0;
			int[] xval = {725, 750, 760, 770, 795, 770, 760, 750}; //x coordinates for the boat, (isn't the boat meant to be at the bottom of the screen and with the arrow keys it will be trying to reach the top? this starts it in the top left corner
			int[] yval = {910, 820, 810, 820, 910, 990, 1000, 990}; //position for the boat
			boolean drawBoat = false;
			boolean checker = false;
			int [][] values = new int[10][2];
			Rectangle[] w = new Rectangle[100];
			Rectangle playerRect = new Rectangle(725, 810,70,190);
			//int [][] 
			 
			
			public GameCard3(){//add in pseudocode for the math.random position of the obstacles
			addKeyListener(this);
			addMouseListener(this);
			addFocusListener(this);
			for(int i=0; i<10; i++)
			{
				x =(int)(Math.random()*800+200);
				y =(int)(Math.random()*800+200);
				w[i]= new Rectangle(x,y,80,40);
				values[i][0]= x;
				values[i][1]= y;
			}
			}
	 
			 public void paintComponent (Graphics g){
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.drawRect(playerRect.x,playerRect.y,playerRect.width,playerRect.height);
				Color boat = new Color(100,60,0);
				for(int z=0; z<10; z++){ 		
					g.setColor(Color.ORANGE);
					g.fillRect(w[z].x,w[z].y,w[z].width,w[z].height);
					}
				if(drawBoat = true){
					g.fillPolygon(xval, yval, 8);
				}
				g.setColor(boat);
				g.fillPolygon(xval, yval, 8);
				}
			
				public void focusGained(FocusEvent evt){}
				public void focusLost(FocusEvent event){}
				public void mousePressed(MouseEvent evt){}
				public void mouseReleased(MouseEvent evt){}
				public void mouseEntered(MouseEvent evt){
					requestFocus();
				}
				public void mouseExited(MouseEvent evt){}
				public void mouseClicked(MouseEvent evt){}
						
				public void keyReleased(KeyEvent evt){}
				public void keyTyped(KeyEvent evt){}
				public void keyPressed(KeyEvent evt){
					
				for(int i = 0; i < yval.length; i++){ //make a for loop so for(int 1 = 0; i < yval.length; i++)
					if(evt.getKeyCode() == KeyEvent.VK_UP){ //then do the if expression for the up arrow key being pressed
						yval[i] -= 160;
						playerRect.y-=20;
						if(yval[i] <= 0){
							card.show(p, "qp3");
							}
						else if(playerRect.intersects(w[i]))							
							card.show(p, "Fail");//every time up key is pressed, all coordinates in yval are decremented by 20, could possibly be done by doing, yval[i] -= 20;
						else{
							drawBoat = true;
							repaint();
						}
							
						}
						else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
							yval[i] += 160;
							playerRect.y+=20;
							if(playerRect.intersects(w[i]))
								card.show(p,"Fail");
							else{
								drawBoat = true;
								repaint();
							}
						}
					}
					for(int j = 0; j < xval.length; j++){
						if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
							xval[j] += 160;
							playerRect.x+=20;
							if(playerRect.intersects(w[j]))					
								card.show(p, "Fail");
							
							else{
								drawBoat = true;
								repaint();
							}
						}	
				
						else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
							xval[j] -= 160;
							playerRect.x-=20;
							if(playerRect.intersects(w[j]))
								card.show(p, "Fail");
							else{
								drawBoat = true;
								repaint();
							}
							
						}
					}
				}					
			}
		
		class QuestionPanel3 extends JPanel implements ActionListener{
				JLabel question;
				JRadioButton a;
				JRadioButton b;
				JRadioButton c;
				JRadioButton d;
				//File IO stuff

				QuestionPanel3(){
					question = new JLabel("Trash affects an ecosystem in many ways. What is one way in which plastic can affect water?");
					add(question);
					a=new JRadioButton("A) Answer");
					add(a);
					a.addActionListener(this);
					b=new JRadioButton("B) Fake Answer ");
					add(b);
					b.addActionListener(this);
					c=new JRadioButton("C) Fake Answer");
					add(c);
					c.addActionListener(this);
					d=new JRadioButton("D) Fake Answer");
					add(d);
					d.addActionListener(this);
				}

				public void paintComponent(Graphics g){
					super.paintComponent(g);
					Image river1 = Toolkit.getDefaultToolkit().getImage("javariver1.jpg");
					g.drawImage(river1, 0 ,0, 1500, 1000, this);
					Font MyFont = new Font("Serif", Font.PLAIN, 45);
		  
				}
				
				
				public void actionPerformed(ActionEvent evt){
					if(evt.getSource()== a)
						card.show(p, "Game Card4");
					else if(evt.getSource()== c)
						card.show(p, "Fail");
					else if(evt.getSource()== b) 
						card.show(p, "Fail");
					else if(evt.getSource()== d)
						card.show(p, "Fail");
				}
			}

		class GameCard4 extends JPanel implements KeyListener, MouseListener, FocusListener{
			int x = 0;
			int y = 0;
			int[] xval = {725, 750, 760, 770, 795, 770, 760, 750}; //x coordinates for the boat, (isn't the boat meant to be at the bottom of the screen and with the arrow keys it will be trying to reach the top? this starts it in the top left corner
			int[] yval = {910, 820, 810, 820, 910, 990, 1000, 990}; //position for the boat
			boolean drawBoat = false;
			boolean checker = false;
			int [][] values = new int[10][2];
			Rectangle[] w = new Rectangle[100];
			Rectangle playerRect = new Rectangle(725, 810,70,190);
			//int [][] 
			 
			
			public GameCard4(){//add in pseudocode for the math.random position of the obstacles
			addKeyListener(this);
			addMouseListener(this);
			addFocusListener(this);
			for(int i=0; i<10; i++)
			{
				x =(int)(Math.random()*800+200);
				y =(int)(Math.random()*800+200);
				w[i]= new Rectangle(x,y,80,40);
				values[i][0]= x;
				values[i][1]= y;
			}
			}
	 
			 public void paintComponent (Graphics g){
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.drawRect(playerRect.x,playerRect.y,playerRect.width,playerRect.height);
				Color boat = new Color(100,60,0);
				for(int z=0; z<10; z++){ 		
					g.setColor(Color.GREEN);
					g.fillRect(w[z].x,w[z].y,w[z].width,w[z].height);
					}
				if(drawBoat = true){
					g.fillPolygon(xval, yval, 8);
				}
				g.setColor(boat);
				g.fillPolygon(xval, yval, 8);
				}
			
				public void focusGained(FocusEvent evt){}
				public void focusLost(FocusEvent event){}
				public void mousePressed(MouseEvent evt){}
				public void mouseReleased(MouseEvent evt){}
				public void mouseEntered(MouseEvent evt){
					requestFocus();
				}
				public void mouseExited(MouseEvent evt){}
				public void mouseClicked(MouseEvent evt){}
						
				public void keyReleased(KeyEvent evt){}
				public void keyTyped(KeyEvent evt){}
				public void keyPressed(KeyEvent evt){
					
				for(int i = 0; i < yval.length; i++){ //make a for loop so for(int 1 = 0; i < yval.length; i++)
					if(evt.getKeyCode() == KeyEvent.VK_UP){ //then do the if expression for the up arrow key being pressed
						yval[i] -= 160;
						playerRect.y-=20;
						if(yval[i] <= 0){
							card.show(p, "qp4");
							}
						else if(playerRect.intersects(w[i]))							
							card.show(p, "Fail");//every time up key is pressed, all coordinates in yval are decremented by 20, could possibly be done by doing, yval[i] -= 20;
						else{
							drawBoat = true;
							repaint();
						}
							
						}
						else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
							yval[i] += 160;
							playerRect.y+=20;
							if(playerRect.intersects(w[i]))
								card.show(p,"Fail");
							else{
								drawBoat = true;
								repaint();
							}
						}
					}
					for(int j = 0; j < xval.length; j++){
						if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
							xval[j] += 160;
							playerRect.x+=20;
							if(playerRect.intersects(w[j]))					
								card.show(p, "Fail");
							
							else{
								drawBoat = true;
								repaint();
							}
						}	
				
						else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
							xval[j] -= 160;
							playerRect.x-=20;
							if(playerRect.intersects(w[j]))
								card.show(p, "Fail");
							else{
								drawBoat = true;
								repaint();
							}
							
						}
					}
				}					
			}
			
			class QuestionPanel4 extends JPanel implements ActionListener{
				JLabel question;
				JRadioButton a;
				JRadioButton b;
				JRadioButton c;
				JRadioButton d;
				//File IO stuff

				QuestionPanel4(){
					question = new JLabel("Trash affects an ecosystem in many ways. What is one way in which plastic can affect water?");
					add(question);
					a=new JRadioButton("A) Answer");
					add(a);
					a.addActionListener(this);
					b=new JRadioButton("B) Fake Answer ");
					add(b);
					b.addActionListener(this);
					c=new JRadioButton("C) Fake Answer");
					add(c);
					c.addActionListener(this);
					d=new JRadioButton("D) Fake Answer");
					add(d);
					d.addActionListener(this);
				}

				public void paintComponent(Graphics g){
					super.paintComponent(g);
					Image river1 = Toolkit.getDefaultToolkit().getImage("javariver1.jpg");
					g.drawImage(river1, 0 ,0, 1500, 1000, this);
					Font MyFont = new Font("Serif", Font.PLAIN, 45);
		  
				}
				
				
				public void actionPerformed(ActionEvent evt){
					if(evt.getSource()== a)
						card.show(p, "Game Card5");
					else if(evt.getSource()== c)
						card.show(p, "Fail");
					else if(evt.getSource()== b) 
						card.show(p, "Fail");
					else if(evt.getSource()== d)
						card.show(p, "Fail");
				}
			}
			
			class GameCard5 extends JPanel implements KeyListener, MouseListener, FocusListener{
				int x = 0;
				int y = 0;
				int[] xval = {725, 750, 760, 770, 795, 770, 760, 750}; //x coordinates for the boat, (isn't the boat meant to be at the bottom of the screen and with the arrow keys it will be trying to reach the top? this starts it in the top left corner
				int[] yval = {910, 820, 810, 820, 910, 990, 1000, 990}; //position for the boat
				boolean drawBoat = false;
				boolean checker = false;
				int [][] values = new int[10][2];
				Rectangle[] w = new Rectangle[100];
				Rectangle playerRect = new Rectangle(725, 810,70,190);
				//int [][] 
				 
			
			public GameCard5(){//add in pseudocode for the math.random position of the obstacles
				addKeyListener(this);
				addMouseListener(this);
				addFocusListener(this);
				for(int i=0; i<10; i++)
				{
					x =(int)(Math.random()*800+200);
					y =(int)(Math.random()*800+200);
					w[i]= new Rectangle(x,y,80,40);
					values[i][0]= x;
					values[i][1]= y;
				}
				}
	 
			 public void paintComponent (Graphics g){
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.drawRect(playerRect.x,playerRect.y,playerRect.width,playerRect.height);
				Color boat = new Color(100,60,0);
				for(int z=0; z<10; z++){ 		
					g.setColor(Color.CYAN);
					g.fillRect(w[z].x,w[z].y,w[z].width,w[z].height);
					}
				if(drawBoat = true){
					g.fillPolygon(xval, yval, 8);
				}
				g.setColor(boat);
				g.fillPolygon(xval, yval, 8);
				}
			
				public void focusGained(FocusEvent evt){}
				public void focusLost(FocusEvent event){}
				public void mousePressed(MouseEvent evt){}
				public void mouseReleased(MouseEvent evt){}
				public void mouseEntered(MouseEvent evt){
					requestFocus();
				}
				public void mouseExited(MouseEvent evt){}
				public void mouseClicked(MouseEvent evt){}
						
				public void keyReleased(KeyEvent evt){}
				public void keyTyped(KeyEvent evt){}
				public void keyPressed(KeyEvent evt){
					
				for(int i = 0; i < yval.length; i++){ //make a for loop so for(int 1 = 0; i < yval.length; i++)
					if(evt.getKeyCode() == KeyEvent.VK_UP){ //then do the if expression for the up arrow key being pressed
						yval[i] -= 160;
						playerRect.y-=20;
						if(yval[i] <= 0){
							card.show(p, "qp5");
							}
						else if(playerRect.intersects(w[i]))							
							card.show(p, "Fail");//every time up key is pressed, all coordinates in yval are decremented by 20, could possibly be done by doing, yval[i] -= 20;
						else{
							drawBoat = true;
							repaint();
						}
							
						}
						else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
							yval[i] += 160;
							playerRect.y+=20;
							if(playerRect.intersects(w[i]))
								card.show(p,"Fail");
							else{
								drawBoat = true;
								repaint();
							}
						}
					}
					for(int j = 0; j < xval.length; j++){
						if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
							xval[j] += 160;
							playerRect.x+=20;
							if(playerRect.intersects(w[j]))					
								card.show(p, "Fail");
							
							else{
								drawBoat = true;
								repaint();
							}
						}	
				
						else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
							xval[j] -= 160;
							playerRect.x-=20;
							if(playerRect.intersects(w[j]))
								card.show(p, "Fail");
							else{
								drawBoat = true;
								repaint();
							}
							
						}
					}
				}					
			}

		class QuestionPanel5 extends JPanel implements ActionListener, ChangeListener{
			JSlider slide;
			boolean slider0;
			boolean slider1;
			boolean slider2;
			boolean slider3;
			boolean slider4;
			boolean slider5;
			JButton end;
		 
		 public QuestionPanel5(){//add in pseudocode for the math.random position of the obstacles
			slide = new JSlider(JSlider.HORIZONTAL, 0,10, 0);
			slide.addChangeListener(this);
			add(slide);
			end = new JButton("End Game");
			end.addActionListener(this);
			add(end);
	 }
	 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillRect(0,250,1500,500);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			g.drawString("Water Quality Test", 450, 950);

			if(slider0){
				g.setColor(Color.BLUE);
				g.fillRect(0,250,1000,500);
					g.drawString("ph = 7",500, 800 );
					slider0=false;
				}
			else if(slider1){
				g.fillRect(0,250,1000,500);
				g.drawString("ph = 6",500, 800 );
				for(int i=0;i<3;i++){
					int x1 =(int)(Math.random()*1000);		
					int x2 =(int)(Math.random()*1000);		
					int y1 =(int)(Math.random()*500+250);	
					int y2 =(int)(Math.random()*500+250);
					g.setColor(Color.GREEN);
					g.fillOval(x1,y1,20,20);
					g.setColor(Color.RED);
					g.fillRect(x2,y2,10,10);
				}
				for(int i=0; i<20; i++){
					int x3 =(int)(Math.random()*1000);		
					int y3 =(int)(Math.random()*500+250);						
					g.setColor(Color.GRAY);
					g.fillOval(x3, y3, 10, 10);
				}
				slider1=false;	
				}
			else if(slider2){
					g.setColor(Color.BLUE);
					g.fillRect(0,250,1000,500);
					g.drawString("ph = 5.5",500, 800 );
					for(int i=0;i<6;i++){
						int x1 =(int)(Math.random()*1500);		
						int x2 =(int)(Math.random()*1500);		
						int y1 =(int)(Math.random()*500+250);	
						int y2 =(int)(Math.random()*500+250);
						g.setColor(Color.GREEN);
						g.fillOval(x1,y1,20,20);
						g.setColor(Color.RED);
						g.fillRect(x2,y2,10,10);
					}
					for(int i=0; i<16; i++){
						int x3 =(int)(Math.random()*1000);		
						int y3 =(int)(Math.random()*500+250);						
						g.setColor(Color.GRAY);
						g.fillOval(x3, y3, 10, 10);
					}
					slider2=false;				
				}
			else if(slider3){
					g.setColor(Color.BLUE);
					g.fillRect(0,250,1000,500);
					g.drawString("ph = 5",500, 800 );
					for(int i=0;i<10;i++){
						int x1 =(int)(Math.random()*1000);		
						int x2 =(int)(Math.random()*1000);		
						int y1 =(int)(Math.random()*500+250);	
						int y2 =(int)(Math.random()*500+250);
						g.setColor(Color.GREEN);
						g.fillOval(x1,y1,20,20);
						g.setColor(Color.RED);
						g.fillRect(x2,y2,10,10);
					}
					for(int i=0; i<14; i++){
						int x3 =(int)(Math.random()*1000);		
						int y3 =(int)(Math.random()*500+250);						
						g.setColor(Color.GRAY);
						g.fillOval(x3, y3, 10, 10);
					}				
					slider3=false;
				}							
			else if(slider4){
					g.setColor(Color.BLUE);
					g.fillRect(0,250,1000,500);
					g.drawString("ph = 4.7",500, 800 );
					for(int i=0;i<12;i++){
						int x1 =(int)(Math.random()*1000);		
						int x2 =(int)(Math.random()*1000);		
						int y1 =(int)(Math.random()*500+250);	
						int y2 =(int)(Math.random()*500+250);
						g.setColor(Color.GREEN);
						g.fillOval(x1,y1,20,20);
						g.setColor(Color.RED);
						g.fillRect(x2,y2,10,10);
					}
					for(int i=0; i<11; i++){
						int x3 =(int)(Math.random()*1000);		
						int y3 =(int)(Math.random()*500+250);						
						g.setColor(Color.GRAY);
						g.fillOval(x3, y3, 10, 10);
					}				
					slider4=false;
				}		
			else if(slider5){
					g.setColor(Color.BLUE);
					g.fillRect(0,250,1000,500);
					g.drawString("ph = 4.3",500, 800 );
					for(int i=0;i<15;i++){
						int x1 =(int)(Math.random()*1000);		
						int x2 =(int)(Math.random()*1000);		
						int y1 =(int)(Math.random()*500+250);	
						int y2 =(int)(Math.random()*500+250);
						g.setColor(Color.GREEN);
						g.fillOval(x1,y1,20,20);
						g.setColor(Color.RED);
						g.fillRect(x2,y2,10,10);
					}
					for(int i=0; i<8; i++){
						int x3 =(int)(Math.random()*1000);		
						int y3 =(int)(Math.random()*500+250);						
						g.setColor(Color.GRAY);
						g.fillOval(x3, y3, 10, 10);
					}				
					slider5=false;
				}	
				g.setColor(Color.RED);		
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				g.drawString("Green Circles = Bacteria", 500, 40);
				g.drawString("Gray Circles = Dissolved Oxygen", 500, 55);
				g.drawString("Red Rectangles = Nitrogen Content", 500, 70);
				g.drawString("pH = Acidity of Water", 500, 85);
				//create booleans that draw stuff depending on slider value
				
			}
			
	 
			public void stateChanged(ChangeEvent evt){
				if(slide.getValue() == 0){
					slider0=true;
					repaint();
				}
				if(slide.getValue() == 2){
					slider1=true;
					repaint();
				}
				if(slide.getValue() == 4){
					slider2=true;
					repaint();
				}
				if(slide.getValue() == 6){
					slider3=true;
					repaint();
				}	
				if(slide.getValue() == 8){
					slider4=true;		
					repaint();
				}
				if(slide.getValue() == 10){
					slider5=true;			
					repaint();		
				}					
				//if else statements that change values of booleans
			}
			
			public void actionPerformed(ActionEvent evt){
				if(evt.getSource()== end)
					card.show(p, "Start");
			}
		}
	}
}



