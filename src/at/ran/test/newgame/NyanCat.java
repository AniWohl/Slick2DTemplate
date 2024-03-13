package at.woa.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Crusher extends SpielObjekt {
    private Input input;
    private Rectangle shape;
    private float acceleration = 0.5F;

    public Crusher(int x, int y, Image image, Input input) {
        super(x, y, image);
        this.input = input;
        this.shape = new Rectangle((float)x, (float)y, (float)image.getWidth(), (float)image.getHeight());
    }

    public void draw(Graphics g) {
        this.getImage().drawCentered((float)this.getX(), (float)this.getY());
    }

    public Shape getShape() {
        return this.shape;
    }

    public void update(int delta) {
        boolean pressed = false;
        if (this.input.isKeyDown(30)) {
            this.setX(this.getX() - (int)this.acceleration);
            if (this.getX() < this.getWidth() / 2) {
                this.setX(this.getWidth() / 2);
            }

            pressed = true;
        }

        if (this.input.isKeyDown(32)) {
            this.setX(this.getX() + (int)this.acceleration);
            if (this.getX() > 1024 - this.getWidth() / 2) {
                this.setX(1024 - this.getWidth() / 2);
            }

            pressed = true;
        }

        if (pressed) {
            this.acceleration += (float)delta;
            if (this.acceleration > 15.0F) {
                this.acceleration = 15.0F;
            }
        } else {
            this.acceleration = 0.5F;
        }

        this.shape.setCenterX((float)this.getX());
        this.shape.setCenterY((float)this.getY());
    }

    public boolean intersects(Shape shape) {
        return shape != null ? this.getShape().intersects(shape) : false;
    }
}
