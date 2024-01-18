package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import observable.WeatherSimulator;

public class MeteoView2 extends JFrame implements Observer{

    private WeatherSimulator simulator;

    private JLabel labelHumidite = null;

    public WeatherSimulator getSimulator() {
	    return simulator;
    }

    public void setSimulator(WeatherSimulator simulator) {
	    this.simulator = simulator;
        simulator.addObserver(this); // Ajouter cette vue comme observateur
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

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
        labelHumidite.setText("Humidité actuelle : " + simulator.getPctHumidite() + " %");
        System.out.println("MAJ VIEW 2");
    }

}
