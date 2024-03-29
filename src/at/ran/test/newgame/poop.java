package at.ran.test.newgame;

import at.ran.test.newgame.Spielobjekt;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class poop extends Spielobjekt {

    private float acceleration =0.005f;
    private float geschwindigkeit =2;
    private Rectangle shape;
    public poop(int x, int y, Image image) {
        super(x, y, image);
        setRandomPosition();
        shape = new Rectangle (x,y, image.getWidth(), image.getHeight());
    }

    @Override
    public void draw(Graphics g) {
        this.getImage().drawCentered(this.getX(),this.getY());
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void update(int delta) {
        this.geschwindigkeit = (delta*this.acceleration + geschwindigkeit);
        if(this.getX() > (1024+this.getHeight())) {
            this.setRandomPosition();
        }
        this.setX(this.getX()+(int) this.geschwindigkeit);
        shape.setCenterX(this.getX());
        shape.setCenterY(this.getY());
    }

    public void setRandomPosition(){
        Random r = new Random();
        int ry = 0;
        int rx = 0;
        rx = r.nextInt(1024+this.getWidth()+1-0) +(this.getWidth()/2);
        // y=0 --> oben
        ry = r.nextInt(600-1+this.getHeight())+this.getHeight();
        this.setY(ry);
        this.setX(-rx);
        setRandomAcceleration();
    }
    private void setRandomAcceleration(){
        Random r = new Random();
        this.geschwindigkeit = r.nextInt(4-1)+1;

    }




}