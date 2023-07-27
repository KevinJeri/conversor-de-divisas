package visual;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import visual.monedas.Moneda;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class monedas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	private JComboBox primero;
	
	public enum Moneda {
		Soles_PesosArgentinos,
		PesosArgentinos_Soles,
		Soles_Boliviano,
		Boliviano_Soles,
		Soles_RealBrazilero,
		RealBrazilero_Soles,
		soles_PesoChileno,
		PesoChileno_Soles,
		Soles_PesoColombiano,
		PesoColombiano_Soles,
		Soles_Dolares,
		Dolares_Soles,
		Soles_PesoMexicano,
		PesoMexicano_Soles,
		Soles_Guaraní,
		Guaraní_Soles,
		Soles_PesoUruguayo,
		PesoUruguayo_Soles,
		
	}
	
	public double PEN_ARS = 75.65;
	public double ARS_PEN = 0.01;
	public double PEN_BOB = 1.91;
	public double BOB_PEN = 0.52;
	public double PEN_BRL = 1.31;
	public double BRL_PEN = 0.76;
	public double PEN_CLP = 228.93;
	public double CLP_PEN = 0.004;
	public double PEN_COP = 1094.78;
	public double COP_PEN = 0.0009;
	public double PEN_USD = 0.28;
	public double USD_PEN = 3.60;
	public double PEN_MXN = 4.68;
	public double MXN_PEN = 0.21;
	public double PEN_PYG = 2022.85;
	public double PYG_PEN = 0.0005;
	public double PEN_UYU = 10.46;
	public double UYU_PEN = 0.09;
	
	public double valorInput = 0.00;
	private JLabel imagen;
	private JTextField monto;
	private JButton btnconvertir;
	private JLabel lbl;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					monedas window = new monedas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public monedas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 464, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lbl = new JLabel("00.00");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl.setForeground(Color.RED);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(146, 118, 160, 36);
		panel.add(lbl);
		
		//evento convertir
		btnconvertir = new JButton("Convertir");
		btnconvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btnconvertir.setBounds(172, 182, 89, 23);
		panel.add(btnconvertir);
		
		primero = new JComboBox();
		primero.setModel(new DefaultComboBoxModel(Moneda.values()));
		primero.setBounds(155, 75, 151, 22);
		panel.add(primero);
		
		monto = new JTextField();
		monto.setToolTipText("00.00");
		monto.setBounds(146, 23, 160, 20);
		panel.add(monto);
		monto.setColumns(10);
		
		imagen = new JLabel("New label");
		imagen.setIcon(new ImageIcon(monedas.class.getResource("/imagenes/cambiomonedas.png")));
		imagen.setBounds(0, 0, 464, 230);
		panel.add(imagen);
	}
	
	public void Convertir() {
		if(Validar(monto.getText())) {
			Moneda moneda = (Moneda) primero.getSelectedItem();
			
			switch (moneda) {
			
			case Soles_PesosArgentinos:
				peruAargentina(PEN_ARS);
				break;	
			case PesosArgentinos_Soles:
				argentinaAperu(ARS_PEN);
				break;
			case Soles_Boliviano:
				peruAbolivia(PEN_BOB);
				break;
			case Boliviano_Soles:
				boliviaAperu(BOB_PEN);
				break;
			case Soles_RealBrazilero:
				peruAbrazil(PEN_BRL);
				break;
			case RealBrazilero_Soles:
				brazilAperu(BRL_PEN);
				break;
			case soles_PesoChileno:
				peruAchile(PEN_CLP);
				break;
			case PesoChileno_Soles:
				chileAperu(CLP_PEN);
				break;
			case Soles_PesoColombiano:
				peruAcolombia(PEN_COP);
				break;
			case PesoColombiano_Soles:
				colombiaAperu(COP_PEN);
				break;
			case Soles_Dolares:
				peruAeeuu(PEN_USD);
				break;
			case Dolares_Soles:
				eeuuAperu(USD_PEN);
				break;
			case Soles_PesoMexicano:
				peruAmexico(PEN_MXN);
				break;
			case PesoMexicano_Soles:
				mexicoAperu(MXN_PEN);
				break;
			case Soles_Guaraní:
				peruAparaguay(PEN_PYG);
				break;
			case Guaraní_Soles:
				paraguayAperu(PYG_PEN);
				break;
			case Soles_PesoUruguayo:
				peruAuruguay(PEN_UYU);
				break;
			case PesoUruguayo_Soles: 
				uruguayAperu(UYU_PEN);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
			}
			
		}
		
	}
	
	public void peruAargentina(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void argentinaAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAbolivia(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void boliviaAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAbrazil(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void brazilAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAchile(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void chileAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAcolombia(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void colombiaAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAeeuu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void eeuuAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAmexico(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void mexicoAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAparaguay(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void paraguayAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void peruAuruguay(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public void uruguayAperu(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(redondear(res));
	}
	
	public String redondear(double valor) {
		DecimalFormat formato = new DecimalFormat("0.00"); 
		formato.setRoundingMode(RoundingMode.HALF_UP);
		return formato.format(valor);
		
	}
	
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;	
		}catch(NumberFormatException e) {
			lbl.setText("Solamente Numeros");
			return false;
			
		}
	}

}
