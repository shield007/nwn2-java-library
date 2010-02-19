parser  grammar NWN2GUIAntlrParser;

options {      
  tokenVocab=NWN2GUILexer;  
  output=AST;
}

tokens {
  TAG_CONTENTS;  
  ATTRIBUTE;
  ELEMENT;
  ATTRIBUTES;
}

@header 
{ package org.stanwood.nwn2.gui.parser.antlr;
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
}


document  : prolog tagContents* ;

element
    : startTag tagContents* endTag
    -> ^(TAG_CONTENTS startTag tagContents* )          
    | emptyElement
    -> ^(TAG_CONTENTS emptyElement ) 
    ;

tagContents : ( element | PCDATA! | comment );
  
attribute  : GENERIC_ID ATTR_EQ GENERIC_ID 
    -> ^(ATTRIBUTE GENERIC_ID GENERIC_ID );

prolog : PROLOG_START! PROLOG PROLOG_END! ;

comment : COMMENT_START! COMMENT! COMMENT_END! ;

elementName : GENERIC_ID;

startTag  : TAG_START_OPEN elementName (attribute)* TAG_CLOSE
  -> elementName ^(ATTRIBUTES   (attribute)* );

endTag :  TAG_END_OPEN! GENERIC_ID! TAG_CLOSE! ;

emptyElement : TAG_START_OPEN elementName (attribute)* TAG_EMPTY_CLOSE 
  -> elementName ^(ATTRIBUTES   (attribute)* );

