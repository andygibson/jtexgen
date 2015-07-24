/*
 * Texture Generator Library by Andy Gibson
 *
 * This software is distributed under the terms of the FSF Lesser
 * Gnu Public License. It is provided as-is, without any express
 * or implied warranty, or guarantee of any kind.
 *
 */
package org.fluttercode.texgen.textures.composite;

import org.fluttercode.texgen.textures.color.SolidTexture;
import org.fluttercode.texgen.textures.AbstractTexture;
import org.fluttercode.texgen.textures.Texture;
import org.fluttercode.texgen.utils.RGBAColor;

/**
 * Takes two textures, a background and an overlay and merges them based on the
 * alpha value of the overlay<br/>
 * <pre>
 * alpha = overlay.alpha
 * Result = (background * (1-alpha)) + (overlay * alpha);
 * <pre>
 * 
 * @author Andy Gibson
 */
public class MergedTexture extends AbstractTexture {

    
    private final Texture overlay;
    private final Texture background;
    
    
    public MergedTexture(RGBAColor color,Texture texture) {        
        this(new SolidTexture(color),texture);
        
    }
    
    public MergedTexture(Texture backGround,Texture texture) {
    	
        this.background = backGround;
        overlay = texture;
    }

    public final void getColor(double u, double v,RGBAColor value) {
        if (overlay == null) {
            if (background == null) {
                value.setColor(0,0,0,1);
            }            
            background.getColor(u, v,value);            
        }
        
        //overlay != null
        if (background == null) {
            overlay.getColor(u, v,value);
        }
        
        //calculate color in texture and merge with background
        background.getColor(u, v,value);
        
        
        value.merge(overlay.getColor(u, v));
    }

    public Texture getOverlay() {
        return overlay;
    }

    public Texture getBackground() {
        return background;
    }
}
