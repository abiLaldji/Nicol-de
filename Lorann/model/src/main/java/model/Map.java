package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Observable;

import model.IElement;
import model.IMap;
import model.element.Element;
import model.element.nonMobile.NonMobileFactory;

class Map extends Observable implements IMap {

	private final int WIDTH = 20;

	private final int HEIGHT = 12;

	private IElement[][] onTheMap = new Element[WIDTH][HEIGHT];

	private static String sql = "{call print_decor}";
	private int startX;
	private int startY;
	private int startXM;
	private int startYM;

	private IMap map;

	public Map() throws IOException {
		super();
		setupMap(this.map);
		loadDB();
		fillMap(this.map);
	}

	public void loadDB() {

		try {
			Connection cnx = model.dao.LorannBDDConnector.connectorDB();
			CallableStatement cs;
			ResultSet rst;

			cs = cnx.prepareCall(sql);
			if (cs.execute()) {
				rst = cs.getResultSet();

				while (rst.next()) {
					int levelNumber = 0;
					int levelNumberBdd = rst.getInt("level_number");
					String type = rst.getString("type");
					int x = rst.getInt("x");
					int y = rst.getInt("y");

					if (levelNumber == levelNumberBdd) {
						switch (type) {
						case "HWall":
							this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('_'), x, y);
							break;
						case "VWall":
							this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('|'), x, y);
							break;
						case "CWall":
							this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('o'), x, y);
							break;
						case "Door":
							this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol(']'), x, y);
							break;
						case "Bubble":
							this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('B'), x, y);
							break;
						case "Purse":
							this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol('P'), x, y);
							break;
						case "Lorann":
							this.startX = x;
							this.startY = y;
							break;
						case "Monster1":
							this.startXM = x;
							this.startYM = y;
							break;
						default:
							this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol(' '), x, y);
							break;
						}
					}
				}
				rst.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void setupMap(IMap map) {
		this.map = map;
		for (int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++) {
				this.setEmptyXY(x, y);
			}
		}
	}

	private void fillMap(final IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++) {

				this.getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}

	}

	public IMap getMap() {
		return this.map;
	}

	public final int getWidth() {
		return this.WIDTH;
	}

	public final int getHeight() {
		return this.HEIGHT;
	}

	public final IElement getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	private void setOnTheMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	public void setEmptyXY(final int x, final int y) {
		setOnTheMapXY(NonMobileFactory.getFromFileSymbol(' '), x, y);
	}
	
	public void setOpenDoor(final int x, final int y) {
		setOnTheMapXY(NonMobileFactory.getFromFileSymbol('['), x, y);
	}

	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	public Observable getObservable() {
		return this;
	}

	public int getStartX() {
		return this.startX;
	}

	public int getStartY() {
		return this.startY;
	}

	public int getStartXM() {
		return this.startXM;
	}

	public int getStartYM() {
		return this.startYM;
	}

}
