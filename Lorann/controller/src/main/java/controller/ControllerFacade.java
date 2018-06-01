package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.IModel;
import view.IView;


public class ControllerFacade implements IController,IOrderPerformer {


    private IView  view;


    private IModel model;
    
    private final int SPEED = 300;
    
    private UserOrder stackOrder;


    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

 
    public void start(){
            while (this.getModel().getLorann().isAlive()) {
                Thread.sleep(SPEED);
                switch (this.getStackOrder()) {
                    case RIGHT:
                        this.getModel().getLorann().moveRight();
                        break;
                    case LEFT:
                        this.getModel().getLorann().moveLeft();
                        break;
                    case UP:
                        this.getModel().getLorann().moveUp();
                        break;
                    case DOWN:
                        this.getModel().getLorann().moveDown();
                        break;
                    case UPLEFT:
                        this.getModel().getLorann().moveUpLeft();
                        break;
                    case DOWNLEFT:
                        this.getModel().getLorann().moveDownLeft();
                        break;
                    case UPRIGHT:
                        this.getModel().getLorann().moveUpRight();
                        break;
                    case DOWNRIGHT:
                        this.getModel().getLorann().moveDownRight();
                        break;
                    case NOP:
                    default:
                        this.getModel().getLorann().doNothing();
                        break;
                }
                this.clearStackOrder();
            }
        }   	
    	
   
    	
    
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

 
    private IView getView() {
        return this.view;
    }

  
    private void setView(final IView view) {
        this.view = view;
    }

 
    private IModel getModel() {
        return this.model;
    }

    
    private void setModel(final IModel model) {
        this.model = model;
    }

 
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }


    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }


    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }


    public IOrderPerformer getOrderPeformer() {
        return this;
    }
}
