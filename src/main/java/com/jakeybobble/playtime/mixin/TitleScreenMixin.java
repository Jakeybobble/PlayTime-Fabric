package com.jakeybobble.playtime.mixin;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.jakeybobble.playtime.PlayTime;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Mixin (TitleScreen.class)
public class TitleScreenMixin extends Screen {

	protected TitleScreenMixin(Text title) {
		super(title);
	}
	
	@Inject(at = @At("TAIL"), method = "render")
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo info) {
		
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
		
		LocalDateTime current_time = LocalDateTime.now();
		Duration diff = Duration.between(PlayTime.date_started,current_time);
		
		String draw = DurationFormatUtils.formatDuration(diff.toMillis(), "H:mm:ss", true);
		drawStringWithShadow(matrices, this.textRenderer, draw, 8, 8, 16777215);
	}

}
