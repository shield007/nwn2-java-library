/*
 *  Copyright (C) 2008  John-Paul.Stanford <dev@stanwood.org.uk>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.stanwood.nwn2.gui.parser.antlr;


import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.junit.Test;


public class NWN2GUIAntlrParserTest {

	@Test
	public void testLexer() throws Exception {
		CharStream input = new ANTLRInputStream(NWN2GUIAntlrParserTest.class.getResourceAsStream("ns5_store.XML"));
        NWN2GUILexer lexer = new NWN2GUILexer(input);
        
        Token token;
        while ((token = lexer.nextToken())!=Token.EOF_TOKEN) {
        	
            System.out.println("Token: " + getTokenName(token.getType()) + " - "+token.getText());
        }
	}
	
	@Test
	public void testParser() throws Exception {
		CharStream input = new ANTLRInputStream(NWN2GUIAntlrParserTest.class.getResourceAsStream("ns5_store.XML"));
		NWN2GUILexer lexer = new NWN2GUILexer(input);
	    CommonTokenStream tokens = new  CommonTokenStream(lexer);	    
	    NWN2GUIAntlrParser parser = new NWN2GUIAntlrParser(tokens);
        parser.document();

	}
	
	public String getTokenName(int id) {
		switch (id) {			
//			case NWN2GUILexer.ATTR_KEY:
//				return "ATTR_KEY";
			case NWN2GUILexer.PROLOG_END:
				return "PROLOG_END";
			case NWN2GUILexer.TAG_CLOSE:
				return "TAG_CLOSE";
			case NWN2GUILexer.LETTER:
				return "LETTER";
			case NWN2GUILexer.PROLOG_START:
				return "PROLOG_START";
			case NWN2GUILexer.TAG_END_OPEN:
				return "TAG_END_OPEN";
			case NWN2GUILexer.EOF:
				return "EOF";
			case NWN2GUILexer.COMMENT_START:
				return "COMMENT_START";
			case NWN2GUILexer.NAMECHAR:
				return "NAMECHAR";
			case NWN2GUILexer.PCDATA:
				return "PCDATA";
			case NWN2GUILexer.TAG_EMPTY_CLOSE:
				return "TAG_EMPTY_CLOSE";
			case NWN2GUILexer.WS:
				return "WS";
			case NWN2GUILexer.COMMENT_END:
				return "COMMENT_END";
			case NWN2GUILexer.GENERIC_ID:
				return "GENERIC_ID";
			case NWN2GUILexer.ATTR_EQ:
				return "ATTR_EQ";
			case NWN2GUILexer.PROLOG:
				return "PROLOG";
//			case NWN2GUILexer.ATTR_VALUE:
//				return "ATTR_VALUE";
			case NWN2GUILexer.DIGIT:
				return "DIGIT";
			case NWN2GUILexer.COMMENT:
				return "COMMENT";
			case NWN2GUILexer.TAG_START_OPEN:
				return "TAG_START_OPEN";
			default:
				return "Unknown ("+id+")";
		}
	}
	
}
