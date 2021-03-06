package io.endertech.multiblock.texture;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ConnectedTextureIcon implements IIcon
{
    public static final String[] ICON_TYPES = {"central", "top", "bottom", "left", "right", "anticorner.tl", "anticorner.tr", "anticorner.br", "anticorner.bl"};
    public static final int CENTRAL = 0;
    public static final int TOP = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;
    public static final int ANTICORNER_TOP_LEFT = 5;
    public static final int ANTICORNER_TOP_RIGHT = 6;
    public static final int ANTICORNER_BOTTOM_RIGHT = 7;
    public static final int ANTICORNER_BOTTOM_LEFT = 8;
    public IIcon[] icons;
    private int renderIndex = 0;

    public ConnectedTextureIcon(IIconRegister icon, String textureBase)
    {
        icons = new IIcon[ICON_TYPES.length];

        for (int iconType = 0; iconType < ICON_TYPES.length; iconType++)
        {
            this.icons[iconType] = icon.registerIcon(textureBase + "." + ICON_TYPES[iconType]);
        }
    }

    public IIcon getCurrentRenderIcon()
    {
        return this.icons[this.renderIndex];
    }

    public void setCurrentRenderIcon(int renderIndex)
    {
        this.renderIndex = renderIndex;
    }

    @Override
    public int getIconWidth()
    {
        return this.getCurrentRenderIcon().getIconWidth();
    }

    @Override
    public int getIconHeight()
    {
        return this.getCurrentRenderIcon().getIconHeight();
    }

    @Override
    public float getMinU()
    {
        return this.getCurrentRenderIcon().getMinU();
    }

    @Override
    public float getMaxU()
    {
        return this.getCurrentRenderIcon().getMaxU();
    }

    @Override
    public float getInterpolatedU(double d)
    {
        return this.getCurrentRenderIcon().getInterpolatedU(d);
    }

    @Override
    public float getMinV()
    {
        return this.getCurrentRenderIcon().getMinV();
    }

    @Override
    public float getMaxV()
    {
        return this.getCurrentRenderIcon().getMaxV();
    }

    @Override
    public float getInterpolatedV(double d)
    {
        return this.getCurrentRenderIcon().getInterpolatedV(d);
    }

    @Override
    public String getIconName()
    {
        return this.getCurrentRenderIcon().getIconName();
    }
}
