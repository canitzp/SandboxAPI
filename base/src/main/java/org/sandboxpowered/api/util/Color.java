package org.sandboxpowered.api.util;

import java.util.Objects;

//Our own class for representing an RGB or ARGB value, since java.awt.Color shouldn't used in a Minecraft environment
public class Color {
	private int red;
	private int green;
	private int blue;
	private int alpha;

	public Color(int red, int green, int blue) {
		this.red = Math.max(0, Math.min(red, 255));
		this.green = Math.max(0, Math.min(green, 255));
		this.blue = Math.max(0, Math.min(blue, 255));
		this.alpha = 255;
	}

	public Color(float red, float green, float blue) {
		this.red = Math.max(0, (int) Math.min(red * 255f, 255));
		this.green = Math.max(0, (int) Math.min(green * 255f, 255));
		this.blue = Math.max(0, (int) Math.min(blue * 255f, 255));
	}

	public Color(int red, int green, int blue, int alpha) {
		this(red, green, blue);
		this.alpha = Math.max(0, Math.min(alpha, 255));
	}

	public Color(float red, float green, float blue, float alpha) {
		this(red, green, blue);
		this.alpha = Math.max(0, (int) Math.min(alpha * 255f, 255));
	}

	public static Color withAlpha(Color previous, int alpha) {
		return new Color(previous.red, previous.green, previous.blue, alpha);
	}

	public static Color withAlpha(Color previous, float alpha) {
		return new Color(previous.red, previous.green, previous.blue, Math.max(0, (int) Math.min(alpha * 255f, 255)));
	}

	public static Color fromHsv(float hue, float saturation, float value) {
		if (hue < 0 || hue > 1 || saturation < 0 || saturation > 1 || value < 0 || value > 1) {
			throw new RuntimeException("Hue, saturation, and value must each be floats between 0 and 1!");
		}
		float chroma = value * saturation;
		int tintIndex = (int) (hue * 6f);
		float alternate = chroma * (1 - Math.abs(tintIndex % 2 - 1));
		float modifier = chroma - value;
		float red = 0f;
		float green = 0f;
		float blue = 0f;
		switch (tintIndex) {
		case 1:
			red = alternate;
			green = chroma;
			break;
		case 2:
			green = chroma;
			blue = alternate;
			break;
		case 3:
			green = alternate;
			blue = chroma;
			break;
		case 4:
			red = alternate;
			blue = chroma;
			break;
		case 5:
			red = chroma;
			blue = alternate;
			break;
		default:
			red = chroma;
			green = alternate;
			break;
		}
		return new Color(red + modifier, green + modifier, blue + modifier);
	}

	public int toRgb() {
		return red << 16 | green << 8 | blue;
	}

	public int toArgb() {
		return alpha << 24 | red << 16 | green << 8 | blue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Color color = (Color) o;
		return red == color.red &&
				green == color.green &&
				blue == color.blue &&
				alpha == color.alpha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(red, green, blue, alpha);
	}

	@Override
	public String toString() {
		return "Color{" +
				"red=" + red +
				", green=" + green +
				", blue=" + blue +
				", alpha=" + alpha +
				'}';
	}
}
