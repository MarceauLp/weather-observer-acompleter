package observable;

import java.util.Calendar;
import java.util.GregorianCalendar;

import views.DateView;

public class DateSimulator {
    public DateSimulator() {

    }

    private DateView view;
    private Thread th = null;
    private Calendar dateDuJour = new GregorianCalendar();

    public Calendar getDateDuJour() {
	return dateDuJour;
    }

    public void start() {

	if (th != null && th.isAlive()) {
	    th.interrupt();
	}

	th = new Thread(new Runnable() {

	    @Override
	    public void run() {
		boolean isinterrupted = false;
		while (!isinterrupted) {
		    try {
			Thread.sleep(10000);
		    } catch (InterruptedException e) {

			isinterrupted = true;
		    }
		    incrementDate();

		}

	    }
	});
	th.start();

    }

    public void stop() {
	if (th != null && th.isAlive()) {
	    th.interrupt();
	    th = null;
	}
    }

    protected void incrementDate() {

	dateDuJour.add(Calendar.DAY_OF_MONTH, 1);
	updateView();

    }

    private void updateView() {
	if (view != null) {
	    view.update();
	}

    }

    public void setView(DateView pView) {
	view = pView;

    }

}
