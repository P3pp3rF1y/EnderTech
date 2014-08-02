package io.endertech.multiblock.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import io.endertech.block.ETBlocks;
import io.endertech.multiblock.MultiblockControllerBase;
import io.endertech.multiblock.MultiblockValidationException;
import io.endertech.multiblock.controller.ControllerTank;
import io.endertech.reference.Strings;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import java.util.Set;

public class TileTankValve extends TileTankPart implements IFluidHandler
{
    public static final int ENERGY_PER_UNIT = 1;

    public static void init()
    {
        GameRegistry.registerTileEntity(TileTankValve.class, "tile." + Strings.Blocks.TANK_VALVE_NAME);
    }

    @Override
    public void isGoodForFrame() throws MultiblockValidationException
    {

    }

    @Override
    public void isGoodForSides() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Tank valves cannot be used for tank sides (only the frame).");
    }

    @Override
    public void isGoodForTop() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Tank valves cannot be used for tank top (only the frame).");
    }

    @Override
    public void isGoodForBottom() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Tank valves cannot be used for tank bottom (only the frame).");
    }

    @Override
    public void isGoodForInterior() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Tank valves cannot be used for tank interior.");
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
    {
        if (!canInteractFromDirection(from) || !isConnected()) { return 0; }

        ControllerTank controller = this.getTankController();
        int energyRequired = resource.amount * ENERGY_PER_UNIT;
        int maxEnergyLimiter = controller.extractEnergy(from, energyRequired, true);
        int energyLimitedFill = (int) Math.floor((maxEnergyLimiter * 1.0) / ENERGY_PER_UNIT);

        FluidStack resourceCopy = resource.copy();
        resourceCopy.amount = energyLimitedFill;
        int fillAmount = controller.tank.fill(resourceCopy, doFill);
        if (fillAmount > 0) controller.extractEnergy(from, fillAmount * ENERGY_PER_UNIT, false);

        return fillAmount;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
    {
        if (!canInteractFromDirection(from) || !this.canDrain(from, null)) { return null; }

        return this.drain(from, resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        if (!canInteractFromDirection(from) || !this.canDrain(from, null)) { return null; }

        ControllerTank controller = this.getTankController();
        int energyRequired = maxDrain * ENERGY_PER_UNIT;
        int maxEnergyLimiter = controller.extractEnergy(from, energyRequired, true);
        int energyLimitedDrain = (int) Math.floor((maxEnergyLimiter * 1.0) / ENERGY_PER_UNIT);

        FluidStack drained = controller.tank.drain(energyLimitedDrain, doDrain);
        if (drained.amount > 0) controller.extractEnergy(from, drained.amount * ENERGY_PER_UNIT, false);

        return drained;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid)
    {
        return canInteractFromDirection(from);
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid)
    {
        return canInteractFromDirection(from);
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from)
    {
        if (!canInteractFromDirection(from)) { return null; }
        return new FluidTankInfo[] {this.getTankController().tank.getInfo()};
    }

    @Override
    public void onMachineAssembled(MultiblockControllerBase controllerBase)
    {
        super.onMachineAssembled(controllerBase);

        Set<ForgeDirection> outs = this.getOutwardsDir();
        for (ForgeDirection out : outs)
            worldObj.notifyBlockOfNeighborChange(xCoord + out.offsetX, yCoord + out.offsetY, zCoord + out.offsetZ, ETBlocks.blockTankPart);
    }

    @Override
    public void onMachineBroken()
    {
        super.onMachineBroken();

        Set<ForgeDirection> outs = this.getOutwardsDir();
        for (ForgeDirection out : outs)
            worldObj.notifyBlockOfNeighborChange(xCoord + out.offsetX, yCoord + out.offsetY, zCoord + out.offsetZ, ETBlocks.blockTankPart);
    }
}