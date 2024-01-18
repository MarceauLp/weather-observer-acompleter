package views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import observable.WeatherSimulator;

public class MeteoView1 extends JFrame {

    private WeatherSimulator simulator;

    private JLabel labelTemperature = null;

    public WeatherSimulator getSimulator() {
	return simulator;
    }

    public void setSimulator(WeatherSimulator simulator) {
	this.simulator = simulator;
    }

    public MeteoView1(String title) {
	super(title);

	setSize(200, 300);

	labelTemperature = new JLabel("Temperature actuelle : --- ");
	this.getContentPane().add(labelTemperature);

	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	addWindowListener(new WindowAdapter() {

	    @Override
	    public void windowClosing(WindowEvent e) {
		if (MeteoView1.this.simulator != null) {
		    MeteoView1.this.simulator.stop();

		}
		super.windowClosing(e);
	    }

	});

    }

    public void update() {
	labelTemperature.setText("Temperature actuelle : " + simulator.getTemperature() + " °C");
	System.out.println("MAJ VIEW 1");

    }

}
