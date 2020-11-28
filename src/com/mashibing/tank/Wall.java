package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/28 11:27
 */

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/28 11:27
 * @Param
 * @return
 **/
public class Wall {
    private static final int xWall = 0;
    private static final int yWall = 0;

    // 为什么不能用
    /*private static final Rectangle rect1 = new Rectangle(0, 0, TankFrame.GAME_WIDTH, TankFrame.GAME_HEIGHT);

    public static void wallCollideWith(Tank tank) {
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if(!rect1.intersects(rect2)) return;
        if(tank.getDir() == Dir.DOWN) tank.setDir(Dir.UP);
        if(tank.getDir() == Dir.UP) tank.setDir(Dir.DOWN);
        if(tank.getDir() == Dir.LEFT) tank.setDir(Dir.RIGHT);
        if(tank.getDir() == Dir.RIGHT) tank.setDir(Dir.LEFT);
    }*/

    public static void wallCollideWith(Tank tank){
        int tankX = tank.getX();
        int tankY = tank.getY();
        int width = tank.WIDTH;
        int height = tank.HEIGHT;

//        if( (0 <tankX - width && tankX + width < TankFrame.GAME_WIDTH) &&(
//                0 < tankY - height && tankY + height <TankFrame.GAME_HEIGHT)) return;

        if(!(tankY + height <TankFrame.GAME_HEIGHT) && tank.getDir() == Dir.DOWN) tank.setDir(Dir.UP);
        if(!(0 < tankY - height) && tank.getDir() == Dir.UP) tank.setDir(Dir.DOWN);
        if(!(tankX + width < TankFrame.GAME_WIDTH) && tank.getDir() == Dir.RIGHT) tank.setDir(Dir.LEFT);
        if(!(0 <tankX - width) && tank.getDir() == Dir.LEFT) tank.setDir(Dir.RIGHT);


    }

}
