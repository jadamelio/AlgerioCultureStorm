import java.util.ArrayList;

public class Player implements MainInterface {

	private int xCoord;
	private int yCoord;
	private int xVel;
	private int yVel;
	private int xA;
	private int yA;
	private int mass;
	private boolean div;
	private String type;
	private ArrayList<Cell> sense;

	@Override
	public void main() {
		// TODO Auto-generated method stub

	}

	public void divide() {

	}

	private void cDxV(Cell cell, int value) {
		cell.setxVel(value);
	}

	private void cDyV(Cell cell, int value) {
		cell.setyVel(value);
	}
	private void cDyAc(Cell cell, int value) {
		cell.setyA(value);
	}
	
	private void cDxAc(Cell cell, int value) {
		cell.setxA(value);
	}
	private void cDsense(Cell cell, ArrayList<Player> players) {
		cell.setSense(players);
	}
	
	private void cDxCoord(Cell cell, int value) {
		cell.setxCoord(value);
	}

	private void cDyCoord(Cell cell, int value) {
		cell.setyCoord(value);
	}
	
	


	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
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

	public boolean isDiv() {
		return div;
	}

	public void setDiv(boolean div) {
		this.div = div;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Cell> getSense() {
		return sense;
	}

	public void setSense(ArrayList<Cell> sense) {
		this.sense = sense;
	}

}
