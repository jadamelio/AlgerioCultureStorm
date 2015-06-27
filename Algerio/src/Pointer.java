import java.util.ArrayList;

public class Pointer implements MainInterface {

	// Properties
	private double xCoord;
	private double yCoord;
	private double xVel;
	private double yVel;
	private double xA;
	private double yA;
	private double mass;
	private boolean div;
	private String type;
	private ArrayList<Cell> sense;
	private ArrayList<Cell> subCells;
	private double maxSpeed;
	private int ID;

	// Constructors
	public Pointer(double xCoord, double yCoord, double xVel, double yVel,
			double xA, double yA, double mass, boolean div, String type,
			ArrayList<Cell> sense, ArrayList<Cell> subCells) {

		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.xVel = xVel;
		this.yVel = yVel;
		this.xA = xA;
		this.yA = yA;
		this.mass = mass;
		this.div = div;
		this.type = type;
		this.sense = sense;
		this.subCells = subCells;
	}

	// Main method, governs actual change of position.
	@Override
	public void main() {
		update();

	}

	@Override
	public String toString() {

		return "ID: "+ ID + " X: " + xCoord + " Y:" + yCoord + " V: "
				+ Math.sqrt(xVel * xVel + yVel * yVel) + " Degree: "
				+ Math.atan(yVel / xVel);
	}

	public void update() {

		for (Cell cell : subCells) {
			cell.setxVel(xVel);
			cell.setyVel(yVel);
			cell.setxA(cell.getxA() + xA);
			cell.setyA(cell.getyA() + yA);
			cell.move(this.xCoord, this.yCoord, .1);
			cell.update();

		}
		xVel += xA;
		yVel += yA;
		this.move(xCoord + xVel, yCoord + yVel);
	}

	// Divides every eligible cell in the pointer
	public void divide() {
		ArrayList<Cell> temp = new ArrayList<Cell>();
		for (Cell cell : subCells) {
			if (cell.getMass() > 59) {
				temp.add(new Cell(cell.getxCoord() + cell.getMass(), cell
						.getyCoord() + cell.getMass(), cell.getxVel(), cell
						.getyVel(), cell.getyA(), cell.getxA(),
						cell.getMass() / 2));
				cell.setMass(cell.getMass() / 2);
			}
		}
		for (Cell cell : temp) {
			subCells.add(cell);
		}
	}

	public void internalContinuity() {
		// Make sure the cells bounce of each other and don't each other
		// This doesn't work, like at all
		for (int i = 0; i < subCells.size(); i++) {
			for (int j = i + 1; j < subCells.size(); j++) {
				if (collisionDetect(subCells.get(i), subCells.get(j))) {
					collide(subCells.get(i), subCells.get(j));
				}
			}
		}
	}

	// Checks to see if two cells are bumping with circle detection
	public boolean collisionDetect(Cell a, Cell b) {
		double xDis = a.getxCoord() - b.getxCoord();
		double yDis = a.getyCoord() - b.getyCoord();
		double distance = Math.abs(Math.sqrt(xDis * xDis + yDis * yDis));

		if (distance < a.getMass() / 2 + b.getMass() / 2) {
			return true;
		} else {
			return false;
		}

	}

	// IDK, i'll figure it out
	public void collide(Cell a, Cell b) {
		double momentum = a.getMomentum() + b.getMomentum();
		// uuuh
	}

	// Removes a cell from the array, returning its mass as a double
	public double removeCell(Cell cell) {
		mass = cell.getMass();
		subCells.remove(cell);
		return mass;
	}

	// Sets pointers x and y vectors to a coordinate point
	public double move(double x, double y) {
		double xVec = this.xCoord - x;
		double yVec = this.yCoord - y;
		double ratio = yVec / xVec;
		for (double i = maxSpeed; i >= 0; i -= .1) {
			for (double j = maxSpeed; j >= 0; j -= .1) {
				if (j / i < ratio + .2 && j / i > ratio - .2
						&& Math.sqrt((j * j) + (i * i)) <= maxSpeed) {
					yVel = i;
					xVel = j;
					return j / i;
				}
			}
		}

		return -1;

	}

	// Not sure about this, two granular?
	private void cDxV(Cell cell, double value) {
		cell.setxVel(value);
	}

	private void cDyV(Cell cell, double value) {
		cell.setyVel(value);
	}

	private void cDyAc(Cell cell, double value) {
		cell.setyA(value);
	}

	private void cDxAc(Cell cell, double value) {
		cell.setxA(value);
	}

	private void cDxCoord(Cell cell, double value) {
		cell.setxCoord(value);
	}

	private void cDyCoord(Cell cell, double value) {
		cell.setyCoord(value);
	}

	// Setters and getter
	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	public double getxA() {
		return xA;
	}

	public void setxA(double xA) {
		this.xA = xA;
	}

	public double getyA() {
		return yA;
	}

	public void setyA(double yA) {
		this.yA = yA;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
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

	public ArrayList<Cell> getSubCells() {
		return subCells;
	}

	public void setSubCells(ArrayList<Cell> subCells) {
		this.subCells = subCells;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
