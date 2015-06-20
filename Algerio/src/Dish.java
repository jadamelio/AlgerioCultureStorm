import java.util.ArrayList;

public class Dish {

	public static void main(String[] args) {
		int width = 2000;
		int height = 200;

		ArrayList<Pointer> pointers = new ArrayList<Pointer>();
		// pointer.add(new jackCellv1());
		// pointer.get(0).setxVel(1);
		// pointer.get(0).setType("Cell");

		while (true) {
			Agar(pointers, width, height);
		}
	}

	public static void Agar(ArrayList<Pointer> pointer, int width, int height) {
		for (int i = 0; i < pointer.size(); i++) {
			// trace("Loop");

			if (pointer.get(i).getType().equals("Cell")) {
				pointer.get(i).main();
				// trace(pointer.get(i).isDiv());
			}
			for (Cell cell : pointer.get(i).getSubCells()) {
				wallDetect(cell, width, height);

			}
			pointer = hitDetect(pointer);

		}

	}

	public static ArrayList<Pointer> hitDetect(ArrayList<Pointer> pointer) {

		for (int i = 0; i < pointer.size(); i++) {
			if (pointer.get(i).getType().equals("Cell")) {

				for (int j = i + 1; j < pointer.size(); j++) {
					for (Cell cellI : pointer.get(i).getSubCells()) {
						for (Cell cellJ : pointer.get(j).getSubCells()) {
							double xDis = cellI.getxCoord() - cellJ.getxCoord();
							double yDis = cellI.getyCoord() - cellJ.getyCoord();
							double distance = Math.abs(Math.sqrt(xDis * xDis + yDis
									* yDis));
							if (distance < cellI.getMass() / 2
									+ cellJ.getMass() / 2) {
								eat(cellI, cellJ, pointer.get(i),
										pointer.get(j));
							}

						}
					}

				}
			}

		}
		return pointer;
	}

	public static void eat(Cell i, Cell j, Pointer I, Pointer J) {

		if (i.getMass() / j.getMass() > 2) {
			i.setMass(j.getMass() + i.getMass());
			J.removeCell(j);
		} else if (j.getMass() / i.getMass() > 2) {
			j.setMass(i.getMass() + j.getMass());
			I.removeCell(i);
		}

	}

	public static void wallDetect(Cell cCell, int width, int height) {

		if (cCell.getxCoord() + cCell.getMass() / 2 > width) {
			cCell.setxCoord(width - cCell.getMass() / 2);
			cCell.setxVel(0);
			cCell.setxA(0);
		}
		if (cCell.getyCoord() + cCell.getMass() / 2 > height) {
			cCell.setyCoord(height - cCell.getMass() / 2);
			cCell.setyVel(0);
			cCell.setyA(0);
		}
		if (cCell.getxCoord() + cCell.getMass() / 2 < 0) {
			cCell.setxCoord(0 + cCell.getMass() / 2);
			cCell.setxVel(0);
			cCell.setxA(0);
		}
		if (cCell.getyCoord() + cCell.getMass() / 2 < 0) {
			cCell.setyCoord(0 + cCell.getMass() / 2);
			cCell.setyVel(0);
			cCell.setyA(0);
		}

	}

	public static void trace(String a) {
		System.out.println(a);
	}

	public static void trace(int a) {
		System.out.println(a);
	}

	public static void trace(double a) {
		System.out.println(a);
	}

	public static void trace(boolean a) {
		System.out.println(a);
	}
}
