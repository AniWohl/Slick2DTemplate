//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package at.woa.game.objects;

import java.util.Random;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class MeinUfo extends SpielObjekt {
    private float acceleration = 0.005F;
    private float geschwindigkeit = 2.0F;
    private Rectangle shape;

    public MeinUfo(int x, int y, Image image) {
        super(x, y, image);
        this.setRandomPosition();
        this.shape = new Rectangle((float)x, (float)y, (float)image.getWidth(), (float)image.getHeight());
    }

    public void draw(Graphics g) {
        this.getImage().drawCentered((float)this.getX(), (float)this.getY());
    }

    public Shape getShape() {
        return this.shape;
    }

    public void update(int delta) {
        this.geschwindigkeit += (float)delta * this.acceleration;
        if (this.getY() > 768 + this.getHeight()) {
            this.setRandomPosition();
        }

        this.setY(this.getY() + (int)this.geschwindigkeit);
        this.shape.setCenterX((float)this.getX());
        this.shape.setCenterY((float)this.getY());
    }

    public void setRandomPosition() {
        Random r = new Random();
        int ry = false;
        int rx = false;
        int rx = r.nextInt(1024 - this.getWidth() + 1 - 0) + this.getWidth() / 2;
        int ry = r.nextInt(601 + this.getHeight()) + this.getHeight();
        this.setY(-ry);
        this.setX(rx);
        this.setRandomAcceleration();
    }

    private void setRandomAcceleration() {
        Random r = new Random();
        this.geschwindigkeit = (float)(r.nextInt(3) + 1);
    }
}
