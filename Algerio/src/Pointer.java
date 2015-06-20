import java.util.ArrayList;

public class Pointer implements MainInterface {

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

	public Pointer(double xCoord, double yCoord, double xVel, double yVel,
			double xA, double yA, double mass, boolean div, String type,
			ArrayList<Cell> sense, ArrayList<Cell> subCells) {
		super();
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

	@Override
	public void main() {
		update();

	}

	public void update() {
		for (Cell cell : subCells) {
			cell.setxVel(xVel);
			cell.setyVel(yVel);
			cell.setxA(cell.getxA() + xA);
			cell.setyA(cell.getyA() + yA);
			cell.update();

		}
	}

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
	}

	public double removeCell(Cell cell) {
		mass = cell.getMass();
		subCells.remove(cell);
		return mass;
	}

	public double move(double x, double y) {
		double xVec = this.xCoord - x;
		double yVec = this.yCoord - y;
		double ratio = yVec / xVec;
		for (double i = maxSpeed; i >= 0; i -= .1) {
			for (double j = maxSpeed; j >= 0; j -= .1) {
				if (j / i < ratio + .2 && j / i > ratio - .2
						&& Math.sqrt((j * j) + (i * i)) <= maxSpeed) {
					this.setyVel(i);
					this.setxVel(j);
					return j / i;
				}
			}
		}

		return -1;

	}

	// Not sure about this
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

}
