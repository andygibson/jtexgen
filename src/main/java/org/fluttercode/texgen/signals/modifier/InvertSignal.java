/*
 * Texture Generator Library by Andy Gibson
 *
 * This software is distributed under the terms of the FSF Lesser
 * Gnu Public License. It is provided as-is, without any express
 * or implied warranty, or guarantee of any kind.
 *
 */
package org.fluttercode.texgen.signals.modifier;

import org.fluttercode.texgen.textures.ChainedChannelSignal;
import org.fluttercode.texgen.textures.ChannelSignal;

/**
 * Takes an input signal and inverts it using (1-input), does not handle out of
 * range issues and assumes a 0..1 range.
 * 
 * @author Andy Gibson
 */
public class InvertSignal extends ChainedChannelSignal {

	public InvertSignal(ChannelSignal source) {
		super(source);
	}
	public double getValue(double u, double v) {
		return 1 - calculateValue(u, v, getSource());
	}

}
