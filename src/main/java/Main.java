import observable.WeatherSimulator;
import views.MeteoView1;
import views.MeteoView2;

public class Main {

    public static void main(String[] args) {
		// Etape 3: Instancier le simulateur et les vues
	WeatherSimulator simulateur = new WeatherSimulator();
	MeteoView1 view1 = new MeteoView1("METEO V1");
	MeteoView2 view2 = new MeteoView2("METEO V2");

	// simulateur.setView(view1);
	// view1.setSimulator(simulateur);

	simulateur.addObserver(view1);
    simulateur.addObserver(view2);

	view1.setVisible(true);
	view2.setVisible(true);
	simulateur.start();
    }

}
