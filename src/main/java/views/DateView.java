package views;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import observable.DateSimulator;

public class DateView extends JFrame {

    private DateSimulator simulator;

    private JLabel labelDate = null;

    public DateSimulator getSimulator() {
	return simulator;
    }

    public void setSimulator(DateSimulator simulator) {
	this.simulator = simulator;
    }

    public DateView(String title) {
	super(title);

	labelDate = new JLabel("La date du jour : --- ");
	this.getContentPane().add(labelDate);

    }

    public void update() {
	labelDate.setText("" + simulator.getDateDuJour().get(Calendar.DAY_OF_MONTH));

    }

}
