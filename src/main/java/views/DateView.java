package views;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Observable;
import java.util.Observer;

import observable.DateSimulator;

public class DateView extends JFrame implements Observer {

    private DateSimulator simulator;

    private JLabel labelDate = null;

    public DateSimulator getSimulator() {
	return simulator;
    }

    public void setSimulator(DateSimulator simulator) {
        this.simulator = simulator;
        simulator.addObserver(this); // Ajouter cette vue comme observateur
    }

    public DateView(String title) {
        super(title);

        labelDate = new JLabel("La date du jour : --- ");
        this.getContentPane().add(labelDate);

    }

    public void update() {
	    labelDate.setText("" + simulator.getDateDuJour().get(Calendar.DAY_OF_MONTH));
    }

    // Implémentation de la méthode update() de l'interface Observer
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
        // Mettre à jour l'affichage de la date
        Calendar date = simulator.getDateDuJour();
        labelDate.setText("La date du jour : " + date.getTime());
    }

}
