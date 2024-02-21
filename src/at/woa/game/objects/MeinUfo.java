package at.woa.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class MeinUfo extends SpielObjekt{

    public MeinUfo(int x, int y, Image image) {
        super(x, y, image);
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
        Random r = new Random();
        int ry =0;
        int rx =0;
        rx = r.nextInt(1024-this.getWidth()+1-0) +0;
        if (this.getY()>(768+this.getHeight())) {
            this.setY(-this.getHeight());
            this.setX(rx);
        }
        this.setY(this.getY()+4);

    }
}
