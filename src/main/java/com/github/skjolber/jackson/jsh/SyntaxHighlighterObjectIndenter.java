package com.github.skjolber.jackson.jsh;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultIndenter;

public class SyntaxHighlighterObjectIndenter extends DefaultIndenter {
	
	private static final long serialVersionUID = 1L;
	
	protected SyntaxHighlighter highligheter;
	protected String valueColor;

	public SyntaxHighlighterObjectIndenter() {
		super();
	}

	public SyntaxHighlighterObjectIndenter(SyntaxHighlighter highligheter) {
		this.highligheter = highligheter;
	}
	
	@Override
	public void writeIndentation(JsonGenerator jg, int level) throws IOException {
		String color = highligheter.forWhitespace();
		jg.writeRaw(color);
		super.writeIndentation(jg, level);
		
		if(valueColor != null) {
			jg.writeRaw(valueColor);
		}
	}
	
	/**
	 * Set the color which is set after the indentation.
	 * 
	 * @param color color to set
	 */
	
	public void setValueColor(String color) {
		this.valueColor = color;
	}

	public void clearValueColor() {
		this.valueColor = null;
	}
	
}
