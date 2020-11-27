package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 21:10
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 21:10
 * @Param
 * @return
 **/
public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR,tankD;
    public static BufferedImage bulletL,bulletU,bulletR,bulletD;

    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
