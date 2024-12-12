package net.go.fishing.mixin;


import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.InventoryOwner;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static net.go.fishing.util.common.createDummyStack;

@Mixin(InventoryOwner.class)
public interface AdjustStackSizeOnPickupMixin {
    @Redirect(method="pickUpItem", at= @At(value = "INVOKE", target = "Lnet/minecraft/inventory/SimpleInventory;canInsert(Lnet/minecraft/item/ItemStack;)Z"))
    private static boolean redirectCanInsert(SimpleInventory inventory, ItemStack stack, @Local(argsOnly = true) MobEntity entity){
        return canInsertDummy( entity, inventory, createDummyStack(stack, entity) );
    }

    @Redirect(method="pickUpItem", at= @At(value = "INVOKE", target = "Lnet/minecraft/inventory/SimpleInventory;addStack(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;"))
    private static ItemStack checkStackSizes_IfDifferent_Recurse(SimpleInventory inventory, ItemStack stack, @Local(argsOnly = true) MobEntity entity){
        ItemStack dummyStack= createDummyStack(stack, entity);
        int dummyMax= dummyStack.getMaxCount();
        int stackMax= stack.getMaxCount();

        return dummyMax==stackMax ? inventory.addStack(stack) : recurse(entity, inventory,stack, dummyStack, 0);
    }

    @Unique
    private static ItemStack recurse(MobEntity entity, SimpleInventory inventory, ItemStack sourceStack, ItemStack dummyStack, int recursionCount){

        int countToAdd= Math.min( sourceStack.getCount(), dummyStack.getMaxCount() );

        ItemStack stackToAdd   = sourceStack.copyWithCount(countToAdd);
        stackToAdd.setHolder(entity);
        stackToAdd.getMaxCount();


        ItemStack stackReturned= inventory.addStack(stackToAdd);


        sourceStack.decrement(countToAdd - stackReturned.getCount());


        boolean canInsert  = canInsertDummy(entity, inventory, dummyStack);


        return ( !canInsert || sourceStack.isEmpty() || recursionCount>100 ) ? sourceStack : recurse(entity, inventory, sourceStack, dummyStack, recursionCount+1);
    }

    @Unique
    private static boolean canInsertDummy(MobEntity entity, SimpleInventory inventory, ItemStack dummyStack){
        boolean toReturn= false;
        for( ItemStack stack: inventory.heldStacks){
            stack.setHolder(entity);
            if ( stack.isEmpty()) { toReturn=true; break;}
            if ( ItemStack.areItemsAndComponentsEqual(stack, dummyStack) && stack.getCount()< stack.getMaxCount() ) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }


}
