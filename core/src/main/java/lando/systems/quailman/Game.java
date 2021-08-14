package lando.systems.quailman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Game extends ApplicationAdapter implements Disposable {

    SpriteBatch batch;
    Texture texture;

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.texture = new Texture("quail.png");
    }

    @Override
    public void render() {
        update();
        draw();
    }

    @Override
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }

    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    public void draw() {
        ScreenUtils.clear(Color.SKY);
        batch.begin();
        {
            float x = Gdx.graphics.getWidth() / 2f - texture.getWidth() / 2f;
            float y = Gdx.graphics.getHeight() / 2f - texture.getHeight() / 2f;
            batch.draw(texture, x, y);
        }
        batch.end();
    }


}