import java.util.ArrayList;
import java.util.Random;

public class Cell {

	private int xCoord;
	private int yCoord;
	private int xVel;
	private int yVel;
	private int xA;
	private int yA;
	private int mass;
	private ArrayList<Player> sense;

	// Constructors
	public Cell() {
		xVel = 0;
		yVel = 0;
		xA = 0;
		yA = 0;
		mass = 10;
		xCoord = 0;
		yCoord = 0;
	}

	public Cell(int xC, int yC, int xV, int yV, int xAc, int yAc, int ma,
			ArrayList<Player> b) {
		xCoord = xC;
		yCoord = yC;
		xVel = xV;
		yVel = yV;
		xA = xAc;
		yA = yAc;
		mass = ma;
		sense = b;
	}

	public Cell(int width, int height) {
		xVel = 0;
		yVel = 0;
		xA = 0;
		yA = 0;
		mass = 10;
		Random gen = new Random(width);
		xCoord = gen.nextInt();
		gen = new Random(height);
		yCoord = gen.nextInt();

	}

	// Methods

	public void update() {
		xVel += xA;
		yVel += yA;
		xCoord += xVel;
		yCoord += yVel;

	}

	public void eat(Cell cell) {

	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCord) {
		this.xCoord = xCord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCord) {
		this.yCoord = yCord;
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getxA() {
		return xA;
	}

	public void setxA(int xA) {
		this.xA = xA;
	}

	public int getyA() {
		return yA;
	}

	public void setyA(int yA) {
		this.yA = yA;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public ArrayList<Player> getSense() {
		return sense;
	}

	public void setSense(ArrayList<Player> sense) {
		this.sense = sense;
	}

}
