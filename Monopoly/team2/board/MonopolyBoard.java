package team2.board;

import java.util.ArrayList;
import java.util.List;

public class MonopolyBoard {
	private List<Square> squareCollections = new ArrayList<>();
	
	public MonopolyBoard(){
		initializeSquares();
	}
	
	private void initializeSquares() {
		Start start = new Start(0);
		start.setName("Start");
		squareCollections.add(start);
		
		CityProperty istanbul = new CityProperty(1, COLOR.RED);
		istanbul.setName("Istanbul");
		istanbul.setRentPrice(80);
		istanbul.setPurchasePrice(1500);	
		squareCollections.add(istanbul);
		
		Lottery lottery = new Lottery(2);
		lottery.setName("Lottery");
		squareCollections.add(lottery);
		
		CityProperty athens = new CityProperty(3, COLOR.RED);
		athens.setName("Athens");
		athens.setRentPrice(100);
		athens.setPurchasePrice(1500);
		squareCollections.add(athens);
		
		Tax local = new Tax(4);
		local.setName("Local Tax");
		squareCollections.add(local);
		
		Airport fiumicino = new Airport(5);
		fiumicino.setName("Fiumicino");
		fiumicino.setRentPrice(600);
		fiumicino.setPurchasePrice(5000);
		squareCollections.add(fiumicino);
		
		CityProperty rome = new CityProperty(6, COLOR.ORANGE);
		rome.setName("Rome");
		rome.setRentPrice(150);
		rome.setPurchasePrice(2500);
		squareCollections.add(rome);
		
		Casino casino = new Casino(7);
		casino.setName("Casino");
		squareCollections.add(casino);
		
		CityProperty venice = new CityProperty(8, COLOR.ORANGE);
		venice.setName("Venice");
		venice.setRentPrice(150);
		venice.setPurchasePrice(2500);
		squareCollections.add(venice);
		
		CityProperty milan = new CityProperty(9, COLOR.ORANGE);
		milan.setName("Milan");
		milan.setRentPrice(200);
		milan.setPurchasePrice(3000);
		squareCollections.add(milan);
		
		Utilities mortorway = new Utilities(10);
		mortorway.setName("Motorway");
		mortorway.setRentPrice(100);
		mortorway.setPurchasePrice(4000);
		squareCollections.add(mortorway);
		
		CityProperty barcelona = new CityProperty(11, COLOR.YELLOW);
		barcelona.setName("Barcelona");
		barcelona.setRentPrice(250);
		barcelona.setPurchasePrice(3500);
		squareCollections.add(barcelona);
		
		Jail jail = new Jail(12);
		jail.setName("Jail");
		squareCollections.add(jail);
		
		CityProperty seville = new CityProperty(13, COLOR.YELLOW);
		seville.setName("Seville");
		seville.setRentPrice(250);
		seville.setPurchasePrice(3500);
		squareCollections.add(seville);
		
		CityProperty madrid = new CityProperty(14, COLOR.YELLOW);
		madrid.setName("Madrid");
		madrid.setRentPrice(300);
		madrid.setPurchasePrice(4000);
		squareCollections.add(madrid);
		
		Airport barajas = new Airport(15);
		barajas.setName("Barajas");
		barajas.setRentPrice(600);
		barajas.setPurchasePrice(5000);
		squareCollections.add(barajas);
		
		CityProperty bordeaux = new CityProperty(16, COLOR.PINK);
		bordeaux.setName("Bordeaux");
		bordeaux.setRentPrice(350);
		bordeaux.setPurchasePrice(4500);
		squareCollections.add(bordeaux);
		
		Lottery lottery2 = new Lottery(17);
		lottery2.setName("Lottery2");
		squareCollections.add(lottery2);
		
		CityProperty lyon = new CityProperty(18, COLOR.PINK);
		lyon.setName("Lyon");
		lyon.setRentPrice(350);
		lyon.setPurchasePrice(4500);
		squareCollections.add(lyon);
		
		CityProperty paris = new CityProperty(19, COLOR.PINK);
		paris.setName("Paris");
		paris.setRentPrice(400);
		paris.setPurchasePrice(5000);
		squareCollections.add(paris);
		
		Vacation vacation = new Vacation(20);
		vacation.setName("Vacation");
		squareCollections.add(vacation);
		
		CityProperty london = new CityProperty(21, COLOR.GREEN);
		london.setName("London");
		london.setRentPrice(450);
		london.setPurchasePrice(5500);
		squareCollections.add(london);
		
		Casino casino2 = new Casino(22);
		casino2.setName("Casino2");
		squareCollections.add(casino2);
		
		CityProperty brussels = new CityProperty(23, COLOR.GREEN);
		brussels.setName("Brussels");
		brussels.setRentPrice(450);
		brussels.setPurchasePrice(5500);
		squareCollections.add(brussels);
		
		CityProperty amsterdam = new CityProperty(24, COLOR.GREEN);
		amsterdam.setName("Amsterdam");
		amsterdam.setRentPrice(500);
		amsterdam.setPurchasePrice(6000);
		squareCollections.add(amsterdam);
		
		Airport schiphol = new Airport(25);
		schiphol.setName("Schiphol");
		schiphol.setRentPrice(600);
		schiphol.setPurchasePrice(5000);
		squareCollections.add(schiphol);
		
		CityProperty oslo = new CityProperty(26, COLOR.BLUE);
		oslo.setName("Oslo");
		oslo.setRentPrice(550);
		oslo.setPurchasePrice(6500);
		squareCollections.add(oslo);
		
		CityProperty stockholm = new CityProperty(27, COLOR.BLUE);
		stockholm.setName("Stockholm");
		stockholm.setRentPrice(550);
		stockholm.setPurchasePrice(6500);
		squareCollections.add(stockholm);
		
		Utilities ferry = new Utilities(28);
		ferry.setName("Ferry");
		ferry.setRentPrice(100);
		ferry.setPurchasePrice(4000);
		squareCollections.add(ferry);
		
		CityProperty copenhagen = new CityProperty(29, COLOR.BLUE);
		copenhagen.setName("Copenhagen");
		copenhagen.setRentPrice(600);
		copenhagen.setPurchasePrice(7000);
		squareCollections.add(copenhagen);
		
		Lottery lottery3 = new Lottery(30);
		lottery3.setName("Lottery3");
		squareCollections.add(lottery3);
		
		CityProperty berlin = new CityProperty(31, COLOR.GRAY);
		berlin.setName("Berlin");
		berlin.setRentPrice(650);
		berlin.setPurchasePrice(7500);
		squareCollections.add(berlin);
		
		GoToJail goToJail = new GoToJail(32);
		goToJail.setName("Go to Jail!");
		squareCollections.add(goToJail);
		
		CityProperty frankfurt = new CityProperty(33, COLOR.GRAY);
		frankfurt.setName("Frankfurt");
		frankfurt.setRentPrice(650);
		frankfurt.setPurchasePrice(7500);
		squareCollections.add(frankfurt);
		
		CityProperty munich = new CityProperty(34, COLOR.GRAY);
		munich.setName("Munich");
		munich.setRentPrice(700);
		munich.setPurchasePrice(8000);
		squareCollections.add(munich);
		
		Airport fjStrauss = new Airport(35);
		fjStrauss.setName("Schiphol");
		fjStrauss.setRentPrice(600);
		fjStrauss.setPurchasePrice(5000);
		squareCollections.add(fjStrauss);
		
		Casino casino3 = new Casino(36);
		casino3.setName("Casino3");
		squareCollections.add(casino3);
		
		CityProperty prague = new CityProperty(37, COLOR.PURPLE);
		prague.setName("Prague");
		prague.setRentPrice(900);
		prague.setPurchasePrice(9000);
		squareCollections.add(prague);
		
		Tax tourist = new Tax(38);
		tourist.setName("Tourist Tax");
		squareCollections.add(tourist);
		
		CityProperty vienna = new CityProperty(39, COLOR.PURPLE);
		vienna.setName("Vienna");
		vienna.setRentPrice(1200);
		vienna.setPurchasePrice(10000);
		squareCollections.add(vienna);
		
	}

	public CityProperty getStreetProperty(int position) {
		return (CityProperty) squareCollections.get(position);
	}
	
	public Airport getEvent(int position) {
		return (Airport) squareCollections.get(position);
	}
}
