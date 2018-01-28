package com.github.skjolber.jackson.jsh;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.FixedSpaceIndenter;

public class SyntaxHighlighterArrayIndenter extends FixedSpaceIndenter {

	private SyntaxHighlighter highligheter;
	
	private String postColor;

	public void setHighligheter(SyntaxHighlighter highligheter) {
		this.highligheter = highligheter;
	}
	
	@Override
	public void writeIndentation(JsonGenerator jg, int level) throws IOException {
		String color;
		if(highligheter != null) {
			color = highligheter.forWhitespace();
			if(color == null) {
				color = SyntaxHighlighter.ANSI_RESET;
			}
		} else {
			color = SyntaxHighlighter.ANSI_RESET;
		}
		jg.writeRaw(color);
		super.writeIndentation(jg, level);
		
		if(postColor != null) {
			jg.writeRaw(postColor);
		}
	}
	
	public void setPostColor(String postColor) {
		this.postColor = postColor;
	}

	public void clearPostColor() {
		this.postColor = null;
	}
}
