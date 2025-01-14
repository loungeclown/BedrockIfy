package me.juancarloscp52.bedrockify.client.features.heldItemTooltips.tooltip;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.StringHelper;

public class PotionTooltip extends Tooltip {

    int ticks;

    public PotionTooltip (StatusEffectInstance effect){
        this.translationKey = effect.getTranslationKey();
        this.primaryValue = effect.getAmplifier();
        this.ticks = effect.getDuration();
    }

    @Override
    public TranslatableText getTooltipText() {
        TranslatableText tooltip = new TranslatableText(translationKey);
        if(primaryValue>0)
            tooltip.append(" ").append(new TranslatableText("potion.potency." + primaryValue));
        if(ticks>=20)
            tooltip.append(" (" + StringHelper.formatTicks(ticks) + ")");
        return tooltip;
    }
}
