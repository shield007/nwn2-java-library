lexer grammar NWN2GUILexer;

@header { package org.stanwood.nwn2.gui.parser.antlr; }

@members {
    boolean tagMode = false;
    boolean prologMode = false;
    boolean commentMode = false;
}

COMMENT_START : '<!' { commentMode = true; } ;
COMMENT_END : { commentMode }?=> '>' { commentMode = false; } ;
PROLOG_START : '<?' { prologMode = true; } ;
PROLOG_END : { prologMode }?=> '>' { prologMode = false; } ;
TAG_START_OPEN : { !prologMode && !commentMode }?=> '<' { tagMode = true; } ;
TAG_END_OPEN : { !prologMode && !commentMode }?=> '</' { tagMode = true; } ;
TAG_CLOSE : { tagMode }?=> '>' { tagMode = false; } ;
TAG_EMPTY_CLOSE : { tagMode }?=> '/>' { tagMode = false; } ;

COMMENT : { commentMode }?=> (~'>')+ ;

ATTR_EQ : { tagMode }?=> '=' ;
    
GENERIC_ID
    : { tagMode }?=>
      (NAMECHAR | '\\' |'"' | '\'' | ',' | '('| ')' )* ~( '>' | '/' | '=' | ' ' | '\r'|'\t'|'\u000C'|'\n' )
    ;

PROLOG : { prologMode }?=> (~'>')+ ;  

PCDATA : { !prologMode && !tagMode && !commentMode }?=> (~'<')+ ;

fragment NAMECHAR
    : LETTER | DIGIT | '.' | '-' | '_' | ':' 
    ;

fragment DIGIT
    :    '0'..'9'
    ;

fragment LETTER
    : 'a'..'z'
    | 'A'..'Z'
    ;   

WS  :  { tagMode }?=>
       (' ' | '\r'|'\t'|'\u000C'|'\n') { skip(); }
    ;
