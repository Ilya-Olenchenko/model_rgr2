package exam;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import process.Dispatcher;

import rnd.Erlang;
import rnd.Norm;
import widgets.ChooseData;
import widgets.ChooseRandom;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class ExamGUI extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTabbedPane jTabbedPane = null;

	private JScrollPane jScrollPaneTz = null;

	private JPanel jPanelModelParameters = null;

	private Dispatcher dispatcher = null;

	private ChooseRandom rndBuldo = null;

	private ChooseRandom rndLoader = null;

	private ChooseData chooseDataNLorry = null;

	private ChooseData chooseDataBodySize = null;

	private ChooseRandom rndLorry = null;

	private ChooseData chooseDataHeapMaxSize = null;

	private ChooseData chooseDataFinishTime = null;

	private JTextPane jTextPane = null;
	private JPanel info;
	private JPanel panelPhoto;

	public ExamGUI() throws HeadlessException {
		super();
		initialize();
	}

	/*private void startTest() {
		getJButtonStart().setEnabled(false);
		getDiagramHeepSize().clear();
		getDiagramQueueToLoader().clear();
		getDiagramLorryOnRoad().clear();
		Dispatcher dispatcher = new Dispatcher();		
		dispatcher.addDispatcherFinishListener(
				()->getJButtonStart().setEnabled(true));
		IModelFactory factory = (d)-> new BuldModel(d, this);
		BuldModel model =(BuldModel) factory.createModel(dispatcher);
		model.initForTest();
		dispatcher.start();
	}*/

	


	/**
	 * This method initializes jTabbedPane
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setName("");
			jTabbedPane.setVisible(true);
			jTabbedPane.setFont(new java.awt.Font("Courier New",
					java.awt.Font.PLAIN, 14));
			jTabbedPane.addTab("Tz", null, getJScrollPaneTz(), null);
			jTabbedPane.addTab("info", null, getInfo(), null);

		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jScrollPaneTz
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneTz() {
		if (jScrollPaneTz == null) {
			jScrollPaneTz = new JScrollPane();
			jScrollPaneTz.setName("jScrollPaneTz");
			jScrollPaneTz.setViewportView(getJTextPane());
			jScrollPaneTz
					.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return jScrollPaneTz;
	}

	/**
	 * This method initializes jPanelModelParameters
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelModelParameters() {
		if (jPanelModelParameters == null) {
			jPanelModelParameters = new JPanel();
			jPanelModelParameters.setLayout(null);
			jPanelModelParameters
					.setBorder(javax.swing.BorderFactory
							.createTitledBorder(
									javax.swing.BorderFactory
											.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
									"Параметри системи що досліджується",
									javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
									javax.swing.border.TitledBorder.DEFAULT_POSITION,
									new java.awt.Font("Dialog",
											java.awt.Font.BOLD, 12),
									new java.awt.Color(51, 51, 51)));
			jPanelModelParameters.setPreferredSize(new Dimension(262, 436));
			jPanelModelParameters.setMinimumSize(new Dimension(262, 436));
			jPanelModelParameters.add(getStudent_performance(), null);
			jPanelModelParameters.add(getStudent_assessments(), null);
			jPanelModelParameters.add(getamount_of_students(), null);
			jPanelModelParameters.add(getChooseDataBodySize(), null);
			jPanelModelParameters.add(getRndQuestion(), null);
			jPanelModelParameters.add(getChooseDataHeapMaxSize(), null);
			jPanelModelParameters.add(getChooseDataFinishTime(), null);
		}
		return jPanelModelParameters;
	}

	/**
	 * This method initializes rndBuldo	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	public ChooseRandom getStudent_performance() {
		if (rndBuldo == null) {
			rndBuldo = new ChooseRandom();
			rndBuldo.setRandom(new Erlang(3,3));
			rndBuldo.setTitle("Успішність студентів");
			rndBuldo.setBounds(new Rectangle(3, 21, 231, 52));
		}
		return rndBuldo;
	}


	/**
	 * This method initializes rndLoader	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	public ChooseRandom getStudent_assessments() {
		if (rndLoader == null) {
			rndLoader = new ChooseRandom();
			rndLoader.setRandom(new Norm(1,0.2));
			rndLoader.setTitle("Оцінкі студентів");
			rndLoader.setBounds(new Rectangle(3, 81, 231, 52));
		}
		return rndLoader;
	}


	/**
	 * This method initializes chooseDataNLorry	
	 * 	
	 * @return widgets.ChooseData	
	 */
	
	public ChooseData getamount_of_students() {
		if (chooseDataNLorry == null) {
			chooseDataNLorry = new ChooseData();
			chooseDataNLorry.setBounds(new Rectangle(3, 200, 231, 53));
			chooseDataNLorry.setTitle("Кількість студентів");
			chooseDataNLorry.setText("20");


		}
		return chooseDataNLorry;
	}


	/**
	 * This method initializes chooseDataBodySize	
	 * 	
	 * @return widgets.ChooseData	
	 */
	public ChooseData getChooseDataBodySize() {
		if (chooseDataBodySize == null) {
			chooseDataBodySize = new ChooseData();
			chooseDataBodySize.setBounds(new Rectangle(4, 263, 231, 53));
			chooseDataBodySize.setTitle("Студенти що не з'явились на Екзамен");
			chooseDataBodySize.setText("5");
		}
		return chooseDataBodySize;
	}


	/**
	 * This method initializes rndLorry	
	 * 	
	 * @return widgets.ChooseRandom	
	 */
	public ChooseRandom getRndQuestion() {
		if (rndLorry == null) {
			rndLorry = new ChooseRandom();
			rndLorry.setBounds(new Rectangle(3, 142, 231, 52));
			rndLorry.setRandom(new Erlang(20, 4));
			rndLorry.setTitle("Кількість питань");
		}
		return rndLorry;
	}


	/**
	 * This method initializes chooseDataHeapMaxSize	
	 * 	
	 * @return widgets.ChooseData	
	 */
	public ChooseData getChooseDataHeapMaxSize() {
		if (chooseDataHeapMaxSize == null) {
			chooseDataHeapMaxSize = new ChooseData();
			chooseDataHeapMaxSize.setBounds(new Rectangle(1, 326, 231, 53));
			chooseDataHeapMaxSize.setTitle("Час на підготовку студента");
			chooseDataHeapMaxSize.setText("30");


		}
		return chooseDataHeapMaxSize;
	}


	/**
	 * This method initializes chooseDataFinishTime	
	 * 	
	 * @return widgets.ChooseData	
	 */
	
	public ChooseData getChooseDataFinishTime() {
		if (chooseDataFinishTime == null) {
			chooseDataFinishTime = new ChooseData();
			chooseDataFinishTime.setBounds(new Rectangle(3, 385, 231, 53));
			chooseDataFinishTime.setTitle("Час моделювання");
			chooseDataFinishTime.setText("500");


		}
		return chooseDataFinishTime;
	}
	


	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			String str="/exam/tz.htm";
			URL url = getClass().getResource(str);
			try {
				jTextPane.setPage(url);
			} catch (IOException e33) {
				System.err
						.println("Problems with file "+str);
			}

		}
		return jTextPane;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExamGUI application = new ExamGUI();
		application.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(949, 499);
		this.setContentPane(getJContentPane());
		this
				.setTitle("Моделювання іспиту, \r\n"
						+ "варіант Examen\r\n"
						+ "Оленченко Ілля КІт-211");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.insets = new Insets(9, 10, 7, 2);
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.ipadx = -21;
			gridBagConstraints7.ipady = 13;
			gridBagConstraints7.gridx = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.ipadx = -96;
			gridBagConstraints6.ipady = -294;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.insets = new Insets(8, 3, 6, 7);
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJTabbedPane(), gridBagConstraints6);
			jContentPane.add(getJPanelModelParameters(), gridBagConstraints7);
		}
		return jContentPane;
	}






	public Dispatcher getDispatcher() {
		if (dispatcher == null)
			dispatcher = new Dispatcher();
		return dispatcher;
	}
	private JPanel getInfo() {
		if (info == null) {
			info = new JPanel() {
			};
			info.setLayout(new BorderLayout(0, 0));
			
			JTextArea txtrDeveloperIllyaOlenchenko = new JTextArea();
			txtrDeveloperIllyaOlenchenko.setText("Developer Illya Olenchenko\r\nDepartament FBI\r\nIndividual plan number 2\r\nE-mail olenchenko.ilya243@gmail.com\r\ntel. 380689987766");
			info.add(txtrDeveloperIllyaOlenchenko, BorderLayout.SOUTH);
			info.add(getPanelPhoto(), BorderLayout.CENTER);
		}
		return info;
	}
	

	private JPanel getPanelPhoto() {
		if (panelPhoto == null) {
			panelPhoto = new JPanel() {
				public void paintComponent(Graphics g){
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g;
					BufferedImage img;
					URL url = getClass().getResource("/resource/IMG_3097.jpg");
					try {
						img = ImageIO.read(url);
					} catch (IOException e) {
						e.printStackTrace();
						return;
					}
					double k = (double)img.getHeight() / img.getWidth();
					int width = getWidth();
					int height = getHeight();
					if((double)height / width > k)
						height = (int) (width *k);
					else
						width = (int) (height /k);
					Image scaledImg = img.getScaledInstance(
	                            width, height, Image.SCALE_SMOOTH);
					g2d.drawImage(scaledImg,0,0,null);
				};
			};
		}
		return panelPhoto;
	}

}  //  @jve:decl-index=0:visual-constraint="42,-8"
// @jve:decl-index=0:visual-constraint="10,8"
