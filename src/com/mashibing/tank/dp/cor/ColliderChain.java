package com.mashibing.tank.dp.cor;/**
 * Created by Administrator on 2020/12/3 23:04
 */

import com.mashibing.tank.PropertyMgr;
import com.mashibing.tank.dp.mediator.GameObject;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/3 23:04
 * @Param
 * @return
 **/
public class ColliderChain implements Collider{
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {

        List<String> list = PropertyMgr.getList("colliders");
        for (int i = 0; i < list.size(); i++) {
            try {
                Object collider = Class.forName(list.get(i)).getDeclaredConstructor().newInstance();
                if(collider instanceof BulletTankCollider) {
                    add((BulletTankCollider) collider);
                }
                 else if (collider instanceof TankTankCollider) {
                    add((TankTankCollider) collider);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(!colliders.get(i).collide(o1,o2)){
                return false;
            }
        }
        return true;
    }
}
