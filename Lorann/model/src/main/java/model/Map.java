package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import model.element.Element;
import model.element.nonMobile.NonMobileFactory;;

/**
 * <h1>The Road Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
class Map extends Observable {

    private int width;

    
    private int height;

    private Element[][] onTheMap;


    Map(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new Element[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheMapXY(NonMobileFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

  
  
    public final int getWidth() {
        return this.width;
    }

    private void setWidth(final int width) {
        this.width = width;
    }


    public final int getHeight() {
        return this.height;
    }

    
    private void setHeight(final int height) {
        this.height = height;
    }



    public final Element getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }


    private void setOnTheMapXY(final Element element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }

  
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    public Observable getObservable() {
        return this;
    }
}
