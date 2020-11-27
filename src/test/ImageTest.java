package test;/**
 * Created by Administrator on 2020/11/27 20:43
 */

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 20:43
 * @Param
 * @return
 **/
public class ImageTest {

    @Test
    void test(){
        try{
//        BufferedImage image = ImageIO.read(new File("C:/Users/Administrator/Desktop/tank.jpg"));
//        assertNotNull(image); // 判断对象是否为空

            BufferedImage images =ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tank.jpg"));
            // this.getClass()
            assertNotNull(images);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
