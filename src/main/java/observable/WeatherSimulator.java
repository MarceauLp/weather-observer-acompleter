package observable;

import java.util.Observable;

// import views.MeteoView1;

public class WeatherSimulator extends Observable {

    private Thread th = null;
    private int temperature = 15;

    public int getTemperature() {
		return temperature;
    }

    public int getPctHumidite() {
		return pctHumidite;
    }

    private int pctHumidite = 20;
    // private MeteoView1 view;

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
			Thread.sleep(1000);
		    } catch (InterruptedException e) {

			isinterrupted = true;
		    }
		    randomizeWeather();

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

    protected void randomizeWeather() {

		int rand = (int) Math.round(Math.random() * 4 - 2);
		temperature += rand;

		if (temperature < -5)
			temperature = 5;

		if (temperature > 45)
			temperature = 45;

		rand = (int) Math.round(Math.random() * 60 - 40);
		pctHumidite += rand;

		pctHumidite = Math.min(100, pctHumidite);
		pctHumidite = Math.max(0, pctHumidite);
		setChanged();
		notifyObservers(temperature);

		// updateView();

    }

    // private void updateView() {
	// 	if (view != null) {
	// 		view.update();
	// 	}
    // }

    // public void setView(MeteoView1 pView) {
	// view = pView;

    // }

}
