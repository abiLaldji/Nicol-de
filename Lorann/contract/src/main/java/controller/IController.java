package controller;

import java.io.IOException;

import model.IModel;

public interface IController {
	
    void play() throws InterruptedException, IOException;
    
    IOrderPerformer getOrderPerformer();
    
    IModel getModel();
    
    
}
