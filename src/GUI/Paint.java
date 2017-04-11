package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entityManagers.ShapeManager;
import shape.Circle;
import shape.Line;
import shape.Rectangle;
import shape.Shape;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class Paint extends JFrame {

	private int x1, x2, y1, y2;
	JPanel panel;
	private Color color = Color.BLACK;
	public Color getColor() {
		return color;
	}

	private String shapeType = "Line";
	final private int idPerson;
	private boolean select;
	List<Shape> shapes = new ArrayList<>();
	private JButton btnZoomin;
	JButton btnZoomout;
	double factor = 0.5;

	// ===============================================
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */

	public Paint(final int idPerson) {
		this.idPerson = idPerson;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setTitle("Paint");
		contentPane.setLayout(null);

		// select shape buttons
		JButton btnLine = new JButton("خط");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setShapeType("Line");
			}
		});
		btnLine.setBounds(551, 70, 99, 25);
		contentPane.add(btnLine);

		JButton btnCircle = new JButton("دایره");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setShapeType("Circle");
			}
		});
		btnCircle.setBounds(551, 120, 99, 25);
		contentPane.add(btnCircle);

		JButton btnRectangle = new JButton("مستطیل");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setShapeType("Rectangle");
			}
		});
		btnRectangle.setBounds(551, 168, 99, 25);
		contentPane.add(btnRectangle);

		// color select label
		JLabel lblColorSelect = new JLabel("انتخاب رنگ");
		lblColorSelect.setForeground(SystemColor.activeCaption);
		lblColorSelect.setBounds(574, 228, 107, 15);
		contentPane.add(lblColorSelect);

		// define radio buttons to choose color
		final JRadioButton rdbtnBlack = new JRadioButton("مشکی");
		buttonGroup.add(rdbtnBlack);
		rdbtnBlack.setBounds(581, 251, 70, 23);
		rdbtnBlack.setSelected(true); // set default checked radio button

		final JRadioButton rdbtnRed = new JRadioButton("قرمز");
		buttonGroup.add(rdbtnRed);
		rdbtnRed.setBounds(581, 278, 54, 23);

		final JRadioButton rdbtnGreen = new JRadioButton("سبز");
		buttonGroup.add(rdbtnGreen);
		rdbtnGreen.setBounds(581, 305, 54, 23);

		final JRadioButton rdbtnBlue = new JRadioButton("آبی");
		buttonGroup.add(rdbtnBlue);
		rdbtnBlue.setBounds(581, 337, 74, 23);

		// add actions for radio buttons here!
		// Black button
		rdbtnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColor(Color.BLACK);
			}
		});

		// Red button
		rdbtnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColor(Color.RED);
			}
		});

		// Green button
		rdbtnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColor(Color.GREEN);
			}
		});

		// Blue button
		rdbtnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColor(Color.BLUE);
			}
		});

		// add radio buttons for colors to Panel
		contentPane.add(rdbtnRed);
		contentPane.add(rdbtnBlue);
		contentPane.add(rdbtnGreen);
		contentPane.add(rdbtnBlack);

		// painting panel (500 * 500 area)
		panel = new JPanel();
		panel.setVisible(true);
		panel.addMouseListener(new MouseAdapter() {
			int x_1, x_2, y_1, y_2;

			@Override
			public void mousePressed(MouseEvent e) {
				x_1 = e.getX();
				y_1 = e.getY();
				changeColor(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				x_2 = e.getX();
				y_2 = e.getY();
				setInitFinialCoordiantes(x_1, x_2, y_1, y_2);
				painting();
			}

//			@Override
//			public void mouseClicked(MouseEvent e) {
//				changeColor(e);
//			}
		});

		panel.setBounds(0, -21, 500, 500);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);

		// add Exit button
		JButton btnExit = new JButton("خروج");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // close paint JPanel
				EventQueue.invokeLater(new Runnable() { // Load Login Page
														// again!
					public void run() {
						try {
							Login frame = new Login();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnExit.setBounds(551, 490, 117, 25);
		contentPane.add(btnExit);

		JButton btnLastshapes = new JButton("شکل‌های قبل");
		btnLastshapes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawExistShapes(idPerson);
			}
		});
		btnLastshapes.setBounds(551, 454, 117, 25);
		btnLastshapes.setToolTipText("نمایش شکل‌های قبل شما");
		contentPane.add(btnLastshapes);

		btnZoomin = new JButton("+");
		btnZoomin.setBounds(612, 412, 44, 25);
		contentPane.add(btnZoomin);

		btnZoomout = new JButton("-");
		btnZoomout.setBounds(562, 412, 44, 25);
		contentPane.add(btnZoomout);

		JButton btnSelect = new JButton("انتخاب");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		btnSelect.setBounds(552, 375, 117, 25);
		contentPane.add(btnSelect);

	} // end Paint(idPerson) constructor

	// setter for color and shapeType
	private void setColor(Color color) {
		this.color = color;
	}

	private void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}

	// ================ methods ===================
	/*
	 * set initial and final coordinates
	 */

	private void select() {
		this.select = true;
		this.shapeType = "";
	}

	private void changeColor(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		if (select) {
			for (int i = 0; i < shapes.size(); i++) {
				if (shapes.get(i).containShape(x1, y1)) {
					shapes.get(i).setColor(getColor());
					ShapeManager.changeColor(idPerson, shapes.get(i));
					 break;
				}
			}
		}
	}

	private void setInitFinialCoordiantes(int x1, int x2, int y1, int y2) {
		// force shapes to draw in 500 * 500 area
		if (x1 > 500)
			x1 = 500;
		if (x1 < 0)
			x1 = 0;
		if (x2 > 500)
			x2 = 500;
		if (x2 < 0)
			x2 = 0;
		if (y1 > 500)
			y1 = 500;
		if (y1 < 0)
			y1 = 0;
		if (y2 > 500)
			y2 = 500;
		if (y2 < 0)
			y2 = 0;

		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	/*
	 * save shapes properties and draw
	 */

	private void painting() {
		Graphics g = getGraphics();

		if (shapeType.equals("Rectangle")) {
			Rectangle r = new Rectangle(x1, x2, y1, y2, color, idPerson, shapeType);
			shapes.add(r);
			ShapeManager.addRectangle(r);
			r.draw(g);
		} else if (shapeType.equals("Circle")) {
			Circle c = new Circle(x1, x2, y1, y2, color, idPerson, shapeType);
			shapes.add(c);
			ShapeManager.addCircle(c);
			c.draw(g);
		} else if (shapeType.equals("Line")) {
			Line l = new Line(x1, x2, y1, y2, color, idPerson, shapeType);
			shapes.add(l);
			ShapeManager.addLine(l);
			l.draw(g);
		}
	}

	/*
	 * Test
	 */

	/*
	 * draws shapes that user already had before
	 * 
	 * **** this part works in debug mode fine and all shapes are shown in debug
	 * mode. **** but no shapes is shown in running mode! I think something on
	 * Graphics or **** JFrame is wrong in my Code! and I don't know what it
	 * is...!
	 */
	void drawExistShapes(int idPers) {
		Rectangle[] rectangles = new Rectangle[Rectangle.size];
		Circle[] circles = new Circle[Circle.size];
		Line[] lines = new Line[Line.size];
		rectangles = ShapeManager.getAllRectangles(idPers);
		circles = ShapeManager.getAllCircles(idPers);
		lines = ShapeManager.getAllLines(idPers);
		Graphics g = getGraphics();
		for (int i = 0; i < lines.length; i++) {
			lines[i].draw(g);
			shapes.add(lines[i]);
		}
		for (int i = 0; i < circles.length; i++) {
			circles[i].draw(g);
			shapes.add(circles[i]);
		}
		for (int i = 0; i < rectangles.length; i++) {
			rectangles[i].draw(g);
			shapes.add(rectangles[i]);
		}
	}

}
