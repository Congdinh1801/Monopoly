package team2.board;

import java.util.ArrayList;
import java.util.List;

public class MonopolyBoard {
	private List<Square> squareCollections = new ArrayList<>();
	
	public MonopolyBoard(){
		initializeSquares();
	}
	
	private void initializeSquares() {
		StreetProperty istanbul = new StreetProperty(1, COLOR.RED);
		istanbul.setName("istanbul");
		istanbul.setRentPrice(80);
		istanbul.setPurchasePrice(1500);	
		squareCollections.add(istanbul);
		
		StreetProperty athens = new StreetProperty(3, COLOR.RED);
		athens.setName("athens");
		athens.setRentPrice(100);
		athens.setPurchasePrice(1500);
		squareCollections.add(athens);
		
		StreetProperty rome = new StreetProperty(6, COLOR.ORANGE);
		rome.setName("rome");
		rome.setRentPrice(150);
		rome.setPurchasePrice(2500);
		squareCollections.add(rome);
		
		StreetProperty venice = new StreetProperty(8, COLOR.ORANGE);
		venice.setName("venice");
		venice.setRentPrice(150);
		venice.setPurchasePrice(2500);
		squareCollections.add(venice);
		
		StreetProperty milan = new StreetProperty(9, COLOR.ORANGE);
		milan.setName("milan");
		milan.setRentPrice(200);
		milan.setPurchasePrice(3000);
		squareCollections.add(milan);
		
		StreetProperty barcelona = new StreetProperty(11, COLOR.YELLOW);
		barcelona.setName("barcelona");
		barcelona.setRentPrice(250);
		barcelona.setPurchasePrice(3500);
		squareCollections.add(barcelona);
		
		StreetProperty seville = new StreetProperty(13, COLOR.YELLOW);
		seville.setName("seville");
		seville.setRentPrice(250);
		seville.setPurchasePrice(3500);
		squareCollections.add(seville);
		
		StreetProperty madrid = new StreetProperty(14, COLOR.YELLOW);
		madrid.setName("madrid");
		madrid.setRentPrice(300);
		madrid.setPurchasePrice(4000);
		squareCollections.add(madrid);
		
		StreetProperty bordeaux = new StreetProperty(16, COLOR.PINK);
		bordeaux.setName("bordeaux");
		bordeaux.setRentPrice(350);
		bordeaux.setPurchasePrice(4500);
		squareCollections.add(bordeaux);
		
		StreetProperty lyon = new StreetProperty(18, COLOR.PINK);
		lyon.setName("lyon");
		lyon.setRentPrice(350);
		lyon.setPurchasePrice(4500);
		squareCollections.add(lyon);
		
		StreetProperty paris = new StreetProperty(19, COLOR.PINK);
		paris.setName("paris");
		paris.setRentPrice(400);
		paris.setPurchasePrice(5000);
		squareCollections.add(paris);
		
		StreetProperty london = new StreetProperty(21, COLOR.GREEN);
		london.setName("london");
		london.setRentPrice(450);
		london.setPurchasePrice(5500);
		squareCollections.add(london);
		
		StreetProperty brussels = new StreetProperty(23, COLOR.GREEN);
		brussels.setName("brussels");
		brussels.setRentPrice(450);
		brussels.setPurchasePrice(5500);
		squareCollections.add(brussels);
		
		StreetProperty amsterdam = new StreetProperty(24, COLOR.GREEN);
		amsterdam.setName("amsterdam");
		amsterdam.setRentPrice(500);
		amsterdam.setPurchasePrice(6000);
		squareCollections.add(amsterdam);
		
		StreetProperty oslo = new StreetProperty(26, COLOR.BLUE);
		oslo.setName("oslo");
		oslo.setRentPrice(550);
		oslo.setPurchasePrice(6500);
		squareCollections.add(oslo);
		
		StreetProperty stockholm = new StreetProperty(27, COLOR.BLUE);
		stockholm.setName("stockholm");
		stockholm.setRentPrice(550);
		stockholm.setPurchasePrice(6500);
		squareCollections.add(stockholm);
		
		StreetProperty copenhagen = new StreetProperty(29, COLOR.BLUE);
		copenhagen.setName("copenhagen");
		copenhagen.setRentPrice(600);
		copenhagen.setPurchasePrice(7000);
		squareCollections.add(copenhagen);
		
		StreetProperty berlin = new StreetProperty(31, COLOR.GRAY);
		berlin.setName("berlin");
		berlin.setRentPrice(650);
		berlin.setPurchasePrice(7500);
		squareCollections.add(berlin);
		
		StreetProperty frankfurt = new StreetProperty(33, COLOR.GRAY);
		frankfurt.setName("frankfurt");
		frankfurt.setRentPrice(650);
		frankfurt.setPurchasePrice(7500);
		squareCollections.add(frankfurt);
		
		StreetProperty munich = new StreetProperty(34, COLOR.GRAY);
		munich.setName("munich");
		munich.setRentPrice(700);
		munich.setPurchasePrice(8000);
		squareCollections.add(munich);
		
		StreetProperty prague = new StreetProperty(37, COLOR.PURPLE);
		prague.setName("prague");
		prague.setRentPrice(900);
		prague.setPurchasePrice(9000);
		squareCollections.add(prague);
		
		StreetProperty vienna = new StreetProperty(39, COLOR.PURPLE);
		vienna.setName("vienna");
		vienna.setRentPrice(1200);
		vienna.setPurchasePrice(10000);
		squareCollections.add(vienna);
		
	}

	public StreetProperty getStreetProperty(int position) {
		return (StreetProperty) squareCollections.get(position);
	}
	
	public Event getEvent(int position) {
		return (Event) squareCollections.get(position);
	}
}
