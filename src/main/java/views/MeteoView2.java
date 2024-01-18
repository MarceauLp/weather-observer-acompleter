package views;

import javax.swing.JFrame;
import javax.swing.JLabel;

import observable.WeatherSimulator;

public class MeteoView2 extends JFrame {

    private WeatherSimulator simulator;

    private JLabel labelHumidite = null;

    public WeatherSimulator getSimulator() {
	return simulator;
    }

    public void setSimulator(WeatherSimulator simulator) {
	this.simulator = simulator;
    }

    public MeteoView2(String title) {
	super(title);

	setSize(200, 100);

	labelHumidite = new JLabel("Humidité actuelle : --- ");
	this.getContentPane().add(labelHumidite);

    }

    public void update() {
	labelHumidite.setText("Humidité actuelle : " + simulator.getPctHumidite() + " %");
	System.out.println("MAJ VIEW 2");
    }

}
