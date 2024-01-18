import observable.WeatherSimulator;
import views.MeteoView1;

public class Main {

    public static void main(String[] args) {
	WeatherSimulator simulateur = new WeatherSimulator();
	MeteoView1 view1 = new MeteoView1("METEO V1");

	simulateur.setView(view1);
	view1.setSimulator(simulateur);

	view1.setVisible(true);
	simulateur.start();
    }

}
