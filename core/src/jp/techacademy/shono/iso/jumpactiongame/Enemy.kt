package jp.techacademy.shono.iso.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Enemy(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    // 高度限界
    var LIMIT_BOTTOM = 0f
    var LIMIT_TOP = 0f
    companion object {
        // 横幅、高さ
        val ENEMY_WIDTH = 1.0f
        val ENEMY_HEIGHT = 1.0f

        // 速度
        val ENEMY_VELOCITY = 2.0f
    }

    init {
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT)
        velocity.y = ENEMY_VELOCITY
    }

    // 座標を更新する
    fun update(deltaTime: Float) {
        y += velocity.y * deltaTime

        if (y < LIMIT_BOTTOM - ENEMY_HEIGHT / 2) {
            velocity.y = -velocity.y
            y = LIMIT_BOTTOM - ENEMY_HEIGHT /2
        }
        if (y > LIMIT_TOP + ENEMY_HEIGHT / 2) {
            velocity.y = -velocity.y
            y = LIMIT_TOP + ENEMY_HEIGHT / 2
        }

    }

    fun setDefaultY(y:Float) {
        LIMIT_BOTTOM = y - 2f
        LIMIT_TOP = y + 2f
    }
}