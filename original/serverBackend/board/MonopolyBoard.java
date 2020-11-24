package serverBackend.board;

import java.util.ArrayList;
import java.util.List;

public class MonopolyBoard {
	private List<Square> squareCollections = new ArrayList<>();
	private List<Asset> assetCollections = new ArrayList<>();
	
	public MonopolyBoard(){
		initializeAssets();
		initializeSquares();
	}
	
	public void initializeAssets() {
		
		CityProperty blank = new CityProperty(0, COLOR.BLUE);
		blank.setName("blank");
		blank.setRentPrice(0);
		blank.setPurchasePrice(0);
		
		//initialize assetCollection
		//assetCollection and squareCollection will have equal positions
		for (int i =0; i < 39; i++) {

			assetCollections.add(blank);
		}
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
		assetCollections.add(1,istanbul);
		
		Lottery lottery = new Lottery(2);
		lottery.setName("Lottery");
		squareCollections.add(lottery);
		
		CityProperty athens = new CityProperty(3, COLOR.RED);
		athens.setName("Athens");
		athens.setRentPrice(100);
		athens.setPurchasePrice(1500);
		squareCollections.add(athens);
		assetCollections.add(3,athens);

		Tax local = new Tax(4);
		local.setName("Local Tax");
		local.setTax(5000);
		squareCollections.add(local);
		
		Airport fiumicino = new Airport(5);
		fiumicino.setName("Fiumicino");
		fiumicino.setRentPrice(600);
		fiumicino.setPurchasePrice(5000);
		squareCollections.add(fiumicino);
		assetCollections.add(5,fiumicino);
		
		CityProperty rome = new CityProperty(6, COLOR.ORANGE);
		rome.setName("Rome");
		rome.setRentPrice(150);
		rome.setPurchasePrice(2500);
		squareCollections.add(rome);
		assetCollections.add(6,rome);

		Casino casino = new Casino(7);
		casino.setName("Casino");
		squareCollections.add(casino);
		
		CityProperty venice = new CityProperty(8, COLOR.ORANGE);
		venice.setName("Venice");
		venice.setRentPrice(150);
		venice.setPurchasePrice(2500);
		squareCollections.add(venice);
		assetCollections.add(8,venice);
		
		CityProperty milan = new CityProperty(9, COLOR.ORANGE);
		milan.setName("Milan");
		milan.setRentPrice(200);
		milan.setPurchasePrice(3000);
		squareCollections.add(milan);
		assetCollections.add(9,milan);

		Utilities mortorway = new Utilities(10);
		mortorway.setName("Motorway");
		mortorway.setRentPrice(100);
		mortorway.setPurchasePrice(4000);
		squareCollections.add(mortorway);
		assetCollections.add(10,mortorway);

		CityProperty barcelona = new CityProperty(11, COLOR.YELLOW);
		barcelona.setName("Barcelona");
		barcelona.setRentPrice(250);
		barcelona.setPurchasePrice(3500);
		squareCollections.add(barcelona);
		assetCollections.add(11,barcelona);

		Jail jail = new Jail(12);
		jail.setName("Jail");
		squareCollections.add(jail);
		
		CityProperty seville = new CityProperty(13, COLOR.YELLOW);
		seville.setName("Seville");
		seville.setRentPrice(250);
		seville.setPurchasePrice(3500);
		squareCollections.add(seville);
		assetCollections.add(13,seville);

		CityProperty madrid = new CityProperty(14, COLOR.YELLOW);
		madrid.setName("Madrid");
		madrid.setRentPrice(300);
		madrid.setPurchasePrice(4000);
		squareCollections.add(madrid);
		assetCollections.add(14,madrid);

		Airport barajas = new Airport(15);
		barajas.setName("Barajas");
		barajas.setRentPrice(600);
		barajas.setPurchasePrice(5000);
		squareCollections.add(barajas);
		assetCollections.add(15,barajas);

		CityProperty bordeaux = new CityProperty(16, COLOR.PINK);
		bordeaux.setName("Bordeaux");
		bordeaux.setRentPrice(350);
		bordeaux.setPurchasePrice(4500);
		squareCollections.add(bordeaux);
		assetCollections.add(16,bordeaux);

		Lottery lottery2 = new Lottery(17);
		lottery2.setName("Lottery2");
		squareCollections.add(lottery2);
		
		CityProperty lyon = new CityProperty(18, COLOR.PINK);
		lyon.setName("Lyon");
		lyon.setRentPrice(350);
		lyon.setPurchasePrice(4500);
		squareCollections.add(lyon);
		assetCollections.add(18,lyon);

		CityProperty paris = new CityProperty(19, COLOR.PINK);
		paris.setName("Paris");
		paris.setRentPrice(400);
		paris.setPurchasePrice(5000);
		squareCollections.add(paris);
		assetCollections.add(19,paris);

		Vacation vacation = new Vacation(20);
		vacation.setName("Vacation");
		squareCollections.add(vacation);
		
		CityProperty london = new CityProperty(21, COLOR.GREEN);
		london.setName("London");
		london.setRentPrice(450);
		london.setPurchasePrice(5500);
		squareCollections.add(london);
		assetCollections.add(21,london);

		Casino casino2 = new Casino(22);
		casino2.setName("Casino2");
		squareCollections.add(casino2);
		
		CityProperty brussels = new CityProperty(23, COLOR.GREEN);
		brussels.setName("Brussels");
		brussels.setRentPrice(450);
		brussels.setPurchasePrice(5500);
		squareCollections.add(brussels);
		assetCollections.add(23,brussels);

		CityProperty amsterdam = new CityProperty(24, COLOR.GREEN);
		amsterdam.setName("Amsterdam");
		amsterdam.setRentPrice(500);
		amsterdam.setPurchasePrice(6000);
		squareCollections.add(amsterdam);
		assetCollections.add(24,amsterdam);

		Airport schiphol = new Airport(25);
		schiphol.setName("Schiphol");
		schiphol.setRentPrice(600);
		schiphol.setPurchasePrice(5000);
		squareCollections.add(schiphol);
		assetCollections.add(25,schiphol);

		CityProperty oslo = new CityProperty(26, COLOR.BLUE);
		oslo.setName("Oslo");
		oslo.setRentPrice(550);
		oslo.setPurchasePrice(6500);
		squareCollections.add(oslo);
		assetCollections.add(26,oslo);

		CityProperty stockholm = new CityProperty(27, COLOR.BLUE);
		stockholm.setName("Stockholm");
		stockholm.setRentPrice(550);
		stockholm.setPurchasePrice(6500);
		squareCollections.add(stockholm);
		assetCollections.add(27,stockholm);

		Utilities ferry = new Utilities(28);
		ferry.setName("Ferry");
		ferry.setRentPrice(100);
		ferry.setPurchasePrice(4000);
		squareCollections.add(ferry);
		assetCollections.add(28,ferry);

		CityProperty copenhagen = new CityProperty(29, COLOR.BLUE);
		copenhagen.setName("Copenhagen");
		copenhagen.setRentPrice(600);
		copenhagen.setPurchasePrice(7000);
		squareCollections.add(copenhagen);
		assetCollections.add(29,copenhagen);

		Lottery lottery3 = new Lottery(30);
		lottery3.setName("Lottery3");
		squareCollections.add(lottery3);
		
		CityProperty berlin = new CityProperty(31, COLOR.GRAY);
		berlin.setName("Berlin");
		berlin.setRentPrice(650);
		berlin.setPurchasePrice(7500);
		squareCollections.add(berlin);
		assetCollections.add(31,berlin);

		GoToJail goToJail = new GoToJail(32);
		goToJail.setName("Go to Jail!");
		squareCollections.add(goToJail);
		
		CityProperty frankfurt = new CityProperty(33, COLOR.GRAY);
		frankfurt.setName("Frankfurt");
		frankfurt.setRentPrice(650);
		frankfurt.setPurchasePrice(7500);
		squareCollections.add(frankfurt);
		assetCollections.add(33,frankfurt);

		CityProperty munich = new CityProperty(34, COLOR.GRAY);
		munich.setName("Munich");
		munich.setRentPrice(700);
		munich.setPurchasePrice(8000);
		squareCollections.add(munich);
		assetCollections.add(34,munich);

		Airport fjStrauss = new Airport(35);
		fjStrauss.setName("Schiphol");
		fjStrauss.setRentPrice(600);
		fjStrauss.setPurchasePrice(5000);
		squareCollections.add(fjStrauss);
		assetCollections.add(35,fjStrauss);

		Casino casino3 = new Casino(36);
		casino3.setName("Casino3");
		squareCollections.add(casino3);
		
		CityProperty prague = new CityProperty(37, COLOR.PURPLE);
		prague.setName("Prague");
		prague.setRentPrice(900);
		prague.setPurchasePrice(9000);
		squareCollections.add(prague);
		assetCollections.add(37,prague);

		Tax tourist = new Tax(38);
		tourist.setName("Tourist Tax");
		tourist.setTax(2000);
		squareCollections.add(tourist);
		
		CityProperty vienna = new CityProperty(39, COLOR.PURPLE);
		vienna.setName("Vienna");
		vienna.setRentPrice(1200);
		vienna.setPurchasePrice(10000);
		squareCollections.add(vienna);		
		assetCollections.add(39,vienna);
		
	}

	public String getName(int pos) {
		return squareCollections.get(pos).getName();

	}
	public int getRent(int pos) {
		return assetCollections.get(pos).getRentPrice();

	}
	public int getPurchase(int pos) {
		return assetCollections.get(pos).getPurchasePrice();

	}
	public Airport getAirport(int position) {
		return (Airport) squareCollections.get(position);
	}

	public Casino getCasino(int position) {
		return (Casino) squareCollections.get(position);
	}
	
	public CityProperty getCityProperty(int position) {
		return (CityProperty) squareCollections.get(position);
	}
	
	public GoToJail getGoToJail(int position) {
		return (GoToJail) squareCollections.get(position);
	}
	
	public Jail getJail(int position) {
		return (Jail) squareCollections.get(position);
	}
	
	public Lottery getLottery(int position) {
		return (Lottery) squareCollections.get(position);
	}
	
	public Start getStart(int position) {
		return (Start) squareCollections.get(position);
	}
	
	public Tax getTax(int position) {
		return (Tax) squareCollections.get(position);
	}
	
	public Utilities getUtilities(int position) {
		return (Utilities) squareCollections.get(position);
	}
	
	public Vacation getVacation(int position) {
		return (Vacation) squareCollections.get(position);
	}
}
