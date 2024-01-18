package views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

// import observable.WeatherSimulator;

public class MeteoView1 extends JFrame implements Observer{

    // private WeatherSimulator simulator;

    private JLabel labelTemperature = null;

    // public WeatherSimulator getSimulator() {
	// 	return simulator;
    // }

    // public void setSimulator(WeatherSimulator simulator) {
	// 	this.simulator = simulator;
	// 	simulator.addObserver(this); // Ajouter cette vue comme observateur
    // }

    public MeteoView1(String title) {
		super(title);

		setSize(200, 300);

		labelTemperature = new JLabel("Temperature actuelle : --- ");
		this.getContentPane().add(labelTemperature);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// addWindowListener(new WindowAdapter() {

		// 	@Override
		// 	public void windowClosing(WindowEvent e) {
		// 		if (MeteoView1.this.simulator != null) {
		// 			MeteoView1.this.simulator.stop();

		// 		}
		// 		super.windowClosing(e);
		// 	}

		// }
		// );

    }

    // public void update() {
	// 	labelTemperature.setText("Temperature actuelle : " + simulator.getTemperature() + " °C");
	// 	System.out.println("MAJ VIEW 1");
    // }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		// throw new UnsupportedOperationException("Unimplemented method 'update'");

		if (arg instanceof Map) {

			Map<String, Integer> weatherData = (Map<String, Integer>) arg;
			int temperature = weatherData.get("temperature");
            // int temperature = (Integer) arg;
            labelTemperature.setText("Temperature actuelle : " + temperature + " °C");
            System.out.println("MAJ VIEW 1");
        }
	}

}
