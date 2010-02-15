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

@header { package org.stanwood.nwn2.gui.parser.antlr;  }


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

