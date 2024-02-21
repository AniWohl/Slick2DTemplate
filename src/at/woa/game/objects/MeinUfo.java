package at.woa.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class MeinUfo extends SpielObjekt{

    public MeinUfo(int x, int y, Image image) {
        super(x, y, image);
        setRandomPosition();
    }

    @Override
    public void draw(Graphics g) {
        this.getImage().drawCentered(this.getX(),this.getY());
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void update(int delta) {

        if (this.getY()>(768+this.getHeight())) {
     this.setRandomPosition();
        }
        this.setY(this.getY()+4);

    }

    private void setRandomPosition(){
        Random r = new Random();
        int ry =0;
        int rx =0;

        rx = r.nextInt(1024-this.getWidth()+1-0) +0;
        //y=0 oben
        ry = r.nextInt(300+1+this.getHeight())+this.getHeight();
        this.setY(-ry);
        this.setX(rx);
    }
}
