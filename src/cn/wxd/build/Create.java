package cn.wxd.build;

import cn.wxd.utils.FontBase;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;


public class Create implements Runnable{
    private PlayerInteractEvent event;
    private String sentence;
    private Location location ;
    private boolean flag=true;

    Create(PlayerInteractEvent event, String setence){
        this.event = event;
        this.sentence = setence;
        this.location = event.getClickedBlock().getLocation();
    }


    @Override
    public void run() {

        /*clearSetence(location,sentence);
        if (Math.abs(location.getX()-event.getClickedBlock().getLocation().getX())>10){
            location=event.getClickedBlock().getLocation();
        }
        createSetence(location.add(1,0,0),sentence);
        flag=false;*/
    }


    public void createSetence(Location location,String setence){
        int length = 0;
        for (int i = 0; i < setence.length(); i++) {
            FontBase fb = FontBase.findWord(setence.substring(i,i+1));
            createWord(location.add(fb.getWidth(),0,0),fb);
            length += fb.getWidth();
        }
        location.add(-length,0,0);
    }


    public void clearSetence(Location location,String setence){
        int length = 0;
        for (int i = 0; i < setence.length(); i++) {
            FontBase fb = FontBase.findWord(setence.substring(i,i+1));
            clearWrod(location.add(fb.getWidth(),0,0),fb);
            length += fb.getWidth();
        }
        location.add(-length,0,0);
    }




    public void createWord(Location location,FontBase fontBase){
        char[] fontBinary = fontBase.getBinaryCode().toCharArray();
        for (int i = 0; i < fontBase.getHeight(); i++) {
            location.add(0,1,0);
            for (int j = 0; j< fontBase.getWidth(); j++) {
                if (fontBinary[i*fontBase.getWidth()+j]=='1'){
                        location.getBlock().setType(Material.DIAMOND_BLOCK);
                }
                location.add(1,0,0);
            }
            location.add(-fontBase.getWidth(),0,0);
        }
        location.add(0,-fontBase.getHeight(),0);
    }

    public void clearWrod(Location location,FontBase fontBase){
        char[] fontBinary = fontBase.getBinaryCode().toCharArray();
        for (int i = 0; i < fontBase.getHeight(); i++) {
            location.add(0,1,0);
            for (int j = 0; j< fontBase.getWidth(); j++) {
                if (fontBinary[i*fontBase.getWidth()+j]=='1'){
                    location.getBlock().setType(Material.AIR);
                }
                location.add(1,0,0);
            }
            location.add(-fontBase.getWidth(),0,0);
        }
        location.add(0,-fontBase.getHeight(),0);
    }


}
